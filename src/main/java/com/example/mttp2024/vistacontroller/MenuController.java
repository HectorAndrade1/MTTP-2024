package com.example.mttp2024.vistacontroller;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuController implements Initializable{

    @FXML
    private Button botonasignaturas;

    @FXML
    private Button botonclase;

    @FXML
    private Button botonevento;

    @FXML
    private Button botontareas;

    @FXML
    private Tab tabAsignaturas;

    @FXML
    private Tab tabClases;

    @FXML
    private Tab tabEventos;

    @FXML
    private Tab tabHorario;

    @FXML
    private Tab tabTareas;

    @FXML
    void btnAsignaturaButtonClick(ActionEvent event){
        try {
            FXMLLoader loader=new FXMLLoader();
            loader.setLocation(getClass().getResource("opciones 1.fxml"));
            Opciones1Controller opciones1Controller=loader.getController();
            Scene scene=new Scene(loader.load());
            Stage stage=new Stage();
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
        }catch (IOException e){
            e.printStackTrace(System.out);
        }
    }

    @FXML
    void btnClaseButtonClick(ActionEvent event) {

    }

    @FXML
    void btnEventoButtonCLick(ActionEvent event) {

    }

    @FXML
    void btnTareaButtonClick(ActionEvent event) {

    }

    @FXML
    void tabAsignaturasSelected(Event event) {

    }

    @FXML
    void tabClasesSelected(Event event) {

    }

    @FXML
    void tabEventosSelected(Event event) {

    }

    @FXML
    void tabHorarioSelected(Event event) {

    }

    @FXML
    void tabTareasSelected(Event event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        
    }
}

