/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

/**
 *
 * @author Edwin Campos
 */
public class Medico {

    private int id_medico;
    private String med_nombre;
    private String med_cedula;
    private String med_telefono;
    private String med_especialidad;
    private String med_direccion;

    public Medico(String med_nombre, String med_cedula, String med_telefono, String med_especialidad, String med_direccion) {
        this.med_nombre = med_nombre;
        this.med_cedula = med_cedula;
        this.med_telefono = med_telefono;
        this.med_especialidad = med_especialidad;
        this.med_direccion = med_direccion;
    }
    
    public Medico(int id_medico,String med_nombre, String med_cedula, String med_telefono, String med_especialidad, String med_direccion){
        this.id_medico = id_medico;
        this.med_nombre = med_nombre;
        this.med_cedula = med_cedula;
        this.med_telefono = med_telefono;
        this.med_especialidad = med_especialidad;
        this.med_direccion = med_direccion;
    }
    @Override
    public String toString() {
        return "Medico{" + "id_medico=" + id_medico + ", med_nombre=" + med_nombre + ", med_cedula=" + med_cedula + ", med_telefono=" + med_telefono + ", med_especialidad=" + med_especialidad + ", med_direccion=" + med_direccion + '}';
    }
    
    public Medico(){
        this.id_medico = 0;
        this.med_cedula = null;
        this.med_direccion = null;
        this.med_especialidad = null;
        this.med_nombre = null;
        this.med_telefono = null;
    }

    public int getId_medico() {
        return id_medico;
    }

    public void setId_medico(int id_medico) {
        this.id_medico = id_medico;
    }

    public String getMed_nombre() {
        return med_nombre;
    }

    public void setMed_nombre(String med_nombre) {
        this.med_nombre = med_nombre;
    }

    public String getMed_cedula() {
        return med_cedula;
    }

    public void setMed_cedula(String med_cedula) {
        this.med_cedula = med_cedula;
    }

    public String getMed_telefono() {
        return med_telefono;
    }

    public void setMed_telefono(String med_telefono) {
        this.med_telefono = med_telefono;
    }

    public String getMed_especialidad() {
        return med_especialidad;
    }

    public void setMed_especialidad(String med_especialidad) {
        this.med_especialidad = med_especialidad;
    }

    public String getMed_direccion() {
        return med_direccion;
    }

    public void setMed_direccion(String med_direccion) {
        this.med_direccion = med_direccion;
    }

}
