/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Usuario
 */
public class Producto {
    int id;
    String nombre;
    String descripcion;
    String proveedor;
    float precioAlCont;
    float precioAlCredito;
    int existencias;

   
     public Producto() {
    }

    public Producto(String nom, String des, String prov, float pAlCon, float pAlCre ) {
        
        this.nombre = nom;
        this.descripcion = des;
        this.proveedor=prov;
        this.precioAlCont=pAlCon;
        this.precioAlCredito=pAlCre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public float getPrecioAlCont() {
        return precioAlCont;
    }

    public void setPrecioAlCont(float pecioAlCont) {
        this.precioAlCont = pecioAlCont;
    }

    public float getPrecioAlCredito() {
        return precioAlCredito;
    }

    public void setPrecioAlCredito(float precioAlCredito) {
        this.precioAlCredito = precioAlCredito;
    }
     public int getExistencias() {
        return existencias;
    }

    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }
    
    
   

}
