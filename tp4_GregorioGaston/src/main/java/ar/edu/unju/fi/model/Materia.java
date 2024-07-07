package ar.edu.unju.fi.model;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

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
	
	@Column(name = "mat_cantidadHoras",nullable = false)
	private int cantidadHoras;
	
	@NonNull
	@Column(name = "mat_modalidad",nullable = false)
	private Modalidad modalidad;
	
	@NonNull
	@OneToOne
	@JoinColumn(name = "doc_legajo")
	private Docente docente;
	
	@NonNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "carre_id")
	private Carrera carrera;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Alumno> alumnos;
	
	@Column(name = "mat_estado",nullable = false)
	private boolean estado;
		
	//Se define enum Modalidad
	public enum Modalidad {
		VIRTUAL, PRESENCIAL, MIXTA
	}
		
}