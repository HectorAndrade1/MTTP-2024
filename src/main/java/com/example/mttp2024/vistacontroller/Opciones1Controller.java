package com.example.mttp2024.vistacontroller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Opciones1Controller {

    @FXML
    private Button botonAgregar;

    @FXML
    private Button botonEliminar;

    @FXML
    private Button botonModificar;

    @FXML
    void btnAgregarButtonClick(ActionEvent event) {

    }

    @FXML
    void btnEliminarButtonClick(ActionEvent event) {

    }

    @FXML
    void btnModificarButtonClick(ActionEvent event) {

    }

    private MenuController menucontrol;
    private Stage stage2;
    private String opciones[]={"Asignatura","Clase,Tarea,Evento"};
    public void init(int id, Stage stage1, MenuController menuController) {
        String seleccion=opciones[id];
        this.menucontrol=menuController;
        this.stage2=stage1;
    }
}