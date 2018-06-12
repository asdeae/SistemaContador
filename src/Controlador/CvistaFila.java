/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;



import Modelo.Diario;
import Modelo.DiarioDAOImpl;
import Modelo.EfectoBoton;
import Modelo.EfectoLabel;
import Modelo.PlantillaDAO;
import Modelo.PlantillaDiarioDAO;
import Modelo.PlantillaVentasDAO;
import Modelo.Producto;
import Modelo.ProductoDAOImpl;
import Modelo.ValidacionesProducto;
import Modelo.Ventas;
import Modelo.VentasDAOImpl;
import Vista.VistaAdministrador;
import Vista.VentanaFila;
import Vista.VistaAyudaCantidad;
import Vista.VistaAyudaMarca;
import Vista.VistaAyudaPrecio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Luis Huayta
 */
public class CvistaFila implements ActionListener{

    PlantillaDAO<Producto> pro = new ProductoDAOImpl();
    PlantillaVentasDAO ventas = new VentasDAOImpl();
    PlantillaDiarioDAO diario = new DiarioDAOImpl();
    VistaAdministrador vent = new VistaAdministrador();
    
    VentanaFila venF = new VentanaFila(vent,true);
    
    ValidacionesProducto vp = new ValidacionesProducto();
    
    CvistaAdministrador cv = new CvistaAdministrador();
    
    public CvistaFila(PlantillaDAO<Producto> pro,VistaAdministrador vent,VentanaFila venF,CvistaAdministrador cv)
    {
        this.pro=pro;
        this.vent=vent;
        this.venF=venF;
        this.cv=cv;
        
        this.venF.jButtonAceptar.addActionListener(this);
        this.venF.jButtonAyudaCantidad.addActionListener(this);
        this.venF.jButtonAyudaMarca.addActionListener(this);
        this.venF.jButtonAyudaPrecio.addActionListener(this);
        this.venF.jButtonRegresar.addActionListener(this);
        new EfectoLabel(this.venF,this.venF.jLabelBarra);
        new EfectoBoton(this.venF.jButtonAceptar);
        new EfectoBoton(this.venF.jButtonAyudaCantidad);
        new EfectoBoton(this.venF.jButtonAyudaMarca);
        new EfectoBoton(this.venF.jButtonAyudaPrecio);
        new EfectoBoton(this.venF,this.venF.jButtonRegresar,"/Imagenes/flecha-blanca.png");
        
        
              
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        
        
        if(e.getSource().equals(this.venF.jButtonAceptar))
        {
            Diario dr = null;
            try
            {
                    Producto o = new Producto();
                    
                    o.setMarca(venF.jTextMarca.getText());
                    o.setPrecioUnitario(Double.parseDouble(venF.jTextFieldPrecio.getText()));
                    o.setStock(Integer.parseInt(venF.jTextCantidad.getText()));
                    
                    pro.insertar(o);
                    
                    JOptionPane.showMessageDialog(venF, "Datos insertados de manera correcta");
                    Ventas ven = new Ventas(pro.obtenerKey());
                    ventas.insertar(ven);
                    
                    dr = diario.getDiario(new java.sql.Date(new java.util.Date().getTime()));
                    
                    if(dr==null)
                    {
                        dr= new Diario(0,0);
                        diario.insertarDiario(dr);
                    }
                     
                    dr.setGananciaDiaria(0);
                    dr.setVentaDiaria(0);
                    
                    
                     Tabla t = new Tabla(this.vent.jTable1,this.pro);
                     t.ver_tabla(this.vent.jTable1, pro);
                     this.cv.carro.iniciarCarrito();
                     venF.hide();
                    
            
                
            }catch(Exception ex)
            {   
                JOptionPane.showMessageDialog(this.venF, "Campos vacios o erroneos de formato");
            }
            
        }
        if(e.getSource().equals(this.venF.jButtonRegresar))
        {
            venF.hide();
            
        }
        if(e.getSource().equals(this.venF.jButtonAyudaCantidad))
        {
            VistaAyudaCantidad vista = new VistaAyudaCantidad(vent, true);
            CVistaAyudaCantidad cv  = new CVistaAyudaCantidad(vent, venF, vista);
            vista.setVisible(true);
        }
        if(e.getSource().equals(this.venF.jButtonAyudaMarca))
        {
            VistaAyudaMarca vista = new VistaAyudaMarca(vent, true);
            CVistaAyudaMarca cv  = new CVistaAyudaMarca(vent, venF, vista);
            vista.setVisible(true);
        
        }
        if(e.getSource().equals(this.venF.jButtonAyudaPrecio))
        {
           
            VistaAyudaPrecio vista = new VistaAyudaPrecio(vent, true);
            CVistaAyudaPrecio cv  = new CVistaAyudaPrecio(vent, venF, vista);
            vista.setVisible(true);
        }
        
    }
}
