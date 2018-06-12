/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.ResultSet;

/**
 *
 * @author Luis Huayta
 */
public class Login extends Conexion{
    
    public boolean verificarLogin(String nombreCuenta,String clave)
    {
        
        try{
            this.conectar();
            ResultSet rs =  this.conexion.prepareStatement("select *from administrador where CLAVE='"+clave+"' and NOMBRECUENTA='"+nombreCuenta+"'").executeQuery();
            
            if(rs.next()==true)
                return true;
            
            this.cerrar();
            
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
        
        return false;
    }
    
}
