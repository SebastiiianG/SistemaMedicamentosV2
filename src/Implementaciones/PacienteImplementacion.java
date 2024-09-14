/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Implementaciones;

import Database.Conecta;
import Interfaces.MetodosPaciente;
import Modelos.Paciente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author edwin-993
 */
public class PacienteImplementacion extends Conecta implements MetodosPaciente{

    @Override
    public int registrarPaciente(Paciente paciente) throws Exception {
        int afectadas = 0;
        try{
            this.conectar();
            PreparedStatement consulta = this.conexion.prepareStatement("INSERT INTO paciente(pac_nss,pac_nombre,pac_edad, pac_altura) VALUES (?,?,?,?)");
            consulta.setInt(1, paciente.getPac_nss());
            consulta.setString(2,paciente.getPac_nombre());
            consulta.setInt(3,paciente.getPac_edad());
            consulta.setFloat(4,paciente.getPac_altura());
            afectadas = consulta.executeUpdate();
            
        }catch(SQLException err){
            JOptionPane.showMessageDialog(null, 
                    "Se ha producido un error en registrarPaciente\n ERROR: " + err.getMessage(), 
                    "Error en la base de datos", 
                    JOptionPane.ERROR_MESSAGE);
        }
        return afectadas;
    }

    @Override
    public int actualizarPaciente(Paciente paciente) throws Exception {
        int afectadas = -1;
        try{
            this.conectar();
            PreparedStatement consulta = this.conexion.prepareStatement("UPDATE paciente "
                    + "SET paciente.pac_nss = ?, paciente.pac_nombre = ?, "
                            + "paciente.pac_edad = ?, "
                            + "paciente.pac_altura =? "
                            + "WHERE paciente.id_paciente = ?");
            consulta.setInt(1, paciente.getPac_nss());
            consulta.setString(2,paciente.getPac_nombre());
            consulta.setInt(3, paciente.getPac_edad());
            consulta.setFloat(4,paciente.getPac_altura());
            consulta.setInt(5, paciente.getId_paciente());
            afectadas = consulta.executeUpdate();
        }catch(SQLException err){
            JOptionPane.showMessageDialog(null, 
                    "Error en actualizarPaciente, a la hora de realizar la consulta a la base de datos: \n"
                            + err.getMessage());
        }
        return afectadas;
    }

    @Override
    public int eliminarPaciente(int id_paciente) throws Exception {
        int afectadas=-1;
        try{
            this.conectar();
            PreparedStatement consulta = this.conexion.prepareStatement("DELETE FROM paciente WHERE paciente.id_paciente = ?");
            consulta.setInt(1, id_paciente);
            afectadas = consulta.executeUpdate();
        }catch(SQLException err){
            JOptionPane.showMessageDialog(null, 
                    "Error en eliminarPaciente, a la hora de realizar la consulta a la base de datos\n"
                            + err.getMessage());
        }
        return afectadas;
    }

    @Override
    public DefaultTableModel recuperarPacientes(int filtro, String criterio, int orden) throws Exception {
        //CONFIGURACION DE LA CONSULTA RESPECTO A FILTROS, CRITERIOS Y ORDEN
        String columnaAFiltrar = " ";
        switch (filtro) {
            case 0 ->
                columnaAFiltrar = " Identificador ";
            case 1 ->
                columnaAFiltrar = " Numero_Seguro_Social ";
            case 2 ->
                columnaAFiltrar = " Nombre ";
            case 3 ->
                columnaAFiltrar = " Edad ";
            case 4 ->
                columnaAFiltrar = " Altura ";
        }
        String where = " WHERE " + columnaAFiltrar + " LIKE " + "'" + criterio + "%'";
        String ordenS = orden == 0 ? " ASC " : " DESC ";
        String consultaCompleta = "SELECT * FROM formatoTablaPaciente " + where
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
        int id =-1;
        ResultSet resultados;
        try{
            this.conectar();
            PreparedStatement consulta = this.conexion.prepareStatement("SELECT MAX(Identificador) FROM formatoTablaPaciente");
            resultados = consulta.executeQuery();
            while(resultados.next()){
                id = resultados.getInt(1);
            }
        }catch(SQLException err){
            JOptionPane.showMessageDialog(null, 
                    "Error en recuperarUltimo, a la hora de realizar la consulta a la base de datos\n"
                            + err.getMessage());
        }
        return id;
    }
   
}
