/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.switer.dao.validation;

import com.rest.switer.model.Model;

/**
 *
 * @author Palina_Piarlukhina
 */
public interface Validation {
    public abstract void canBeAdded(Model m);
    public abstract void canBeUpdated(Model m);
    public abstract Model canBeDeleted(long id);
    
   
}
