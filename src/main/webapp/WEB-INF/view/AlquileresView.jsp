<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.Alquiler, java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Alquileres</title>
<link rel="icon" href="assets/libro-abierto.png" type="image/x-icon">
<!-- CSS de Bootstrap -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet" integrity="sha384-QWERTY1234" crossorigin="anonymous">
<link href="assets/bootstrap.min.css" rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css"
	rel="stylesheet">
</head>
<body class="container">
	<div
		class="d-flex flex-column justify-content-center align-items-center">
		<!-- Logo centrado -->
		<img src="assets/logo.jpg" alt="Logo de la Biblioteca Manga"
			style="max-width: 100px;">

		<!-- Tabla de Alquileres -->
		<h2 class="text-center mb-5">Lista de Alquileres</h2>
		<div class="d-flex w-100 justify-content-between mb-3">
			<button class="btn btn-primary"
				onclick="window.location.href='index'">Volver</button>
		</div>

		<table class="table table-striped">
			<thead class="thead-dark">
				<tr>
					<th>DNI Usuario</th>
					<th>Título Manga</th>
					<th>Fecha Inicio</th>
					<th>Fecha Fin</th>
					<th>Acciones</th>
				</tr>
			</thead>
			<tbody>
				<%
				Iterable<Alquiler> alquileres = (Iterable<Alquiler>) request.getAttribute("alquileres");
				if (alquileres != null) {
					for (Alquiler alquiler : alquileres) {
				%>
				<tr>
					<td><%=alquiler.getDni_usuario()%></td>
					<td><%=alquiler.getTitulo()%></td>
					<td><%=alquiler.getFecha_inicio()%></td>
					<td><%=alquiler.getFecha_fin()%></td>
					<td>
						<button class="btn btn-warning btn-sm"
							onclick="window.location.href='editarAlquiler?id=<%=alquiler.getId()%>'">Editar</button>

						<button class="btn btn-danger btn-sm"
							onclick="window.location.href='alquileres?action=eliminar&id=<%=alquiler.getId()%>'">Eliminar</button>

					</td>
				</tr>
				<%
				}
				}
				%>
			</tbody>
		</table>

	</div>
	<!--Script de Bootstrap -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ABCD1234" crossorigin="anonymous"></script>
</body>
</html>