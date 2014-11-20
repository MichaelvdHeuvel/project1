package com.dao;

import com.model.Skill;
import com.model.User;
import java.sql.Timestamp;
import java.util.Date;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SkillDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public void addSkill(Skill skill) {
        getCurrentSession().save(skill);
    }

    public void updateSkill(Skill skill) {
        Skill skillToUpdate = getSkill(skill.getSkillId());
        skillToUpdate.setName(skill.getName());
        skillToUpdate.setCategory(skill.getCategory());
        if (skill.getActive() == 1) {
            skillToUpdate.setActive(0);
        } else {
            skillToUpdate.setActive(1);
        }
        getCurrentSession().update(skillToUpdate);
    }

    public Skill getSkill(int id) {
        Skill skill = (Skill) getCurrentSession().get(Skill.class, id);
        return skill;
    }

    public void deleteSkill(int id) {
        Skill skill = getSkill(id);
        if (skill != null) {
            getCurrentSession().delete(skill);
        }
    }

    public void deleteCategory(int id) {
        Skill skillToUpdate = getSkill(id);
        skillToUpdate.setCategory(null);
        getCurrentSession().update(skillToUpdate);
    }

    @SuppressWarnings("unchecked")
    public List<Skill> getSkills() {
        return getCurrentSession().createQuery("from Skill").list();
    }

    public void storeAllSkills(List<Skill> skills) {

        for (Skill skill : skills) {
            getCurrentSession().save(skill);
        }

    }
}
