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

    public void crearEvento(String evename, String evedescription, String etxtdate, String horaini, String horafin) {
        LocalDate evedate = formatoFecha(etxtdate);
        LocalTime evehoraini = formatoHora(horaini);
        LocalTime evehorafin = formatoHora(horafin);
        try {
            if (existe(evename)) {
                throw new ExisteException("El nombre del evento ya existe");
            } else {
                listaeventos.add(new Evento(evename, evedescription, evedate, evehoraini, evehorafin));
                System.out.println("Evento agregado");
            }
        } catch (ExisteException x) {
            System.out.println(x.toString());
        }
    }

    public void crearEvento(String nombre, String descripcion, String ubicacion, String txtdate, String horaini, String horafin) {
        LocalDate evedate = formatoFecha(txtdate);
        LocalTime evehoraini = formatoHora(horaini);
        LocalTime evehorafin = formatoHora(horafin);
        try {
            if (existe(nombre)) {
                throw new ExisteException("El nombre del evento ha sido agrgado");
            } else {
                listaeventos.add(new Evento(nombre, descripcion, ubicacion, evedate, evehoraini, evehorafin));
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
        LocalDate fechaconformato = LocalDate.parse(texto, dateformat);
        return fechaconformato;
    }
    public LocalTime formatoHora(String texto){
        DateTimeFormatter horaformat = new DateTimeFormatterBuilder().append(DateTimeFormatter.ofPattern("HH:mm")).toFormatter();
        LocalTime horaconformato = LocalTime.parse(texto, horaformat);
        return horaconformato;
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
                DateTimeFormatter formato = new DateTimeFormatterBuilder().append(DateTimeFormatter.ofPattern("dd-MM-yyyy")).toFormatter();
                LocalDate newdate = LocalDate.parse(nuevovalor, formato);
                listaeventos.get(indice).setFechaEvento(newdate);
                break;
            case "horaInicioEvento":
                DateTimeFormatter inihora = new DateTimeFormatterBuilder().append(DateTimeFormatter.ofPattern("HH:mm")).toFormatter();
                LocalTime newhoraini = LocalTime.parse(nuevovalor, inihora);
                listaeventos.get(indice).setHoraInicioEvento(newhoraini);
                break;
            case "horaFinEvento":
                DateTimeFormatter finhora = new DateTimeFormatterBuilder().append(DateTimeFormatter.ofPattern("HH:mm")).toFormatter();
                LocalTime newhorafin = LocalTime.parse(nuevovalor, finhora);
                listaeventos.get(indice).setHoraFinEvento(newhorafin);
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
            System.out.println("Nombre:" + l.getNombreEvento() + "\nDescripción:" + l.getDescripcionEvento()/*+"\nUbicación:"+l.getUbicacion()*/ + "\nFecha del evento:" + l.getFechaEvento() + "\nHora de inicio:" + l.getHoraFinEvento() + "\nHora fin de evento" + l.getHoraFinEvento());
            System.out.println("___________________________________");
        }
    }

}
