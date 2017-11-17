/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.switer.exceptions.errors;

/**
 *
 * @author Palina_Piarlukhina
 */
public enum UserError {
    //ID VALIDATION
    NOT_VALID_ID(new ErrorDTO( 1, "Id is not valid.")),
    ID_USED(new ErrorDTO( 2, "Id is already used.")),
    ID_MISSED(new ErrorDTO( 3, "Id is missing.")),
    NO_USER(new ErrorDTO(7, "User with such id is not found")),
    NO_ADD_ID(new ErrorDTO(10, "You can not set or edit id of employee")),
    
    //EMAIL VALIDATION
    NOT_VALID_EMAIL(new ErrorDTO( 4, "Email not valid.")),
    EMAIL_USED(new ErrorDTO(5, "Email already used.")),
    EMAIL_MISSED(new ErrorDTO(6, "Email is missing.")),
    
    //PASSWORD VALIDATION
    NO_PASSWORD(new ErrorDTO( 8, "Password is missing.")),
    PASSWORD_NOT_VALID(new ErrorDTO( 9, "Password is too simple."));
    
    
    private final ErrorDTO err;

    private UserError(ErrorDTO err) {
        this.err = err;
    }  

    public ErrorDTO getErr() {
        return err;
    }
    
    
    
    
    
}
