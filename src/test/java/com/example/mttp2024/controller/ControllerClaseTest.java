package com.example.mttp2024.controller;
import com.example.mttp2024.controllers.ControllerClase;
import com.example.mttp2024.models.Clase;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;

public class ControllerClaseTest {


    @Test
    void pruebaRecuperarClase() throws SQLException {
        // Crea una instancia del ControllerClase
        ControllerClase controller = new ControllerClase();

        // Llama al método que deseas proba
        Clase clase = controller.recuperarClase(1);

        if (clase!=null){
            System.out.println("existe la clase:"+clase.getDiaSemana()+clase.getHoraInicio());
        }
        else {
            System.out.println("no existe la clase");
        }

    }

    @Test
    void pruebaListarClase() throws SQLException{
        Clase listar;
        ControllerClase controller=new ControllerClase();
        ArrayList<Clase> clases= controller.mostrarClases();
        for (int i = 0; i <clases.size(); i++) {
            listar = clases.get(i);
            System.out.println("clase con identificador:" + listar.getIdClase() + "Dia de la semana: " + listar.getDiaSemana());
        }
    }
}

