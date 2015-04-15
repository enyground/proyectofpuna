/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import javax.swing.JOptionPane;
import model.Permisos;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author anex
 */
public class PermisoControlador {
    public void insert(Permisos perm) throws Exception {
      
        Session baseDatos = HibernateUtil.getSessionFactory().openSession();
        baseDatos.beginTransaction();
        
        try {
            baseDatos.save(perm);
            baseDatos.beginTransaction().commit();
        
        } catch (org.hibernate.exception.ConstraintViolationException cve) {
    
             JOptionPane.showMessageDialog(null, "El valor ya existe. Error al insertar", 
                     "Error: ", JOptionPane.ERROR_MESSAGE);
        }catch(HibernateException e){
            e.getMessage();
        }
         
    }
    
    
}
