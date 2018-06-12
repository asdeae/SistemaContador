/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.awt.AlphaComposite;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;


/**
 *
 * @author Luis Huayta
 */
public class EfectoHoverBoton extends JButton{
    
    
    private float opacity = 0.5f;

    public float getOpacity() {
        return opacity;
    }

    public void setOpacity(float opacity) {
        this.opacity = opacity;
        repaint();
    }
    public EfectoHoverBoton()
    {
        super();
        addMouseListener(new EventButton());
    }
    public EfectoHoverBoton(String nombre)
    {
        super(nombre);
    }
    
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,opacity));
        super.paintComponent(g2);
        
        
    }
    
    class EventButton extends MouseAdapter
    {

        @Override
        public void mouseExited(MouseEvent e) {
            efectHover( 1f, 0.5f, 0.03f, 10, false);
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            efectHover(0.5f, 1f, 0.03f, 10, true);
        }

        @Override
        public void mouseClicked(MouseEvent e) {
//            efectHover( 1f, 0.5f, 0.03f, 10, false);
        }
        private void efectHover(float index,float range,float cont,int sleep,boolean event)
        {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for(float i = index;(event) ? i <= range : i>=range; i = (event) ?i+cont:i-cont)
                    {
                        setOpacity(i);
                        try
                        {
                            Thread.sleep(sleep);
                        }catch(Exception ex){
                            ex.printStackTrace();
                        }
                    }
                }
            }).start();
        }
    }
    
    
    
   
    
}
