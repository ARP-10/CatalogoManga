<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.Categoria"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Crear Nuevo Manga</title>
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
      
        <div class="d-flex flex-column justify-content-center align-items-center mb-4">
            <img src="assets/logo.jpg" alt="Logo de la Biblioteca Manga" style="max-width: 100px;">
            <h4 class="h4 text-dark">Nuevo Manga</h4>
        </div>

        <% if (request.getAttribute("error") != null) { %>
            <div class="alert alert-danger">
                <%= request.getAttribute("error") %>
            </div>
        <% } %>

        <form action="nuevoManga" method="post" class="container col-md-6 mx-auto bg-light p-4 rounded shadow">
           
            <div class="mb-3">
                <label for="titulo" class="form-label">Título del Manga</label>
                <input type="text" class="form-control" id="titulo" name="titulo" required>
            </div>

            <div class="mb-3">
                <label for="categoria" class="form-label">Categoría</label>
                <select class="form-select" id="categoria" name="categoria" required>
                    <option value="">Seleccione una categoría</option>
                    <%
                    List<Categoria> categorias = (List<Categoria>) request.getAttribute("categorias");
                    if (categorias != null) {
                        for (Categoria categoria : categorias) {
                    %>
                    <option value="<%=categoria.getId()%>"><%=categoria.getNombre()%></option>
                    <%
                        }
                    }
                    %>
                </select>
            </div>

            <div class="d-flex justify-content-between mt-4">
             
                <button type="submit" class="btn btn-success d-flex align-items-center gap-2">
                    <i class="bi bi-check-circle"></i> Crear Manga
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

    <!-- Scripts de Bootstrap -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
