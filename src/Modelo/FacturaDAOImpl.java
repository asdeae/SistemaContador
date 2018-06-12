/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


/**
 *
 * @author Luis Huayta
 */
public class FacturaDAOImpl extends Conexion implements PlantillaFacturaDAO{

    ArrayList<Producto> productos = new ArrayList();
    ArrayList<Ventas> carrito  = new ArrayList();
    
    PlantillaCarritoDAO carro = new CarritoDAOImpl(carrito, productos)
            ;
    
    
    @Override
    public Factura obtenerFactura(Factura factura) {
         Factura fac  = null;
        try{
        this.conectar();    
            
        ResultSet rs;
             try (PreparedStatement ps = this.conexion.prepareStatement("select *from facturas where idFactura=?")) {
                 ps.setInt(1, factura.getIdFactura());
                 fac  = new Factura();
                 rs = ps.executeQuery();
                 if(rs.next())
                 {
                     fac.setContenidoFactura(rs.getString("contenidoFactura"));
                     fac.setFechaVenta(rs.getDate("fechaVenta"));
                     fac.setIdFactura(rs.getInt("idFactura"));
                 }}
            rs.close();
            
            this.cerrar();
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return fac;
    }

    @Override
    public void insertarFactura(Factura factura) {
        try
            {
                this.conectar();
            PreparedStatement ps  = this.conexion.prepareStatement("insert into facturas (contenidoFactura,fechaVenta) values (?,?)");
           
            
            ps.setString(1, factura.getContenidoFactura());
            ps.setDate(2, factura.getFechaVenta());
            ps.executeUpdate();
            }catch(Exception ex)
            {
                ex.printStackTrace();
            }
            
        }

   
    }
    

