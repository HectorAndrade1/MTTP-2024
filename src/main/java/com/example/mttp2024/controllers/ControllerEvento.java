package com.example.mttp2024.controllers;

import com.example.mttp2024.database.Database;
import com.example.mttp2024.models.Evento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ControllerEvento {

    private Database db;

    public ControllerEvento(){
        db= new Database();

    }

    public Evento recuperarEvento(int id) throws SQLException {
        try ( Connection con= db.connection()){
            String query= String.format("SELECT * From evento WHERE id_evento= %d",id);

            PreparedStatement statement= con.prepareStatement(query);

            ResultSet resultado= statement.executeQuery();
            if (resultado.next()){
                resultado.getInt("id_evento");
                int id_evento=resultado.getInt("id_evento");
                String nombre_evento= resultado.getString("nombre_evento");
                String descripcion_evento=resultado.getString("descripcion_evento");
                String fecha_evento = resultado.getString("fecha_evento");
                String hora_inicio_evento = resultado.getString("hora_inicio_evento");
                String hora_fin_evento = resultado.getString("hora_fin_evento");

                LocalDate fecha= parseFecha(fecha_evento);
                LocalTime inicio= parseHora(hora_fin_evento);
                LocalTime fin= parseHora(hora_fin_evento);
                Evento evento=new Evento(id,nombre_evento,descripcion_evento,fecha,inicio,fin);
                return evento;
            }
        }

        return null;
    }


    public ArrayList<Evento> mostrarEventos() throws SQLException {
        ArrayList<Evento> eventos=new ArrayList<>();

        try (Connection con= db.connection();){
            String query="SELECT * FROM evento";
            PreparedStatement statement= con.prepareStatement(query);

            ResultSet resultado= statement.executeQuery();
            while (resultado.next()) {
                int idEvento = resultado.getInt("id_evento");
                String nombreEvento = resultado.getString("nombre_evento");
                String descripcionEvento = resultado.getString("descripcion_evento");
                String fechaEvento = resultado.getString("fecha_evento");
                String horaInicioEvento = resultado.getString("hora_inicio_evento");
                String horaFinEvento = resultado.getString("hora_fin_evento");
                String ubicacion = resultado.getString("ubicacion");

                LocalDate fecha= parseFecha(fechaEvento);
                LocalTime inicio= parseHora(horaInicioEvento);
                LocalTime fin=parseHora(horaFinEvento);
                // Crear un nuevo objeto Evento y agregarlo a la lista
                Evento evento = new Evento(idEvento, nombreEvento, descripcionEvento, fecha,inicio,fin);
                eventos.add(evento);
            }
        }


        return eventos;
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
