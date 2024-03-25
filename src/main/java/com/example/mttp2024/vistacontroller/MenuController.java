package com.example.mttp2024.vistacontroller;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import javax.xml.stream.Location;
import java.io.IOException;


public class MenuController {

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

    private Stage stage=new Stage();

    @FXML
    void btnAsignaturaButtonClick(ActionEvent event) throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("com/example/mttp2024/opciones 1.fxml"));
        Scene scene = new Scene(loader.load(),854,480);
        stage.setTitle("Organizador de Tareas");
        stage.setScene(scene);
        stage.show();
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
}

