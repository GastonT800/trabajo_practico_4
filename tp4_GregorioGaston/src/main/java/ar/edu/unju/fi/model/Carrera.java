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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Component

@Entity
@Table(name = "carrera")
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Carrera {
	
	//Se definen los atributos para esta clase
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="carre_id")
	private int codigo;
	
	@NonNull
	@Column(name="carre_nombre", nullable = false)
	private String nombre;
	
	@Column(name="carre_anios")
	private int cantAnios;
	
	@Column(name="carre_activo")
	private boolean estado;
	
	@Column(name="carre_estado")
	private boolean activo;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Materia> materias;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Alumno> alumnos;
	
}
