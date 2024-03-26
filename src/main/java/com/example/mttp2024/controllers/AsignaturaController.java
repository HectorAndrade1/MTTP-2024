package com.example.mttp2024.controllers;

import com.example.mttp2024.database.Database;
import com.example.mttp2024.models.Asignatura;
import com.example.mttp2024.models.Evento;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class AsignaturaController {

    private Database db;

    public AsignaturaController(){
        db=new Database();
    }

    public void crearAsignatura(Asignatura asignatura){
        String nombre=asignatura.getNombreAsigatura();
        String query= String.format("INSERT INTO asignatura(nombre_asignatura) VALUES('%s') ",nombre);

        try ( Connection con= db.connection()){

            PreparedStatement statement= con.prepareStatement(query);

            // Ejecutar la consulta de inserción
            int filasInsertadas = statement.executeUpdate();

            // Verificar si la inserción fue exitosa
            if (filasInsertadas > 0) {
                System.out.println("Asignatura insertada correctamente.");
            } else {
                System.out.println("No se pudo insertar la asignatura.");
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error al insertar la asignatura: " + e.getMessage(), e);
        }
    }


    public ArrayList<Asignatura> mostrarAsignaturas() throws SQLException {
        ArrayList<Asignatura> asignaturas=new ArrayList<>();

        try (Connection con= db.connection();){
            String query="SELECT * FROM asignatura";
            PreparedStatement statement= con.prepareStatement(query);

            ResultSet resultado= statement.executeQuery();
            while(resultado.next()) {
                int idAsignatura = resultado.getInt("id_asignatura");
                String nombreAsignatura = resultado.getString("nombre_asignatura");

                // Crear un nuevo objeto Asignatura y agregar a la lista
                Asignatura asignatura= new Asignatura(idAsignatura,nombreAsignatura) ;
                asignaturas.add(asignatura);

            }
        }
        return asignaturas;
    }



    public Asignatura mostrarAsignatura(int id) throws SQLException {

        try (Connection con= db.connection();){
            String query=String.format("SELECT * FROM asignatura WHERE id_asignatura=%d",id);
            PreparedStatement statement= con.prepareStatement(query);

            ResultSet resultado= statement.executeQuery();
            if (resultado.next()) {
                int idAsignatura = resultado.getInt("id_asignatura");
                String nombreAsignatura = resultado.getString("nombre_asignatura");

                // Crear un nuevo objeto Asignatura
                Asignatura asignatura= new Asignatura(idAsignatura,nombreAsignatura) ;
                return asignatura;
            }
        }
        return null;
    }

    public void actualizarAsignatura(int id,String nuevo) throws SQLException {
        String query=String.format("UPDATE asignatura SET nombre_asignatura = '%s' WHERE id_asignatura = %d",nuevo,id);

        try (Connection con= db.connection()){
            try (Statement statement = con.createStatement()) {
                // Ejecutamos la consulta SQL
                int filasActualizadas = statement.executeUpdate(query);

                // Verificamos si se actualizó al menos una fila
                if (filasActualizadas > 0) {
                    System.out.println("Asignatura actualizada exitosamente.");
                } else {
                    System.out.println("No se encontró ninguna asignatura con el ID especificado.");
                }
            }

        }catch (SQLException e) {
            // Manejo de errores de SQL
            System.err.println("Error al actualizar la asignatura: " + e.getMessage());
        }
    }



}
