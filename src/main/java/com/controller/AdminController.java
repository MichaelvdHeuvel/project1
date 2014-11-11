/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.model.User;
import com.service.UserRequestService;
import com.service.UserService;
import java.io.IOException;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author David
 */
@Controller
@RequestMapping(value="/admin")
public class AdminController {
    @Autowired
    private UserRequestService userRequestService;
    @Autowired
    private UserService userService;
    
    @RequestMapping(value="/userrequestlist")
    public ModelAndView adminHomePage(HttpSession session) throws IOException{
        User loggedInUser = (User)session.getAttribute("loggedInUser");
        if(loggedInUser != null ){
            //Checks if user is admin
            if(loggedInUser.getRole() == 3){
                ModelAndView userRequestListView = new ModelAndView("userrequest/userrequestlist");
                userRequestListView.addObject("requestList", userRequestService.getUserRequests());
                userRequestListView.addObject("requestListSize", userRequestService.getUserRequests().size());

                return userRequestListView;
            }else{
                ModelAndView homeView = new ModelAndView("index/index");
                User activeUser = (User)session.getAttribute("loggedInUser");

                homeView.addObject("loggedInUser", activeUser);
                return homeView;
            }
        }else{
                ModelAndView loginView = new ModelAndView("/login/login");

                loginView.addObject("user", new User());

                return loginView; 
            }
    }
    
    @RequestMapping(value="/userlist")
    public ModelAndView adminUserList(HttpSession session) throws IOException{
        User loggedInUser = (User)session.getAttribute("loggedInUser");
        if(loggedInUser != null) {
            //Checks if user is admin
            if(loggedInUser.getRole() == 3){
                ModelAndView userListView = new ModelAndView("/admin/userlist");
        
                userListView.addObject("userList", userService.getUsers());
                userListView.addObject("userListSize", userService.getUsers().size());
                
                return userListView;
            }else{
                ModelAndView homeView = new ModelAndView("index/index");
                User activeUser = (User)session.getAttribute("loggedInUser");

                homeView.addObject("loggedInUser", activeUser);
                return homeView;
            }
        }else{
            ModelAndView loginView = new ModelAndView("/login/login");

                loginView.addObject("user", new User());

                return loginView; 
        }
    }
    
    @RequestMapping(value = "/userlist/active/{id}", method = RequestMethod.GET)
    public ModelAndView removeEmployee(@PathVariable int id, HttpSession session){
        User loggedInUser = (User)session.getAttribute("loggedInUser");
        if(loggedInUser != null) {
            //Checks if user is admin
            if(loggedInUser.getRole() == 3){
                ModelAndView userListView = new ModelAndView("admin/userlist");
                
                userService.updateUserActive(userService.getUser(id));
                
                userListView.addObject("userList", userService.getUsers());
                userListView.addObject("userListSize", userService.getUsers().size());

                return userListView;
            }else{
                ModelAndView homeView = new ModelAndView("index/index");
                User activeUser = (User)session.getAttribute("loggedInUser");

                homeView.addObject("loggedInUser", activeUser);
                return homeView;
            }
        }else{
            ModelAndView loginView = new ModelAndView("/login/login");

                loginView.addObject("user", new User());

                return loginView; 
        }
    }
}
