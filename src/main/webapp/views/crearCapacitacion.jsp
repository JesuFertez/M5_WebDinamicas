<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Crear Capacitacion</title>
<!-- CSS Bootstrap -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
	crossorigin="anonymous">

</head>
<body>

	<%@ include file='navbar.jsp'%>
	<div class="container" style="width: 25rem;">
		<h1>Crear Capacitacion</h1>
		<form action="CrearCapacitacion" method="post">
			<div class="form-group">
				<label for="identificador">ID:</label> <input type="number"
					class="form-control" name="idCapacitacion" id="idCapacitacion"
					required>
			</div>
			<div class="mb-3">
				<label for="rut">Rut Cliente:</label> <input type="number"
					class="form-control" name="rutCliente" id="rutCliente" required>
			</div>
			<div class="mb-3">
				<label for="dia">Día:</label> <input type="text"
					class="form-control" name="dia" id="dia" required>
			</div>
			<div class="mb-3">
				<label for="hora">Hora (hh:mm):</label> <input type="text"
					class="form-control" name="hora" id="hora" required>
			</div>
			<div class="mb-3">
				<label for="lugar">Lugar:</label> <input type="text"
					class="form-control" name="lugar" id="lugar" required>
			</div>
			<div class="mb-3">
				<label for="duracion">Duración:</label> <input type="text"
					class="form-control" name="duracion" id="duracion" required>
			</div>
			<div class="mb-3">
				<label for="cantidad">Cantidad de Asistentes:</label> <input
					type="number" class="form-control" name="cantidadAsistentes"
					id="cantidadAsistentes" required>
			</div>
			<button type="submit" class="btn btn-primary">Crear</button>
		</form>
	</div>
	<!-- JavaScript Bootstrap -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
		crossorigin="anonymous"></script>
</body>
</html>