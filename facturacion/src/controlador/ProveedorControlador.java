/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelo.Proveedor;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 */
public class ProveedorControlador {
    
    public void insert(Proveedor prov) throws Exception {
      
        Session baseDatos = HibernateUtil.getSessionFactory().openSession();
        baseDatos.beginTransaction();
        
        try {
            baseDatos.save(prov);
            baseDatos.beginTransaction().commit();
        } catch(HibernateException e){
            throw new Exception("Error al guardar proveedor: \n" + e.getMessage());
        }
         
    }
    
   
     
    public void update(Proveedor prov) throws Exception{
        Session baseDatos = HibernateUtil.getSessionFactory().openSession();
        baseDatos.beginTransaction();
        
        try {
           
          
          baseDatos.update(prov);
        
         
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
        String query = "SELECT cod_proveedor as \"Código\", ruc_ci as \"RUC/CI\", nombre as \"Nombre\", apellido as \"Apellido\", direccion as \"Direccion\", telefono as \"Telefono\", estado as \"Estado\" from proveedor";
        PreparedStatement ps = baseDatos.connection().prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        try {
            return rs;
        } catch(HibernateException e){
            throw new Exception("Error al consultar la tabla Componentes: \n" + e.getMessage());
        }
    }
}
   
