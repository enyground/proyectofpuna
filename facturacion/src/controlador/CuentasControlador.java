/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Cuentas;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 */
public class CuentasControlador {
    
    public void insert(Cuentas cuenta) throws Exception {
      
        Session baseDatos = HibernateUtil.getSessionFactory().openSession();
        baseDatos.beginTransaction();
        
        try {
            baseDatos.save(cuenta);
            baseDatos.beginTransaction().commit();
        } catch(HibernateException e){
            throw new Exception("Error al guardar compra: \n" + e.getMessage());
        }
         
    }
    
   
     
    /*public void update(Proveedor prov) throws Exception{
        Session baseDatos = HibernateUtil.getSessionFactory().openSession();
        baseDatos.beginTransaction();
        
        try {
           
          
          baseDatos.update(prov);
        
         
          baseDatos.beginTransaction().commit();
        } catch(HibernateException e){
            throw new Exception("Error al modificar proveedor: \n" + e.getMessage());
        }
    }*/
    
  
    
    public void update(Cuentas cuenta) throws Exception {
        Session baseDatos = HibernateUtil.getSessionFactory().openSession();
        baseDatos.beginTransaction();
        
        try {
            baseDatos.createQuery("update Cuentas set "
                   +" estado = '" + cuenta.getEstado() + "' where cod_proveedor = '" + cuenta.getCuentaId()+ "'").executeUpdate();
            baseDatos.beginTransaction().commit();
            baseDatos.beginTransaction().commit();
        } catch(HibernateException e){
            throw new Exception("Error al anular factura: \n" + e.getMessage());
        }
    }
    
   
    }

   
