/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vista;

import controlador.PermisoControlador;
import controlador.RolControlador;
import java.awt.HeadlessException;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import static javax.swing.JOptionPane.YES_OPTION;
import static javax.swing.JOptionPane.showConfirmDialog;
import static javax.swing.JOptionPane.showMessageDialog;
import model.Permisos;
import model.Rol;

/**
 *
 * @author anex
 */
public class RolForm extends javax.swing.JDialog {

    /**
     * Creates new form RolForm
     */
    public RolForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    public RolForm() {
        
        initComponents();
        establecerBotones("Vacio");  
    }
    Rol rolModel = new Rol();
    RolControlador rolBD = new RolControlador();
    HashSet permisos = new HashSet();
    private void establecerBotones(String modo) {
        switch (modo) {
            case "Nuevo":
                JBnuevo.setEnabled(false);
                JBborrar.setEnabled(false);
                JBcancelar.setEnabled(true);
                JBguardar.setEnabled(true);
                break;
            case "Edicion":
                JBnuevo.setEnabled(true);
                JBborrar.setEnabled(true);
                JBcancelar.setEnabled(false);
                JBguardar.setEnabled(true);
                break;
            case "Vacio":
                JBnuevo.setEnabled(true);
                JBborrar.setEnabled(false);
                JBcancelar.setEnabled(false);
                JBguardar.setEnabled(false);
                break;
            case "Buscar":
                JBnuevo.setEnabled(false);
                JBborrar.setEnabled(false);
                JBcancelar.setEnabled(true);
                JBguardar.setEnabled(false);
                break;
        }
    }
        private void nuevo() {
   
        limpiar();
        establecerBotones("Nuevo");
        try {
            txtnombreRol.requestFocusInWindow();     
        } catch (Exception ex) {
            showMessageDialog(null, ex.toString(), "Error", ERROR_MESSAGE);
        }
       
        }
        private void limpiar() {
        txtnombreRol.setText("");
        txtDescripcionRol.setText("");
        JRModuloFacturacion.setSelected(false);
        JRadministrarUsuario.setSelected(false);
        JRmoduloProyecto.setSelected(false);
        
     
        }
        private void guardar(){
    
       if (showConfirmDialog(null, "Está seguro de guardar los datos?", "Confirmar", YES_NO_OPTION) == YES_OPTION) {
                 
             if (txtnombreRol.getText().trim().isEmpty() == true) {
                showMessageDialog(this, "Campo rol vacío, por favor ingrese el nombre del rol", "", JOptionPane.WARNING_MESSAGE);
                return;
        }
          
           
         if (JBnuevo.isEnabled() == false) { //is Enable true - habilita boton 
                try {
                    if (JRadministrarUsuario.isSelected()){
                      permisos.add(new Permisos("Admin. Usuario"));
                       
                    }
                    if (JRModuloFacturacion.isSelected()){
                      permisos.add(new Permisos("Admin. Facturacion")); 
                    }
                    if (JRmoduloProyecto.isSelected()){
                      permisos.add(new Permisos("Admin. Proyecto")); 
                    }
                
                    rolBD.insert(txtnombreRol.getText(),txtDescripcionRol.getText(),permisos);
                      
                    nuevo();
                
                } catch (Exception ex) {
                    //showMessageDialog(null, "Debe ingresar la descripción.", "Atención", INFORMATION_MESSAGE); 
                    
                   showMessageDialog(null,ex.getMessage(), "Error", ERROR_MESSAGE);
                }
            } else {
                 try {
                    rolBD.insert(txtnombreRol.getText(),txtDescripcionRol.getText(),permisos);
                    showMessageDialog(null, "Actualizado correctamente");
                    limpiar();              
                } catch (Exception ex) {
                    showMessageDialog(null, ex, "Error", ERROR_MESSAGE);
                }
             
                
            }
         
         }
       }
        
