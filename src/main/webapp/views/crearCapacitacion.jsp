<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Crear Capacitacion</title>
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
	<%@ include file='navbar.jsp'%>
	<div class="container d-flex justify-content-center align-items-center mt-4">
	
	<!-- Formulario para crear capacitacion -->
		<div class="card" style="width: 50%;">
			<div class="card-header bg-dark text-white">
				<h2 class="card-title">Crear Capacitacion</h2>
			</div>
			<div class="card-body">
				<form action="CrearCapacitacion" class="row" method="post">
				  <div class="col-md-4 mb-3">
						<label for="identificador" class="form-label">ID:</label>
						<input type="number" class="form-control" name="idCapacitacion" id="idCapacitacion" required>
				  </div>
				  <div class="col-md-8 mb-3">
						<label for="rut" class="form-label">Rut Cliente:</label>
						<input type="number" class="form-control" name="rutCliente" id="rutCliente" required>
				  </div>
				  <div class="col-md-3 mb-3">
						<label for="dia" class="form-label">Día:</label>
						<input type="text" class="form-control" name="dia" id="dia" required>
				  </div>
				  <div class="col-md-4 mb-3">
						<label for="hora" class="form-label">Hora (hh:mm):</label>
						<input type="text" class="form-control" name="hora" id="hora" required>
				  </div>
					<div class="col-md-5">
						<label for="lugar" class="form-label">Lugar:</label>
						<input type="text" class="form-control" name="lugar" id="lugar" required>
					</div>
					<div class="col-md-6">
						<label for="duracion" class="form-label">Duración:</label>
						<input type="text" class="form-control" name="duracion" id="duracion" required>
					</div>
					<div class="col-md-6 ">
						<label for="cantidad" class="form-label">Cantidad de Asistentes:</label>
						<input type="number" class="form-control" name="cantidadAsistentes" id="cantidadAsistentes" required>
					</div>
					<div class="col-md-12">
						<button type="submit" class="btn btn-secondary w-100 mt-4">Crear</button>
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