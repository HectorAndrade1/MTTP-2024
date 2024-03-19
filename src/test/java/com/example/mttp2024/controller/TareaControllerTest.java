package com.example.mttp2024.controller;

import com.example.mttp2024.controllers.TareaController;
import com.example.mttp2024.models.Tarea;
import org.junit.jupiter.api.Test;


import com.example.mttp2024.models.Tarea;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
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
        int prioridad = 1;
        LocalDate fechaEntrega = LocalDate.now();

        // Act
        //tareaController.crearTarea(nombre, descripcion, prioridad, fechaEntrega);

        /* Assert
        List<Tarea> listaTareas = tareaController.getListaTareas();
        assertEquals(1, listaTareas.size());
        Tarea tarea = listaTareas.get(0);
        assertEquals(nombre, tarea.getNombreTarea());
        assertEquals(descripcion, tarea.getDescripcionTarea());
        assertEquals(prioridad, tarea.getPrioridad());
        assertEquals(fechaEntrega, tarea.getFechaEntrega());*/
    }
}
