/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.PlantillaDAO;
import Modelo.Producto;
import Modelo.ProductoDAOImpl;
import java.awt.List;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

/**
 *
 * @author Luis Huayta
 */
public class ComboBox {
    
        String [] marcas = null;
        
        PlantillaDAO<Producto> pro = new ProductoDAOImpl();
        JComboBox jcb = new JComboBox();
        public ComboBox(JComboBox jcb,PlantillaDAO<Producto> pro)
        {
            this.pro=pro;
            this.jcb=jcb;
        
        }
         
         
         
        
        public void inicializar(JComboBox jcb)
        {
            
            DefaultComboBoxModel<String> dcbm = new DefaultComboBoxModel(inicializarModelo());
            
            jcb.setModel(dcbm);
            
        }
        private String[] inicializarModelo()
        {
            try
            {
            marcas = new String[this.pro.obtenerlista().size()];
            
            for(int i = 0 ;  i < marcas.length;i++)
                marcas[i] = this.pro.obtenerlista().get(i).getMarca();
            
            }catch(Exception ex)
            {
                ex.printStackTrace();
            }
            
            return marcas;
        }
        
    
}
