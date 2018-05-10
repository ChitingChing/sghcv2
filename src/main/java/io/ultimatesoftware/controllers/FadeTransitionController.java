/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ultimatesoftware.controllers;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.fxml.FXMLLoader;
import javafx.util.Duration;
import org.controlsfx.control.HiddenSidesPane;

/**
 *
 * @author Soporte
 */
public class FadeTransitionController {
    
    private String rutaFxmlName;
    private int miliseconds;
    private HiddenSidesPane hsp;

    public FadeTransitionController(String RutaFxmlName, int miliseconds, HiddenSidesPane hsp) {
        this.rutaFxmlName = RutaFxmlName;
        this.miliseconds = miliseconds;
        this.hsp = hsp;
    }
    
    
    
    public void start(){
       
        FadeTransition fade = new FadeTransition(Duration.millis(miliseconds));
        fade.setNode(hsp.getContent());
        fade.setFromValue(1);
        fade.setToValue(0);
        fade.play();
        fade.setOnFinished((eventFade) -> {
            try {
                hsp.setContent(FXMLLoader.load(getClass().getResource(rutaFxmlName)));
            } catch (IOException ex) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
    
}
