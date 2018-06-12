/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JTextField;

/**
 *
 * @author Luis Huayta
 */
public class Validaciones extends Conexion{
    
       Formulario forma = new Formulario();
       
      
       
       public Validaciones(Formulario formato)
       {
           this.forma=formato;
           
       }
       
       public boolean verificarNombre()
       {
           String nombreUsuario = this.forma.getCampoNombre().getText();
           boolean flag  = true;
           
           
               
           if(nombreUsuario.isEmpty())
               return !flag;
           else
           {
               for(int i = 0 ; i  < nombreUsuario.length();i++)
               {
                   if(nombreUsuario.charAt(i)=='0' ||nombreUsuario.charAt(i)=='1' || nombreUsuario.charAt(i)=='2' ||nombreUsuario.charAt(i)=='3' ||nombreUsuario.charAt(i)=='4' ||nombreUsuario.charAt(i)=='5' ||nombreUsuario.charAt(i)=='6' ||nombreUsuario.charAt(i)=='7' ||nombreUsuario.charAt(i)=='8' ||nombreUsuario.charAt(i)=='9' )
                                                           flag=!flag;
                                                            break;
                                                            
               }
               
               return flag;
           }
           
           
           
               
           
       }
       public boolean verificarApellidoPaterno()
       {
           String nombreUsuario = this.forma.getCampoPrimerApellido().getText();
           boolean flag  = true;
           
           
               
           if(nombreUsuario.isEmpty())
               return !flag;
           else
           {
               for(int i = 0 ; i  < nombreUsuario.length();i++)
               {
                   if(nombreUsuario.charAt(i)=='0' ||nombreUsuario.charAt(i)=='1' || nombreUsuario.charAt(i)=='2' ||nombreUsuario.charAt(i)=='3' ||nombreUsuario.charAt(i)=='4' ||nombreUsuario.charAt(i)=='5' ||nombreUsuario.charAt(i)=='6' ||nombreUsuario.charAt(i)=='7' ||nombreUsuario.charAt(i)=='8' ||nombreUsuario.charAt(i)=='9' )
                                                           flag=!flag;
                                                            break;
                                                            
               }
               
               return flag;
           }
       }
       public boolean verificarApellidoMaterno()
       {
           String nombreUsuario = this.forma.getCampoSegundoApellido().getText();
           boolean flag  = true;
           
           
               
           if(nombreUsuario.isEmpty())
               return !flag;
           else
           {
               for(int i = 0 ; i  < nombreUsuario.length();i++)
               {
                   if(nombreUsuario.charAt(i)=='0' ||nombreUsuario.charAt(i)=='1' || nombreUsuario.charAt(i)=='2' ||nombreUsuario.charAt(i)=='3' ||nombreUsuario.charAt(i)=='4' ||nombreUsuario.charAt(i)=='5' ||nombreUsuario.charAt(i)=='6' ||nombreUsuario.charAt(i)=='7' ||nombreUsuario.charAt(i)=='8' ||nombreUsuario.charAt(i)=='9' )
                                                           flag=!flag;
                                                            break;
                                                            
               }
               
               return flag;
           }
       }
       public boolean verificaNombreCuenta()
       {
           String nombreCuenta   = this.forma.getCampoNombrecuenta().getText();
           
           boolean flag  = true;
         
           try
           {
               this.conectar();
                
           if(nombreCuenta.isEmpty()){
               
               flag=!flag;
               System.out.println("Texto vacio");
           }
               
           else
           {
                 PreparedStatement ps = this.conexion.prepareStatement("Select *from administrador where NOMBRECUENTA=?");
               ps.setString(1, nombreCuenta);
               ResultSet rs = ps.executeQuery();
               
               if(rs.next())
               {
                   
                   flag=!flag;
               } 
           }
           
           }catch(Exception ex)
           {
               
                ex.printStackTrace();
           }
                
           return flag;
          
               
           
       }
       public boolean verificarClave()
       {
           String claveUsuario = this.forma.getCampoClave().getText();
           
           boolean flag  = true;
           
           try
           {
               this.conectar();
                
           if(claveUsuario.isEmpty())
               flag=!flag;
           else
           {
               PreparedStatement ps = this.conexion.prepareStatement("Select *from administrador where CLAVE=?");
               ps.setString(1, claveUsuario);
               ResultSet rs = ps.executeQuery();
               if(rs.next())
               {
                   flag=!flag;
               } 
           }
           
           }catch(Exception ex)
           {
               
                ex.printStackTrace();
           }
           
               
           return flag;
       }
       
    
    
}
