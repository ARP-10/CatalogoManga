package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Alquiler;

public class AlquilerDAO extends BaseDAO<Alquiler> implements CrudDAO<Alquiler>{
    private static final String SELECT_ALQUILERES = "SELECT a.*, m.titulo FROM alquileres a JOIN mangas m ON a.id_manga = m.id";
    private static final String INSERT_ALQUILER = "INSERT INTO manga_db.alquileres (fecha_inicio, fecha_fin, alquilado,dni_usuario) VALUES (?, ?, ?, ?)";
    private static final String UPDATE_ALQUILER = "UPDATE manga_db.alquileres SET fecha_inicio = ?, fecha_fin = ?, alquilado = ?, dni_usuario = ? WHERE id = ?";
    private static final String DELETE_ALQUILER = "DELETE FROM manga_db.alquileres WHERE id = ?";
	
    // TODO: Meter que SOLO se pueda actualizar el estado??
    
	public AlquilerDAO(Connection connection) {
		super(connection);
	}
	
	@Override
	protected Alquiler mapResultSetToEntity(ResultSet rs) throws SQLException {
		// TODO: probar a ver si sin esto da error o no
	    /*
	     * // Imprimir los nombres de las columnas para debug
	    java.sql.ResultSetMetaData rsmd = rs.getMetaData();
	    int columnsNumber = rsmd.getColumnCount();
	    System.out.println("Columnas disponibles:");
	    for (int i = 1; i <= columnsNumber; i++) {
	        System.out.println(rsmd.getColumnName(i));
	    }
	     */
	    
	    return new Alquiler(
	        rs.getInt("id"),
	        rs.getDate("fecha_inicio"),
	        rs.getDate("fecha_fin"),
	        rs.getBoolean("alquilado"),
	        rs.getString("dni_usuario"),
	        rs.getString("titulo")
	    );
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
