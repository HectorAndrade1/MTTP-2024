package com.example.mttp2024.controllers;

import com.example.mttp2024.database.Database;
import com.example.mttp2024.exceptions.ExisteException;
import com.example.mttp2024.models.Evento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.List;

public class EventoController {

    private Database dataBase;

    private List<Evento> listaeventos = new ArrayList<>();

    public EventoController() {
        dataBase = new Database();
    }

    public List<Evento> getListaEvento(){
        return listaeventos;
    }
    public void crearEventoEnDatabase(String nombreEvento, String descripcionEvento,String ubicacion,String fecha,String horaInicio,String horaFin) throws SQLException{
        try {
            if (existe(nombreEvento)) {
                throw new ExisteException("El nombre del evento ya existe");
            } else {
                try (Connection conection=dataBase.connection()) {
                    String query = String.format("INSERT INTO evento (nombre_evento,descripcion_evento,fecha_evento,hora_inicio_evento,hora_fin_evento,ubicacion) VALUES ('%s','%s','%s','%s','%s','%s')",nombreEvento , descripcionEvento , fecha , horaInicio , horaFin , ubicacion );
                    PreparedStatement statement = conection.prepareStatement(query);
                    ResultSet resultado=statement.executeQuery();
                    if(resultado.next()){
                        System.out.println("Evento agreagado con exito");
                    }
                    else {
                        System.out.println("No se pudo agregar el evento");
                    }
                }
            }
        } catch (ExisteException x) {
            System.out.println(x.toString());
        }
    }
    public void eliminarEventoDeDatabase(int id) throws SQLException{
        try (Connection conection=dataBase.connection()){
            String query= String.format("DELETE * From evento WHERE id_evento= %d",id);
            PreparedStatement statement=conection.prepareStatement(query);
            ResultSet resultado=statement.executeQuery();
        }
    }

    public Evento recuperarEventoDeDataBaseMedianteID(int id) throws SQLException{
        try (Connection conection=dataBase.connection()){
            String query= String.format("SELECT * From evento WHERE id_evento= %d",id);
            PreparedStatement statement=conection.prepareStatement(query);
            ResultSet resultado=statement.executeQuery();
            if(resultado.next()){
                int id_evento=resultado.getInt("id_evento");
                String nombre_evento= resultado.getString("nombre_evento");
                String descripcion_evento=resultado.getString("descripcion_evento");
                String fecha_evento = resultado.getString("fecha_evento");
                String hora_inicio_evento = resultado.getString("hora_inicio_evento");
                String hora_fin_evento = resultado.getString("hora_fin_evento");
                String ubicacion=resultado.getString("ubicacion");
                LocalDate fechaevento=formatoFecha(fecha_evento);
                LocalTime horaInicioEvento=formatoHora(hora_inicio_evento);
                LocalTime horaFinEvento=formatoHora(hora_fin_evento);
                if(ubicacion!=null){
                    Evento evento=new Evento(id_evento,nombre_evento,descripcion_evento,ubicacion,fechaevento,horaInicioEvento,horaFinEvento);
                    return evento;
                }else {
                    Evento evento=new Evento(id_evento,nombre_evento,descripcion_evento,fechaevento,horaInicioEvento,horaFinEvento);
                    return evento;
                }
            }
        }
        return null;
    }


    public boolean existe(String target) throws SQLException {
         try (Connection conection=dataBase.connection()){
                String query= String.format("SELECT nombre_evento From evento WHERE EXISTS (SELECT nombre_evento FROM evento WHERE nombre_evento= '%s')",target);
                PreparedStatement statement=conection.prepareStatement(query);
                ResultSet result=statement.executeQuery();
             return result.next();
         }
    }
    public LocalDate formatoFecha(String texto){
        DateTimeFormatter dateformat = new DateTimeFormatterBuilder().append(DateTimeFormatter.ofPattern("yyyy-MM-dd")).toFormatter();
        return LocalDate.parse(texto, dateformat);
    }
    public LocalTime formatoHora(String texto){
        DateTimeFormatter horaformat = new DateTimeFormatterBuilder().append(DateTimeFormatter.ofPattern("HH:mm")).toFormatter();
        return LocalTime.parse(texto, horaformat);
    }

    public void modificarEventoEnDatabase(int id, String atributo, String nuevovalor) throws SQLException {
        try (Connection conection=dataBase.connection()){
            String query=String.format("UPDATE evenyo SET %s='%s' WHERE id_evento=%d",atributo,nuevovalor,id);
            PreparedStatement statement=conection.prepareStatement(query);
            ResultSet resultado=statement.executeQuery();

        }

    }


    public void listarEventos() throws SQLException {
        try (Connection connection = dataBase.connection()) {
            String query = "SELECT id_evento FROM evento";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultado = statement.executeQuery();
            while (resultado.next()) {
                int idEvento = resultado.getInt("id_evento");
                listaeventos.add(recuperarEventoDeDataBaseMedianteID(idEvento));
            }
        }
    }

}
