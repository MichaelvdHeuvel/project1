package com.controller;

import com.lib.FileUploader;
import com.model.User;
import com.service.UserService;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/upload")
public class FileUploadController {

    @Autowired
    UserService userService;

    
    @RequestMapping(value="/profile/image", method = RequestMethod.GET)
    ModelAndView singleSaveView(HttpSession session){
        User loggedInUser = (User)session.getAttribute("loggedInUser");
        
        if(loggedInUser != null){
            ModelAndView ProfilePictureUploadView = new ModelAndView("user/editUserPicture");
            
            return ProfilePictureUploadView;
        }else{
            ModelAndView loginView = new ModelAndView("login/login");
            
            loginView.addObject("user", new User());
            
            return loginView;
        }
    }
    
    @RequestMapping(value = "/save/image", method = RequestMethod.POST)
    ModelAndView singleSave(@RequestParam("file") MultipartFile file, HttpSession session, 
        HttpServletRequest request) throws IOException {

        User loggedInUser = (User)session.getAttribute("loggedInUser");
        
        ModelAndView homeView = new ModelAndView("index/index");
        homeView.addObject("loggedInUser", loggedInUser);

        if (!file.isEmpty()) {
            FileUploader upload = new FileUploader(loggedInUser, request);
            
            upload.ImageFileUpload(file);
            
            userService.updateUserPicture(loggedInUser, file.getOriginalFilename());
            
            String message = "Bestand is succesvol geupload.";
            homeView.addObject("message", message);
        } else {
            String message = "bestand is leeg";
            homeView.addObject("message", message);
        }
        return homeView;
    }
}
