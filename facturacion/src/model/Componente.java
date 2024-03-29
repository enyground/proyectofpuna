package model;
// Generated Apr 14, 2015 8:31:57 PM by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;

/**
 * Componente generated by hbm2java
 */
public class Componente  implements java.io.Serializable {


     private int componenteId;
     private String descripcion;
     private String unidadMedida;
     private String codigo;
     private int stockMinimo;
     private Integer stockMaximo;
     private double precioUnidad;
     private Set stocks = new HashSet(0);
     private Set detalleVentas = new HashSet(0);
     private Set detalleRemisions = new HashSet(0);
     private Set detalleCompras = new HashSet(0);

    public Componente() {
    }

	
    public Componente(int componenteId, int stockMinimo, double precioUnidad) {
        this.componenteId = componenteId;
        this.stockMinimo = stockMinimo;
        this.precioUnidad = precioUnidad;
    }
    public Componente(int componenteId, String descripcion, String unidadMedida, String codigo, int stockMinimo, Integer stockMaximo, double precioUnidad, Set stocks, Set detalleVentas, Set detalleRemisions, Set detalleCompras) {
       this.componenteId = componenteId;
       this.descripcion = descripcion;
       this.unidadMedida = unidadMedida;
       this.codigo = codigo;
       this.stockMinimo = stockMinimo;
       this.stockMaximo = stockMaximo;
       this.precioUnidad = precioUnidad;
       this.stocks = stocks;
       this.detalleVentas = detalleVentas;
       this.detalleRemisions = detalleRemisions;
       this.detalleCompras = detalleCompras;
    }
   
    public int getComponenteId() {
        return this.componenteId;
    }
    
    public void setComponenteId(int componenteId) {
        this.componenteId = componenteId;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getUnidadMedida() {
        return this.unidadMedida;
    }
    
    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }
    public String getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public int getStockMinimo() {
        return this.stockMinimo;
    }
    
    public void setStockMinimo(int stockMinimo) {
        this.stockMinimo = stockMinimo;
    }
    public Integer getStockMaximo() {
        return this.stockMaximo;
    }
    
    public void setStockMaximo(Integer stockMaximo) {
        this.stockMaximo = stockMaximo;
    }
    public double getPrecioUnidad() {
        return this.precioUnidad;
    }
    
    public void setPrecioUnidad(double precioUnidad) {
        this.precioUnidad = precioUnidad;
    }
    public Set getStocks() {
        return this.stocks;
    }
    
    public void setStocks(Set stocks) {
        this.stocks = stocks;
    }
    public Set getDetalleVentas() {
        return this.detalleVentas;
    }
    
    public void setDetalleVentas(Set detalleVentas) {
        this.detalleVentas = detalleVentas;
    }
    public Set getDetalleRemisions() {
        return this.detalleRemisions;
    }
    
    public void setDetalleRemisions(Set detalleRemisions) {
        this.detalleRemisions = detalleRemisions;
    }
    public Set getDetalleCompras() {
        return this.detalleCompras;
    }
    
    public void setDetalleCompras(Set detalleCompras) {
        this.detalleCompras = detalleCompras;
    }




}


