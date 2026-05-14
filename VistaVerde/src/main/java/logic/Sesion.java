/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import model.Condominio;

/**
 *
 * @author Angel Sotoy
 */
public class Sesion {

    private static Sesion instancia;
    private Condominio condominio;
    private boolean autentificacion;

    //Usuario y contraseña del administrador
    private static final String USUARIO = "iusr_vistaverde";
    private static final String Contrasena = "R3sidencial2026%";

    public Sesion() {
        this.condominio = new Condominio();
        this.autentificacion = false;
    }
    
    public static Sesion getInstancia(){
        if (instancia == null) {
            instancia = new Sesion();
        }
        return instancia;
    }
    
    public boolean autentificacion(String usuario, String Contrasena){
        if (USUARIO.equals(usuario) && Contrasena.equals(Contrasena)) {
            autentificacion = true;
            return autentificacion;
        }
        return false;
    }
    
    public void cerrarSecio(){
        autentificacion =  false;
    }
    
    public Condominio getCondominio(){return condominio;}
    public boolean isautentificacion (){return autentificacion;}
}
