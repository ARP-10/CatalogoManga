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
import dao.MangaDAO;
import util.DB_Connection;

@WebServlet("/nuevoAlquiler")
public class NuevoAlquilerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MangaDAO mangaDAO;
	private AlquilerDAO alquilerDAO;

	@Override
	public void init() throws ServletException {
		try {
			DB_Connection dbConnection = new DB_Connection();
			Connection conn = dbConnection.obtenerConexion();

			alquilerDAO = new AlquilerDAO(conn);
			mangaDAO = new MangaDAO(conn);
			System.out.println("Conexión a la base de datos inicializada correctamente.");
		} catch (SQLException | ClassNotFoundException e) {
			throw new ServletException("Error al inicializar la conexión a la base de datos", e);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");

		if (id != null) {
			try {
				int mangaId = Integer.parseInt(id);
				String titulo = mangaDAO.obtenerTituloPorId(mangaId);

				if (titulo != null) {
					request.setAttribute("mangaId", id);
					request.setAttribute("mangaTitulo", titulo);
					request.getRequestDispatcher("/WEB-INF/view/NuevoAlquilerView.jsp").forward(request, response);
				} else {
					response.sendError(HttpServletResponse.SC_NOT_FOUND,
							"No se encontró el manga con el ID proporcionado.");
				}
			} catch (NumberFormatException e) {
				response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID del manga no válido.");
			} catch (SQLException e) {
				e.printStackTrace();
				response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
						"Error al obtener los datos del manga.");
			}

		} else {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID de manga no proporcionado");
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    try {
	        // Obtén los valores desde el formulario
	        String idMangaStr = request.getParameter("id_manga");
	        String fechaInicioStr = request.getParameter("fecha_inicio");
	        String fechaFinStr = request.getParameter("fecha_fin");
	        String dniUsuario = request.getParameter("dni_usuario");

	        // Validaciones de campos obligatorios
	        if (idMangaStr == null || idMangaStr.trim().isEmpty() ||
	            fechaInicioStr == null || fechaInicioStr.trim().isEmpty() ||
	            fechaFinStr == null || fechaFinStr.trim().isEmpty() ||
	            dniUsuario == null || dniUsuario.trim().isEmpty()) {

	            request.setAttribute("error", "Todos los campos son obligatorios.");
	            request.setAttribute("mangaTitulo", request.getAttribute("mangaTitulo")); 
	            request.getRequestDispatcher("/WEB-INF/view/NuevoAlquilerView.jsp").forward(request, response);
	            return;
	        }

	        // Validación específica para el DNI (exactamente 9 caracteres)
	        if (dniUsuario.length() != 9) {
	            request.setAttribute("error", "El DNI debe tener exactamente 9 caracteres.");
	            request.setAttribute("mangaTitulo", request.getAttribute("mangaTitulo")); 
	            request.getRequestDispatcher("/WEB-INF/view/NuevoAlquilerView.jsp").forward(request, response);
	            return;
	        }

	        // Conversión de parámetros
	        int idManga = Integer.parseInt(idMangaStr);
	        java.sql.Date fechaInicio = java.sql.Date.valueOf(fechaInicioStr);
	        java.sql.Date fechaFin = java.sql.Date.valueOf(fechaFinStr);

	        // Guardar el nuevo alquiler usando el DAO
	        alquilerDAO.crearNuevoAlquiler(idManga, fechaInicio, fechaFin, dniUsuario, true);

	        // Redirigir al listado de alquileres tras guardar con éxito
	        response.sendRedirect(request.getContextPath() + "/alquileres");
	    } catch (SQLException e) {
	        e.printStackTrace();

	        // Maneja errores de base de datos
	        request.setAttribute("error", "Error al guardar el alquiler: " + e.getMessage());
	        request.setAttribute("mangaTitulo", request.getAttribute("mangaTitulo")); 
	        request.getRequestDispatcher("/WEB-INF/view/NuevoAlquilerView.jsp").forward(request, response);
	    } catch (NumberFormatException e) {
	        request.setAttribute("error", "El ID del manga no es válido.");
	        request.setAttribute("mangaTitulo", request.getAttribute("mangaTitulo")); 
	        request.getRequestDispatcher("/WEB-INF/view/NuevoAlquilerView.jsp").forward(request, response);
	    }
	}



}
