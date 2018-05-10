/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ultimatesoftware.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * FXML Controller class
 *
 * @author chiti
 */
public class HomeController implements Initializable {

    @FXML
    private Button btnRegisterPatient;
    @FXML
    private Button btnSearchPatient;
    private RegistroInformacionController controllerRegistro ;
    public SearchPatientController controllerSearch;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        //controllerSearch.init(this);
    }

    @FXML
    private void showRegisterPatient(ActionEvent event) throws IOException {

        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/RegistroInformacion.fxml"));
        //loader.setLocation(getClass().getResource("/fxml/RegistroInformacion.fxml"));


        //Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/fxml/RegistroInformacion.fxml")));
        Scene scene = new Scene(loader.load());

        stage.setScene(scene);
        scene.getStylesheets().add("/styles/validation.css");
        stage.setResizable(false);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();

    }

    @FXML
    private void showSearchPatient(ActionEvent event) throws IOException {
/*        HiddenSidesPane p = (HiddenSidesPane) ((Node) event.getSource()).getScene().getRoot();
        FadeTransitionController fade = new FadeTransitionController("/fxml/SearchPatient.fxml", 1000, p);
        fade.start();
        */

        Stage stage = new Stage();
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/fxml/SearchPatient.fxml")));
        stage.setScene(scene);
        stage.setResizable(false);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }
    public Boolean asd(){
        return true;
    }

}
