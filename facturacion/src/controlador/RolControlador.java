/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Set;
import javax.swing.JOptionPane;
import model.Rol;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 */
public class RolControlador {
    
    public void insert(String role, String descripcion, Set permiso) throws Exception {
      
        Session baseDatos = HibernateUtil.getSessionFactory().openSession();
        baseDatos.beginTransaction();
           
        try {
            Rol rol =new Rol(role, descripcion);
            rol.setPermisoses(permiso);
            baseDatos.save(rol);
            baseDatos.beginTransaction().commit();
        }  catch (org.hibernate.exception.ConstraintViolationException cve) {
    
            JOptionPane.showMessageDialog(null, "El rol ya existe. Error al insertar", 
                     "Error: ", JOptionPane.ERROR_MESSAGE);
        }catch(HibernateException e){
            e.getMessage();
        }
         
    }
    
   
     
    public void update(Rol rol) throws Exception{
        Session baseDatos = HibernateUtil.getSessionFactory().openSession();
        baseDatos.beginTransaction();
        
        try {
           
          
          baseDatos.update(rol);
        
         
          baseDatos.beginTransaction().commit();
        } catch(HibernateException e){
            throw new Exception("Error al modificar proveedor: \n" + e.getMessage());
        }
    }
    
   /* public void update(Proveedor prov) throws Exception {
        Session baseDatos = HibernateUtil.getSessionFactory().openSession();
        baseDatos.beginTransaction();
        
        try {
            baseDatos.createQuery("update Proveedor set "
                   +" nombre = '" + prov.getNombre() + "', apellido = '" + prov.getApellido() + "'"
                    + ", ci = '" +  prov.getCi() + "', dv = '" +  prov.getDv()+  "', direccion = '" +  prov.getDireccion()+ "', telefono = '" + prov.getTelefono() +  "'"                   
            + ", estado = '" + prov.getEstado() + "' where cod_proveedor = '" + prov.getCodProveedor() + "'").executeUpdate();
            baseDatos.beginTransaction().commit();
        } catch(HibernateException e){
            throw new Exception("Error al modificar proveedor: \n" + e.getMessage());
        }
    }
    
    public void delete(String codigo_prov) throws Exception {
        Session baseDatos = HibernateUtil.getSessionFactory().openSession();
        baseDatos.beginTransaction();
        
        try {
            baseDatos.createQuery("update Proveedor set estado = 'INACTIVO' where cod_proveedor = '" + codigo_prov+ "'").executeUpdate();
            baseDatos.beginTransaction().commit();
        } catch(HibernateException e){
            throw new Exception("Error al eliminar proveedor: \n" + e.getMessage());
        }
    }
    
    
    public ResultSet datos() throws Exception {
        Session baseDatos = HibernateUtil.getSessionFactory().openSession();
        
        
        String query = "SELECT cod_proveedor as \"Código\",  case when dv='' then ci else ci||'-'||dv end as \"RUC/CI\", nombre as \"Nombre\", apellido as \"Apellido\", direccion as \"Direccion\", telefono as \"Telefono\", estado as \"Estado\" from Proveedor";
        PreparedStatement ps = baseDatos.connection().prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        try {
            return rs;
        } catch(HibernateException e){
            throw new Exception("Error al consultar la tabla Componentes: \n" + e.getMessage());
        }
    }*/
}
   
