/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Vista.VistaAdministrador;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 *
 * @author Luis Huayta
 */
public class EfectoBoton extends MouseAdapter {
    
    JButton boton  = new JButton();
    EfectoHoverBoton ef = new EfectoHoverBoton();
    JFrame ventana = new JFrame();
    JDialog dialog   = new JDialog();
    VistaAdministrador vista = new VistaAdministrador();
    public EfectoBoton(JButton boton)
    {
        
        this.boton = boton;
        this.boton.addMouseListener(this);
        this.boton.setFocusable(false);
        
    }
     
   
         
    public EfectoBoton(JFrame ventana,JButton boton,String ruta)
    {
        this.ventana=ventana;
        this.boton=boton;
        this.boton.setIcon(new ImageIcon(this.ventana.getClass().getResource(ruta)));
        
    }
    
    public EfectoBoton(JDialog dialog,JButton boton,String ruta)
    {
        this.dialog=dialog;
        this.boton=boton;
        this.boton.setIcon(new ImageIcon(this.dialog.getClass().getResource(ruta)));
    }
            
    
    
    @Override
    public void mouseExited(MouseEvent e) {
        this.boton.setBackground(new java.awt.Color(51,51,51));
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        this.boton.setBackground(new java.awt.Color(0,102,255));
    }
    
    
    
}