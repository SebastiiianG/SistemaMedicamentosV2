/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

/**
 *
 * @author edwin-993
 */
public class Paciente {
    private int id_paciente;
    private int pac_nss;
    private String pac_nombre;
    private int pac_edad;
    private float pac_altura;

    public Paciente(int id_paciente, int pac_nss, String pac_nombre, int pac_edad, float pac_altura) {
        this.id_paciente = id_paciente;
        this.pac_nss = pac_nss;
        this.pac_nombre = pac_nombre;
        this.pac_edad = pac_edad;
        this.pac_altura = pac_altura;
    }

    public int getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(int id_paciente) {
        this.id_paciente = id_paciente;
    }

    public int getPac_nss() {
        return pac_nss;
    }

    public void setPac_nss(int pac_nss) {
        this.pac_nss = pac_nss;
    }

    public String getPac_nombre() {
        return pac_nombre;
    }

    public void setPac_nombre(String pac_nombre) {
        this.pac_nombre = pac_nombre;
    }

    public int getPac_edad() {
        return pac_edad;
    }

    public void setPac_edad(int pac_edad) {
        this.pac_edad = pac_edad;
    }

    public float getPac_altura() {
        return pac_altura;
    }

    public void setPac_altura(float pac_altura) {
        this.pac_altura = pac_altura;
    }
    
    
    
    
}
