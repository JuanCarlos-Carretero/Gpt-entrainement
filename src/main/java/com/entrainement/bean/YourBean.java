package com.entrainement.bean;

import javax.inject.Named;

import javax.enterprise.context.RequestScoped;
import javax.faces.event.ActionEvent;

@Named
@RequestScoped
public class YourBean {
    
    public void action(ActionEvent event) {
        System.out.println("Le boutton a ete cliquée!");
    }
}