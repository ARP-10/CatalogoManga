package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CapituloDAO;
import model.Capitulo;
import util.DB_Connection;

@WebServlet("/capitulos")
public class CapituloController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CapituloDAO capituloDAO;
	
	@Override
	public void init() throws ServletException {
	
		try {
			DB_Connection dbConnection = new DB_Connection();
			Connection conn = dbConnection.obtenerConexion();
			capituloDAO = new CapituloDAO(conn);
			System.out.println("Conexión a la base de datos inicializada correctamente.");
		} catch (SQLException | ClassNotFoundException e) {
			throw new ServletException("ERROR al inicializar la conexión a la BBDD", e);
		}
	}


       
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			Iterable<Capitulo> capitulos = capituloDAO.obtenerTodosCrud();
			request.setAttribute("capitulos", capitulos);
		
			request.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(request,  response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		try {
			if ("crear".equals(action)) {
				String titulo = request.getParameter("titulo");
				int numero = Integer.parseInt(request.getParameter("numero"));
				Capitulo nuevoCapitulo = new Capitulo(0, titulo, numero);
				capituloDAO.crearNuevoCrud(nuevoCapitulo);
				
			} else if ("actualizar".equals(action)) {
				int id = Integer.parseInt(request.getParameter("id"));
				String titulo = request.getParameter("titulo");
				int numero = Integer.parseInt(request.getParameter("numero"));
				Capitulo capituloActualizado = new Capitulo(id, titulo, numero);
				capituloDAO.actualizarCrud(capituloActualizado);
				
			}  else if ("eliminar".equals(action)) {
				int id = Integer.parseInt(request.getParameter("id"));
				capituloDAO.borrarCrud(id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
