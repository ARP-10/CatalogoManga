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
<body>
	<div class="container">
		<header class="py-3 text-center border-bottom mb-4">
			<img src="assets/logo.jpg" alt="Logo de la Biblioteca Manga"
				style="max-width: 120px;" class="mb-2">
			<h1 class="h4 text-dark">Lista de Mangas</h1>
		</header>

			<div class="d-flex justify-content-between align-items-center mb-3">
				<button
					class="btn btn-outline-primary d-flex align-items-center gap-2"
					onclick="window.location.href='index'">
					<i class="bi bi-arrow-left"></i> Volver
				</button>
				<button class="btn btn-success d-flex align-items-center gap-2"
					onclick="window.location.href='nuevoManga'">
					<i class="bi bi-plus-circle"></i> Nuevo Manga
				</button>
			</div>

			<!-- Tabla de Mangas -->
			<table class="table table-striped table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Título</th>
						<th>Categoría</th>
						<th>Aqluilado</th>
						<th>Acciones</th>
					</tr>
				</thead>
				<tbody>
                <% 
                Iterable<Manga> mangas = (Iterable<Manga>) request.getAttribute("mangas");
                for (Manga manga : mangas) { 
                %>
                <tr>
                    <td><%= manga.getId() %></td>
                    <td><%= manga.getTitulo() %></td>
                    <td><%= manga.getCategoria() %></td>
                    <td>
                        <div class="form-check">
                            <input class="form-check-input" type="checkbox" disabled <%= manga.isAlquilado() ? "checked" : "" %>>
                        </div>
                    </td>
                    <td class="text-center">
                        <% if (!manga.isAlquilado()) { %>
                            <form action="nuevoAlquiler" method="get" style="display: inline;">
                                <input type="hidden" name="id" value="<%= manga.getId() %>">
                                <button class="btn btn-warning btn-sm">
                                    Alquilar
                                </button>
                            </form>
                        <% } else { %>
                            <button class="btn btn-secondary btn-sm" disabled>
                                Alquilado
                            </button>
                        <% } %>
                        <!-- Botón para Eliminar -->
                        <form action="mangas" method="post" style="display: inline;">
                            <input type="hidden" name="action" value="eliminar">
                            <input type="hidden" name="id" value="<%= manga.getId() %>">
                            <button type="submit" class="btn btn-danger btn-sm d-inline-flex align-items-center p-2">
                <i class="bi bi-trash"></i> 
            </button>
                        </form>
                    </td>
                </tr>
                <% } %>
            </tbody>

			</table>
		</div>

	<footer class="bg-dark text-white text-center py-3 mt-4">
		<p class="mb-0">&copy; 2025 Biblioteca Manga. Todos los derechos
			reservados.</p>
	</footer>
	<!-- Script de Bootstrap -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ABCD1234" crossorigin="anonymous"></script>
</body>
</html>
