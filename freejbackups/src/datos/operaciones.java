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

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class operaciones extends conexion{

    public boolean insertar(String sql){
        boolean valor = true;
        conectar();
        try {
            consulta.executeUpdate(sql);
        } catch (SQLException e) {
                valor = false;
                System.out.println("Mensaje:"+e.getMessage());
                System.out.println("Estado:"+e.getSQLState());
                System.out.println("Codigo del error:"+e.getErrorCode());
                JOptionPane.showMessageDialog(null, ""+e.getMessage());
            }      
        finally{  
            try{    
                 consulta.close();  
                 conexion.close();  
             }catch (SQLException e){  
                System.out.println("Mensaje:"+e.getMessage());
                System.out.println("Estado:"+e.getSQLState());
                System.out.println("Codigo del error:"+e.getErrorCode());
                JOptionPane.showMessageDialog(null, ""+e.getMessage());
             }  
        }
        return valor;
    }

    public ResultSet consultar(String sql){
        conectar();
        ResultSet resultado = null;
        try {
            resultado = consulta.executeQuery(sql);

        } catch (SQLException e) {
                System.out.println("Mensaje:"+e.getMessage());
                System.out.println("Estado:"+e.getSQLState());
                System.out.println("Codigo del error:"+e.getErrorCode());
                JOptionPane.showMessageDialog(null, ""+e.getMessage());
            }
        return resultado;
    }
}