       private void cancelar(){
        if(showConfirmDialog (null, "Está seguro de cancelar la operación?", "Confirmar", YES_NO_OPTION) == YES_OPTION){
            limpiar();
            establecerBotones("Edicion");
         
            
        }
       }
       
       private void borrar(){
        try {          
               //rolBD.delete(rolModel);
               showMessageDialog(null, "Operación exitosa"); 
               limpiar();
            } catch (HeadlessException ex) {
                showMessageDialog(null, ex, "Error", ERROR_MESSAGE);
            }
        }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtnombreRol = new javax.swing.JTextField();
        labelRol = new javax.swing.JLabel();
        labelDescripcion = new javax.swing.JLabel();
        txtDescripcionRol = new javax.swing.JTextField();
        JBnuevo = new javax.swing.JButton();
        JBguardar = new javax.swing.JButton();
        JBcancelar = new javax.swing.JButton();
        JBborrar = new javax.swing.JButton();
        JBbuscar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        labelPermisos = new javax.swing.JLabel();
        JRadministrarUsuario = new javax.swing.JRadioButton();
        JRmoduloProyecto = new javax.swing.JRadioButton();
        JRModuloFacturacion = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Administrar Roles");

        labelRol.setText("Rol:");

        labelDescripcion.setText("Descripcion:");

        JBnuevo.setText("Nuevo");
        JBnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBnuevoActionPerformed(evt);
            }
        });

        JBguardar.setText("Guardar");
        JBguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBguardarActionPerformed(evt);
            }
        });

        JBcancelar.setText("Cancelar");
        JBcancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBcancelarActionPerformed(evt);
            }
        });

        JBborrar.setText("Borrar");
        JBborrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBborrarActionPerformed(evt);
            }
        });

        JBbuscar.setText("Buscar");

        labelPermisos.setText("Permisos");

        JRadministrarUsuario.setText("Administrar Usuarios");

        JRmoduloProyecto.setText("Modulo Proyecto ");

        JRModuloFacturacion.setText("Modulo Facturacion");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(labelPermisos)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(JRadministrarUsuario)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JRModuloFacturacion)
                            .addComponent(JRmoduloProyecto))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(labelPermisos)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addComponent(JRadministrarUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JRmoduloProyecto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JRModuloFacturacion)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelDescripcion)
                            .addComponent(labelRol))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDescripcionRol, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtnombreRol, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JBcancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JBborrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JBguardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JBnuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JBbuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JBnuevo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JBguardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JBcancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JBborrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JBbuscar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtnombreRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelRol))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDescripcionRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelDescripcion))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JBnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBnuevoActionPerformed
        nuevo();
    }//GEN-LAST:event_JBnuevoActionPerformed

    private void JBguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBguardarActionPerformed
         guardar();
    }//GEN-LAST:event_JBguardarActionPerformed

    private void JBcancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBcancelarActionPerformed
        cancelar();
    }//GEN-LAST:event_JBcancelarActionPerformed

    private void JBborrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBborrarActionPerformed
        borrar();
    }//GEN-LAST:event_JBborrarActionPerformed

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
            java.util.logging.Logger.getLogger(RolForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RolForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RolForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RolForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                RolForm dialog = new RolForm(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBborrar;
    private javax.swing.JButton JBbuscar;
    private javax.swing.JButton JBcancelar;
    private javax.swing.JButton JBguardar;
    private javax.swing.JButton JBnuevo;
    private javax.swing.JRadioButton JRModuloFacturacion;
    private javax.swing.JRadioButton JRadministrarUsuario;
    private javax.swing.JRadioButton JRmoduloProyecto;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelDescripcion;
    private javax.swing.JLabel labelPermisos;
    private javax.swing.JLabel labelRol;
    private javax.swing.JTextField txtDescripcionRol;
    private javax.swing.JTextField txtnombreRol;
    // End of variables declaration//GEN-END:variables
}
