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
public interface PlantillaDAO <E>{
    public void actualizar(E objeto)throws Exception;
    public void eliminar(E objeto)throws Exception;
    public void insertar(E objeto)throws Exception;
    public ArrayList<E> obtenerlista() throws Exception;
    public E obtenerObjeto(String key) throws Exception;
    public int obtenerKey();
}
