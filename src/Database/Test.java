
package Database;

import Database.Conecta;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ulseg
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Conecta conecta = new Conecta();
        conecta.conectar();

        if (conecta.verificarConexion()) {
            System.out.println("Conexion exitosa a la base de datos.");
        } else {
            System.out.println("Error al conectar a la base de datos.");
        }

        try {
            conecta.cerrar();
        } catch (SQLException e) {
            Logger.getLogger(Conecta.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
