/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.switer.dao;

import java.util.List;

import com.rest.switer.dao.validation.UserValidation;
import com.rest.switer.dao.validation.Validation;
import com.rest.switer.exceptions.UserException;
import com.rest.switer.model.User;
import java.util.ArrayList;
import org.hibernate.Session;

/**
 *
 * @author Palina_Piarlukhina
 */
public class UserDAO extends DAO {

    private List<User> allUsers;
    public Validation valid;

    public UserDAO() {
        allUsers = new ArrayList();
        valid = new UserValidation();
    }

    public User getUser(long id) throws UserException {
        Session s = this.getSession();
        this.start();
        valid.canBeGot(id);
        User res = (User) s.get(User.class, id);
        this.commit();
        this.close();
        return res;
    }

    public List<User> getAllUsers() {
        Session s = this.getSession();
        this.start();
        allUsers = s.createCriteria(User.class).list();
        this.commit();
        this.close();
        return allUsers;
    }

    public User addUser(User u) throws UserException {
        valid.canBeAdded(u);
        Session s = this.getSession();
        this.start();
        u.generateId();
        s.save(u);
        this.commit();        
        this.close(); 
        return u;
    }

    public User updateUserInfo(User u) throws UserException {        
        valid.canBeUpdated(u);
        Session s = this.getSession();
        this.start();
        User old = (User) s.get(User.class, u.getId());
        u.fillMissedFields(old);
        s.delete(old);
        s.save(u);
        this.commit();
        this.close(); 
        return u;
    }

    public void deleteUser(long id) throws UserException {        
        valid.canBeDeleted(id);
        Session s = this.getSession();
        this.start();
        User old = (User) s.get(User.class, id);
        s.delete(old);
        this.commit();
        this.close(); 
    }

    public User fillEmptyValues(User newVersion, User oldVersion) {
        if (newVersion.getAge() == 0) {
            newVersion.setAge(oldVersion.getAge());
        }
        try {
            newVersion.getFirstName();
        } catch (NullPointerException e) {
            newVersion.setFirstName(oldVersion.getFirstName());
        }
        try {
            newVersion.getLastName();
        } catch (NullPointerException e) {
            newVersion.setLastName(oldVersion.getLastName());
        }
        try {
            newVersion.getTelephone();
        } catch (NullPointerException e) {
            newVersion.setTelephone(oldVersion.getTelephone());
        }
        return newVersion;

    }
}
