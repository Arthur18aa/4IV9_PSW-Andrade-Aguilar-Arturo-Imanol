package Control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    public static Connection getConexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url, userName, password;
            url = "jdbc:mysql://localhost/extra";
            userName = "root";
            password = "Patopato612:";

            return DriverManager.getConnection(url, userName, password);
        } catch (SQLException | ClassNotFoundException sq) {
            System.out.println("Error de conexión a la base de datos: " + sq);
        }
        return null;
    }
}

