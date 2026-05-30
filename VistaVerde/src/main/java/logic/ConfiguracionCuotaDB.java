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

    public static double obtenerMontoVigente() {
        String sql = "SELECT monto FROM cuota ORDER BY id_cuota DESC LIMIT 1";
        try (Connection conn = ConexionDB.getConxion(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return rs.getDouble("monto");
            }
        } catch (SQLException e) {
            System.out.println("Error obtener monto: " + e.getMessage());
            e.printStackTrace();
        }
        return 0.0;
    }

    public static boolean nuevaCuota(double monto) {
        // Primero obtenemos los valores actuales para no dejar nulos
        int diaLimite = obtenerDiaLimiteVigente();
        String fechaVigencia = obtenerFechaVigente();

        // INSERT simple sin funciones de fecha problemáticas
        String sql = "INSERT INTO cuota (monto, dia_limite, fecha_vigencia, observacion) "
                + "VALUES (?, ?, ?, ?)";
        try (Connection conn = ConexionDB.getConxion(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setDouble(1, monto);
            ps.setInt(2, diaLimite);
            ps.setString(3, fechaVigencia); // String "yyyy-MM-dd"
            ps.setString(4, "Cuota actualizada");
            int filas = ps.executeUpdate();
            System.out.println("Filas insertadas: " + filas); // para debug
            return filas > 0;
        } catch (SQLException e) {
            // Este mensaje aparecerá en la consola de NetBeans
            System.out.println("Error al insertar cuota: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("ErrorCode: " + e.getErrorCode());
            e.printStackTrace();
            return false;
        }
    }

    public static boolean actualizarCuota(double nuevaCuota) {
        return nuevaCuota(nuevaCuota);
    }

    private static int obtenerDiaLimiteVigente() {
        String sql = "SELECT dia_limite FROM cuota ORDER BY id_cuota DESC LIMIT 1";
        try (Connection conn = ConexionDB.getConxion(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return rs.getInt("dia_limite");
            }
        } catch (SQLException e) {
            System.out.println("Error dia_limite: " + e.getMessage());
        }
        return 7;
    }

    private static String obtenerFechaVigente() {
        // Devuelve la fecha de hoy en formato SQLite "yyyy-MM-dd"
        return java.time.LocalDate.now().toString();
    }
}
