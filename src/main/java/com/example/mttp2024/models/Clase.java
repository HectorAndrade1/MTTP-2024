package com.example.mttp2024.models;

import java.time.LocalTime;

public class Clase {
    private String diaSemana;
    private LocalTime horaInicio;
    private  LocalTime horaFin;

    public Clase(String diaSemana, LocalTime horaInicio, LocalTime horaFin) {
        this.diaSemana=diaSemana;
        this.horaInicio=horaInicio;
        this.horaFin=horaFin;
    }

    public String getDiaSemana() {
        return diaSemana;
    }
    public void setDiaSemana(String newdiaSemana){
        diaSemana=newdiaSemana;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }

}

