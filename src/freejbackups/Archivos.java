/**
 *
 * @Copyright 2014 "freejbakcups" por Adrian Seimandi - bajosega@gmail.com 
 *  
 * This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program. If not, see <http://www.gnu.org/licenses/>.  
 */


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
               listarDirectorio(fichero);
           }else
          {
          conteoFiles++; 
          archivos.add(fichero.getPath().toString());      
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
            fichero = new FileWriter("log/historial.text",true);
            pw = new PrintWriter(fichero);
            pw.println(linea);
            fichero.close();
       } catch (IOException e) {
       historial.logError(e.getMessage());
       }
   }
          
}
