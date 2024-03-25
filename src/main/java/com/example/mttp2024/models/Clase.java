package com.example.mttp2024.models;

import java.time.LocalTime;

public class Clase {

    private  int idClase;
    private String diaSemana;
    private LocalTime horaInicio;
    private  LocalTime horaFin;

    public Clase(int id, String diaSemana, LocalTime horaInicio, LocalTime horaFin) {
        this.idClase=id;
        this.diaSemana=diaSemana;
        this.horaInicio=horaInicio;
        this.horaFin=horaFin;
    }
    public int getIdClase() {
        return idClase;
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

