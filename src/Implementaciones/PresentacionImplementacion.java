package Implementaciones;

import java.sql.PreparedStatement;

import Database.Conecta;
import java.sql.ResultSet;
import Modelos.Presentacion;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import Interfaces.MetodosPresentacion;
/**
 *
 * @author ulseg
 */
public class PresentacionImplementacion extends Conecta implements MetodosPresentacion{
    DefaultTableModel modeloDeTabla;///Se crea un modelo de tabla para poder meter los datos en la misma.

    @Override
    public void registrar(Presentacion presentacion) throws Exception {
        try {
            this.conectar();
                PreparedStatement ST = this.conexion.prepareStatement("INSERT INTO presentacion(pre_nombre) VALUES (?)");
                ST.setString(1,presentacion.getPreNombre());
                ST.executeUpdate();
            }catch(SQLException err){
                    throw err;
            }finally {
                    this.cerrar();
        }
		
    }

    
    @Override
    public int recuperarUltimaPresentacion()throws Exception{
            
            ResultSet resultados;
            int id = -1;
            try{
                this.conectar();
                PreparedStatement ST= this.conexion.prepareStatement("SELECT MAX(id_presentacion) FROM presentacion");
                resultados=ST.executeQuery();
                while(resultados.next()){
                    id = resultados.getInt("MAX(id_presentacion)");
                }
            }catch(SQLException err){
                throw err;
            }finally{
                this.cerrar();
                resultados = null;
            }
            return id;
    }
    
    @Override
    public DefaultTableModel recuperarRegistros(int criterio, String filtro) throws Exception {
      String consulta = "";
      filtro='"'+filtro+"%"+'"';
      if (criterio==0){
              consulta = "SELECT presentacion.pre_nombre FROM presentacion WHERE presentacion.pre_nombre" 
                      + " LIKE " + filtro+ " ORDER BY presentacion.pre_nombre ASC LIMIT 40";
             
      }else if(criterio==1){  
              consulta = "SELECT presentacion.pre_nombre FROM presentacion WHERE presentacion.pre_nombre" 
                      + " LIKE " + filtro + " ORDER BY presentacion.pre_nombre DESC LIMIT 40";
      }        
      
      
       this.setTitulos();
       ResultSet resultados;
       try{
           this.conectar();
           PreparedStatement ST = this.conexion.prepareStatement(consulta);
           resultados = ST.executeQuery();
           Object[] fila = new Object[1];
           while(resultados.next()){
               fila[0] = resultados.getString(1);
               modeloDeTabla.addRow(fila);
           }
       }catch(Exception err){
           throw err;
       }finally{
           this.cerrar();
           resultados = null;
       }
       return modeloDeTabla;
    }
    
    @Override
    public DefaultTableModel setTitulos() throws Exception {
        modeloDeTabla = new DefaultTableModel();
        modeloDeTabla.addColumn("Tipo de  presentacion: ");
        return modeloDeTabla;
    }
    
    @Override
    public int eliminarPresentacion(int id_presentacion) throws Exception{
        int registrosAfectados=-1;
        try {
            this.conectar();
            PreparedStatement ST = this.conexion.prepareStatement("DELETE FROM presentacion "
                    + "WHERE presentacion.id_presentacion = ?");
            ST.setInt(1,id_presentacion);
            registrosAfectados = ST.executeUpdate();
	}catch(Exception err){
            throw err;
	}finally {
            this.cerrar();
	}
        return registrosAfectados;
    }
    
    @Override
    public int modificarPresentacion (Presentacion presentacion) throws Exception {
        int filasAfectadas = -1;
        try{
            this.conectar();
            PreparedStatement ST = this.conexion.prepareStatement("UPDATE presentacion SET pre_nombre = ?"
                    + "WHERE presentacion.id_presentacion = ?");
            ST.setString(1,presentacion.getPreNombre());
            ST.setInt(2,presentacion.getIdPresentacion());
            filasAfectadas = ST.executeUpdate();
        }catch(SQLException err){
            throw err;
        }finally{
            this.cerrar();
        }
        return filasAfectadas;
    }
    
    @Override
    public int recuperarId(String nombre) throws Exception {   
        int id = -1;
        ResultSet resultado;

        try{
            this.conectar();
            PreparedStatement ST = this.conexion.prepareStatement("SELECT id_presentacion FROM presentacion "
            + "WHERE presentacion.pre_nombre = ?");
            ST.setString(1,nombre);
            resultado = ST.executeQuery();
            while(resultado.next()){
                id = resultado.getInt("id_presentacion");
            }
        }catch(SQLException err){
            throw err;
        }finally{
            this.cerrar();
        }
        
        return id;
    }

    @Override
    public Presentacion buscarPresentacion(String pres_nombre) throws Exception {
        Presentacion presentacion = new Presentacion();
        ResultSet resultado;
        try{
            this.conectar();
            PreparedStatement ST= this.conexion.prepareStatement("SELECT "
                    + "pre_nombre FROM presentacion WHERE "
                    + "presentacion.pre_nombre =" + pres_nombre);
            resultado=ST.executeQuery(); 
            while(resultado.next()){ //Para recorrer el result set
                    ///Se capturan todos los datos que arroja la consulta y se guardan en el objeto presentacion
                    presentacion.setPreNombre(resultado.getString("pre_nombre"));
            }
        }catch(SQLException err){
            throw err;
        }finally{
            this.cerrar();
            resultado = null;
        }
        return presentacion;        
    }
    
}
