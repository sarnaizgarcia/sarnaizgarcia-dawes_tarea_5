<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>FORMULARIO DE ALTA DE LIBRO</h1>
	<form action="/admon/alta" method="post">
	
		<p><input type="number" name="isbn" >Isbn</p>
		<p><input type="text" name="titulo" >Titulo</p>
		<p><input type="text" name="autor">Marca</p>
		<p><input type="number" name="precioUnitario">Precio</p>
		<p><input type="number" name="paginas">Paginas</p>
				
		Id tema: <select name="tema.idTema">
				<c:forEach var="ele" items="${listaTemas}">
						<option value="${ele.idTema}">${ele.descTema}</option>
				</c:forEach>
			</select>
		
		<p><input type="submit" value="Enviar"></p>
		
	
	</form>
</body>
</html>