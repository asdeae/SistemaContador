/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;



/**
 *
 * @author Luis Huayta
 */
public class Diario {
    
    
    private int idDiario ;
    private int ventaDiaria;
    private double  gananciaDiaria;
    private java.sql.Date fechaDia;

    public java.sql.Date getFechaDia() {
        return fechaDia;
    }

    public void setFechaDia(java.sql.Date fechaDia) {
        this.fechaDia = fechaDia;
    }
    
    public int getIdDiario() {
        return idDiario;
    }

    public Diario(int idDiario, int ventaDiaria, double gananciaDiaria,java.sql.Date fechaDia) {
        this.idDiario = idDiario;
        this.ventaDiaria = ventaDiaria;
        this.gananciaDiaria = gananciaDiaria;
        this.fechaDia=fechaDia;
    }
    
    
    public Diario()
    {
        
    }
    public Diario(int ventaDiaria,double gananciaDiaria)
    {
        this.ventaDiaria=ventaDiaria;
        this.gananciaDiaria=gananciaDiaria;
    }
    

    public void setIdDiario(int idDiario) {
        this.idDiario = idDiario;
    }

    public int getVentaDiaria() {
        return ventaDiaria;
    }

    public void setVentaDiaria(int ventaDiaria) {
        this.ventaDiaria = ventaDiaria;
    }

    public double getGananciaDiaria() {
        return gananciaDiaria;
    }

    public void setGananciaDiaria(double gananciaDiaria) {
        this.gananciaDiaria = gananciaDiaria;
    }
    
    
    
}
