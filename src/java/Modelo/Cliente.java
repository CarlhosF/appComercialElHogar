/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author LisetSaldana
 */
public class Cliente {

    

    int id;
    String nombres;
    String apellidos;
    String dui;
    String direccion;
    String telefono;
    
    public Cliente() {
    }

    public Cliente(int id, String nom, String ape, String dui, String dir, String tel) {
        this.id = id;
        this.nombres = nom;
        this.apellidos = ape;
        this.dui = dui;
        this.direccion = dir;
        this.telefono = tel;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getId() {
        return id;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getDui() {
        return dui;
    }
    
    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }
}


