package com.example.mttp2024.controllers;

import com.example.mttp2024.database.Database;
import com.example.mttp2024.models.Clase;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ControllerClase {

    private Database db;

    public ControllerClase() {
        db = new Database();
    }

    public Clase recuperarClase(int id) throws SQLException {
        try ( Connection con= db.connection()){
            String query= String.format("SELECT * From evento WHERE id_clase= %d",id);

            PreparedStatement statement= con.prepareStatement(query);

            ResultSet resultado= statement.executeQuery();

            if (resultado.next()){
                resultado.getInt("id_clase");

                int id_evento=resultado.getInt("id_evento");
                String diaSemana_clase= resultado.getString("diaSemana_clase");
                String hora_inicio_clase = resultado.getString("hora_inicio_clase");
                String hora_fin_clase = resultado.getString("hora_fin_clase");

                LocalTime inicio= parseHora(hora_inicio_clase);
                LocalTime fin= parseHora(hora_fin_clase);
                Clase evento=new Clase(id,diaSemana_clase,inicio,fin);
                return evento;
            }
        }

        return null;
    }
    public ArrayList<Clase> mostrarClases() throws SQLException {
        ArrayList<Clase> clases=new ArrayList<>();

        try (Connection con= db.connection();){
            String query="SELECT * FROM clase";
            PreparedStatement statement= con.prepareStatement(query);

            ResultSet resultado= statement.executeQuery();
            while (resultado.next()) {
                int idClase = resultado.getInt("id_clase");

                String diaSemanaClase= resultado.getString("diaSemana_clase");
                String horaInicioClase = resultado.getString("hora_inicio_evento");
                String horaFinClase = resultado.getString("hora_fin_evento");

                LocalTime inicio= parseHora(horaInicioClase);
                LocalTime fin=parseHora(horaFinClase);
                // Crear un nuevo objeto Clase y agregarlo a la lista
                Clase clase = new Clase(idClase,diaSemanaClase,inicio,fin);
                clases.add(clase);
            }
        }

        return clases;
    }


    // Método  para convertir una cadena de texto a LocalTime
    public LocalTime parseHora(String hora) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        return LocalTime.parse(hora, formatter);
    }
}
