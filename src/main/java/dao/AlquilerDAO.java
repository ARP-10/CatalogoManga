package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Alquiler;

public class AlquilerDAO extends BaseDAO<Alquiler> implements CrudDAO<Alquiler>{
    private static final String SELECT_ALQUILERES = "SELECT * FROM manga_db.alquileres";
    private static final String INSERT_ALQUILER = "INSERT INTO manga_db.alquileres (fecha_inicio, fecha_fin, alquilado,dni_usuario) VALUES (?, ?, ?, ?)";
    private static final String UPDATE_ALQUILER = "UPDATE manga_db.alquileres SET fecha_inicio = ?, fecha_fin = ?, alquilado = ?, dni_usuario = ? WHERE id = ?";
    private static final String DELETE_ALQUILER = "DELETE FROM manga_db.alquileres WHERE id = ?";
	
    // TODO: Meter que SOLO se pueda actualizar el estado??
    
	public AlquilerDAO(Connection connection) {
		super(connection);
	}
	
	@Override
	protected Alquiler mapResultSetToEntity(ResultSet rs) throws SQLException {
		return new Alquiler(rs.getInt("id"), rs.getDate("fecha_inicio"), rs.getDate("fecha_fin"), rs.getBoolean("alquilado"), rs.getString("dni_usuario"));
	}

	@Override
	public Iterable<Alquiler> obtenerTodosCrud() throws SQLException {
		return obtenerTodos(SELECT_ALQUILERES);
	}

	@Override
	public void crearNuevoCrud(Alquiler alquiler) throws SQLException {
		crearNuevo(INSERT_ALQUILER, alquiler.getFecha_inicio(), alquiler.getFecha_fin(), alquiler.isAlquilado());
		
	}

	@Override
	public void actualizarCrud(Alquiler alquiler) throws SQLException {
		actualizar(UPDATE_ALQUILER, alquiler.getFecha_inicio(), alquiler.getFecha_fin(), alquiler.isAlquilado());
		
	}

	@Override
	public void borrarCrud(int id) throws SQLException {
		borrar(DELETE_ALQUILER, id);
		
	}

	

	
}
