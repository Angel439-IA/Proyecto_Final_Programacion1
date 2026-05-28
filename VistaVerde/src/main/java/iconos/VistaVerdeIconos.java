package iconos;

import javax.swing.ImageIcon;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Sistemas
 */
public class VistaVerdeIconos {

    // Método para obtener el logo
    public static ImageIcon getLogo() {

        return new ImageIcon(
                VistaVerdeIconos.class.getResource("/Iconos/VistaVerde.jpeg")
        );
    }

    public static javax.swing.ImageIcon getUsuario() {
        return new javax.swing.ImageIcon(VistaVerdeIconos.class.getResource("/Iconos/Usuario.png"));
    }

    public static javax.swing.ImageIcon getContrasena() {
        return new javax.swing.ImageIcon(VistaVerdeIconos.class.getResource("/Iconos/Contrasena.png"));
    }

    public static javax.swing.ImageIcon getRegistropropietario() {
        return new javax.swing.ImageIcon(VistaVerdeIconos.class.getResource("/Iconos/AgregarUsuario.png"));
    }

    public static javax.swing.ImageIcon getRegistroPago() {
        return new javax.swing.ImageIcon(VistaVerdeIconos.class.getResource("/Iconos/RegistroPago.png"));
    }

    public static javax.swing.ImageIcon getConfiguracionCuota() {
        return new javax.swing.ImageIcon(VistaVerdeIconos.class.getResource("/Iconos/ConfiguracionPago.png"));
    }

    public static javax.swing.ImageIcon getEstadoCuenta() {
        return new javax.swing.ImageIcon(VistaVerdeIconos.class.getResource("/Iconos/EstadoCuenta.png"));
    }

    public static javax.swing.ImageIcon getReporteGeneral() {
        return new javax.swing.ImageIcon(VistaVerdeIconos.class.getResource("/Iconos/ReporteGeneral.png"));
    }

    public static javax.swing.ImageIcon getCasasMorosas() {
        return new javax.swing.ImageIcon(VistaVerdeIconos.class.getResource("/Iconos/CasasMorosas.png"));
    }

    public static javax.swing.ImageIcon getCerrarSesion() {
        return new javax.swing.ImageIcon(VistaVerdeIconos.class.getResource("/Iconos/CerrarSesion.png"));
    }

    public static javax.swing.ImageIcon getNombre() {
        return new javax.swing.ImageIcon(VistaVerdeIconos.class.getResource("/Iconos/Nombre.png"));
    }

    public static javax.swing.ImageIcon getNumeroCasa() {
        return new javax.swing.ImageIcon(VistaVerdeIconos.class.getResource("/Iconos/NumeroCasa.png"));
    }

    public static javax.swing.ImageIcon getNumeroTelefono() {
        return new javax.swing.ImageIcon(VistaVerdeIconos.class.getResource("/Iconos/NumeroTelefono.png"));
    }

    public static javax.swing.ImageIcon getCorreo() {
        return new javax.swing.ImageIcon(VistaVerdeIconos.class.getResource("/Iconos/Correo.png"));
    }

    public static javax.swing.ImageIcon getEliminar() {
        return new javax.swing.ImageIcon(VistaVerdeIconos.class.getResource("/Iconos/Eliminar.png"));
    }

    public static javax.swing.ImageIcon geteditar() {
        return new javax.swing.ImageIcon(VistaVerdeIconos.class.getResource("/Iconos/Editar.png"));
    }

    public static javax.swing.ImageIcon getGuardar() {
        return new javax.swing.ImageIcon(VistaVerdeIconos.class.getResource("/Iconos/Guardar.png"));
    }

    public static javax.swing.ImageIcon getIngresar() {
        return new javax.swing.ImageIcon(VistaVerdeIconos.class.getResource("/Iconos/Ingresar.png"));
    }

    public static javax.swing.ImageIcon getExito() {
        return new javax.swing.ImageIcon(VistaVerdeIconos.class.getResource("/Iconos/CheckExitoso.png"));
    }
}
