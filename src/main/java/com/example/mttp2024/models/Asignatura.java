package com.example.mttp2024.models;

import java.util.ArrayList;

public class Asignatura {

    private int idAsignatura;
    private String nombreAsigatura;


    public Asignatura(int idAsignatura,String nombreAsigatura){
        this.idAsignatura=idAsignatura;
        this.nombreAsigatura=nombreAsigatura;

    }
    public  Asignatura(String nombreAsigatura){
        this.nombreAsigatura=nombreAsigatura;

    }
    public void setNombreAsigatura(String nombreAsigatura) {
        this.nombreAsigatura = nombreAsigatura;
    }

    public String getNombreAsigatura() {
        return nombreAsigatura;
    }

    public int getIdAsignatura() {
        return idAsignatura;
    }
}
