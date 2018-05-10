package io.ultimatesoftware.controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import org.controlsfx.control.HiddenSidesPane;

/**
 * FXML Controller class
 *
 * @author Soporte
 */
public class SidePaneController implements Initializable {

    public StackPane logoPane;
    public Label txtEntity;
    @FXML
    private VBox sidePane;
    @FXML
    private Button btnHome;
    @FXML
    private Label lblUserLetter;
    @FXML
    private Button btnUserConfig;
    @FXML
    private Button btnSystemConfig;
    @FXML
    private Button btnSearchPacient;

    /**
     *
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        /*SecEntityDao eDao = new SecEntityDao();
        Entidad entity = eDao.getSecEntity();
        txtEntity.setText(entity.getDescripcion());*/

    }

    @FXML
    private void showHome(ActionEvent event) {
        HiddenSidesPane p = (HiddenSidesPane) ((Node) event.getSource()).getScene().getRoot();
        FadeTransitionController fade = new FadeTransitionController("/fxml/Home.fxml", 1000, p);
        fade.start();
    }

    @FXML
    private void showSearchPatient(ActionEvent event) {
        HiddenSidesPane p = (HiddenSidesPane) ((Node) event.getSource()).getScene().getRoot();
        FadeTransitionController fade = new FadeTransitionController("/fxml/SearchPatient.fxml", 1000, p);
        fade.start();
    }

}
