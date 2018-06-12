/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Calendario;
import Modelo.OperacionesVenta;
import Modelo.PlantillaDAO;
import Modelo.PlantillaVentasDAO;
import Modelo.Ventas;
import Modelo.VentasDAOImpl;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;

import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Luis Huayta
 */
public class Estadistica {
    
    
    
    private DefaultCategoryDataset dataVentas;
    private DefaultCategoryDataset dataGanancia;
    private JFreeChart graf  ;
    private ChartPanel contenedor= new ChartPanel(graf);
    private Calendario calendario = new Calendario();
    private OperacionesVenta pv = new OperacionesVenta();
    private PlantillaVentasDAO vet = new VentasDAOImpl();
    
    JComboBox jcb = new JComboBox();
    public Estadistica(JComboBox jcb)
    {
        
        this.jcb=jcb;
        
        
    }
    public Estadistica()
    {
        
    }
    
    
    public ChartPanel obtenerGrafico(ArrayList<Ventas> lista)
    {
        
            
            
        graf = ChartFactory.createBarChart3D("RECORDS", "DIAS", "VENTA", obtenerVentas(lista), PlotOrientation.VERTICAL, true, true, false);
        
        return new ChartPanel(graf);
    }
    
    private DefaultCategoryDataset obtenerVentas(ArrayList<Ventas> lista) //Devuelve un grafico de las ventas realizadas por hoy
    {
        dataVentas = null;
        try
        {
            if(pv.mayorVentas(lista).getCantidadVentas()==0)
            {
                    dataVentas.addValue(pv.mayorVentas(lista).getCantidadVentas(),pv.mayorVentas(lista).getIdProducto(), calendario.getDIA());
                    dataVentas.addValue(pv.menorVentas(lista).getCantidadVentas(),pv.menorVentas(lista).getIdProducto(), calendario.getDIA());
            }
            if(pv.mayorVentas(lista).getCantidadVentas()!=0 && pv.menorVentas(lista).getCantidadVentas()==0)
            {
                    
            }
            if(pv.productosVendidos(lista))
            {
                
            }
            
       
        
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return dataVentas;
    }
    private DefaultCategoryDataset obtenerGanancias(ArrayList<Ventas> lista) //Devuelve un grafico de las gananccias realizadas por hoy
    {
        dataGanancia = null;
        try
        {
            if(pv.mayorGanancia(lista).getGananciaAcumulada()>0&&pv.menorGanancia(lista).getGananciaAcumulada()!=0)
            {
                dataGanancia.addValue(pv.mayorGanancia(lista).getGananciaAcumulada(), pv.mayorGanancia(lista).getIdProducto(), calendario.getDIA());
                dataGanancia.addValue(pv.menorGanancia(lista).getGananciaAcumulada(), pv.menorGanancia(lista).getIdProducto(),calendario.getDIA());
            }
            else
            {
            
            }
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return dataGanancia;
    } 
    private void setDatosOrdenados(ArrayList<Ventas> lista)
    {
        dataGanancia.addValue(pv.mayorGanancia(lista).getGananciaAcumulada(), pv.mayorGanancia(lista).getIdProducto(), calendario.getDIA());
            
    }
    
    
    
    
    
}
