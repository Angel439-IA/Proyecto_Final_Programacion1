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

    //Cargar couta actual desde la DB
    public static ArrayList<Pago> cargarPorCasa(int numeroCasa) {
        ArrayList<Pago> lista = new ArrayList<>();
        String sql = "SELECT * FROM pagos WHERE numero_casa=?";
        try (PreparedStatement ps
                = ConexionDB.getConxion().prepareStatement(sql)) {
            ps.setInt(1, numeroCasa);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(new Pago(
                        rs.getInt("mes"),
                        rs.getInt("anio"),
                        rs.getDouble("monto")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Error cargar pagos: " + e.getMessage());
        }
        return lista;
    }

    //Actualizar la couta de DB
    public static boolean actualizarCuota(double nuevaCuota) {
        String sql
                = "UPDATE configuracion SET cuota_actual=? WHERE id=1";
        try (PreparedStatement ps
                = ConexionDB.getConxion().prepareStatement(sql)) {
            ps.setDouble(1, nuevaCuota);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error actualizar cuota: "
                    + e.getMessage());
            return false;
        }
    }
}
