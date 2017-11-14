/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.switer.dao;

import com.rest.switer.model.Message;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Palina_Piarlukhina
 */
public class MessageDAO {
    private static final Map<String, Message> messages = new HashMap<String, Message>();
    
    static {
        initMessages();
    }
    
    private static void initMessages(){
        Message msg1 = new Message("hello", "Hi! How are you?");
        Message msg2 = new Message("bye", "Good bye for now, see you later");
        Message msg3 = new Message("question", "What are you going to do tonight?");
        Message msg4 = new Message("compliment", "You look nice today");
        
        messages.put(msg1.getTitle(), msg1);
        messages.put(msg2.getTitle(), msg2);
        messages.put(msg3.getTitle(), msg3);
        messages.put(msg4.getTitle(), msg4);        
    }
    
    public static Message getMessage(String title){
        return messages.get(title);
    }
    
    public static void addMessage( Message ms){
        messages.put(ms.getTitle(),ms);
    }
    
    public static void updateMessage(Message ms){       
        messages.put(ms.getTitle(), ms);
    }
    
    public static void deleteMessage(String title){
        messages.remove(title);
    }
    
    public static List<Message> getAll(){
        ArrayList<Message> result=new ArrayList<Message>();
        Collection<Message> c = messages.values();
        result.addAll(c);
        return result;
    }
}
