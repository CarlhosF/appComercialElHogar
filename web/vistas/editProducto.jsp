
<%@page import="Modelo.Producto"%>
<%@page import="ModeloDAO.ProductoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>Editar Producto</title>
    </head>
    <body>
        <div class="container">
            <div class="col-lg-6">
              <%
              ProductoDAO dao=new ProductoDAO();
              int id=Integer.parseInt((String)request.getAttribute("idpro"));
              Producto p=(Producto)dao.list(id);
          %>
            <h1>Modificar Producto</h1>
            <form action="Controlador2">
                <label for="txtnom">NOMBRE:</label><br>
                    <input class="form-control" type="text" name="txtnom"><br>
                    <label for="txtdes">DESCRIPCION:</label> <br>
                    <input class="form-control" type="text" name="txtdes"><br>
                    <label for="txtprov">PROVEEDOR:</label> <br>
                    <input class="form-control" type="text" name="txtprov"><br>
                    <label for="txtpalCont">PRECIO AL CONTADO: </label> <br>
                    <input class="form-control" type="text" name="txtpalCont"><br>
                    <label for="txtpalCre">PRECIO AL CREDITO: </label> <br>
                    <input class="form-control" type="text" name="txtpalCre"><br>
                    <label for="txtexs">EXISTENCIAS: </label> <br>
                    <input class="form-control" type="text" name="txtexs"><br>
                <input type="hidden" name="txtid" value="<%= p.getId()%>">
                <input class="btn btn-primary" type="submit" name="accion" value="ActualizarProducto"> 
                <a href="Controlador2?accion=listarProducto">Regresar</a>
            </form>
          </div>
          
        </div>
    </body>
</html>
