package com.example.mttp2024.controllers;

import com.example.mttp2024.models.Evento;
import com.example.mttp2024.models.Evento;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EventoController {
    public List<Evento> listaeventos=new ArrayList<>();

    public void CrearEvento(){
        System.out.println("Ingrese nombre de Evento");
        Scanner scan=new Scanner(System.in);
        String evename=scan.nextLine();
        System.out.println("Ingrese descripción del evento");
        String evedescription=scan.nextLine();
        System.out.println("Ingrese fecha del evento: dd-mm-yyyy");
        String etxtdate= scan.nextLine();
        DateTimeFormatter dateformat=new DateTimeFormatterBuilder().append(DateTimeFormatter.ofPattern("dd-MM-yyyy")).toFormatter();
        LocalDate evedate=LocalDate.parse(etxtdate,dateformat);
        System.out.println("Ingrese Hora de inicio del evento: HH:mm");
        String horaini=scan.nextLine();
        DateTimeFormatter horaformat=new DateTimeFormatterBuilder().append(DateTimeFormatter.ofPattern("HH:mm")).toFormatter();
        LocalTime evehoraini=LocalTime.parse(horaini,horaformat);
        System.out.println("Ingrese Hora de inicio del evento: HH:mm");
        String horafin=scan.nextLine();
        LocalTime evehorafin=LocalTime.parse(horafin,horaformat);
        if(existe(evename)){
            System.out.println("El evento ya existe; Evento no agreagado");
        }else{
            System.out.println("¿El evento tiene Ubicacion?:\n1.Si\n2.no");
            Scanner num=new Scanner(System.in);
            int op=num.nextInt();
            switch (op) {
                case 1:
                    System.out.println("Ingrese Ubicación del evento");
                    String ubi = scan.nextLine();
                    listaeventos.add(new Evento(evename, evedescription, ubi, evedate, evehoraini, evehorafin));
                    break;
                case 2:
                    listaeventos.add(new Evento(evename, evedescription, evedate, evehoraini, evehorafin));
                    break;
                default:System.out.println("Opcion no disponible");
            }
            System.out.println("Evento agregado");
        }
    }
    public boolean existe(String target){
        boolean r = false;
        for(Evento i:listaeventos){
            r = target.trim().equalsIgnoreCase(i.getNombreEvento().trim());
        }
        return r;
    }
    public void ModificarEvento(){
        System.out.println("Ingrese Evento a modificar");
        Scanner mt=new Scanner(System.in);
        String target=mt.nextLine();
        for(Evento j:listaeventos){
            if(target.trim().equalsIgnoreCase(j.getNombreEvento())){
                System.out.println("Indique parametro a modificar:\n1.Nombre\n2.Descripción\n3.Ubicacion\n4.Fecha del evento\n5.Hora de inicio\n6.Hora final");
                Scanner sw=new Scanner(System.in);
                int val=sw.nextInt();
                switch (val){
                    case 1: System.out.println("Ingrese nuevo nombre de la Evento");
                            String nuevoname=mt.nextLine();
                            j.setNombreEvento(nuevoname);
                        break;
                    case 2: System.out.println("Ingrese nuevo descripción de la Evento");
                            String nuevodescrip=mt.nextLine();
                            j.setDescripcionEvento(nuevodescrip);
                        break;
                    case 3: System.out.println("Ingrese nueva Ubicacion de la Evento");
                            String nuevaubi=mt.nextLine();
                            /*if(j.getUbicacion()==null){
                                String name=j.getNombreEvento();
                                String decrip=j.getDescripcionEvento();
                                LocalDate fechaEvento=j.getFechaEvento();
                                LocalTime horaInicioEvento=j.getHoraInicioEvento();
                                LocalTime horaFinEvento=j.getHoraFinEvento();
                                listaeventos.remove(j);
                                listaeventos.add(j,new Evento(name, decrip,nuevaubi, fechaEvento, horaInicioEvento, horaFinEvento));
                            }else {
                                j.setUbicacion(nuevaubi);
                            }*/
                        break;
                    case 4: System.out.println("Ingrese nueva fecha de evento");
                            String ntxtdate=mt.nextLine();
                            DateTimeFormatter formato=new DateTimeFormatterBuilder().append(DateTimeFormatter.ofPattern("dd-MM-yyyy")).toFormatter();
                            LocalDate newdate=LocalDate.parse(ntxtdate,formato);
                            j.setFechaEvento(newdate);
                        break;
                    case 5: System.out.println("Ingrese nueva hora de inicio");
                            String newini=mt.nextLine();
                        DateTimeFormatter inihora=new DateTimeFormatterBuilder().append(DateTimeFormatter.ofPattern("HH:mm")).toFormatter();
                            LocalTime newhoraini=LocalTime.parse(newini,inihora);
                            j.setHoraInicioEvento(newhoraini);
                        break;
                    case 6: System.out.println("Ingrese nueva hora final");
                            String newfin=mt.nextLine();
                            DateTimeFormatter finhora=new DateTimeFormatterBuilder().append(DateTimeFormatter.ofPattern("HH:mm")).toFormatter();
                            LocalTime newhorafin=LocalTime.parse(newfin,finhora);
                            j.setHoraFinEvento(newhorafin);
                        break;
                    default:System.out.println("La opción ingresada no es valida");
                }
            }else{
                System.out.println("El Evento especificado no existe");
            }
        }
    }
    public void EliminarEvento(){
        System.out.println("Ingrese Evento a eliminar");
        Scanner el=new Scanner(System.in);
        String elim=el.nextLine();
        for(Evento k:listaeventos){
            if(elim.trim().equalsIgnoreCase(k.getNombreEvento())){
                System.out.println("Esta seguro que desea eliminar el Evento:\nsi\nno");
                String pregunta=el.nextLine();
                if(pregunta.equalsIgnoreCase("si")){
                    listaeventos.remove(k);
                    System.out.println("Evento eliminado");
                    return;
                }
            }else{
                System.out.println("El Evento especificado no existe");
            }
        }
    }
    public void ListarEventos(){
        for(Evento l:listaeventos){
            System.out.println("Nombre:"+l.getNombreEvento()+"\nDescripción:"+l.getDescripcionEvento()/*+"\nUbicación:"+l.getUbicacion()*/+"\nFecha del evento:"+l.getFechaEvento()+"\nHora de inicio:"+l.getHoraFinEvento()+"\nHora fin de evento"+l.getHoraFinEvento());
            System.out.println("___________________________________");
        }
    }
}
