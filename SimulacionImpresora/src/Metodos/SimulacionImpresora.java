/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodos;

import java.awt.Dimension;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Armando
 */
public class SimulacionImpresora {

    private static JDesktopPane PanelPrincipal;

    public SimulacionImpresora(JDesktopPane jDesktopPane) {
        SimulacionImpresora.PanelPrincipal = jDesktopPane;
    }

    public void abrirSimulacion(JInternalFrame frmImpresora) {
        Dimension escritorioSize = this.PanelPrincipal.getSize();
        Dimension frmSimulacionSize = frmImpresora.getSize();

        frmImpresora.setLocation((escritorioSize.width - frmSimulacionSize.width) / 2, (escritorioSize.height - frmSimulacionSize.height) / 2);
        if (frmImpresora.isVisible()) {

            frmImpresora.toFront();
            frmImpresora.requestFocus();

        } else {
            PanelPrincipal.add(frmImpresora);
            frmImpresora.setVisible(true);
           
        }

    }
    
    
    public static void Imprimiendo(){
        
    }
}
