/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import Config.Conexion; 
import java.sql.*;
import Modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Figueroa
 */
public class UsuarioDAO{
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Usuario p=new Usuario();
   
     public Usuario validar(String user, String dni) {
        Usuario em = new Usuario();
        String sql = "select * from usuarios where usuario=? and Contrasena=?";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, dni);
            rs = ps.executeQuery();
            while (rs.next()) {
                em.setId(rs.getInt("id"));
                em.setDui(rs.getString("DUI"));
                em.setNombre(rs.getString("nombre"));
                em.setApellido(rs.getString("apellido"));
                em.setRol(rs.getInt("rol"));
                em.setUsuario(rs.getString("usuario"));
                em.setContrasena(rs.getString("contrasena"));
            }
        } catch (Exception e) {
        }
        return em;
    }
   
    public List listar() {
        ArrayList<Usuario>list=new ArrayList<>();
        String sql="SELECT * from usuarios";
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            while(rs.next()){
                Usuario per=new Usuario();
                per.setId(rs.getInt("id"));
                per.setDui(rs.getString("DUI"));
                per.setNombre(rs.getString("nombre"));
                per.setApellido(rs.getString("apellido"));
                per.setRol(rs.getInt("rol"));
                per.setUsuario(rs.getString("usuario"));
                per.setContrasena(rs.getString("contrasena"));
                list.add(per);
            }
        } catch (SQLException e) {
        }
        return list;
    }

    
    public Usuario list(int id) {
        String sql="select * from usuarios where id="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){                
               p.setId(rs.getInt("id"));
               p.setNombre(rs.getString("nombre"));
               p.setApellido(rs.getString("apellido"));
               p.setDui(rs.getString("dui"));
               p.setRol(rs.getInt("rol"));
               p.setUsuario(rs.getString("usuario"));
               p.setContrasena(rs.getString("contrasena"));
            }
        } catch (SQLException e) {
        }
        return p;
    }

    public boolean add(Usuario per) {
       String sql="insert into usuarios(DUI,nombre,apellido,rol,usuario,contrasena)values('"+per.getDui()+"','"+per.getNombre()+"','"+per.getApellido()+"','"+per.getRol()+"','"+per.getUsuario()+"','"+per.getContrasena()+"');";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
        }
       return false;
    }


    public boolean edit(Usuario per) {
        String sql="update usuarios set nombre='"+per.getNombre()+"',apellido='"+per.getApellido()+"',dui='"+per.getDui()+"',rol='"+per.getRol()+"',usuario='"+per.getUsuario()+"',contrasena='"+per.getContrasena()+"' Where id='"+per.getId()+"';";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
        }
        return false;
    }

    
    public boolean eliminar(int id) {
        String sql="delete from usuarios where Id="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
        }
        return false;
    }
    
}

