package com.example.mttp2024.models;

import java.time.LocalDate;
import java.time.LocalTime;

public class Evento {

    private String nombreEvento;
    private String descripcionEvento;
    private String ubicacion;
    private LocalDate fechaEvento;
    private LocalTime horaInicioEvento;
    private LocalTime horaFinEvento;

    //contructor con todos los atributos
    public Evento(String nombreEvento,String descripcionEvento,String ubicacion,LocalDate fechaEvento,
                  LocalTime horaInicioEvento,LocalTime horaFinEvento){

        this.nombreEvento=nombreEvento;
        this.descripcionEvento=descripcionEvento;
        this.ubicacion=ubicacion;
        this.fechaEvento=fechaEvento;
        this.horaInicioEvento=horaInicioEvento;
        this.horaFinEvento=horaFinEvento;

    }
    //constructor sin atributo de ubicacion
    public Evento(String nombreEvento,String descripcionEvento,LocalDate fechaEvento,
                  LocalTime horaInicioEvento,LocalTime horaFinEvento){

        this.nombreEvento=nombreEvento;
        this.descripcionEvento=descripcionEvento;
        ubicacion=null;
        this.fechaEvento=fechaEvento;
        this.horaInicioEvento=horaInicioEvento;
        this.horaFinEvento=horaFinEvento;

    }


    public String getNombreEvento() {
        return nombreEvento;
    }

    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }

    public String getDescripcionEvento() {
        return descripcionEvento;
    }

    public void setDescripcionEvento(String descripcionEvento) {
        this.descripcionEvento = descripcionEvento;
    }

    public LocalDate getFechaEvento() {
        return fechaEvento;
    }

    public void setFechaEvento(LocalDate fechaEvento) {
        this.fechaEvento = fechaEvento;
    }

    public LocalTime getHoraInicioEvento() {
        return horaInicioEvento;
    }

    public void setHoraInicioEvento(LocalTime horaInicioEvento) {
        this.horaInicioEvento = horaInicioEvento;
    }

    public LocalTime getHoraFinEvento() {
        return horaFinEvento;
    }

    public void setHoraFinEvento(LocalTime horaFinEvento) {
        this.horaFinEvento = horaFinEvento;
    }
}
