
package Metodos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dospino17
 */
public class Cargardatos extends javax.swing.JFrame {

    public static String ruta = System.getProperties().getProperty("user.dir");
    private static Cola<String> Elementos = new Cola<>();
    public static String FirstElement(){
        return Elementos.First();
    }
public static void FirstDelete() {
    
        Elementos.dequeue();
    }

    public static boolean current() {
        
        if (Elementos.isEmpty()) {
            return false;
        }
        return true;
    }
    
    
    public static void CargardatosEnJtable(JTable archivos) {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            archivo = new File(ruta + "\\spool.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            String info;

            DefaultListModel modelis = new DefaultListModel();
            DefaultTableModel modeltab = new DefaultTableModel();
            modeltab.addColumn("Archivos");

            while ((info = br.readLine()) != null) {
                Elementos.enqueue(info);
                modeltab.addRow(new String[]{info});

                archivos.setModel(modeltab);
            }

        } catch (IOException e) {
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (IOException e2) {

            }
        }
    }

    public static void CargardatosEnJtextFiel(JLabel archivos) {
       
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            archivo = new File(ruta + "\\spool.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
             
            String linea;
            
         while((linea=br.readLine())!=null)
         archivos.setText(linea);
         archivo.setExecutable(true);
         
         
      }
      catch(Exception e){
         e.printStackTrace();
      }finally{
         try{
            if( null != fr ){
               fr.close();
            }
         }catch (Exception e2){
            e2.printStackTrace();
         }
      } 
    }
    
    
       public static void ButtonBloqueo(JButton boton) {
        boton.setEnabled(false);
    }

    public static void ButtonDesbloqueo(JButton boton) {
        boton.setEnabled(true);
    }
}

