/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.EfectoBoton;
import Modelo.EfectoLabel;
import Vista.VistaAdministrador;
import Vista.VistaFactura;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Luis Huayta
 */
public class CVistaFactura implements ActionListener {

    
    VistaAdministrador ventana = new VistaAdministrador();
    
    VistaFactura vista = new VistaFactura(ventana, true);
    
    CvistaAdministrador cv = new CvistaAdministrador();
    public CVistaFactura (VistaAdministrador ventana,VistaFactura vista,CvistaAdministrador cv)
    {
        this.ventana=ventana;
        this.vista=vista;
        this.cv=cv;
        this.vista.jButtonRegresar.addActionListener(this);
        new EfectoBoton(this.vista, this.vista.jButtonRegresar, "/Imagenes/flecha-blanca.png");
        new EfectoBoton(this.vista.jButton1);
        new EfectoLabel(this.vista, this.vista.jLabelBarra);
        pintarFactura();
        capturarDatos();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
       this.vista.dispose();
    }
    private void pintarFactura()
    {
        this.vista.JTextAreaFactura.setText(this.ventana.jTextAreaFactura.getText());
    }
    private void capturarDatos()
    {
        this.vista.jTextFieldPrecioTotal.setText(String.valueOf(this.cv.carro.precioCarrito()));
    }
    
}
