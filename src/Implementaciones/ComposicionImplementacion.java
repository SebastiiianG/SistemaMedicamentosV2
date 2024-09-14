
package Implementaciones;

import java.sql.PreparedStatement;
import Database.Conecta;
import Interfaces.MetodosComposicion;
import Modelos.Composicion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author ulseg
 */
public class ComposicionImplementacion extends Conecta implements MetodosComposicion{
    
    @Override
    public int registrarComposicion(Composicion composicion) throws Exception{
        int afectadas;
        try{
            this.conectar();
                    PreparedStatement ST = this.conexion.prepareStatement("INSERT INTO "
                            + "composicion(id_medicamento, id_principio, comp_concentracion, comp_unidades) "
                            + "VALUES(?, ?, ?, ?)");
           
                    int id_med = recuperarIdMed(composicion.getNombreMedicamento()); //Transformación de las variables
                    int id_prin = recuperarIdPrin(composicion.getNombrePrincipio());
            
                    ST.setInt(1,id_med);
                    ST.setInt(2,id_prin);
                    ST.setInt(3,composicion.getCompConcentracion());
                    ST.setString(4,composicion.getCompUnidades());
                    
                    afectadas = ST.executeUpdate();
        }catch(SQLException err){
            throw err;
        }finally{
            this.cerrar();
        }
        return afectadas;
    }   
    
    @Override
    public ArrayList recuperarNomPrincipio() throws Exception{ //Funcion para rellenar la cmb
        String consulta = "";
        ArrayList principios = new ArrayList();
        
            consulta = "SELECT principio_activo.pri_nombre"
                      + " FROM principio_activo" 
                      + " ORDER BY principio_activo.pri_nombre ASC";
            
        ResultSet resultados;
        try{
           this.conectar();
           PreparedStatement ST = this.conexion.prepareStatement(consulta);
           resultados = ST.executeQuery();
           while(resultados.next()){
               principios.add(resultados.getString(1));
           }
        }catch(Exception err){
                throw err;
        }finally{
                this.cerrar();
                resultados = null;
        }
        return principios;
         
    }
    
    @Override
    public int recuperarIdPrin(String prin) throws Exception{
        int idPrin=0;
        try{
            this.conectar();
            PreparedStatement ST = this.conexion.prepareStatement("SELECT principio_activo.id_principio FROM principio_activo "
                    + "WHERE principio_activo.pri_nombre="+"\""+ prin + "\"");
            ResultSet rs=ST.executeQuery();
            
            while(rs.next())
            {
                idPrin=rs.getInt(1);
            }
            
        }catch(SQLException err)
        {
            throw err;
        }finally{
            this.cerrar();
        }
        
        return idPrin;
    }
    
    @Override
    public String buscarNombrePrin(int id_prin) throws Exception{ //Funcion para llenar la tabla, 
        //cambiar los id por nombre
        String consulta = "";
        String nombrePrincipio = ""; //Inicializacion de las variables a nulo 
              
            consulta = "SELECT principio_activo.pri_nombre"
                      + " FROM principio_activo " 
                      + " WHERE principio_activo.id_principio = " + id_prin  
                      + " LIMIT 1"; //Construcción de la consulta, se obtiene el nombre
            //con base en el ID
        ResultSet resultados;
        try{
           this.conectar();
           PreparedStatement ST = this.conexion.prepareStatement(consulta);
           resultados = ST.executeQuery();
           while(resultados.next()){
               nombrePrincipio = resultados.getString(1); //Asignación del string
           }
        }catch(Exception err){
                throw err;
        }finally{
                this.cerrar();
                resultados = null;
        }
         return nombrePrincipio;
    }
    
    @Override
    public ArrayList recuperarNomMedicamento() throws Exception{ //Funcion para rellenar la cmb
        String consulta = "";
        ArrayList principios = new ArrayList();
        
            consulta = "SELECT medicamento.mdm_nombre"
                      + " FROM medicamento" 
                      + " ORDER BY medicamento.mdm_nombre ASC";
            
        ResultSet resultados;
        try{
           this.conectar();
           PreparedStatement ST = this.conexion.prepareStatement(consulta);
           resultados = ST.executeQuery();
           while(resultados.next()){
               principios.add(resultados.getString(1));
           }
        }catch(Exception err){
                throw err;
        }finally{
                this.cerrar();
                resultados = null;
        }
        return principios;
         
    }
    
