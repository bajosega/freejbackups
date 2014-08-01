package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
/**
 *
 * @author adrian
 */
public class conexion {
        Connection conexion;
	Statement consulta;
	public String ruta;
    
    public conexion(){
    ruta = "./datos/freejbackupsBase";    
    }
   
   public void conectar(){
	try {
        Class.forName("org.sqlite.JDBC");
	}
        catch (ClassNotFoundException e) {
	JOptionPane.showMessageDialog(null, e.getMessage());
	}	 
	try {
         conexion = DriverManager.getConnection("jdbc:sqlite:"+ruta);
         consulta = conexion.createStatement();
	} catch (SQLException e) {
         JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
}
