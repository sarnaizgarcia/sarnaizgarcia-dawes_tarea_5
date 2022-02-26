<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
div {
	display: flex;
}

table {
	width: 25%;
	border-collapse: collapse;
	text-align: left;
	margin: 10px;
}

td {
	border: solid 3px #00AEFF;
	text-align: center;
	padding: 10px
}

tr {
	font-size: 18px;
	font-weight: bold;
}
</style>
<body>

	<h2>Detalle del Libro seleccionado</h2>
	<div>
		<table>
			<tr>
				<td>Isbn</td>
				<td>${listaLibros.isbn}</td>
			</tr>
			<tr>
				<td>Titulo</td>
				<td>${listaLibros.titulo}</td>
			</tr>
			<tr>
				<td>Autor</td>
				<td>${listaLibros.autor}</td>
			</tr>
			<tr>
				<td>Precio</td>
				<td>${listaLibros.precioUnitario}</td>
			</tr>
			<tr>
				<td>Paginas</td>
				<td>${listaLibros.paginas}</td>
			</tr>
			<tr>
				<td>Novedad</td>
				<td>${listaLibros.novedad}</td>
			</tr>
			<c:forEach var="ele" items="${listaLibros.temas}">
				<tr>
					<td>${ele.idTema }</td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<h3>Mensajes: ${mensaje}</h3>

	<a href="/eventos/destacados">Volver al inicio</a>


</body>
</html>