<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.Categoria"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Crear Nuevo Manga</title>
<link rel="icon" href="assets/libro-abierto.png" type="image/x-icon">
<!-- Asegúrate de que el enlace a Bootstrap sea correcto -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body class="container">
	<div
		class="d-flex flex-column justify-content-center align-items-center">
		<!-- Logo centrado -->
		<img src="assets/logo.jpg" alt="Logo de la Biblioteca Manga"
			style="max-width: 100px;">
	</div>
	<!-- Título -->
	<h2 class="text-center mb-5">Nuevo Manga</h2>

	<!-- Formulario para crear un nuevo manga -->
	<form action="nuevoManga" method="post">
		<div class="mb-3">
			<label for="titulo" class="form-label">Título del Manga</label> <input
				type="text" class="form-control" id="titulo" name="titulo" required>
		</div>

		<!-- Desplegable con las categorías dinámicas -->
		<div class="mb-3">
			<label for="categoria" class="form-label">Categoría</label> <select
				class="form-select" id="categoria" name="categoria" required>
				<option value="">Seleccione una categoría</option>
				<%
				List<Categoria> categorias = (List<Categoria>) request.getAttribute("categorias");
				for (Categoria categoria : categorias) {
				%>
				<option value="<%=categoria.getId()%>"><%=categoria.getNombre()%></option>
				<%
				}
				%>
			</select>
		</div>

		<!-- Botón de submit -->
		<button type="submit" class="btn btn-success">Crear Manga</button>
	</form>

</body>
</html>
