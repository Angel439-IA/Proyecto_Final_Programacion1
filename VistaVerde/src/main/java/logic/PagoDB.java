/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import model.Pago;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author d4nil
 */
public class PagoDB {

    public static ArrayList<Pago> cargarPorCasa(int numeroCasa) {
        ArrayList<Pago> lista = new ArrayList<>();
        String sql = "SELECT * FROM pago WHERE id_casa = ? ORDER BY anio DESC, mes DESC";
        try (Connection conn = ConexionDB.getConxion(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, numeroCasa);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    lista.add(new Pago(
                            rs.getInt("id_casa"),
                            rs.getInt("id_propietario"),
                            rs.getInt("mes"),
                            rs.getInt("anio"),
                            rs.getDouble("monto_pagado"),
                            rs.getString("fecha_pago"),
                            rs.getInt("id_cuota"),
                            rs.getInt("pago_tardio")
                    ));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public static boolean GuardarPago(Pago pago) {

        String checkSql = "SELECT COUNT(*) FROM pago WHERE id_casa=? AND mes=? AND anio=?";
        try (Connection conn = ConexionDB.getConxion(); PreparedStatement check = conn.prepareStatement(checkSql)) {
            check.setInt(1, pago.getIdCasa());
            check.setInt(2, pago.getMes());
            check.setInt(3, pago.getAnio());
            try (ResultSet rs = check.executeQuery()) {
                if (rs.next() && rs.getInt(1) > 0) {
                    return false; // duplicate
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        String sql = "INSERT INTO pago (id_casa, id_propietario, mes, anio, "
                + "monto_pagado, fecha_pago, id_cuota, pago_tardio) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConexionDB.getConxion(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, pago.getIdCasa());
            ps.setInt(2, pago.getIdPropietario());
            ps.setInt(3, pago.getMes());
            ps.setInt(4, pago.getAnio());
            ps.setDouble(5, pago.getMontoPagado());
            ps.setString(6, pago.getFechaPago());
            ps.setInt(7, pago.getIdCuota());
            ps.setInt(8, pago.getPagoTardio());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static int obtenerPropietarioPorCasa(int idCasa) {
        String sql = "SELECT id_propietario FROM propietario WHERE id_casa = ? LIMIT 1";
        try (Connection conn = ConexionDB.getConxion(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idCasa);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("id_propietario");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static double getMontoMantenimientoVigente() {
        double monto = 0.0;
        // Consultamos la tabla 'cuota' obteniendo el último registro ingresado
        String sql = "SELECT monto FROM cuota ORDER BY id_cuota DESC LIMIT 1";

        try (Connection conn = ConexionDB.getConxion(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                monto = rs.getDouble("monto");
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener la cuota vigente: " + e.getMessage());
        }

        return monto;
    }

    public static String obtenerNombrePropietarioPorCasa(int idCasa) {
        String sql = "SELECT nombre || ' ' || apellido AS propietario FROM propietario WHERE id_casa = ? LIMIT 1";
        try (Connection conn = ConexionDB.getConxion(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idCasa);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("propietario"); // devuelve nombre completo
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener nombre de propietario: " + e.getMessage());
        }
        return "Sin propietario registrado"; // si no existe propietario
    }

    public static String obtenerCorreoPorCasa(int idCasa) {
        String sql = "SELECT correo FROM propietario WHERE id_casa = ? LIMIT 1";
        try (Connection conn = ConexionDB.getConxion(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idCasa);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("correo");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "correo_no_disponible@ejemplo.com";
    }

    public static ArrayList<String[]> obtenerPagosPorCasa(int idCasa) {

        ArrayList<String[]> lista = new ArrayList<>();

        String sql = "SELECT mes, anio, monto_pagado, fecha_pago, pago_tardio "
                + "FROM pago WHERE id_casa = ? "
                + "ORDER BY anio DESC, mes DESC";

        try (
                Connection conn = ConexionDB.getConxion(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idCasa);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                String[] pago = new String[5];

                pago[0] = String.valueOf(rs.getInt("mes"));
                pago[1] = String.valueOf(rs.getInt("anio"));
                pago[2] = String.valueOf(rs.getDouble("monto_pagado"));
                pago[3] = rs.getString("fecha_pago");
                pago[4] = String.valueOf(rs.getInt("pago_tardio"));

                lista.add(pago);
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener pagos por casa: " + e.getMessage());
        }

        return lista;
    }

}
