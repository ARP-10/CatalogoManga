package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MangaDAO;
import dao.CategoriaDAO;
import model.Manga;
import model.Categoria;
import util.DB_Connection;

@WebServlet("/nuevoManga")
public class NuevoMangaController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private MangaDAO mangaDAO;
    private CategoriaDAO categoriaDAO;

    @Override
    public void init() throws ServletException {
        try {
            DB_Connection dbConnection = new DB_Connection();
            Connection conn = dbConnection.obtenerConexion();
            mangaDAO = new MangaDAO(conn);
            categoriaDAO = new CategoriaDAO(conn);
            System.out.println("Conexión a la base de datos inicializada correctamente.");
        } catch (SQLException | ClassNotFoundException e) {
            throw new ServletException("ERROR al inicializar la conexión a la BBDD", e);
        }
    }

    private void cargarCategorias(HttpServletRequest request) throws SQLException {
        List<Categoria> categorias = categoriaDAO.obtenerTodosCrud();
        request.setAttribute("categorias", categorias);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            cargarCategorias(request);
            request.getRequestDispatcher("/WEB-INF/view/NuevoMangaView.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al cargar las categorías");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String titulo = request.getParameter("titulo");
            String categoriaStr = request.getParameter("categoria");
            
            if (titulo == null || titulo.trim().isEmpty()) {
                request.setAttribute("error", "El título es obligatorio");
                cargarCategorias(request);
                request.getRequestDispatcher("/WEB-INF/view/NuevoMangaView.jsp").forward(request, response);
                return;
            }

            if (categoriaStr == null || categoriaStr.trim().isEmpty()) {
                request.setAttribute("error", "La categoría es obligatoria");
                cargarCategorias(request);
                request.getRequestDispatcher("/WEB-INF/view/NuevoMangaView.jsp").forward(request, response);
                return;
            }

            int categoriaId = Integer.parseInt(categoriaStr);
            Manga nuevoManga = new Manga(0, titulo, categoriaId);
            mangaDAO.crearNuevoCrud(nuevoManga);
            
            response.sendRedirect(request.getContextPath() + "/mangas");
        } catch (Exception e) {
            e.printStackTrace();
            try {
                request.setAttribute("error", "Error al crear el manga: " + e.getMessage());
                cargarCategorias(request);
                request.getRequestDispatcher("/WEB-INF/view/NuevoMangaView.jsp").forward(request, response);
            } catch (SQLException ex) {
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al procesar la solicitud");
            }
        }
    }
}
