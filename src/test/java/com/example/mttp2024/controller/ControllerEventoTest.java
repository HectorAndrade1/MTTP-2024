package com.example.mttp2024.controller;
import com.example.mttp2024.controllers.ControllerEvento;
import com.example.mttp2024.models.Evento;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;

public class ControllerEventoTest {


    @Test
    void pruebaRecuperarEvento() throws SQLException {
        // Crea una instancia del ControllerEvento
        ControllerEvento controller = new ControllerEvento();

        // Llama al método que deseas proba
        Evento evento = controller.recuperarEvento(4);

        if (evento!=null){
            System.out.println("existe el evento:"+evento.getNombreEvento()+evento.getFechaEvento());
        }
        else {
            System.out.println("no existe el evento");
        }

    }

    @Test
    void pruebaListarEventos() throws SQLException{
        Evento listar;
        ControllerEvento controller=new ControllerEvento();
        ArrayList<Evento> eventos= controller.mostrarEventos();
        for (int i = 0; i <eventos.size(); i++) {
            listar = eventos.get(i);
            System.out.println("evento con identificador:" + listar.getIdEvento() + "nombre: " + listar.getNombreEvento());
        }
    }
}
