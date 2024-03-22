package com.example.mttp2024.controllers;

import com.example.mttp2024.models.Evento;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.List;

class ExisteException extends Exception {
    String s;
    ExisteException(String s) {
    this.s = s;}
    public String toString() {
        return s;
    }

}

public class EventoController {
    public List<Evento> listaeventos = new ArrayList<>();

    public void crearEvento(String nombre, String descripcion, LocalDate fecha, LocalTime horaini, LocalTime horafin) {
        try {
            if (existe(nombre)) {
                throw new ExisteException("El nombre del evento ya existe");
            } else {
                listaeventos.add(new Evento(nombre, descripcion, fecha, horaini, horafin));
                System.out.println("Evento agregado");
            }
        } catch (ExisteException x) {
            System.out.println(x.toString());
        }
    }

    public void crearEvento(String nombre, String descripcion, String ubicacion, LocalDate fecha, LocalTime horaini, LocalTime horafin) {
        try {
            if (existe(nombre)) {
                throw new ExisteException("El nombre del evento ha sido agrgado");
            } else {
                listaeventos.add(new Evento(nombre, descripcion, ubicacion, fecha, horaini, horafin));
                System.out.println("Evento agregado");
            }
        } catch (ExisteException x) {
            System.out.println(x.toString());
        }
    }

    public boolean existe(String target) {
        boolean r = false;
        for (Evento i : listaeventos) {
            r = target.trim().equalsIgnoreCase(i.getNombreEvento().trim());
        }
        return r;
    }
    public LocalDate formatoFecha(String texto){
        DateTimeFormatter dateformat = new DateTimeFormatterBuilder().append(DateTimeFormatter.ofPattern("yyyy-MM-dd")).toFormatter();
        LocalDate fechacambiada;
        return fechacambiada= LocalDate.parse(texto, dateformat);
    }
    public LocalTime formatoHora(String texto){
        DateTimeFormatter horaformat = new DateTimeFormatterBuilder().append(DateTimeFormatter.ofPattern("HH:mm")).toFormatter();
        LocalTime horaconformato;
        return horaconformato = LocalTime.parse(texto, horaformat);
    }

    public void modificarEvento(String nombre, String atributo, String nuevovalor) {
        int indice = 0;
        for (Evento j : listaeventos) {
            if (nombre.trim().equalsIgnoreCase(j.getNombreEvento())) {
                indice = listaeventos.indexOf(j);
            }
        }
        switch (atributo) {
            case "nombreEvento":
                listaeventos.get(indice).setNombreEvento(nuevovalor);
                break;
            case "descripcionEvento":
                listaeventos.get(indice).setDescripcionEvento(nuevovalor);
                break;
            case "ubicacion":
                if (listaeventos.get(indice).getUbicacion() == null) {
                    String name = listaeventos.get(indice).getNombreEvento();
                    String decrip = listaeventos.get(indice).getDescripcionEvento();
                    LocalDate fechaEvento = listaeventos.get(indice).getFechaEvento();
                    LocalTime horaInicioEvento = listaeventos.get(indice).getHoraInicioEvento();
                    LocalTime horaFinEvento = listaeventos.get(indice).getHoraFinEvento();
                    listaeventos.remove(listaeventos.get(indice));
                    listaeventos.add(indice, new Evento(name, decrip, nuevovalor, fechaEvento, horaInicioEvento, horaFinEvento));
                } else {
                    listaeventos.get(indice).setUbicacion(nuevovalor);
                }
                break;
            case "fechaEvento":
                listaeventos.get(indice).setFechaEvento(formatoFecha(nuevovalor));
                break;
            case "horaInicioEvento":
                listaeventos.get(indice).setHoraInicioEvento(formatoHora(nuevovalor));
                break;
            case "horaFinEvento":
                listaeventos.get(indice).setHoraFinEvento(formatoHora(nuevovalor));
                break;
            default:
                System.out.println("No se puede modificar ese atributo");
        }
    }

    public void eliminarEvento(String nombre) {
        for (Evento k : listaeventos) {
            if (nombre.trim().equalsIgnoreCase(k.getNombreEvento())) {
                listaeventos.remove(k);
                System.out.println("Evento Eliminado");
                return;
            } else {
                System.out.println("El Evento especificado no existe");
            }
        }
    }

    public void listarEventos() {
        for (Evento l : listaeventos) {
            System.out.println("Nombre:" + l.getNombreEvento() + "\nDescripción:" + l.getDescripcionEvento() + "\nUbicación:"+l.getUbicacion() + "\nFecha del evento:" + l.getFechaEvento() + "\nHora de inicio:" + l.getHoraFinEvento() + "\nHora fin de evento" + l.getHoraFinEvento());
            System.out.println("___________________________________");
        }
    }

}
