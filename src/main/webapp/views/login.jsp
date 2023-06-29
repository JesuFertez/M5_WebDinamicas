<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
		<main class="form-signin">
			<form action="Ingreso" method="GET">
				<h1 class="h3 mb-3 fw-normal">Por favor, ingrese</h1>

				<div class="form-floating">
					<input type="text" class="form-control" id="floatingInput" name="usuario"
						placeholder="Usuario"> <label for="floatingInput">Usuario</label>
				</div>
				<div class="form-floating pt-2">
					<input type="password" class="form-control" id="floatingPassword" name="password"
						placeholder="Contraseña"> <label for="floatingPassword">Contraseña</label>
				</div>

				<div class="checkbox mb-3">
					<label> <input type="checkbox" value="remember-me">
						Acuerdate de mi
					</label>
				</div>
				<button class="w-100 btn btn-lg btn-primary" type="submit">Iniciar Sesion</button>
			</form>
		</main>
	</div>
	<!-- JavaScript Bootstrap -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
		crossorigin="anonymous"></script>
</body>
</html>