package model;
// Generated Apr 14, 2015 8:31:57 PM by Hibernate Tools 3.6.0



/**
 * Componentes generated by hbm2java
 */
public class Componentes  implements java.io.Serializable {


     private String codigo;
     private String descripcion;
     private String unidad;

    public Componentes() {
    }

	
    public Componentes(String codigo) {
        this.codigo = codigo;
    }
    public Componentes(String codigo, String descripcion, String unidad) {
       this.codigo = codigo;
       this.descripcion = descripcion;
       this.unidad = unidad;
    }
   
    public String getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getUnidad() {
        return this.unidad;
    }
    
    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }




}


