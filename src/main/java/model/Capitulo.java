package model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class Capitulo {
    // Atributos
    private int id;
    private String titulo;
    private int numero;
    private int id_manga;

    public Capitulo(int id, String titulo, int numero) {
        this.id = id;
        this.titulo = titulo;
        this.numero = numero;
    }
}
