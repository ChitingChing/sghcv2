/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ultimatesoftware.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ResourceBundle;

import io.ultimatesoftware.entities.Embarazo;
import io.ultimatesoftware.entities.Paciente;
import io.ultimatesoftware.sghc.Connection;
import io.ultimatesoftware.sghc.Message;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.controlsfx.control.textfield.CustomTextField;

import javax.persistence.EntityManager;

/**
 * FXML Controller class
 *
 * @author chiti
 */
public class SearchPatientController implements Initializable {
    private RegistroInformacionController controllerRegistro ;


    public CustomTextField txtNombres;
    public CustomTextField txtCedula;
    public TableView tblPacientes;
    public Button btnBuscar;
    public TableColumn colIdentificacion;
    public TableColumn colPrimerNombre;
    public TableColumn colPrimerApellido;
    public TableColumn colSegundoNombre;
    public TableColumn colSegundoApellido;
    public TableColumn colHistorial;
    public TableColumn colTelefono;
    public RadioButton rdbCedula;
    public RadioButton rdbNombres;
    public Button btnNuevoEmbarazo;
    public Button btnNuevoPaciente;
    public TableView tblVisitas;
    //
    public TableColumn colFechaVisita;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        colIdentificacion.setCellValueFactory(new PropertyValueFactory<Paciente, String>("Identificacion"));
        colPrimerNombre.setCellValueFactory(new PropertyValueFactory<Paciente, String>("primerNombre"));
        colPrimerApellido.setCellValueFactory(new PropertyValueFactory<Paciente, String>("primerApellido"));
        colSegundoNombre.setCellValueFactory(new PropertyValueFactory<Paciente, String>("segundoNombre"));
        colTelefono.setCellValueFactory(new PropertyValueFactory<Paciente, String>("telefono1"));
        colHistorial.setCellValueFactory(new PropertyValueFactory<Paciente, String>("nHistorialClinico"));
        colSegundoApellido.setCellValueFactory(new PropertyValueFactory<Paciente, String>("segundoApellido"));

        colFechaVisita.setCellValueFactory(new PropertyValueFactory<Embarazo,String>("fechaRegistro"));
        tblPacientes.setRowFactory(param -> {
            TableRow<Paciente> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if(!row.isEmpty() && event.getClickCount()==2) {
                   tblVisitas.setItems(getVisitas(row.getItem().getId().toString()));
                }
            });
            return row;
        });


        
    }

    public void buscarPacientes(ActionEvent actionEvent) {
        try {
            String sql;
            if(rdbCedula.isSelected()){
                sql= "FROM Paciente p where p.identificacion like '%"+txtCedula.getText().trim()+"%'";
            }
            else {
                sql= "FROM Paciente p where " +
                     "concat (p.primerNombre,' ',p.segundoNombre,' ',p.primerApellido,' ',p.segundoApellido) " +
                     "like '%"+txtNombres.getText().trim()+"%'";
            }

            EntityManager em = Connection.emf.createEntityManager();
            ObservableList<Paciente> pacienteList= FXCollections.observableArrayList(em.createQuery(sql).getResultList());
            tblPacientes.setItems(pacienteList);
            em.close();
        }catch  (Exception ex)
        {
            Message m = new Message();
            m.showMessage("Error",ex.getMessage(),Alert.AlertType.ERROR);
        }

    }
    public ObservableList<Embarazo> getVisitas(String IdPaciente ) {
        ObservableList<Embarazo> listaEmbarazo=null;
        try {
            EntityManager em = Connection.emf.createEntityManager();
            listaEmbarazo = FXCollections.observableArrayList(
                    em.createQuery(
                            "Select e From Embarazo e where e.paciente.id ='" + IdPaciente + "' order by e.fechaRegistro desc")
                            .getResultList());
            em.close();
        } catch (Exception ex) {
            Message m = new Message();
            m.showMessage("Error", ex.getMessage(), Alert.AlertType.ERROR);
        }
        return listaEmbarazo;
    }
    public void showNuevoEmbarazo() throws IOException {
        if(!tblPacientes.getSelectionModel().isEmpty()){
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/RegistroInformacion.fxml"));
            //loader.setLocation(getClass().getResource("/fxml/RegistroInformacion.fxml"));
            //Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/fxml/RegistroInformacion.fxml")));
            Scene scene = new Scene(loader.load());
            controllerRegistro = loader.getController();
            Paciente p = (Paciente) tblPacientes.getSelectionModel().getSelectedItem();
            controllerRegistro.init(p.getId());
            stage.setScene(scene);
            scene.getStylesheets().add("/styles/validation.css");
            stage.setResizable(false);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();

            Stage stageSearch = (Stage) txtNombres.getScene().getWindow();
            stageSearch.close();

        }
    }


}
