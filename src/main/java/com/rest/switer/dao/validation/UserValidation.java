/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.switer.dao.validation;

import com.rest.switer.dao.DAO;
import com.rest.switer.exceptions.UserException;
import static com.rest.switer.exceptions.errors.UserError.*;
import com.rest.switer.model.Model;
import com.rest.switer.model.User;
import java.util.List;
import static java.util.Objects.isNull;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Palina_Piarlukhina
 */
public class UserValidation implements Validation {
    
    private static DAO dao = new DAO();

    public UserValidation() {
    }

    public static void IdNotPresent(User u) {
        long id = u.getId();
        if (id != 0) {
            throw new UserException(403, NO_ADD_ID);
        }
    }

    public static void IdPresent(User u) {
        int status = 400;
        long id = u.getId();
        if (id == 0) {
            throw new UserException(status, ID_MISSED);
        }        
    }
    
    public static void IdValid(User u) {
        int status = 400;
        long id = u.getId();        
        if (id < 0) {
            throw new UserException(status, NOT_VALID_ID);
        }
    }

    public static void IdIsUsed(long id) {   
        dao.start();
        Model present = (Model)dao.getSession().load(User.class, id); 
        dao.commit();
        if (isNull(present)) {
            dao.close();
            throw new UserException(404, NO_USER);            
        }   
        dao.close();
    }

    public static void EmailPresent(User u) {
        int status = 400;        
        try {
            String email = u.getEmail();
            if (email.equals("")) {
                throw new UserException(status, EMAIL_MISSED);
            }            
        } catch (NullPointerException e) {
            throw new UserException(status, EMAIL_MISSED);
        }

    }
    
    public static void EmailNotUsed(User u) {
        int status = 400;
        dao.start();
        List result = dao.getSession().createCriteria(User.class).add(Restrictions.eq("email", u.getEmail())).list();
        dao.commit();
         if (result.size()>0) {
            dao.close();
            throw new UserException(status, EMAIL_USED);
        }
        dao.close();
    }   
    
    public static void EmailNotDuplicate(User u){
        String email = u.getEmail();
        if (!email.equals("")){
            int status = 400;
         dao.start();
        List result = dao.getSession().createCriteria(User.class).add(Restrictions.eq("email", u.getEmail())).list();
         if (result.size()>1) {
           dao.close();
            throw new UserException(status, EMAIL_USED);
        }
         dao.close();
        }         
    }

    public static void PasswordPresent(User u) {
        int status = 400;
        try {
            String pass = u.getPassword();
            if (pass.equals("")) {
                throw new UserException(status, NO_PASSWORD);
            }
        } catch (NullPointerException e) {
            throw new UserException(status, NO_PASSWORD);
        }
    }

    @Override
    public void canBeAdded(Model m) {
        User u = (User) m;        
        IdNotPresent(u);
        PasswordPresent(u);
        EmailPresent(u);
        EmailNotUsed(u);
    }

    @Override
    public void canBeUpdated(Model m) {
        User u = (User) m;
        IdPresent(u);
        IdValid(u);
        IdIsUsed(u.getId());          
        EmailNotDuplicate(u);
    }

    @Override
    public void canBeDeleted(long id) {
        IdIsUsed(id);
    }

    @Override
    public void canBeGot(long id) {
       IdIsUsed(id);
    }

}
