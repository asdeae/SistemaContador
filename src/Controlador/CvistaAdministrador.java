/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import Modelo.EfectoBoton;
import Modelo.Administrador;
import Modelo.CarritoDAOImpl;
import Modelo.EfectoLabel;
import Modelo.Factura;
import Modelo.FacturaDAOImpl;
import Modelo.OperacionesVenta;
import Modelo.PlantillaCarritoDAO;
import Modelo.PlantillaDAO;
import Modelo.PlantillaFacturaDAO;
import Modelo.PlantillaVentasDAO;
import Modelo.Producto;
import Modelo.ProductoDAOImpl;
import Modelo.Ventas;
import Modelo.VentasDAOImpl;
import Vista.VentanaEliminar;
import Vista.VentanaFila;
import Vista.VentanaModificar;
import Vista.VistaAdministrador;
import Vista.VistaFactura;
import Vista.VistaPerfil;
import Vista.VistaPrincipal;
import Vista.VistaVentas;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.util.ArrayList;

import javax.swing.JOptionPane;


/**
 *
 * @author Luis Huayta
 */
public class CvistaAdministrador extends MouseAdapter{
    
    
    
    VistaAdministrador vista = new VistaAdministrador();
    
    PlantillaFacturaDAO factura = new FacturaDAOImpl();
    
    PlantillaDAO<Producto> pro = new ProductoDAOImpl();
    
    Administrador admn = new Administrador();
    
    ArrayList<Ventas> carrito  = new ArrayList<>();
    ArrayList<Producto> productos = new ArrayList();
    OperacionesVenta op = new OperacionesVenta();
    StringBuilder cabeceraFactura = new StringBuilder();
    StringBuilder contenidoFactura = new StringBuilder();
    
    
    PlantillaVentasDAO ventas = new VentasDAOImpl();
    PlantillaCarritoDAO carro = new CarritoDAOImpl(carrito, productos);
    public CvistaAdministrador(VistaAdministrador vista,Administrador adm)
    {
        this.vista=vista;
        setAdministrador(adm);
        
        
        
        
        
        this.carro.iniciarCarrito();
        
        
        this.vista.jButtonAgregar.addMouseListener(this);
        this.vista.jButtonEliminar.addMouseListener(this);
        this.vista.jButtonModifica.addMouseListener(this);
        this.vista.jButtonEstadisticas.addMouseListener(this);
        this.vista.jButtonFactura.addMouseListener(this);
        this.vista.jButtonCerrarSesion.addMouseListener(this);
        this.vista.jTable1.addMouseListener(this);
        this.vista.jTextAreaFactura.addMouseListener(this);
        this.vista.mayorGanancia.addMouseListener(this);
        this.vista.menorGanancia.addMouseListener(this);
        this.vista.mayorVenta.addMouseListener(this);
        this.vista.menorVenta.addMouseListener(this);
        this.vista.jButtonFoto.addMouseListener(this);
        this.vista.jButtonVentaHoy.addMouseListener(this);
        this.vista.jButtonGananciaHoy.addMouseListener(this);
        
        new EfectoLabel(this.vista,this.vista.jLabel5);
        new EfectoBoton(this.vista.jButtonAgregar);
        new EfectoBoton(this.vista.jButtonEliminar);
        new EfectoBoton(this.vista.jButtonModifica);
        new EfectoBoton(this.vista.jButtonEstadisticas);
        new EfectoBoton(this.vista.jButtonFactura);
        new EfectoBoton(this.vista, this.vista.mayorGanancia, "/Imagenes/gain.png");
        new EfectoBoton(this.vista, this.vista.menorGanancia, "/Imagenes/loss.png");
        new EfectoBoton(this.vista, this.vista.mayorVenta, "/Imagenes/bar-chart.png");
        new EfectoBoton(this.vista, this.vista.menorVenta, "/Imagenes/bars.png");
        new EfectoBoton(this.vista,this.vista.ventaHoy,"/Imagenes/shopping-cart.png");
        new EfectoBoton(this.vista,this.vista.gananciaHoy,"/Imagenes/coin.png");
        new EfectoBoton(this.vista,this.vista.jButtonFoto,"/Imagenes/avatar-inside-a-circle.png");
        
        setDatos(this.admn);
        
        Tabla t = new Tabla(this.vista.jTable1, this.pro);
        t.ver_tabla(this.vista.jTable1, pro);
        
    }
    public CvistaAdministrador()
    {
        
    }
    
