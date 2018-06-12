/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.EfectoBoton;
import Modelo.Administrador;
import Modelo.AdministradorDAOImpl;
import Modelo.Diario;
import Modelo.DiarioDAOImpl;
import Modelo.EfectoLabel;
import Modelo.Login;
import Modelo.PlantillaDAO;
import Modelo.PlantillaDiarioDAO;
import Vista.VistaAdministrador;
import Vista.VistaPrincipal;
import Vista.VistaRegistro;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Luis Huayta
 */
public class CvistaPrincipal implements ActionListener{
    
    
    VistaPrincipal vp  = new VistaPrincipal();
    
    Login log = new Login();
    
    PlantillaDAO<Administrador> admn = new AdministradorDAOImpl();
    PlantillaDiarioDAO diario = new DiarioDAOImpl();
    
    public CvistaPrincipal(VistaPrincipal vp)           
    {
        this.vp=vp;
        new EfectoLabel(this.vp,this.vp.jLabelBarraSuperior);
        this.vp.jButton1.addActionListener(this);
        this.vp.jButton2.addActionListener(this);
       
        this.vp.jButtonMinimizar.addActionListener(this);
        this.vp.jButtonCerrar.addActionListener(this);
       
        this.vp.jLabelImagen.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/Imagenes/online-store.png")).getImage().getScaledInstance(this.vp.jLabelImagen.getWidth(), this.vp.jLabelImagen.getHeight(), Image.SCALE_DEFAULT)));
        new EfectoBoton(this.vp.jButton1);
        new EfectoBoton(this.vp.jButton2);
        
       
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(this.vp.jButton1))
        {
            if(log.verificarLogin(this.vp.jTextField1.getText(),this.vp.jPasswordField1.getText()))
            {
                this.vp.hide();
                try{
                    Administrador admn = this.admn.obtenerObjeto(this.vp.jTextField1.getText());
                    VistaAdministrador obj = new VistaAdministrador();
                    CvistaAdministrador vis = new CvistaAdministrador(obj,admn);
                    iniciarDiario();
                    obj.setVisible(true);
                }catch(Exception ex)
                {
                    ex.printStackTrace();
                }
                
            }
            else
                JOptionPane.showMessageDialog(this.vp, "Error de Login");
        }
        if(e.getSource().equals(this.vp.jButton2))
        {
            
            this.vp.hide();
            VistaRegistro obj = new VistaRegistro();
            CvistaRegistro cv = new  CvistaRegistro(obj);
            obj.setVisible(true);
        }
        if(e.getSource().equals(this.vp.jButtonCerrar))
            System.exit(0);
        if(e.getSource().equals(this.vp.jButtonMinimizar))
            this.vp.setExtendedState(JFrame.ICONIFIED);
      
    }
    public void iniciarDiario(){
        
        Diario dr = null;
        
        try
        {
              dr = diario.getDiario(new java.sql.Date(new java.util.Date().getTime()));
                    
                    if(dr==null)
                    {
                        dr= new Diario(0,0);
                        dr.setFechaDia(new java.sql.Date(new java.util.Date().getTime()));
                        diario.insertarDiario(dr);
                    }
                     
                    dr.setGananciaDiaria(0);
                    dr.setVentaDiaria(0);
                    
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
    
    
}
