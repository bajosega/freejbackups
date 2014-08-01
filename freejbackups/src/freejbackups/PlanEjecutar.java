package freejbackups;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @"jbakcups" por Adrian Seimandi - bajosega@gmail.com - @2014
 */
 
public class PlanEjecutar extends javax.swing.JFrame {
hilo hilo1 = new hilo("hilo 1");

String[] directorios;
      
    public PlanEjecutar() {
        initComponents();
        setLocationRelativeTo(null);
        hilo1.detenElHilo();
        
        // busco los directorios que tengo que comprimir
        directorios = new String[PlanCrear.tblDirectorios.getRowCount()];    
        for (int i=0;i<PlanCrear.tblDirectorios.getRowCount();i++)
        {     
          directorios[i] = PlanCrear.tblDirectorios.getValueAt(i, 0).toString();       
          // pongo los directorios en la tabla 
          llenarTabla(directorios[i], "---", "---");
        }
        //inicio el HILO !! . 
        iniciar();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnPausar = new javax.swing.JButton();
        btnParar = new javax.swing.JButton();
        btnIniciar = new javax.swing.JButton();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jHistorial = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtErrores = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblInfoProceso = new javax.swing.JTable();
        panInfo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblComprimiendoArchivo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnPausar.setText("PAUSAR");
        btnPausar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPausarActionPerformed(evt);
            }
        });

        btnParar.setText("CANCELAR");
        btnParar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPararActionPerformed(evt);
            }
        });

        btnIniciar.setText("INICIAR");
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });

        jHistorial.setColumns(20);
        jHistorial.setRows(5);
        jScrollPane2.setViewportView(jHistorial);

        jTabbedPane4.addTab("historial", jScrollPane2);

        txtErrores.setColumns(20);
        txtErrores.setRows(5);
        jScrollPane3.setViewportView(txtErrores);

        jTabbedPane4.addTab("errores", jScrollPane3);

        tblInfoProceso.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ARCHIVO ZIP", "ARCHIVOS PROCESADOS", "TAMAÑO PROCESADO", "ARCHIVOS TOTALES", "TAMAÑO TOTAL"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblInfoProceso);

        jLabel1.setText("Comprimiendo archivo :");

        lblComprimiendoArchivo.setText("---");

        javax.swing.GroupLayout panInfoLayout = new javax.swing.GroupLayout(panInfo);
        panInfo.setLayout(panInfoLayout);
        panInfoLayout.setHorizontalGroup(
            panInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblComprimiendoArchivo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panInfoLayout.setVerticalGroup(
            panInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panInfoLayout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addGroup(panInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblComprimiendoArchivo))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnIniciar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPausar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnParar, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(551, Short.MAX_VALUE))
                    .addComponent(jScrollPane1)
                    .addComponent(panInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnParar)
                    .addComponent(btnPausar)
                    .addComponent(btnIniciar))
                .addGap(11, 11, 11)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPausarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPausarActionPerformed

        btnIniciar.setEnabled(true);
        btnParar.setEnabled(true);
        btnPausar.setEnabled(false);
        hilo1.PausarElHilo();

    }//GEN-LAST:event_btnPausarActionPerformed

    private void btnPararActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPararActionPerformed
        btnIniciar.setEnabled(true);
        btnParar.setEnabled(false);
        btnPausar.setEnabled(false);

        hilo1.detenElHilo();
        hilo1.stop();
        dispose();
        // y aca tengo que decir de alguna manera que si apreto iniciar tengo que volver a hacer todo desde cero
    }//GEN-LAST:event_btnPararActionPerformed

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed
       iniciar();
    }//GEN-LAST:event_btnIniciarActionPerformed

     private void llenarTabla(String ArchivoZIP,String Procesados,String Totales){
       // String [] titulos = {"Archivo ZIP","Procesados","Total Archivos"};
        DefaultTableModel tablamodal = (DefaultTableModel)tblInfoProceso.getModel();
        String [] fila = new String[3];
        fila[0]=ArchivoZIP;
        fila[1]=Procesados;
        fila[2]=Totales;
        tablamodal.addRow(fila);
        tblInfoProceso.setModel(tablamodal);
    }
  
    
    
    
    
    private void iniciar(){        
       String destino = PlanCrear.txtDestino.getText().toString();
        
        hilo1.setFileName(directorios);
        hilo1.SetDestino(destino); 
        hilo1.IniciarElHilo();    
        btnIniciar.setEnabled(false);
        btnParar.setEnabled(true);
        btnPausar.setEnabled(true);
                
    }
    
  
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
            java.util.logging.Logger.getLogger(PlanEjecutar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PlanEjecutar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PlanEjecutar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PlanEjecutar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PlanEjecutar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnIniciar;
    public static javax.swing.JButton btnParar;
    public static javax.swing.JButton btnPausar;
    public static javax.swing.JTextArea jHistorial;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane4;
    public static javax.swing.JLabel lblComprimiendoArchivo;
    private javax.swing.JPanel panInfo;
    public static javax.swing.JTable tblInfoProceso;
    public static javax.swing.JTextArea txtErrores;
    // End of variables declaration//GEN-END:variables
}
