/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import static implementacion.EstructuraGeneral.interfaz;
import javax.swing.JOptionPane;

/**
 *
 * @author erikssonherlo
 */
public class ModificarUsuario extends javax.swing.JFrame {

    /**
     * Creates new form Interfaz
     */
    public ModificarUsuario() {
        initComponents();
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
        buscarUsuario = new javax.swing.JButton();
        menuInicial = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        codigoUsuario = new javax.swing.JTextField();
        crearUsuario1 = new javax.swing.JButton();
        codigoUsuarioEncontrado = new javax.swing.JLabel();
        nuevoCodigoUsuario = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(650, 500));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Titulo.setFont(new java.awt.Font("DejaVu Serif Condensed", 1, 40)); // NOI18N
        Titulo.setForeground(new java.awt.Color(1, 1, 1));
        Titulo.setText("GENERADOR DE IMAGENES");
        getContentPane().add(Titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 590, 53));

        Salir.setBackground(new java.awt.Color(43, 46, 46));
        Salir.setFont(new java.awt.Font("DejaVu Serif Condensed", 1, 15)); // NOI18N
        Salir.setForeground(new java.awt.Color(250, 250, 244));
        Salir.setText("Salir");
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });
        getContentPane().add(Salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 390, 230, 40));

        buscarUsuario.setBackground(new java.awt.Color(43, 46, 46));
        buscarUsuario.setFont(new java.awt.Font("DejaVu Serif Condensed", 1, 15)); // NOI18N
        buscarUsuario.setForeground(new java.awt.Color(250, 250, 244));
        buscarUsuario.setText("Buscar Usuario");
        buscarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarUsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(buscarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 120, 230, 40));

        menuInicial.setBackground(new java.awt.Color(43, 46, 46));
        menuInicial.setFont(new java.awt.Font("DejaVu Serif Condensed", 1, 15)); // NOI18N
        menuInicial.setForeground(new java.awt.Color(250, 250, 244));
        menuInicial.setText("Volver al Menu Inicial");
        menuInicial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuInicialActionPerformed(evt);
            }
        });
        getContentPane().add(menuInicial, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 330, 230, 40));

        jLabel1.setFont(new java.awt.Font("Ubuntu", 0, 20)); // NOI18N
        jLabel1.setText("Codigo: ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, 90, 30));
        getContentPane().add(codigoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, 230, -1));

        crearUsuario1.setBackground(new java.awt.Color(43, 46, 46));
        crearUsuario1.setFont(new java.awt.Font("DejaVu Serif Condensed", 1, 15)); // NOI18N
        crearUsuario1.setForeground(new java.awt.Color(250, 250, 244));
        crearUsuario1.setText("Modificar Usuario");
        crearUsuario1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearUsuario1ActionPerformed(evt);
            }
        });
        getContentPane().add(crearUsuario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 260, 230, 40));

        codigoUsuarioEncontrado.setFont(new java.awt.Font("Ubuntu", 0, 20)); // NOI18N
        codigoUsuarioEncontrado.setText("user");
        getContentPane().add(codigoUsuarioEncontrado, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 180, 210, 30));
        getContentPane().add(nuevoCodigoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, 230, -1));

        jLabel3.setFont(new java.awt.Font("Ubuntu", 0, 20)); // NOI18N
        jLabel3.setText("Nuevo Codigo:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, 150, 30));

        jLabel4.setFont(new java.awt.Font("Ubuntu", 0, 20)); // NOI18N
        jLabel4.setText("Usuario Encontrado:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 210, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
        System.exit(0);
        // TODO add your handling code here:
    }//GEN-LAST:event_SalirActionPerformed

    private void buscarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buscarUsuarioActionPerformed

    private void menuInicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuInicialActionPerformed
        interfaz.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_menuInicialActionPerformed

    private void crearUsuario1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearUsuario1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_crearUsuario1ActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Salir;
    private javax.swing.JLabel Titulo;
    private javax.swing.JButton buscarUsuario;
    private javax.swing.JTextField codigoUsuario;
    private javax.swing.JLabel codigoUsuarioEncontrado;
    private javax.swing.JButton crearUsuario1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton menuInicial;
    private javax.swing.JTextField nuevoCodigoUsuario;
    // End of variables declaration//GEN-END:variables
}
