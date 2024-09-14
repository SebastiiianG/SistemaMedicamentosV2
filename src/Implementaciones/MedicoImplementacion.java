/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Implementaciones;

import Database.Conecta;
import Interfaces.MetodosMedico;
import Modelos.Medico;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Edwin Campos
 */
public class MedicoImplementacion extends Conecta implements MetodosMedico {

    @Override
    public int registrarMedico(Medico medico) throws Exception {
        int columnasAfectadas;
        try {
            this.conectar();
            PreparedStatement statement = this.conexion.prepareStatement(
                    "INSERT INTO medico("
                            + "med_nombre, med_cedula, med_telefono, med_especialidad, med_direccion) "
                            + "VALUES (?,?,?,?,?)");
            statement.setString(1, medico.getMed_nombre());
            statement.setString(2,medico.getMed_cedula());
            statement.setString(3, medico.getMed_telefono());
            statement.setString(4,medico.getMed_especialidad());
            statement.setString(5,medico.getMed_direccion());
            columnasAfectadas = statement.executeUpdate();
        } catch (SQLException err) {
            throw err;
        } finally {
            this.cerrar();
        }
        return columnasAfectadas;
    }

    @Override
    public int actualizarMedico(Medico medico) throws Exception {
        int columnasAfectadas;
        try{
            this.conectar();
            PreparedStatement actualizacion = this.conexion.prepareStatement("UPDATE medico"
                    + " SET med_nombre = ?, "
                    + " med_cedula = ?, "
                    + " med_telefono = ?, "
                    + " med_especialidad = ?, "
                    + " med_direccion = ? "
                    + " WHERE medico.id_medico = ?");
            actualizacion.setString(1, medico.getMed_nombre());
            actualizacion.setString(2,medico.getMed_cedula());
            actualizacion.setString(3,medico.getMed_telefono());
            actualizacion.setString(4, medico.getMed_especialidad());
            actualizacion.setString(5,medico.getMed_direccion());
            actualizacion.setInt(6, medico.getId_medico());
            columnasAfectadas = actualizacion.executeUpdate();
        }catch(SQLException err){
            throw err;
        }
        return columnasAfectadas;
    }

    @Override
    public int eliminarMedico(int id_med) throws Exception {
        int afectados =-1;
        try{
            this.conectar();
            PreparedStatement eliminacion = this.conexion.prepareStatement("DELETE FROM medico WHERE id_medico = ?");
            eliminacion.setInt(1, id_med);
            afectados = eliminacion.executeUpdate();
        }catch(SQLException err){
            JOptionPane.showMessageDialog(null, 
                    "Error al eliminar de la base de datos:\n" + err.getMessage(), 
                    "Error al eliminar un medico", 
                    JOptionPane.ERROR_MESSAGE);
        }
        return afectados;
    }

    @Override
    public Medico consultarMedico(int id_med) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public DefaultTableModel recuperarMedicos(int filtro, String criterio, int orden) throws Exception {
        //CONFIGURACION DE LA CONSULTA RESPECTO A FILTROS, CRITERIOS Y ORDEN
        String columnaAFiltrar = " ";
        switch (filtro) {
            case 0 ->
                columnaAFiltrar = " Identificador ";
            case 1 ->
                columnaAFiltrar = " Nombre_completo ";
            case 2 ->
                columnaAFiltrar = " Cedula_profesional ";
            case 3 ->
                columnaAFiltrar = " Telefono_movil ";
            case 4 ->
                columnaAFiltrar = " Especialidad ";
        }
        String where = " WHERE " + columnaAFiltrar + " LIKE " + "'" + criterio + "%'";
        String ordenS = orden == 0 ? " ASC " : " DESC ";
        String consultaCompleta = "SELECT * FROM formatoTablaMedico " + where
                + " ORDER BY " + columnaAFiltrar + " " + ordenS + " LIMIT 40 ";
        DefaultTableModel modeloTabla = new DefaultTableModel();
        try {
            this.conectar();
            PreparedStatement statement = this.conexion.prepareStatement(consultaCompleta);
            ResultSet registrosRecientes = statement.executeQuery();
            int columnCount = registrosRecientes.getMetaData().getColumnCount();
            //Se recuperan los nombres de columna del result set para meterlos a la tabla
            String[] nombresColumnas = new String[columnCount];
            //Se itera en el arreglo de nombres y se asigna cada uno
            for (int i = 0; i < columnCount; i++) {
                nombresColumnas[i] = registrosRecientes.getMetaData().getColumnLabel(i + 1);
            }
            //Se colocan los identificadores de las columnas
            modeloTabla.setColumnIdentifiers(nombresColumnas);
            //Inicia iteracion recorriendo el ResultSet
            while (registrosRecientes.next()) {
                //Crea un arreglo de objetos para recuperar los datos de las tuplas
                Object[] datosMedicos = new Object[columnCount];
                //Se meten los datos en el array de objetos
                for (int i = 0; i < columnCount; i++) {
                    datosMedicos[i] = registrosRecientes.getObject(i + 1);
                }
                //Se inserta la fila en el DefaultTableModel
                modeloTabla.addRow(datosMedicos);
            }
            return modeloTabla;
        } catch (SQLException err) {
            throw err;
        } finally {
            this.cerrar();
        }
    }

    @Override
    public int recuperarUltimo() throws Exception {
        int identificador = -1;
        ResultSet resultado;
        String consulta = "SELECT MAX(Identificador) from formatoTablaMedico";
        try{
            this.conectar();
            PreparedStatement sentencia = this.conexion.prepareStatement(consulta);
            resultado = sentencia.executeQuery();
            while(resultado.next()){
                identificador = resultado.getInt(1);
            }
        }catch(SQLException err){
        throw err;
        }
        return identificador;
    }
}
