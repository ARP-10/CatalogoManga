<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="model.Manga"%>

<html>
<head>
<title>Lista de Mangas</title>
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

		<!-- Título -->
		<h2 class="text-center mb-5">Lista de Mangas</h2>
		<div class="d-flex w-100 justify-content-between mb-3">
			<button class="btn btn-primary"
				onclick="window.location.href='index'">Volver</button>
			<button class="btn btn-success"
				onclick="window.location.href='nuevoManga'">Nuevo</button>
		</div>

		<!-- Tabla de Mangas -->
		<table class="table table-striped table-bordered">
			<thead>
				<tr>
					<th>ID</th>
					<th>Título</th>
					<th>Acciones</th>
				</tr>
			</thead>
			<tbody>
    <%
    Iterable<Manga> capitulos = (Iterable<Manga>) request.getAttribute("capitulos");
    for (Manga manga : capitulos) {
    %>
    <tr>
        <td><%=manga.getId()%></td>
        <td><%=manga.getTitulo()%></td>
        <td>
            <!-- Botón para Actualizar -->
            <form action="mangas" method="post" style="display:inline;">
                <button class="btn btn-warning btn-sm" onclick="window.location.href='nuevoAlquiler'">Alquilar</button>
            </form>
            <!-- Botón para Eliminar -->
            <form action="mangas" method="post" style="display:inline;">
                <input type="hidden" name="action" value="eliminar">
                <input type="hidden" name="id" value="<%=manga.getId()%>">
                <button type="submit" class="btn btn-danger btn-sm">Eliminar</button>
            </form>
        </td>
    </tr>
    <%
    }
    %>
</tbody>

		</table>
	</div>

	<!-- Script de Bootstrap -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ABCD1234" crossorigin="anonymous"></script>
</body>
</html>
