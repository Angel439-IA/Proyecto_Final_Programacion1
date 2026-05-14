/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Angel Sotoy
 */
public class ConexionDB {

    private static final String URL = "jdbc:sqlite:vistaverde.db";
    private static Connection conexion = null;

    public static Connection getConxion() {
        try {
            if (conexion == null || conexion.isClosed()) {
                conexion = DriverManager.getConnection(URL);
            }
        } catch (SQLException e) {
            System.out.println("Error de conexion: " + e.getMessage());
        }
        return conexion;
    }

    //Creacion de tablas
    public static void iniciarDB() {

        try (Statement stmt = getConxion().createStatement()) {

            // Tabla casas
            stmt.execute(
                    "CREATE TABLE IF NOT EXISTS casas ("
                    + "numero INTEGER PRIMARY KEY,"
                    + "tiene_propietario INTEGER DEFAULT 0)"
            );

            // Tabla propietarios
            stmt.execute(
                    "CREATE TABLE IF NOT EXISTS propietarios ("
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "numero_casa INTEGER UNIQUE,"
                    + "nombre TEXT NOT NULL,"
                    + "telefono TEXT NOT NULL,"
                    + "correo TEXT NOT NULL,"
                    + "FOREIGN KEY (numero_casa) REFERENCES casas(numero))"
            );

            // Tabla pagos
            stmt.execute(
                    "CREATE TABLE IF NOT EXISTS pagos ("
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "numero_casa INTEGER,"
                    + "mes INTEGER NOT NULL,"
                    + "anio INTEGER NOT NULL,"
                    + "monto REAL NOT NULL,"
                    + "FOREIGN KEY (numero_casa) REFERENCES casas(numero))"
            );

            // Tabla configuracion
            stmt.execute(
                    "CREATE TABLE IF NOT EXISTS configuracion ("
                    + "id INTEGER PRIMARY KEY,"
                    + "cuota_actual REAL NOT NULL)"
            );

            // Insertar las 30 casas
            for (int i = 1; i <= 30; i++) {
                stmt.execute(
                        "INSERT OR IGNORE INTO casas (numero) VALUES (" + i + ")"
                );
            }

            // Insertar cuota inicial
            stmt.execute(
                    "INSERT OR IGNORE INTO configuracion "
                    + "(id, cuota_actual) VALUES (1, 1500.00)"
            );

            System.out.println("Base de datos inicializada correctamente");

        } catch (SQLException e) {
            System.out.println("Error al inicializar DB: " + e.getMessage());
        }
    }

    public static void cerrarConexion() {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
                System.out.println("Conexion cerrada");
            }
        } catch (SQLException e) {
            System.out.println("Error al cerrar: " + e.getMessage());
        }
    }

}
