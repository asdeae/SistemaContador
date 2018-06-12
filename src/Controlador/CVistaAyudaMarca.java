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
import Vista.VistaAyudaMarca;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Luis Huayta
 */
public class CVistaAyudaMarca implements ActionListener {
     public VistaAdministrador vista = new VistaAdministrador();
    public VentanaFila ventSecundaria = new VentanaFila(vista, true);
    public VistaAyudaMarca ventPrincipal = new VistaAyudaMarca(vista, true);
    
    public CVistaAyudaMarca(VistaAdministrador vista,VentanaFila ventSecundaria,VistaAyudaMarca ventPrincipal)
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
