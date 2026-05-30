/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import model.Propietario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author deleo
 */
public class MorososDB {

    public static ArrayList<Propietario> getMorososPorMes(int mes) {

        ArrayList<Propietario> lista = new ArrayList<>();

        String sql = "SELECT DISTINCT p.id_propietario, p.id_casa, p.nombre, "
                + "p.apellido, p.telefono, p.correo, p.fecha_registro "
                + "FROM propietario p "
                + "JOIN pago pg ON pg.id_casa = p.id_casa "
                + "WHERE pg.mes = ? "
                + "AND pg.pago_tardio = 1 "
                + "ORDER BY p.id_casa";

        try (
                PreparedStatement ps = ConexionDB.getConxion().prepareStatement(sql)) {

            ps.setInt(1, mes);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Propietario p = new Propietario(
                        rs.getInt("id_propietario"),
                        rs.getInt("id_casa"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("telefono"),
                        rs.getString("correo"),
                        rs.getString("fecha_registro")
                );

                lista.add(p);
            }

        } catch (SQLException e) {
            System.out.println("Error al buscar morosos: " + e.getMessage());
        }

        return lista;
    }

    public static String getEstadoCasa(int idCasa) {
        int anio = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);

        String sqlProp = "SELECT nombre, apellido FROM propietario WHERE id_casa = ?";
        try (PreparedStatement ps = ConexionDB.getConxion().prepareStatement(sqlProp)) {
            ps.setInt(1, idCasa);
            ResultSet rs = ps.executeQuery();
            if (!rs.next()) {
                return "La casa " + idCasa + " no tiene propietario registrado.";
            }
            String propietario = rs.getString("nombre") + " " + rs.getString("apellido");

            // ✅ Solo pagos tardíos
            String sqlPagos = "SELECT mes FROM pago WHERE id_casa = ? AND anio = ? AND pago_tardio = 1 ORDER BY mes";
            try (PreparedStatement ps2 = ConexionDB.getConxion().prepareStatement(sqlPagos)) {
                ps2.setInt(1, idCasa);
                ps2.setInt(2, anio);
                ResultSet rs2 = ps2.executeQuery();

                ArrayList<Integer> mesesTardios = new ArrayList<>();
                while (rs2.next()) {
                    mesesTardios.add(rs2.getInt("mes"));
                }

                if (mesesTardios.isEmpty()) {
                    return "✓ Casa " + idCasa + " — " + propietario + "\nNo tiene pagos atrasados registrados en " + anio + ".";
                } else {
                    String[] nombreMeses = {"", "Enero", "Febrero", "Marzo", "Abril",
                        "Mayo", "Junio", "Julio", "Agosto",
                        "Septiembre", "Octubre", "Noviembre", "Diciembre"};
                    StringBuilder pendientes = new StringBuilder();
                    for (int m : mesesTardios) {
                        pendientes.append(nombreMeses[m]).append(", ");
                    }
                    String listaPendientes = pendientes.toString().replaceAll(", $", "");

                    return "⚠ Casa " + idCasa + " — " + propietario
                            + "\nTiene pagos atrasados (" + mesesTardios.size() + "): " + listaPendientes + ".";
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al verificar estado de casa: " + e.getMessage());
            return "Error al consultar la base de datos.";
        }
    }

    public static int contarMorososPorMes(int mes) {

        String sql = "SELECT COUNT(DISTINCT id_casa) "
                + "FROM pago "
                + "WHERE mes = ? "
                + "AND pago_tardio = 1";

        try (
                PreparedStatement ps = ConexionDB.getConxion().prepareStatement(sql)) {

            ps.setInt(1, mes);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt(1);
            }

        } catch (SQLException e) {
            System.out.println("Error al contar morosos: " + e.getMessage());
        }

        return 0;
    }

    public static ArrayList<Integer> getMesesTardiosPorCasa(int idCasa) {

        ArrayList<Integer> meses = new ArrayList<>();

        String sql = "SELECT mes "
                + "FROM pago "
                + "WHERE id_casa = ? "
                + "AND pago_tardio = 1 "
                + "ORDER BY mes";

        try (
                PreparedStatement ps = ConexionDB.getConxion().prepareStatement(sql)) {

            ps.setInt(1, idCasa);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                meses.add(rs.getInt("mes"));
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener meses tardíos: " + e.getMessage());
        }

        return meses;

    }

}
