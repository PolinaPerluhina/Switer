/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.switer.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 *
 * @author Palina_Piarlukhina
 */
//@JsonInclude(Include.NON_EMPTY)
public class User extends Model {

    private long id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private int age;
    private String telephone;

    public User() {
    }

    public User(long id, String email, String password, String firstName, String lastName, int age, String telephone) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.telephone = telephone;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public User copyProperties() {
        User newUser = new User();
        newUser.setId(this.getId());
        newUser.setEmail(this.getEmail());
        newUser.setPassword(this.getPassword());
        newUser.setFirstName(this.getFirstName());
        newUser.setLastName(this.getLastName());
        newUser.setTelephone(this.getTelephone());
        return newUser;
    }

    /*
    Possibility to send for PUT not all fields. This method will fullfill
    missed fields with old values;
     */
    public void fillMissedFields(User copyFrom) {
        if (this.getAge() == 0) {
            this.setAge(copyFrom.getAge());
        }
        if (this.getEmail() == null) {
            this.setEmail(copyFrom.getEmail());
        }
        if (this.getPassword() == null) {
            this.setPassword(copyFrom.getPassword());
        }
        if (this.getFirstName() == null) {
            this.setFirstName(copyFrom.getFirstName());
        }
        if (this.getLastName() == null) {
            this.setLastName(copyFrom.getLastName());
        }
        if (this.getTelephone() == null) {
            this.setTelephone(copyFrom.getTelephone());
        }
    }
    
    /*
    Possibility to send for POST not all fields. This method will fullfill
    missed fields with empty values;
     */

    public void fillMissedFields() {
        if (this.getEmail() == null) {
            this.setEmail("");
        }
        if (this.getPassword() == null) {
            this.setPassword("");
        }
        if (this.getFirstName() == null) {
            this.setFirstName("");
        }
        if (this.getLastName() == null) {
            this.setLastName("");
        }
        if (this.getTelephone() == null) {
            this.setTelephone("");
        }
    }
}
