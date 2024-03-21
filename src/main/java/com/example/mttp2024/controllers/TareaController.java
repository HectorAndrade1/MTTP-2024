package com.example.mttp2024.controllers;

import com.example.mttp2024.models.Tarea;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TareaController {

    public List<Tarea> listatareas = new ArrayList<>();

    public void crearTarea(String nombre, String descripcion, int prioridad, LocalDate fecha) {
        try {
            if (existe(nombre)) {
                throw new ExisteException("El nombre del evento ha sido agrgado");
            } else {
                listatareas.add(new Tarea(nombre, descripcion, prioridad, fecha));
                System.out.println("Tarea agregada");
            }
        } catch (ExisteException x) {
            System.out.println(x.toString());
        }
    }

    public boolean existe(String target) {
        boolean r = false;
        for (Tarea i : listatareas) {
            r = target.trim().equalsIgnoreCase(i.getNombreTarea().trim());
        }
        return r;
    }

    public void modificarTarea(String nombre, String atributo, String nuevovalor) {
        int indice = 0;
        for (Tarea j : listatareas) {
            if (nombre.trim().equalsIgnoreCase(j.getNombreTarea())) {
                indice = listatareas.indexOf(j);
            } else {
                System.out.println("La tarea no existe");
            }
        }
        switch (atributo) {
            case "nombreTarea":
                listatareas.get(indice).setNombreTarea(nuevovalor);
                System.out.println("Nombre cambiado");
                break;
            case "descripcionTarea":
                listatareas.get(indice).setDescripcionTarea(nuevovalor);
                System.out.println("Descripcion cambiada");
                break;
            case "prioridad":
                int numero = Integer.parseInt(nuevovalor);
                listatareas.get(indice).setPrioridad(numero);
                System.out.println("Prioridad cambiada");
                break;
            case "fechaEntrega":
                DateTimeFormatter formato = new DateTimeFormatterBuilder().append(DateTimeFormatter.ofPattern("yyyy-MM-dd")).toFormatter();
                LocalDate newdate = LocalDate.parse(nuevovalor, formato);
                listatareas.get(indice).setFechaEntrega(newdate);
                System.out.println("Fecha cambiada");
                break;
            default:
                System.out.println("La opncion ingresada no es valida");
        }
    }


    public void eliminarTarea(String nombre) {
        for (Tarea k : listatareas) {
            if (nombre.trim().equalsIgnoreCase(k.getNombreTarea())) {
                listatareas.remove(k);
                System.out.println("Tarea eliminada");
                return;
            } else {
                System.out.println("La tarea especificada no existe");
            }
        }
    }

    public void mostraCreacion() {
        for (Tarea l : listatareas) {
            System.out.println("Nombre:" + l.getNombreTarea() + "\nDescripcion:" + l.getDescripcionTarea() + "\nPrioridad:" + l.getPrioridad() + "\nFecha de Entrega:" + l.getFechaEntrega());
            System.out.println("____________________________________________");
        }
    }

    public void mostrarPrioridad() {
        List<Tarea> listaprior = new ArrayList<>(listatareas);
        Tarea aux;
        for (int j = 0; j < listaprior.size(); j++) {
            for (int i = 0; i < listaprior.size() - 1; i++) {
                if (listaprior.get(i).getPrioridad() < listaprior.get(i + 1).getPrioridad()) {
                    aux = listaprior.get(i);
                    listaprior.set(i, listaprior.get(i + 1));
                    listaprior.set(i + 1, aux);
                }
            }
        }
        for (Tarea l : listaprior) {
            System.out.println("Nombre:" + l.getNombreTarea() + "\nDescripcion:" + l.getDescripcionTarea() + "\nPrioridad:" + l.getPrioridad() + "\nFecha de Entrega:" + l.getFechaEntrega());
            System.out.println("____________________________________________");
        }
    }
}
