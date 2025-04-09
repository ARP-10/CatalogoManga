<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <title>Biblioteca Manga</title>
    <link rel="icon" href="assets/libro-abierto.png" type="image/x-icon">
    <!-- CSS de Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWERTY1234" crossorigin="anonymous">
	<link href="assets/bootstrap.min.css" rel="stylesheet">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css" rel="stylesheet">
	
</head>
<body class="container">
    <div class="d-flex flex-column justify-content-center align-items-center">
        <!-- Logo centrado -->
        <img src="assets/logo.jpg" alt="Logo de la Biblioteca Manga" style="max-width: 200px;">
        
        <!-- Botones centrados -->
        <div class="d-flex gap-3">
            <button class="btn btn-primary" onclick="window.location.href='alquileres'">Ver alquileres</button>
            <button class="btn btn-secondary" onclick="window.location.href='mangas'">Biblioteca</button>
        </div>
    </div>

    <!--Script de Bootstrap -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-ABCD1234" crossorigin="anonymous"></script>
</body>
</html>