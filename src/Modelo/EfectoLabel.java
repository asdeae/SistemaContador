/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;


import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Luis Huayta
 */
public class EfectoLabel extends MouseAdapter{
    
    
    public int x;
    public int y;
    JFrame ventana = new JFrame();
    JLabel labelSuperior = new JLabel();
    JDialog dialog = new JDialog();
    public EfectoLabel(JFrame ventana,JLabel labelSuperior)    
    {
        this.labelSuperior=labelSuperior;
        this.ventana=ventana;
        this.labelSuperior.addMouseMotionListener(this);
        this.labelSuperior.addMouseListener(this);
    }
    
    public EfectoLabel(JDialog dialog,JLabel labelSuperior)
    {
        this.dialog=dialog;
        this.labelSuperior=labelSuperior;
        this.labelSuperior.addMouseListener(new MouseAdapter() {

            public void mousePressed(MouseEvent e)
                {
                     x = e.getX();
                     y = e.getY();  
                }
        
        }
        );
        this.labelSuperior.addMouseMotionListener(new MouseAdapter(){
            public void mouseDragged(MouseEvent e)
                {
                    Point point = MouseInfo.getPointerInfo().getLocation()   ; 
                    dialog.setLocation(point.x - x, point.y - y); 
                }
            
            
        });
               
    }
    @Override
    public void mouseDragged(MouseEvent e) {
        
        Point point = MouseInfo.getPointerInfo().getLocation()   ; 
        ventana.setLocation(point.x - x, point.y - y); 
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        x = e.getX();
        y = e.getY();  
    }

   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
            
}
