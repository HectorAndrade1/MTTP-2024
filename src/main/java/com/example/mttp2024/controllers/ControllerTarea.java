package com.example.mttp2024.controllers;

import com.example.mttp2024.database.Database;
import com.example.mttp2024.models.Evento;
import com.example.mttp2024.models.Tarea;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ControllerTarea {
    private Database db;

    public ControllerTarea(){
        db = new Database();
    }

    public Tarea recuperarTarea(int id) throws SQLException {
        try (Connection con = db.connection()){
            String query = String.format("SELECT * From tarea WHERE id_tarea = %d",id);

            PreparedStatement statement = con.prepareStatement(query);

            ResultSet resultado = statement.executeQuery();
            if (resultado.next()){
                resultado.getInt("id_evento");
                int id_tarea = resultado.getInt("id_evento");
                String nombre_tarea = resultado.getString("nombre_tarea");
                String descripcion_tarea = resultado.getString("descripcion_tarea");
                int prioridad_tarea = resultado.getInt("prioridad_tarea");
                String fecha_entrega_tarea = resultado.getString("fecha_entrega_tarea");

                LocalDate fecha = parseFecha(fecha_entrega_tarea);
                Tarea tarea = new Tarea(id_tarea, nombre_tarea, descripcion_tarea, prioridad_tarea, fecha);
                return tarea;
            }
        }
        return null;
    }


    public ArrayList<Tarea> mostrarTareas() throws SQLException {
        ArrayList<Tarea> tareas = new ArrayList<>();

        try (Connection con= db.connection();){
            String query ="SELECT * FROM tarea";
            PreparedStatement statement = con.prepareStatement(query);

            ResultSet resultado = statement.executeQuery();
            while (resultado.next()) {
                resultado.getInt("id_evento");
                int id_tarea = resultado.getInt("id_evento");
                String nombre_tarea = resultado.getString("nombre_tarea");
                String descripcion_tarea = resultado.getString("descripcion_tarea");
                int prioridad_tarea = resultado.getInt("prioridad_tarea");
                String fecha_entrega_tarea = resultado.getString("fecha_entrega_tarea");

                LocalDate fecha= parseFecha(fecha_entrega_tarea);

                // Crear un nuevo objeto Evento y agregarlo a la lista
                Tarea tarea = new Tarea(id_tarea, nombre_tarea, descripcion_tarea, prioridad_tarea, fecha);
                tareas.add(tarea);
            }
        }
        return tareas;
    }


    // Método para convertir una cadena de texto a LocalDate
    public LocalDate parseFecha(String fecha) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(fecha, formatter);
    }

    // Método  para convertir una cadena de texto a LocalTime
    public LocalTime parseHora(String hora) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        return LocalTime.parse(hora, formatter);
    }
}
