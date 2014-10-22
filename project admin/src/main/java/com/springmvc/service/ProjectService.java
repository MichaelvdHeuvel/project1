/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springmvc.service;

import com.springmvc.dao.ProjectDAO;
import com.springmvc.model.Project;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Ruben
 */
@Service
@Transactional
public class ProjectService {
     @Autowired
    private ProjectDAO projectDAO;

    public void addProject(Project project) {
        projectDAO.addProject(project);
    }
    
    public void updateProject(Project project) {
        projectDAO.updateProject(project);
    }

   

    public Project getProject(int id) {
        return projectDAO.getProject(id);
    }
    
   

    

    public List<Project> getProjects() {
        return projectDAO.getProjects();
    }

    public void storeAllProjects(List<Project> project) {

      projectDAO.storeAllProjects(project);

   }
}

