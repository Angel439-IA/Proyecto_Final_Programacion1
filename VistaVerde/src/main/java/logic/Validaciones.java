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
    
        public static boolean validarTelefono(String telefono) {
 
        if (!telefono.matches("^\\d{4}-\\d{4}$")) {
            return false;
        }

        // Quitar el guion y verificar que no sean todos iguales
        String soloNumeros = telefono.replace("-", "");
        char primero = soloNumeros.charAt(0);
        for (char c : soloNumeros.toCharArray()) {
            if (c != primero) return true; 
        }
        return false; 
    }
    
    public static boolean validarCorreo(String correo){
        return correo.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    }
}
