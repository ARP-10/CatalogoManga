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
    private boolean alquilado;
    private String categoria;

    // Constructores
    public Manga(int id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }
    
    public Manga(int id, String titulo, int id_categoria) {
        this.id = id;
        this.titulo = titulo;
        this.id_categoria = id_categoria;
    }
    
   
}
