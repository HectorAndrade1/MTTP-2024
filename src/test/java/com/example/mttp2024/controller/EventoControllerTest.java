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
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class EventoControllerTest {
    @Test
    public void existe_DeberiaRetornarTrueFalse()throws SQLException {
        //Arrange
        EventoController ec=new EventoController();

        //Act
        boolean resultado=ec.existe("prueba");

        //Assert
        assertTrue(resultado,"El evento no existe");
    }
    @Test
    void recuperarEventoDeDataBaseMedianteID_DeberiaRetornarEvento() throws SQLException {
        //Arrange
        ControllerEvento controller = new ControllerEvento();

        //Act
        Evento evento = controller.recuperarEvento(2);

        //Assert
        assertNotNull(evento,"El evento no existe");
    }

}
