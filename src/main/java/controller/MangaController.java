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

@WebServlet("/mangas")
public class MangaController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private MangaDAO mangaDAO;

    @Override
    public void init() throws ServletException {
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
            Iterable<Manga> mangas = mangaDAO.obtenerTodosConAlquiler();
            request.setAttribute("mangas", mangas);
            request.getRequestDispatcher("/WEB-INF/view/MangasView.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al obtener los mangas");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        try {
            if ("actualizar".equals(action)) {
                int id = Integer.parseInt(request.getParameter("id"));
                String titulo = request.getParameter("titulo");
                Manga mangaActualizado = new Manga(id, titulo);
                mangaDAO.actualizarCrud(mangaActualizado);
                response.sendRedirect(request.getContextPath() + "/mangas"); 
            } else if ("eliminar".equals(action)) {
                int id = Integer.parseInt(request.getParameter("id"));
                mangaDAO.borrarCrud(id);
                response.sendRedirect(request.getContextPath() + "/mangas"); 
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al realizar la acción");
        }
    }
}
