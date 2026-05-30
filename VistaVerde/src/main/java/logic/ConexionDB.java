package logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionDB {

    private static final String URL = "jdbc:sqlite:vistaverde.db";
    private static Connection conexion = null;

    public static Connection getConxion() {
        try {
            if (conexion == null || conexion.isClosed()) {
                conexion = DriverManager.getConnection(URL);
            }
        } catch (SQLException e) {
            System.out.println("Error de conexión: " + e.getMessage());
        }
        return conexion;
    }

    public static void iniciarDB() {
        try (Statement stmt = getConxion().createStatement()) {
            stmt.execute("PRAGMA foreign_keys = ON");

            // Tabla casa
            stmt.execute("CREATE TABLE IF NOT EXISTS casa ("
                    + "id_casa INTEGER PRIMARY KEY,"
                    + "ubicacion TEXT NOT NULL,"
                    + "disponible INTEGER NOT NULL DEFAULT 1)");

            for (int i = 1; i <= 30; i++) {
                stmt.execute("INSERT OR IGNORE INTO casa (id_casa, ubicacion, disponible) "
                        + "VALUES (" + i + ", 'Casa " + i + "', 1)");
            }

            // Tabla propietario
            stmt.execute("CREATE TABLE IF NOT EXISTS propietario ("
                    + "id_propietario INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "id_casa INTEGER NOT NULL UNIQUE,"
                    + "nombre TEXT NOT NULL,"
                    + "apellido TEXT NOT NULL,"
                    + "telefono TEXT NOT NULL,"
                    + "correo TEXT NOT NULL,"
                    + "fecha_registro TEXT NOT NULL DEFAULT (DATE('now')),"
                    + "FOREIGN KEY (id_casa) REFERENCES casa(id_casa))");

            // Tabla cuota
            stmt.execute("CREATE TABLE IF NOT EXISTS cuota ("
                    + "id_cuota INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "monto REAL NOT NULL,"
                    + "dia_limite INTEGER NOT NULL DEFAULT 7,"
                    + "fecha_vigencia TEXT NOT NULL DEFAULT (DATE('now')),"
                    + "observacion TEXT)");

            stmt.execute("INSERT OR IGNORE INTO cuota (id_cuota, monto, dia_limite, fecha_vigencia, observacion) "
                    + "VALUES (1, 1500.00, 7, DATE('now'), 'Cuota inicial')");

            // Tabla pago
            stmt.execute("CREATE TABLE IF NOT EXISTS pago ("
                    + "id_pago INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "id_casa INTEGER NOT NULL,"
                    + "id_propietario INTEGER NOT NULL,"
                    + "mes INTEGER NOT NULL,"
                    + "anio INTEGER NOT NULL,"
                    + "monto_pagado REAL NOT NULL,"
                    + "fecha_pago TEXT NOT NULL DEFAULT (DATETIME('now')),"
                    + "id_cuota INTEGER NOT NULL,"
                    + "pago_tardio INTEGER NOT NULL DEFAULT 0,"
                    + "UNIQUE (id_casa, mes, anio),"
                    + "FOREIGN KEY (id_casa) REFERENCES casa(id_casa),"
                    + "FOREIGN KEY (id_propietario) REFERENCES propietario(id_propietario),"
                    + "FOREIGN KEY (id_cuota) REFERENCES cuota(id_cuota))");

            // 🔎 Views
            stmt.execute("CREATE VIEW IF NOT EXISTS v_estado_mes_actual AS "
                    + "SELECT c.id_casa, "
                    + "COALESCE(p.nombre || ' ' || p.apellido, 'Sin propietario') AS propietario, "
                    + "p.telefono, p.correo, "
                    + "CASE WHEN pg.id_pago IS NULL THEN 'Moroso' "
                    + "     WHEN pg.pago_tardio = 1 THEN 'Pagado tardío' "
                    + "     ELSE 'Pagado a tiempo' END AS estado_mes_actual, "
                    + "COALESCE(pg.monto_pagado, 0) AS pagado_mes_actual, "
                    + "COALESCE(pg.fecha_pago, 'Sin pago') AS fecha_pago "
                    + "FROM casa c "
                    + "LEFT JOIN propietario p ON p.id_casa = c.id_casa "
                    + "LEFT JOIN pago pg ON pg.id_casa = c.id_casa "
                    + "AND pg.mes = CAST(strftime('%m','now') AS INTEGER) "
                    + "AND pg.anio = CAST(strftime('%Y','now') AS INTEGER)");

            stmt.execute("CREATE VIEW IF NOT EXISTS v_morosos_mes_actual AS "
                    + "SELECT c.id_casa, "
                    + "COALESCE(p.nombre || ' ' || p.apellido, 'Sin propietario') AS propietario, "
                    + "p.telefono, p.correo "
                    + "FROM casa c "
                    + "LEFT JOIN propietario p ON p.id_casa = c.id_casa "
                    + "LEFT JOIN pago pg ON pg.id_casa = c.id_casa "
                    + "AND pg.mes = CAST(strftime('%m','now') AS INTEGER) "
                    + "AND pg.anio = CAST(strftime('%Y','now') AS INTEGER) "
                    + "WHERE pg.id_pago IS NULL");

            stmt.execute("CREATE VIEW IF NOT EXISTS v_total_pagado_anio AS "
                    + "SELECT c.id_casa, "
                    + "COALESCE(p.nombre || ' ' || p.apellido, 'Sin propietario') AS propietario, "
                    + "SUM(pg.monto_pagado) AS total_pagado_anio "
                    + "FROM casa c "
                    + "LEFT JOIN propietario p ON p.id_casa = c.id_casa "
                    + "LEFT JOIN pago pg ON pg.id_casa = c.id_casa "
                    + "AND pg.anio = CAST(strftime('%Y','now') AS INTEGER) "
                    + "GROUP BY c.id_casa");

            stmt.execute("CREATE VIEW IF NOT EXISTS v_estado_cuenta_casa AS "
                    + "SELECT c.id_casa, "
                    + "COALESCE(p.nombre || ' ' || p.apellido, 'Sin propietario') AS propietario, "
                    + "pg.mes, pg.anio, pg.monto_pagado, pg.fecha_pago, "
                    + "CASE WHEN pg.pago_tardio = 1 THEN 'Pagado tardío' ELSE 'Pagado a tiempo' END AS estado "
                    + "FROM casa c "
                    + "LEFT JOIN propietario p ON p.id_casa = c.id_casa");
            System.out.println("Base de datos inicializada correctamente con tablas y views.");
        } catch (SQLException e) {
            System.out.println("Error al inicializar DB: " + e.getMessage());
        }
    }

    public static void cerrarConexion() {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
                System.out.println("Conexión cerrada");
            }
        } catch (SQLException e) {
            System.out.println("Error al cerrar: " + e.getMessage());
        }
    }
}
