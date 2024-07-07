package ar.edu.unju.fi.dto;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Materia.Modalidad;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor

public class MateriaDTO {
	
	private int codigo;
	
	@NotBlank(message = "Ingrese un Nombre.")
	@Size(min = 5, max = 30, message = "Debe tener entre 5 y 30 caracteres.")
	private String nombre;
	
	@NotBlank(message = "Seleccione un Curso.")
	@Size(min = 5, max = 20, message = "Debe tener entre 5 y 20 caracteres.")
	private String curso;
	
	@Min(value=60, message= "Debe ingresar un número mayor o igual a 60")
	@Max(value=90, message= "Debe ingresar un número menor o igual a 90")
	private int cantidadHoras;
	
	@NotNull(message = "Seleccione un tipo de modalidad")
	private Modalidad modalidad;
	
	@NotNull(message = "Seleccione un Docente")
	private DocenteDTO docente;
	
	@NotNull(message = "Seleccione una Carrera")
	private CarreraDTO carrera;
	
	private boolean estado;
}
