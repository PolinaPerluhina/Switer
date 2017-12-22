/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.switer.dao.validation;

import com.rest.switer.model.Model;
import org.hibernate.Session;

/**
 *
 * @author Palina_Piarlukhina
 */
public interface Validation {
    
    /* 
    GET VALIDATIONS COMMON:
    *id of model is valid    
    */
    public abstract void canBeGot(long id);
        
    /* 
    ADD VALIDATIONS COMMON:
    *id of model not present    
    */
    public abstract void canBeAdded(Model m);
    
    /* 
    UPDATE VALIDATIONS COMMON:
    *id of model is present 
    *id of model is valid 
    */    
    public abstract void canBeUpdated(Model m);
    
     /* 
    DELETE VALIDATIONS COMMON:   
    *id of model is valid 
    */
    public abstract void canBeDeleted(long id);
   
}
