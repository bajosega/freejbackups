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

package datos;

import static freejbackups.historial.jdatetime;
import javax.swing.JOptionPane;

public class planes extends operaciones{
    
    public  void GuardarPlan(String Nombre,String origenes[],String destino){
        // primero guardo en la tabla Plan . 
    String sql;
    boolean guardado = true;
    
    sql = "insert into plan"
            + " (nombre,fechaCreado)"
            + " values"
            + " ('"+Nombre+"','" + jdatetime() +"')";    
      if ( insertar(sql))
      {   // como se guardo correctamente ,tengo que gurdar los detalles del plan. 
        for (String origen : origenes)
        {
              sql = "insert into plan_detalle"
                      + " (nombre,origen,destino)"
                      + " values"
                      + " ('"+Nombre+"','" + origen +"',' "+ destino + "')";
              if (!insertar(sql)){    
               guardado = false;
              } 
        }
      }
      else  
      {
          guardado = false;
      }    
     if (guardado) JOptionPane.showMessageDialog(null, "EL PLAN SE AGREGO CORRECTAMENTE");
     else  JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR EL PLAN");
    }  
    
   public  void InsertarPlan(String sql){
       insertar("INSERT INTO plan (nombre, fechaCreado, ultimaEjecucion, estado, activo) " +
                "VALUES (" + sql +")");
   }   
}
