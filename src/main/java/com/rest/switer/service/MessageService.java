/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.switer.service;

import com.rest.switer.dao.MessageDAO;
import com.rest.switer.model.Message;
import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Palina_Piarlukhina
 */
@Path("messages")
public class MessageService {
    
    // URI:
    // /switer-1.0/rest/messages
    @GET
    @Produces({ MediaType.APPLICATION_JSON})
    public List<Message> getAllMessages() {
        List<Message> listOfMessages = MessageDAO.getAll();
        return listOfMessages;
    }
    
    @GET
    @Path("/{title}")
    @Produces({ MediaType.APPLICATION_JSON})
    public Message getMessage(@PathParam("title") String title) {
        Message ms = MessageDAO.getMessage(title);
        return ms;
    }
    
    @POST
    @Produces({ MediaType.APPLICATION_JSON})
    public void sendMessage(Message message){
        MessageDAO.addMessage(message);
    }
    
    @PUT
    @Produces({ MediaType.APPLICATION_JSON})
    public void updateMessage(Message message){
        MessageDAO.updateMessage(message);
    }
    
    @DELETE
    @Path("/{title}")
    @Produces({ MediaType.APPLICATION_JSON})
    public void deleteMessage(@PathParam("title") String title){
        MessageDAO.deleteMessage(title);
    }
}
