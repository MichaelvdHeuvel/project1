package com.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Skill implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int skillId;
    
    private String name;
    private int active;
    
    @ManyToOne
    private Category category;

    // constructors
    public Skill() {

    }

    public Skill(int skillId, String name, int active, Category category) {
        this.skillId = skillId;
        this.name = name;
        this.active = active;
        this.category = category;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public int getSkillId() {
        return skillId;
    }

    public void setSkillId(int skillId) {
        this.skillId = skillId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

 

}
