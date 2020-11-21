

package Controlador;

import Modelo.Cliente;
import Modelo.Producto;
import Modelo.Usuario;
import ModeloDAO.ClienteDAO;
import ModeloDAO.ProductoDAO;
import ModeloDAO.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ClienteControlador extends HttpServlet {

  
    String menu="menu.html";
    String listarClientes="vistas/Cliente/listarClientes.jsp";
    String addClientes="vistas/Cliente/addCliente.jsp";
    String editClientes="vistas/Cliente/editCliente.jsp";
    Producto p=new Producto();
    ProductoDAO dao=new ProductoDAO();
    Usuario u=new Usuario();
    UsuarioDAO udao= new UsuarioDAO();
    Cliente c = new Cliente();
    ClienteDAO cdao = new ClienteDAO();
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
        if(action.equalsIgnoreCase("listarCliente")){
            acceso=listarClientes;            
        }else if(action.equalsIgnoreCase("menu"))
        {
                acceso=menu;
        }
        else if(action.equalsIgnoreCase("addCliente")){
            acceso=addClientes;
        }
        else if(action.equalsIgnoreCase("AgregarCliente")){
            
            String nom=request.getParameter("nom");
            String ape=request.getParameter("ape");
            String dui=request.getParameter("dui");
            String dir=request.getParameter("dir");
            String tel=request.getParameter("tel");
            
            c.setNombres(nom);
            c.setApellidos(ape);
            c.setDui(dui);
            c.setDireccion(dir);
            c.setTelefono(tel);
            cdao.add(c);
            acceso=listarClientes;
        }
        else if(action.equalsIgnoreCase("editarCliente")){
            request.setAttribute("idcl",request.getParameter("id"));
            acceso=editClientes;
        }
        else if(action.equalsIgnoreCase("ActualizarCliente")){
            
            id=Integer.parseInt(request.getParameter("id"));
            
            String nom=request.getParameter("nom");
            String ape=request.getParameter("ape");
            String dui=request.getParameter("dui");
            String dir=request.getParameter("dir");
            String tel=request.getParameter("tel");
            
            c.setId(id);
            c.setNombres(nom);
            c.setApellidos(ape);
            c.setDui(dui);
            c.setDireccion(dir);
            c.setTelefono(tel);
            
            cdao.edit(c);
            acceso=listarClientes;
        }
        else if(action.equalsIgnoreCase("eliminarCliente")){
           id=Integer.parseInt(request.getParameter("id"));
            c.setId(id);
            cdao.eliminar(id);
            acceso=listarClientes;
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
