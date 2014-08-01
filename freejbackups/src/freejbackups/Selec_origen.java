package freejbackups;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @"freejbakcups" por Adrian Seimandi - bajosega@gmail.com - @2014
 */
public class Selec_origen extends javax.swing.JFrame {
  
    public Selec_origen() {
        initComponents();
        setLocationRelativeTo(null); // para centrar el formulario en pantalla
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser3 = new javax.swing.JFileChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jFileChooser3.setDialogTitle("Seleccion directorio");
        jFileChooser3.setFileFilter(null);
        jFileChooser3.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);
        jFileChooser3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFileChooser3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jFileChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, 732, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jFileChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jFileChooser3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFileChooser3ActionPerformed
         
         if ("ApproveSelection".equals(evt.getActionCommand().toString()))
         {
          llenarTabla (jFileChooser3.getSelectedFile().toPath().toString(),"...","...");      
          System.out.println("-Modificado Origen ---------");
          System.out.println(jFileChooser3.getSelectedFile().toPath());
        //  historial.historial("Modificado Origen " + jFileChooser3.getSelectedFile().toPath());
          dispose();
         }
         
         if ("CancelSelection".equals(evt.getActionCommand().toString()))
         {
          dispose();
         }        
    }//GEN-LAST:event_jFileChooser3ActionPerformed

    
     private void llenarTabla(String directorio,String Archivos,String Tamaño){
        DefaultTableModel tablamodal = (DefaultTableModel)PlanCrear.tblDirectorios.getModel();
        String [] fila = new String[3];
        fila[0]=directorio;
        fila[1]=Archivos;
        fila[2]=Tamaño;
        tablamodal.addRow(fila);
        PlanCrear.tblDirectorios.setModel(tablamodal);
    }
       
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Selec_origen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Selec_origen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Selec_origen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Selec_origen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Selec_origen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser jFileChooser3;
    // End of variables declaration//GEN-END:variables
}
