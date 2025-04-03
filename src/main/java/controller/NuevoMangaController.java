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
            categoriaDAO = new CategoriaDAO(conn); // Inicializamos el DAO para categorías
            System.out.println("Conexión a la base de datos inicializada correctamente.");
        } catch (SQLException | ClassNotFoundException e) {
            throw new ServletException("ERROR al inicializar la conexión a la BBDD", e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Obtener todas las categorías desde la base de datos
            List<Categoria> categorias = categoriaDAO.obtenerTodosCrud();
            request.setAttribute("categorias", categorias);  // Pasar las categorías al JSP
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al cargar las categorías");
        }
        
        // Redirigir a la vista para crear un nuevo manga
        request.getRequestDispatcher("/WEB-INF/view/NuevoMangaView.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String titulo = request.getParameter("titulo");
        int categoriaId = Integer.parseInt(request.getParameter("categoria"));

        try {
            // Crear un nuevo manga con la categoría seleccionada
            Manga nuevoManga = new Manga(0, titulo, categoriaId);
            mangaDAO.crearNuevoCrud(nuevoManga);
            
            // Redirigir a la página de la lista de mangas
            response.sendRedirect(request.getContextPath() + "/mangas");
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al crear el nuevo manga");
        }
    }
}
