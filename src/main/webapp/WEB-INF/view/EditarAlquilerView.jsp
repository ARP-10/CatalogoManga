<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.Alquiler"%>
<%@ page import="java.util.List"%>


<% Alquiler alquiler = (Alquiler) request.getAttribute("alquiler");%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Editar Alquiler</title>
    <link rel="icon" href="assets/libro-abierto.png" type="image/x-icon">
    <!-- CSS de Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" 
          rel="stylesheet">
    <link href="assets/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css" 
          rel="stylesheet">
</head>
<body>
    <div class="container">
      
        <header class="py-3 text-center border-bottom mb-4">
            <img src="assets/logo.jpg" alt="Logo de la Biblioteca Manga" 
                 class="mb-2" style="max-width: 100px;">
            <h4 class="h4 text-dark">Editar Alquiler</h4>
        </header>

  
        <form method="post" action="<%= request.getContextPath() %>/editarAlquiler" 
              class="container col-md-6 mx-auto bg-light p-4 rounded shadow">
          
            <input type="hidden" name="id" value="<%= alquiler.getId() %>">

      
            <div class="mb-3">
                <label for="dni_usuario" class="form-label">DNI Usuario</label>
                <input type="text" class="form-control" id="dni_usuario" 
                       name="dni_usuario" value="<%= alquiler.getDni_usuario() %>" readonly>
            </div>

            <div class="mb-3">
                <label for="titulo" class="form-label">Título Manga</label>
                <input type="text" class="form-control" id="titulo" 
                       name="titulo" value="<%= alquiler.getTitulo() %>" readonly>
            </div>

 
            <div class="mb-3">
                <label for="fecha_inicio" class="form-label">Fecha Inicio</label>
                <input type="date" class="form-control" id="fecha_inicio" 
                       name="fecha_inicio" value="<%= alquiler.getFecha_inicio() %>" readonly>
            </div>

    
            <div class="mb-3">
                <label for="fecha_fin" class="form-label">Fecha Fin</label>
                <input type="date" class="form-control" id="fecha_fin" 
                       name="fecha_fin" value="<%= alquiler.getFecha_fin() %>" required>
            </div>

     
            <div class="d-flex justify-content-between mt-4">
                <button type="submit" class="btn btn-success d-flex align-items-center gap-2">
                    <i class="bi bi-check-circle"></i> Guardar
                </button>
                <button type="button" class="btn btn-outline-primary d-flex align-items-center gap-2" 
                        onclick="window.location.href='<%= request.getContextPath() %>/alquileres'">
                    <i class="bi bi-arrow-left"></i> Cancelar
                </button>
            </div>
        </form>
    </div>


    <footer class="bg-dark text-white text-center py-3 mt-4">
        <p class="mb-0">&copy; 2025 Biblioteca Manga. Todos los derechos reservados.</p>
    </footer>

    <!-- Scripts de Bootstrap -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
