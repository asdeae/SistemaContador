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
public class Producto {
    private String marca;

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
;
    private int stock;
    private double precioUnitario;
    private int idProducto;

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }
    public Producto(int idProducto,String marca,int stock,double precioUnitario)           
    {
        this.idProducto=idProducto;
                
        this.marca=marca;
        this.precioUnitario=precioUnitario;
        this.stock=stock;
    }
    public Producto()
    {
        
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }
    public boolean equals(Object o)
    {
        if (o instanceof Producto) {
        Producto pro = (Producto) o;
        if(this.marca==pro.getMarca())
            return true;
        else return false;
    }
        else 
            return false;
    }
    
}
