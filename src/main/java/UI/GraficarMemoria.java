/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import estructuras.MatrizDispersa;
import implementacion.ArchivosEntrada;
import implementacion.GeneradorGraphviz;
import implementacion.EstructuraGeneral;
import static implementacion.EstructuraGeneral.interfaz;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import nodos.NodoArbolAVL;
import nodos.NodoListaDobleCircular;

/**
 *
 * @author erikssonherlo
 */
public class GraficarMemoria extends javax.swing.JFrame {

    /**
     * Creates new form Interfaz
     */
    
    private EstructuraGeneral estructuraGeneral;
    private ArchivosEntrada archivosEntrada;
    private GeneradorGraphviz graficador;
    public GraficarMemoria() {
        initComponents();
        this.estructuraGeneral = new EstructuraGeneral();
        this.archivosEntrada = new ArchivosEntrada();
        this.graficador = new GeneradorGraphviz();
        lblBuscar.setVisible(false);
        txtBuscar.setVisible(false);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Titulo = new javax.swing.JLabel();
        Salir = new javax.swing.JButton();
        graficar = new javax.swing.JButton();
        menuAnterior = new javax.swing.JButton();
        informacionCapas = new javax.swing.JLabel();
        comboTipoGrafica = new javax.swing.JComboBox<>();
        lblBuscar = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(getPreferredSize());
        setSize(new java.awt.Dimension(850, 700));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Titulo.setFont(new java.awt.Font("DejaVu Serif Condensed", 1, 40)); // NOI18N
        Titulo.setForeground(new java.awt.Color(1, 1, 1));
        Titulo.setText("GENERADOR DE IMAGENES");
        getContentPane().add(Titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 590, 53));

        Salir.setBackground(new java.awt.Color(43, 46, 46));
        Salir.setFont(new java.awt.Font("DejaVu Serif Condensed", 1, 15)); // NOI18N
        Salir.setForeground(new java.awt.Color(250, 250, 244));
        Salir.setText("Salir");
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });
        getContentPane().add(Salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 420, 230, 40));

        graficar.setBackground(new java.awt.Color(43, 46, 46));
        graficar.setFont(new java.awt.Font("DejaVu Serif Condensed", 1, 15)); // NOI18N
        graficar.setForeground(new java.awt.Color(250, 250, 244));
        graficar.setText("Graficar");
        graficar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                graficarActionPerformed(evt);
            }
        });
        getContentPane().add(graficar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 260, 230, 40));

        menuAnterior.setBackground(new java.awt.Color(43, 46, 46));
        menuAnterior.setFont(new java.awt.Font("DejaVu Serif Condensed", 1, 15)); // NOI18N
        menuAnterior.setForeground(new java.awt.Color(250, 250, 244));
        menuAnterior.setText("Regresar al Menu Inicial");
        menuAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAnteriorActionPerformed(evt);
            }
        });
        getContentPane().add(menuAnterior, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 370, 230, 40));

        informacionCapas.setText("Tipo de Grafica a Generar:");
        getContentPane().add(informacionCapas, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 200, 40));

        comboTipoGrafica.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lista de Imagenes", "Arbol de Capas", "Capa", "Imagen y Arbol de Capas", "Arbol de Usuarios" }));
        comboTipoGrafica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTipoGraficaActionPerformed(evt);
            }
        });
        getContentPane().add(comboTipoGrafica, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 90, 280, -1));

        lblBuscar.setText("Buscar:");
        getContentPane().add(lblBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, 80, 30));
        getContentPane().add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 160, 280, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
        System.exit(0);
        // TODO add your handling code here:
    }//GEN-LAST:event_SalirActionPerformed

    private void graficarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_graficarActionPerformed
          switch (comboTipoGrafica.getSelectedIndex()) {
            case 0:
                //manejadorGraficas.graficarEstadoMemoria(manejadorPrincipal.getListaImagenes().dotCode(), "ListaImagenes", jPanel6);
                graficador.graficarEstadoMemoria(estructuraGeneral.getListaImagenes().dotCode(), "Lista_Doble_Imagenes");
                break;
            case 1:
                //manejadorGraficas.graficarEstadoMemoria(manejadorPrincipal.getArbolCapas().dotCode(), "ArbolCapas", jPanel6);
                 graficador.graficarEstadoMemoria(estructuraGeneral.getArbolCapas().dotCode(),"Arbol_AVL_Capas");
                break;
            case 2:
                NodoArbolAVL capaBuscada;
                String capaABuscar = txtBuscar.getText();
                //if((capaBuscada = manejadorPrincipal.getArbolCapas().buscar(capaABuscar)) != null) {
                if((capaBuscada = estructuraGeneral.getArbolCapas().buscar(capaABuscar)) != null) {
                    MatrizDispersa matrizObtenida = (MatrizDispersa) capaBuscada.getContenido();
                    //manejadorGraficas.graficarEstadoMemoria(matrizObtenida.dotCode(), "CapaSolicitada", jPanel6);
                    graficador.graficarEstadoMemoria(matrizObtenida.dotCode(), "Capa_Por_Medio_De_Busqueda");
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontró la capa " + capaABuscar);
                }
                break;
            case 3:
                NodoListaDobleCircular imagen;
                String imagenSolicitada = txtBuscar.getText();
                //if((imagen = manejadorPrincipal.getListaImagenes().buscar(imagenSolicitada)) != null) {
                 if((imagen = estructuraGeneral.getListaImagenes().buscar(imagenSolicitada)) != null) {
                    System.out.println(imagen.dotCode(estructuraGeneral.getArbolCapas()));
                    String codigo = imagen.dotCode(estructuraGeneral.getArbolCapas());
                   // manejadorGraficas.graficarEstadoMemoria(codigo, "ImagenConArbol", jPanel6);
                   graficador.graficarEstadoMemoria(codigo, "");
                } else {
                    JOptionPane.showMessageDialog(null, "No se ha encontrado la imagen: " + imagenSolicitada);
                }
                break;
            case 4:
                //manejadorGraficas.graficarEstadoMemoria(manejadorPrincipal.getArbolUsuarios().dotCode(), "ArbolUsuarios", jPanel6);
                graficador.graficarEstadoMemoria(estructuraGeneral.getArbolUsuarios().dotCode(), "Arbol_AVL_Usuarios");
                break;
            default:
                break;
        }
    }//GEN-LAST:event_graficarActionPerformed

    private void menuAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAnteriorActionPerformed
        interfaz.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_menuAnteriorActionPerformed

    private void comboTipoGraficaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTipoGraficaActionPerformed
        // TODO add your handling code here:
        switch(comboTipoGrafica.getSelectedIndex()) {
            case 0:
            lblBuscar.setVisible(false);
            txtBuscar.setVisible(false);
            break;
            case 1:
            lblBuscar.setVisible(false);
            txtBuscar.setVisible(false);
            break;
            case 2:
            lblBuscar.setVisible(true);
            txtBuscar.setVisible(true);
            break;
            case 3:
            lblBuscar.setVisible(true);
            txtBuscar.setVisible(true);
            break;
            case 4:
            lblBuscar.setVisible(false);
            txtBuscar.setVisible(false);
            break;
            default:
            lblBuscar.setVisible(false);
            txtBuscar.setVisible(false);
            break;
        }
    }//GEN-LAST:event_comboTipoGraficaActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Salir;
    private javax.swing.JLabel Titulo;
    private javax.swing.JComboBox<String> comboTipoGrafica;
    private javax.swing.JButton graficar;
    private javax.swing.JLabel informacionCapas;
    private javax.swing.JLabel lblBuscar;
    private javax.swing.JButton menuAnterior;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}