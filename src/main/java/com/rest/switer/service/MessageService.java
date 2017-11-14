/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.switer.service;

import com.rest.switer.dao.MessageDAO;
import com.rest.switer.model.Message;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Palina_Piarlukhina
 */
@Path("messages")
public class MessageService {
    
    // URI:
    // /contextPath/servletPath/messages
    @GET
    @Produces({ MediaType.APPLICATION_JSON})
    public List<Message> getEmployees_JSON() {
        List<Message> listOfMessages = MessageDAO.getAll();
        return listOfMessages;
    }
}