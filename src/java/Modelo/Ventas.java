/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import Modelo.Cliente;
import Modelo.Usuario;
import Modelo.DetallesVentas;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class Ventas {
     int id;
     Cliente cliente;
     Usuario usuario;
     Date fecha;
     String FormadePago;
     List<DetallesVentas> Lista;
     public Ventas(){
     
     }
     public Ventas(int i, Cliente c, Usuario u, Date f,String Fp)
     {
         this.id=i;
         this.cliente=c;
         this.usuario=u;
         this.fecha=f;
         this.FormadePago=Fp;
     }
     
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getFormadePago() {
        return FormadePago;
    }

    public void setFormadePago(String FormadePago) {
        this.FormadePago = FormadePago;
    }
    
    public List<DetallesVentas> getLista() {
        return Lista;
    }

    public void setLista(List<DetallesVentas> Lista) {
        this.Lista = Lista;
    }
    
    
}
