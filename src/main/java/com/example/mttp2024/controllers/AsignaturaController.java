package com.example.mttp2024.controllers;

import com.example.mttp2024.models.Clase;
import com.example.mttp2024.models.Tarea;
import com.example.mttp2024.models.Asignatura;
import java.util.ArrayList;
import java.util.Scanner;

public class AsignaturaController {
    private ArrayList<Asignatura> listaAsignaturas;

    public AsignaturaController() {
        listaAsignaturas = new ArrayList<>();
    }

    public void agregarAsignatura() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el nombre de la asignatura:");
        String nombre = scanner.nextLine();
        Asignatura asignatura = new Asignatura(nombre);
        listaAsignaturas.add(asignatura);
        System.out.println("Asignatura agregada correctamente.");
    }

    public void agregarTarea(Asignatura asignatura, Tarea tarea) {
        asignatura.getListaTareas().add(tarea);
        System.out.println("Tarea agregada a la asignatura " + asignatura.getNombreAsigatura());
    }

    public void agregarClase(Asignatura asignatura, Clase clase) {
        asignatura.getListaClases().add(clase);
        System.out.println("Clase agregada a la asignatura " + asignatura.getNombreAsigatura());
    }

    public void modificarAsignatura(Asignatura asignatura) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el nuevo nombre de la asignatura:");
        String nuevoNombre = scanner.nextLine();
        asignatura.setNombreAsigatura(nuevoNombre);
        System.out.println("Asignatura modificada correctamente.");
    }

    public void eliminarAsignatura() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el nombre de la asignatura a eliminar:");
        String nombreEliminar = scanner.nextLine();

        for (Asignatura asignatura : listaAsignaturas) {
            if (asignatura.getNombreAsigatura().equalsIgnoreCase(nombreEliminar)) {
                System.out.println("¿Estás seguro de eliminar la asignatura? (si/no)");
                String confirmacion = scanner.nextLine();
                if (confirmacion.equalsIgnoreCase("si")) {
                    listaAsignaturas.remove(asignatura);
                    System.out.println("Asignatura eliminada correctamente.");
                } else {
                    System.out.println("Operación de eliminación cancelada.");
                }
            }
        }
        System.out.println("No se encontró la asignatura con el nombre especificado.");
    }


    public void listarTareas(Asignatura asignatura) {
        System.out.println("Tareas de la asignatura " + asignatura.getNombreAsigatura() + ":");
        for (Tarea tarea : asignatura.getListaTareas()) {
            System.out.println(tarea);
        }
    }

    public void listarClases(Asignatura asignatura) {
        System.out.println("Clases de la asignatura " + asignatura.getNombreAsigatura() + ":");
        for (Clase clase : asignatura.getListaClases()) {
            System.out.println(clase);
        }
    }

    // Otros métodos según las necesidades específicas del controlador
}

