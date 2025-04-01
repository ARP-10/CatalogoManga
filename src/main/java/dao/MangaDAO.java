package dao;

import model.Manga;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MangaDAO extends BaseDAO<Manga> implements CrudDAO<Manga>{
    private static final String SELECT_MANGAS = "SELECT * FROM manga_db.mangas";
    private static final String INSERT_MANGA = "INSERT INTO manga_db.mangas (titulo) VALUES (?)";
    private static final String INSERT_MANGA_ID = "INSERT INTO manga_db.mangas (id, titulo) VALUES (?, ?)";
    private static final String UPDATE_MANGA = "UPDATE manga_db.mangas SET titulo = ? WHERE id = ?";
    private static final String DELETE_MANGA = "DELETE FROM manga_db.mangas WHERE id = ?";

    public MangaDAO (Connection connection) {
        super(connection);
    }

    @Override
    protected Manga mapResultSetToEntity(ResultSet rs) throws SQLException {
        return new Manga(rs.getInt("id"), rs.getString("titulo"));
    }

    // Obtener todos los mangas
    @Override
    public List<Manga> obtenerTodosCrud() throws SQLException {
        return obtenerTodos(SELECT_MANGAS);
    }

    // Crear un manga nuevo
    @Override
    public void crearNuevoCrud(Manga manga) throws SQLException {
        crearNuevo(INSERT_MANGA, manga.getTitulo());
    }

    // Crear un manga nueva con un ID nuevo
    public void crearMangaId(Manga manga) throws SQLException {
        try (PreparedStatement ps = connection.prepareStatement(INSERT_MANGA_ID)) {
            ps.setInt(1, manga.getId());
            ps.setString(2, manga.getTitulo());
            ps.executeUpdate();
        }
    }

    // Actualizar una manga
    @Override
    public void actualizarCrud(Manga manga) throws SQLException {
        actualizar(UPDATE_MANGA, manga.getTitulo());
    }

    // Borrar un manga
    @Override
    public void borrarCrud(int id) throws SQLException {
        borrar(DELETE_MANGA, id);
    }
}
