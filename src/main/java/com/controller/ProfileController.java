package com.controller;

import com.model.User;
import com.model.WorkExperience;
import com.service.UserService;
import com.service.WorkExperienceService;
import java.io.IOException;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Profile Controller.
 * Organizes and maps everything for the profile views.
 * 
 * @author David
 */
@Controller
@RequestMapping(value="/profile")
public class ProfileController {
    @Autowired
    UserService userService;
    @Autowired
    WorkExperienceService workExpService;
    
    /**
     * Mapping for the view of a person's profile.
     * 
     * Check if the user is logged in. If not return to the login page. If a user is found
     * show it's profile page. If the user is not found send client to de /index page.
     * 
     * @param session - check if there is a user object in the session (login)
     * @param id - the id of the selected User
     * @return profileView or profileViewNot - first for positive user selection second otherwise 
     * @throws java.io.IOException 
     */
    @RequestMapping(value = "/user/{id}")
    public ModelAndView tabbedProfile(HttpSession session, @PathVariable int id) throws IOException{
        //get the user out of the session
        User loggedInUser = (User)session.getAttribute("loggedInUser");
        
        //if a user object is found, redirect to the intended page
        if(loggedInUser != null){
            User user = userService.getUser(id);
        
            //check if the user exists.
            if(user != null){
                ModelAndView profileView = new ModelAndView("/profile/profile");

                profileView.addObject("user", userService.getUser(id));

                return profileView;
            }else{
                ModelAndView profileViewNot = new ModelAndView("/index/index");
                profileViewNot.addObject("error", "Deze gebruiker bestaat niet!");
                return profileViewNot;
            }
        }
        //else return to the login page if no user object is found in the session
        else{
            ModelAndView loginView = new ModelAndView("/login/login");
        
            loginView.addObject("user", new User());
            return loginView;
        }
    }
    
    @RequestMapping(value="/add/workexperience", method = RequestMethod.GET)
    public ModelAndView addWorkExperience(){
        ModelAndView addWorkExp = new ModelAndView("/profile/addWorkExperience");
        
        addWorkExp.addObject("workexperience", new WorkExperience());
        
        return addWorkExp;
    }
    
    @RequestMapping(value="/add/workexperience", method = RequestMethod.POST)
    public ModelAndView addWorkExperience(@ModelAttribute WorkExperience workexperience, HttpSession session){
        ModelAndView profileView = new ModelAndView("/login/login");
        //User loggedInUser = (User)session.getAttribute("loggedInUser");
        
        //workExpService.addWorkExperience(workexperience);
        
        profileView.addObject("user", new User());
        
        return profileView;
    }
}