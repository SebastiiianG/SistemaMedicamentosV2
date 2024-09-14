
package Interfaces;
import javax.swing.table.DefaultTableModel;
import Modelos.PrincipioActivo;
/**
 *
 * @author ulseg
 */
public interface MetodosPrincipio {
    public int registrarPrincipio(PrincipioActivo principio) throws Exception;
    public int recuperarUltimoPrincipio() throws Exception;
    public DefaultTableModel recuperarRegistrosPrincipio(int criterio, String filtro) throws Exception;
    public DefaultTableModel setTitulosPrincipio() throws Exception;
    public int eliminarPrincipio(int id_principio) throws Exception;
    public int modificarPrincipio(PrincipioActivo principio) throws Exception;
    public int recuperarIdPrincipio(String prin)throws Exception;
    public PrincipioActivo buscarPrincipio(String prin_nombre) throws Exception;
}

