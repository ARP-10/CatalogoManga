<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <title>Lista de Capítulos</title>
</head>
<body>
    <!-- EJEMPLO DE IMPLEMENTACIÓN SIN USAR JSTL -->
    <h1>Capítulos</h1>
    <table>
        <tr>
            <th>ID</th>
            <th>Título</th>
            <th>Número</th>
            <th>Acciones</th>
        </tr>
        <%
            // Obtén la lista de capítulos desde el atributo de la solicitud
            Iterable<model.Capitulo> capitulos = (Iterable<model.Capitulo>) request.getAttribute("capitulos");
            if (capitulos != null) {
                for (model.Capitulo capitulo : capitulos) {
        %>
                    <tr>
                        <td><%= capitulo.getId() %></td>
                        <td><%= capitulo.getTitulo() %></td>
                        <td><%= capitulo.getNumero() %></td>
                        <td>
                            <form action="CapituloController" method="post">
                                <input type="hidden" name="id" value="<%= capitulo.getId() %>" />
                                <button type="submit" name="action" value="eliminar">Eliminar</button>
                            </form>
                        </td>
                    </tr>
        <%
                }
            }
        %>
    </table>

    <h2>Crear Nuevo Capítulo</h2>
    <form action="CapituloController" method="post">
        <input type="text" name="titulo" placeholder="Título" required />
        <input type="number" name="numero" placeholder="Número" required />
        <button type="submit" name="action" value="crear">Crear</button>
    </form>
</body>
</html>
