/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Calendario;
import Modelo.EfectoBoton;
import Modelo.EfectoLabel;
import Modelo.OperacionesVenta;
import Modelo.PlantillaDAO;
import Modelo.PlantillaVentasDAO;
import Modelo.Producto;
import Modelo.ProductoDAOImpl;

import Modelo.VentasDAOImpl;
import Vista.VentanaEmpresa;
import Vista.VentanaProductos;
import Vista.VistaAdministrador;
import Vista.VistaVentas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

/**
 *
 * @author Luis Huayta
 */
public class CVistaVentas implements ActionListener{

    
    
    
    PlantillaDAO<Producto> pro  = new ProductoDAOImpl(  );
    
    PlantillaVentasDAO venta = new VentasDAOImpl();
    
    
    VistaAdministrador vis = new VistaAdministrador();
    
    VistaVentas ven = new VistaVentas(vis,true);
    
    JFreeChart graf  ;
    ChartPanel contenedor= new ChartPanel(graf);
    Calendario calendario = new Calendario();
    OperacionesVenta pv = new OperacionesVenta();
    PlantillaVentasDAO vet = new VentasDAOImpl();
    
    public CVistaVentas(VistaAdministrador vis,VistaVentas ven)
    {
       this.vis=vis;
       this.ven=ven;
        
       this.ven.jButton1.addActionListener(this);
       this.ven.estadisticaEmpresa.addActionListener(this);
       this.ven.estadisticaFactura.addActionListener(this);
       this.ven.estadisticaProducto.addActionListener(this);
       
       new EfectoLabel(ven, ven.jLabelBarra);
       
       new EfectoBoton(ven, ven.jButton1,"/Imagenes/flecha-blanca.png");
       new EfectoBoton(ven, ven.estadisticaProducto, "/Imagenes/producto.png");
       new EfectoBoton(ven, ven.estadisticaEmpresa, "/Imagenes/empresa.png");
       new EfectoBoton(ven, ven.estadisticaFactura, "/Imagenes/factura.png");
       
       
       
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource().equals(this.ven.estadisticaProducto))
       {
           VentanaProductos ventana = new VentanaProductos(vis, true);
           CVentanaProductos cv = new CVentanaProductos(vis, ventana);
           ventana.setVisible(true);
       }
       if(e.getSource().equals(this.ven.estadisticaEmpresa))
       {
           
            VentanaEmpresa ventana = new VentanaEmpresa(vis, true);
            CVentanaEmpresa cv = new CVentanaEmpresa(vis,ventana);
            ventana.setVisible(true);
       }
       if(e.getSource().equals(this.ven.estadisticaFactura))
       {
            
       }
       if(e.getSource().equals(this.ven.jButton1)){
           this.ven.hide();
       }
           
              
    }
    
}

    