    @Override
    public int recuperarIdMed(String mdm) throws Exception{
        int idMed=0;
        try{
            this.conectar();
            PreparedStatement ST = this.conexion.prepareStatement("SELECT medicamento.id_medicamento FROM medicamento "
                    + "WHERE medicamento.mdm_nombre="+"\""+ mdm + "\"");
            ResultSet rs=ST.executeQuery();
            
            while(rs.next())
            {
                idMed=rs.getInt(1);
            }
            
        }catch(SQLException err)
        {
            throw err;
        }finally{
            this.cerrar();
        }
        
        return idMed;
    }
    
    @Override
    public String buscarNombreMed(int id_med) throws Exception{ //Funcion para llenar la tabla, 
        //cambiar los id por nombre
        String consulta = "";
        String nombreMedicamento = ""; //Inicializacion de las variables a nulo 
              
            consulta = "SELECT medicamento.mdm_nombre"
                      + " FROM medicamento " 
                      + " WHERE medicamento.id_medicamento = " + id_med  
                      + " LIMIT 1"; //Construcción de la consulta, se obtiene el nombre
            //con base en el ID
        ResultSet resultados;
        try{
           this.conectar();
           PreparedStatement ST = this.conexion.prepareStatement(consulta);
           resultados = ST.executeQuery();
           while(resultados.next()){
               nombreMedicamento = resultados.getString(1); //Asignación del string
           }
        }catch(Exception err){
                throw err;
        }finally{
                this.cerrar();
                resultados = null;
        }
         return nombreMedicamento;
    }
    
    @Override
    public int recuperarUltimaComposicion() throws Exception {
        ResultSet resultados;
            int id = -1;
            try{
                this.conectar();
                PreparedStatement ST= this.conexion.prepareStatement("SELECT MAX(id_composicion) FROM composicion");
                resultados=ST.executeQuery();
                while(resultados.next()){
                    id = resultados.getInt("MAX(id_composicion)");
                }
            }catch(SQLException err){
                throw err;
            }finally{
                this.cerrar();
                resultados = null;
            }
            return id;
    }

    /*@Override
    public DefaultTableModel recuperarRegistrosComposicion(int criterio, String filtro, int orden) throws Exception {
        String columnaAFiltrar = "";
        System.out.println("El valor del criterio es: " + criterio);
        switch(criterio){
            case 0:
                columnaAFiltrar = " medicamento.mdm_nombre ";
                System.out.println("El valor de la columna a filtrar es: " + columnaAFiltrar);
            case 1:
                columnaAFiltrar = " principio_activo.pri_nombre ";      
                System.out.println("El valor de la columna a filtrar es: " + columnaAFiltrar);
            default:
                System.out.println("EL SWITCH NO ENTRA EN NINGUNO DE LOS CASOS" );
                break;
        }
        
        String where = " WHERE " + columnaAFiltrar + " LIKE " + "'" + filtro + "%'";
        String ordenS = orden == 0 ? " ASC " : " DESC ";
        String fullQuery = "SELECT medicamento.mdm_nombre, principio_activo.pri_nombre, "
                + "composicion.comp_concentracion, composicion.comp_unidades FROM composicion "
                + "JOIN medicamento ON medicamento.id_medicamento = composicion.id_medicamento " 
                + "JOIN principio_activo ON principio_activo.id_principio = composicion.id_principio " + where
                + " ORDER BY " + columnaAFiltrar + " " + ordenS + " LIMIT 40";
         this.setTitulosComposicion();
         ResultSet resultados;
         try{
             this.conectar();
             PreparedStatement ST = this.conexion.prepareStatement(fullQuery);
             resultados = ST.executeQuery();
             Object[] fila = new Object[4]; //Arreglo de los objetos
             while(resultados.next()){
                 fila[0] = resultados.getString(1); //Recibe el id y lo transforma al nombre para
                 //Generar las tablas
                 fila[1] = resultados.getString(2);
                 fila[2] = resultados.getInt(3);
                 fila[3] = resultados.getString(4);
                 modeloDeTabla.addRow(fila);
             }
         }catch(Exception err){
             throw err;
         }finally{
             this.cerrar();
             resultados = null;
         }
        return modeloDeTabla;
    }*/

