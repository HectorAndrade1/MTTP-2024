package com.example.mttp2024.vistacontroller;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class MenuController {

    @FXML
    private MenuItem agregarasignatura;

    @FXML
    private MenuItem agregarclase;

    @FXML
    private MenuItem agregarevento;

    @FXML
    private MenuItem agregartarea;

    @FXML
    private MenuItem eliminarasignatura;

    @FXML
    private MenuItem eliminarclase;

    @FXML
    private MenuItem eliminarevento;

    @FXML
    private MenuItem eliminartarea;

    @FXML
    private MenuItem modificarAsignatura;

    @FXML
    private MenuItem modificarclase;

    @FXML
    private MenuItem modificarevento;

    @FXML
    private MenuItem modificartarea;

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
    private TableView<?> tablahorario;

    @FXML
    void btnAgregarAsignaturaClick(ActionEvent event) throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("agregarasignatura.fxml"));
            URL fxmlUrl = getClass().getResource("com/example/mttp2024/agregarasignatura.fxml");
            System.out.println("Ruta del recurso cargado: " + fxmlUrl);
            Parent root=loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }


    }

    @FXML
    void btnAgregarClaseClick(ActionEvent event) {

    }

    @FXML
    void btnAgregarEventoClick(ActionEvent event) {

    }

    @FXML
    void btnAgregarTareaClick(ActionEvent event) {

    }

    @FXML
    void btnEliminarAsignaturaClick(ActionEvent event) {

    }

    @FXML
    void btnEliminarClaseClick(ActionEvent event) {

    }

    @FXML
    void btnEliminarEventoClick(ActionEvent event) {

    }

    @FXML
    void btnEliminarTareaClick(ActionEvent event) {

    }

    @FXML
    void btnModificarAsignaturaClick(ActionEvent event) {

    }

    @FXML
    void btnModificarClaseClick(ActionEvent event) {

    }

    @FXML
    void btnModificarEventoClick(ActionEvent event) {

    }

    @FXML
    void btnModificarTareaClick(ActionEvent event) {

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

