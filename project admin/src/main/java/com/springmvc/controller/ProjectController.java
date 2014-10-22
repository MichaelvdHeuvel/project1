/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springmvc.controller;

import com.springmvc.model.Project;
import com.springmvc.model.Role;
import com.springmvc.service.ProjectService;
import com.springmvc.service.RoleService;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Ruben
 */
@Controller
@RequestMapping(value = "/project")
public class ProjectController {
     
    @Autowired
    private ProjectService projectService;

    
     private static String projectNieuw = "Nieuwe Project";
  

    @RequestMapping(value = "/list")
    public ModelAndView projectList() throws IOException {
        ModelAndView projectListView = new ModelAndView("ProjectList");
        projectListView.addObject("projectList", projectService.getProjects());

        return projectListView;
    }
      @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView userProjectAdd() throws IOException {

        ModelAndView userProjectView = new ModelAndView("projectAdd");
        userProjectView.addObject("paginaTitel", projectNieuw);
        userProjectView.addObject("project", new Project());
        userProjectView.addObject("projectList", projectService.getProjects());
        return userProjectView;

    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView projectAdd(@ModelAttribute Project project)  {

        ModelAndView projectListView = new ModelAndView("userList");
        projectService.addProject(project);
        projectListView.addObject("projectList", projectService.getProjects());
        String message = "Project was successfully added.";
        projectListView.addObject("message", message);

        return projectListView;

    }
}