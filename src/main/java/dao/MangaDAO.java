package dao;

import model.Manga;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MangaDAO extends BaseDAO<Manga> implements CrudDAO<Manga>{
    private static final String SELECT_MANGAS = "SELECT * FROM manga_db.mangas";
    private static final String SELECT_MANGAS_ALQUILER = "SELECT m.*, a.alquilado, c.nombre AS categoria FROM mangas m LEFT JOIN alquileres a ON m.id = a.id_manga LEFT JOIN categorias c ON m.id_categoria = c.id;";
    private static final String SELECT_TITULO_ID = "SELECT titulo FROM manga_db.mangas WHERE id = ?";
    private static final String INSERT_MANGA = "INSERT INTO manga_db.mangas (titulo, id_categoria) VALUES (?, ?)";
    private static final String INSERT_MANGA_ID = "INSERT INTO manga_db.mangas (id, titulo, id_categoria) VALUES (?, ?, ?)";
    private static final String UPDATE_MANGA = "UPDATE manga_db.mangas SET titulo = ? WHERE id = ?";
    private static final String DELETE_MANGA = "DELETE FROM manga_db.mangas WHERE id = ?";

    public MangaDAO (Connection connection) {
        super(connection);
    }

    @Override
    protected Manga mapResultSetToEntity(ResultSet rs) throws SQLException {
        return new Manga(
            rs.getInt("id"), 
            rs.getString("titulo"),
            rs.getInt("id_categoria"),
            rs.getBoolean("alquilado"),
            rs.getString("categoria")
        );
    }

    @Override
    public List<Manga> obtenerTodosCrud() throws SQLException {
        return obtenerTodos(SELECT_MANGAS);
    }
    
    public List<Manga> obtenerTodosConAlquiler() throws SQLException {
        try (PreparedStatement ps = connection.prepareStatement(SELECT_MANGAS_ALQUILER)) {
            ResultSet rs = ps.executeQuery();
            List<Manga> mangas = new ArrayList<>();
            while (rs.next()) {
                Manga manga = new Manga(
                    rs.getInt("id"),
                    rs.getString("titulo"),
                    rs.getInt("id_categoria"),
                    rs.getBoolean("alquilado"),
                    rs.getString("categoria")
                );
                mangas.add(manga);
            }
            return mangas;
        }
    }
    
    public String obtenerTituloPorId(int id) throws SQLException {
        
        try (PreparedStatement ps = connection.prepareStatement(SELECT_TITULO_ID)) {
            ps.setInt(1, id); 
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("titulo"); 
            }
        }
        return null; 
    }


    @Override
    public void crearNuevoCrud(Manga manga) throws SQLException {
        crearNuevo(INSERT_MANGA, manga.getTitulo(), manga.getId_categoria());
    }

    public void crearMangaId(Manga manga) throws SQLException {
        try (PreparedStatement ps = connection.prepareStatement(INSERT_MANGA_ID)) {
            ps.setInt(1, manga.getId());
            ps.setString(2, manga.getTitulo());
            ps.setInt(3, manga.getId_categoria());
            ps.executeUpdate();
        }
    }

    @Override
    public void actualizarCrud(Manga manga) throws SQLException {
        actualizar(UPDATE_MANGA, manga.getTitulo(), manga.getId());
    }

    @Override
    public void borrarCrud(int id) throws SQLException {
        borrar(DELETE_MANGA, id);
    }
}
