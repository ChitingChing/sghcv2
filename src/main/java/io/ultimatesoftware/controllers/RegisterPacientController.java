/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ultimatesoftware.controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import io.ultimatesoftware.sghc.FxUtils;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;
import org.controlsfx.control.CheckComboBox;
import org.controlsfx.control.PrefixSelectionComboBox;
import org.controlsfx.control.textfield.TextFields;

/**
 * FXML Controller class
 *
 * @author chiti
 */
public class RegisterPacientController implements Initializable {


    public PrefixSelectionComboBox cmbStudy;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ObservableList<String> options =
                FXCollections.observableArrayList(
                        "Option 1",
                        "asdn 2",
                        "afc 3"
                );
        cmbStudy.getItems().addAll(options);
        cmbStudy.getSelectionModel().selectFirst();
    }


    public void checkIfExist(InputMethodEvent inputMethodEvent) {

    }
}
