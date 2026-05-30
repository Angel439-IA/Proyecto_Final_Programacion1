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

        // Año actual del sistema
        int anio = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);

        // Busca casas que tienen propietario pero NO tienen pago en ese mes/año
        String sql = "SELECT p.id_propietario, p.id_casa, p.nombre, p.apellido, " +
                     "p.telefono, p.correo, p.fecha_registro " +
                     "FROM propietario p " +
                     "WHERE NOT EXISTS (" +
                     "  SELECT 1 FROM pago pg " +
                     "  WHERE pg.id_casa = p.id_casa " +
                     "  AND pg.mes = ? AND pg.anio = ?" +
                     ") ORDER BY p.id_casa";

        try (PreparedStatement ps = ConexionDB.getConxion().prepareStatement(sql)) {
            ps.setInt(1, mes);
            ps.setInt(2, anio);
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

        // Primero verificar si la casa tiene propietario
        String sqlProp = "SELECT nombre, apellido FROM propietario WHERE id_casa = ?";
        try (PreparedStatement ps = ConexionDB.getConxion().prepareStatement(sqlProp)) {
            ps.setInt(1, idCasa);
            ResultSet rs = ps.executeQuery();
            if (!rs.next()) {
                return "La casa " + idCasa + " no tiene propietario registrado.";
            }
            String propietario = rs.getString("nombre") + " " + rs.getString("apellido");

            // Buscar cuántos meses del año actual pagó
            String sqlPagos = "SELECT mes FROM pago WHERE id_casa = ? AND anio = ? ORDER BY mes";
            try (PreparedStatement ps2 = ConexionDB.getConxion().prepareStatement(sqlPagos)) {
                ps2.setInt(1, idCasa);
                ps2.setInt(2, anio);
                ResultSet rs2 = ps2.executeQuery();

                ArrayList<Integer> mesesPagados = new ArrayList<>();
                while (rs2.next()) {
                    mesesPagados.add(rs2.getInt("mes"));
                }

                int mesActual = java.util.Calendar.getInstance().get(java.util.Calendar.MONTH) + 1;

                // Buscar meses pendientes (del mes 1 hasta el mes actual)
                ArrayList<Integer> mesesPendientes = new ArrayList<>();
                for (int m = 1; m <= mesActual; m++) {
                    if (!mesesPagados.contains(m)) {
                        mesesPendientes.add(m);
                    }
                }

                if (mesesPendientes.isEmpty()) {
                    return "✓ Casa " + idCasa + " — " + propietario + "\nEstá AL DÍA con todos los pagos del año " + anio + ".";
                } else {
                    String[] nombreMeses = {"", "Enero", "Febrero", "Marzo", "Abril",
                                            "Mayo", "Junio", "Julio", "Agosto",
                                            "Septiembre", "Octubre", "Noviembre", "Diciembre"};
                    StringBuilder pendientes = new StringBuilder();
                    for (int m : mesesPendientes) {
                        pendientes.append(nombreMeses[m]).append(", ");
                    }
                    // Quitar última coma
                    String listaPendientes = pendientes.toString().replaceAll(", $", "");

                    return+ idCasa + " — " + propietario +
                           "\nDebe " + mesesPendientes.size() + " mensualidad): " + listaPendientes + ".";
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al verificar estado de casa: " + e.getMessage());
            return "Error al consultar la base de datos.";
        }
    }

 
    public static int contarMorososPorMes(int mes) {
        int anio = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
        String sql = "SELECT COUNT(*) FROM propietario p " +
                     "WHERE NOT EXISTS (" +
                     "  SELECT 1 FROM pago pg " +
                     "  WHERE pg.id_casa = p.id_casa " +
                     "  AND pg.mes = ? AND pg.anio = ?" +
                     ")";
        try (PreparedStatement ps = ConexionDB.getConxion().prepareStatement(sql)) {
            ps.setInt(1, mes);
            ps.setInt(2, anio);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return rs.getInt(1);
        } catch (SQLException e) {
            System.out.println("Error al contar morosos: " + e.getMessage());
        }
        return 0;
    }
}
