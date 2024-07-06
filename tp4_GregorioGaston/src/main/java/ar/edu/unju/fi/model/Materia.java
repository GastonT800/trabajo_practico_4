package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Entity
@Table(name = "MATERIAS")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Materia {
	
	@Id
	@Column(name = "mat_codigo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	
	@NonNull
	@Column(name = "mat_nombre",nullable = false)
	private String nombre;
	
	@NonNull
	@Column(name = "mat_curso",nullable = false)
	private String curso;
	
	@NonNull
	@Column(name = "mat_cantidadHoras",nullable = false)
	private short cantidadHoras;
	
	@NonNull
	@Column(name = "mat_modalidad",nullable = false)
	private Modalidad modalidad;
	
	@NonNull
	@Column(name = "mat_docente",nullable = false)
	private Docente docente;
	
	@NonNull
	@Column(name = "mat_carrera",nullable = false)
	private Carrera carrera;
	
	@Column(name = "mat_estado")
	private boolean estado;
		
	//Se define enum Modalidad
	public enum Modalidad {
		VIRTUAL, PRESENCIAL, MIXTA
	}
}
