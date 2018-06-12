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
public class Ventas {
    
    private int cantidadVentas=0;
    private double gananciaAcumulada=0;
    private int idProducto;
    private int idVentas;
    
    
    public Ventas()
    {
        
    }
    public Ventas(int idProducto)
    {
        this.idProducto=idProducto;
    }
    
    public int getIdVentas() {
        return idVentas;
    }

    public void setIdVentas(int idVentas) {
        this.idVentas = idVentas;
    }
    public Ventas(int idVenta,int cantidadVentas,double gananciaAcumulada,int idProducto)
    {
        this.idVentas=idVenta;
        this.cantidadVentas=cantidadVentas;
        this.gananciaAcumulada=gananciaAcumulada;
        this.idProducto=idProducto;   
        
    }
    
    public int getCantidadVentas() {
        return cantidadVentas;
    }

    public void setCantidadVentas(int cantidadVentas) {
        this.cantidadVentas = cantidadVentas;
    }

    public double getGananciaAcumulada() {
        return gananciaAcumulada;
    }

    public void setGananciaAcumulada(double gananciaAcumulada) {
        this.gananciaAcumulada = gananciaAcumulada;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }
     public boolean equals(Object o)
    {
        if (o instanceof Ventas) {
        Ventas pro = (Ventas) o;
        if(this.idProducto==pro.idProducto)
            return true;
        else return false;
    }
        else 
            return false;
    }
    public void aumentarVentas()
    {
        this.cantidadVentas++;
    }
    public void disminuirVentas()
    {
        this.cantidadVentas--;
    }
}