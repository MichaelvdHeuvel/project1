package is204.web.controller;

import is204.users.model.User;
import is204.users.service.UserService;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
//@RequestMapping(value = "/register")
public class UserController {

    @Autowired
    private UserService userService;

    private static final String newTitel = "registreren";

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView registerPage() throws IOException {

        ModelAndView model = new ModelAndView("register");
        model.addObject("paginaTitel", newTitel);
        model.addObject("user", new User());
        return model;

    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView register(@ModelAttribute User user) {

        ModelAndView model = new ModelAndView("login");
        userService.addUser(user);
        String message = "Gebruiker is succesvol aangemaakt.";
        model.addObject("login");
        model.addObject("msg", message);

        return model;

    }
}