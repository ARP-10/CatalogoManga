<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<html>
<head>
<title>Biblioteca Manga</title>
<link rel="icon" href="assets/libro-abierto.png" type="image/x-icon">
<!-- CSS de Bootstrap -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet" integrity="sha384-QWERTY1234" crossorigin="anonymous">
<link href="assets/bootstrap.min.css" rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css"
	rel="stylesheet">
	
<style>
	footer {
		position:sticky;
		bottom: 0;
	}
</style>

</head>
<body>

	<div class="container">
		<!-- Encabezado -->
		<header class=" mb-2 text-center">
			<img src="assets/logo.jpg" alt="Logo de la Biblioteca Manga"
				style="max-width: 150px;" class="mb-2">
		</header>
		<div class="text-center mb-4">
			<p class="text-muted">Explorador para alquilar o buscar nuevos
				títulos en la biblioteca.</p>
		</div>
		<!-- Tarjeta con botones -->
		<div class="card shadow mb-2">
			<div class="card-body text-center">
				<h2 class="h5 mb-4">Explora la Biblioteca</h2>
				<div class="d-flex justify-content-center gap-3">
					<button class="btn btn-primary btn-sm rounded-pill"
						onclick="window.location.href='alquileres'">
						<i class="bi bi-book"></i> Ver alquileres
					</button>
					<button class="btn btn-secondary btn-sm rounded-pill"
						onclick="window.location.href='mangas'">
						<i class="bi bi-collection"></i> Biblioteca
					</button>
				</div>

			</div>
		</div>
	</div>
	<!-- Pie de página -->
	<footer class="bg-dark text-white text-center py-3 mt-4">
		
		<p class="mb-0">&copy; 2025 Biblioteca Manga. Alejandra Rodríguez</p>
	</footer>

	<!-- Scripts de Bootstrap -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>