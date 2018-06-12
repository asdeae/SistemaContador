/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;



/**
 *
 * @author Luis Huayta
 */
public interface PlantillaFacturaDAO {
    
    Factura obtenerFactura(Factura factura) throws Exception; 
    void insertarFactura(Factura factura) throws Exception;
    
}
