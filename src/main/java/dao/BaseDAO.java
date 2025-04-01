package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseDAO<T> {
    protected Connection connection;

    public BaseDAO(Connection connection) {
        this.connection = connection;
    }

    // Mapeo de los resultados de la consulta SQL
    protected abstract T mapResultSetToEntity(ResultSet rs) throws SQLException;

    public List<T> obtenerTodos(String selectQuery) throws SQLException {
        List<T> entities = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(selectQuery)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                entities.add(mapResultSetToEntity(rs));
            }
        }
        return entities;
    }

    public void crearNuevo(String insertQuery, Object... params) throws SQLException {
        try (PreparedStatement ps = connection.prepareStatement(insertQuery)) {
            for (int i = 0; i < params.length; i++) {
                ps.setObject(i + 1, params[i]);
            }
            ps.executeUpdate();
        }
    }

    public void actualizar(String updateQuery, Object... params) throws SQLException {
        try (PreparedStatement ps = connection.prepareStatement(updateQuery)) {
            for (int i = 0; i < params.length; i++) {
                ps.setObject(i + 1, params[i]);
            }
            ps.executeUpdate();
        }
    }

    public void borrar(String deleteQuery, Object param) throws SQLException {
        try (PreparedStatement ps = connection.prepareStatement(deleteQuery)) {
            ps.setObject(1, param);
            ps.executeUpdate();
        }
    }





}
