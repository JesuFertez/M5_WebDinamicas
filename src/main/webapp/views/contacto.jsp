<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pagina de Contacto</title>
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
	<!-- Formulario para crear capacitacion -->
	<c:set var="navItem" value="Contacto" /> <!-- Menu activo -->
	<%@ include file='navbar.jsp'%>
	
	<section>
	<!-- Formulario de contacto -->
	<div class="container mt-4">
		<div class="row justify-content-center">
			<div class="col-lg-6 col-md-8">
				<div class="card">
					<div class="card-header bg-dark text-white">
						<h2 class="card-title text-center">Formulario de Contacto</h2>
					</div>
					<div class="card-body">
						<form action="Contacto" method="post">
							<div class="mb-3">
								<label for="nombre" class="form-label">Nombre:</label>
								<input type="text" class="form-control" id="nombre" name="nombre" required>
							</div>
							<div class="mb-3">
								<label for="email" class="form-label">Email:</label>
								<input type="email" class="form-control" id="email" name="email" required>
							</div>
							<div class="mb-3">
								<label for="mensaje" class="form-label">Mensaje:</label>
								<textarea class="form-control" id="mensaje" name="mensaje" rows="5" required></textarea>
							</div>
							<div class="text-center">
								<button type="submit" class="btn btn-secondary w-100">Enviar</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

	</section>

	<!-- JavaScript Bootstrap -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
		crossorigin="anonymous"></script>

</body>
</html>