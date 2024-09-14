/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Modelos.Medico;
import javax.swing.table.TableModel;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Edwin Campos
 */
public interface MetodosMedico {

    public int registrarMedico(Medico medico) throws Exception;

    public int actualizarMedico(Medico medico) throws Exception;

    public int eliminarMedico(int id_med) throws Exception;

    public Medico consultarMedico(int id_med) throws Exception;

    public DefaultTableModel recuperarMedicos(int filtro, String criterio, int orden) throws Exception;

    public int recuperarUltimo() throws Exception;
}
