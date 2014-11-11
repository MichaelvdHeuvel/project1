/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.ProjectDAO;
import com.model.Project;
import java.util.List;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Faustino
 */
@Service
@Transactional
public class ProjectService {
    
        @Autowired
        private ProjectDAO projectDAO;
        
        public void addProject(Project project, HttpSession session){
            projectDAO.addProject(project, session);            
        }
        
        public void updateProject(Project project) {
            projectDAO.updateProject(project);
        }
        
        public Project getProject(int id) {
            return projectDAO.getProject(id);
        }
        
        public void deleteProject(int id) {
            projectDAO.deleteProject(id);
        }
    
        public List<Project> getProjects() {
            return projectDAO.getProjects();
        }
        
        public void storeAllProjects(List<Project> projects) {
            projectDAO.storeAllProjects(projects);
        }
}
