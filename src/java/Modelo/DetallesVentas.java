/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import Modelo.Ventas;
import Modelo.Producto;
import java.util.Date;

/**
 *
 * @author Usuario
 */
public class DetallesVentas {
    
    int id;
    Ventas venta;
    Producto producto;
    int Cantidad;
    
     public DetallesVentas()
    {
    
    }
    public DetallesVentas(int i, Ventas v, Producto p, int c)
    {
        this.id=i;
        this.venta=v;
        this.producto=p;
        this.Cantidad=c;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Ventas getVenta() {
        return venta;
    }

    public void setVenta(Ventas venta) {
        this.venta = venta;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }
    
   
    
}
