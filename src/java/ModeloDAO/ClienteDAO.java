/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import Config.Conexion;
import Modelo.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author LisetSaldana
 */
public class ClienteDAO {
    Conexion cn = new Conexion ();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Cliente c = new Cliente();
    
    public List listar(){
      ArrayList<Cliente>list = new ArrayList<>();
      String sql = "select * from clientes;";
       try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            while(rs.next()){
                Cliente cl=new Cliente();
                cl.setId(rs.getInt("id"));
                cl.setNombres(rs.getString("Nombres"));
                cl.setApellidos(rs.getString("Apellidos"));
                cl.setDui(rs.getString("DUI"));
                cl.setDireccion(rs.getString("Direccion"));
                cl.setTelefono(rs.getString("Telefono"));
                list.add(cl);
            }
        } catch (SQLException e) {
        }
        return list;
    }
    
    public Cliente list(int id){
        String sql="select * from clientes where Id="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            while(rs.next()){
                c.setId(rs.getInt("id"));
                c.setNombres(rs.getString("Nombres"));
                c.setApellidos(rs.getString("Apellidos"));
                c.setDui(rs.getString("DUI"));
                c.setDireccion(rs.getString("Direccion"));
                c.setTelefono(rs.getString("Telefono"));
            }
            
        }catch (SQLException e){    
        }
        return c;
        
    }
    
     public boolean add(Cliente cl) {
       String sql="insert into clientes(nombres,apellidos,dui,direccion,telefono)values('"+cl.getNombres()+"','"+cl.getApellidos()+"','"+cl.getDui()+"','"+cl.getDireccion()+"','"+cl.getTelefono()+"');";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
        }
       return false;
    }


    public boolean edit(Cliente cl) {
        String sql="update clientes set nombres='"+cl.getNombres()+"',apellidos='"+cl.getApellidos()+"',dui='"+cl.getDui()+"',direccion='"+cl.getDireccion()+"',telefono='"+cl.getTelefono()+"' Where id='"+cl.getId()+"';";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
        }
        return false;
    }
    
    public boolean eliminar(int id) {
        String sql="delete from clientes where Id="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
        }
        return false;
    }
}
