/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

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
public class ConfiguracionCuotaDB {

    // Actualizar la cuota en la DB
    public static boolean actualizarCuota(double nuevaCuota) {
        String sql = "UPDATE configuracion SET cuota_actual=? WHERE id=1";
        try (PreparedStatement ps = ConexionDB.getConxion().prepareStatement(sql)) {
            ps.setDouble(1, nuevaCuota);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error actualizar cuota: " + e.getMessage());
            return false;
        }
    }
}