    /*@Override
    public DefaultTableModel setTitulosComposicion() throws Exception {
        modeloDeTabla = new DefaultTableModel();
        modeloDeTabla.addColumn("Medicamento");
        modeloDeTabla.addColumn("Principio Activo");
        modeloDeTabla.addColumn("Concentración");
        modeloDeTabla.addColumn("Unidad de medida");
        return modeloDeTabla;
    }*/

    @Override
    public int eliminarComposicion(int id_composicion) throws Exception {
        int registrosAfectados=-1;
        try {
            this.conectar();
            PreparedStatement ST = this.conexion.prepareStatement("DELETE FROM composicion "
                    + "WHERE composicion.id_composicion = ?");
            ST.setInt(1,id_composicion);
            registrosAfectados = ST.executeUpdate();
	}catch(Exception err){
            throw err;
	}finally {
            this.cerrar();
	}
        return registrosAfectados;
    }

    @Override
    public int modificarComposicion(Composicion composicion) throws Exception {
        int filasAfectadas = -1;
        int id_prin = 0, id_med = 0, id_comp = 0;
        try{
            this.conectar();
            PreparedStatement ST = this.conexion.prepareStatement("UPDATE composicion SET id_medicamento = ?, id_principio = ?,"
                    + "comp_concentracion = ?, comp_unidades = ?"
                    + "WHERE composicion.id_composicion = ?");
            
           id_med = recuperarIdMed(composicion.getNombreMedicamento()); //Transformación de las variables
           id_prin = recuperarIdPrin(composicion.getNombrePrincipio());
            
            ST.setInt(1,id_med);
            ST.setInt(2,id_prin);
            ST.setInt(3,composicion.getCompConcentracion());
            ST.setString(4,composicion.getCompUnidades());
            ST.setInt(5, composicion.getIdComposicion());
            filasAfectadas = ST.executeUpdate();
        }catch(SQLException err){
            throw err;
        }finally{
            this.cerrar();
        }
        return filasAfectadas;
    }

    @Override
    public int recuperarIdComposicion(String med, String prin) throws Exception {
        int id = -1;
        int id_prin = 0, id_med = 0;
        ResultSet resultado;

        try{
            this.conectar();
            PreparedStatement ST = this.conexion.prepareStatement("SELECT id_composicion FROM composicion "
            + "WHERE composicion.id_medicamento = ? AND composicion.id_principio = ?");
            id_med = recuperarIdMed(med); //Transformación de las variables
            id_prin = recuperarIdPrin(prin);
            ST.setInt(1,id_med);
            ST.setInt(2,id_prin);
            resultado = ST.executeQuery();
            while(resultado.next()){
                id = resultado.getInt("id_composicion");
            }
        }catch(SQLException err){
            throw err;
        }finally{
            this.cerrar();
        }
        
        return id;
    }

    @Override
    public JComboBox obtenerPrincipio() throws Exception {
        JComboBox combo = new JComboBox();
        try{
            this.conectar();
            PreparedStatement ST = this.conexion.prepareStatement("SELECT DISTINCT pri_nombre FROM principio_activo");
            
            ResultSet rs = ST.executeQuery();
            
            while(rs.next())
            {
                combo.addItem(rs.getString(1));
            }
        }catch(SQLException err)
        {
            throw err;
        }finally
        {
            this.cerrar();
        }
        return combo;
    }
    
