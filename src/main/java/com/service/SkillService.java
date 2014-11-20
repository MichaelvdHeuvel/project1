/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.dao.SkillDAO;
import com.model.Skill;
import com.model.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Tim
 */
@Service
@Transactional
public class SkillService {

    @Autowired
    private SkillDAO skillDAO;

    public void addSkill(Skill skill) {
        skillDAO.addSkill(skill);
    }

    public void updateSkill(Skill skill) {
        skillDAO.updateSkill(skill);
    }

    public Skill getSkill(int id) {
        return skillDAO.getSkill(id);
    }

    public void deleteSkill(int id) {
        skillDAO.deleteSkill(id);
    }
     public void deleteCategory(int id) {
        skillDAO.deleteCategory(id);
    }

    public List<Skill> getSkills() {
        return skillDAO.getSkills();
    }

    public void storeAllSkills(List<Skill> skills) {

        skillDAO.storeAllSkills(skills);

    }

}
