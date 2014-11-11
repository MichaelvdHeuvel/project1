package com.controller;

import com.model.User;
import com.service.UserService;
import java.io.IOException;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
 * Controller that organizes everything for the user.
 * All the user related mapping like editing and adding are stored in this controller.
 * @author David
 */
@Controller
@RequestMapping(value="/user")
public class UserController {
    @Autowired
    private UserService userService;
    
    /**
     * Get the user for editing a user object.
     * Check if a user is logged in by checking the session for a user object. If so,
     * a new edituser view is showed to the client and the fields are filled with the 
     * user's data.
     * 
     * @param session - the session to check if a user object exists in the session.
     * @param id - the id to get the right user.
     * @return editUserView or loginView. First for the update, second if no user is logged in.
     * @throws IOException 
     */
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editUser(HttpSession session, @PathVariable int id) throws IOException {
        User loggedInUser = (User)session.getAttribute("loggedInUser");
        if(loggedInUser != null){
            if(id == loggedInUser.getId()){
                ModelAndView editUserView = new ModelAndView("/user/edituser");

                User user = userService.getUser(id);
                editUserView.addObject("user", user);

                return editUserView;
            }else{
                ModelAndView homeView = new ModelAndView("redirect:/");
                
                return homeView;
            }
        }else{
            ModelAndView loginView = new ModelAndView("/login/login");
            loginView.addObject("user", new User());
            return loginView;
        }
    }
    
    /**
     * Post of a user edit.
     * Get the user and update it's details.
     * 
     * @param user - the user to update
     * @param result
     * @return ProfileUserList with a message to confirm that a user is updated.
     */
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView editUser(@ModelAttribute("user") @Valid User user, BindingResult result) {
        ModelAndView ProfileUserList = new ModelAndView("/profile/profile");
        
         if(result.hasErrors()){
            
            
            return new ModelAndView("user/edituser");
            
        } else {
        
        userService.updateUser(user);
        
        ProfileUserList.addObject("user", userService.getUser(user.getId()));
        String message = user.getFirstName() + " " + user.getLastName() + " is succesvol gewijzigd";
        ProfileUserList.addObject("message", message);
        
         }
        return ProfileUserList;
    }
    
    /**
     * Get the user password.
     * Update page for a password change. First check if the user is logged into the session.
     * If true show the update page, false show the login page. get the user and update it's 
     * password.
     * 
     * @param session - the session to check if a user object exists in the session.
     * @param id - the id to get the right user
     * @return - editUserView if the user is found in the session. loginView otherwise.
     * @throws IOException 
     */
    @RequestMapping(value = "/edit/password/{id}", method = RequestMethod.GET)
    public ModelAndView editUserPassword(HttpSession session, @PathVariable int id) throws IOException {
        User loggedInUser = (User)session.getAttribute("loggedInUser");
        if(loggedInUser != null){
            ModelAndView editUserView = new ModelAndView("/user/edituserpassword");
            
            User user = userService.getUser(id);
            editUserView.addObject("user", user);
            
            return editUserView;
        }else{
            ModelAndView loginView = new ModelAndView("/login/login");
            loginView.addObject("user", new User());
            return loginView;
        }
    }
    
    /**
     * Post of the password view.
     * Get the user's details and update the password column.
     * 
     * @param user - the user to update
     * @return - ProfileUserList with a message that the update was succesful
     */
    @RequestMapping(value = "/editpassword", method = RequestMethod.POST)
    public ModelAndView editUserPassword(@ModelAttribute("user") User user) {
        ModelAndView ProfileUserList = new ModelAndView("/index/index");
        userService.udpateUserPassword(user);
        
        String message = "Wachtwoord is succesvol gewijzigd";
        ProfileUserList.addObject("message", message);

        return ProfileUserList;
    }
}
