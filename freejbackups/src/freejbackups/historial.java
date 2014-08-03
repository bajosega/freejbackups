package freejbackups;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @"freejbakcups" por Adrian Seimandi - bajosega@gmail.com - @2014
 */

public class historial {
    
    public static String getFecha(){ 
   // Calendar calendario = Calendar.getInstance();
     Calendar calendario = new GregorianCalendar();
    //Calendar calendario = new GregorianCalendar();
    int  hora =calendario.get(Calendar.HOUR_OF_DAY);
    int minutos = calendario.get(Calendar.MINUTE);
    int segundos = calendario.get(Calendar.SECOND);
    int año = calendario.get(Calendar.YEAR);
    int mes = calendario.get(Calendar.MONTH);
    int dia = calendario.get(Calendar.DAY_OF_MONTH);
    return año +"-"+ mes +"-"+ dia + "-"+ hora + ";" + minutos + ";" + segundos;
    }   
    
     public static String jdatetime(){ 
   // Calendar calendario = Calendar.getInstance();
     Calendar calendario = new GregorianCalendar();
    //Calendar calendario = new GregorianCalendar();
    int  hora =calendario.get(Calendar.HOUR_OF_DAY);
    int minutos = calendario.get(Calendar.MINUTE);
    int segundos = calendario.get(Calendar.SECOND);
    int año = calendario.get(Calendar.YEAR);
    int mes = calendario.get(Calendar.MONTH);
    int dia = calendario.get(Calendar.DAY_OF_MONTH);
    return año +"-"+ mes +"-"+ dia + " "+ hora + ":" + minutos + ":" + segundos;
    }   
    
    
    
    public static void logCompresion(String contenido)
    {
    System.out.println(getFecha() + "-" + contenido);
    PlanEjecutar.jHistorial.append(getFecha()+ "-" + contenido);  
    PlanEjecutar.jHistorial.append(System.getProperty("line.separator")); // Esto para el salto de línea 
    Archivos.EscribirArchivo(getFecha()+ "-" + contenido);    
    }  
    
    public static void logError(String contenido)
    {
    System.out.println(getFecha() + "-" + contenido);
    PlanEjecutar.txtErrores.append(getFecha()+ "-" + contenido);  
    PlanEjecutar.txtErrores.append(System.getProperty("line.separator")); // Esto para el salto de línea
    Archivos.EscribirArchivo(getFecha()+ "-" + contenido);
    }   
    
   
    
    
}
