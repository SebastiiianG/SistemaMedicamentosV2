
package Interfaces;
import Modelos.Composicion;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ulseg
 */
public interface MetodosComposicion {
    public int registrarComposicion(Composicion composicion) throws Exception;
    public int recuperarUltimaComposicion() throws Exception;
    
    public ArrayList recuperarNomPrincipio() throws Exception;
    public int recuperarIdPrin(String prin) throws Exception;
    public String buscarNombrePrin(int id_prin) throws Exception;
    
    public ArrayList recuperarNomMedicamento() throws Exception;
    public int recuperarIdMed(String mdm) throws Exception;
    public String buscarNombreMed(int id_med) throws Exception;
    
    public int eliminarComposicion(int id_composicion) throws Exception;
    public int modificarComposicion(Composicion composicion) throws Exception;
    public int recuperarIdComposicion(String med, String prin)throws Exception;
    
    public JComboBox obtenerPrincipio() throws Exception;
    public JComboBox obtenerMedicamento() throws Exception;
    
    public void rellenarTabla(DefaultTableModel table, Composicion composicion) throws Exception;
    public void buscar(DefaultTableModel tabla, Composicion composicion, int filtro, String busqueda) throws Exception;

}
