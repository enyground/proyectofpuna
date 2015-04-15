package model;
// Generated Apr 14, 2015 8:31:57 PM by Hibernate Tools 3.6.0



/**
 * DetalleRemision generated by hbm2java
 */
public class DetalleRemision  implements java.io.Serializable {


     private int detalleRemisionId;
     private Componente componente;
     private NotaRemision notaRemision;
     private int cantidad;
     private String codigoComponente;
     private String descripcion;

    public DetalleRemision() {
    }

	
    public DetalleRemision(int detalleRemisionId, Componente componente, NotaRemision notaRemision, int cantidad, String codigoComponente) {
        this.detalleRemisionId = detalleRemisionId;
        this.componente = componente;
        this.notaRemision = notaRemision;
        this.cantidad = cantidad;
        this.codigoComponente = codigoComponente;
    }
    public DetalleRemision(int detalleRemisionId, Componente componente, NotaRemision notaRemision, int cantidad, String codigoComponente, String descripcion) {
       this.detalleRemisionId = detalleRemisionId;
       this.componente = componente;
       this.notaRemision = notaRemision;
       this.cantidad = cantidad;
       this.codigoComponente = codigoComponente;
       this.descripcion = descripcion;
    }
   
    public int getDetalleRemisionId() {
        return this.detalleRemisionId;
    }
    
    public void setDetalleRemisionId(int detalleRemisionId) {
        this.detalleRemisionId = detalleRemisionId;
    }
    public Componente getComponente() {
        return this.componente;
    }
    
    public void setComponente(Componente componente) {
        this.componente = componente;
    }
    public NotaRemision getNotaRemision() {
        return this.notaRemision;
    }
    
    public void setNotaRemision(NotaRemision notaRemision) {
        this.notaRemision = notaRemision;
    }
    public int getCantidad() {
        return this.cantidad;
    }
    
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public String getCodigoComponente() {
        return this.codigoComponente;
    }
    
    public void setCodigoComponente(String codigoComponente) {
        this.codigoComponente = codigoComponente;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }




}


