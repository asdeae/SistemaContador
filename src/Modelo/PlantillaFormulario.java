/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author Luis Huayta
 */
public interface PlantillaFormulario <Formulario>{
    
    boolean verificarNombre(Formulario form)throws Exception;
    boolean verificarNombreCuenta(Formulario form) throws Exception;
    boolean verificarClave(Formulario form) throws Exception;
    
    Formulario obtenerFormulario(Formulario form) throws Exception;
    
}
