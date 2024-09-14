/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;
import Modelos.Visita;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author edwin-993
 */
public interface MetodosVisita {
    public int registrarVisita(Visita visita);
    public int actualizarVisita(Visita visita);
    public int eliminarVisita(int id_Visita);
    public DefaultTableModel recuperarVisitas(int filtro, String criterio, int orden);
    public int recuperarUltimo();
    public ArrayList<String> recuperarNombresPacientes();
    public int obtenerId(String nombre);
    public String obtenerNombre(int id);
}
