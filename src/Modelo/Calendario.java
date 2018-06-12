/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Luis Huayta
 */
public class Calendario {
    
    Calendar calendar  = new GregorianCalendar();
    
    private String DIA;
    private String MES;
    private String ANIO;
    
    public String getDIA() {
        return DIA;
    }

    

    public String getMES() {
        return MES;
    }


    public String getANIO() {
        return ANIO;
    }
    
    
    
    public Calendario()
    {
        obtenerDia();
        obtenerMes();
        obtenerAnio();
    
    }
    public void obtenerDia()
    {
        switch(calendar.get(Calendar.DAY_OF_WEEK))
        {
            case 1: DIA ="DOMINGO";break;
            case 2: DIA="LUNES";break;
            case 3: DIA="MARTES";break;
            case 4: DIA="MIERCOLES";break;
            case 5: DIA="JUEVES";break;
            case 6: DIA="VIERNES";break;
            case 7: DIA="SABADO";break;
        }
        
    }
    public void obtenerMes()
    {
        switch(calendar.get(Calendar.MONTH))
        {
            case 0: MES="ENERO";break;
            case 1: MES="FEBRERO";break;
            case 2: MES="MARZO";break;
            case 3: MES="ABRIL";break;
            case 4: MES="MAYO";break;
            case 5: MES="JUNIO";break;
            case 6: MES="JULIO";break;
            case 7: MES="AGOSTO";break;
            case 8: MES="SEPTIEMBRE";break;
            case 9: MES="OCTUBRE";break;
            case 10: MES="NOVIEMBRE";break;
            case 11: MES="DICIEMBRE";break;
        }
    }
    public void obtenerAnio()
    {
       ANIO = String.valueOf(calendar.get(Calendar.YEAR));
    }
    
}
    

