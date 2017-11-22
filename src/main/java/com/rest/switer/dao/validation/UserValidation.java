/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.switer.dao.validation;

import com.rest.switer.dao.UserDAO;
import com.rest.switer.exceptions.UserException;
import static com.rest.switer.exceptions.errors.UserError.*;
import com.rest.switer.model.Model;
import com.rest.switer.model.User;
import java.util.List;

/**
 *
 * @author Palina_Piarlukhina
 */
public class UserValidation implements Validation {

    public UserValidation() {
    }

    public static void noId(User u) {
        long id = u.getId();
        if (id != 0) {
            throw new UserException(403, NO_ADD_ID);
        }
    }

    public static void idValidation(User u) {
        int status = 400;

        long id = u.getId();
        if (id == 0) {
            throw new UserException(status, ID_MISSED);
        }
        if (id < 0) {
            throw new UserException(status, NOT_VALID_ID);
        }
    }

    public static User doesUserExist(long id) {
        List<User> all = UserDAO.getAllUsers();
        boolean present = false;
        User toDelete = null;
        for (User user : all) {            
            if (user.getId() == id) {
                present = true;
                toDelete = user;
            }
        }
        if (!present) {
            throw new UserException(404, NO_USER);
        }
        return toDelete;
    }

    public static void emailValidation(User u) {
        int status = 400;
        List<User> all = UserDAO.getAllUsers();
        try {
            String email = u.getEmail();
            if (email.equals("")) {
                throw new UserException(status, EMAIL_MISSED);
            }
            for (User user : all) {
                if (user.getEmail().equals(email)) {
                    throw new UserException(status, EMAIL_USED);
                }
            }

        } catch (NullPointerException e) {
            throw new UserException(status, EMAIL_MISSED);
        }

    }

    public static void emailPresent(User u) {
        int status = 400;
        List<User> all = UserDAO.getAllUsers();
        try {
            String email = u.getEmail();
            if (email.equals("")) {
                throw new UserException(status, EMAIL_MISSED);
            }

        } catch (NullPointerException e) {
            throw new UserException(status, EMAIL_MISSED);
        }

    }

    public static void passwordPresent(User u) {
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
        noId(u);
        emailValidation(u);
        passwordPresent(u);
    }

    @Override
    public void canBeUpdated(Model m) {
        User u = (User) m;             
        System.out.println(u.getId()+" - catched in validation user id");
        idValidation(u);        
        doesUserExist(u.getId());
        

    }

    @Override
    public Model canBeDeleted(long id) {
        return (Model) doesUserExist(id);
    }

}
