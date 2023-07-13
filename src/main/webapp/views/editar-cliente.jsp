<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar Cliente</title>
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
	<c:set var="navItem" value="ModificarCliente" />
	<!-- Menu activo -->
	<c:set var="navText" value="Cliente" />
	<!-- Texto Crear -->
	<%@ include file='navbar.jsp'%>

	<div
		class="container d-flex justify-content-center align-items-center mt-4">
		<!-- Formulario para modificar un cliente -->
		<div class="card" style="width: 50%;">
			<div class="card-header bg-dark text-white">
				<h2 class="card-title d-flex justify-content-center">Modificar Cliente</h2>
			</div>
			
			<div class="card-body">
				<form action="EdicionClientes" class="row" method="post">
					<div class="col-md-4 mb-3">
						<label for="id" class="form-label">id</label> 
						<input type="text"value="${idCliente}" class="form-control" name="idCliente" readonly >
					</div>
					<div class="col-md-6 mb-3">
						<label for="nombres" class="form-label">Nombres</label> 
						<input type="text" class="form-control" name="nombresCliente" required>
					</div>
					<div class="col-md-6 mb-3">
						<label for="apellidos" class="form-label">Apellidos</label> 
						<input type="text" class="form-control" name="apellidos" required>
					</div>
					<div class="col-md-3 mb-3">
						<label for="edad" class="form-label">edad</label> 
						<input type="text" class="form-control" name="edad" required>
					</div>
					<div class="col-md-4 mb-3">
						<label for="rut" class="form-label">rut</label> 
						<input type="text"class="form-control" name="rut" required>
					</div>
					<div class="col-md-5 mb-3">
						<label for="telefono" class="form-label">Telefono</label> 
						<input type="text" class="form-control" name="telefono" required>
					</div>
					<div class="col-md-7 mb-3">
						<label for="direccion" class="form-label">Direcci�n</label> 
						<input type="text" class="form-control" name="direccion" required>
					</div>
					<div class="col-md-5 mb-3">
						<label for="comuna" class="form-label">Comuna</label> 
						<input type="text" class="form-control" name="comuna" required>
					</div>

					<div class="col-md-12">
						<button type="submit" class="btn btn-secondary w-100 mt-4">Guardar</button>
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