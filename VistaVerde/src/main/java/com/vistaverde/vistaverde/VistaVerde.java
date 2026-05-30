/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.vistaverde.vistaverde;

import logic.PropietariosDB;
import model.Propietario;

/**
 *
 * @author Angel Sotoy
 */
public class VistaVerde {

    public static void main(String[] args) {

        logic.ConexionDB.iniciarDB();

        java.awt.EventQueue.invokeLater(() -> {
            new ui.Login().setVisible(true);
        });
    }
}
