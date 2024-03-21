package com.example.mttp2024.models;

import java.util.ArrayList;

public class Asignatura {
    private String nombreAsigatura;
    private ArrayList<Tarea> listaTareas;
    private ArrayList<Clase> listaClases;

    public Asignatura() {
        nombreAsigatura = "";
        listaTareas = new ArrayList<Tarea>();
        listaClases = new ArrayList<Clase>();
    }
    public Asignatura(String nombreAsigatura, ArrayList<Tarea> listaTareas, ArrayList<Clase> listaClases){

        this.nombreAsigatura=nombreAsigatura;
        this.listaTareas=listaTareas;
        this.listaClases=listaClases;
    }
    public  Asignatura(String nombreAsigatura){
        this.nombreAsigatura=nombreAsigatura;
        listaTareas=null;
        listaClases=null;
    }
    public void setNombreAsigatura(String nombreAsigatura) {
        this.nombreAsigatura = nombreAsigatura;
    }

    public String getNombreAsigatura() {
        return nombreAsigatura;
    }

    public ArrayList<Clase> getListaClases() {
        return listaClases;
    }
    public void setListaClases(ArrayList<Clase> listaClases) {
        this.listaClases = listaClases;
    }

    public void setListaTareas(ArrayList<Tarea> listaTareas) {
        this.listaTareas = listaTareas;
    }

    public ArrayList<Tarea> getListaTareas() {
        return listaTareas;
    }

}
