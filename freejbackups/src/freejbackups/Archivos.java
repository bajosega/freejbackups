package freejbackups;

import java.io.File;
import java.sql.Date;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Vector;
import static freejbackups.Archivos.archivos;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @"freejbakcups" por Adrian Seimandi - bajosega@gmail.com - @2014
 */

public class Archivos {
    
    static int  conteoFiles = 0;
    static int  conteoDIRs = 0;
    static long  TamañoTotal = 0;
    static Vector<String> archivos =new Vector<String>();
    
   public static void listarDirectorio(File f){
       File[] ficheros = f.listFiles();                      
       for (File fichero : ficheros) {
          if (fichero.isDirectory()) {
               conteoDIRs++;  
               EscribirArchivo("d;"+fichero.getPath()+";null");
               listarDirectorio(fichero);
           }else
          {
          conteoFiles++; 
          archivos.add(fichero.getPath().toString());      
          //EscribirArchivo("f;"+fichero.getPath()+";"+TamañoArchivo(fichero));
          CalcularTamaño(fichero);
          }
       }
   } 
   
   public static int GetCantArchivos(){
   return  conteoFiles;
   }
   public static int GetCantDirectorios(){
   return  conteoDIRs;
   }
   
   public static long GetTamañoTotal(){
   return  TamañoTotal;
   }
   
   public static Vector<String> GetArchivos(){
       return archivos;
   }
   
   public static String TamañoArchivo(File fichero){
   DecimalFormat formateador = new DecimalFormat("0");
   return  formateador.format((fichero.length()/1024.0));
   }
   
   public static void CalcularTamaño(File fichero){
   TamañoTotal += ((fichero.length()/1024.0)); 
   }
     
   public static String fechaModificado(File fichero){
       long ms = fichero.lastModified();
            Date d = new Date(ms);
            Calendar c = new GregorianCalendar();
            c.setTime(d);
            String dia = Integer.toString(c.get(Calendar.DATE));
            String  mes = Integer.toString((c.get(Calendar.MONTH) + 1)) ;
            String  annio = Integer.toString(c.get(Calendar.YEAR));
            String  hora = Integer.toString(c.get(Calendar.HOUR_OF_DAY));
            String  minuto = Integer.toString(c.get(Calendar.MINUTE));
            String segundo = Integer.toString(c.get(Calendar.SECOND));
       return annio +"-"+ mes +"-"+ dia +" "+ hora +":"+ minuto +":"+ segundo ;
   }
   
   public static void EscribirArchivo(String linea){
        FileWriter fichero = null;
        PrintWriter pw = null;
    try {   
            fichero = new FileWriter("log/archivos.txt",true);
            pw = new PrintWriter(fichero);
            pw.println(linea);
            fichero.close();
       } catch (IOException e) {
       historial.logError(e.getMessage());
       }
   }
   
   
        
}
