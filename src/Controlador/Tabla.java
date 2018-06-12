/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.PlantillaDAO;
import Modelo.PlantillaVentasDAO;
import Modelo.Producto;
import Modelo.ProductoDAOImpl;

import java.util.ArrayList;

import javax.swing.JTable;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Luis Huayta
 */
public class Tabla {
    
    JTable tabla = new JTable();
    
    
    
    public  PlantillaDAO<Producto> pro = new ProductoDAOImpl();
    private Object columnName[] = new String[3];
    
    private Object data[][] = null; 
    public Tabla(JTable tabla,PlantillaDAO<Producto> pro)
    {
        this.tabla=tabla;
        this.pro=pro;
        
        
    }
            
    
    
    
    public void ver_tabla(JTable tabla,PlantillaDAO<Producto> pro)
    {
        
        try
        {
        columnName[0] = "CANTIDAD";
        columnName[1] = "MARCA";
        columnName[2] = "PRECIOUNITARIO";
        
        data = toMatriz(pro.obtenerlista());
        
        DefaultTableModel dtm;
        dtm = new DefaultTableModel(data,columnName)
        {
            public boolean isCellEditable(int row,int column)
            {
                return false;
            }
        };
        
        tabla.setModel(dtm);
        
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
        tabla.setRowHeight(30);
    }
    
    public Object [][] toMatriz(ArrayList<Producto> obj)
    {
        
        
        Object o[][] = null;
        
        try
        {
            
            o = new Object [obj.size()][columnName.length];
            
            for(int i = 0 ;  i < obj.size();i++){
                
                    o[i][0] = obj.get(i).getStock();
                    o[i][1] = obj.get(i).getMarca();
                    o[i][2] = obj.get(i).getPrecioUnitario();
            }   
                    
            
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
        
        
        
        return o;
    }
    
    
            
    
}
