package ar.edu.unju.fi.dto;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Carrera;
import ar.edu.unju.fi.model.Docente;
import ar.edu.unju.fi.model.Materia.Modalidad;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor

public class MateriaDTO {
	
	private int codigo;
	private String nombre;
	private String curso;
	private short cantidadHoras;
	private Modalidad modalidad;
	private Docente docente;
	private Carrera carrera;
}
