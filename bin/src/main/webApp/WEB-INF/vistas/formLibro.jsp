<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>FORMULARIO DE ALTA DE LIBRO</h3>
	<form action="/admon/alta" method="post">

		<p>
			Isbn: <input type="number" name="isbn">
		</p>
		<p>
			Titulo: <input type="text" name="titulo">
		</p>
		<p>
			Autor: <input type="text" name="autor">
		</p>
		<p>
			Precio: <input type="number" name="precioUnitario">
		</p>
		<p>
			Paginas: <input type="number" name="paginas">
		</p>
		<p>
			Id tema: <select name="tema.idTema">
				<c:forEach var="ele" items="${listaTemas}">
					<option value="${ele.idTema}">${ele.descTema}</option>
				</c:forEach>
			</select>
		</p>
		<p>
			<input type="submit" value="Enviar">
		</p>


	</form>
</body>
</html>