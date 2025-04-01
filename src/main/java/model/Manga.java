package model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Manga {
    // Atributos
    private int id;
    private String titulo;
    private int id_categoria;

    // Constructores
    public Manga(int id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }
}
