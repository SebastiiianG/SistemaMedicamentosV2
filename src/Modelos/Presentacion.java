
package Modelos;

/**
 *
 * @author ulseg
 */
public class Presentacion {

    private int id_presentacion;
    private String pre_nombre;
    
    //Constructores
    public Presentacion(int id_presentacion, String pre_nombre){
        this.id_presentacion = id_presentacion;
        this.pre_nombre = pre_nombre;
    }
    
    public Presentacion(){
        this(0, null); 
    }
    public int getIdPresentacion() {
        return id_presentacion;
    }

    //Setters y getters
    public void setIdPresentacion(int id_presentacion) {
        this.id_presentacion = id_presentacion;
    }

    public String getPreNombre() {
        return pre_nombre;
    }

    public void setPreNombre(String pre_nombre) {
        this.pre_nombre = pre_nombre;
    }
    
    
}
