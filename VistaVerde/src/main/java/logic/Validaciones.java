/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

/**
 *
 * @author Angel Sotoy
 */
public class Validaciones {
    
    
    //Validaciones de Registro Propietatario
    public static boolean validarNombre(String nombre){
        return nombre.matches("^[a-zA-ZÁÉÍÓÚáéíóúÑñ ]+$");
    }
    
    public static boolean validarTelefono(String telefono){
        return telefono.matches("^[0-9]{7,15}$");
    }
    
    public static boolean validarCorreo(String correo){
        return correo.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    }
}
