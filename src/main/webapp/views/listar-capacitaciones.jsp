<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listar capacitaciones</title>
<!-- CSS Bootstrap -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
	crossorigin="anonymous">
</head>
<body>
	<%@ include file='navbar.jsp'%>
	<div class="container">

		<section>
			<h1>Listado de capacitaciones</h1>

			<table class="table">
				<thead class="table-dark">
					<tr>
						<th>Id</th>
						<th>Capacitación</th>
						<th>Lugar</th>
						<th>Numero asistentes</th>
						
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>1</td>
						<td>Matematicas</td>
						<td>Alcantara</td>
						<td>23</td>
					</tr>
					<tr>
						<td>2</td>
						<td>Gestion</td>
						<td>Golf</td>
						<td>12</td>
					</tr>
					<tr>
						<td>3</td>
						<td>Liderazgo</td>
						<td>Las Condes</td>
						<td>18</td>
					</tr>
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