<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="model.Alquiler, java.util.List"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Gestión de Alquileres</title>
    <link rel="icon" href="assets/libro-abierto.png" type="image/x-icon">
    <!-- CSS de Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" 
          rel="stylesheet" integrity="sha384-QWERTY1234" crossorigin="anonymous">
    <link href="assets/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css" rel="stylesheet">
</head>
<body>
    <div class="container">
       
        <header class="py-3 text-center border-bottom mb-4">
            <img src="assets/logo.jpg" alt="Logo de la Biblioteca Manga" class="mb-2" style="max-width: 120px;">
            <h1 class="h4 text-dark">Gestión de Alquileres</h1>
        </header>

     
        <div class="d-flex justify-content-between align-items-center mb-3">
            <button class="btn btn-outline-primary d-flex align-items-center gap-2"
                    onclick="window.location.href='index'">
                <i class="bi bi-arrow-left"></i> Volver
            </button>
        </div>

      
        <table class="table table-striped table-bordered">
            <thead class="thead-dark">
                <tr>
                    <th>DNI Usuario</th>
                    <th>Título Manga</th>
                    <th>Fecha Inicio</th>
                    <th>Fecha Fin</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
                <% 
                Iterable<Alquiler> alquileres = (Iterable<Alquiler>) request.getAttribute("alquileres");
                if (alquileres != null) {
                    for (Alquiler alquiler : alquileres) { 
                %>
                <tr>
                    <td><%= alquiler.getDni_usuario() %></td>
                    <td><%= alquiler.getTitulo() %></td>
                    <td><%= alquiler.getFecha_inicio() %></td>
                    <td><%= alquiler.getFecha_fin() %></td>
                    <td class="text-center">
                     
                        <button class="btn btn-warning btn-sm"
                                onclick="window.location.href='editarAlquiler?id=<%= alquiler.getId() %>'">
                            Editar
                        </button>
                        
                        <button type="button" class="btn btn-danger btn-sm d-inline-flex align-items-center gap-2"
                                data-bs-toggle="modal" data-bs-target="#confirmDeleteModal"
                                onclick="setDeleteData(<%= alquiler.getId() %>, '<%= alquiler.getTitulo() %>')">
                            <i class="bi bi-trash"></i> Eliminar
                        </button>
                    </td>
                </tr>
                <% 
                    }
                } else { 
                %>
                <tr>
                    <td colspan="5" class="text-center text-muted">No hay alquileres disponibles.</td>
                </tr>
                <% } %>
            </tbody>
        </table>
    </div>

 
    <div class="modal fade" id="confirmDeleteModal" tabindex="-1" aria-labelledby="confirmDeleteModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title text-danger" id="confirmDeleteModalLabel">Confirmar Eliminación</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Cerrar"></button>
                </div>
                <div class="modal-body">
                    ¿Estás seguro de que deseas eliminar el alquiler del manga <strong id="mangaTitle"></strong>?
                </div>
                <div class="modal-footer">
                    <form action="alquileres" method="post" id="deleteForm">
                        <input type="hidden" name="action" value="eliminar">
                        <input type="hidden" name="id" id="mangaId">
                        <button type="submit" class="btn btn-danger">Sí, eliminar</button>
                    </form>
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                </div>
            </div>
        </div>
    </div>

    <!-- Scripts de Bootstrap -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    <script>
        // Función para actualizar el modal con los datos del alquiler
        function setDeleteData(id, title) {
            document.getElementById('mangaId').value = id;
            document.getElementById('mangaTitle').textContent = title;
        }
    </script>
</body>
</html>
