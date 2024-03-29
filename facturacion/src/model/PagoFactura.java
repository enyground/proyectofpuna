package model;
// Generated Apr 14, 2015 8:31:57 PM by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;

/**
 * PagoFactura generated by hbm2java
 */
public class PagoFactura  implements java.io.Serializable {


     private int pagoDocumentoId;
     private Venta venta;
     private Compra compra;
     private Cuentas cuentas;
     private String estado;
     private double monto;
     private Set tipoPagos = new HashSet(0);

    public PagoFactura() {
    }

	
    public PagoFactura(int pagoDocumentoId, Cuentas cuentas, String estado, double monto) {
        this.pagoDocumentoId = pagoDocumentoId;
        this.cuentas = cuentas;
        this.estado = estado;
        this.monto = monto;
    }
    public PagoFactura(int pagoDocumentoId, Venta venta, Compra compra, Cuentas cuentas, String estado, double monto, Set tipoPagos) {
       this.pagoDocumentoId = pagoDocumentoId;
       this.venta = venta;
       this.compra = compra;
       this.cuentas = cuentas;
       this.estado = estado;
       this.monto = monto;
       this.tipoPagos = tipoPagos;
    }
   
    public int getPagoDocumentoId() {
        return this.pagoDocumentoId;
    }
    
    public void setPagoDocumentoId(int pagoDocumentoId) {
        this.pagoDocumentoId = pagoDocumentoId;
    }
    public Venta getVenta() {
        return this.venta;
    }
    
    public void setVenta(Venta venta) {
        this.venta = venta;
    }
    public Compra getCompra() {
        return this.compra;
    }
    
    public void setCompra(Compra compra) {
        this.compra = compra;
    }
    public Cuentas getCuentas() {
        return this.cuentas;
    }
    
    public void setCuentas(Cuentas cuentas) {
        this.cuentas = cuentas;
    }
    public String getEstado() {
        return this.estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public double getMonto() {
        return this.monto;
    }
    
    public void setMonto(double monto) {
        this.monto = monto;
    }
    public Set getTipoPagos() {
        return this.tipoPagos;
    }
    
    public void setTipoPagos(Set tipoPagos) {
        this.tipoPagos = tipoPagos;
    }




}


