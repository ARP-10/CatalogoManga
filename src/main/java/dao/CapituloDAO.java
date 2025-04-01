package dao;

import model.Capitulo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CapituloDAO extends BaseDAO<Capitulo> implements CrudDAO<Capitulo> {
    private static final String SELECT_CAPITULOS = "SELECT * FROM manga_db.capitulos";
    private static final String INSERT_CAPITULO = "INSERT INTO manga_db.capitulos (titulo, numero) VALUES (?, ?)";
    private static final String UPDATE_CAPITULO = "UPDATE manga_db.capitulos SET titulo = ?, numero = ? WHERE id = ?";
    private static final String DELETE_CAPITULO = "DELETE FROM manga_db.capitulos WHERE id = ?";

    public CapituloDAO (Connection connection) {
        super(connection);
    }

    @Override
    protected Capitulo mapResultSetToEntity(ResultSet rs) throws SQLException {
        return new Capitulo(rs.getInt("id"), rs.getString("titulo"), rs.getInt("numero"));
    }

    @Override
    public Iterable<Capitulo> obtenerTodosCrud() throws SQLException {
        return obtenerTodos(SELECT_CAPITULOS);
    }

    @Override
    public void crearNuevoCrud(Capitulo capitulo) throws SQLException {
        crearNuevo(INSERT_CAPITULO, capitulo.getTitulo(), capitulo.getNumero());
    }

    @Override
    public void actualizarCrud(Capitulo capitulo) throws SQLException {
        actualizar(UPDATE_CAPITULO, capitulo.getTitulo(), capitulo.getNumero());
    }

    @Override
    public void borrarCrud(int id) throws SQLException {
        borrar(DELETE_CAPITULO, id);
    }
}
