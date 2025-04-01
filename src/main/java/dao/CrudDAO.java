package dao;

import java.sql.SQLException;

public interface CrudDAO <T>{
    Iterable<T> obtenerTodosCrud() throws SQLException;
    void crearNuevoCrud(T entity) throws SQLException;
    void actualizarCrud(T entity) throws SQLException;
    void borrarCrud(int id) throws SQLException;

    // TODO: crearConId(T entity):
}
