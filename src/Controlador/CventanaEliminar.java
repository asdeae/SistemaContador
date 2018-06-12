/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.EfectoBoton;
import Modelo.EfectoLabel;
import Modelo.PlantillaDAO;
import Modelo.Producto;
import Modelo.ProductoDAOImpl;
import Vista.VentanaEliminar;
import Vista.VistaAdministrador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Luis Huayta
 */
public class CventanaEliminar implements ActionListener{
    
    VistaAdministrador ven = new VistaAdministrador();
    
    PlantillaDAO<Producto> pro = new ProductoDAOImpl();
    
    VentanaEliminar obj = new VentanaEliminar(ven, true);
    
    
    public CventanaEliminar(VistaAdministrador ven, PlantillaDAO<Producto> pro,VentanaEliminar obj)
    {
        this.ven=ven;
        this.obj=obj;
        this.pro=pro;
        
        ComboBox cb = new ComboBox(this.obj.jComboBoxProductos,this.pro);
        cb.inicializar(this.obj.jComboBoxProductos);
        
        this.obj.jButtonEliminar.addActionListener(this);
        this.obj.jButtonRegresar.addActionListener(this);
        this.obj.jComboBoxProductos.addActionListener(this);
        
        new EfectoBoton(this.obj.jButtonEliminar);
        new EfectoBoton(obj, this.obj.jButtonRegresar, "/Imagenes/flecha-blanca.png");
        new EfectoLabel(this.obj, this.obj.jLabelBarra);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(this.obj.jButtonEliminar))
        {
            Producto pro = new Producto();
            
            String marca = this.obj.jComboBoxProductos.getSelectedItem().toString();
            
            try
            {
                pro = this.pro.obtenerObjeto(marca);
                
                this.pro.eliminar(pro);
                
                ComboBox cb = new ComboBox(this.obj.jComboBoxProductos, this.pro);
                cb.inicializar(this.obj.jComboBoxProductos);
                
                Tabla t = new Tabla(this.ven.jTable1, this.pro);
                t.ver_tabla(this.ven.jTable1, this.pro);
                
                
                
            }catch(Exception ex)
            {
                ex.printStackTrace();
            }
            
        }
        if(e.getSource().equals(this.obj.jButtonRegresar))
        {
            this.obj.hide();
        }
    }
                            
}
