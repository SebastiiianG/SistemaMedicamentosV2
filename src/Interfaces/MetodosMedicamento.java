
package Interfaces;
import javax.swing.table.DefaultTableModel;
import Modelos.Medicamento;
/**
 *
 * @author ulseg
 */
public interface MetodosMedicamento {
    public int registrarMedicamento(Medicamento medicamento) throws Exception;
    public int recuperarUltimoMedicamento() throws Exception;
    public DefaultTableModel recuperarRegistrosMedicamento(int criterio, String filtro) throws Exception;
    public DefaultTableModel setTitulosMedicamento() throws Exception;
    public int eliminarMedicamento(int id_medicamento) throws Exception;
    public int modificarMedicamento(Medicamento medicamento) throws Exception;
    public int recuperarIdMedicamento(String mdm)throws Exception;
    public Medicamento buscarMedicamento(String mdm_nombre) throws Exception;
}

