<!DOCTYPE html>


<html lang="en">

<head>
	<meta charset="UTF-8">
	<title>longin</title>
	 <link rel="stylesheet" type="text/css" href="css/materialize.css">
   <link rel="stylesheet" type="text/css" href="css/jquery.mobile-1.4.5.min.css">
	<link rel="stylesheet" type="text/css" href="style.css">
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
</head>
<body>
<div class="navbar-fixed">

	<nav class="light-blue lighten-1">   
		<div class="nav-wrapper">
			<a href="#a" class="brand-logo right center black-text">Comercial el Hogar</a>

			 
		</div>
		</nav> 
</div>

<div class="container">
<div class="row">
    <div class="col m6 ">
     
<br>
<br>
<br>

    <h4>Iniciar Sesión</h4>
   
      <form method="post" action="Validar?accion=entrar">

      	<div class="row">
         
          <div class="input-field col s9">
          <i class="material-icons prefix">perm_identity</i>
          <input name="usuario" type="text" class="validate" required title="Rellene este campo">
          <label for="icon_prefix">Nombre de usuario:</label>
        </div>
    </div>
    <div class="row">
        <div class="input-field col s9">
        	   <i class="material-icons prefix">vpn_key</i>
          <input name="password" type="password" class="validate" required title="Rellene este campo">
          <label for="password">Password:</label>
        </div>
        </div>
      <div class="row">
        <div class="col s6">
          
        
      	 <input type="submit" value="Iniciar seción" name="entrar" class="btn light-blue lighten-1">
         


</div>
      	
      </div>

      </form>
      
    </div>


    <div class="col s12 m6">
<br>

  

<div class="carousel carousel-slider">
  <a class="carousel-item" href="#one!"><img src="imagenes/images.jpeg"></a>
  <a class="carousel-item" href="#two!"><img src="imagenes/indice.png"> </a>
  <a class="carousel-item" href="#two!"><img src="imagenes/2.jpeg"> </a>
 
</div>
 



</div>
 



 



</div>
   </div>


<!--footer -->
      <footer class="page-footer  light-blue lighten-1">
          <div class="container">
            <div class="row">
              <div class="col l6 s12">
                <h5 class="#4A4A4A">Footer Content</h5>
                <p class="#4A4A4A text-lighten-4">You can use rows and columns here to organize your footer content.</p>
              </div>
              <div class="col l4 offset-l2 s12">
                <h5 class="#4A4A4A">Links</h5>
                <ul>
                  
                  <li><a class="black-text " href="#!">Link 2</a></li>
                  <li><a class="black-text " href="#!">Link 3</a></li>
                  <li><a class="black-text " href="#!">Link 4</a></li>
                </ul>
              </div>
            </div>
          </div>
          <div class="footer-copyright">
            <div class="container">
           <span class="#4A4A4A"> © 2020 Copyright Text</span> 
            <a class="white-text  right" href="#!">More Links</a>
            </div>
          </div>
        </footer>
  
  



<script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<script src="js/init.js"></script>
<script src="js/materialize.min.js"></script>
<script>
	$(document).ready(function(){
    M.AutoInit();
	
	
   

     $('.carousel.carousel-slider').carousel({
       fullWidth: true,
       
      
     
     
     
     });
     setInterval(function(){
$(".carousel").carousel("next");
}, 3000);
    
    });
	</script>
	<% 
    String lo = request.getParameter("error");
    
if((lo!=null))
{
    %> 
            <script> 
    alert('Constraseña ó Usuario Incorrecto');
    window.location.href='http://localhost:20301/ComercialElHogar/index.jsp';
            </script> 

        <%
}
%>


</body>
</html>