<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<html>
<head>
<title>Categorías</title>
<link rel="icon" href="assets/libro-abierto.png" type="image/x-icon">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css"
	rel="stylesheet">
</head>
<body class="container">
	<div>
		<div class="d-flex justify-content-center">
			<img src="assets/logo.jpg" alt="Logo de la Biblioteca Manga"
				style="max-width: 100px;">
		</div>
		<h2 class="text-center mb-5">Categorías Disponibles</h2>

		<!-- Contenedor para los botones -->
		<div
			class="d-flex flex-column justify-content-center align-items-center">
			<!-- Fila de botones -->
			<div class="d-flex justify-content-center gap-3 mb-3">
				<button class="btn btn-outline-primary"
					onclick="window.location.href='mangas'">Seinen</button>
				<button class="btn btn-outline-primary"
					onclick="window.location.href='mangas'">Shonen</button>
				<button class="btn btn-outline-primary"
					onclick="window.location.href='mangas'">Kodomo</button>
			</div>
			<div class="d-flex justify-content-center gap-3">
				<button class="btn btn-outline-primary"
					onclick="window.location.href='mangas'">Mecha</button>
				<button class="btn btn-outline-primary"
					onclick="window.location.href='mangas'">Josei</button>
			</div>
		</div>

		<!-- Botón de volver centrado -->
		<div class="d-flex justify-content-center mt-5">
			<button class="btn btn-primary"
				onclick="window.location.href='index'">Volver</button>
		</div>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
