/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.CarritoDAOImpl;
import Modelo.EfectoBoton;
import Modelo.EfectoLabel;
import Modelo.OperacionesVenta;
import Modelo.PlantillaCarritoDAO;
import Modelo.PlantillaDAO;
import Modelo.PlantillaVentasDAO;
import Modelo.Producto;
import Modelo.ProductoDAOImpl;
import Modelo.Ventas;
import Modelo.VentasDAOImpl;
import Vista.VentanaProductos;
import Vista.VistaAdministrador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.util.ArrayList;

/**
 *
 * @author Luis Huayta
 */
public class CVentanaProductos extends MouseAdapter implements ActionListener{
    
    VistaAdministrador vista = new VistaAdministrador();
    
    VentanaProductos vp = new VentanaProductos(vista,true);
    
    OperacionesVenta op = new OperacionesVenta();
    ArrayList<Ventas> ven = new ArrayList<>();
    ArrayList<Producto> pro = new ArrayList<>()
            ;
    PlantillaVentasDAO ventas = new VentasDAOImpl()
            ;
    
    PlantillaDAO<Producto> productoImpl = new ProductoDAOImpl();
    
    Producto producto= null;
    
    Ventas venta = null;
    public CVentanaProductos (VistaAdministrador vista, VentanaProductos vp)
    {
        this.vista = vista;
        this.vp=vp;
        this.vp.jButton1.addMouseListener(this);
        this.vp.botonGanancia.addMouseListener(this);
        this.vp.botonVenta.addMouseListener(this);
        this.vp.jComboBox1.addActionListener(this);
        new EfectoLabel(this.vp, this.vp.jLabel1);
        
        new EfectoBoton(this.vp ,this.vp.jButton1   , "/Imagenes/flecha-blanca.png");
        new EfectoBoton(this.vp, this.vp.botonGanancia, "/Imagenes/coin.png");
        new EfectoBoton(this.vp, this.vp.botonVenta, "/Imagenes/shopping-cart.png");
        
        ComboBox cb = new ComboBox(this.vp.jComboBox1, productoImpl);
        cb.inicializar(this.vp.jComboBox1);
        
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource().equals(this.vp.jButton1))
        {
            this.vp.hide();
        }
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getSource().equals(vp.botonGanancia))
        {
             
            try
            {
              
               if(venta!=null)
                vp.jTextFieldGanancia.setText(String.valueOf(op.gananciaobtenidaProducto(venta)));
            
            }catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
        if(e.getSource().equals(vp.botonVenta) && venta!=null)
        {
            try
            {
                venta =  ventas.obtenerVenta(producto.getIdProducto());
                
                
                vp.jTextFieldVentas.setText(String.valueOf(op.cantidadvendidaProducto(venta)));
                
            }catch(Exception ex)
            {
                ex.printStackTrace();
            }
            
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource().equals(vp.botonGanancia))
            {
                vp.jTextFieldGanancia.setText("");
            }
            if(e.getSource().equals(vp.botonVenta))
            {
                vp.jTextFieldVentas.setText("");
            }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(this.vp.jComboBox1))
        {
            
            String marca = this.vp.jComboBox1.getSelectedItem().toString();
            
            try
            {
                producto = productoImpl.obtenerObjeto(marca);
                
                
                venta = ventas.obtenerVenta(producto.getIdProducto());
                vp.jTextFieldVentas.setText("");
                vp.jTextFieldGanancia.setText("");
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
            
        }
    }
    
}