    public void mouseClicked(MouseEvent e)
    {
        if(e.getSource().equals(this.vista.jButtonCerrarSesion))
        {
            this.carro.vaciarCarrito();
            this.carro.iniciarCarrito();
            VistaPrincipal ven = new VistaPrincipal();
            CvistaPrincipal cv = new CvistaPrincipal(ven);
            ven.setVisible(true);
            this.vista.dispose();
        }
        if(e.getSource().equals(this.vista.jButtonAgregar))
        {
            VentanaFila ven = new VentanaFila(this.vista,true);
            CvistaFila cvs = new CvistaFila(pro, vista, ven,this);
            ven.setVisible(true);
        }
        if(e.getSource().equals(this.vista.jButtonEliminar))
        {
            VentanaEliminar ven = new VentanaEliminar(this.vista,true);
            CventanaEliminar cv = new CventanaEliminar(this.vista, this.pro, ven);
            ven.setVisible(true);
        }
        if(e.getSource().equals(this.vista.jButtonModifica))
        {
            VentanaModificar ven = new VentanaModificar(this.vista,true);
            CventanaModificar cv = new CventanaModificar(this.pro, this.vista, ven);
            ven.setVisible(true);
        }
        
        if(e.getSource().equals(this.vista.jButtonEstadisticas))
        {
            VistaVentas ven = new VistaVentas(this.vista, true);
            CVistaVentas cv = new CVistaVentas(this.vista, ven);
            ven.setVisible(true);
            
        }
        if(e.getSource().equals(this.vista.jTable1) && e.getClickCount()==2 && e.getButton()==1) //Funcionalidad vender :v
        {
            
            int filaSeleccionada  = this.vista.jTable1.getSelectedRow();
            int columnaseleccionada = this.vista.jTable1.getSelectedColumn();
            
            {
                try
                {
                    
                    Producto obj =  this.pro.obtenerObjeto(this.vista.jTable1.getValueAt((filaSeleccionada), columnaseleccionada).toString());
                    
                    this.carro.aumentarCantidadC(obj);
                    this.carro.precioProducto(obj);
                    
                    
                    pintarTextArea();
                    
                }
                catch(Exception ex)
                {
                    JOptionPane.showMessageDialog(this.vista, "Realizar los 2 clics en la columna de la marca");
                }
            }
            
        }
        if(e.getSource().equals(this.vista.jTable1) && e.getClickCount()==2 && e.getButton()==3){
            int filaSeleccionada  = this.vista.jTable1.getSelectedRow();
            int columnaseleccionada = this.vista.jTable1.getSelectedColumn();
            
            {
                try
                {
                    
                    Producto obj =  this.pro.obtenerObjeto(this.vista.jTable1.getValueAt((filaSeleccionada), columnaseleccionada).toString());
                    
                    this.carro.disminuirCantidadC(obj);
                    this.carro.precioProducto(obj);
                    
                    pintarTextArea();
                    
                }
                catch(Exception ex)
                {
                    JOptionPane.showMessageDialog(this.vista, "Realizar los 2 clics en la columna de la marca");
                }
            }
        }
        if(e.getSource().equals(this.vista.jButtonFactura))
        {
           try
           {
               if(this.vista.jTextAreaFactura.getText().isEmpty() || this.vista.jTextAreaFactura.getText().equals("") || this.carro.obtenerCarrito().isEmpty())
               {
                    JOptionPane.showMessageDialog(this.vista, "No existe precompra en la boleta");
               }
               else
               {
                   this.carro.actualizarProductos();
                 
                 
                 
                 Tabla t = new Tabla(this.vista.jTable1, this.pro);
                 t.ver_tabla(this.vista.jTable1, pro);
                 
                 
                
                VistaFactura vista  = new VistaFactura(this.vista, true);
                CVistaFactura cv  = new CVistaFactura(this.vista, vista,this);
                
                
                    
                        Factura fac = new Factura();
                        fac.setContenidoFactura(this.vista.jTextAreaFactura.getText());
                        fac.setFechaVenta( new java.sql.Date(new java.util.Date().getTime()));
                        factura.insertarFactura(fac);
                
                
                
                
                this.vista.jTextAreaFactura.setText("");
                this.carro.vaciarCarrito();
                this.carro.iniciarCarrito();
                vista.setVisible(true);
               }
               
               
               
                
           }
           catch(Exception ex)
           {
               ex.printStackTrace();
           }
        }
       
        if(e.getSource().equals(this.vista.jTextAreaFactura))
        {
                this.vista.jTextAreaFactura.setText("");
                this.carro.vaciarCarrito();
                this.carro.iniciarCarrito();
        }  
       
       if(e.getSource().equals(this.vista.jButtonFoto))
       {
          VistaPerfil ventana = new VistaPerfil(vista, true);
          CVistaPerfil cv = new CVistaPerfil(vista, ventana,this);
          ventana.setVisible(true);
       }
          
    }
    public void mouseEntered (MouseEvent e)
    {
        if(e.getSource().equals(this.vista.gananciaHoy))
        {
            
        }
        if(e.getSource().equals(this.vista.ventaHoy))
        {
            
        }
    }
    public void mouseExited(MouseEvent e)
    {
        if(e.getSource().equals(this.vista.gananciaHoy))
        {
            
        }
        if(e.getSource().equals(this.vista.ventaHoy))
        {
            
        }
    }
            
            
    public void pintarTextArea()
    {
        this.vista.jTextAreaFactura.setText("");
        
        contenidoFactura.delete(0, contenidoFactura.toString().length());
        
        for(Ventas o:this.carro.obtenerCarrito())
            if(o.getCantidadVentas()>0)
                contenidoFactura.append(o.getIdProducto()+"             "+o.getCantidadVentas()+"\n".toString());
            
        this.vista.jTextAreaFactura.setText(contenidoFactura.toString());
        
    }
    public void setAdministrador(Administrador adm)
    {
        this.admn=adm;
    }
    public Administrador getAdministrador()    
    {
        return this.admn;
    }
    public void setDatos(Administrador adm)
    {
        this.vista.jLabelNombre.setText(adm.getNombre().toUpperCase());
        this.vista.jLabelPrimerApellido.setText(adm.getApellidoPaterno().toUpperCase());
        this.vista.jLabelSegundoApellido.setText(adm.getApellidoMaterno().toUpperCase());
        
    }
}