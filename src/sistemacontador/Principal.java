/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemacontador;
import Controlador.CvistaPrincipal;


import Vista.VistaPrincipal;



/**
 *
 * @author Luis Huayta
 */
public class Principal {

    /**
     * @param args the command line arguments
     */         
    public static void main(String[] args) {
        
        VistaPrincipal obj = new VistaPrincipal();
        CvistaPrincipal cv = new CvistaPrincipal(obj);
        obj.setVisible(true);
        
//        
//        Double f1  = 15.2;
//       
//        if(f1.isNaN())
//            System.out.println("No es un numero");
//        else
//            System.out.println("Es un numero");
//              
       /* ArrayList<Ventas> venta  =  new ArrayList();
        venta.add(new Ventas(1, 10, 12.50, "SAPOLIO"));
        venta.add(new Ventas(2, 12, 11.50, "RICOCAN"));
        venta.add(new Ventas(3, 5, 10.50, "INCA KOLA"));
        venta.add(new Ventas(4, 14, 18.50, "COCA COLA"));
        venta.add(new Ventas(5, 7, 17.50, "FANTA"));
        venta.add(new Ventas(6, 20, 20.50, "SEVEN UP"));
        Ventas ven = new Ventas(7,8,23.50,"CHIN CHIN");
        venta.add(ven);
        */
        /*
        Collections.sort(venta,new Comparator<Ventas>() {
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
        
        */
        
      
       
      /*
        venta.remove(ven);
          for(Ventas o : venta)
            System.out.println(o.getCantidadVentas());
          
        */  
     /*  StringBuilder cadena = new StringBuilder();
       
       cadena.append("Marca                        Cantidad");
       cadena.append("\nSapolio                     1");
       cadena.append("\nSapolio                     2");
        System.out.println(cadena.toString());
    
    
       StringBuilder str = new StringBuilder();
       str.append("HOLA");
        System.out.println(str.toString());
        str.delete(0, str.toString().length());
        System.out.println(str.toString());
    */           
    }
 
    
}
