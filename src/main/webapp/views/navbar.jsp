<%@page import="model.Usuario"%>
<% //Se obtiene la sesion desde el request en el navbar ya que ahi se encuentran los link de navegacion
	HttpSession sesion = request.getSession();
	// aca se crea la variable ingreso que controla si se ingreso us y ps
	boolean ingreso = false;
	if(sesion.getAttribute("ingreso") != null) {
		ingreso = (boolean) sesion.getAttribute("ingreso");		
	}
%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@page import="model.Usuario"%>

<header>
<nav class="navbar bg-dark  navbar-expand-lg bg-body-tertiary " data-bs-theme="dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">WebDinámica</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
      <div class="navbar-nav">
        <a class="nav-link active" aria-current="page" href="Inicio">Inicio</a>      
        <% if(ingreso) { %>
        	<a class="nav-link" href="Contacto">Contacto</a>
        	<a class="nav-link" href="CrearCapacitacion">Crear Capacitación</a>
        	<a class="nav-link" href="ListarCapacitaciones">Listar Capacitaciones</a>
        <% } %>
        <a class="nav-link" href="Login">Login</a>
         <% if(ingreso) { %>
         <a style=text-align:right class="nav-link"  href="CerrarSession">Cerrar Sesión</a>
        <% } %>
      </div>
    </div>
  </div>
</nav>
</header>