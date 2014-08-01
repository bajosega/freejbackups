package freejbackups;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @"jbakcups" por Adrian Seimandi - bajosega@gmail.com - @2014
 */
public class Varios {
    private void llenarJtable(JTable jotaTable,String[] Datos){
        DefaultTableModel tablamodal = (DefaultTableModel)jotaTable.getModel();
        tablamodal.addRow(Datos);
        jotaTable.setModel(tablamodal);
    }
}
