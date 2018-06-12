/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.EfectoBoton;
import Modelo.EfectoLabel;
import Modelo.OperacionesVenta;
import Vista.VentanaEmpresa;
import Vista.VistaAdministrador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


/**
 *
 * @author Luis Huayta
 */
   
        
public class CVentanaEmpresa implements MouseListener{
    
    
    
    VistaAdministrador vista  = new VistaAdministrador();
    
    VentanaEmpresa ven = new VentanaEmpresa(vista,true);
    
    
    
    OperacionesVenta op = new OperacionesVenta();
    
    
    public CVentanaEmpresa(VistaAdministrador vista,VentanaEmpresa ven)
    {
        this.vista=vista;
        this.ven=ven;
        this.ven.jButton1.addMouseListener(this);
        
        this.ven.botonGananciaTotal.addMouseListener(this);
        this.ven.botonVentasTotal.addMouseListener(this);
        
        new EfectoLabel(ven, ven.jLabelBarra);
        
        new EfectoBoton(ven, ven.jButton1, "/Imagenes/flecha-blanca.png");
        new EfectoBoton(ven, ven.botonGananciaTotal, "/Imagenes/coin.png");
        new EfectoBoton(ven, ven.botonVentasTotal, "/Imagenes/shopping-cart.png");
        
      
        
        
        
//        this.ven.jLabelGananciasTotales.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/Imagenes/coin.png")).getImage().getScaledInstance(this.ven.jLabelGananciasTotales.getWidth(), this.ven.jLabelGananciasTotales.getHeight(), Image.SCALE_DEFAULT)));
//        this.ven.jLabelVentasTotales.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/Imagenes/shopping-cart.png")).getImage().getScaledInstance(this.ven.jLabelVentasTotales.getWidth(), this.ven.jLabelVentasTotales.getHeight(), Image.SCALE_DEFAULT)));
        
    }
    
    

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource().equals(this.ven.jButton1))
        {
            this.ven.hide();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getSource().equals(ven.botonGananciaTotal))
        {
            
            ven.jTextFieldGanancia.setText(String.valueOf(op.gananciaTotal()));
        }
        if(e.getSource().equals(ven.botonVentasTotal))
        {
            ven.jTextFieldVentas.setText(String.valueOf(op.ventaTotal()));
                
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
            if(e.getSource().equals(ven.botonGananciaTotal))
            {
                ven.jTextFieldGanancia.setText("");
            }
            if(e.getSource().equals(ven.botonVentasTotal))
            {
                ven.jTextFieldVentas.setText("");
            }
    }
    
        
}