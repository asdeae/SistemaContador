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
public interface PlantillaCarritoDAO {
    
    
   
    public void eliminarProducto(Producto pro);
    public void aumentarCantidadC(Producto pro);
    public void disminuirCantidadC(Producto pro);
    public void vaciarCarrito();
    public void iniciarCarrito();
    public boolean comprobarProducto(Producto pro);
    public ArrayList<Ventas> obtenerCarrito();
    public Ventas obtener(Producto pro);
    public void agregarProducto(Producto pro);
    public double precioCarrito();
    public void precioProducto(Producto pro);
    public void actualizarProductos();
    
    
}
