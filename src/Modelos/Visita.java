package Modelos;


import java.util.Date;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author edwin-993
 */
public class Visita {
    int id_visita;
    Date vis_fecha_ingreso;
    Date vis_fecha_salida;
    String vis_diagnostico;
    int id_paciente;
    String pac_nombre;

    public Visita(int id_visita, Date vis_fecha_ingreso, Date vis_fecha_salida, String vis_diagnostico, int id_paciente, String pac_nombre) {
        this.id_visita = id_visita;
        this.vis_fecha_ingreso = vis_fecha_ingreso;
        this.vis_fecha_salida = vis_fecha_salida;
        this.vis_diagnostico = vis_diagnostico;
        this.id_paciente = id_paciente;
        this.pac_nombre = pac_nombre;
    }

    @Override
    public String toString() {
        return "Visita{" + "id_visita=" + id_visita + ", vis_fecha_ingreso=" + vis_fecha_ingreso + ", vis_fecha_salida=" + vis_fecha_salida + ", vis_diagnostico=" + vis_diagnostico + ", id_paciente=" + id_paciente + ", pac_nombre=" + pac_nombre + '}';
    }
    

    public int getId_visita() {
        return id_visita;
    }

    public void setId_visita(int id_visita) {
        this.id_visita = id_visita;
    }

    public Date getVis_fecha_ingreso() {
        return vis_fecha_ingreso;
    }

    public void setVis_fecha_ingreso(Date vis_fecha_ingreso) {
        this.vis_fecha_ingreso = vis_fecha_ingreso;
    }

    public Date getVis_fecha_salida() {
        return vis_fecha_salida;
    }

    public void setVis_fecha_salida(Date vis_fecha_salida) {
        this.vis_fecha_salida = vis_fecha_salida;
    }

    public String getVis_diagnostico() {
        return vis_diagnostico;
    }

    public void setVis_diagnostico(String vis_diagnostico) {
        this.vis_diagnostico = vis_diagnostico;
    }

    public int getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(int id_paciente) {
        this.id_paciente = id_paciente;
    }

    public String getPac_nombre() {
        return pac_nombre;
    }

    public void setPac_nombre(String pac_nombre) {
        this.pac_nombre = pac_nombre;
    }
    
    
}
