package com.example.mttp2024.controllers;
import com.example.mttp2024.models.Clase;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class ClaseController {
    private ArrayList<Clase> listaClases;

    public ClaseController() {
        listaClases = new ArrayList<>();
    }

    public void agregarClase() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el día de la semana:");
        String diaSemana = scanner.nextLine();
        System.out.println("Ingrese la hora de inicio (HH:mm):");
        String horaInicioStr = scanner.nextLine();
        LocalTime horaInicio = LocalTime.parse(horaInicioStr);
        System.out.println("Ingrese la hora de fin (HH:mm):");
        String horaFinStr = scanner.nextLine();
        LocalTime horaFin = LocalTime.parse(horaFinStr);

        Clase nuevaClase = new Clase(diaSemana, horaInicio, horaFin);
        listaClases.add(nuevaClase);
        System.out.println("Clase agregada correctamente.");
    }

    public void modificarClase() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el día de la semana de la clase a modificar:");
        String diaSemanaBuscar = scanner.nextLine();

        for (Clase clase : listaClases) {
            if (clase.getDiaSemana().equalsIgnoreCase(diaSemanaBuscar)) {
                System.out.println("Ingrese la nueva hora de inicio (HH:mm):");
                String nuevaHoraInicioStr = scanner.nextLine();
                LocalTime nuevaHoraInicio = LocalTime.parse(nuevaHoraInicioStr);
                clase.setHoraInicio(nuevaHoraInicio);

                System.out.println("Ingrese la nueva hora de fin (HH:mm):");
                String nuevaHoraFinStr = scanner.nextLine();
                LocalTime nuevaHoraFin = LocalTime.parse(nuevaHoraFinStr);
                clase.setHoraFin(nuevaHoraFin);

                System.out.println("Clase modificada correctamente.");
                return;
            }
        }
        System.out.println("No se encontró la clase con el día de semana especificado.");
    }

    public void eliminarClase() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el día de la semana de la clase a eliminar:");
        String diaSemanaEliminar = scanner.nextLine();

        for (Clase clase : listaClases) {
            if (clase.getDiaSemana().equalsIgnoreCase(diaSemanaEliminar)) {
                System.out.println("¿Estás seguro de eliminar la clase? (si/no)");
                String confirmacion = scanner.nextLine();
                if (confirmacion.equalsIgnoreCase("si")) {
                    listaClases.remove(clase);
                    System.out.println("Clase eliminada correctamente.");
                } else {
                    System.out.println("Operación de eliminación cancelada.");
                }
            }
        }
        System.out.println("No se encontró la clase con el día de semana especificado.");
    }


    public void listarClases() {
        System.out.println("Listado de clases:");
        for (Clase clase : listaClases) {
            System.out.println("Día: " + clase.getDiaSemana() + ", Hora inicio: " + clase.getHoraInicio() +
                    ", Hora fin: " + clase.getHoraFin());
        }
    }

    // Otros métodos según las necesidades específicas del controlador
}

