
package Modelos;

/**
 *
 * @author ulseg
 */
public class PrincipioActivo {
    
    private int id_principio;
    private String pri_nombre;
    private String pri_descripcion;

    
    public PrincipioActivo(int id_principio, String pri_nombre, String pri_descripcion){
        this.id_principio = id_principio;
        this.pri_nombre = pri_nombre;
        this.pri_descripcion = pri_descripcion;
    }
    
    public PrincipioActivo(){
        this(0, null, null);
    }
    
    public int getIdPrincipio() {
        return id_principio;
    }
    
    public void setIdPrincipio(int id_principio) {
        this.id_principio = id_principio;
    }

    public String getPriNombre() {
        return pri_nombre;
    }
    
     public void setPriNombre(String pri_nombre) {
        this.pri_nombre = pri_nombre;
    }

    public String getPriDescripcion() {
        return pri_descripcion;
    }    

    public void setPriDescripcion(String pri_descripcion) {
        this.pri_descripcion = pri_descripcion;
    }   
           
}

