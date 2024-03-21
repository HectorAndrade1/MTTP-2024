package com.example.mttp2024.utils;

import com.example.mttp2024.models.Asignatura;
import com.example.mttp2024.models.Evento;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

public class DataManager {
    private String formatoFecha;
    private String formatoHora;
    private ArrayList<Evento> listaEventos;
    private ArrayList<Asignatura> listaAsignaturas;

    public DataManager() {
        formatoFecha = "yyyy-MM-dd";
        formatoHora = "HH:mm:ss";
        listaEventos = new ArrayList<>();
        listaAsignaturas = new ArrayList<>();
    }

    public String getFormatoFecha() {
        return formatoFecha;
    }

    public String getFormatoHora() {
        return formatoHora;
    }

    public void addEvento(Evento evento) {
        listaEventos.add(evento);
    }

    public void addAsignatura(Asignatura asignatura) {
        listaAsignaturas.add(asignatura);
    }

    public Evento obtenerEventoPorNombre(String nombre) {
        for (Evento evento : listaEventos) {
            if (Objects.equals(evento.getNombreEvento(), nombre)) {
                return evento;
            }
        }
        return null;
    }

    public Asignatura obtenerAsignaturaPorNombre(String nombre) {
        for (Asignatura asignatura : listaAsignaturas) {
            if (Objects.equals(asignatura.getNombreAsigatura(), nombre)) {
                return asignatura;
            }
        }
        return null;
    }

    public String obtenerJSON(Object obj) {
        ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        mapper.registerModule(new JavaTimeModule());
        try {
            String json = mapper.writeValueAsString(obj);
            System.out.println("JSON:\n" + json);
            return json;
        } catch (IOException e) {
            e.printStackTrace();
            return "Err: cannot transform events to json string";
        }
    }

    public void cargarEventosConJSON(String textoJSON) {
        ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        mapper.registerModule(new JavaTimeModule());
        try {
            listaEventos = mapper.readValue(textoJSON, new TypeReference<ArrayList<Evento>>() {});
            System.out.println("Des-Events:\n" + listaEventos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cargarAsignaturasConJSON(String textoJSON) {
        ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        mapper.registerModule(new JavaTimeModule());
        try {
            listaAsignaturas = mapper.readValue(textoJSON, new TypeReference<ArrayList<Asignatura>>() {});
            System.out.println("Des-Subjects:\n" + listaAsignaturas);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void escribirArchivoJSON(String nombreArchivo, String textoJSON){
        String path = String.format("data/%s.json", nombreArchivo);
        File archivo = new File(path);
        try {
            FileWriter escritor = new FileWriter(archivo);
            BufferedWriter buffer = new BufferedWriter(escritor);
            buffer.write(textoJSON);
            buffer.close();
        } catch(IOException e) {
            e.printStackTrace(System.out);
        }
    }

    public String leerArchivoJSON(String nombreArchivo) {
        String path = String.format("data/%s.json", nombreArchivo);
        try {
            File archivo = new File(path);
            FileReader lector = new FileReader(archivo);
            BufferedReader buffer = new BufferedReader(lector);
            StringBuilder contenido = new StringBuilder();
            String linea;
            while ((linea = buffer.readLine()) != null) {
                contenido.append(linea).append("\n");
            }
            buffer.close();
            return contenido.toString();
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error al leer el archivo: " + e.getMessage());
            return "";
        }
    }

    public void guardarDatos() {
        String textoJSON = obtenerJSON(listaEventos);
        escribirArchivoJSON("eventos", textoJSON);
        textoJSON = obtenerJSON(listaAsignaturas);
        escribirArchivoJSON("asignaturas", textoJSON);
    }

    public void cargarDatos() {
        String textoJSON = leerArchivoJSON("eventos");
        cargarEventosConJSON(textoJSON);
        textoJSON = leerArchivoJSON("asignaturas");
        cargarAsignaturasConJSON(textoJSON);
    }
}
