package com.example.mttp2024.controller;

import com.example.mttp2024.controllers.TareaController;
import com.example.mttp2024.models.Tarea;
import org.junit.jupiter.api.Test;


import com.example.mttp2024.models.Tarea;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class TareaControllerTest {

    @Test
    void crearTarea_DeberiaAgregarTareaALaLista() {
        // Arrange
        TareaController tareaController = new TareaController();
        String nombre = "Tarea de prueba";
        String descripcion = "Descripción de la tarea de prueba";
        int prioridad=1;
        LocalDate fechaEntrega=LocalDate.now();

        // Act
        tareaController.crearTarea(nombre, descripcion, prioridad, fechaEntrega);

       //Assert
        List<Tarea> listaTareas = tareaController.listatareas;
        assertEquals(1, listaTareas.size());
        Tarea tarea = listaTareas.get(0);
        assertEquals(nombre, tarea.getNombreTarea());
        assertEquals(descripcion, tarea.getDescripcionTarea());
        assertEquals(prioridad, tarea.getPrioridad());
        assertEquals(fechaEntrega, tarea.getFechaEntrega());
    }

    @Test
    void modificarTarea_DeberiaModificarTarea(){
        //Arrange
        TareaController tareaController=new TareaController();

        String nombre="nombre";
        String descripcion="descripcion";
        int prioridad=1;
        LocalDate fecha=LocalDate.now();

        tareaController.crearTarea(nombre,descripcion,prioridad,fecha);

        String nuevonombre="nuevoNombre";
        String nuevadescripcion="nuevaDescripcion";
        String nuevaprioridad="4";
        int numerocomparar=Integer.parseInt(nuevaprioridad);
        String nuevafecha="2020-01-01";
        DateTimeFormatter formato = new DateTimeFormatterBuilder().append(DateTimeFormatter.ofPattern("yyyy-MM-dd")).toFormatter();
        LocalDate fechaparacomparar=LocalDate.parse(nuevafecha,formato);

        //Act
        tareaController.modificarTarea("nombre","descripcionTarea",nuevadescripcion);
        tareaController.modificarTarea("nombre","prioridad",nuevaprioridad);
        tareaController.modificarTarea("nombre","fechaEntrega",nuevafecha);
        tareaController.modificarTarea("nombre","nombreTarea",nuevonombre);

        //Assert
        List<Tarea> listaTarea=tareaController.listatareas;
        Tarea tarea=listaTarea.get(0);
        assertEquals(nuevonombre,tarea.getNombreTarea());
        assertEquals(nuevadescripcion,tarea.getDescripcionTarea());
        assertEquals(numerocomparar,tarea.getPrioridad());
        assertEquals(fechaparacomparar,tarea.getFechaEntrega());
    }

    @Test
    void eliminarTarea_DeberiaEliminarTareaDeLista(){
        // Arrange
        TareaController tareaController = new TareaController();
        String nombre = "Tarea de prueba";
        String descripcion = "Descripción de la tarea de prueba";
        int prioridad=1;
        LocalDate fechaEntrega=LocalDate.now();

        tareaController.crearTarea(nombre, descripcion, prioridad, fechaEntrega);

        //Act
        tareaController.eliminarTarea(nombre);

        //Assert
        List<Tarea> listaTarea=tareaController.listatareas;
        assertEquals(0,listaTarea.size());
    }
}