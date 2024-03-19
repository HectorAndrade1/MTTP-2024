package com.example.mttp2024.controllers;

import com.example.mttp2024.models.Tarea;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.*;

public class TareaController {

    public List<Tarea> listatareas= new ArrayList<>();
    public void CrearTarea(){
        System.out.println("Ingrese nombre de tarea");
        Scanner scan=new Scanner(System.in);
        String taskname=scan.nextLine();
        System.out.println("Ingrese descripcion");
        String taskdescription=scan.nextLine();
        System.out.println("Ingrese prioridada");
        Scanner scp=new Scanner(System.in);
        int prior= scp.nextInt();
        System.out.println("Ingrese fecha de entrega: dd-mm-yyyy");
        String txtdate= scan.nextLine();
        DateTimeFormatter format=new DateTimeFormatterBuilder().append(DateTimeFormatter.ofPattern("dd-MM-yyyy")).toFormatter();
        LocalDate taskdate=LocalDate.parse(txtdate,format);
        if(existe(taskname)){
            System.out.println("El nombre de la tarea ya existe; tarea no agreagada");
        }else{
            listatareas.add(new Tarea(taskname,taskdescription,prior,taskdate));
            System.out.println("Tarea agregada");
        }
    }
    public boolean existe(String target){
        boolean r = false;
        for(Tarea i:listatareas){
            r = target.trim().equalsIgnoreCase(i.getNombreTarea().trim());
        }
        return r;
    }
    public void ModificarTarea(){
        System.out.println("Ingrese tarea a modificar");
        Scanner mt=new Scanner(System.in);
        String target=mt.nextLine();
        for(Tarea j:listatareas){
            if(target.trim().equalsIgnoreCase(j.getNombreTarea())){
                System.out.println("Indique parametro a modificar:\n1.Nombre\n2.Descripción\n3.Prioridad\n4.Fecha de Entrega");
                Scanner sw=new Scanner(System.in);
                int val=sw.nextInt();
                switch (val){
                    case 1: System.out.println("Ingrese nuevo nombre de la tarea");
                        String nuevoname=mt.nextLine();
                        j.setNombreTarea(nuevoname);
                        break;
                    case 2: System.out.println("Ingrese nuevo descripción de la tarea");
                        String nuevodescrip=mt.nextLine();
                        j.setDescripcionTarea(nuevodescrip);
                        break;
                    case 3: System.out.println("Ingrese nueva prioridad de la tarea");
                        int nuevoprior=sw.nextInt();
                        j.setPrioridad(nuevoprior);
                        break;
                    case 4: System.out.println("Ingrese nueva fecha de entrega");
                        String ntxtdate=mt.nextLine();
                        DateTimeFormatter formato=new DateTimeFormatterBuilder().append(DateTimeFormatter.ofPattern("dd-MM-yyyy")).toFormatter();
                        LocalDate newdate=LocalDate.parse(ntxtdate,formato);
                        j.setFechaEntrega(newdate);
                        break;
                    default:System.out.println("La opncion ingresada no es valida");
                }
            }else{
                System.out.println("La tarea especificada no existe");
            }
        }
    }
    public void EliminarTarea(){
        System.out.println("Ingrese tarea a eliminar");
        Scanner el=new Scanner(System.in);
        String elim=el.nextLine();
        for(Tarea k:listatareas){
            if(elim.trim().equalsIgnoreCase(k.getNombreTarea())){
                System.out.println("Esta seguro que desea eliminar la tarea:\nsi\nno");
                String pregunta=el.nextLine();
                if(pregunta.equalsIgnoreCase("si")){
                    listatareas.remove(k);
                    System.out.println("Tarea eliminada");
                    return;
                }
            }else{
                System.out.println("La tarea especificada no existe");
            }
        }
    }
    public void MostraCreacion(){
        for(Tarea l:listatareas){
            System.out.println("Nombre:"+l.getNombreTarea()+"\nDescripcion:"+l.getDescripcionTarea()+"\nPrioridad:"+l.getPrioridad()+"\nFecha de Entrega:"+l.getFechaEntrega());
            System.out.println("____________________________________________");
        }
    }
    public void MostrarPrioridad(){
        List<Tarea> listaprior = new ArrayList<>(listatareas);
        Tarea aux;
        for(int j=0;j<listaprior.size();j++){
            for (int i=0;i<listaprior.size()-1;i++){
                if(listaprior.get(i).getPrioridad()<listaprior.get(i+1).getPrioridad()){
                    aux=listaprior.get(i);
                    listaprior.set(i,listaprior.get(i+1));
                    listaprior.set(i+1,aux);
                }
            }
        }
        for(Tarea l:listaprior){
            System.out.println("Nombre:"+l.getNombreTarea()+"\nDescripcion:"+l.getDescripcionTarea()+"\nPrioridad:"+l.getPrioridad()+"\nFecha de Entrega:"+l.getFechaEntrega());
            System.out.println("____________________________________________");
        }
    }
}