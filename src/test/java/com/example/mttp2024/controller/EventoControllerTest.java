package com.example.mttp2024.controller;

import com.example.mttp2024.controllers.ControllerEvento;
import com.example.mttp2024.controllers.EventoController;
import com.example.mttp2024.controllers.TareaController;
import com.example.mttp2024.models.Evento;
import com.example.mttp2024.models.Tarea;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class EventoControllerTest {

    @Test
    void existe_DeberiaRetornarTrueFalse()throws SQLException {
        //Arrange
        EventoController ec=new EventoController();

        //Act
        boolean resultado=ec.existe("prueba");

        //Assert
        assertTrue(resultado,"El evento no existe");
    }

    @Test
    void recuperarIdEventoPorNombre_DeberiaRetornarID() throws SQLException{
        //Arrange
        EventoController ec=new EventoController();

        //Act
        int idRecuperado=ec.recuperarIdEventoPorNombre("prueba");

        //Assert
        assertEquals(4,idRecuperado,"El id no coincide");
    }

    @Test
    void recuperarEventoDeDataBaseMedianteID_DeberiaRetornarEvento() throws SQLException {
        //Arrange
        EventoController ec = new EventoController();

        //Act
        Evento evento = ec.recuperarEventoDeDataBaseMedianteID(2);

        //Assert
        assertNotNull(evento,"El evento no existe");
    }

    @Test
    void listarEventoPrueba()throws SQLException{
        //Arrange
        EventoController ec=new EventoController();

        //Act
        ArrayList<Evento> eventos=ec.listarEventos();

        //Assert
        assertNotNull(eventos,"Lista vacia");
    }

    @Test
    void crearEvento_DeberiaAgreagarEventosADatabase() throws SQLException{
        //Arrange
        EventoController ec=new EventoController();

        //Act
        ec.crearEventoEnDatabase("nombre","descripcion",null,"2020-01-01","12:00:00","12:30:00");

        //Assert
        boolean existe= ec.existe("nombre");
        assertTrue(existe,"Evento no agregado");
    }

    @Test
    void modificarEventoEnDatabase_DeberiaModificarAtributos() throws SQLException{
        //Arrange
        EventoController ec=new EventoController();

        //Act
        ec.modificarEventoEnDatabase(ec.recuperarIdEventoPorNombre("nombre"),"ubicacion","nuevaubicacion");

        //Assert
        String ubicacion=ec.recuperarEventoDeDataBaseMedianteID(ec.recuperarIdEventoPorNombre("nombre")).getUbicacion();
        assertEquals(ubicacion,"nuevaubicacion");
    }

    @Test
    void eliminarEvento_DeberiaEliminarEventosDeDatabase() throws SQLException {
        //Arrange
        EventoController ec = new EventoController();

        //Act
        ec.eliminarEventoDeDatabase(ec.recuperarIdEventoPorNombre("nombre"));

        //Assert
        boolean existe = ec.existe("nombre");
        assertFalse(existe, "Evento no eliminado");
    }

}
