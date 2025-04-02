package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MangaDAO;
import model.Manga;
import util.DB_Connection;

@WebServlet("/MangaController")
public class MangaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MangaDAO mangaDAO;
	
	@Override
	public void init() throws ServletException {
		// Se inicializa la conexión a la BBDD
		try {
			DB_Connection dbConnection = new DB_Connection();
			Connection conn = dbConnection.obtenerConexion();
			mangaDAO = new MangaDAO(conn);
			System.out.println("Conexión a la base de datos inicializada correctamente.");
		} catch (SQLException | ClassNotFoundException e) {
			throw new ServletException("ERROR al inicializar la conexión a la BBDD", e);
		}
	}


       
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// Obtener todos los capítulos
			Iterable<Manga> capitulos = mangaDAO.obtenerTodosCrud();
			request.setAttribute("capitulos", capitulos);
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
				String titulo = request.getParameter("titulo");
				Manga nuevoManga = new Manga(0, titulo);
				mangaDAO.crearNuevoCrud(nuevoManga);
				
			} else if ("actualizar".equals(action)) {
				int id = Integer.parseInt(request.getParameter("id"));
				String titulo = request.getParameter("titulo");
				Manga mangaActualizado = new Manga(id, titulo);
				mangaDAO.actualizarCrud(mangaActualizado);
				
			}  else if ("eliminar".equals(action)) {
				int id = Integer.parseInt(request.getParameter("id"));
				mangaDAO.borrarCrud(id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
