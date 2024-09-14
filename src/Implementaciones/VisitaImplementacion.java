/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Implementaciones;

import Database.Conecta;
import Interfaces.MetodosVisita;
import Modelos.Visita;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author edwin-993
 */
public class VisitaImplementacion extends Conecta implements MetodosVisita{

    @Override
    public int registrarVisita(Visita visita) {
        int afectadas = -1;
        try{
            this.conectar();
            PreparedStatement consulta = this.conexion.prepareStatement("INSERT INTO visita(vis_fecha_ingreso, "
                    + "vis_fecha_salida, "
                    + "vis_diagnostico, "
                    + "id_paciente) VALUES (?,?,?,?)");
            
            //Transformación de datos de java.util.date a java.sql.date mediante la API de java.time
            java.time.Instant instante = visita.getVis_fecha_ingreso().toInstant();
            java.time.LocalDate localDate = instante.atZone(ZoneId.systemDefault()).toLocalDate();
            java.sql.Date sqlDateIngreso = java.sql.Date.valueOf(localDate);
            consulta.setDate(1, sqlDateIngreso);
            
            java.time.Instant instanteE = visita.getVis_fecha_ingreso().toInstant();
            java.time.LocalDate localDateE = instanteE.atZone(ZoneId.systemDefault()).toLocalDate();
            java.sql.Date sqlDateEgreso = java.sql.Date.valueOf(localDateE);
            consulta.setDate(2, sqlDateEgreso);
            
            
            consulta.setString(3, visita.getVis_diagnostico());
            consulta.setInt(4,visita.getId_paciente());
            afectadas = consulta.executeUpdate();
            
        }catch(SQLException err){
            JOptionPane.showMessageDialog(null, "Se ha producido un error en registrarVisita:\n"
                    + err.getMessage(), "Error en VistaImplementacion", JOptionPane.ERROR_MESSAGE);
        }
        return afectadas;
    }

