/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.switer.model;

/**
 *
 * @author Palina_Piarlukhina
 */
public class Message {
    private String title;
    private String text;

    public Message() {
    }

    public Message(String title, String text) {
        this.text = text;
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }  

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }   
    
}
