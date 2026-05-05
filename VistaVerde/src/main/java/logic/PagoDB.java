/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import model.Pago;
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
public class PagoDB {

    //Guardar los pagos en la DB
    public static boolean GuardarPago(int numeroCasa, Pago pago) {
        String sql
                = "INSERT INTO pagos "
                + "(numero_casa, mes, anio, monto) "
                + "VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps
                = ConexionDB.getConxion().prepareStatement(sql)) {
            ps.setInt(1, numeroCasa);
            ps.setInt(2, pago.getMes());
            ps.setInt(3, pago.getAnio());
            ps.setDouble(4, pago.getMonto());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error guardar pago: " + e.getMessage());
            return false;
        }
    }

    //Obtener los pagos de casas espesificas
    public static ArrayList<Pago> cargarPorCasa(int numeroCasa) {
        ArrayList<Pago> listaPagos = new ArrayList<>();
        String sql = "SELECT * FROM pagos WHERE numero_casa=?";
        try (PreparedStatement ps
                = ConexionDB.getConxion().prepareStatement(sql)) {
            ps.setInt(1, numeroCasa);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listaPagos.add(new Pago(
                        rs.getInt("mes"),
                        rs.getInt("anio"),
                        rs.getDouble("monto")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Error cargar pagos: " + e.getMessage());
        }
        return listaPagos;
    }
}
