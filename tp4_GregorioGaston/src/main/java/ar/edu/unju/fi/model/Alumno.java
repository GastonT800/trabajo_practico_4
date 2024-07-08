package ar.edu.unju.fi.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity(name = "ALUMNOS")
public class Alumno {
	
	@Id
	@Column(name = "alu_codigo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer lu;
	@NonNull
	@Column(name = "alu_dni",  nullable = false)
	private Integer dni;
	@NonNull
	@Column(name = "alu_nombre",  nullable = false)
	private String nombre;
	@NonNull
	@Column(name = "alu_apellido",  nullable = false)
	private String apellido;
	@NonNull
	@Column(name = "alu_email",  nullable = false)
	private String email;
	@NonNull
	@Column(name = "alu_telefono",  nullable = false)
	private Long telefono;
	@NonNull
	@Column(name = "alu_fecha_nacimiento",  nullable = false)
	private LocalDate fechaNacimiento;
	@NonNull
	@Column(name = "alu_domicilio",  nullable = false)
	private String domicilio;
	@Column(name = "alu_estado")
	private Boolean estado;
	
	@NonNull
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "carre_id")
	@ToString.Exclude
    private Carrera carrera;
	
	@ManyToMany(mappedBy = "alumnos")
	private List<Materia> materias = new ArrayList<>();

	
}