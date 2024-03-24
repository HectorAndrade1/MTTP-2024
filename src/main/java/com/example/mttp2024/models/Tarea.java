package com.example.mttp2024.models;

import java.time.LocalDate;

public class Tarea {
    private  int idTarea;
    private String nombreTarea;
    private String descripcionTarea;
    private int prioridad;
    private LocalDate fechaEntrega;

    public Tarea(int idTarea, String nombreTarea,String descripcionTarea, int prioridad,LocalDate fechaEntrega) {
        this(nombreTarea, descripcionTarea, prioridad, fechaEntrega);
        this.idTarea = idTarea;
    }

    public Tarea(String nombreTarea,String descripcionTarea, int prioridad,LocalDate fechaEntrega) {
        this.nombreTarea=nombreTarea;
        this.descripcionTarea=descripcionTarea;
        this.prioridad=prioridad;
        this.fechaEntrega=fechaEntrega;
    }

    public String getNombreTarea() {
        return nombreTarea;
    }

    public void setNombreTarea(String nombreTarea) {
        this.nombreTarea = nombreTarea;
    }

    public String getDescripcionTarea() {
        return descripcionTarea;
    }

    public void setDescripcionTarea(String descripcionTarea) {
        this.descripcionTarea = descripcionTarea;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }
}
