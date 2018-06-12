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
public interface PlantillaVentasDAO<E> {
    
    public  ArrayList<E> obtenerVentas() throws Exception;
    public Ventas obtenerVenta(int key) throws Exception;
    public void insertar(Ventas ven) throws Exception;
    
    public void modificar(Ventas ven) throws Exception;

}
