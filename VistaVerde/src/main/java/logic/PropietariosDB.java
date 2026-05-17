/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import model.Propietario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Angel Sotoy
 */
public class PropietariosDB {

    //Guardar propietarios
    public static boolean Guardar(Propietario propietario) {
        
        String check = "SELECT COUNT(*) FROM propietarios WHERE numero_casa";
        try(PreparedStatement PsCheck = ConexionDB.getConxion().prepareStatement(check)){
            PsCheck.setInt(1, propietario.getNumeroCasa());
            ResultSet RS = PsCheck.executeQuery();
            if (RS.next() && RS.getInt(1) > 0) {
                javax.swing.JOptionPane.showMessageDialog(null,
                        "Error: La casa" + propietario.getNumeroCasa() + "ya tiene un propietario registrado.");
                return false;
            }
        }catch (SQLException e){
            System.out.println("Erro al verificar: " + e.getMessage());
            return false;
        }
        
        String sql =
        """
            INSERT INTO propietarios 
            (numero_casa, nombre, telefono, correo) 
            VALUES (?, ?, ?, ?)
        """;
        try (PreparedStatement PS
                = ConexionDB.getConxion().prepareStatement(sql)) {
            PS.setInt(1, propietario.getNumeroCasa());
            PS.setString(2, propietario.getNombreCompleto());
            PS.setString(3, propietario.getTelefono());
            PS.setString(4, propietario.getCorreoElectronico());
                     
            PS.executeUpdate();

            String update = "Update casas set tiene_propietario = 1 where numero = ?";
            try (PreparedStatement PS2
                    = ConexionDB.getConxion().prepareStatement(update)) {
                PS2.setInt(1, propietario.getNumeroCasa());
                PS2.executeUpdate();
            }
            return true;
        } catch (SQLException e) {
            System.out.println("Error al guardar propietario: " + e.getMessage());
            return false;
        }
    }

    public static ArrayList<Propietario> cargarTodos() {
        ArrayList<Propietario> listaPropietario = new ArrayList<>();
        String sql = "Select * from propietarios";
        try (Statement statement = ConexionDB.getConxion().createStatement(); ResultSet Rs = statement.executeQuery(sql)) {
            while (Rs.next()) {
                listaPropietario.add(new Propietario(
                        Rs.getString("nombre"),
                        Rs.getInt("numero_casa"),
                        Rs.getString("Telefono"),
                        Rs.getString("Correo")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Error al cargar propietarios: " + e.getMessage());
        }
        return listaPropietario;
    }
}
