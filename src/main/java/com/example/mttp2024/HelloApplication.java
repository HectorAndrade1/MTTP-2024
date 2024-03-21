package com.example.mttp2024;

import com.example.mttp2024.controllers.TareaController;
import com.example.mttp2024.models.Asignatura;
import com.example.mttp2024.models.Clase;
import com.example.mttp2024.models.Evento;
import com.example.mttp2024.models.Tarea;
import com.example.mttp2024.utils.DataManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        /*/
        /    Ejemplo de creación y guardado de Datos en formato JSON
        /*/

        /*
        DataManager data = new DataManager();

        Evento evento01 = new Evento(
                "Bautismo",
                "Alfonso me solicito uno",
                "Calle Aguayo #121",
                LocalDate.of(2024, 4, 1),
                LocalTime.of(14, 0),
                LocalTime.of(15, 0)
        );
        Evento evento02 = new Evento(
                "Exorcismo",
                "Alondra me solicito uno",
                "Av. Charco #666",
                LocalDate.of(2024, 4, 2),
                LocalTime.of(23, 0),
                LocalTime.of(23, 59)
        );
        ArrayList<Tarea> tareas01 = new ArrayList<Tarea>();
        tareas01.add(new Tarea("Resumen Tema 1", "", 1, LocalDate.of(2024, 4, 2)));
        tareas01.add(new Tarea("Resumen Tema 2", "", 1, LocalDate.of(2024, 4, 11)));
        ArrayList<Clase> clases01 = new ArrayList<Clase>();
        clases01.add(new Clase("Lunes", LocalTime.of(8, 0), LocalTime.of(9, 0)));
        clases01.add(new Clase("Martes", LocalTime.of(8, 0), LocalTime.of(9, 0)));
        clases01.add(new Clase("Jueves", LocalTime.of(8, 0), LocalTime.of(9, 0)));
        Asignatura asignatura01 = new Asignatura("Liturgia II", tareas01, clases01);

        data.addEvento(evento01);
        data.addEvento(evento02);
        data.addAsignatura(asignatura01);

        data.guardarDatos();
         */

        /*/
        /    Ejemplo de lectura y recuperación de Datos JSON
        /*/

        DataManager data = new DataManager();
        data.cargarDatos();

        Evento eventoRecuperado = data.obtenerEventoPorNombre("Exorcismo");
        System.out.println("Evento recuperado: " + eventoRecuperado.getNombreEvento());
        System.out.println("    Descripción: " + eventoRecuperado.getDescripcionEvento());
        System.out.println("    Ubicación: " + eventoRecuperado.getUbicacion());
        System.out.println("    Fecha: " + eventoRecuperado.getFechaEvento());
        System.out.println("    Inicia: " + eventoRecuperado.getHoraInicioEvento());
        System.out.println("    Termina: " + eventoRecuperado.getHoraFinEvento());

        /*/
        /    Fin de ejemplos JSON
        /*/

        launch();
    }
}