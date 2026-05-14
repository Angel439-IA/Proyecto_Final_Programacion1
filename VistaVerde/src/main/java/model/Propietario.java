/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Angel Sotoy
 */
public class Propietario {

    private String nombreCompleto;
    private int numeroCasa;
    private String telefono;
    private String correoElectronico;

    public Propietario(String nombreCompleto, int numeroCasa, String telefono, String correoElectronico) {
        this.nombreCompleto = nombreCompleto;
        this.numeroCasa = numeroCasa;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
    }


    //Getters
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public int getNumeroCasa() {
        return numeroCasa;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    //Setters
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }
}
