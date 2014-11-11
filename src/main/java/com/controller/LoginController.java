package com.controller;

import com.model.User;
import com.service.LoginService;
import com.service.UserService;
import java.io.IOException;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller for the login page. Login controller that organizes the login.
 *
 * @author David
 */
@Controller
@RequestMapping(value = "/login")
public class LoginController {

    @Autowired
    private UserService userService;
    @Autowired
    private LoginService loginService;

    /**
     * Get of the login view. The main reason for this is to check whether a
     * session has a user object in it If so, a user is logged in. loggedInUser
     * is not null if a user object is in the session this means a user is
     * logged in. if so, this page can be skipped and the homepage will be
     * returned.
     *
     * @param session - to get the user object out of the session
     * @return loginView or homeController. depends of a logged in user.
     * @throws IOException
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView loginView(HttpSession session) throws IOException {
        User loggedInUser = (User) session.getAttribute("loggedInUser");
        if (loggedInUser != null) {
            ModelAndView homeController = new ModelAndView("/index/index");

            return homeController;
        } else {
            ModelAndView loginView = new ModelAndView("/login/login");
            loginView.addObject("user", new User());
            return loginView;
        }
    }

    /**
     * Post of the login view. loginCheck checks if the given password is the
     * same as the stored password. if so, the user is logged in and a session
     * with it's user object is stored. If authentication fales, the client will
     * get a new login screen with a given error.
     *
     * @param user - to get the information off the jsp page.
     * @param session - to store a user object if the password is right
     * @return loginView - either a redirect to / if a user is logged in or to a
     * new login page with a "Wrong username or password!" error.
     * @throws IOException
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView loginCheck(@ModelAttribute User user, HttpSession session) throws IOException {
        //Check if the log in request is valid
        if (loginService.isLogginCorrect(user.getEmailAddress(), user.getPassword())) {

            session.setAttribute("loggedInUser", loginService.getLoggedInUser(user.getEmailAddress()));
            ModelAndView loginView = new ModelAndView("redirect:/");

            return loginView;
        } else {// if it's not valid return new login screen with error
            ModelAndView loginView = new ModelAndView("/login/login");

            loginView.addObject("error", "Wrong username or password!");
            return loginView;
        }
    }

    /**
     * Get of the register page. loggedInUser checks if a user object is stored
     * in the session. If this is true The user will be redirected to the home
     * page. (a stored user object in the session is only possible after a
     * succesful login).
     *
     * @param session - To check if a user object exists in the session
     * @return userRegisterView Redirect to / or a new view to a new register
     * page
     * @throws IOException
     */
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView userRegisterPage(HttpSession session) throws IOException {
        User loggedInUser = (User) session.getAttribute("loggedInUser");

        if (loggedInUser != null) {
            ModelAndView userRegisterView = new ModelAndView("redirect:/");

            return userRegisterView;
        } else {
            ModelAndView userRegisterView = new ModelAndView("/login/register");

            userRegisterView.addObject("loggedInUser", loggedInUser);

            userRegisterView.addObject("pageTitle", "Register");
            userRegisterView.addObject("user", new User());

            return userRegisterView;
        }
    }

    /**
     * Post of the register page. Here comes the login request via email.
     *
     * @param user - the user to set the email request
     * @return userRegisterView get back to the login page with a positive error
     * message
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView userRegister(@ModelAttribute User user) {
        if (user.getPassword().equals(user.getPasswordConfirm())) {
            ModelAndView userRegisterView = new ModelAndView("/login/login");

            user.setProfileImage("blank_person.png");
            user.setRole(1);
            user.setActive(1);

            userService.addUser(user);

            userRegisterView.addObject("user", new User());
            userRegisterView.addObject("error", "Email verstuurd ter verificatie");

            return userRegisterView;
        } else {
            ModelAndView userRegisterView = new ModelAndView("/login/register");

            userRegisterView.addObject("pageTitle", "Register");
            userRegisterView.addObject("user", new User());
            userRegisterView.addObject("error", "wachtwoorden komen niet overeen");

            return userRegisterView;
        }
    }
}
