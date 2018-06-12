/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.EfectoBoton;
import Modelo.EfectoLabel;
import Modelo.PlantillaDAO;
import Modelo.PlantillaVentasDAO;
import Modelo.Producto;
import Modelo.ProductoDAOImpl;
import Modelo.Ventas;
import Modelo.VentasDAOImpl;
import Vista.VentanaModificar;
import Vista.VistaAdministrador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Luis Huayta
 */
public class CventanaModificar implements ActionListener{
    
    VistaAdministrador obj = new VistaAdministrador();
    
    PlantillaDAO<Producto> pro = new ProductoDAOImpl();
    PlantillaVentasDAO ventas  = new VentasDAOImpl();
    VentanaModificar ven = new VentanaModificar(obj,true);
    
    public CventanaModificar(PlantillaDAO<Producto> pro,VistaAdministrador obj,VentanaModificar ven)
    {
        
        this.pro=pro;
        this.obj=obj;
        this.ven=ven;
        
        this.ven.jButtonModificar.addActionListener(this);
        this.ven.jComboBoxProductos.addActionListener(this);
        this.ven.jButtonRegresar.addActionListener(this);
        new EfectoBoton(this.ven.jButtonModificar);
        new EfectoBoton(this.ven, this.ven.jButtonRegresar, "/Imagenes/flecha-blanca.png");
        new EfectoLabel(this.ven, this.ven.jLabelBarra);
        
        ComboBox cb = new ComboBox(this.ven.jComboBoxProductos,this.pro);
        cb.inicializar(this.ven.jComboBoxProductos);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
       
        
        if(e.getSource().equals(this.ven.jComboBoxProductos))
        {
                String marca = this.ven.jComboBoxProductos.getSelectedItem().toString();
                 Producto pro = null;
                try
                {
                    pro = this.pro.obtenerObjeto(marca);
                    
                    this.ven.jTextFieldCantidad.setText(String.valueOf(pro.getStock()));
                    this.ven.jTextFieldPrecioUnitario.setText(String.valueOf(pro.getPrecioUnitario()));
                    
                    
                    
                }catch(Exception ex)
                {
                    ex.printStackTrace();
                }
                
        }
        if(e.getSource().equals(this.ven.jButtonModificar))
        {
            Producto pro = null;
            
            String marca = this.ven.jComboBoxProductos.getSelectedItem().toString();
            try
            {
                pro = this.pro.obtenerObjeto(marca);
               
                pro.setPrecioUnitario(Double.valueOf(this.ven.jTextFieldPrecioUnitario.getText().toString()));
                pro.setStock(Integer.valueOf(this.ven.jTextFieldCantidad.getText().toString()));
                
                this.pro.actualizar(pro);
                
                Tabla t = new Tabla(this.obj.jTable1,this.pro);
                t.ver_tabla(this.obj.jTable1,this.pro);
             
                
                this.ven.hide();
                
            }catch(Exception ex)
            {
                JOptionPane.showMessageDialog(ven, "Error al actualizar producto");
            }
        }
        if(e.getSource().equals(this.ven.jButtonRegresar))
        {
            this.ven.hide();
        }
        
                
    }
    
}
