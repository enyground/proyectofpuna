package model;
// Generated Apr 14, 2015 8:31:57 PM by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;

/**
 * Usuario generated by hbm2java
 */
public class Usuario  implements java.io.Serializable {


     private int idUsuario;
     private String nombre;
     private String contrasenha;
     private Set rols = new HashSet(0);

    public Usuario() {
    }

	
    public Usuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    public Usuario(int idUsuario, String nombre, String contrasenha, Set rols) {
       this.idUsuario = idUsuario;
       this.nombre = nombre;
       this.contrasenha = contrasenha;
       this.rols = rols;
    }
   
    public int getIdUsuario() {
        return this.idUsuario;
    }
    
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getContrasenha() {
        return this.contrasenha;
    }
    
    public void setContrasenha(String contrasenha) {
        this.contrasenha = contrasenha;
    }
    public Set getRols() {
        return this.rols;
    }
    
    public void setRols(Set rols) {
        this.rols = rols;
    }




}

