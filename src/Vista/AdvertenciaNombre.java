/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.CvistaModeloAdvertencia;
import Modelo.EfectoBoton;
import Modelo.EfectoLabel;
import java.awt.Frame;


/**
 *
 * @author Luis Huayta
 */
public class AdvertenciaNombre extends VistaModeloAdvertencia {
    
    public AdvertenciaNombre(Frame parent, boolean modal) {
        super(parent, modal);
        this.jLabelTexto.setText("Verifique que el nombre puesto no tenga caracteres numéricos");
        
        
    }
    
    
    
}
