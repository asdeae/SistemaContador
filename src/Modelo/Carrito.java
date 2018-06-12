/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author Luis Huayta
 */
public class Carrito {
    
    protected ArrayList<Ventas> carrito = new ArrayList();
    protected int cantidadProductos;
    protected ArrayList<Producto> productos = new ArrayList<>();

    public ArrayList<Ventas> getCarrito() {
        return carrito;
    }

    public void setCarrito(ArrayList<Ventas> carrito) {
        this.carrito = carrito;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }
    
    
    public Carrito(ArrayList<Ventas> carrito,ArrayList<Producto> productos)
    {
        this.carrito=carrito;
        this.productos=productos;
    }
    
    
}
