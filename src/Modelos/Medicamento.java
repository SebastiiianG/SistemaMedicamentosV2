
package Modelos;

/**
 *
 * @author ulseg
 */
public class Medicamento {

    /**
     * @param args the command line arguments
     */
    private int id_medicamento;
    private String mdm_nombre;
    private String mdm_descripcion;
    
    public Medicamento(int id_medicamento, String mdm_nombre, String mdm_descripcion){
        this.id_medicamento = id_medicamento;
        this.mdm_nombre = mdm_nombre;
        this.mdm_descripcion = mdm_descripcion;
    }
    
    public Medicamento(){
        this(0, null, null);
    }
    
    public int getIdMedicamento(){
        return id_medicamento;
    }            
    
    public void setIdMedicamento(int id_medicamento){
        this.id_medicamento = id_medicamento;
    }
    
    public String getMdmNombre(){
        return mdm_nombre;
    }
    
    public void setMdmNombre(String mdm_nombre){
        this.mdm_nombre = mdm_nombre;
    }
    
    public String getMdmDescripcion(){
        return mdm_descripcion;
    }
    
    public void setMdmDescripcion(String mdm_descripcion){
        this.mdm_descripcion = mdm_descripcion;
    }
   
}
