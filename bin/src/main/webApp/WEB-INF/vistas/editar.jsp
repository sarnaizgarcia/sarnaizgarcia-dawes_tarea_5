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
	<h3>EDITAR DE LIBRO</h3>
	<form action="/admon/editar" method="post">

		<p>
			Isbn: <input type="number" name="isbn" value="${libro.isbn }" readonly="readonly">
		</p>
		<p>
			Titulo: <input type="text" name="titulo" value="${libro.titulo }">
		</p>
		<p>
			Autor: <input type="text" name="autor" value="${libro.autor }">
		</p>
		<p>
			Precio: <input type="number" name="precioUnitario" value="${libro.precioUnitario }">
		</p>
		<p>
			Paginas: <input type="number" name="paginas" value="${libro.paginas }">
		</p>
		<p>
			Id tema: <select name="tema.idTema">
				<c:forEach var="ele" items="${listaTemas}">
					<option value="${ele.idTema}">${ele.descTema}</option>
				</c:forEach>
			</select>
		</p>
		<p>
			Portada: <input type="text" name="imagen" value="${libro.imagen }">
		</p>
		<p>
			<input type="submit" value="Guardar">
		</p>


	</form>
</body>
</html>