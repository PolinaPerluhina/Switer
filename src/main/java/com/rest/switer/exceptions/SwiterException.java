/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.switer.exceptions;

import com.rest.switer.exceptions.errors.UserError;
import static com.rest.switer.exceptions.errors.UserError.NOT_VALID_ID;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Palina_Piarlukhina
 */
public class SwiterException extends WebApplicationException{    

    public SwiterException() {
    }

    public SwiterException(Response response) {
        super(response);
    }    
    
    public SwiterException(int status, UserError error) {
        super(Response.status(status).entity(error.getErr()).type(MediaType.APPLICATION_JSON_TYPE).build());
    }
    
}
