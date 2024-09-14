/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Modelos.Paciente;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author edwin-993
 */
public interface MetodosPaciente {
    public int registrarPaciente(Paciente paciente) throws Exception;
    public int actualizarPaciente(Paciente paciente) throws Exception;
    public int eliminarPaciente(int id_paciente) throws Exception;
    public DefaultTableModel recuperarPacientes(int filtro, String criterio, int orden) throws Exception;
    public int recuperarUltimo() throws Exception;
}
