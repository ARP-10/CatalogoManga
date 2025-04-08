package model;

import java.sql.Date;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Alquiler {
	private int id;
	private Date fecha_inicio;
	private Date fecha_fin;
	private boolean alquilado;
	private String dni_usuario;
	private int id_manga; 
	private String titulo;
	
	public Alquiler (int id, Date fecha_inicio, Date fecha_fin, boolean alquilado, String dni_usuario, String titulo) {
		this.id = id;
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
		this.alquilado = alquilado;
		this.dni_usuario = dni_usuario;
		this.titulo = titulo;
	}
	
}
