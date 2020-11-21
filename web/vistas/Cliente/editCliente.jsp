<%-- 
    Document   : editCliente
    Created on : 10-nov-2020, 23:24:26
    Author     : LisetSaldana
--%>

<%@page import="Modelo.Cliente"%>
<%@page import="ModeloDAO.ClienteDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>Editar Cliente</title>
    </head>
    <body>
        <div class="container">
            <div class="col-lg-6">
              <%
              ClienteDAO dao=new ClienteDAO();
              int id=Integer.parseInt((String)request.getAttribute("idcl"));
              Cliente c=(Cliente)dao.list(id);
          %>
            <h1>Modificar Cliente</h1>
            <form action="ClienteControlador">
                    <label for="nom">NOMBRES:</label><br>
                    <input class="form-control" type="text" name="nom" value="<%= c.getNombres()%>"><br>
                    <label for="ape">APELLIDOS:</label> <br>
                    <input class="form-control" type="text" name="ape" value="<%= c.getApellidos()%>"><br>
                    <label for="dui">DUI:</label> <br>
                    <input class="form-control" type="text" name="dui" value="<%= c.getDui()%>"><br>
                    <label for="dir">DIRECCION:</label> <br>
                    <input class="form-control" type="text" name="dir" value="<%= c.getDireccion()%>"><br>
                    <label for="tel">TELEFONO:</label> <br>
                    <input class="form-control" type="text" name="tel" value="<%= c.getTelefono()%>"><br>
                <input type="hidden" name="id" value="<%= c.getId()%>">
                <input class="btn btn-primary" type="submit" name="accion" value="Actualizarcliente"> 
                <a href="ClienteControlador?accion=listarCliente">Regresar</a>
            </form>
          </div>
          
        </div>
    </body>
</html>