package controller;

import dao.CategoriaDAO;
import model.Categoria;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CategoriaController {
    private final CategoriaDAO categoriaDAO;

    public CategoriaController(Connection connection) {
        this.categoriaDAO = new CategoriaDAO(connection);
    }


}
