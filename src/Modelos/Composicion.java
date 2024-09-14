
package Modelos;

/**
 *
 * @author ulseg
 */
public class Composicion {

    private int id_composicion;
    private int comp_concentracion;
    private String comp_unidades;
    private int id_medicamento;
    private int id_principio;
    private String nombreMedicamento;
    private String nombrePrincipio;
    
    
    
    public Composicion(int id_composicion, int comp_concentracion,
             String comp_unidades, int id_medicamento, int id_principio ){
        this.id_composicion = id_composicion;
        this.comp_concentracion = comp_concentracion;
        this.comp_unidades = comp_unidades;
        this.id_medicamento = id_medicamento;
        this.id_principio = id_principio;
    }
    
    public Composicion(){
        this(0,0,null,0,0);
    }
    
    public int getIdComposicion() {
        return id_composicion;
    }

    public void setIdComposicion(int id_composicion) {
        this.id_composicion = id_composicion;
    }

    public int getCompConcentracion() {
        return comp_concentracion;
    }

    public void setCompConcentracion(int comp_concentracion) {
        this.comp_concentracion = comp_concentracion;
    }

    public String getCompUnidades() {
        return comp_unidades;
    }

    public void setCompUnidades(String comp_unidades) {
        this.comp_unidades = comp_unidades;
    }

    public int getIdMedicamento() {
        return id_medicamento;
    }

    public void setIdMedicamento(int id_medicamento) {
        this.id_medicamento = id_medicamento;
    }

    public int getIdPrincipio() {
        return id_principio;
    }

    public void setIdPrincipio(int id_principio) {
        this.id_principio = id_principio;
    }

    public String getNombreMedicamento() {
        return nombreMedicamento;
    }

    public void setNombreMedicamento(String nombreMedicamento) {
        this.nombreMedicamento = nombreMedicamento;
    }

    public String getNombrePrincipio() {
        return nombrePrincipio;
    }

    public void setNombrePrincipio(String nombrePrincipio) {
        this.nombrePrincipio = nombrePrincipio;
    }
    
    
    
    
    
}