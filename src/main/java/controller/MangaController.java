package controller;

import dao.MangaDAO;
import model.Manga;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class MangaController {
    private final MangaDAO mangaDAO;

    public MangaController(Connection connection) {
        this.mangaDAO = new MangaDAO(connection);
    }

}
