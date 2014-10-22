package com.springmvc.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @RequestMapping(value = "/")
    public ModelAndView home() throws IOException {
        return new ModelAndView("index");
    }

    @RequestMapping(value = "/index")
    public ModelAndView index() throws IOException {
        return new ModelAndView("index");
    }

//    @RequestMapping(value = "/home")
//    public ModelAndView home1() throws IOException {
//        return new ModelAndView("home");
//    }

    @RequestMapping(value = "/home")
    public ModelAndView home1() throws IOException {
        return new ModelAndView("home");
    }
    
        @RequestMapping(value = "/message")
    public ModelAndView message() throws IOException {
        return new ModelAndView("message");
    }
}
