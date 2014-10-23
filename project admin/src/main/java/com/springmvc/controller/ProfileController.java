package com.springmvc.controller;

import java.io.IOException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author David
 */
@Controller
@RequestMapping("/profile")
public class ProfileController {
    @RequestMapping(value = "/tabbed")
    public ModelAndView tabbedProfile() throws IOException{
        ModelAndView tabbedProfileView = new ModelAndView("profileOne");
        String pageTitle = "profile tabbed";
        tabbedProfileView.addObject("pageTitle", pageTitle);
        
        return tabbedProfileView;
    }
    
    @RequestMapping(value = "/onePage")
    public ModelAndView onePageProfile() throws IOException{
        ModelAndView onePageProfileView = new ModelAndView("profileTwo");
        String pageTitle = "profile onePage";
        onePageProfileView.addObject("pageTitle", pageTitle);
        
        return onePageProfileView;
    }
}