/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

public class Casa {

    private int idCasa;          // Identificador único de la casa
    private boolean ocupada;     // true si la casa ya tiene propietario
    private int idPropietario;   // ID del propietario asignado (0 si no tiene)

    // Constructor vacío
    public Casa() {
    }

    // Constructor con parámetros
    public Casa(int idCasa, boolean ocupada, int idPropietario) {
        this.idCasa = idCasa;
        this.ocupada = ocupada;
        this.idPropietario = idPropietario;
    }

    // Getters y Setters
    public int getIdCasa() {
        return idCasa;
    }

    public void setIdCasa(int idCasa) {
        this.idCasa = idCasa;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }

    public int getIdPropietario() {
        return idPropietario;
    }

    public void setIdPropietario(int idPropietario) {
        this.idPropietario = idPropietario;
    }

    @Override
    public String toString() {
        return "Casa{"
                + "idCasa=" + idCasa
                + ", ocupada=" + ocupada
                + ", idPropietario=" + idPropietario
                + '}';
    }
}
