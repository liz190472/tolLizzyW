/*
 * Clase para establecer la conexión a la base de datos MySQL.
 */
package com.toallaslizzy.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static final String URL = "jdbc:mysql://localhost:3306/toallas_lizzy";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    
    /**
     * Establece una conexión con la base de datos y la retorna.
     * @return un objeto Connection si la conexión es exitosa, null en caso de error.
     */
    public static Connection getConnection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("✅ Conexión establecida correctamente");
        } catch (SQLException e) {
            System.out.println("❌ Error al conectar: " + e.getMessage());
        }
        return con;
    }
}
