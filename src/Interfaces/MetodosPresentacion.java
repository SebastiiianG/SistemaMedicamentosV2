package Interfaces;
import javax.swing.table.DefaultTableModel;
import Modelos.Presentacion;
/**
 * @author ulseg
 */
public interface MetodosPresentacion { //Las interfaces solo son visibles para quien la implementa
    public void registrar(Presentacion presentacion) throws Exception;
    public int recuperarUltimaPresentacion() throws Exception;
    public DefaultTableModel recuperarRegistros(int criterio, String filtro) throws Exception;
    public DefaultTableModel setTitulos() throws Exception;
    public int eliminarPresentacion(int id_presentacion) throws Exception;
    public int modificarPresentacion(Presentacion presentacion) throws Exception;
    public int recuperarId(String nombre)throws Exception;
    public Presentacion buscarPresentacion(String pres_nombre) throws Exception;
}

