/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Metodos.Cargardatos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Armando
 */
public class GUIPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form GUIPrincipal
     */
    public static JdImpresora jdimpresora;

    public GUIPrincipal() {
        super();
        initComponents();
        timerA = new Timer(5000, Tinicio);
        timerB = new Timer(2000, Tfinal);
        setResizable(false);
        Cargardatos.ButtonBloqueo(btnInicialsimulacion);

    }
    JdImpresora JventanaImprimiendo;
    private Timer timerA, timerB;

    private final ActionListener Tinicio = new ActionListener() {

        @Override

        public void actionPerformed(ActionEvent e) {
            if (Cargardatos.current()) {
                Cargardatos.FirstDelete();

                DefaultTableModel modeltab = (DefaultTableModel) tbtArchivos.getModel();
                modeltab.removeRow(0);

                tbtArchivos.setModel(modeltab);
                JventanaImprimiendo.Obtenerarreglo(Cargardatos.FirstElement());
                JventanaImprimiendo.setVisible(false);

                timerB.start();
            }
            timerA.stop();
        }

    };

    private final ActionListener Tfinal = new ActionListener() {

        @Override

        public void actionPerformed(ActionEvent e) {
            JventanaImprimiendo.setVisible(true);

            timerA.start();
            timerB.stop();
        }

    };

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbtArchivos = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        btnCargardatos = new javax.swing.JButton();
        btnInicialsimulacion = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Simulacion de una cola de Impresion");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 14, 600, 40));

        tbtArchivos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "                  Archivos"
            }
        ));
        jScrollPane1.setViewportView(tbtArchivos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 160, 120));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Printer_Folder_36848.png"))); // NOI18N
        jLabel2.setToolTipText("");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 80, -1, -1));

        btnCargardatos.setText("Cargar Datos");
        btnCargardatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargardatosActionPerformed(evt);
            }
        });
        jPanel1.add(btnCargardatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, -1, 40));

        btnInicialsimulacion.setText("Iniciar Simulacion");
        btnInicialsimulacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInicialsimulacionActionPerformed(evt);
            }
        });
        jPanel1.add(btnInicialsimulacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 230, -1, 40));

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 230, 70, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCargardatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargardatosActionPerformed
        // TODO add your handling code here:
        btnInicialsimulacion.setEnabled(true);
        Cargardatos.CargardatosEnJtable(tbtArchivos);
        Cargardatos.ButtonDesbloqueo(btnInicialsimulacion);

    }//GEN-LAST:event_btnCargardatosActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnInicialsimulacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicialsimulacionActionPerformed
        // TODO add your handling code here:
         JventanaImprimiendo = new JdImpresora(new javax.swing.JFrame(), false, Cargardatos.FirstElement());
         Cargardatos.ButtonBloqueo(btnInicialsimulacion);
        timerA.start();
    }//GEN-LAST:event_btnInicialsimulacionActionPerformed

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
            java.util.logging.Logger.getLogger(GUIPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCargardatos;
    private javax.swing.JButton btnInicialsimulacion;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbtArchivos;
    // End of variables declaration//GEN-END:variables
}
