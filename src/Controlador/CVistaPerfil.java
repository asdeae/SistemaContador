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
import Modelo.PlantillaDAO;
import Vista.VistaAdministrador;
import Vista.VistaPerfil;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author Luis Huayta
 */
public class CVistaPerfil extends MouseAdapter{
    
    
    VistaAdministrador ventana = new VistaAdministrador()
            ;
    VistaPerfil vista   = new VistaPerfil(ventana,true);
    
    CvistaAdministrador cv = new CvistaAdministrador();
    
    PlantillaDAO<Administrador> planti = new AdministradorDAOImpl();
    
    public CVistaPerfil(VistaAdministrador ventana, VistaPerfil vista,CvistaAdministrador cv)
    {
        this.ventana=ventana;
        this.vista=vista;
        this.cv=cv;
        
        
        this.vista.jButtonApellidoMaterno.addMouseListener(this);
        this.vista.jButtonApellidoPaterno.addMouseListener(this);
        this.vista.jButtonRegresar.addMouseListener(this);
        this.vista.jButtonCuenta.addMouseListener(this);
        this.vista.jButtonNombre.addMouseListener(this);
        
        
        new EfectoLabel(this.vista, this.vista.jLabelBarra);
        
        new EfectoBoton(this.vista, this.vista.jButtonRegresar, "/Imagenes/flecha-blanca.png");
        new EfectoBoton(this.vista,this.vista.jButtonApellidoMaterno,"/Imagenes/tuerca.png");
        new EfectoBoton(this.vista,this.vista.jButtonApellidoPaterno,"/Imagenes/tuerca.png");
        new EfectoBoton(this.vista,this.vista.jButtonCuenta,"/Imagenes/tuerca.png");
        new EfectoBoton(this.vista,this.vista.jButtonNombre,"/Imagenes/tuerca.png");
        
        this.vista.jTextFieldCuenta.setText(this.cv.admn.getNombreCuenta());
        this.vista.jTextFieldNombre.setText(this.cv.admn.getNombre());
        this.vista.jTextFieldApellidoMaterno.setText(this.cv.admn.getApellidoMaterno());
        this.vista.jTextFieldApellidoPaterno.setText(this.cv.admn.getApellidoPaterno());
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        if(e.getSource().equals(this.vista.jButtonRegresar))
        {
            this.vista.setVisible(false);
            
            Administrador admin = this.cv.getAdministrador();
            
            System.out.println("ID del administrador que cambia es :" +admin.getID());
            admin.setApellidoMaterno(this.vista.jTextFieldApellidoMaterno.getText());
            admin.setApellidoPaterno(this.vista.jTextFieldApellidoPaterno.getText());
            admin.setNombre(this.vista.jTextFieldNombre.getText());
            admin.setNombreCuenta(this.vista.jTextFieldCuenta.getText());
            
            this.cv.setAdministrador(admin);
            
            this.cv.setDatos(admin);
            
            try
            {
                this.planti.actualizar(admin);
            
            }catch(Exception ex)
            {
                ex.printStackTrace();
            }
            
            
        }
        if(e.getSource().equals(this.vista.jButtonCuenta))
        {
            this.vista.jTextFieldCuenta.setEditable(true);
        }
        if(e.getSource().equals(this.vista.jButtonNombre))
        {
            this.vista.jTextFieldNombre.setEditable(true);
        }
        if(e.getSource().equals(this.vista.jButtonApellidoMaterno))
        {
            this.vista.jTextFieldApellidoMaterno.setEditable(true);
        }
        if(e.getSource().equals(this.vista.jButtonApellidoPaterno))
        {
            this.vista.jTextFieldApellidoPaterno.setEditable(true);
        }
            
        
            
        
        
    }
    
    
    
    
}
