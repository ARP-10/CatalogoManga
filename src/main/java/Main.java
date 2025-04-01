import dao.CapituloDAO;
import dao.CategoriaDAO;
import model.Capitulo;
import model.Categoria;
import util.DB_Connection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        DB_Connection dbConnection = new DB_Connection();

        try(Connection con = dbConnection.obtenerConexion()) {
            // Instanciar el DAO
            CategoriaDAO categoriaDAO = new CategoriaDAO(con);

            // Usar el método obtenerTodos
            List<Categoria> categorias = categoriaDAO.obtenerTodosCrud();
            for (Categoria categoria : categorias) {
                System.out.println("ID: " + categoria.getId() + ", Nombre: " + categoria.getNombre());
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}