package model;
// Generated Apr 14, 2015 8:31:57 PM by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;

/**
 * Permisos generated by hbm2java
 */
public class Permisos  implements java.io.Serializable {


     private int idPermisos;
     private String nombre;
     private Set rols = new HashSet(0);

    public Permisos() {
    }

	
    public Permisos(int idPermisos) {
        this.idPermisos = idPermisos;
    }
    public Permisos(String nombre) {
       this.nombre = nombre;
      
    }
   
    public int getIdPermisos() {
        return this.idPermisos;
    }
    
    public void setIdPermisos(int idPermisos) {
        this.idPermisos = idPermisos;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Set getRols() {
        return this.rols;
    }
    
    public void setRols(Set rols) {
        this.rols = rols;
    }




}


