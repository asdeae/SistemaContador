/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Administrador;
import Modelo.AdministradorDAOImpl;
import Modelo.EfectoBoton;
import Modelo.EfectoLabel;
import Modelo.Formulario;
import Modelo.PlantillaDAO;
import Modelo.Producto;
import Modelo.ProductoDAOImpl;
import Modelo.Validaciones;
import Vista.AdvertenciaApellidoMaterno;
import Vista.AdvertenciaApellidoPaterno;
import Vista.AdvertenciaCamposVacios;
import Vista.AdvertenciaClave;
import Vista.AdvertenciaNombre;
import Vista.AdvertenciaNombreCuenta;
import Vista.VistaPrincipal;
import Vista.VistaRegistro;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Luis Huayta
 */
public class CvistaRegistro implements ActionListener{

    
    
    
    VistaRegistro obj = new VistaRegistro();
    
    PlantillaDAO<Administrador> admin = new AdministradorDAOImpl();
    
    public CvistaRegistro(VistaRegistro obj)           
    {
        
        this.obj=obj;
        this.obj.jButton1.addActionListener(this);
        this.obj.jButtonRegresar.addActionListener(this);
        new EfectoBoton(this.obj, this.obj.jButtonRegresar, "/Imagenes/flecha-blanca.png");
        new EfectoBoton(this.obj.jButton1);
        new EfectoLabel(this.obj, this.obj.jLabelBarra);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        
        if(e.getSource().equals(this.obj.jButton1)){
            Formulario form = new Formulario();
        
            form.setCampoNombrecuenta(this.obj.jTextFieldCuentaUsuari);
            form.setCampoClave(this.obj.jPasswordFieldClave);
        
            form.setCampoNombre(this.obj.jTextFieldNombre);
            form.setCampoPrimerApellido(this.obj.jTextFieldApellidoPaterno);
            form.setCampoSegundoApellido(this.obj.jTextFieldApellidoMaterno);
        
        
            Validaciones v = new Validaciones(form);
            
            if(form.isEmpty())
            {
                AdvertenciaCamposVacios vent = new AdvertenciaCamposVacios(obj, true);
                CAdvertenciaCamposVacios ca = new CAdvertenciaCamposVacios(obj, vent);
                vent.setVisible(true);
            }
            else
            
            if(!v.verificarClave()){
                   AdvertenciaClave vent = new AdvertenciaClave(obj, true);
                   CAdvertenciaClave ca = new CAdvertenciaClave(obj, vent);
                   vent.setVisible(true);
        
            }
        
                
            else
        
                if(!v.verificarNombre())
                {
                    AdvertenciaNombre vent = new AdvertenciaNombre(obj, true);
                   CAdvertenciaNombre ca = new CAdvertenciaNombre(obj, vent);
                   vent.setVisible(true);
            
                }
            
                    
                else
            
                    if(!v.verificaNombreCuenta())
                    {
                         AdvertenciaNombreCuenta vent = new AdvertenciaNombreCuenta(obj, true);
                        CAdvertenciaNombreCuenta ca = new CAdvertenciaNombreCuenta(obj, vent);
                        vent.setVisible(true);
            
                
                    }
                
                        
                    else
                        if(!v.verificarApellidoMaterno())
                        {
                             AdvertenciaApellidoMaterno vent = new AdvertenciaApellidoMaterno(obj, true);
                        CAdvertenciaApellidoMaterno ca = new CAdvertenciaApellidoMaterno(obj, vent);
                        vent.setVisible(true);
                        }
                        
                        
                        
                        else
                            if(!v.verificarApellidoPaterno())
                            {
                                AdvertenciaApellidoPaterno vent = new AdvertenciaApellidoPaterno(obj, true);
                                CAdvertenciaApellidoPaterno ca = new CAdvertenciaApellidoPaterno(obj, vent);
                                vent.setVisible(true);
                            }
                               
                            else    
                        {
                    
                    
                        Administrador adm = new Administrador();
                    
                        adm.setClave(form.getCampoClave().getText().toUpperCase());
                        adm.setNombre(form.getCampoNombre().getText().toUpperCase());
                        adm.setApellidoMaterno(form.getCampoSegundoApellido().getText().toUpperCase());
                        adm.setApellidoPaterno(form.getCampoPrimerApellido().getText().toUpperCase());
                        adm.setFechaInicio(new java.sql.Date(new java.util.Date().getTime()));
                        adm.setNombreCuenta(form.getCampoNombrecuenta().getText().toUpperCase());
                        
                        try
                        {
                            this.admin.insertar(adm);
                    
                        }catch(Exception ex)
                        {
                            ex.printStackTrace();
                        }
                    
                        JOptionPane.showMessageDialog(obj, "Cuenta creada con éxito");
                        this.obj.dispose();
                        VistaPrincipal ven = new VistaPrincipal();
                    
                        CvistaPrincipal cv = new CvistaPrincipal(ven);
                        
                        ven.setVisible(true);
                    }
                    
        }
        if(e.getSource().equals(this.obj.jButtonRegresar)){
            this.obj.dispose();
            VistaPrincipal ven = new VistaPrincipal()
                    ;
            CvistaPrincipal cv = new CvistaPrincipal(ven);
            ven.setVisible(true);
            
        }
       
                    
                    
                
                        
    }
            
}
    
    
    
    

