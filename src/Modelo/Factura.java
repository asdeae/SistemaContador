/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Date;


/**
 *
 * @author Luis Huayta
 */
public class Factura {

    public String getContenidoFactura() {
        return contenidoFactura;
    }

    public void setContenidoFactura(String contenidoFactura) {
        this.contenidoFactura = contenidoFactura;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    
    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

     
    private String contenidoFactura;
    private Date fechaVenta;
    
    private int idFactura;
    
    
    public Factura(int idFactura, String contenidoFactura,Date fechaVenta)
    {
        this.idFactura=idFactura;
        
        this.contenidoFactura=contenidoFactura;
        this.fechaVenta=fechaVenta;
                
    }
    public Factura(){
        
    }
    
    
    
    
}
