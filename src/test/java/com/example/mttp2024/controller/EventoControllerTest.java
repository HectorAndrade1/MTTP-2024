package com.example.mttp2024.controller;

import com.example.mttp2024.controllers.EventoController;
import com.example.mttp2024.controllers.TareaController;
import com.example.mttp2024.models.Evento;
import com.example.mttp2024.models.Tarea;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class EventoControllerTest {
    @Test
    void crearTarea_DeberiaAgregarTareaALaLista() {
        // Arrange
        EventoController eventoController = new EventoController();
        String nombre = "Evento de prueba";
        String descripcion = "Descripción del evento de prueba";
        LocalDate fechaEvento=LocalDate.now();
        LocalTime horainicio=LocalTime.now();
        LocalTime horafin=LocalTime.now();

        // Act
        eventoController.crearEvento(nombre, descripcion, fechaEvento,horainicio,horafin);

        //Assert
        List<Evento> listaEvento = eventoController.listaeventos;
        assertEquals(1, listaEvento.size());
        Evento evento = listaEvento.get(0);
        assertEquals(nombre, evento.getNombreEvento());
        assertEquals(descripcion, evento.getDescripcionEvento());
        assertEquals(fechaEvento, evento.getFechaEvento());
        assertEquals(horainicio,evento.getHoraInicioEvento() );
        assertEquals(horafin,evento.getHoraFinEvento());
    }
    @Test
    void modificarEvento_DeberiaModificarelEvento(){
        //Arrange
        EventoController eventoController = new EventoController();
        String nombre = "Evento de prueba";
        String descripcion = "Descripción del evento de prueba";
        LocalDate fechaEvento=LocalDate.now();
        LocalTime horainicio=LocalTime.now();
        LocalTime horafin=LocalTime.now();

        eventoController.crearEvento(nombre, descripcion, fechaEvento,horainicio,horafin);
        List<Evento> listaEventos=eventoController.listaeventos;

        String newnombre = "Nuevo evento de prueba";
        String newdescripcion = "Nueva descripción del evento de prueba";
        String newubicacion="nueva ubicacion";
        String newfechaEvento="2024-10-01";
        String newhorainicio="12:00";
        String newhorafin="12:30";
        LocalDate fecha=eventoController.formatoFecha(newfechaEvento);
        LocalTime hora1=eventoController.formatoHora(newhorainicio);
        LocalTime hora2=eventoController.formatoHora(newhorafin);

        //Act
        eventoController.modificarEvento(nombre,"descripcionEvento",newdescripcion);
        eventoController.modificarEvento(nombre,"ubicacion",newubicacion);
        eventoController.modificarEvento(nombre,"fechaEvento",newfechaEvento);
        eventoController.modificarEvento(nombre,"horaInicioEvento",newhorainicio);
        eventoController.modificarEvento(nombre,"horaFinEvento",newhorafin);
        eventoController.modificarEvento(nombre,"nombreEvento",newnombre);

        //Assert
        Evento evento=listaEventos.get(0);
        assertEquals(newnombre, evento.getNombreEvento());
        assertEquals(newdescripcion, evento.getDescripcionEvento());
        assertEquals(fecha, evento.getFechaEvento());
        assertEquals(hora1,evento.getHoraInicioEvento() );
        assertEquals(hora2,evento.getHoraFinEvento());
        assertNotNull(evento.getUbicacion());
    }
    @Test
    void eliminarEvento_DeberiaEliminarEventodelaLista(){
        //Arrange
        EventoController eventoController = new EventoController();
        String nombre = "Evento de prueba";
        String descripcion = "Descripción del evento de prueba";
        LocalDate fechaEvento=LocalDate.now();
        LocalTime horainicio=LocalTime.now();
        LocalTime horafin=LocalTime.now();

        //Act
        eventoController.eliminarEvento(nombre);

        //Assert
        List<Evento> listaEvento=eventoController.listaeventos;
        assertEquals(0,listaEvento.size());
    }
}
