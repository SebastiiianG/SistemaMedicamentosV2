
package Implementaciones;

import java.sql.PreparedStatement;

import Database.Conecta;
import java.sql.ResultSet;
import Modelos.Medicamento;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import Interfaces.MetodosMedicamento;

public class MedicamentoImplementacion extends Conecta implements MetodosMedicamento{
    DefaultTableModel modeloDeTabla;
    
    @Override
    public int registrarMedicamento(Medicamento medicamento) throws Exception {
        int afectadas;
        try {
            this.conectar();
                PreparedStatement ST = this.conexion.prepareStatement("INSERT INTO medicamento(mdm_nombre, mdm_descripcion)" 
                        + "VALUES (?, ?)");
                ST.setString(1,medicamento.getMdmNombre());
                ST.setString(2,medicamento.getMdmDescripcion());
                afectadas = ST.executeUpdate();
            }catch(SQLException err){
                    throw err;
            }finally {
                    this.cerrar();
        }
        return afectadas;
    }

    @Override
    public int recuperarUltimoMedicamento()throws Exception{
            ResultSet resultados;
            int id = -1;
            try{
                this.conectar();
                PreparedStatement ST= this.conexion.prepareStatement("SELECT MAX(id_medicamento) FROM medicamento");
                resultados=ST.executeQuery();
                while(resultados.next()){
                    id = resultados.getInt("MAX(id_medicamento)");
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
    public DefaultTableModel recuperarRegistrosMedicamento(int criterio, String filtro) throws Exception {
      String consulta = "";
      filtro='"'+filtro+"%"+'"';

      if (criterio==0){
              consulta = "SELECT medicamento.mdm_nombre , medicamento.mdm_descripcion"
                      + " FROM medicamento WHERE medicamento.mdm_nombre " 
                      + " LIKE " + filtro + " ORDER BY medicamento.mdm_nombre ASC LIMIT 40";
         
      }else if(criterio==1){  
              consulta = "SELECT medicamento.mdm_nombre , medicamento.mdm_descripcion"
                      + " FROM medicamento WHERE medicamento.mdm_nombre " 
                      + " LIKE " + filtro + " ORDER BY medicamento.mdm_nombre DESC LIMIT 40";
      }        
      
      
       this.setTitulosMedicamento();
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
    public DefaultTableModel setTitulosMedicamento() throws Exception {
        modeloDeTabla = new DefaultTableModel();
        modeloDeTabla.addColumn("Nombre del medicamento");
        modeloDeTabla.addColumn("Descripción del medicamento");
        return modeloDeTabla;
    }
    
    @Override
    public int eliminarMedicamento(int id_medicamento) throws Exception{
        int registrosAfectados=-1;
        try {
            this.conectar();
            PreparedStatement ST = this.conexion.prepareStatement("DELETE FROM medicamento "
                    + "WHERE medicamento.id_medicamento = ?");
            ST.setInt(1,id_medicamento);
            registrosAfectados = ST.executeUpdate();
	}catch(Exception err){
            throw err;
	}finally {
            this.cerrar();
	}
        return registrosAfectados;
    }
    
    @Override
    public int modificarMedicamento(Medicamento medicamento) throws Exception {
        int filasAfectadas = -1;
        try{
            this.conectar();
            PreparedStatement ST = this.conexion.prepareStatement("UPDATE medicamento SET mdm_nombre = ?, mdm_descripcion = ?"
                    + "WHERE medicamento.id_medicamento = ?");
            ST.setString(1,medicamento.getMdmNombre());
            ST.setString(2,medicamento.getMdmDescripcion());
            ST.setInt(3,medicamento.getIdMedicamento());
            filasAfectadas = ST.executeUpdate();
        }catch(SQLException err){
            throw err;
        }finally{
            this.cerrar();
        }
        return filasAfectadas;
    }
    
    @Override
    public int recuperarIdMedicamento(String mdm) throws Exception {   
        int id = -1;
        ResultSet resultado;

        try{
            this.conectar();
            PreparedStatement ST = this.conexion.prepareStatement("SELECT id_medicamento FROM medicamento "
            + "WHERE medicamento.mdm_nombre = ?");
            ST.setString(1,mdm);
            resultado = ST.executeQuery();
            while(resultado.next()){
                id = resultado.getInt("id_medicamento");
            }
        }catch(SQLException err){
            throw err;
        }finally{
            this.cerrar();
        }
        
        return id;
    }

    @Override
    public Medicamento buscarMedicamento(String mdm_nombre) throws Exception {
        Medicamento medicamento = new Medicamento();
        ResultSet resultado;
        try{
            this.conectar();
            PreparedStatement ST= this.conexion.prepareStatement("SELECT "
                    + "mdm_nombre, mdm_descripcion FROM medicamento WHERE "
                    + "medicamento.mdm_nombre =" + mdm_nombre);
            resultado=ST.executeQuery(); 
            while(resultado.next()){ //Para recorrer el result set
                    ///Se capturan todos los datos que arroja la consulta y se guardan en el objeto principio
                    medicamento.setMdmNombre(resultado.getString("mdm_nombre"));
            }
        }catch(SQLException err){
            throw err;
        }finally{
            this.cerrar();
            resultado = null;
        }
        return medicamento;        
    }
    
}

