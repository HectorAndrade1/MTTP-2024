package com.example.mttp2024.database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    String URL = "jdbc:sqlite:src/main/java/com/example/mttp2024/database/organizador.db";
    // Ruta del archivo de la base de datos SQLite
    //private final String URL = "jdbc:sqlite:organizador.db";
    private Connection connection;
    public Database(){
        try {
            // Establecer la conexión al crear una instancia de la clase
            connection = DriverManager.getConnection(URL);
        } catch (SQLException e) {
            // Manejar cualquier excepción que ocurra al establecer la conexión
            System.err.println("Error al establecer la conexión con la base de datos: " + e.getMessage());
        }

    }

    // Método para establecer la conexión con la base de datos
    public  Connection connection()  {
        return connection;
    }

    // Método para cerrar la conexión
    public void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
                System.out.println("Conexión cerrada correctamente.");
            }
        } catch (SQLException e) {
            System.err.println("Error al cerrar la conexión con la base de datos: " + e.getMessage());
        }
    }


}
