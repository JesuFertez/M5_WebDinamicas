<%@page import="model.Usuario"%>
<% //Se obtiene la sesion desde el request en el navbar ya que ahi se encuentran los link de navegacion
	HttpSession sesion = request.getSession();
	String nombreUsuario = (String)sesion.getAttribute("usuario");
	// aca se crea la variable ingreso que controla si se ingreso us y ps
	boolean ingreso = false;
	if(sesion.getAttribute("ingreso") != null) {
		ingreso = (boolean) sesion.getAttribute("ingreso");	
	}
%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@page import="model.Usuario"%>
<head>
	<link rel="stylesheet" href="../css/estilos.css">
</head>
<header>
<nav class="navbar bg-dark  navbar-expand-lg bg-body-tertiary " data-bs-theme="dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">WebDinámica</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" 
    	aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
      <div class="navbar-nav">
        <a class="nav-link active" aria-current="page" href="Inicio">Inicio</a>      
        <% if(ingreso) { %>
        	<a class="nav-link" href="Contacto">Contacto</a>
	         <div class="nav-item dropdown">
	           	<a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
	           		Crear
	           	</a>
	           	<ul class="dropdown-menu">
	            	 <li><a class="nav-link" href="CrearCapacitacion">Crear Capacitación</a></li>
	            	 <li><a class="nav-link" href="CrearUsuario">Crear Usuario</a></li>
	           	</ul>
	         </div>
	         <div class="nav-item dropdown">
	           	<a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
	           		Listar
	           	</a>
	           	<ul class="dropdown-menu">
	            	 <li><a class="dropdown-item"  href="ListarCapacitaciones">Listar Capacitaciones</a></li>
	            	 <li><a class="dropdown-item"  href="ListadoUsuarios">Listar Usuarios</a></li>
	           	</ul>
	         </div>
        <% } else { %>
        <a class="nav-link" href="Login">Login</a>
        <% } %>
         <% if(ingreso) { %>
         <div class="vr"></div>
         <div class="nav-item dropdown">
           	<a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            	Usuario <%=nombreUsuario %>
           	</a>
           	<ul class="dropdown-menu">
            	 <li><a class="dropdown-item" href="CerrarSession">Cerrar Sesión</a></li>
           	</ul>
         </div>
        <% } %>
      </div>
    </div>
  </div>
</nav>
</header>