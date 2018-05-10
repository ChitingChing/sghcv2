package io.ultimatesoftware.controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;

import io.ultimatesoftware.sghc.ConnectionFile;
import io.ultimatesoftware.sghc.Message;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import org.controlsfx.control.textfield.CustomPasswordField;
import org.controlsfx.control.textfield.CustomTextField;

/**
 * FXML Controller class
 *
 * @author Soporte
 */
public  class ConnectionParametersController implements Initializable {


    public CustomTextField txtUrl;
    public CustomTextField txtUserDatabase;
    public CustomPasswordField txtPasswordDatabase;
    private Properties prop;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ConnectionFile con = new ConnectionFile();
        prop  = con.getPropertiesFile();
        if(prop.isEmpty()){
            ConnectionFile conF = new ConnectionFile();
            prop=conF.createPropertiesFile();
        }
        txtUrl.setText(prop.getProperty("hibernate.connection.url"));
        txtUserDatabase.setText(prop.getProperty("hibernate.connection.username"));
        txtPasswordDatabase.setText(prop.getProperty("hibernate.connection.password"));

    }
    public void saveData(){
        prop.setProperty("hibernate.connection.url",txtUrl.getText().trim());
        prop.setProperty("hibernate.connection.username",txtUserDatabase.getText().trim());
        prop.setProperty("hibernate.connection.password",txtPasswordDatabase.getText().trim());
        ConnectionFile conF = new ConnectionFile();
        String resultado= conF.saveProperties(prop);
        Message m = new Message();
        m.showMessage("Info",resultado, Alert.AlertType.INFORMATION);
    }

}
