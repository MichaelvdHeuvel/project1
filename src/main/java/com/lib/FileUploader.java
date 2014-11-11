/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lib;

import com.model.User;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author David
 */
public class FileUploader {

    private User loggedInUser;
    private HttpServletRequest request;

    public FileUploader(User user, HttpServletRequest request) {
        this.loggedInUser = user;
        this.request = request;
    }

    public void ImageFileUpload(MultipartFile file) throws IOException {

        String SAVE_DIR = "resources/userfiles/" + loggedInUser.getEmailAddress() + "/";
        String fileName = null;

        String appPath = request.getServletContext().getRealPath("");
        String path = appPath + File.separator + SAVE_DIR;

        fileName = file.getOriginalFilename();

        byte[] bytes = file.getBytes();
        BufferedOutputStream buffStream
                = new BufferedOutputStream(new FileOutputStream(
                                new File(path + fileName)));
        buffStream.write(bytes);
        buffStream.close();
    }
}
