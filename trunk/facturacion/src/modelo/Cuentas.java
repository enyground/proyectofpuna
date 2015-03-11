package modelo;
// Generated Mar 11, 2015 2:13:18 PM by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;

/**
 * Cuentas generated by hbm2java
 */
public class Cuentas  implements java.io.Serializable {


     private int cuentaId;
     private Cliente cliente;
     private Proveedor proveedor;
     private double saldo;
     private String estado;
     private Short pagoEn;
     private Set pagoFacturas = new HashSet(0);

    public Cuentas() {
    }

	
    public Cuentas(int cuentaId, double saldo, String estado) {
        this.cuentaId = cuentaId;
        this.saldo = saldo;
        this.estado = estado;
    }
    public Cuentas(int cuentaId, Cliente cliente, Proveedor proveedor, double saldo, String estado, Short pagoEn, Set pagoFacturas) {
       this.cuentaId = cuentaId;
       this.cliente = cliente;
       this.proveedor = proveedor;
       this.saldo = saldo;
       this.estado = estado;
       this.pagoEn = pagoEn;
       this.pagoFacturas = pagoFacturas;
    }
   
    public int getCuentaId() {
        return this.cuentaId;
    }
    
    public void setCuentaId(int cuentaId) {
        this.cuentaId = cuentaId;
    }
    public Cliente getCliente() {
        return this.cliente;
    }
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public Proveedor getProveedor() {
        return this.proveedor;
    }
    
    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
    public double getSaldo() {
        return this.saldo;
    }
    
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    public String getEstado() {
        return this.estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public Short getPagoEn() {
        return this.pagoEn;
    }
    
    public void setPagoEn(Short pagoEn) {
        this.pagoEn = pagoEn;
    }
    public Set getPagoFacturas() {
        return this.pagoFacturas;
    }
    
    public void setPagoFacturas(Set pagoFacturas) {
        this.pagoFacturas = pagoFacturas;
    }




}


