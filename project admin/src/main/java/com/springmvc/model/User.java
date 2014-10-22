package com.springmvc.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;
    private String name;
    private String streetAddress;
    private String city;
    private String houseNumber;

    @ManyToOne
    private Role role;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name= "user_projects", joinColumns = {@JoinColumn(name="user_id")},inverseJoinColumns = {@JoinColumn(name="project_id")})
    private List<Project> projects;

    // constructors
    public User() {

    }

    public User(int userId, String name, String streetAddress, String city, String houseNumber, Role role, List<Project> projects) {

        this.setUserId(userId);
        this.setName(name);
        this.setStreetAddress(streetAddress);
        this.setCity(city);
        this.setHouseNumber(houseNumber);
        this.setRole(role);
        this.projects = projects;

    }


    /* Getters en setters voor de verschillende attributen van het Model */
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
    
    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}
