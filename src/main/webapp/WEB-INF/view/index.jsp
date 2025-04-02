<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <title>Biblioteca Manga</title>
    <!-- CSS de Bootstrap -->
    
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWERTY1234" crossorigin="anonymous">
	<link href="assets/bootstrap.min.css" rel="stylesheet">
	
</head>
<body class="container">
    <div class="d-flex flex-column justify-content-center align-items-center">
        <!-- Logo centrado -->
        <img src="assets/logo.jpg" alt="Logo de la Biblioteca Manga" style="max-width: 200px;">
        
        <!-- Botones centrados -->
        <div class="d-flex gap-3">
            <button class="btn btn-primary" onclick="window.location.href='AlquileresView.jsp'">Ver alquileres</button>
            <button class="btn btn-secondary" onclick="window.location.href='categorias'">Ver categorías</button>
        </div>
    </div>

    <!--Script de Bootstrap -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-ABCD1234" crossorigin="anonymous"></script>
</body>
</html>