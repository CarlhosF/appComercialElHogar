/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Usuario;
import ModeloDAO.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Usuario
 */
public class Validar extends HttpServlet {

    UsuarioDAO edao = new UsuarioDAO();
    Usuario em = new Usuario();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
           String accion = request.getParameter("accion");
        if (accion.equalsIgnoreCase("entrar")) {
            String user = request.getParameter("usuario");
            String pass = request.getParameter("password");
            em = edao.validar(user, pass);
            if (em.getUsuario()!= null) {
                request.setAttribute("usuario", em);
                request.setAttribute("nombre", em.getNombre());
                request.getRequestDispatcher("menu.jsp?nombre="+em.getNombre()).forward(request, response);
            } else {
              
              response.sendRedirect("http://localhost:20301/ComercialElHogar/index.jsp?error=contra");
            }
        } else {
            response.sendRedirect("http://localhost:20301/ComercialElHogar/index.jsp?error=usu");
        }
    }
    
    
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
