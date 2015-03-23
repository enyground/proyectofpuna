/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vista;

import controlador.ProveedorControlador;
import java.awt.Component;
import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import static javax.swing.JOptionPane.YES_OPTION;
import static javax.swing.JOptionPane.showConfirmDialog;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.table.DefaultTableModel;
import model.Proveedor;

/**
 *
 * @author admin
 */
public class ProveedorForm extends javax.swing.JDialog {

    /**
     * Creates new form Proveedor
     * @param parent
     */
    public ProveedorForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
    }

        public ProveedorForm() {
        
        initComponents();
        establecerBotones("Vacio");
        JRci.setSelected(true);
        labelGuion.setVisible(false);
        txtdv.setVisible(false);
        JRparticular.setSelected(true);
        getProveedores();
        
        
    }
    
    Proveedor pro = new Proveedor();
    
    ProveedorControlador proBD = new ProveedorControlador();
    private final Component msg_error=null;
    Mensaje err = new Mensaje(msg_error); 

    
  
   
    
        private void nuevo() {
        limpiar();
        establecerBotones("Nuevo");
        txtCodigo.setEditable(true);
        CBestado.setSelectedIndex(0);
        CBestado.setEnabled(false);
        txtdv.setEditable(false);
        try {
            txtCodigo.requestFocusInWindow();     
        } catch (Exception ex) {
            showMessageDialog(null, ex, "Error", ERROR_MESSAGE);
        }
       
        }
        private void limpiar() {
        txtCodigo.setText("");
        txtci.setText("");
        txtdv.setText("");
        txtNombre.setText("");      
        txtApellido.setText("");
        txtDireccion.setText("");
        txtTelefono.setText(""); 
        
        if(tbProveedor.getRowCount() == 0){
            establecerBotones("Vacio");
        }
        }
        
       private void guardar(){

            pro.setCodProveedor(txtCodigo.getText());
            pro.setNombre(txtNombre.getText());
            pro.setApellido(txtApellido.getText()); 
            pro.setDireccion(txtDireccion.getText()); 
            pro.setCi(txtci.getText());
            pro.setDv(txtdv.getText());
            pro.setTelefono(txtTelefono.getText());
            pro.setEstado(CBestado.getSelectedItem().toString());
           
           
         if (bNuevo.isEnabled() == false) { //is Enable true - habilita boton 
                try {
                    proBD.insert(pro);
                    nuevo();
                    getProveedores();
                } catch (Exception ex) {
                    showMessageDialog(null, ex, "Error", ERROR_MESSAGE);
                }
            } else {
                 try {
                    proBD.update(pro);
                    limpiar();              
                    getProveedores();
                } catch (Exception ex) {
                    showMessageDialog(null, ex, "Error", ERROR_MESSAGE);
                }
             
                
            }
         
    }
     private void cancelar(){
        if(showConfirmDialog (null, "Está seguro de cancelar la operación?", "Confirmar", YES_NO_OPTION) == YES_OPTION){
            limpiar();
            txtCodigo.setEditable(false);
            CBestado.setEnabled(true);
            txtdv.setEditable(false);
            getProveedores();
            establecerBotones("Edicion");
        }
    }
    private void borrar(){
        if(showConfirmDialog (null, "Está seguro de eliminar el componente seleccionado?", "Confirmar", YES_NO_OPTION) == YES_OPTION){
            try {
                proBD.delete(tbProveedor.getValueAt(tbProveedor.getSelectedRow(), 0).toString());
                limpiar();
                getProveedores();
            } catch (Exception ex) {
                showMessageDialog(null, ex, "Error", ERROR_MESSAGE);
            }
        }
    }
       
        
    private void getProveedores() {
        try {
            DefaultTableModel modelo = new DefaultTableModel();
            tbProveedor.setModel(modelo);
            try (ResultSet rs = proBD.datos()) {
                ResultSetMetaData rsMd = rs.getMetaData();
                
                int cantidadColumnas = rsMd.getColumnCount();
                
                for (int i = 1; i <= cantidadColumnas; i++) {
                    modelo.addColumn(rsMd.getColumnLabel(i));
                }

                while (rs.next()) {
                    Object[] fila = new Object[cantidadColumnas];
                    for (int i = 0; i < cantidadColumnas; i++) {
                        fila[i]=rs.getObject(i+1);
                    }
                    modelo.addRow(fila);
                }
            } catch (Exception ex) {
                showMessageDialog(null,  ex, "Error", JOptionPane.WARNING_MESSAGE);
            }
        } catch (HeadlessException ex) {
            showMessageDialog(null, ex, "Error", ERROR_MESSAGE);
        }
    }
    
    
    
        
        
        
        
        
        private void establecerBotones(String modo) {
        switch (modo) {
            case "Nuevo":
                bNuevo.setEnabled(false);
                bBorrar.setEnabled(false);
                bCancelar.setEnabled(true);
                bGuardar.setEnabled(true);
                break;
            case "Edicion":
                bNuevo.setEnabled(true);
                bBorrar.setEnabled(true);
                bCancelar.setEnabled(false);
                bGuardar.setEnabled(true);
                break;
            case "Vacio":
                bNuevo.setEnabled(true);
                bBorrar.setEnabled(false);
                bCancelar.setEnabled(false);
                bGuardar.setEnabled(false);
                break;
        }
    }
  private String Pa_Calcular_Dv_11_A(String p_numero, int p_basemax) {
  int v_total, v_resto, k, v_numero_aux, v_digit;
  String v_numero_al = "";
  String v_digit2;
      
  for (int i = 0; i < p_numero.length(); i++) {
    char c = p_numero.charAt(i);
    if(Character.isDigit(c)) {
      v_numero_al += c;
    } else {
      v_numero_al += (int) c;
    }
  }
      
  k = 2;
  v_total = 0;
      
  for(int i = v_numero_al.length() - 1; i >= 0; i--) {
    k = k > p_basemax ? 2 : k;
    v_numero_aux = v_numero_al.charAt(i) - 48;
    v_total += v_numero_aux * k++;
  }
      
  v_resto = v_total % 11;
  v_digit = v_resto > 1 ? 11 - v_resto : 0;
  
      
  return Integer.toString(v_digit);
}
        
  

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GrupoBotonEmpresa = new javax.swing.ButtonGroup();
        GrupoBotonCedula = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        LabelApellido = new javax.swing.JLabel();
        direccion = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        bNuevo = new javax.swing.JButton();
        bGuardar = new javax.swing.JButton();
        bCancelar = new javax.swing.JButton();
        bBorrar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbProveedor = new javax.swing.JTable();
        CBestado = new javax.swing.JComboBox();
        JRruc = new javax.swing.JRadioButton();
        JRci = new javax.swing.JRadioButton();
        txtci = new javax.swing.JTextField();
        txtdv = new javax.swing.JTextField();
        JRparticular = new javax.swing.JRadioButton();
        JRempresa = new javax.swing.JRadioButton();
        labelGuion = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Proveedores");

        jLabel1.setText("Codigo:");

        jLabel2.setText("Nombre:");

        LabelApellido.setText("Apellido:");

        direccion.setText("Direccion:");

        jLabel6.setText("Telefono/Celular:");

        jLabel7.setText("Estado:");

        txtCodigo.setColumns(10);
        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });
        txtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoKeyTyped(evt);
            }
        });

        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        txtApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidoKeyTyped(evt);
            }
        });

        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });
        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });

        txtDireccion.setCursor(new java.awt.Cursor(java.awt.Cursor.N_RESIZE_CURSOR));
        txtDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionActionPerformed(evt);
            }
        });

        bNuevo.setText("Nuevo");
        bNuevo.setToolTipText("");
        bNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNuevoActionPerformed(evt);
            }
        });

        bGuardar.setText("Guardar");
        bGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bGuardarActionPerformed(evt);
            }
        });

        bCancelar.setText("Cancelar");
        bCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bCancelarMouseClicked(evt);
            }
        });

        bBorrar.setText("Borrar");
        bBorrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bBorrarMouseClicked(evt);
            }
        });

        tbProveedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbProveedor.setToolTipText("");
        tbProveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbProveedorMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbProveedor);

        CBestado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ACTIVO", "INACTIVO", " " }));
        CBestado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CBestadoMouseClicked(evt);
            }
        });
        CBestado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CBestadoActionPerformed(evt);
            }
        });

        GrupoBotonCedula.add(JRruc);
        JRruc.setText("RUC");
        JRruc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JRrucMouseClicked(evt);
            }
        });
        JRruc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JRrucActionPerformed(evt);
            }
        });

        GrupoBotonCedula.add(JRci);
        JRci.setText("CI");
        JRci.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JRciMouseClicked(evt);
            }
        });
        JRci.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JRciActionPerformed(evt);
            }
        });

        txtci.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtciFocusLost(evt);
            }
        });
        txtci.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtciKeyTyped(evt);
            }
        });

        txtdv.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtdvKeyTyped(evt);
            }
        });

        GrupoBotonEmpresa.add(JRparticular);
        JRparticular.setText("Particular");
        JRparticular.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JRparticularMouseClicked(evt);
            }
        });

        GrupoBotonEmpresa.add(JRempresa);
        JRempresa.setText("Empresa");
        JRempresa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JRempresaMouseClicked(evt);
            }
        });
        JRempresa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JRempresaKeyTyped(evt);
            }
        });

        labelGuion.setText("-");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LabelApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(82, 82, 82)
                                .addComponent(JRruc, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JRci)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtci, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelGuion, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtdv, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(175, 175, 175)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(direccion, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CBestado, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 635, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(JRparticular)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(JRempresa))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(311, 311, 311)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(bCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(bGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(bBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(bNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 22, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JRruc)
                    .addComponent(JRci)
                    .addComponent(txtci, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtdv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bNuevo)
                    .addComponent(labelGuion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(direccion)
                    .addComponent(bGuardar))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LabelApellido)
                            .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CBestado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(bCancelar)
                            .addComponent(JRempresa)
                            .addComponent(JRparticular))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bBorrar)
                            .addComponent(jLabel2))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void bNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNuevoActionPerformed
     nuevo();   
    }//GEN-LAST:event_bNuevoActionPerformed
    private void formWindowOpened(java.awt.event.WindowEvent evt) {       
        nuevo();
        getProveedores();
    }  
    private void tbProveedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbProveedorMouseClicked
        String ced = tbProveedor.getValueAt(tbProveedor.getSelectedRow(), 1).toString();
        
       
        
        //busca la posicion en la que se encuentra el guion
        
        
        // variable dv que almacena el dígito verificador en caso de que sea un ruc
        char dv = ced.charAt(ced.length()-1);
        
        if (evt.isMetaDown()){
            return;
        } else {
            if (bNuevo.isEnabled() == true) {
                
                //Averiguo si es un RUC 
                if(ced.indexOf('-') != -1){
                    int posGuion = ced.indexOf('-');
                    txtdv.setVisible(true);
                    labelGuion.setVisible(true);
                    txtdv.setText(Character.toString(dv));
                    JRruc.setSelected(true);
                    txtci.setText(ced.substring(0, posGuion));
                     
                }else{
                    txtdv.setText("");
                    txtdv.setVisible(false);
                    labelGuion.setVisible(false);
                    JRci.setSelected(true);
                    txtci.setText(tbProveedor.getValueAt(tbProveedor.getSelectedRow(), 1).toString());   
                }
               
                // si apellido es null entonces es una empresa
                if(tbProveedor.getValueAt(tbProveedor.getSelectedRow(), 3).toString().equals("")){
                    LabelApellido.setVisible(false);
                    JRempresa.setSelected(true);
                    txtApellido.setText("");
                    txtApellido.setVisible(false);
                }else{
                    JRparticular.setSelected(true);
                    LabelApellido.setVisible(true);
                    txtApellido.setVisible(true);
                    txtApellido.setText(tbProveedor.getValueAt(tbProveedor.getSelectedRow(), 3).toString());
                }
                txtCodigo.setText(tbProveedor.getValueAt(tbProveedor.getSelectedRow(), 0).toString());
                txtNombre.setText(tbProveedor.getValueAt(tbProveedor.getSelectedRow(), 2).toString());
                txtDireccion.setText(tbProveedor.getValueAt(tbProveedor.getSelectedRow(), 4).toString());
                txtTelefono.setText(tbProveedor.getValueAt(tbProveedor.getSelectedRow(), 5).toString());
                CBestado.setSelectedItem(tbProveedor.getValueAt(tbProveedor.getSelectedRow(), 6).toString());
            }
        }
    }//GEN-LAST:event_tbProveedorMouseClicked

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoActionPerformed

    private void bGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bGuardarActionPerformed
        /*if ("".equals(txtCodigo.getText())) {
            showMessageDialog(null, "Debe ingresar el codigo", "Error", JOptionPane.WARNING_MESSAGE);
            txtCodigo.requestFocusInWindow();       
        } else if ("".equals(txtNombre.getText())) {
           showMessageDialog(null, "Debe ingresar el nombre", "Error", JOptionPane.WARNING_MESSAGE);
             txtNombre.requestFocusInWindow(); 
        } else  if  ("".equals(txtApellido.getText())) {
           showMessageDialog(null, "Debe ingresar el apellido", "Error", JOptionPane.WARNING_MESSAGE);
             txtApellido.requestFocusInWindow(); 
        }*/
        if ("".equals(txtCodigo.getText())) {
            err.camposVacios(evt, "codigos");
            txtCodigo.requestFocusInWindow();       
        } else if ("".equals(txtNombre.getText())) {
             err.camposVacios(evt, "nombre");
             txtNombre.requestFocusInWindow(); 
        } else  if  ("".equals(txtApellido.getText()) && JRparticular.isSelected()) {
             err.camposVacios(evt, "apellido");
             txtApellido.requestFocusInWindow(); 
        }
        
        else { guardar();}
    }//GEN-LAST:event_bGuardarActionPerformed

    private void bCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bCancelarMouseClicked
       if (evt.isMetaDown()){
            return;
        } else {
            cancelar();
        }
    }//GEN-LAST:event_bCancelarMouseClicked

    private void bBorrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bBorrarMouseClicked
         if (evt.isMetaDown()){
            return;
        } else {
            borrar();
            limpiar();
            getProveedores();
        }
    }//GEN-LAST:event_bBorrarMouseClicked

    private void CBestadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CBestadoMouseClicked
       
    }//GEN-LAST:event_CBestadoMouseClicked

    private void JRrucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JRrucActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JRrucActionPerformed

    private void txtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionActionPerformed

    private void JRciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JRciActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JRciActionPerformed

    private void CBestadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CBestadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CBestadoActionPerformed

    private void JRrucMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JRrucMouseClicked
       if (evt.isMetaDown()){
            return;
        } else {
     
            txtdv.setVisible(true);
            labelGuion.setVisible(true);
            txtci.requestFocusInWindow();
            //txtdv.setText((Pa_Calcular_Dv_11_A(txtci.getText(), 11)));    
        }
    }//GEN-LAST:event_JRrucMouseClicked

    private void JRciMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JRciMouseClicked
      
         txtdv.setVisible(false);
         labelGuion.setVisible(false);
          txtci.requestFocusInWindow();
         
    }//GEN-LAST:event_JRciMouseClicked

    private void txtCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyTyped
        if(txtCodigo.getText().length()>9){
             evt.consume();  
        }
    }//GEN-LAST:event_txtCodigoKeyTyped

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
         char c = evt.getKeyChar();
         if(Character.isLetter(c))
         {
             getToolkit().beep();
             evt.consume();
         }   
        if(txtTelefono.getText().length()>14){
             evt.consume();  
        }
    }//GEN-LAST:event_txtTelefonoKeyTyped

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        char c = evt.getKeyChar();
         if(Character.isDigit(c))
         {
             getToolkit().beep();
             evt.consume();
         }   
        if(txtNombre.getText().length()>14){
             evt.consume();  
        }
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtApellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoKeyTyped
          char c = evt.getKeyChar();
         if(Character.isDigit(c))
         {
             getToolkit().beep();
             evt.consume();
         }   
        if(txtApellido.getText().length()>14){
             evt.consume();  
        }
    }//GEN-LAST:event_txtApellidoKeyTyped

    private void txtciKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtciKeyTyped
          if(txtci.getText().length()>7){
             evt.consume();  
        }
    }//GEN-LAST:event_txtciKeyTyped

    private void txtdvKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdvKeyTyped
           char c = evt.getKeyChar();
         if(Character.isLetter(c))
         {
             getToolkit().beep();
             evt.consume();
         }   
        if(txtdv.getText().length()>0){
             evt.consume();  
        }
    }//GEN-LAST:event_txtdvKeyTyped

    private void JRparticularMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JRparticularMouseClicked
        if (evt.isMetaDown()){
            return;
        } else {
             
             txtApellido.setVisible(true);
             LabelApellido.setVisible(true);
            
          
             txtNombre.requestFocusInWindow();
            //txtdv.setText((Pa_Calcular_Dv_11_A(txtci.getText(), 11)));    
        }
        
        
      
    }//GEN-LAST:event_JRparticularMouseClicked

    private void JRempresaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JRempresaKeyTyped
       
        
        
    }//GEN-LAST:event_JRempresaKeyTyped

    private void JRempresaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JRempresaMouseClicked
              txtApellido.setVisible(false);
              LabelApellido.setVisible(false);
             txtNombre.requestFocusInWindow();
    }//GEN-LAST:event_JRempresaMouseClicked

    private void txtciFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtciFocusLost
         txtdv.setText((Pa_Calcular_Dv_11_A(txtci.getText(), 11))); 
    }//GEN-LAST:event_txtciFocusLost

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
            java.util.logging.Logger.getLogger(ProveedorForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProveedorForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProveedorForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProveedorForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ProveedorForm dialog = new ProveedorForm(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox CBestado;
    private javax.swing.ButtonGroup GrupoBotonCedula;
    private javax.swing.ButtonGroup GrupoBotonEmpresa;
    private javax.swing.JRadioButton JRci;
    private javax.swing.JRadioButton JRempresa;
    private javax.swing.JRadioButton JRparticular;
    private javax.swing.JRadioButton JRruc;
    private javax.swing.JLabel LabelApellido;
    private javax.swing.JButton bBorrar;
    private javax.swing.JButton bCancelar;
    private javax.swing.JButton bGuardar;
    private javax.swing.JButton bNuevo;
    private javax.swing.JLabel direccion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelGuion;
    private javax.swing.JTable tbProveedor;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtci;
    private javax.swing.JTextField txtdv;
    // End of variables declaration//GEN-END:variables

}
