package com.controller;

import com.model.User;
import com.model.WorkExperience;
import com.service.UserService;
import com.service.WorkExperienceService;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Profile Controller. Organizes and maps everything for the profile views.
 *
 * @author David
 */
@Controller
@RequestMapping(value = "/profile")
public class ProfileController {

    @Autowired
    UserService userService;
    @Autowired
    WorkExperienceService workExpService;

    //Dit zorgt ervoor dat de String omgezet wordt in een Date object
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yy");
        dateFormat.setLenient(false);
        webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    /**
     * Mapping for the view of a person's profile.
     *
     * Check if the user is logged in. If not return to the login page. If a
     * user is found show it's profile page. If the user is not found send
     * client to de /index page.
     *
     * @param session - check if there is a user object in the session (login)
     * @param id - the id of the selected User
     * @return profileView or profileViewNot - first for positive user selection
     * second otherwise
     * @throws java.io.IOException
     */
    @RequestMapping(value = "/user/{id}")
    public ModelAndView tabbedProfile(HttpSession session, @PathVariable int id) throws IOException {
        //get the user out of the session
        User loggedInUser = (User) session.getAttribute("loggedInUser");

        //if a user object is found, redirect to the intended page
        if (loggedInUser != null) {
            User user = userService.getUser(id);

            //check if the user exists.
            if (user != null) {
                ModelAndView profileView = new ModelAndView("/profile/profile");

                profileView.addObject("user", userService.getUser(id));
                profileView.addObject("workExp", workExpService.getActiveWorkExperience(id));
                profileView.addObject("workExpSize", workExpService.getActiveWorkExperience(id).size());

                return profileView;
            } else {
                ModelAndView profileViewNot = new ModelAndView("/index/index");
                profileViewNot.addObject("error", "Deze gebruiker bestaat niet!");
                return profileViewNot;
            }
        } //else return to the login page if no user object is found in the session
        else {
            ModelAndView loginView = new ModelAndView("/login/login");

            loginView.addObject("user", new User());
            return loginView;
        }
    }

    @RequestMapping(value = "/add/workexperience", method = RequestMethod.GET)
    public ModelAndView addWorkExperience(HttpSession session) {
        //get the user out of the session
        User loggedInUser = (User) session.getAttribute("loggedInUser");

        //if a user object is found, redirect to the intended page
        if (loggedInUser != null) {
            ModelAndView addWorkExp = new ModelAndView("/profile/addWorkExperience");

            addWorkExp.addObject("workexperience", new WorkExperience());

            return addWorkExp;
        } else {
            ModelAndView loginView = new ModelAndView("/login/login");

            loginView.addObject("user", new User());
            return loginView;
        }
    }

    @RequestMapping(value = "/add/workexperience", method = RequestMethod.POST)
    public ModelAndView addWorkExperience(@ModelAttribute("workexperience")
            @Valid WorkExperience workexperience, HttpSession session, BindingResult result) {
        //get the user out of the session
        User loggedInUser = (User) session.getAttribute("loggedInUser");

        ModelAndView profileView = new ModelAndView("/profile/listworkexperience");
//        if(result.hasErrors()){
//            profileView = new ModelAndView("/profile/addWorkExperience");
//        }else{
        workExpService.addWorkExperience(workexperience, session);
        profileView.addObject("message", "werkervaring is succesvol toegevoegd");
        profileView.addObject("workExpList", workExpService.getAllWorkExperience(loggedInUser.getId()));
        profileView.addObject("workExpSize", workExpService.getAllWorkExperience(loggedInUser.getId()).size());
//        }
        return profileView;
    }

    @RequestMapping(value = "/list/workexperience", method = RequestMethod.GET)
    public ModelAndView listWorkExperience(HttpSession session) {
        //get the user out of the session
        User loggedInUser = (User) session.getAttribute("loggedInUser");

        //if a user object is found, redirect to the intended page
        if (loggedInUser != null) {

            int id = loggedInUser.getId();
            ModelAndView listWorkExp = new ModelAndView("/profile/listworkexperience");

            listWorkExp.addObject("workExpList", workExpService.getAllWorkExperience(id));
            listWorkExp.addObject("workExpSize", workExpService.getAllWorkExperience(id).size());

            return listWorkExp;
        } else {
            ModelAndView loginView = new ModelAndView("/login/login");

            loginView.addObject("user", new User());
            return loginView;
        }
    }

    @RequestMapping(value = "/edit/workexperience/{id}", method = RequestMethod.GET)
    public ModelAndView editWorkExperience(@PathVariable int id, HttpSession session) {
        //get the user out of the session
        User loggedInUser = (User) session.getAttribute("loggedInUser");

        //if a user object is found, redirect to the intended page
        if (loggedInUser != null) {
            ModelAndView addWorkExp = new ModelAndView("/profile/editWorkExperience");

            addWorkExp.addObject("workexperience", workExpService.getWorkExperience(id));

            return addWorkExp;
        } else {
            ModelAndView loginView = new ModelAndView("/login/login");

            loginView.addObject("user", new User());
            return loginView;
        }
    }
    
    @RequestMapping(value = "/edit/workexperience", method = RequestMethod.POST)
    public ModelAndView postEditWorkExperience(@ModelAttribute("workexperience") WorkExperience workExp,
            HttpSession session){
        //get the user out of the session
        User loggedInUser = (User) session.getAttribute("loggedInUser");
        ModelAndView listWorkExp = new ModelAndView("/profile/listworkexperience");
        
          workExpService.updateWorkExperience(workExp);
        
        listWorkExp.addObject("workExpList", workExpService.getAllWorkExperience(loggedInUser.getId()));
        listWorkExp.addObject("workExpSize", workExpService.getAllWorkExperience(loggedInUser.getId()).size());
        
        return listWorkExp;
        
    }

    @RequestMapping(value = "/workexperience/visibility/{id}", method = RequestMethod.GET)
    public ModelAndView deactivateWorkExperience(@PathVariable int id, HttpSession session) {
        User loggedInUser = (User) session.getAttribute("loggedInUser");
        if (loggedInUser != null) {
            ModelAndView workExpList = new ModelAndView("/profile/listworkexperience");

            workExpService.setActive(workExpService.getWorkExperience(id));

            int userId = loggedInUser.getId();

            workExpList.addObject("workExpList", workExpService.getAllWorkExperience(userId));
            workExpList.addObject("workExpSize", workExpService.getAllWorkExperience(userId).size());

            return workExpList;
        } else {
            ModelAndView loginView = new ModelAndView("/login/login");

            loginView.addObject("user", new User());

            return loginView;
        }
    }
}
