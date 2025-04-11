<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="model.Manga"%>
<!DOCTYPE html>
<html>
<head>
    <title>Lista de Mangas</title>
    <link rel="icon" href="assets/libro-abierto.png" type="image/x-icon">
    <!-- CSS de Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" 
          rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css" 
          rel="stylesheet">
</head>
<body>
    <div class="container">
        <header class="py-3 text-center border-bottom mb-4">
            <img src="assets/logo.jpg" alt="Logo de la Biblioteca Manga" style="max-width: 120px;" class="mb-2">
            <h1 class="h4 text-dark">Lista de Mangas</h1>
        </header>

        <div class="d-flex justify-content-between align-items-center mb-3">
            <button class="btn btn-outline-primary d-flex align-items-center gap-2" onclick="window.location.href='index'">
                <i class="bi bi-arrow-left"></i> Volver
            </button>
            <button class="btn btn-success d-flex align-items-center gap-2" onclick="window.location.href='nuevoManga'">
                <i class="bi bi-plus-circle"></i> Nuevo Manga
            </button>
        </div>

        <table class="table table-striped table-bordered">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Título</th>
                    <th>Categoría</th>
                    <th>Alquilado</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
                <% 
                Iterable<Manga> mangas = (Iterable<Manga>) request.getAttribute("mangas");
                for (Manga manga : mangas) { 
                %>
                <tr>
                    <td><%= manga.getId() %></td>
                    <td><%= manga.getTitulo() %></td>
                    <td><%= manga.getCategoria() %></td>
                    <td>
                        <div class="form-check">
                            <input class="form-check-input" type="checkbox" disabled <%= manga.isAlquilado() ? "checked" : "" %>>
                        </div>
                    </td>
                    <td class="text-center">
                        <% if (!manga.isAlquilado()) { %>
                            <form action="nuevoAlquiler" method="get" style="display: inline;">
                                <input type="hidden" name="id" value="<%= manga.getId() %>">
                                <button class="btn btn-warning btn-sm">
                                    Alquilar
                                </button>
                            </form>
                        <% } else { %>
                            <button class="btn btn-secondary btn-sm" disabled>
                                Alquilar
                            </button>
                        <% } %>
                    
                        <button type="button" class="btn btn-danger btn-sm d-inline-flex align-items-center p-2"
                                data-bs-toggle="modal" data-bs-target="#confirmDeleteModal"
                                onclick="setDeleteData(<%= manga.getId() %>, '<%= manga.getTitulo() %>')">
                            <i class="bi bi-trash"></i>
                        </button>
                    </td>
                </tr>
                <% } %>
            </tbody>
        </table>
    </div>


    <div class="modal fade" id="confirmDeleteModal" tabindex="-1" aria-labelledby="confirmDeleteModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="confirmDeleteModalLabel">Confirmar Eliminación</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Cerrar"></button>
                </div>
                <div class="modal-body">
                    ¿Estás seguro de que deseas eliminar el manga <strong id="mangaTitle"></strong>?
                </div>
                <div class="modal-footer">
                    <form action="mangas" method="post" id="deleteForm">
                        <input type="hidden" name="action" value="eliminar">
                        <input type="hidden" name="id" id="mangaId">
                        <button type="submit" class="btn btn-danger">Sí, eliminar</button>
                    </form>
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                </div>
            </div>
        </div>
    </div>


    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    <script>
        // Función para actualizar el modal con los datos del manga
        function setDeleteData(id, title) {
            document.getElementById('mangaId').value = id;
            document.getElementById('mangaTitle').textContent = title;
        }
    </script>
</body>
</html>
