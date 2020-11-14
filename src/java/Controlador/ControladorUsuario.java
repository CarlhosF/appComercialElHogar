

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


public class ControladorUsuario extends HttpServlet {

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
      if(action.equalsIgnoreCase("listarUsuario")){
        acceso=listarUsuarios;
        }else if(action.equalsIgnoreCase("addUsuario")){
            acceso=addUsuario;
        }
        else if(action.equalsIgnoreCase("AgregarUsuario")){
            
            String nom=request.getParameter("dui");
            String des=request.getParameter("nom");
            String prov=request.getParameter("ape");
            String palCont=request.getParameter("rol");
            String palCre=request.getParameter("usu");
            String exs=request.getParameter("contra");
            
            u.setDui(nom);
            u.setNombre(des);
            u.setApellido(prov);
            u.setRol(Integer.parseInt(palCont));
            u.setUsuario((palCre));
            u.setContrasena(exs);
            udao.add(u);
            acceso=listarUsuarios;
        }else if(action.equalsIgnoreCase("eliminarUsuario")){
           id=Integer.parseInt(request.getParameter("id"));
            u.setId(id);
            udao.eliminar(id);
            acceso=listarUsuarios;
        }else if(action.equalsIgnoreCase("editarUsuario")){
            request.setAttribute("idpro",request.getParameter("id"));
            acceso=editUsuario;
        }else if(action.equalsIgnoreCase("ActualizarUsuario")){
            
            id=Integer.parseInt(request.getParameter("txtid"));
            
            String nom=request.getParameter("dui");
            String des=request.getParameter("nom");
            String prov=request.getParameter("ape");
            String palCont=request.getParameter("rol");
            String palCre=request.getParameter("usu");
            String exs=request.getParameter("con");
            
            u.setId(id);
            u.setDui(nom);
            u.setNombre(des);
            u.setApellido(prov);
            u.setRol(Integer.parseInt(palCont));
            u.setUsuario((palCre));
            u.setContrasena(exs);
            
            udao.edit(u);
            acceso=listarUsuarios;
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
