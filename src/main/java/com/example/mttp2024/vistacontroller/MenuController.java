package com.example.mttp2024.vistacontroller;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuController implements Initializable{

    private Stage stage;

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

    public void setStage(Stage primarystage){
        stage=primarystage;
    }

    @FXML
    void btnAsignaturaButtonClick(ActionEvent event) throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("resources/com/example/mttp2024/opciones 1.fxml"));
        Scene scene=new Scene(loader.load());
        Opciones1Controller opciones1=loader.getController();
        Scene scene1=new Scene(loader.load());
        Stage stage1=new Stage();
        stage1.setScene(scene1);
        stage1.show();


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
        //TODO
    }
}

