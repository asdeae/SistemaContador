/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;


import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Luis Huayta
 */
public class Formulario {
    private JTextField campoNombre ;
    private JPasswordField campoClave;
    private JTextField campoPrimerApellido;
    private JTextField campoSegundoApellido;

    public JTextField getCampoPrimerApellido() {
        return campoPrimerApellido;
    }

    public void setCampoPrimerApellido(JTextField campoPrimerApellido) {
        this.campoPrimerApellido = campoPrimerApellido;
    }

    public JTextField getCampoSegundoApellido() {
        return campoSegundoApellido;
    }

    public void setCampoSegundoApellido(JTextField campoSegundoApellido) {
        this.campoSegundoApellido = campoSegundoApellido;
    }
    private JTextField campoNombrecuenta;
    
    public Formulario ()
    {
        
    }
    public Formulario(JTextField campoNombre,JTextField campoPrimerApellido,JTextField campoSegundoApellido,JPasswordField campoClave,JTextField campoNombrecuenta)
    {
        this.campoClave=campoClave;
        this.campoNombre=campoNombre;
        this.campoPrimerApellido=campoPrimerApellido;
        this.campoSegundoApellido=campoSegundoApellido;
        this.campoNombrecuenta=campoNombrecuenta;
    }

    public JTextField getCampoNombre() {
        return campoNombre;
    }

    public void setCampoNombre(JTextField campoNombre) {
        this.campoNombre = campoNombre;
    }

    public JPasswordField getCampoClave() {
        return campoClave;
    }

    public void setCampoClave(JPasswordField campoClave) {
        this.campoClave = campoClave;
    }

    

    public JTextField getCampoNombrecuenta() {
        return campoNombrecuenta;
    }

    public void setCampoNombrecuenta(JTextField campoNombrecuenta) {
        this.campoNombrecuenta = campoNombrecuenta;
    }
    public boolean isEmpty() //Si todos estan llenos retorna false 
    {
        return (this.campoClave.getText().isEmpty() || this.campoNombre.getText().isEmpty() || this.campoNombrecuenta.getText().isEmpty()   || this.campoPrimerApellido.getText().isEmpty()  || this.campoSegundoApellido.getText().isEmpty());
    }
}
