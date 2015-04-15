/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main;

//import vista.CrearRol;
import vista.ProveedorForm;
import vista.medioPagoForm;


/**
 *
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       ProveedorForm c = new ProveedorForm();
      // medioPagoForm c = new medioPagoForm(); 
       c.pack();
       c.setVisible(true);
       c.setLocationRelativeTo(null);
      
     
       /*int ci;
       ruc RUC = new ruc();
       ci=RUC.Pa_Calcular_Dv_11_A("80055516", 11);
       System.out.println(ci);*/
    }
    
}
