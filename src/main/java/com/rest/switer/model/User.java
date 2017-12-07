/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.switer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 *
 * @author Palina_Piarlukhina
 */
//@JsonInclude(Include.NON_EMPTY)

@Entity
@Table(name = "users")
public class User extends Model {

    @Id
    @Column(name="id")
    private long id;
    @Column(name="email")
    private String email;
    @Column(name="password")
    private String password;
    @Column(name = "firstName")
    private String firstName;
    @Column(name="lastName")
    private String lastName;
    @Column(name="age")
    private int age;
    @Column(name="telephone")
    private String telephone;

    public User() {       
    }

    public User(String email, String password, String firstName, String lastName, int age, String telephone) {
        this.generateId();
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.telephone = telephone;
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

    public void generateId() {
        String generated = "";
        for (int i = 0; i < 6; i++) {
            generated += Math.round(Math.random() * 10);
        }
        long newId = Long.parseLong(generated);
        this.id = newId;
    }
}
