/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.dao.WorkExperienceDAO;
import com.model.WorkExperience;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author David
 */
@Service
@Transactional

public class WorkExperienceService {
    @Autowired
    private WorkExperienceDAO workExpDAO;
    
    public void addWorkExperience(WorkExperience exp, HttpSession session){
        workExpDAO.addWorkExperience(exp, session);
    }
    
    public WorkExperience getWorkExperience(int id){
        return workExpDAO.getWorkExperience(id);
    }
    
    public void updateWorkExperience(WorkExperience exp){
        workExpDAO.updateWorkExperience(exp);
    }
    
    public void setActive(WorkExperience exp){
        workExpDAO.setActive(exp);
    }
    
    public List<WorkExperience> getActiveWorkExperience(int id){
        return workExpDAO.getActiveWorkExperience(id);
    }
    
    public List<WorkExperience> getAllWorkExperience(int id){
        return workExpDAO.getAllWorkExperience(id);
    }
}
