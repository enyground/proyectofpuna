package model;
// Generated Apr 14, 2015 8:31:57 PM by Hibernate Tools 3.6.0



/**
 * TipoPago generated by hbm2java
 */
public class TipoPago  implements java.io.Serializable {


     private int tipoPagoId;
     private PagoFactura pagoFactura;
     private String nombrePago;

    public TipoPago() {
    }

    public TipoPago(int tipoPagoId, PagoFactura pagoFactura, String nombrePago) {
       this.tipoPagoId = tipoPagoId;
       this.pagoFactura = pagoFactura;
       this.nombrePago = nombrePago;
    }
   
    public int getTipoPagoId() {
        return this.tipoPagoId;
    }
    
    public void setTipoPagoId(int tipoPagoId) {
        this.tipoPagoId = tipoPagoId;
    }
    public PagoFactura getPagoFactura() {
        return this.pagoFactura;
    }
    
    public void setPagoFactura(PagoFactura pagoFactura) {
        this.pagoFactura = pagoFactura;
    }
    public String getNombrePago() {
        return this.nombrePago;
    }
    
    public void setNombrePago(String nombrePago) {
        this.nombrePago = nombrePago;
    }




}