    @Override
    public JComboBox obtenerMedicamento() throws Exception {
        JComboBox combo = new JComboBox();
        try{
            this.conectar();
            PreparedStatement ST = this.conexion.prepareStatement("SELECT DISTINCT mdm_nombre FROM medicamento");
            
            ResultSet rs = ST.executeQuery();
            
            while(rs.next())
            {
                combo.addItem(rs.getString(1));
            }
        }catch(SQLException err)
        {
            throw err;
        }finally
        {
            this.cerrar();
        }
        return combo;
    }

    @Override
    public void rellenarTabla(DefaultTableModel table, Composicion composicion) throws Exception {
        try{
            this.conectar();
            PreparedStatement ST = this.conexion.prepareStatement("SELECT medicamento.mdm_nombre,"
                    + " principio_activo.pri_nombre, "
                    + " composicion.comp_concentracion, "
                    + "composicion.comp_unidades FROM composicion "
                    + "JOIN medicamento ON medicamento.id_medicamento = composicion.id_medicamento "
                    + "JOIN principio_activo ON principio_activo.id_principio = composicion.id_principio "
                    + "ORDER BY medicamento.mdm_nombre ASC LIMIT 40");
            
            ResultSet rs = ST.executeQuery();
            
            while(rs.next())
            {
                table.addRow(new String[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)});
            }
            
        }catch(SQLException err)
        {
            throw err;
        }finally
        {
            this.cerrar();
        }
    }
    
    
    @Override
    public void buscar(DefaultTableModel table, Composicion composicion, int filtro, String busqueda) throws Exception{
        this.conectar();
        
        switch (filtro) {
            case 0 -> {
                try{
                    PreparedStatement ST = this.conexion.prepareStatement("SELECT medicamento.mdm_nombre,"
                    + " principio_activo.pri_nombre, "
                    + " composicion.comp_concentracion, "
                    + "composicion.comp_unidades FROM composicion "
                    + "JOIN medicamento ON medicamento.id_medicamento = composicion.id_medicamento "
                    + "JOIN principio_activo ON principio_activo.id_principio = composicion.id_principio "
                    + "WHERE medicamento.mdm_nombre LIKE '"+busqueda+"%'"
                    + "ORDER BY medicamento.mdm_nombre ASC LIMIT 40");
                    ResultSet rs = ST.executeQuery();
                    while(rs.next()){
                        table.addRow(new String[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)});
                    }
                    
                }catch(Exception e){
                    throw e;
                }
            }
            case 1 -> {
                try{
                    PreparedStatement ST = this.conexion.prepareStatement("SELECT medicamento.mdm_nombre,"
                    + " principio_activo.pri_nombre, "
                    + " composicion.comp_concentracion, "
                    + "composicion.comp_unidades FROM composicion "
                    + "JOIN medicamento ON medicamento.id_medicamento = composicion.id_medicamento "
                    + "JOIN principio_activo ON principio_activo.id_principio = composicion.id_principio "
                    + "WHERE principio_activo.pri_nombre LIKE '"+busqueda+"%'"
                    + "ORDER BY principio_activo.pri_nombre ASC LIMIT 40");
                    
                    ResultSet rs = ST.executeQuery();
                    
                    while(rs.next()){
                        table.addRow(new String[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)});
                    }
                    
                }catch(Exception e){
                    throw e;
                }
            }
            case 2 -> {
                try{
                    PreparedStatement ST = this.conexion.prepareStatement("SELECT medicamento.mdm_nombre,"
                    + " principio_activo.pri_nombre, "
                    + " composicion.comp_concentracion, "
                    + "composicion.comp_unidades FROM composicion "
                    + "JOIN medicamento ON medicamento.id_medicamento = composicion.id_medicamento "
                    + "JOIN principio_activo ON principio_activo.id_principio = composicion.id_principio "
                    + "WHERE composicion.comp_concentracion LIKE '"+busqueda+"%'"
                    + " ORDER BY composicion.comp_concentracion ASC LIMIT 40");
                   
                    ResultSet rs = ST.executeQuery();
                    
                    while(rs.next()){
                        table.addRow(new String[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)});
                    }
                    
                }catch(Exception e){
                    throw e;
                }
            }
                default -> {
            }
        }
        
        this.cerrar();
    }

    
    
    
    
    
}
