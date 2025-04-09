package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AlquilerDAO;
import model.Alquiler;
import util.DB_Connection;

@WebServlet("/editarAlquiler")
public class EditarAlquilerController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private AlquilerDAO alquilerDAO;

    @Override
    public void init() throws ServletException {
        try {
            DB_Connection dbConnection = new DB_Connection();
            Connection conn = dbConnection.obtenerConexion();
            alquilerDAO = new AlquilerDAO(conn);
        } catch (SQLException | ClassNotFoundException e) {
            throw new ServletException("Error al inicializar la conexión a la base de datos", e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Obtener el ID del alquiler desde la URL
            int id = Integer.parseInt(request.getParameter("id"));

            // Consultar el alquiler en la base de datos
            Alquiler alquiler = alquilerDAO.obtenerPorId(id);

            if (alquiler != null) {
                // Pasar el alquiler al JSP
                request.setAttribute("alquiler", alquiler);
                request.getRequestDispatcher("/WEB-INF/view/EditarAlquilerView.jsp").forward(request, response);
            } else {
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "Alquiler no encontrado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al consultar el alquiler.");
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID inválido.");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Obtener el ID y la nueva fecha_fin desde el formulario
            int id = Integer.parseInt(request.getParameter("id"));
            String fechaFinStr = request.getParameter("fecha_fin");

            // Actualizar solo la fecha_fin
            java.sql.Date fechaFin = java.sql.Date.valueOf(fechaFinStr);
            alquilerDAO.actualizarFechaFin(id, fechaFin);

            // Redirigir al listado de alquileres
            response.sendRedirect(request.getContextPath() + "/alquileres");
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al actualizar el alquiler.");
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Datos inválidos.");
        }
    }
}

