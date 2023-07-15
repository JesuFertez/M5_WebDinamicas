<%@page import="model.Usuario"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@page import="model.Usuario"%>
<head>
	<!-- CSS PROPIO -->
	<link rel="stylesheet" href="../css/estilos.css">
	<!-- Iconos Bootstrap -->
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
</head>
<header>
<!-- Variables JSTL -->
<c:set var="nombreUsuario" value="${sessionScope.usuario}" />
<c:set var="ingreso" value="${not empty sessionScope.ingreso and sessionScope.ingreso}" />

<!-- Navbar del sitio -->
<nav class="navbar bg-dark  navbar-expand-lg bg-body-tertiary " data-bs-theme="dark">
  <div class="container-fluid">	
	<!-- Logo y nombre del sitio -->
    <a class="navbar-brand" href="#">
	    <i class="bi bi-fan"></i>
	    <span class="text-ligth">WebDinámica</span>
	</a>
	<!-- boton del menu  -->
    <button class="navbar-toggler" type="button" 
    	data-bs-toggle="collapse" data-bs-target="#menu" 
    	aria-controls="navbarNavAltMarkup" aria-expanded="false" 
    	aria-label="Toggle navigation">
     	<span class="navbar-toggler-icon"></span>
    </button>
    <!-- elementos del menu colapsable -->
    <div class="collapse navbar-collapse" id="menu">
	    <ul class="navbar-nav me-auto">
	    	<li class="nav-item ms-2">
	    		<a class="nav-link ${navItem == 'Inicio' ? 'active' : ''}" href="Inicio">
	    		<i class="bi bi-house"></i>   Inicio</a>
	    	</li>
	    	<!-- Elementos disponibles solo cuando exista una sesion iniciada -->
	    	<c:choose>
	    	  <c:when test="${ingreso}">
		    	<li class="nav-item ms-2">
		    		<a class="nav-link ${navItem == 'Contacto' ? 'active' : ''}" href="Contacto">
		    		<i class="bi bi-envelope-at"></i>   Contacto</a>
		    	</li>
		    	<li class="nav-item dropdown ms-2">
		    		<a class="nav-link dropdown-toggle ${navItem == 'Crear' ? 'active' : ''}"
		    		id="navbarDropdown" role="button" data-bs-toggle="dropdown"  href="#">
		    		<i class="bi bi-plus-circle"></i>
		    		   Crear ${navText == 'Capacitacion' ? 'Capacitación': ''}
		    		   		 ${navText == 'Usuario' ? 'Usuario': ''}</a>
		           	<ul class="dropdown-menu bg-dark">
		            	 <li>
		            		 <a class="dropdown-item" href="CrearCapacitacion">
		            		 <i class="bi bi-file-plus"></i>  Crear Capacitación</a>
		            	 </li>
		            	 <li>
			            	 <a class="dropdown-item" href="CrearUsuario">
			            	 <i class="bi bi-person-plus"></i>  Crear Usuario</a>
		            	 </li>		            	 		            	
		           	</ul>
		    	</li>
		    	<li class="nav-item dropdown ms-2">
		    		<a class="nav-link dropdown-toggle ${navItem == 'Listar' ? 'active' : ''}"
		    		id="navbarDropdown" role="button" data-bs-toggle="dropdown"  href="#">
		    		<i class="bi bi-card-list"></i>
		    		   Listar ${navText == 'Capacitaciones' ? 'Capacitaciones' : ''}
		    		   		 ${navText == 'Usuarios' ? 'Usuarios': ''}
		    		   		 ${navText == 'Clientes' ? 'Clientes': ''}
		    		   		 ${navText == 'Profesionales' ? 'Profesionales': ''}
		    		   		 ${navText == 'Administrativos' ? 'Administrativos': ''}</a>
		           	<ul class="dropdown-menu bg-dark">
		            	 <li>
		            	 	<a class="dropdown-item" href="ListarCapacitaciones">
		            	 	<i class="bi bi-files"></i>  Listar Capacitaciones</a>
		            	 </li>
		            	 <li>
		            	 	<a class="dropdown-item" href="ListadoUsuarios">
		            	 	<i class="bi bi-people"></i>  Listar Usuarios</a>
		            	 </li>
		            	 <li>
		            	 	<a class="dropdown-item" href="ListarPorTipoUsuario?accion=listarCliente">
		            	 	<i class="bi bi-people"></i>  Listar Clientes</a>
		            	 </li>
		            	  <li>
		            	 	<a class="dropdown-item" href="ListarPorTipoUsuario?accion=listarPresional">
		            	 	<i class="bi bi-people"></i>  Listar Profesionales</a>
		            	 </li>
		            	  <li>
		            	 	<a class="dropdown-item" href="ListarPorTipoUsuario?accion=listarAdministrativo">
		            	 	<i class="bi bi-people"></i>  Listar Administrativos</a>
		            	 </li>
		           	</ul>
		    	</li>
		      </c:when>
		      <c:otherwise>
		      <!-- De otro modo, aparece la opcion de iniciar sesion -->
		    	<li class="nav-item">
		    		<a class="nav-link ${navItem == 'Login' ? 'active' : ''}" href="Login">
		    		<i class="bi bi-box-arrow-in-left ms-2"></i> Login</a>
		    	</li>
		      </c:otherwise>
	   		</c:choose>
	    </ul>
	    <ul class="navbar-nav flex-row flex-wrap text-light">
		    <c:if test="${ingreso}">
			<li class="nav-item dropdown">
				<a class="nav-link dropdown-toggle"
				id="navbarDropdown" role="button" data-bs-toggle="dropdown"  href="#">
					<i class="bi bi-person-circle"></i>   ${nombreUsuario}
				</a>
			    <ul class="dropdown-menu dropdown-menu-end bg-dark">
			    	<li>
			    		<a class="dropdown-item" href="CerrarSession">
			    		<i class="bi bi-box-arrow-right"></i>   Cerrar Sesión</a>
			    	</li>
			    </ul>
			</li>
			</c:if>
	    </ul>
      <!--  -->
    </div>
  </div>
</nav>
</header>