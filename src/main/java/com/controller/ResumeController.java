/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.model.User;
import com.service.UserService;
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
 *
 * @author Tim
 */
@Controller
@RequestMapping(value = "/resume")
public class ResumeController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editUser(HttpSession session, @PathVariable int id) throws IOException {
        User loggedInUser = (User) session.getAttribute("loggedInUser");
        if (loggedInUser != null) {
            if (id == loggedInUser.getId()) {
                ModelAndView editResumeView = new ModelAndView("/user/editresume");

                User user = userService.getUser(id);
                editResumeView.addObject("user", user);

                return editResumeView;
            } else {
                ModelAndView homeView = new ModelAndView("redirect:/");

                return homeView;
            }
        } else {
            ModelAndView loginView = new ModelAndView("/login/login");
            loginView.addObject("user", new User());
            return loginView;
        }
    }

    /**
     * Post of a user edit. Get the user and update it's details.
     *
     * @param user - the user to update
     * @return ProfileUserList with a message to confirm that a user is updated.
     */
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView editUser(@ModelAttribute("user") User user) {
        ModelAndView ProfileUserList = new ModelAndView("/profile/profile");
        userService.updateUser(user);

        ProfileUserList.addObject("user", userService.getUser(user.getId()));
        String message = user.getFirstName() + " " + user.getLastName() + " is succesvol gewijzigd";
        ProfileUserList.addObject("message", message);

        return ProfileUserList;
    }
}
