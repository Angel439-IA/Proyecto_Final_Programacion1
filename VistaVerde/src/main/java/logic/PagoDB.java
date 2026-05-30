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
        try (Connection conn = ConexionDB.getConxion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

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
            check.setInt(1, pago.getIdCasa());
            check.setInt(2, pago.getMes());
            check.setInt(3, pago.getAnio());
            try (ResultSet rs = check.executeQuery()) {
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
  public static boolean GuardarPago(Pago pago) {

        String checkSql = "SELECT COUNT(*) FROM pago WHERE id_casa=? AND mes=? AND anio=?";
        try (Connection conn = ConexionDB.getConxion();
             PreparedStatement check = conn.prepareStatement(checkSql)) {
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
                if (rs.next() && rs.getInt(1) > 0) return false; // duplicate
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
            if (rs.next()) {
                monto = rs.getDouble("monto");
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener la cuota vigente: " + e.getMessage());
        }
        
         String sql = "INSERT INTO pago (id_casa, id_propietario, mes, anio, " +
                     "monto_pagado, fecha_pago, id_cuota, pago_tardio) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConexionDB.getConxion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1,    pago.getIdCasa());
            ps.setInt(2,    pago.getIdPropietario());
            ps.setInt(3,    pago.getMes());
            ps.setInt(4,    pago.getAnio());
            ps.setDouble(5, pago.getMontoPagado());
            ps.setString(6, pago.getFechaPago());
            ps.setInt(7,    pago.getIdCuota());
            ps.setInt(8,    pago.getPagoTardio());
}
    
    
  
}
    

