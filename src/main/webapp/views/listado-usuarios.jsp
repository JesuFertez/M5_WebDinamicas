<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listado de usuarios</title>
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
	<c:set var="navItem" value="Listar" />
	<!-- Menu activo -->
	<c:set var="navText" value="Usuarios" />
	<!-- Texto Listar -->
	<%@ include file='navbar.jsp'%>

	<!--  Vista para mostrar las capacitaciones -->
	<div class="container mt-4">

		<section>
			<h1>Listado de Usuarios</h1>
			<c:choose>
				<c:when test="${empty listaUsuarios}">
					<div class="alert alert-danger" style="text-align: center"
						role="alert">
						No hay registros de Usuarios. <a href="CrearUsuario"
							class="alert-link">Ir a crear Usuario</a>
					</div>
				</c:when>
				<c:otherwise>
          <table class="table table-striped table-bordered">
            <thead class="table-dark">
              <tr>
                <!-- Capacitacion(int identificador, int rutCliente, String dia, String hora, String lugar, String duracion,int cantidadAsistentes) -->
                <th>Id</th>
                <th>Nombre</th>
                <th>Tipo</th>
                <th>Modificar</th>
              </tr>
            </thead>
            <tbody>
              <!-- Ciclo forEach con JSTL para imprimir datos de la lista -->
              <c:forEach var="usu" items="${listaUsuarios}">
                <tr>
                  <td><c:out value="${usu.getId()}"></c:out></td>
                  <td><c:out value="${usu.getNombre()}"></c:out></td>
                  <td><c:out value="${usu.getTipo()}"></c:out></td>
                  <td><a href="EditarCliente?id=${usu.getId()}"><button type="submit" class="btn btn-outline-dark btn-sm"><i class="bi bi-pencil-square"></i> Editar</button></a></td>
                </tr>
              </c:forEach>
            </tbody>
          </table>
				</c:otherwise>
			</c:choose>
		</section>
	</div>
<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
		crossorigin="anonymous"></script>
</body>
</html>