package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conecta {
    protected Connection conexion;
    private final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String DB_URL = "jdbc:mysql://localhost/medicamentos?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private final String USER = "root";
    private final String PASSWORD = "";

    public void conectar() {
        try {
            Class.forName(JDBC_DRIVER);
            conexion = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            System.out.println("Conexion establecida en el metodo conectar."); // Mensaje de depuración
        } catch (ClassNotFoundException e) {
            Logger.getLogger(Conecta.class.getName()).log(Level.SEVERE, "Driver no encontrado", e);
        } catch (SQLException e) {
            Logger.getLogger(Conecta.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void cerrar() throws SQLException {
        if (conexion != null) {
            if (!conexion.isClosed()) {
                conexion.close();
                System.out.println("Conexion cerrada."); // Mensaje de depuración
            }
        }
    }

    public boolean verificarConexion() {
        try {
            boolean isConnected = conexion != null && !conexion.isClosed();
            System.out.println("verificarConexion() retorna: " + isConnected); // Mensaje de depuración
            return isConnected;
        } catch (SQLException e) {
            Logger.getLogger(Conecta.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }
}
