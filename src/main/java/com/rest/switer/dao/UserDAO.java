/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.switer.dao;

import static com.rest.switer.dao.validation.UserValidation.*;
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
        canBeAdded(u);
        allUsers.add(u);

    }

    public static void updateUserInfo(User u) throws UserException {
        canBeUpdated(u);
        for (int i = 0; i < allUsers.size(); i++) {
            if (allUsers.get(i).getId() == u.getId()) {
                allUsers.remove(i);
                allUsers.add(u);
            }
        }
    }

    public static void deleteUser(long id) throws UserException {

        allUsers.remove(doesUserExist(id));

    }
}
