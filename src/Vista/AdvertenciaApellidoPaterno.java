/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.EfectoBoton;
import Modelo.EfectoLabel;
import java.awt.Frame;

/**
 
 * @author Luis Huayta
 */
public class AdvertenciaApellidoPaterno extends VistaModeloAdvertencia {
    
    public AdvertenciaApellidoPaterno(Frame parent, boolean modal) {
        super(parent, modal);
        this.jLabelTexto.setText("Verifique que no hayan caracteres numéricos");
        
    }
    
}
