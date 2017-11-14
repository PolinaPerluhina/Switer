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
        messages.put("Message1", new Message("asd;ljgaod"));
        messages.put("Message2", new Message("s;flgkjhskirfgjh[irw"));
        messages.put("Message3", new Message("Firslfkghnklsfgnhkslfgnhst"));
        messages.put("Message4", new Message("Firsosdhnjogfsjht"));
    }
    
    public static Message getMessage(String title){
        return messages.get(title);
    }
    
    public static void addMessage(String title, Message ms){
        messages.put(title,ms);
    }
    
    public static void updateMessage(String title, String newText){
        Message ms = messages.get(title);
        ms.setText(newText);
        messages.put(title, ms);
    }
    
    public void deleteMessage(String title){
        messages.remove(title);
    }
    
    public static List<Message> getAll(){
        ArrayList<Message> result=new ArrayList<Message>();
        Collection<Message> c = messages.values();
        result.addAll(c);
        return result;
    }
}
