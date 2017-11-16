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
public class ErrorDTO {

    private int code;
    private String message;

    public ErrorDTO() {
    }

    public ErrorDTO(int code, String message) {
        this.code = code;
        this.message = message;

    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
