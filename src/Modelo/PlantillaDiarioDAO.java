/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Luis Huayta
 */
public interface PlantillaDiarioDAO {
    
    
    public void insertarDiario(Diario dr) throws Exception;
    public void actualizarDiario(Diario dr) throws Exception;
    public Diario getDiario(java.sql.Date fecha) throws Exception;
    
   
}
