/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.model.User;
import com.model.UserRequest;
import com.service.UserRequestService;
import java.io.IOException;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author David
 */
@Controller
@RequestMapping(value = "/userrequest")
public class UserRequestController {

    @Autowired
    UserRequestService userRequestService;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addRequestPage(HttpSession session) throws IOException {
        User loggedInUser = (User) session.getAttribute("loggedInUser");

        if (loggedInUser != null) {
            if (loggedInUser.getRole() == 3) {
                ModelAndView homeView = new ModelAndView("redirect:/");

                return homeView;
            } else {
                ModelAndView requestAddView = new ModelAndView("/userrequest/add");

                requestAddView.addObject("userRequest", new UserRequest());

                return requestAddView;
            }
        } else {
            ModelAndView loginView = new ModelAndView("/login/login");

            loginView.addObject("user", new User());

            return loginView;
        }
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addRequest(@ModelAttribute("userRequest") @Valid UserRequest userRequest, BindingResult result, HttpSession session){
        ModelAndView requestAddView = new ModelAndView("/index/index");
        
        if (result.hasErrors()) {
            return new ModelAndView("/userrequest/add");
            
        } else {
            userRequestService.addUserRequest(userRequest, session);
            requestAddView.addObject("message", "Verzoek met succes ingediend!");

            return requestAddView;
        }
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteUserRequest(@PathVariable Integer id, HttpSession session) {
        userRequestService.deleteUserRequest(id);

        if (userRequestService.getUserRequests().isEmpty()) {
            ModelAndView homeView = new ModelAndView("index/index");

            session.setAttribute("requestList", userRequestService.getUserRequests());
            session.setAttribute("requestListSize", userRequestService.getUserRequests().size());

            homeView.addObject("message", "Er zijn geen verzoeken meer!");
            return homeView;
        } else {
            ModelAndView deleteUserRequest = new ModelAndView("/userrequest/list");
            session.setAttribute("requestList", userRequestService.getUserRequests());
            session.setAttribute("requestListSize", userRequestService.getUserRequests().size());

            String message = "Verzoek is verwijderd.";
            deleteUserRequest.addObject("message", message);
            return deleteUserRequest;
        }
    }

}
