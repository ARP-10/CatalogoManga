package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Alquiler;

public class AlquilerDAO extends BaseDAO<Alquiler> implements CrudDAO<Alquiler>{
    private static final String SELECT_ALQUILERES = "SELECT a.*, m.titulo FROM alquileres a JOIN mangas m ON a.id_manga = m.id";
    private static final String SELECT_ID = "SELECT a.*, m.titulo FROM alquileres a JOIN mangas m ON a.id_manga = m.id WHERE a.id = ?";
    private static final String INSERT_ALQUILER = "INSERT INTO manga_db.alquileres (fecha_inicio, fecha_fin, alquilado,dni_usuario) VALUES (?, ?, ?, ?)";
    private static final String INSERT_ALQUILER_IDMANGA = "INSERT INTO alquileres (id_manga, fecha_inicio, fecha_fin, dni_usuario, alquilado) VALUES (?, ?, ?, ?, ?)";
    private static final String UPDATE_ALQUILER = "UPDATE manga_db.alquileres SET fecha_inicio = ?, fecha_fin = ?, alquilado = ?, dni_usuario = ? WHERE id = ?";
    private static final String UPDATE_ALQUILER_DATE = "UPDATE alquileres SET fecha_fin = ? WHERE id = ?";
    private static final String DELETE_ALQUILER = "DELETE FROM manga_db.alquileres WHERE id = ?";
	
    // TODO: Meter que SOLO se pueda actualizar el estado??
    
	public AlquilerDAO(Connection connection) {
		super(connection);
	}
	
	@Override
	protected Alquiler mapResultSetToEntity(ResultSet rs) throws SQLException {
	    
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
	
	public Alquiler obtenerPorId(int id) throws SQLException {
	    
	    try (PreparedStatement ps = connection.prepareStatement(SELECT_ID)) {
	        ps.setInt(1, id); 
	        try (ResultSet rs = ps.executeQuery()) {
	            if (rs.next()) {
	                return mapResultSetToEntity(rs); 
	            }
	        }
	    }
	    return null;
	}


	@Override
	public void crearNuevoCrud(Alquiler alquiler) throws SQLException {
		crearNuevo(INSERT_ALQUILER, alquiler.getFecha_inicio(), alquiler.getFecha_fin(), alquiler.isAlquilado());
		
	}
	
	public void crearNuevoAlquiler(int idManga, java.sql.Date fechaInicio, java.sql.Date fechaFin, String dniUsuario, boolean alquilado) throws SQLException {
		try (PreparedStatement ps = connection.prepareStatement(INSERT_ALQUILER_IDMANGA)) {
	        ps.setInt(1, idManga); 
	        ps.setDate(2, fechaInicio); 
	        ps.setDate(3, fechaFin); 
	        ps.setString(4, dniUsuario);
	        ps.setBoolean(5, true); 
	        ps.executeUpdate();
	    }
    }

	@Override
	public void actualizarCrud(Alquiler alquiler) throws SQLException {
		actualizar(UPDATE_ALQUILER, alquiler.getFecha_inicio(), alquiler.getFecha_fin(), alquiler.isAlquilado());
		
	}
	
	public void actualizarFechaFin(int id, java.sql.Date fechaFin) throws SQLException {
	    
	    try (PreparedStatement ps = connection.prepareStatement(UPDATE_ALQUILER_DATE)) {
	        ps.setDate(1, fechaFin); 
	        ps.setInt(2, id);      
	        ps.executeUpdate();
	    }
	}


	@Override
	public void borrarCrud(int id) throws SQLException {
		borrar(DELETE_ALQUILER, id);
		
	}

	

	
}
