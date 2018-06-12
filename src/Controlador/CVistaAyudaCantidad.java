/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.EfectoBoton;
import Modelo.EfectoLabel;
import Vista.VentanaFila;
import Vista.VistaAdministrador;
import Vista.VistaAyudaCantidad;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Luis Huayta
 */
public class CVistaAyudaCantidad implements ActionListener{

     public VistaAdministrador vista = new VistaAdministrador();
    public VentanaFila ventSecundaria = new VentanaFila(vista, true);
    public VistaAyudaCantidad ventPrincipal = new VistaAyudaCantidad(vista, true);
    
    public CVistaAyudaCantidad(VistaAdministrador vista,VentanaFila ventSecundaria,VistaAyudaCantidad ventPrincipal)
    {
        this.vista=vista;
        this.ventSecundaria=ventSecundaria;
        this.ventPrincipal=ventPrincipal;
        this.ventPrincipal.jButtonRegresar.addActionListener(this);
        new EfectoBoton(this.ventPrincipal, this.ventPrincipal.jButtonRegresar, "/Imagenes/flecha-blanca.png");
        new EfectoLabel(this.ventPrincipal, this.ventPrincipal.jLabelBarra);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        this.ventPrincipal.hide();
    }
    
}
