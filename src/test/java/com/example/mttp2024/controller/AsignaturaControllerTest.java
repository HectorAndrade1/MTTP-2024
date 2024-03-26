package com.example.mttp2024.controller;

import com.example.mttp2024.controllers.AsignaturaController;
import com.example.mttp2024.controllers.ControllerEvento;
import com.example.mttp2024.models.Asignatura;
import com.example.mttp2024.models.Evento;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;

public class AsignaturaControllerTest {

    @Test
    void pruebaCrearAsinatura()throws SQLException {
        AsignaturaController controller= new AsignaturaController();
        Asignatura asignatura= new Asignatura("valores catolicos");
        controller.crearAsignatura(asignatura);


    }


    @Test
    void pruebaMostrarAsignaturas() throws SQLException {

        AsignaturaController controller=new AsignaturaController();
        ArrayList<Asignatura>lista=controller.mostrarAsignaturas();
        for (int i=0;i<lista.size();i++){
            Asignatura indice=lista.get(i);
            System.out.println("indetidicador: "+indice.getIdAsignatura()+" nombre: "+indice.getNombreAsigatura());

        }
    }


    @Test
    void pruebaRecuperarAsignatura() throws SQLException {
        // Crea una instancia del ControllerEvento
        AsignaturaController controller = new AsignaturaController();

        // Llama al método que deseas proba
        Asignatura asignatura= controller.mostrarAsignatura(4);

        if (asignatura!=null){
            System.out.println("existe la asignatura :"+asignatura.getNombreAsigatura()+" con id: "+asignatura.getIdAsignatura());
        }
        else {
            System.out.println("no existe la asignatura ");
        }

    }

    @Test
    void pruebaCrearAsignatura() throws SQLException {
        AsignaturaController controller= new AsignaturaController();
        controller.actualizarAsignatura(4,"historia catolica");
    }

}
