package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AlquilerDAO;
import model.Alquiler;
import util.DB_Connection;

@WebServlet("/AlquilerController")
public class AlquilerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AlquilerDAO alquilerDAO;
	
	@Override
	public void init() throws ServletException {
		// Se inicializa la conexión a la BBDD
		try {
			DB_Connection dbConnection = new DB_Connection();
			Connection conn = dbConnection.obtenerConexion();
			alquilerDAO = new AlquilerDAO(conn);
			System.out.println("Conexión a la base de datos inicializada correctamente.");
		} catch (SQLException | ClassNotFoundException e) {
			throw new ServletException("ERROR al inicializar la conexión a la BBDD", e);
		}
	}


       
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// Obtener todos los capítulos
			Iterable<Alquiler> alquileres = alquilerDAO.obtenerTodosCrud();
			request.setAttribute("alquileres", alquileres);
			// TODO: Cambiar el .jsp
			request.getRequestDispatcher("/WEB-INF/view/pruebas.jsp").forward(request,  response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Dónde cambiemos action por otro parámetro (crear, actualizar eliminar) en el .jsp entrará por aquí
		String action = request.getParameter("action");
		try {
			if ("crear".equals(action)) {
				String fechaInicioStr = request.getParameter("fecha_inicio");
				String fechaFinStr = request.getParameter("fecha_fin");
				Date fechaInicio = Date.valueOf(fechaInicioStr); 
				Date fechaFin = Date.valueOf(fechaFinStr);
				boolean estado = Boolean.parseBoolean(request.getParameter("estado"));

				Alquiler nuevoAlquiler = new Alquiler(0, fechaInicio, fechaFin, estado);
				alquilerDAO.crearNuevoCrud(nuevoAlquiler);
				
			} else if ("actualizar".equals(action)) {
				int id = Integer.parseInt(request.getParameter("id"));
				String fechaInicioStr = request.getParameter("fecha_inicio");
				String fechaFinStr = request.getParameter("fecha_fin");
				Date fechaInicio = Date.valueOf(fechaInicioStr); 
				Date fechaFin = Date.valueOf(fechaFinStr);
				boolean estado = Boolean.parseBoolean(request.getParameter("estado"));
				Alquiler alquilerActualizado = new Alquiler(id, fechaInicio, fechaFin, estado);
				alquilerDAO.actualizarCrud(alquilerActualizado);
				
			}  else if ("eliminar".equals(action)) {
				int id = Integer.parseInt(request.getParameter("id"));
				alquilerDAO.borrarCrud(id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
