/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ultimatesoftware.controllers;

import io.ultimatesoftware.sghc.ConnectionFile;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressIndicator;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.controlsfx.control.NotificationPane;
import org.controlsfx.control.textfield.CustomPasswordField;
import org.controlsfx.control.textfield.CustomTextField;

import java.io.IOException;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * FXML Controller class
 *
 * @author Soporte
 */
public class LoginController implements Initializable {

    @FXML
    private CustomTextField txtUser;
    @FXML
    private CustomPasswordField txtPassword;
    @FXML
    private Button btnLogin;
    @FXML
    private ProgressIndicator ctrProgress;
    @FXML
    private Button btnParameters;
    @FXML
    private NotificationPane npNotification;
    private String error;
    private String testMessage;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ctrProgress.setVisible(false);

    }

    @FXML
    private void ShowParameters() {
        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/ConnectionParameters.fxml"));
            Scene scene = new Scene(root);
            stage.setTitle("Parámetros de conexión");
            stage.setResizable(false);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.show();

        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void Login(ActionEvent event) {

        /*ctrProgress.setVisible(true);
        if (testConnectionDb()) {
            connectHibernateThread(event);
            showHome(event);
        } else {
            Message m = new Message();
            m.showMessage("Error", "No se ha podido conectar a la base de datos: " + testMessage, Alert.AlertType.ERROR);
            testMessage = "";
        }*/
    }



    private boolean testConnectionDb() {
        boolean connection=false;
        ConnectionFile conf = new ConnectionFile();
        if (!conf.getPropertiesFile().isEmpty()) {
            Properties prop = conf.getPropertiesFile();
            String username = prop.getProperty("hibernate.connection.username");
            String url = prop.getProperty("hibernate.connection.url");
            String password = prop.getProperty("hibernate.connection.password");
            try {
                DriverManager.getConnection(url, username, password).close();
                connection = true;
            } catch (SQLException e) {
                e.printStackTrace();
                testMessage = e.toString();
                connection = false;
            }
        }else {
            error = "No existe un archivo de configuracion, dirigase a la opcion de parametros para crear uno.";
        }
        return connection;
    }

    /*private void connectHibernateThread(ActionEvent event) {

        Task<Void> t = new Task<Void>() {
            @Override
            protected Void call() throws Exception {


                ConnectionFile conf = new ConnectionFile();
                if (!conf.getPropertiesFile().isEmpty()) {
                    //si usuario correcto ocultar login y mostrar home

                    SecUserDao uDao = new SecUserDao();
                    SecUser user = new SecUser();
                    user = uDao.getSecUserByPassword(txtUser.getText().trim(), txtPassword.getText());
                    if (user == null) {
                        error = "No existe usuario/clave.";
                    } else {
                        error = "ok";
                    }

                } else {
                    error = "No existe un archivo de configuracion, dirigase a la opcion de parametros para crear uno.";
                }
                ctrProgress.setVisible(false);
                return null;
            }
        };
        t.setOnSucceeded(e -> {
            if (!error.equals("ok")) {
                Message m = new Message();
                m.showMessage("Error", error, Alert.AlertType.ERROR);
            }
        });
        new Thread(t).start();
    }*/
}
