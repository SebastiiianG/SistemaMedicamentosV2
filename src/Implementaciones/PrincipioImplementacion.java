
package Implementaciones;

import java.sql.PreparedStatement;

import Database.Conecta;
import java.sql.ResultSet;
import Modelos.PrincipioActivo;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import Interfaces.MetodosPrincipio;

public class PrincipioImplementacion extends Conecta implements MetodosPrincipio{
    DefaultTableModel modeloDeTabla;
    
    @Override
    public int registrarPrincipio(PrincipioActivo principio) throws Exception {
        int afectadas;
        try {
            this.conectar();
                PreparedStatement ST = this.conexion.prepareStatement("INSERT INTO principio_activo(pri_nombre, pri_descripcion)" 
                        + "VALUES (?, ?)");
                ST.setString(1,principio.getPriNombre());
                ST.setString(2,principio.getPriDescripcion());
                afectadas = ST.executeUpdate();
            }catch(SQLException err){
                    throw err;
            }finally {
                    this.cerrar();
        }
        return afectadas;
    }

    @Override
    public int recuperarUltimoPrincipio()throws Exception{
            ResultSet resultados;
            int id = -1;
            try{
                this.conectar();
                PreparedStatement ST= this.conexion.prepareStatement("SELECT MAX(id_principio) FROM principio_activo");
                resultados=ST.executeQuery();
                while(resultados.next()){
                    id = resultados.getInt("MAX(id_principio)");
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
    public DefaultTableModel recuperarRegistrosPrincipio(int criterio, String filtro) throws Exception {
      String consulta = "";
      filtro='"'+filtro+"%"+'"';

      if (criterio==0){
              consulta = "SELECT principio_activo.pri_nombre , principio_activo.pri_descripcion"
                      + " FROM principio_activo WHERE principio_activo.pri_nombre " 
                      + " LIKE " + filtro + " ORDER BY principio_activo.pri_nombre ASC LIMIT 40";
         
      }else if(criterio==1){  
              consulta = "SELECT principio_activo.pri_nombre , principio_activo.pri_descripcion"
                      + " FROM principio_activo WHERE principio_activo.pri_nombre " 
                      + " LIKE " + filtro + " ORDER BY principio_activo.pri_nombre DESC LIMIT 40";
      }        
      
      
       this.setTitulosPrincipio();
       ResultSet resultados;
       try{
           this.conectar();
           PreparedStatement ST = this.conexion.prepareStatement(consulta);
           resultados = ST.executeQuery();
           Object[] fila = new Object[2]; //Arreglo de los objetos
           while(resultados.next()){
               fila[0] = resultados.getString(1);
               fila[1] = resultados.getString(2);
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
    public DefaultTableModel setTitulosPrincipio() throws Exception {
        modeloDeTabla = new DefaultTableModel();
        modeloDeTabla.addColumn("Nombre del principio:");
        modeloDeTabla.addColumn("Descripción del principio:");
        return modeloDeTabla;
    }
    
    @Override
    public int eliminarPrincipio(int id_principio) throws Exception{
        int registrosAfectados=-1;
        try {
            this.conectar();
            PreparedStatement ST = this.conexion.prepareStatement("DELETE FROM principio_activo "
                    + "WHERE principio_activo.id_principio = ?");
            ST.setInt(1,id_principio);
            registrosAfectados = ST.executeUpdate();
	}catch(Exception err){
            throw err;
	}finally {
            this.cerrar();
	}
        return registrosAfectados;
    }
    
    @Override
    public int modificarPrincipio (PrincipioActivo principio) throws Exception {
        int filasAfectadas = -1;
        try{
            this.conectar();
            PreparedStatement ST = this.conexion.prepareStatement("UPDATE principio_activo SET pri_nombre = ?, pri_descripcion = ?"
                    + "WHERE presentacion.id_presentacion = ?");
            ST.setString(1,principio.getPriNombre());
            ST.setString(2,principio.getPriDescripcion());
            ST.setInt(3,principio.getIdPrincipio());
            filasAfectadas = ST.executeUpdate();
        }catch(SQLException err){
            throw err;
        }finally{
            this.cerrar();
        }
        return filasAfectadas;
    }
    
    @Override
    public int recuperarIdPrincipio(String prin) throws Exception {   
        int id = -1;
        ResultSet resultado;

        try{
            this.conectar();
            PreparedStatement ST = this.conexion.prepareStatement("SELECT id_principio FROM principio_activo "
            + "WHERE principio_activo.pri_nombre = ?");
            ST.setString(1,prin);
            resultado = ST.executeQuery();
            while(resultado.next()){
                id = resultado.getInt("id_principio");
            }
        }catch(SQLException err){
            throw err;
        }finally{
            this.cerrar();
        }
        
        return id;
    }

    @Override
    public PrincipioActivo buscarPrincipio(String pri_nombre) throws Exception {
        PrincipioActivo principio = new PrincipioActivo();
        ResultSet resultado;
        try{
            this.conectar();
            PreparedStatement ST= this.conexion.prepareStatement("SELECT "
                    + "pri_nombre, pri_descripcion FROM principio_activo WHERE "
                    + "principio_activo.pri_nombre =" + pri_nombre);
            resultado=ST.executeQuery(); 
            while(resultado.next()){ //Para recorrer el result set
                    ///Se capturan todos los datos que arroja la consulta y se guardan en el objeto principio
                    principio.setPriNombre(resultado.getString("pri_nombre"));
            }
        }catch(SQLException err){
            throw err;
        }finally{
            this.cerrar();
            resultado = null;
        }
        return principio;        
    }
    
}

