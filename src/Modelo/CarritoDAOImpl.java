/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 
 * @author Luis Huayta
 */
public class CarritoDAOImpl extends Carrito implements PlantillaCarritoDAO{
    
    PlantillaDAO<Producto> pro = new ProductoDAOImpl();
    PlantillaVentasDAO vent = new VentasDAOImpl();
    
    public CarritoDAOImpl(ArrayList<Ventas> carrito, ArrayList<Producto> productos) {
        super(carrito, productos);
    }
    
    @Override
    public void eliminarProducto(Producto pro) {
        try
        {
            this.carrito.remove(vent.obtenerVenta(pro.getIdProducto()
        ));
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        
    }

    @Override
    public void vaciarCarrito() {
        this.carrito.clear();
    }

    @Override
    public void iniciarCarrito() {
        try
        {
                for(Producto o : pro.obtenerlista())
                {
                    this.carrito.add(new Ventas(o.getIdProducto()));
                }
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }

    @Override
    public void aumentarCantidadC(Producto pro) {
        
        try
        {
            if(obtener(pro).getCantidadVentas()<pro.getStock())
                obtener(pro).aumentarVentas();
            
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }

    @Override
    public void disminuirCantidadC(Producto pro) {
        try
        {
            if(obtener(pro).getCantidadVentas()>0)
                obtener(pro).disminuirVentas();
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
    public int cantidadProductos()
    {
        
        int cantidad = 0 ; 
        try
        {
            for(Ventas o:carrito)
                cantidad+=o.getCantidadVentas();
            return cantidad;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            return cantidad;
        }
    }

    @Override
    public boolean comprobarProducto(Producto pro) { //Comprueba si un producto tiene más de una venta pre programada en el carrito
        
        try
        {
            return obtener(pro).getCantidadVentas()>0;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public ArrayList<Ventas> obtenerCarrito() {
        return super.getCarrito();
    }

    @Override
    public Ventas obtener(Producto pro) {
        
        for(Ventas o : this.carrito)
            if(o.getIdProducto()==(pro.getIdProducto()))
                return o;
        return new Ventas();
    }

    @Override
    public void agregarProducto(Producto pro) {
        try
        {
            this.carrito.add(new Ventas(pro.getIdProducto()));
        
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }

    @Override
    public double precioCarrito() {
        double precioTotal= 0;
        for(Ventas o : this.carrito)
        {
            precioTotal+=o.getGananciaAcumulada();
        }
            return precioTotal;
    }
    
    @Override
    public void precioProducto(Producto pro) {
        obtener(pro).setGananciaAcumulada(pro.getPrecioUnitario()*obtener(pro).getCantidadVentas());
     }

    @Override
    public void actualizarProductos() {
        
        Ventas venta = null;
        try
        {
             for(Producto o : this.pro.obtenerlista())
             {
                 if(comprobarProducto(o))
                 {
                    venta = obtener(o);
                   
                   o.setStock(o.getStock() - venta.getCantidadVentas());
                   pro.actualizar(o);
                   vent.modificar(venta);
                 }
                 
             }
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }

    
    
    
}
