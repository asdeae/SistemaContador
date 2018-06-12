/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import oracle.jrockit.jfr.ProducerDescriptor;

/**
 *
 * @author Luis Huayta
 */
public class ProductoDAOImpl extends Conexion implements PlantillaDAO<Producto>{

    
    private int keyInsertada =-1;
    
    
   
    
    
    
    @Override
    public void actualizar(Producto objeto) throws Exception {
       try
       {
           
           this.conectar();
            PreparedStatement ps = this.conexion.prepareStatement("update  PRODUCTOS set CANTIDAD = ?, PRECIOUNITARIO = ?  WHERE MARCA = ? ");
            ps.setInt(1, objeto.getStock());
            ps.setDouble(2, objeto.getPrecioUnitario());
            ps.setString(3, objeto.getMarca());
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
    @Override
    public void eliminar(Producto objeto) throws Exception {
        try
       {
           
           this.conectar();
            PreparedStatement ps = this.conexion.prepareStatement("delete from  PRODUCTOS where MARCA = ? ");
            ps.setString(1, objeto.getMarca());
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

    @Override
    public void insertar(Producto objeto) throws Exception {
     try
        {
            this.conectar();
            PreparedStatement ps = this.conexion.prepareStatement("insert into PRODUCTOS (MARCA,CANTIDAD,PRECIOUNITARIO) values (?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, objeto.getMarca());
            ps.setInt(2, objeto.getStock());
            ps.setDouble(3, objeto.getPrecioUnitario());
            ps.executeUpdate();
            ResultSet rs  = ps.getGeneratedKeys();
            if(rs.next())
            {
                keyInsertada  = rs.getInt(1);
            }
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

    @Override
    public ArrayList<Producto> obtenerlista() throws Exception {
        ArrayList<Producto> lista=null;	
            try
		{
		    this.conectar();
                    PreparedStatement ps = this.conexion.prepareStatement("select *from Productos");	
		   lista= new ArrayList<>();
		   ResultSet rs = ps.executeQuery();
		   while(rs.next())
			{
				Producto pr = new Producto();
				pr.setIdProducto(rs.getInt(1));
                                pr.setMarca(rs.getString(2));
                                pr.setPrecioUnitario(rs.getFloat(3));
                                pr.setStock(rs.getInt(4));
                                
				lista.add(pr);
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
    public Producto obtenerObjeto(String key) throws Exception {
        Producto pr  = null;
         try
		{
		    this.conectar();
                    PreparedStatement ps = this.conexion.prepareStatement("select *from Productos where MARCA=?");	
                    ps.setString(1, key);
		    ResultSet rs = ps.executeQuery();
                    
                    while(rs.next())
                    {
                        pr = new Producto();
                        pr.setIdProducto(rs.getInt(1));
                        pr.setMarca(rs.getString(2));
                        pr.setPrecioUnitario(rs.getFloat(3));
                        pr.setStock(rs.getInt(4));
                                
			
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
		return pr;
        
    }

    @Override
    public int obtenerKey() {
        return this.keyInsertada;
    }
}
    
    

