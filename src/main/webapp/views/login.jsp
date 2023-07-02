<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Iniciar Sesión</title>
<!-- CSS Bootstrap -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
	crossorigin="anonymous">
</head>
<body>
	<%@ include file='navbar.jsp'%>
	<div class="container mt-4">
		<div class="row justify-content-center">
			<div class="col-lg-4 col-md-6">
				<div class="card">
					<div class="card-body">
						<h1 class="card-title text-center">Iniciar Sesión</h1>
						<div class="row justify-content-center">
							<svg xmlns="http://www.w3.org/2000/svg" width="150" height="150" fill="currentColor" class="bi bi-person-circle" viewBox="0 0 16 16">
	  							<path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"/>
	  							<path fill-rule="evenodd" d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z"/>
							</svg>
						</div>
						<form action="Ingreso" method="POST">
							<div class="mb-3">
								<label for="usuario" class="form-label">Usuario</label>
								<input type="text" class="form-control" id="usuario" name="usuario" placeholder="Usuario" required>
							</div>
							<div class="mb-3">
								<label for="password" class="form-label">Contraseña</label>
								<input type="password" class="form-control" id="password" name="password" placeholder="Contraseña" required>
							</div>
							<div class="mb-3 form-check">
								<input type="checkbox" class="form-check-input" id="rememberMe" name="rememberMe">
								<label class="form-check-label" for="rememberMe">Recordarme</label>
							</div>
							<div class="text-center">
								<button type="submit" class="btn btn-primary w-75">Iniciar Sesión</button>
							</div>
						</form>
					</div>
				</div>
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