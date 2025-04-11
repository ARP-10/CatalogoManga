package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoriaDAO;
import model.Categoria;
import util.DB_Connection;

@WebServlet("/categorias")
public class CategoriaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CategoriaDAO categoriaDAO;
	
	@Override
	public void init() throws ServletException {
		
		try {
			DB_Connection dbConnection = new DB_Connection();
			Connection conn = dbConnection.obtenerConexion();
			categoriaDAO = new CategoriaDAO(conn);
			System.out.println("Conexión a la base de datos inicializada correctamente.");
		} catch (SQLException | ClassNotFoundException e) {
			throw new ServletException("ERROR al inicializar la conexión a la BBDD", e);
		}
	}


      
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {

			Iterable<Categoria> categorias = categoriaDAO.obtenerTodosCrud();
			request.setAttribute("categorias", categorias);
			
			request.getRequestDispatcher("/WEB-INF/view/CategoriasView.jsp").forward(request,  response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		try {
			if ("crear".equals(action)) {
				String nombre = request.getParameter("nombre");
				Categoria nuevaCategoria = new Categoria(0, nombre);
				categoriaDAO.crearNuevoCrud(nuevaCategoria);
				
			} else if ("actualizar".equals(action)) {
				int id = Integer.parseInt(request.getParameter("id"));
				String nombre = request.getParameter("nombre");
				Categoria categoriaActualizada = new Categoria(id, nombre);
				categoriaDAO.actualizarCrud(categoriaActualizada);
				
			}  else if ("eliminar".equals(action)) {
				int id = Integer.parseInt(request.getParameter("id"));
				categoriaDAO.borrarCrud(id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
