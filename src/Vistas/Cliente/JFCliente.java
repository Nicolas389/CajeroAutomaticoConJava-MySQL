/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas.Cliente;

import Metodos.Metodos;
import Vistas.JFInicio;
import Vistas.JFPadre;
import java.awt.Color;
import javax.swing.JOptionPane;

public class JFCliente extends JFPadre {

    Metodos met = new Metodos();

    public JFCliente() {
        initComponents();
        this.labelTexto.setText("ELIJA UNA OPCION"); // cambia el texto bajo el logo
        this.btnCambiarClave.setBackground(Color.red); // cambia el color de los botones
        this.btnConsultarMovimientos.setBackground(Color.red);
        this.btnConsultarSaldo.setBackground(Color.red);
        this.btnDepositarDinero.setBackground(Color.red);
        this.btnRetirarDinero.setBackground(Color.red);
        this.btnTransferencia.setBackground(Color.red);
        this.btnSalir.setBackground(Color.red);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnTransferencia1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btnConsultarSaldo = new javax.swing.JButton();
        btnConsultarMovimientos = new javax.swing.JButton();
        btnRetirarDinero = new javax.swing.JButton();
        btnDepositarDinero = new javax.swing.JButton();
        btnTransferencia = new javax.swing.JButton();
        btnCambiarClave = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        btnTransferencia1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnTransferencia1.setForeground(new java.awt.Color(255, 255, 255));
        btnTransferencia1.setText("TRANSFERENCIA");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        btnConsultarSaldo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnConsultarSaldo.setForeground(new java.awt.Color(255, 255, 255));
        btnConsultarSaldo.setText("CONSULTAR SALDO");
        btnConsultarSaldo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarSaldoActionPerformed(evt);
            }
        });

        btnConsultarMovimientos.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnConsultarMovimientos.setForeground(new java.awt.Color(255, 255, 255));
        btnConsultarMovimientos.setText("CONSULTAR MOVIMIENTOS");
        btnConsultarMovimientos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarMovimientosActionPerformed(evt);
            }
        });

        btnRetirarDinero.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnRetirarDinero.setForeground(new java.awt.Color(255, 255, 255));
        btnRetirarDinero.setText("RETIRAR DINERO");
        btnRetirarDinero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetirarDineroActionPerformed(evt);
            }
        });

        btnDepositarDinero.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnDepositarDinero.setForeground(new java.awt.Color(255, 255, 255));
        btnDepositarDinero.setText("DEPOSITAR DINERO");
        btnDepositarDinero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDepositarDineroActionPerformed(evt);
            }
        });

        btnTransferencia.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnTransferencia.setForeground(new java.awt.Color(255, 255, 255));
        btnTransferencia.setText("TRANSFERENCIA");
        btnTransferencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTransferenciaActionPerformed(evt);
            }
        });

        btnCambiarClave.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnCambiarClave.setForeground(new java.awt.Color(255, 255, 255));
        btnCambiarClave.setText("CAMBIAR CLAVE");
        btnCambiarClave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarClaveActionPerformed(evt);
            }
        });

        btnSalir.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(255, 255, 255));
        btnSalir.setText("SALIR");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnTransferencia, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSalir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCambiarClave, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnConsultarSaldo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnRetirarDinero, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnDepositarDinero, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                            .addComponent(btnConsultarMovimientos, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(303, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConsultarSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConsultarMovimientos, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRetirarDinero, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDepositarDinero, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTransferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCambiarClave, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCambiarClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarClaveActionPerformed
        JFCambiarClave cc = new JFCambiarClave();
        
        this.setVisible(false);
        cc.setVisible(true);
    }//GEN-LAST:event_btnCambiarClaveActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        JFInicio in = new JFInicio();

        int resp = met.Confirmacion("¿Desea cerrar la sesion?", "CERRAR SESION");
        if (resp == 0) {
            this.setVisible(false);
            in.setVisible(true);
        }
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnTransferenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransferenciaActionPerformed
        JFTransf transf = new JFTransf();
        this.setVisible(false);
        transf.setVisible(true);

    }//GEN-LAST:event_btnTransferenciaActionPerformed

    private void btnConsultarSaldoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarSaldoActionPerformed
        JFConsultarSaldo consulta = new JFConsultarSaldo();
        this.setVisible(false);
        consulta.setVisible(true);
       
    }//GEN-LAST:event_btnConsultarSaldoActionPerformed

    private void btnRetirarDineroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetirarDineroActionPerformed
       JFRetirar re = new JFRetirar();
       this.setVisible(false);
       re.setVisible(true);
    }//GEN-LAST:event_btnRetirarDineroActionPerformed

    private void btnDepositarDineroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDepositarDineroActionPerformed
        JFDepositar Fdep = new JFDepositar();
        this.setVisible(false);
        Fdep.setVisible(true);
       
    }//GEN-LAST:event_btnDepositarDineroActionPerformed

    private void btnConsultarMovimientosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarMovimientosActionPerformed
        JFMovimientos Fmov = new JFMovimientos();
        this.setVisible(false);
        Fmov.setVisible(true);
    }//GEN-LAST:event_btnConsultarMovimientosActionPerformed

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
            java.util.logging.Logger.getLogger(JFCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCambiarClave;
    private javax.swing.JButton btnConsultarMovimientos;
    private javax.swing.JButton btnConsultarSaldo;
    private javax.swing.JButton btnDepositarDinero;
    private javax.swing.JButton btnRetirarDinero;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnTransferencia;
    private javax.swing.JButton btnTransferencia1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
