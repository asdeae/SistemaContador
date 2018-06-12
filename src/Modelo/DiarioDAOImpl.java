/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;



import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Luis Huayta
 */
public class DiarioDAOImpl extends Conexion implements PlantillaDiarioDAO{

    
    
    OperacionesVenta op = new OperacionesVenta();
    
    
    private static Diario instancia;
    
    
    
    
    @Override
    public Diario getDiario(java.sql.Date fecha) throws Exception {
        
        
        Diario dr  =  null;
        
        try
            
        {
            this.conectar();
            
             
                    PreparedStatement ps = this.conexion.prepareStatement("select *from Diario where fechaDia=?");	
                    ps.setDate(1, fecha);
		    ResultSet rs= ps.executeQuery();
                            
                    
                    if(rs.next())
                    {
                        dr = new Diario();
				
                        dr.setFechaDia(rs.getDate("fechaDia"));
                        dr.setGananciaDiaria(rs.getDouble("GananciaDia"));
                        dr.setIdDiario(rs.getInt("idDiario"));
                        dr.setVentaDiaria(rs.getInt("VentaDia"));
                        
                    
                    }        
                    
			rs.close();
			ps.close();
                        
            
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            this.cerrar();
        }
        
        return dr;
    }

    @Override
    public void insertarDiario(Diario dr) throws Exception {
        
        try
        {
            this.conectar();
            
             
                    PreparedStatement ps = this.conexion.prepareStatement("insert into Diario (GananciaDia,VentaDia,fechaDia) values (?,?,?)");	
                    ps.setDouble(1,dr.getGananciaDiaria() );
                    ps.setInt(2, dr.getVentaDiaria());
                    ps.setDate(3, dr.getFechaDia());
		    ps.executeUpdate();
            
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            this.cerrar();
        }
    }

   

    @Override
    public void actualizarDiario(Diario dr) throws Exception {
        
        try
        {
            this.conectar();
            
            PreparedStatement ps = this.conexion.prepareStatement("update diario set GananciaDia=?,VentaDia=? where idDiario=?");
            
            ps.setDouble(1, dr.getGananciaDiaria());
            ps.setInt(2, dr.getVentaDiaria());
            ps.setInt(3, dr.getIdDiario());
            ps.executeUpdate();
            
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            this.cerrar();
        }
    }

  
    public static Diario instanciaDiario() {
        
        
        if(instancia==null)
            instancia = new Diario(0,0);
        
        return instancia;
    }

    
}
