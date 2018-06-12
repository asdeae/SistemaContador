/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Luis Huayta
 */
public class OperacionesVenta {
     
    public PlantillaVentasDAO<Ventas> registro = new VentasDAOImpl();
    public ArrayList<Producto> productos = new ArrayList();
  
    public java.sql.Date fecha = new Date(new java.util.Date().getTime());
    
    public float gananciaTotal()
    {
    
        float sumaTotal =0 ; 
        
        try
        {
            ArrayList<Ventas> vt =registro.obtenerVentas();
       
            for(int i = 0 ; i < vt.size();i++)
                sumaTotal += vt.get(i).getGananciaAcumulada();
        
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return sumaTotal;
    }
    
    public int ventaTotal ()
    {
        
        int sumaTotal = 0 ;
        try
        {
            ArrayList<Ventas> vt = registro.obtenerVentas();
        
        
        for(int i = 0 ; i < vt.size();i++)
        {
            sumaTotal += vt.get(i).getCantidadVentas();
        }
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return sumaTotal;
    }
    
   public int cantidadvendidaProducto(Ventas ven)
   {
       return ven.getCantidadVentas();
   }
   public double gananciaobtenidaProducto(Ventas ven)
   {
       return ven.getGananciaAcumulada();
   }
   public Ventas mayorVentas(ArrayList<Ventas> lista) //Retorna el objeto con la mayor cantidad de objetos vendidos
    {
        
        Ventas venta = new Ventas();
        
        int mayor = -1;
        for (Ventas o : lista) {
            if(o.getCantidadVentas()>mayor)
                venta = o;
        }
        return venta;
    }
    public Ventas menorVentas(ArrayList<Ventas> lista) //Retorna el objeto con el menor cantidad de objetos vendidos
    {
        Ventas venta = new Ventas();
        int menor = 99999;
        for(Ventas o : lista)
            if(o.getCantidadVentas()<menor)
                venta = o;
        
        return venta;
    }
    public boolean productosVendidos(ArrayList<Ventas> lista) //Retorna verdadero si no se han vendido objetos hasta ese entonces
    {
        return lista.stream().noneMatch((o) -> (o.getCantidadVentas()!=0));
    }
    public Ventas mayorGanancia(ArrayList<Ventas> lista)
    {
        Ventas venta = new Ventas();
        double mayor =-1;
        for(Ventas o : lista)
            if(o.getGananciaAcumulada()>mayor)
                venta=o;
       return venta;
    }
    public Ventas menorGanancia(ArrayList<Ventas> lista)
    {
        Ventas venta = new Ventas();
        double menor=99999;
        for(Ventas o: lista)
            if(o.getGananciaAcumulada()<menor)
                venta=o;
        return venta;
    }
    
    public Ventas[] obtenerVentasMenor(ArrayList<Ventas> lista)
    {
        
        Ventas venta[] = new Ventas[3];
        
        Collections.sort(lista,new Comparator<Ventas>() {
            @Override
            public int compare(Ventas o1, Ventas o2) {
                
                if(o1.getCantidadVentas()>o2.getCantidadVentas())
                    return 1;
                else
                    if(o1.getCantidadVentas()<o2.getCantidadVentas())
                        return -1;
                    else
                        return 0;
                
            }
        });
        
        venta[0] = lista.get(0); 
        venta[1] = lista.get(1);
        venta[2] = lista.get(2);
        
        return venta;
    
    
    
    }
    public Ventas[] obtenerVentasMayor(ArrayList<Ventas> lista)
    {
        Ventas venta[] = new Ventas[3];
        
        Collections.sort(lista,new Comparator<Ventas>() {
            @Override
            public int compare(Ventas o1, Ventas o2) {
                   if(o1.getCantidadVentas()<o2.getCantidadVentas())
                    return 1;
                else
                    if(o1.getCantidadVentas()>o2.getCantidadVentas())
                        return -1;
                    else
                        return 0;
        
            }
        });
        venta[0] = lista.get(0); 
        venta[1] = lista.get(1);
        venta[2] = lista.get(2);
        
        return venta;
    }
    
    public Ventas[] obtenerGananciaMenor(ArrayList<Ventas> lista)
    {
        Ventas venta[] = new Ventas[3];
        
        Collections.sort(lista,new Comparator<Ventas>() {
            @Override
            public int compare(Ventas o1, Ventas o2) {
                   if(o1.getGananciaAcumulada()<o2.getGananciaAcumulada())
                    return 1;
                else
                    if(o1.getGananciaAcumulada()>o2.getGananciaAcumulada())
                        return -1;
                    else
                        return 0;
        
            }
        });
        venta[0] = lista.get(0); 
        venta[1] = lista.get(1);
        venta[2] = lista.get(2);
        
        return venta; 
    }
    public Ventas[] obtenerGananciaMayor(ArrayList<Ventas> lista)
    {
        Ventas venta[] = new Ventas[3];
        
        Collections.sort(lista,new Comparator<Ventas>() {
            @Override
            public int compare(Ventas o1, Ventas o2) {
                   if(o1.getGananciaAcumulada()>o2.getGananciaAcumulada())
                    return 1;
                else
                    if(o1.getGananciaAcumulada()<o2.getGananciaAcumulada())
                        return -1;
                    else
                        return 0;
        
            }
        });
        venta[0] = lista.get(0); 
        venta[1] = lista.get(1);
        venta[2] = lista.get(2);
        
        return venta; 
    }
    
    
    public Ventas[] obtenerAnteriorPosteriorGanancias(Ventas venta)
    {
        Ventas ven[]= new Ventas[3];
        try
        {
            Collections.sort(registro.obtenerVentas(),new Comparator<Ventas>() {
            @Override
            public int compare(Ventas o1, Ventas o2) {
                if(o1.getGananciaAcumulada()>o2.getGananciaAcumulada())
                    return 1;
                else
                    if(o1.getGananciaAcumulada()<o2.getGananciaAcumulada())
                        return -1;
                    else
                        return 0;
        
            }
        });
            
            ven[0] = registro.obtenerVentas().get(0); 
            ven[1] = registro.obtenerVentas().get(1);
            ven[2] = registro.obtenerVentas().get(2);
            
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
        
        
        
        
        return ven;
        
    }
    
    public void añadirProducto(Producto pro)    
    {
        productos.add(pro);
    }
    public void quitarProducto(Producto pro)
    {
        productos.remove(pro);
    }
    
    
    
    public int getVentasHoy()
    {
        
        PlantillaDiarioDAO diario = new DiarioDAOImpl();
        
        
        Diario dr = new Diario(0,0);
        
        if(fecha.toString().equals(new java.sql.Date(new java.util.Date().getTime()).toString()))
        {
            try
            {
                    dr = diario.getDiario(fecha);
                        
            }catch(Exception ex)
            { 
                
                  
                ex.printStackTrace();
            }
        }        
            
        return dr.getVentaDiaria();
    }
    public double getGananciasHoy()
    {
        
        Diario dr  = new Diario(0,0);
        PlantillaDiarioDAO diario = new DiarioDAOImpl();
        if(fecha.toString().equals(new java.sql.Date(new java.util.Date().getTime()).toString()))
        {
            try
            {
                dr = diario.getDiario(fecha);
            }catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
        
        
        return dr.getGananciaDiaria();
    }
            
    
    
}
