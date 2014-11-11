/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.model.Project;
import com.model.User;
import com.service.ProjectService;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Faustino
 */
@Controller
@RequestMapping(value = "/project")
public class ProjectController {

    @Autowired
    ProjectService projectService;
    private static final String titelNieuw = "Nieuw project";

    //Dit zorgt ervoor dat de String omgezet wordt in een Date object
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @RequestMapping(value = "/list")
    public ModelAndView projectList(HttpSession session) throws IOException {
        User loggedInUser = (User) session.getAttribute("loggedInUser");

        if (loggedInUser != null) {
            // Checks if user is Admin
            if (loggedInUser.getRole() != 3) {
                ModelAndView projectListView = new ModelAndView("project/projectList");
                projectListView.addObject("projectList", projectService.getProjects());
                return projectListView;
            } else {
                ModelAndView homeView = new ModelAndView("index/index");
                User activeUser = (User) session.getAttribute("loggedInUser");

                homeView.addObject("loggedInUser", activeUser);
                homeView.addObject("message", "U heeft geen bevoegdheden om dit te zien");

                return homeView;
            }
        } else {
            ModelAndView loginView = new ModelAndView("/login/login");

            loginView.addObject("user", new User());
            return loginView;
        }
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView projectAddPage(HttpSession session) throws IOException {
        User loggedInUser = (User) session.getAttribute("loggedInUser");

        if (loggedInUser != null) {
            // Checks if user is Manager
            if (loggedInUser.getRole() == 2) {
                ModelAndView projectAddView = new ModelAndView("project/addProject");

                projectAddView.addObject("project", new Project());

                return projectAddView;
            } else {
                ModelAndView homeView = new ModelAndView("index/index");
                User activeUser = (User) session.getAttribute("loggedInUser");

                homeView.addObject("loggedInUser", activeUser);
                homeView.addObject("message", "U heeft geen bevoegdheden om dit te zien");

                return homeView;
            }

        } else {
            ModelAndView loginView = new ModelAndView("/login/login");

            loginView.addObject("user", new User());
            return loginView;
        }

    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView projectAdd(@ModelAttribute Project project, HttpSession session) {

        ModelAndView projectListView = new ModelAndView("/project/projectList");

        projectService.addProject(project, session);
        projectListView.addObject("projectList", projectService.getProjects());
        String message = "Project was successfully added.";
        projectListView.addObject("message", message);
        return projectListView;
    }

    @RequestMapping(value = "/remove/{id}", method = RequestMethod.GET)
    public ModelAndView removeProject(@PathVariable int id, HttpSession session) {
        User loggedInUser = (User) session.getAttribute("loggedInUser");

        if (loggedInUser != null) {
            // Checks if user is Manager
            if (loggedInUser.getRole() == 2) {
                ModelAndView projectListView = new ModelAndView("/project/projectList");
                projectService.deleteProject(id);
                projectListView.addObject("projectList", projectService.getProjects());

                String message = "Het project is succesvol verwijderd.";
                projectListView.addObject("message", message);
                return projectListView;
            } else {
                ModelAndView homeView = new ModelAndView("index/index");
                User activeUser = (User) session.getAttribute("loggedInUser");

                homeView.addObject("loggedInUser", activeUser);
                homeView.addObject("message", "U heeft geen bevoegdheden om dit te zien");

                return homeView;
            }
        } else {
            ModelAndView loginView = new ModelAndView("/login/login");

            loginView.addObject("user", new User());
            return loginView;
        }
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editProject(HttpSession session, @PathVariable int id) throws IOException {
        User loggedInUser = (User) session.getAttribute("loggedInUser");

        if (loggedInUser != null) {
            ModelAndView editProjectView = new ModelAndView("/project/editProject");
            Project project = projectService.getProject(id);
            editProjectView.addObject("project", project);
            editProjectView.addObject("projectList", projectService.getProjects());
            return editProjectView;
        } else {
            ModelAndView loginView = new ModelAndView("/login/login");

            loginView.addObject("user", new User());
            return loginView;
        }
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView projectEdit(@ModelAttribute Project project) {

        ModelAndView projectListView = new ModelAndView("/project/projectList");
        projectService.updateProject(project);
        projectListView.addObject("projectList", projectService.getProjects());
        return projectListView;
    }

}
