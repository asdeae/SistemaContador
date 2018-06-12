/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.EfectoBoton;
import Modelo.EfectoLabel;
import Vista.VistaModeloAdvertencia;
import Vista.VistaRegistro;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Luis Huayta
 */
public class CvistaModeloAdvertencia implements ActionListener{
    VistaRegistro ventana = new VistaRegistro();
    VistaModeloAdvertencia vista = new VistaModeloAdvertencia(ventana, true);
    
    
    public CvistaModeloAdvertencia(VistaRegistro ventana,VistaModeloAdvertencia vista)
    {
        this.ventana=ventana;
        this.vista=vista;
        this.vista.jButton1.addActionListener(this);
        new EfectoLabel(this.vista, this.vista.jLabel1);
        new EfectoBoton(this.vista.jButton1);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.vista.dispose();
    }
    
   
    
}
