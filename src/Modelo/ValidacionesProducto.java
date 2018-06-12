/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import javax.swing.JTextField;

/**
 *
 * @author Luis Huayta
 */
public class ValidacionesProducto extends Conexion {
   
    PlantillaDAO<Producto> pro = new ProductoDAOImpl();
    
    public ValidacionesProducto()
    {
        
    }
    
    public boolean verificarMarca(JTextField obj) //VACIO
    {
        return obj.getText().isEmpty();
    }
    public boolean verificarCantidad(JTextField obj) throws Exception
    {
        
        try
        {
            return obj.getText().isEmpty();
            
        }catch(Exception ex)
            {
                    return false;
            }
    }
    
    public boolean verificarPrecio(JTextField obj) throws Exception
    {
        try
        {
            return obj.getText().isEmpty();
            
        }catch(Exception ex)
            {
                    return false;
            }
    }
}
