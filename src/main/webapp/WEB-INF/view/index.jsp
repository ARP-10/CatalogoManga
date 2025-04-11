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
	position: sticky;
	bottom: 0;
}
</style>

</head>
<body>

	<div class="container">
		<header class="mb-4 text-center">
			<img src="assets/logo.jpg" alt="Logo de la Biblioteca Manga"
				class="mb-2" style="max-width: 100px; height: auto;">
			<div class="d-flex justify-content-center align-items-center">
				<p class="text-muted small mb-0 me-2">Explorador para alquilar o
					buscar nuevos títulos en la biblioteca.</p>
				<button class="btn btn-sm d-flex align-items-center p-2"
					style="background-color: #ECA32B; color: white; border: none;"
					onclick="document.querySelector('.card').scrollIntoView({behavior: 'smooth'});">
					<i class="bi bi-arrow-down"></i>
				</button>
			</div>
		</header>



		<div class="container my-4">
			<h2 class="text-center h5 mb-3">Galería</h2>
			<div class="row g-3 text-center">
				<div class="col-12 col-sm-6 col-md-4 d-flex justify-content-center">
					<img src="assets/dragonball.jpg" alt="Dragon Ball"
						class="img-thumbnail shadow"
						style="width: 200px; height: 300px; object-fit: cover;">
				</div>
				<div class="col-12 col-sm-6 col-md-4 d-flex justify-content-center">
					<img src="assets/one-piece.jpg" alt="One Piece"
						class="img-thumbnail shadow"
						style="width: 200px; height: 300px; object-fit: cover;">
				</div>
				<div class="col-12 col-sm-6 col-md-4 d-flex justify-content-center">
					<img src="assets/jujutsu.jpg" alt="Jujutsu Kaisen"
						class="img-thumbnail shadow"
						style="width: 200px; height: 300px; object-fit: cover;">
				</div>
			</div>
		</div>


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

	<footer class="bg-dark text-white text-center py-3 mt-4">

		<p class="mb-0">&copy; 2025 Biblioteca Manga. Alejandra Rodríguez</p>
	</footer>

	<!-- Scripts de Bootstrap -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>