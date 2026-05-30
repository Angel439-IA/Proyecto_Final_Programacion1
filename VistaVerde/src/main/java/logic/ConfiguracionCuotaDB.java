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

/*
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

    // Obtener el monto vigente de la BD
    public static double obtenerMontoVigente() {
        String sql = "SELECT cuota_actual FROM configuracion WHERE id=1";
        try (Statement st = ConexionDB.getConxion().createStatement(); ResultSet rs = st.executeQuery(sql)) {
            if (rs.next()) {
                return rs.getDouble("cuota_actual");
            }
        } catch (SQLException e) {
            System.out.println("Error obtener monto: " + e.getMessage());
        }
        return 0.0;
    }

    // Actualizar solo el monto — SIN dia_limite NI descripcion
    public static boolean nuevaCuota(double monto) {
        String sql = "UPDATE configuracion SET cuota_actual=? WHERE id=1";
        try (PreparedStatement ps = ConexionDB.getConxion().prepareStatement(sql)) {
            ps.setDouble(1, monto);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error nueva cuota: " + e.getMessage());
            return false;
        }
    }
}
*/