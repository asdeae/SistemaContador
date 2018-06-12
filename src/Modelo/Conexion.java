/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Luis Huayta
 */
public class Conexion {
    protected Connection conexion;
	
	private final String nombreDB="root";
	private final String contraDB="";
	
	
	public void conectar()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
            
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/sistematienda",nombreDB,contraDB);
            
		}catch(Exception ex)
		{
			ex.printStackTrace();
			
		}
		
	}
	public void cerrar() throws SQLException
	
	{
		if(conexion!=null)
			if(!conexion.isClosed())
				conexion.close();
	}
}
