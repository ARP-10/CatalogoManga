<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.Alquiler"%>
<%@ page import="java.util.List"%>


<% Alquiler alquiler = (Alquiler) request.getAttribute("alquiler");%>

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
	<h2 class="text-center mb-4">Editar Alquiler</h2>

    <form method="post" action="<%= request.getContextPath() %>/editarAlquiler">
        <!-- Campo oculto para el ID del alquiler -->
        <input type="hidden" name="id" value="<%= alquiler.getId() %>">

        <!-- Mostrar el DNI del usuario -->
        <div class="mb-3">
            <label for="dni_usuario" class="form-label">DNI Usuario</label>
            <input type="text" class="form-control" id="dni_usuario" name="dni_usuario" value="<%= alquiler.getDni_usuario() %>" readonly>
        </div>

        <!-- Mostrar el título del manga -->
        <div class="mb-3">
            <label for="titulo" class="form-label">Título Manga</label>
            <input type="text" class="form-control" id="titulo" name="titulo" value="<%= alquiler.getTitulo() %>" readonly>
        </div>

        <!-- Mostrar la fecha de inicio -->
        <div class="mb-3">
            <label for="fecha_inicio" class="form-label">Fecha Inicio</label>
            <input type="date" class="form-control" id="fecha_inicio" name="fecha_inicio" value="<%= alquiler.getFecha_inicio() %>" readonly>
        </div>

        <!-- Campo para editar la fecha de fin -->
        <div class="mb-3">
            <label for="fecha_fin" class="form-label">Fecha Fin</label>
            <input type="date" class="form-control" id="fecha_fin" name="fecha_fin" value="<%= alquiler.getFecha_fin() %>" required>
        </div>

        <!-- Botones -->
        <div class="d-flex justify-content-between">
            <button type="submit" class="btn btn-success">Guardar</button>
            <button type="button" class="btn btn-secondary" onclick="window.location.href='<%= request.getContextPath() %>/alquileres'">Cancelar</button>
        </div>
    </form>



</body>
</html>
