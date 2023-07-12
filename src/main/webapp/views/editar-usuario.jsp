<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar Usuario</title>
<!-- CSS del proyecto -->
	<link rel="stylesheet" href="../css/estilos.css">
<!-- CSS Bootstrap -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
	crossorigin="anonymous">
</head>
<body>

<!-- Incluyendo navbar menu -->
	<c:set var="navItem" value="Modificar" /> <!-- Menu activo -->
	<c:set var="navText" value="Usuario"/> <!-- Texto Crear -->
	<%@ include file='navbar.jsp'%>

	
	<div class="container d-flex justify-content-center align-items-center mt-4">
	<!-- Formulario para modificar un usuario -->
		<div class="card" style="width: 50%;">
			<div class="card-header bg-dark text-white">
				<h2 class="card-title d-flex justify-content-center">Modificar Usuario</h2>
			</div>
			<div class="card-body">
				<form action="EditarCliente" class="row" method="post">
				  <div class="col-md-6 mb-3">
						<label for="nombre" class="form-label">Nombre</label>
						<input type="text" class="form-control" name="nombre" required>
				  </div>
				  <div class="col-md-6 mb-3">
						<label for="contraseña" class="form-label">Contraseña</label>
						<input type="text" class="form-control" name="contraseña" required>
				  </div>
					<div class="col-md-12 mb-3">
					    <label for="tipoLbl" class="form-label">Tipo</label>
					    <select class="form-control" name="tipo" required>
					        <option value="Cliente">Cliente</option>
					        <option value="Administrativo">Administrativo</option>
					        <option value="Profesional">Profesional</option>
					    </select>
					</div>
					
					<div class="col-md-12">
						<button type="submit" class="btn btn-secondary w-100 mt-4">Guardar cambios</button>
					</div>
				</form>
			</div>
		</div>
	</div>
<!-- JavaScript Bootstrap -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
		crossorigin="anonymous"></script>
</body>
</html>