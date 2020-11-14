/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import Config.Conexion;
import Modelo.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class ProductoDAO{
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Producto p=new Producto();
    
   
    public List listar() {
        ArrayList<Producto>list=new ArrayList<>();
        String sql="select * from productos;";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Producto per=new Producto();
                per.setId(rs.getInt("id"));
                per.setNombre(rs.getString("nombre"));
                per.setDescripcion(rs.getString("descripcion"));
                per.setProveedor(rs.getString("proveedor"));
                per.setPrecioAlCont(rs.getFloat("precioalCont"));
                per.setPrecioAlCredito(rs.getFloat("precioalCredito"));
                per.setExistencias(rs.getInt("existencias"));
                list.add(per);
            }
        } catch (SQLException e) {
        }
        return list;
    }

    
    public Producto list(int id) {
        String sql="select * from productos where Id="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){                
                p.setId(rs.getInt("id"));
                p.setNombre(rs.getString("nombre"));
                p.setDescripcion(rs.getString("descripcion"));
                p.setProveedor(rs.getString("proveedor"));
                p.setPrecioAlCont(rs.getFloat("precioalCont"));
                p.setPrecioAlCredito(rs.getFloat("precioalCredito"));
                p.setExistencias(rs.getInt("existencias"));
            }
        } catch (SQLException e) {
        }
        return p;
    }

    public boolean add(Producto per) {
       String sql="insert into productos(nombre,descripcion,proveedor,precioAlCont,precioAlCredito,existencias)values('"+per.getNombre()+"','"+per.getDescripcion()+"','"+per.getProveedor()+"','"+per.getPrecioAlCont()+"',"+per.getPrecioAlCredito()+",'"+per.getExistencias()+"');";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
        }
       return false;
    }


    public boolean edit(Producto per) {
        String sql="update productos set nombre='"+per.getNombre()+"',descripcion='"+per.getDescripcion()+"',proveedor='"+per.getProveedor()+"',precioAlCont='"+per.getPrecioAlCont()+"',precioAlCredito='"+per.getPrecioAlCredito()+"',existencias='"+per.getExistencias()+"' Where id='"+per.getId()+"';";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
        }
        return false;
    }

    
    public boolean eliminar(int id) {
        String sql="delete from productos where Id="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
        }
        return false;
    }
    
}

