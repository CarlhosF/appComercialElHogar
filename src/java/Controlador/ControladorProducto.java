
package Controlador;

import Modelo.Producto;
import Modelo.Usuario;
import ModeloDAO.ProductoDAO;
import ModeloDAO.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ControladorProducto extends HttpServlet {

    String listarProductos="vistas/listarProductos.jsp";
    String addProductos="vistas/addProducto.jsp";
    String editProductos="vistas/editProducto.jsp";
    String menu="menu.jsp";
    String listarUsuarios="vistas/listarUsuarios.jsp";
    String addUsuario="vistas/addUsuarios.jsp";
    String editUsuario="vistas/editUsuario.jsp";
    Producto p=new Producto();
    ProductoDAO dao=new ProductoDAO();
    Usuario u=new Usuario();
    UsuarioDAO udao= new UsuarioDAO();
    int id;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controlador</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>COntrolador 2  at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acceso="";
        String action=request.getParameter("accion");
        if(action.equalsIgnoreCase("listarProducto")){
            acceso=listarProductos;            
        }else if(action.equalsIgnoreCase("menu")){
            acceso=menu;
        }else if(action.equalsIgnoreCase("addProducto")){
            acceso=addProductos;
        }
        else if(action.equalsIgnoreCase("menu")){
            acceso="menu.html";
        }
        else if(action.equalsIgnoreCase("AgregarProducto")){
            String nom=request.getParameter("txtnom");
            String des=request.getParameter("txtdes");
            String prov=request.getParameter("txtprov");
            String palCont=request.getParameter("txtpalCont");
            String palCre=request.getParameter("txtpalCre");
            String exs=request.getParameter("txtexs");
            p.setNombre(nom);
            p.setDescripcion(des);
            p.setProveedor(prov);
            p.setPrecioAlCont(Float.parseFloat(palCont));
            p.setPrecioAlCredito(Float.parseFloat(palCre));
            p.setExistencias(Integer.parseInt(exs));
            dao.add(p);
            acceso=listarProductos;
        }
        else if(action.equalsIgnoreCase("editarProducto")){
            request.setAttribute("idpro",request.getParameter("id"));
            acceso=editProductos;
        }
        else if(action.equalsIgnoreCase("ActualizarProducto")){
            id=Integer.parseInt(request.getParameter("txtid"));
            String nom=request.getParameter("txtnom");
            String des=request.getParameter("txtdes");
            String prov=request.getParameter("txtprov");
            String palCont=request.getParameter("txtpalCont");
            String palCre=request.getParameter("txtpalCre");
            String exs=request.getParameter("txtexs");
            p.setId(id);
            p.setNombre(nom);
            p.setDescripcion(des);
            p.setProveedor(prov);
            p.setPrecioAlCont(Float.parseFloat(palCont));
            p.setPrecioAlCredito(Float.parseFloat(palCre));
            p.setExistencias(Integer.parseInt(exs));
            dao.edit(p);
            acceso=listarProductos;
        }
        else if(action.equalsIgnoreCase("eliminarProducto")){
           id=Integer.parseInt(request.getParameter("id"));
            p.setId(id);
            dao.eliminar(id);
            acceso=listarProductos;
        }
        RequestDispatcher vista=request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
