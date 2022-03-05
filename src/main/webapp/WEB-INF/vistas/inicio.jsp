<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

</head>
<body>
	<sec:authentication property="name" />
	<sec:authorize access="hasAuthority('ROL_CLIENTE')">You're an CLIENTE</sec:authorize>
	<sec:authorize access="hasAuthority('ROL_ADMON')">You're an ADMON</sec:authorize>

	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="/">Librería</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" href="/">Novedades</a>
				</li>
				<sec:authorize access="hasAnyAuthority('ROL_ADMON')">
					<li class="nav-item"><a class="nav-link"
						href="/admon/usuarios">Usuarios</a></li>
				</sec:authorize>
				<sec:authorize access="hasAuthority('ROL_ADMON')">
					<li class="nav-item"><a class="nav-link"
						href="/admon/perfiles">Perfiles</a></li>
				</sec:authorize>
				<sec:authorize access="!isAuthenticated()">
					<li class="nav-item"><a class="nav-link" href="/index">Iniciar
							Sesión</a></li>
				</sec:authorize>
				<sec:authorize access="hasAuthority('ROL_ADMON')">
					<li class="nav-item"><a class="nav-link" href="/admon/temas">Temas</a></li>
				</sec:authorize>
				<sec:authorize access="hasAuthority('ROL_CLIENTE')">
					<li class="nav-item"><a class="nav-link"
						href="/cliente/verCarrito">Ver carrito</a></li>
				</sec:authorize>
				<sec:authorize access="hasAuthority('ROL_CLIENTE')">
					<li class="nav-item"><a class="nav-link"
						href="/cliente/misDatos">Mis datos</a></li>
				</sec:authorize>
				<sec:authorize access="isAuthenticated()">
					<li class="nav-item"><a class="nav-link" href="/logout">Cerrar
							Sesión</a></li>
				</sec:authorize>
			</ul>
		</div>
	</nav>
	<h3>Mensaje: ${mensaje }</h3>
	
	<sec:authorize access="hasAuthority('ROL_CLIENTE')">
		<form action="/cliente/busquedaPorTema" method="get">
			<div class="input-group">
		  		<div class="form-outline">
		    		<label class="form-label" for="form1">Buscar por tema:</label>
		    		<input type="search" name="nombreTema" id="nombreTema" class="form-control" />
		    		<input type="submit" value="Buscar por tema" class="btn btn-primary">
		  		</div>
			</div>
		</form>
		
		<form action="/cliente/busquedaPorPalabra" method="get">
			<div class="input-group">
		  		<div class="form-outline">
		    		<label class="form-label" for="form1">Buscar por palabra:</label>
		    		<input type="search" name="palabra" class="form-control" />
		    		<input type="submit" value="Buscar" class="btn btn-primary">
		  		</div>
			</div>
		</form>
	</sec:authorize>
	
	<sec:authorize access="hasAuthority('ROL_ADMON')">
		<form action="/admon/busquedaPorTema" method="get">
			<div class="input-group">
		  		<div class="form-outline">
		    		<label class="form-label" for="form1">Buscar por tema:</label>
		    		<input type="search" name="nombreTema" id="nombreTema" class="form-control" />
		    		<input type="submit" value="Buscar por tema" class="btn btn-primary">
		  		</div>
			</div>
		</form>
		
		<form action="/admon/busquedaPorPalabra" method="get">
			<div class="input-group">
		  		<div class="form-outline">
		    		<label class="form-label" for="form1">Buscar por palabra:</label>
		    		<input type="search" name="palabra" class="form-control" />
		    		<input type="submit" value="Buscar" class="btn btn-primary">
		  		</div>
			</div>
		</form>
	</sec:authorize>
	
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
</body>
</html>