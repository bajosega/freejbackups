package datos;


import static freejbackups.historial.jdatetime;
import javax.swing.JOptionPane;


/**
 *
 * @author aseimandi
 */
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
                      + " ('"+Nombre+"','" + origen +"','"+ destino + "')";
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
    
   
    
}