    @Override
    public int actualizarVisita(Visita visita) {
        int afectadas = -1;
        try{
            this.conectar();
            PreparedStatement consulta = this.conexion.prepareStatement("UPDATE visita SET "
                    + "vis_fecha_ingreso = ?, "
                    + "vis_fecha_salida = ?, "
                    + "vis_diagnostico = ?, "
                    + "id_paciente =  ? "
                    + "WHERE id_visita = ?");
            java.time.Instant instante = visita.getVis_fecha_ingreso().toInstant();
            java.time.LocalDate localDate = instante.atZone(ZoneId.systemDefault()).toLocalDate();
            java.sql.Date sqlDateIngreso = java.sql.Date.valueOf(localDate);
            consulta.setDate(1, sqlDateIngreso);
            
            java.time.Instant instanteE = visita.getVis_fecha_ingreso().toInstant();
            java.time.LocalDate localDateE = instanteE.atZone(ZoneId.systemDefault()).toLocalDate();
            java.sql.Date sqlDateEgreso = java.sql.Date.valueOf(localDateE);
            consulta.setDate(2, sqlDateEgreso);
            
            consulta.setString(3,visita.getVis_diagnostico());
            consulta.setInt(4, visita.getId_paciente());
            consulta.setInt(5,visita.getId_visita());
            afectadas = consulta.executeUpdate();
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Se ha producido un error en actualizarVisita:\n"
                    + err.getMessage(), "Error en VistaImplementacion", JOptionPane.ERROR_MESSAGE);
        }
        return afectadas;
    }

    @Override
    public int eliminarVisita(int id_Visita) {
        int afectadas = -1;
        try{
            this.conectar();
            PreparedStatement consulta = this.conexion.prepareStatement("DELETE FROM visita WHERE id_visita = ?");
            consulta.setInt(1, id_Visita);
            afectadas = consulta.executeUpdate();
        }catch(SQLException err){
            JOptionPane.showMessageDialog(null, "Se ha producido un error en eliminarVisita:\n"
                    + err.getMessage(), "Error en VistaImplementacion", JOptionPane.ERROR_MESSAGE);
        }
        return afectadas;
    }

    @Override
    public DefaultTableModel recuperarVisitas(int filtro, String criterio, int orden) {
        //CONFIGURACION DE LA CONSULTA RESPECTO A FILTROS, CRITERIOS Y ORDEN
        String columnaAFiltrar = " ";
        switch (filtro) {
            case 0 ->
                columnaAFiltrar = " Identificador ";
            case 1 ->
                columnaAFiltrar = " Fecha_Ingreso ";
            case 2 ->
                columnaAFiltrar = " Fecha_Salida ";
            case 3 ->
                columnaAFiltrar = " Diagnostico ";
            case 4 ->
                columnaAFiltrar = " Nombre_Paciente ";
        }
        String where = " WHERE " + columnaAFiltrar + " LIKE " + "'" + criterio + "%'";
        String ordenS = orden == 0 ? " ASC " : " DESC ";
        String consultaCompleta = "SELECT * FROM formatoTablaVisita" + where
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
                Object[] datosVistas = new Object[columnCount];
                //Se meten los datos en el array de objetos
                for (int i = 0; i < columnCount; i++) {
                    datosVistas[i] = registrosRecientes.getObject(i + 1);
                }
                //Se inserta la fila en el DefaultTableModel
                modeloTabla.addRow(datosVistas);
            }
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Se ha producido un error en recuperarVisitas, el error es:\n"
                    + err.getMessage(),"Error en VistaImplementacion",JOptionPane.ERROR_MESSAGE);
        }
        return modeloTabla;
    }

    @Override
    public int recuperarUltimo() {
        int id = -1;
        try{
            this.conectar();
            PreparedStatement consulta = this.conexion.prepareStatement("SELECT MAX(Identificador) FROM formatoTablaVisita ");
            ResultSet resultados = consulta.executeQuery();
            while(resultados.next()){
                id = resultados.getInt(1);
            }
        }catch(SQLException err){
            JOptionPane.showMessageDialog(null,
                    "Se ha producido un error en recuperarUltimo\n"
                            + err.getMessage(),"Error en VisitaImplementacion",
                            JOptionPane.ERROR_MESSAGE);
        }
        return id+1;
    }

    @Override
    public ArrayList<String> recuperarNombresPacientes() {
        ArrayList<String> nombresPacientes = new ArrayList<String>();
        try{
            this.conectar();
            PreparedStatement consulta = this.conexion.prepareStatement("SELECT DISTINCT Nombre_Paciente FROM formatoTablaVisita ORDER BY Nombre_Paciente ASC");
            ResultSet resultados = consulta.executeQuery();
            while(resultados.next()){
                nombresPacientes.add(resultados.getString(1));
            }
        }catch(SQLException err){
            JOptionPane.showMessageDialog(null,
                    "Se ha producido un error en recuperarNombresPacientes\n"
                            + err.getMessage(),"Error en VisitaImplementacion",
                            JOptionPane.ERROR_MESSAGE);
        }
        
        return nombresPacientes;
    }

    @Override
    public int obtenerId(String nombre) {
        int id =-1;
        try{
            this.conectar();
            PreparedStatement consulta = this.conexion.prepareStatement("SELECT paciente.id_paciente FROM paciente WHERE paciente.pac_nombre = ?");
            consulta.setString(1, nombre);
            ResultSet resultado = consulta.executeQuery();
            while(resultado.next()){
                id = resultado.getInt(1);
            }
        }catch(SQLException err){
            JOptionPane.showMessageDialog(null,
                    "Se ha producido un error en obtenerId\n"
                            + err.getMessage(),"Error en VisitaImplementacion",
                            JOptionPane.ERROR_MESSAGE);
        }
        return id;
    }

    @Override
    public String obtenerNombre(int id) {
        String nombre = "INICIALIZADA";
        try{
            this.conectar();
            PreparedStatement consulta = this.conexion.prepareStatement("SELECT paciente.pac_nombre FROM paciente WHERE paciente.id_paciente = ?");
            consulta.setInt(1, id);
            ResultSet resultado = consulta.executeQuery();
            while(resultado.next()){
                nombre = resultado.getString(1);
            }
        }catch(SQLException err){
            JOptionPane.showMessageDialog(null,
                    "Se ha producido un error en obtenerId\n"
                            + err.getMessage(),"Error en VisitaImplementacion",
                            JOptionPane.ERROR_MESSAGE);
        }
        return nombre;
    }
    
}
