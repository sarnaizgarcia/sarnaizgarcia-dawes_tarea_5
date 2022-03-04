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
	<jsp:include page="inicio.jsp"></jsp:include>

	<div class="container">
		<h1 class="text-primary">Libros por palabra ${palabra }</h1>
		
		<c:choose>
			<c:when test="${librosPorPalabra.size() == 0 }">
				<p style="color:red">No se han encontrado resultados</p>
			</c:when>
			<c:otherwise>
				<table class="table table-striped table-sm">
					<tr>
						<th>Título</th>
						<th>Autor</th>
						<th>Opciones</th>
						
					</tr>
					<c:forEach var="ele" items="${librosPorPalabra }">
						<tr>
							<td>${ele.titulo }</td>
							<td>${ele.autor }</td>
														<td>
								<a href="/cliente/verDetalle/${ele.isbn}"
									class="btn btn-success btn-sm">
									Ver detalle
								</a> 
								<a href="/cliente/addCarrito/${ele.isbn }"
									class="btn btn-warning btn-sm">
									Añadir al carrito
								</a>
							</td>
							
						</tr>
					</c:forEach>
				</table>				
			</c:otherwise>
		</c:choose>
	</div>
	
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