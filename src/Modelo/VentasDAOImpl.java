/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Luis Huayta
 */
public class VentasDAOImpl extends Conexion implements PlantillaVentasDAO<Ventas>{


    @Override
    public ArrayList<Ventas> obtenerVentas() throws Exception {
               ArrayList<Ventas> lista=null;	
            try
		{
		    this.conectar();
                    PreparedStatement ps = this.conexion.prepareStatement("select *from Ventas");	
		   lista= new ArrayList<>();
		   ResultSet rs = ps.executeQuery();
		   while(rs.next())
			{
				Ventas vent = new Ventas();
				
                                vent.setIdVentas(rs.getInt("IdVentas"));
                        vent.setCantidadVentas(rs.getInt("CANTIDADVENTAS"));
                        vent.setGananciaAcumulada(rs.getFloat("GANANCIATOTAL"));
                        vent.setIdProducto(rs.getInt("IdProducto"));
                                
				lista.add(vent);
			}
			rs.close();
			ps.close();
			
		
		}catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		finally
		{
			this.cerrar();
		}
		return lista;
  
    }

    @Override
    public Ventas obtenerVenta(int key) throws Exception {
           Ventas vent=null;	
            try
		{
		    this.conectar();
                    PreparedStatement ps = this.conexion.prepareStatement("select *from Ventas where IdProducto=?");
                    ps.setInt(1, key);
                    vent = new Ventas();
		    ResultSet rs = ps.executeQuery();
		    while(rs.next())
                    {
                        vent.setIdVentas(rs.getInt("IdVentas"));
                        vent.setCantidadVentas(rs.getInt("CANTIDADVENTAS"));
                        vent.setGananciaAcumulada(rs.getFloat("GANANCIATOTAL"));
                        vent.setIdProducto(rs.getInt("IdProducto"));
                    }
			rs.close();
			ps.close();
			
		
		}catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		finally
		{
			this.cerrar();
		}
		return vent;
    }

    @Override
    public void insertar(Ventas ven) throws Exception {
        {
            try
            {
                this.conectar();
            PreparedStatement ps  = this.conexion.prepareStatement("insert into VENTAS (CANTIDADVENTAS,GANANCIATOTAL,IdProducto) VALUES (?,?,?)");
           
            ps.setInt(1, ven.getCantidadVentas());
            ps.setDouble(2, ven.getGananciaAcumulada());
            ps.setInt(3, ven.getIdProducto());
            ps.executeUpdate();
            }catch(Exception ex)
            {
                ex.printStackTrace();
            }
            
        }   
            
            
    }


    @Override
    public void modificar(Ventas ven) throws Exception {
        try
        {
            this.conectar();
            
            PreparedStatement ps = this.conexion.prepareStatement("update  ventas set CANTIDADVENTAS = ?, GANANCIATOTAL= ?  WHERE IdProducto = ?");
            
            ps.setInt(1, ven.getCantidadVentas());
            ps.setDouble(2, ven.getGananciaAcumulada());
            ps.setInt(3, ven.getIdProducto());
            ps.executeUpdate();
        
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
                    
        }
        finally
        {
            this.cerrar();
        }
    }

    
    
}
