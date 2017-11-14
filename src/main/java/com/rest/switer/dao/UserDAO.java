/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.switer.dao;

import com.rest.switer.model.User;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Palina_Piarlukhina
 */
public class UserDAO {
    private static List<User> allUsers = new ArrayList<User>();
    
    static{
        User user1 = new User(123123123, "ivan@mail.com","password1", "Ivan", "Ivanov", 25, "123-123-123");
        User user2 = new User(452625563, "anna@mail.com","password2", "Anna", "Ivanova", 36, "568-591-002");
        User user3 = new User(578895002, "alina@mail.com","password3", "Alina", "Ivanova", 19, "335-564-821");
        
        allUsers.add(user1);
        allUsers.add(user2);
        allUsers.add(user3);
    }
    
    public static User getUser(long id){
        for (User u: allUsers){
            if (id==u.getId()){
                return u;
            }
        }
        return null;
    }
    
    public static List<User> getAllUsers(){
        return allUsers;
    }
    
    public static void addUser(User u){
        allUsers.add(u);
    }
    
    public static void updateUserInfo(User u){
        for (int i = 0; i< allUsers.size(); i++){
            if (allUsers.get(i).getId()==u.getId()){
                allUsers.remove(i);
                allUsers.add(u);
            }
        }
    }
    
    public static void deleteUser(long id){
        int index = -1;
        for (int i = 0; i< allUsers.size(); i++){
          if (allUsers.get(i).getId()==id){
              index = i;
          }  
        }        
        if (index >= 0){
            allUsers.remove(index);
        }
        else {
            System.out.println("No such element");
        }
        
    }
}
