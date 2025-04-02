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
	private boolean estado;
	
}
