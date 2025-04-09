<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.Categoria"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Crear Nuevo Alquiler</title>
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
	<h2 class="text-center mb-5">Nuevo Alquiler</h2>
	

	<form method="post" action="<%= request.getContextPath() %>/nuevoAlquiler" class="container col-md-6 mx-auto">
        
        <div class="mb-3 bg-info bg-opacity-10 border border-info rounded p-2">
            <strong>Título Manga:</strong> <%= request.getAttribute("mangaTitulo") %>
        </div>

        <input type="hidden" name="id_manga" value="<%= request.getAttribute("mangaId") %>">

        <div class="mb-3">
            <label for="fecha_inicio" class="form-label">Fecha Inicio</label>
            <input type="date" class="form-control" id="fecha_inicio" name="fecha_inicio" required>
        </div>

        <div class="mb-3">
            <label for="fecha_fin" class="form-label">Fecha Fin</label>
            <input type="date" class="form-control" id="fecha_fin" name="fecha_fin" required>
        </div>

        <div class="mb-3">
            <label for="dni_usuario" class="form-label">DNI Usuario</label>
            <input type="text" class="form-control" id="dni_usuario" name="dni_usuario" maxlength="9" required>
        </div>

        <div class="d-flex justify-content-between mb-3">
            <button type="submit" class="btn btn-success">Guardar</button>
            <button type="button" class="btn btn-primary" onclick="window.location.href='<%= request.getContextPath() %>/mangas'">Volver</button>
        </div>
    </form>



</body>
</html>
