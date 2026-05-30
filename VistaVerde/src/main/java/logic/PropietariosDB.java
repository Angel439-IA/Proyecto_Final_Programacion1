package logic;

import model.Propietario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PropietariosDB {

    public static boolean guardar(Propietario propietario) {
        // Verificar si la casa ya tiene propietario
        String check = "SELECT COUNT(*) FROM propietario WHERE id_casa = ?";
        try (PreparedStatement psCheck = ConexionDB.getConxion().prepareStatement(check)) {
            psCheck.setInt(1, propietario.getIdCasa());
            ResultSet rs = psCheck.executeQuery();
            if (rs.next() && rs.getInt(1) > 0) {
                javax.swing.JOptionPane.showMessageDialog(null,
                        "Error: La casa " + propietario.getIdCasa() + " ya tiene propietario.");
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Error al verificar: " + e.getMessage());
            return false;
        }

        // Guardar propietario
        String sql = "INSERT INTO propietario (id_casa, nombre, apellido, telefono, correo) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = ConexionDB.getConxion().prepareStatement(sql)) {
            ps.setInt(1, propietario.getIdCasa());
            ps.setString(2, propietario.getNombre());
            ps.setString(3, propietario.getApellido());
            ps.setString(4, propietario.getTelefono());
            ps.setString(5, propietario.getCorreo());

            if (ps.executeUpdate() > 0) {
                // Enviar correo de confirmación
                String asunto = "Registro de Propietario - Casa " + propietario.getIdCasa();
                String cuerpoHtml = "<html>"
                        + "<body style='font-family: Arial, sans-serif; color: #333;'>"
                        + "<h2 style='color: green;'>CONDOMINIO VISTA VERDE</h2>"
                        + "<p>Estimado <b>" + propietario.getNombre() + " " + propietario.getApellido() + "</b>,</p>"
                        + "<p>Su registro como propietario de la Casa <b>" + propietario.getIdCasa() + "</b> "
                        + "se ha realizado correctamente.</p>"
                        + "<p>Bienvenido al <b>Condominio Vista Verde</b>.</p>"
                        + "<br>"
                        + "<img src='cid:logoVistaVerde' alt='Logo Condominio' style='width:200px;height:auto;'/>"
                        + "</body></html>";

                try {
                    EmailSender.enviarCorreo(propietario.getCorreo(), asunto, cuerpoHtml);
                } catch (Exception e) {
                    System.err.println("Error al enviar correo: " + e.getMessage());
                }

                // Actualizar casa como ocupada
                String update = "UPDATE casa SET disponible = 0 WHERE id_casa = ?";
                try (PreparedStatement ps2 = ConexionDB.getConxion().prepareStatement(update)) {
                    ps2.setInt(1, propietario.getIdCasa());
                    ps2.executeUpdate();
                }
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Error al guardar propietario: " + e.getMessage());
            return false;
        }
        return false;
    }

    public static ArrayList<Propietario> cargarTodos() {
        ArrayList<Propietario> lista = new ArrayList<>();
        String sql = "SELECT * FROM propietario";
        try (Statement st = ConexionDB.getConxion().createStatement(); ResultSet rs = st.executeQuery(sql)) {
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
            System.out.println("Error al cargar propietarios: " + e.getMessage());
        }
        return lista;
    }

    public static boolean actualizar(Propietario propietario) {
        String sql = "UPDATE propietario SET nombre = ?, apellido = ?, telefono = ?, correo = ? WHERE id_casa = ?";
        try (PreparedStatement ps = ConexionDB.getConxion().prepareStatement(sql)) {
            ps.setString(1, propietario.getNombre());
            ps.setString(2, propietario.getApellido());
            ps.setString(3, propietario.getTelefono());
            ps.setString(4, propietario.getCorreo());
            ps.setInt(5, propietario.getIdCasa());
            int filas = ps.executeUpdate();
            return filas > 0;
        } catch (SQLException e) {
            System.out.println("Error al actualizar propietario: " + e.getMessage());
            return false;
        }
    }

    public static boolean eliminarPorCasa(int idCasa) {
        String sql = "DELETE FROM propietario WHERE id_casa = ?";
        try (PreparedStatement ps = ConexionDB.getConxion().prepareStatement(sql)) {
            ps.setInt(1, idCasa);
            int filas = ps.executeUpdate();

            if (filas > 0) {
                // Marcar la casa como disponible
                String update = "UPDATE casa SET disponible = 1 WHERE id_casa = ?";
                try (PreparedStatement ps2 = ConexionDB.getConxion().prepareStatement(update)) {
                    ps2.setInt(1, idCasa);
                    ps2.executeUpdate();
                }
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar propietario: " + e.getMessage());
        }
        return false;
    }

    public static String obtenerCorreoPorCasa(int idCasa) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
