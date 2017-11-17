/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.switer.dao;

import com.rest.switer.dao.validation.UserValidation;
import static com.rest.switer.dao.validation.UserValidation.*;
import com.rest.switer.dao.validation.Validation;
import com.rest.switer.model.User;
import com.rest.switer.exceptions.UserException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Palina_Piarlukhina
 */
public class UserDAO {

    private static List<User> allUsers = new ArrayList<User>();
    public static Validation valid = new UserValidation();

    static {
        User user1 = new User(1223, "ivan@mail.com", "password1", "Ivan", "Ivanov", 25, "123-123-123");
        User user2 = new User(4522, "anna@mail.com", "password2", "Anna", "Ivanova", 36, "568-591-002");
        User user3 = new User(5728, "alina@mail.com", "password3", "Alina", "Ivanova", 19, "335-564-821");

        allUsers.add(user1);
        allUsers.add(user2);
        allUsers.add(user3);
    }

    public static User getUser(long id) throws UserException {
        return doesUserExist(id);
    }

    public static List<User> getAllUsers() {
        return allUsers;
    }

    public static void addUser(User u) throws UserException {
        valid.canBeAdded(u);
        allUsers.add(u);

    }

    public static void updateUserInfo(User u) throws UserException {
        valid.canBeUpdated(u);       
        for (User user: allUsers){
            if (user.getId()==u.getId()){ 
                u.fillMissedFields(user);
                allUsers.remove(user);
                allUsers.add(u);
                return;                
            }
        }        
    }

    public static void deleteUser(long id) throws UserException {

        allUsers.remove(valid.canBeDeleted(id));

    }

    public static User fillEmptyValues(User newVersion, User oldVersion) {
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
