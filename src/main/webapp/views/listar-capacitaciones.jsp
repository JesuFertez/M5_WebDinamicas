<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listar capacitaciones</title>
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
	
	<!--  Vista para mostrar las capacitaciones -->
	<div class="container mt-4">

		<section>
			<h1>Listado de Capacitaciones con JSTL</h1>

			<table class="table table-striped table-bordered">
				<thead class="table-dark">
					<tr>
					<!-- Capacitacion(int identificador, int rutCliente, String dia, String hora, String lugar, String duracion,int cantidadAsistentes) -->
						<th>ID</th>
						<th>Nombre</th>
						<th>Detalle</th>
						<th>Rut Cliente</th>
						<th>Día</th>
						<th>Hora</th>
						<th>Lugar</th>
						<th>Duración</th>
						<th># Asistentes</th>
					</tr>
				</thead>
				<tbody>
					<!-- Ciclo forEach con JSTL para imprimir datos de la lista -->
					<c:forEach var="cap" items="${listaCapacitacion}">
					<tr>
						<td><c:out value="${cap.getId()}"></c:out></td>
						<td><c:out value="${cap.getNombre()}"></c:out></td>
						<td><c:out value="${cap.getDetalle()}"></c:out></td>
						<td><c:out value="${cap.getRutCliente()}"></c:out></td>
						<td><c:out value="${cap.getDia()}"></c:out></td>
						<td><c:out value="${cap.getHora()}"></c:out></td>
						<td><c:out value="${cap.getLugar()}"></c:out></td>
						<td><c:out value="${cap.getDuracion()}"></c:out></td>
						<td><c:out value="${cap.getCantidadAsistentes()}"></c:out></td>
					</tr>
					</c:forEach>
					
				</tbody>
			</table>

		</section>
	</div>
		<!-- JavaScript Bootstrap -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
		="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
		crointegrityssorigin="anonymous"></script>
</body>
</html>