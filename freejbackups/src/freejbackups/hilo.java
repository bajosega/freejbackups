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

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import javax.swing.JOptionPane;

/**
 * 
 * implementacion de hilos gracias a la explicacion de Jorge V. http://codigoprogramacion.com/cursos/java/133-uso-de-hilos-o-threads-en-java.html#.U6zFHECTMUo
 * mas documentacion consultada http://leo.ugr.es/J2ME/CLDC/transjava/node11.html
 * @"freejbakcups" por Adrian Seimandi - bajosega@gmail.com - @2014
 */
public class hilo  extends Thread  {
private static final int BUFFER_SIZE = 4096;
private static ZipOutputStream zos;
String Directorios[];
String Destino;
static String Estado ;
static boolean continuar;     
long bytesRead = 0;
long bytesReadTotales = 0;

     
private static int ArchivosProcesados=0;

public hilo(String msg)
{
   super(msg);    
}

public void setFileName(String msj[])
{
    this.Directorios= msj;
}
 
 public void SetDestino(String msj)
{
     this.Destino = msj;
}

public String getEstado()
{
 return Estado;
}
 
public void detenElHilo()
   {
 
        continuar=false;
        Estado ="PARADO";
        // stop();
     
   }
 public void IniciarElHilo()
   {     
      if ("PARADO".equals(Estado)){
      continuar=true;
      Estado ="INICIADO";
      start();
      }else
      { // osea que estaba pausado
      ContinuarElHilo();
      }
   }
 
 public void PausarElHilo()
   {
      continuar=true;
      Estado ="PAUSADO";
      this.suspend();
   }
 
 public void ContinuarElHilo()
   {
      continuar=true;
      Estado ="INICIADO";
      this.resume();
   }
 
@Override
public void run()
{   
    historial.logCompresion(".");
    historial.logCompresion("COMENZANDO CON LA COMPRESION POR LOTES");        
        for (int i=0;i<(Directorios.length);i++)
        { 
            historial.logCompresion("..");    
            try {
                File obj = new File(Directorios[i]);
                // obtengo la lista de archivos
                historial.logCompresion("Leyendo directorio : " + obj.getName());
                Archivos.listarDirectorio(obj);   
                ArchivosProcesados=0;
                bytesReadTotales =0;
                //obtengo el tamaño total del directorio   Archivos.GetTamañoTotal();
                //obtengo la cantidad de archivos          Archivos.GetCantArchivos();
                //obtenter el directorio                   Archivos.GetCantDirectorios();    
                //PlanEjecutar.tblInfoProceso.setValueAt( Archivos.GetTamañoTotal(),i ,2) ; // tamaño
                PlanEjecutar.tblInfoProceso.setValueAt(Archivos.GetCantArchivos()  ,i ,3) ; // cantidad de archivos y directorios
                PlanEjecutar.tblInfoProceso.setValueAt( Archivos.GetTamañoTotal() + " KB",i ,4) ; // tamaño
        
               
               //creo el archivo ZIP
               ZipOutputStream zos;
               zos = new ZipOutputStream(new FileOutputStream(Destino+"/"+obj.getName()+".zip"));
                
                // informo que voy a empezar la compresion del directorio actual
                historial.logCompresion("Comprimiendo : " + obj.getName());
               
                // recorrro los archivos del directorio actual 
                for (int ii= 0 ;ii<Archivos.GetArchivos().size() ;ii++){
                    File file = new File(Archivos.GetArchivos().elementAt(ii));
                    PlanEjecutar.lblComprimiendoArchivo.setText(file.getPath());
                    agregarArchivoZip(file,zos); // agrego el archivos al zip actual  
                    ArchivosProcesados++; // cuenta los archivos que voy procesando
                    bytesReadTotales += file.length()/1024;
                    PlanEjecutar.tblInfoProceso.setValueAt(ArchivosProcesados,i ,1); // informo en el formulario los archivos procesados
                    PlanEjecutar.tblInfoProceso.setValueAt((bytesReadTotales) + " KB",i ,2) ; // tamaño procesado                
                }
              
                zos.flush();
                zos.close();
                
                // informo que termine con el directorio actual
                historial.logCompresion("Terminado : " + obj.getName());
                PlanEjecutar.lblComprimiendoArchivo.setText("---");
                
                
            } catch (IOException ex) {
                Logger.getLogger(hilo.class.getName()).log(Level.SEVERE, null, ex);
                historial.logError(ex.getMessage());
            }
            }// fin for proincipal
          
            JOptionPane.showMessageDialog(null, "RESGUARDO/s TERMINADO/s");
            historial.logCompresion("...");
            historial.logCompresion("RESGUARDO/s TERMINADO/s");
            historial.logCompresion(".....");
            PlanEjecutar.btnIniciar.setEnabled(false);
            PlanEjecutar.btnParar.setEnabled(false);
            PlanEjecutar.btnPausar.setEnabled(false);
            
}
     

private void agregarArchivoZip(File file, ZipOutputStream zos)
       {
    try {
       
        // agregado
       String fileSinUrl;
       fileSinUrl= file.getPath().substring(file.getPath().lastIndexOf( File.separator )+1); 
       zos.putNextEntry(new ZipEntry(fileSinUrl));
       // agregado
       
       // borrado
        //zos.putNextEntry(new ZipEntry(file.getPath()));
       
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
        
        byte[] bytesIn = new byte[BUFFER_SIZE];
        int read = 0;
        while ((read = bis.read(bytesIn)) != -1) {
            zos.write(bytesIn, 0, read);
            bytesRead += read;
        }
        zos.closeEntry();
    } catch (IOException ex) {
        Logger.getLogger(hilo.class.getName()).log(Level.SEVERE, null, ex);
          historial.logError(ex.getMessage());
    }
    }


}



