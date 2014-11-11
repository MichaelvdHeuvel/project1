package com.controller;

import com.model.User;
import com.service.UserService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * TestDataController.
 * Automatically creates test data after a create in the hibernate configuration.
 * 
 * @author David
 */
@Controller
public class TestDataController {
    @Autowired
    private UserService userService;
    
    /**
     * Setup for the database.
     * Sets the setupRoles and setupUsers to automatically add user data in the database.
     * 
     * @return menuView - return a new login view with a message.
     * @throws IOException 
     */
    @RequestMapping(value = "/dba")
    public ModelAndView UserList() throws IOException {
        ModelAndView menuView = new ModelAndView("/login/login");
        setupUsers();
        String message = "Database setup was successfull!";
        menuView.addObject("user", new User());
        menuView.addObject("message", message);
        return menuView;
    }
    
    /**
     * Add the users to the database, ready to test with.
     */
    private void setupUsers(){
        // passwords are 1234
        List<User> users = new ArrayList<User>();
        User user = new User("$2a$12$PmT10XB.VEgIl9wwYptCHOf8l.c8fHF8iO85lVjvhofP4AmpDdyPS", 1,
                            1 , "Adrie", "van der Sande", "blank_person.png",
                            "adrie.sande@infosupport.nl", "06-33643024", "Kijckerweg", "187",
                            "2678 AA", "De Lier");
        user.setProfileImage("adriesande_profile_picture.jpg");
        users.add(user);
        
        user = new User("$2a$12$PmT10XB.VEgIl9wwYptCHOf8l.c8fHF8iO85lVjvhofP4AmpDdyPS", 1,
                        2, "Brutus", "Boneschansker", "blank_person.png", 
                        "brutus.boneschansker@infosupport.nl", "06-11689699", "Willemsweg", "180", 
                        "6531 DM", "Nijmegen");
        user.setProfileImage("brutusbone_profile_picture.jpg");
        users.add(user);
        
        user = new User("$2a$12$PmT10XB.VEgIl9wwYptCHOf8l.c8fHF8iO85lVjvhofP4AmpDdyPS", 1,
                        2, "charlotte", "Haze", "blank_person.png", 
                        "charlotte.haze@infosupport.nl", "06-65334117", "Alkmaarseweg", "102", 
                        "1944 DV", "Beverwijk");
        user.setProfileImage("charlotteh_profile_picture.png");
        users.add(user);
        
        user = new User("$2a$12$PmT10XB.VEgIl9wwYptCHOf8l.c8fHF8iO85lVjvhofP4AmpDdyPS", 0,
                        3, "Dirk", "Diepenmaat", "blank_person.png", 
                        "dirk.diepenmaat@infosupport.nl", "06-45596241", "Tollenaersingel", "43",
                        "2352 JN", "Leiderdorp");
        user.setProfileImage("dirkdiepen_profile_picture.jpg");
        users.add(user);
        
        user = new User("$2a$12$PmT10XB.VEgIl9wwYptCHOf8l.c8fHF8iO85lVjvhofP4AmpDdyPS", 1,
                        3, "Elsbeth", "Nieboer", "blank_person.png", 
                        "elsbeth.nieboer@infosupport.nl", "06-56760923", "Karel van Gelderstraat", "89",
                        "6882 CH", "Velp");
        user.setProfileImage("elsbethnieb_profile_picture.jpg");
        users.add(user);
        
        user = new User("$2a$12$PmT10XB.VEgIl9wwYptCHOf8l.c8fHF8iO85lVjvhofP4AmpDdyPS", 0,
                        3, "Erik", "Norel", "blank_person.png", 
                        "erik.norel@infosupport.nl", "06-73643972", "Meidoornlaan ", "23", 
                        "4171 AP", "Heerwijnen");
        user.setProfileImage("eriknorel_profile_picture.jpg");
        users.add(user);
        
        user = new User("$2a$12$PmT10XB.VEgIl9wwYptCHOf8l.c8fHF8iO85lVjvhofP4AmpDdyPS", 0,
                        3, "Eduard", "Kaal", "blank_person.png", 
                        "eduard.kaal@infosupport.nl", "06-58641955", "Zuiderplein", "82", 
                        "8911 AN", "Leeuwarden");
        user.setProfileImage("eduardkaal_profile_picture.jpg");
        users.add(user);
        
        user = new User("$2a$12$PmT10XB.VEgIl9wwYptCHOf8l.c8fHF8iO85lVjvhofP4AmpDdyPS", 1,
                        3, "Frits", "de Hooge", "blank_person.png", 
                        "frits.hooge@infosupport.nl", "06-93723733", "Wethouder van Dijklaan", "89",
                        "4849 PG", "Dorst");
        user.setProfileImage("fritshooge_profile_picture.jpg");
        users.add(user);
        userService.storeAllUsers(users);
    }
}
