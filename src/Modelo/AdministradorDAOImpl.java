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
public class AdministradorDAOImpl extends Conexion implements   PlantillaDAO<Administrador> {

    
    private int keyInsertada=-1;
    @Override
    public void actualizar(Administrador objeto) throws Exception {
        try
        {
            this.conectar();
            PreparedStatement ps = this.conexion.prepareStatement("update administrador set NombreCuenta = ?,Nombre = ?,ApellidoPaterno = ?,ApellidoMaterno = ?  where idAdministrador  = ? ");
            ps.setString(1, objeto.getNombreCuenta());
            ps.setString(2, objeto.getNombre());
            ps.setString(3, objeto.getApellidoPaterno());
            ps.setString(4, objeto.getApellidoMaterno());
            ps.setInt(5, objeto.getID());
            
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
    public void eliminar(Administrador objeto) throws Exception {
        try
        {
            this.conectar();
            PreparedStatement ps = this.conexion.prepareStatement("delete from ADMINISTRADOR where NombreCuenta = ? AND Clave = ? ");
            ps.setString(1,objeto.getNombreCuenta());
            ps.setString(2, objeto.getNombreCuenta());
            ps.setString(3, objeto.getClave());
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
    public void insertar(Administrador objeto) throws Exception {
        try
        {
            this.conectar();
            PreparedStatement ps = this.conexion.prepareStatement("insert into ADMINISTRADOR (Nombre,NombreCuenta,Clave,ApellidoPaterno,ApellidoMaterno,FechaInicio) values (?,?,?,?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, objeto.getNombre());
            ps.setString(2, objeto.getNombreCuenta());
            ps.setString(3, objeto.getClave());
            ps.setString(4, objeto.getApellidoPaterno());
            ps.setString(5, objeto.getApellidoMaterno());
            ps.setDate(6, objeto.getFechaInicio());
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next())
                keyInsertada = rs.getInt(1);
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
    public ArrayList<Administrador> obtenerlista() throws Exception {
        ArrayList<Administrador> lista=null;	
            try
		{
		    this.conectar();
                    PreparedStatement ps = this.conexion.prepareStatement("select *from administrador");	
		   lista= new ArrayList<>();
		   ResultSet rs = ps.executeQuery();
		   while(rs.next())
			{
				Administrador al = new Administrador();
				
				
                        al.setClave(rs.getString("Clave"));
                        al.setNombre(rs.getString("Nombre"));
                        al.setNombreCuenta(rs.getString("NombreCuenta"));
			al.setID(rs.getInt("idAdministrador"));
                        al.setApellidoPaterno(rs.getString("ApellidoPaterno"));
                        al.setApellidoMaterno(rs.getString("ApellidoMaterno"));
                        al.setFechaInicio(rs.getDate("FechaInicio"));
                                
				lista.add(al);
			}
			rs.close();
			ps.close();
			
		
		}catch(Exception ex)
		{
			//System.out.println(ex.getMessage());
                        ex.printStackTrace();
                }
		finally
		{
			this.cerrar();
		}
		return lista;
    
    }

    @Override
    public Administrador obtenerObjeto(String key) throws Exception {
         Administrador pr  = null;
         try
		{
		    this.conectar();
                    PreparedStatement ps = this.conexion.prepareStatement("select *from Administrador where NOMBRECUENTA=?");	
                    ps.setString(1, key);
		    ResultSet rs = ps.executeQuery();
                    
                    while(rs.next())
                    {
                        pr = new Administrador();
				
                        pr.setClave(rs.getString("Clave"));
                        pr.setNombre(rs.getString("Nombre"));
                        pr.setNombreCuenta(rs.getString("NombreCuenta"));
			pr.setID(rs.getInt("idAdministrador"));
                        pr.setApellidoPaterno(rs.getString("ApellidoPaterno"));
                        pr.setApellidoMaterno(rs.getString("ApellidoMaterno"));
                        pr.setFechaInicio(rs.getDate("FechaInicio"));
                        
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
