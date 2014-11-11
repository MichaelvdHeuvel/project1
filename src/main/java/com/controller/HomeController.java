package com.controller;

import com.model.User;
import com.service.LoginService;
import com.service.UserRequestService;
import com.service.UserService;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Home Controller that does all the mapping for the home page views.
 * @author David
 */
@Controller
public class HomeController {
    @Autowired
    LoginService loginService;
    @Autowired
    UserRequestService userRequestService;
    @Autowired
    UserService userService;
    
    /**
     * Get of the index page.
     * Check if a user is logged in. If this is not true redirect to the login page.
     * If a user is logged in show his index page.
     * 
     * @param session - check if a user object is stored in the session
     * @return homeView and loginView - homeView if user is logged in loginView otherwise
     * @throws IOException 
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView homePage(HttpSession session) throws IOException {
        User loggedInUser = (User)session.getAttribute("loggedInUser");
        if(loggedInUser != null ){
            if(loggedInUser.getRole() == 3){
                session.setAttribute("requestList", userRequestService.getUserRequests());
                session.setAttribute("requestListSize", userRequestService.getUserRequests().size());
                ModelAndView homeView = new ModelAndView("admin/index");
                User activeUser = (User)session.getAttribute("loggedInUser");

                homeView.addObject("loggedInUser", activeUser);
                return homeView;
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
    
    /**
     * Logging out of the user.
     * Check if a user object is stored in the session. If true, go to the logout page
     * and set the object in the session to null. This means no user is logged in.
     * If a user isn't logged in send the user to the login page.
     * 
     * @param session - to check if a user is in the session
     * @return logoutView or loginView - logoutView if a user is in the session. loginView otherwise
     * @throws IOException 
     */
    @RequestMapping(value = "/logout")
    public ModelAndView logout(HttpSession session) throws IOException {
        User loggedInUser = (User)session.getAttribute("loggedInUser");
        if(loggedInUser != null){
            ModelAndView logoutView = new ModelAndView("login/logout");
        
            session.setAttribute("loggedInUser", null);

            return logoutView;
        }else{
            ModelAndView loginView = new ModelAndView("/login/login");
        
            loginView.addObject("user", new User());
            return loginView;
        }
    }
    
    @RequestMapping(value = "/searchresult", method = RequestMethod.POST)
    public ModelAndView SendSearchUserlist(@RequestParam("firstName") String criteria) {
        ModelAndView model = new ModelAndView("/searchresult/userlist");
        List<User> usersResult = userService.searchUsers(criteria);

        
        model.addObject("users", usersResult);
        
        return model;

    }
}
