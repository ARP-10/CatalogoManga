package dao;

import model.Categoria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CategoriaDAO extends BaseDAO<Categoria> implements CrudDAO<Categoria>{
    private static final String SELECT_CATEGORIAS = "SELECT * FROM manga_db.categorias";
    private static final String INSERT_CATEGORIA = "INSERT INTO manga_db.categorias (nombre) VALUES (?)";
    private static final String INSERT_CATEGORIA_ID = "INSERT INTO manga_db.categorias (id, nombre) VALUES (?, ?)";
    private static final String UPDATE_CATEGORIA = "UPDATE manga_db.categorias SET nombre = ? WHERE id = ?";
    private static final String DELETE_CATEGORIA = "DELETE FROM manga_db.categorias WHERE id = ?";

    public CategoriaDAO (Connection connection) {
        super(connection);
    }

    @Override
    protected Categoria mapResultSetToEntity(ResultSet rs) throws SQLException {
        return new Categoria(rs.getInt("id"), rs.getString("nombre"));
    }

    @Override
    public List<Categoria> obtenerTodosCrud() throws SQLException {
        return obtenerTodos(SELECT_CATEGORIAS);
    }

    @Override
    public void crearNuevoCrud(Categoria categoria) throws SQLException {
        crearNuevo(INSERT_CATEGORIA, categoria.getNombre());
    }

    public void crearCategoriaId(Categoria categoria) throws SQLException {
        try (PreparedStatement ps = connection.prepareStatement(INSERT_CATEGORIA_ID)) {
            ps.setInt(1, categoria.getId());
            ps.setString(2, categoria.getNombre());
            ps.executeUpdate();
        }
    }

    @Override
    public void actualizarCrud(Categoria categoria) throws SQLException {
        actualizar(UPDATE_CATEGORIA, categoria.getNombre(), categoria.getId());
    }

    @Override
    public void borrarCrud(int id) throws SQLException {
        borrar(DELETE_CATEGORIA, id);
    }
}
