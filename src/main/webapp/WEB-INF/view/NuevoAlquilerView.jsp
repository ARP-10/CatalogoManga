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
    <!-- CSS de Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" 
          rel="stylesheet" integrity="sha384-QWERTY1234" crossorigin="anonymous">
    <link href="assets/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css" 
          rel="stylesheet">
</head>
<body>
    <div class="container">
    
        <header class="py-3 text-center border-bottom mb-4">
            <img src="assets/logo.jpg" alt="Logo de la Biblioteca Manga" 
                 class="mb-2" style="max-width: 100px;">
            <h4 class="h4 text-dark">Nuevo Alquiler</h4>
        </header>


        <form method="post" action="<%= request.getContextPath() %>/nuevoAlquiler" 
              class="container col-md-6 mx-auto bg-light p-4 rounded shadow">
            
           
            <div class="mb-3 bg-info bg-opacity-10 border border-info rounded p-2">
                <strong class="text-primary">Título Manga:</strong> <%= request.getAttribute("mangaTitulo") %>
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
                <input type="text" class="form-control" id="dni_usuario" name="dni_usuario" 
                       maxlength="9" required>
            </div>

          
            <div class="d-flex justify-content-between mt-4">
                <button type="submit" class="btn btn-success d-flex align-items-center gap-2">
                    <i class="bi bi-check-circle"></i> Guardar
                </button>
                <button type="button" class="btn btn-outline-primary d-flex align-items-center gap-2" 
                        onclick="window.location.href='<%= request.getContextPath() %>/mangas'">
                    <i class="bi bi-arrow-left"></i> Cancelar
                </button>
            </div>
        </form>
    </div>

    
    <footer class="bg-dark text-white text-center py-3 mt-4">
        <p class="mb-0">&copy; 2025 Biblioteca Manga. Alejandra Rodríguez.</p>
    </footer>

  
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" 
            integrity="sha384-ABCD1234" crossorigin="anonymous"></script>
</body>
</html>

