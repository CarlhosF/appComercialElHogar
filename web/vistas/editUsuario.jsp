

<%@page import="Modelo.Usuario"%>
<%@page import="ModeloDAO.UsuarioDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>Editar Usuario</title>
    </head>
    <body>
        <div class="container">
            <div class="col-lg-6">
              <%
              UsuarioDAO dao=new UsuarioDAO();
              int id=Integer.parseInt((String)request.getAttribute("idpro"));
              Usuario p=(Usuario)dao.list(id);
          %>
            <h1>Modificar Usuario</h1>
            <form action="Controlador2">
                <label for="txtnom">DUI:</label><br>
                    <input class="form-control" type="text" name="dui" value="<%= p.getDui()%>"><br>
                    <label for="txtdes">NOMBRE:</label> <br>
                    <input class="form-control" type="text" name="nom" value="<%= p.getNombre()%>"><br>
                    <label for="txtprov">APELLIDO:</label> <br>
                    <input class="form-control" type="text" name="ape" value="<%= p.getApellido()%>"><br>
                    <label for="txtpalCont">ROL:</label> <br>
                    <input class="form-control" type="text" name="rol" value="<%= p.getRol()%>"><br>
                    <label for="txtpalCre">USUARIO:</label> <br>
                    <input class="form-control" type="text" name="usu" value="<%= p.getUsuario()%>"><br>
                    <label for="txtexs">CONTRASEÑA:</label> <br>
                    <input class="form-control" type="text" name="con" value="<%= p.getContrasena()%>"><br>
                <input type="hidden" name="txtid" value="<%= p.getId()%>">
                <input class="btn btn-primary" type="submit" name="accion" value="ActualizarUsuario"> 
                <a href="Controlador2?accion=listarProducto">Regresar</a>
            </form>
          </div>
          
        </div>
    </body>
</html>
