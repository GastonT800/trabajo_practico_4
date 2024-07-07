package ar.edu.unju.fi.dto;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Materia.Modalidad;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
//import jakarta.validation.constraints.Pattern;
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
	
	//@NotEmpty(message = "Ingrese un Nombre.")
	@NotBlank
	@Size(min = 5, max = 30, message = "Debe tener entre 5 y 30 caracteres.")
	private String nombre;
	
	//@NotEmpty(message = "Ingrese el Curso.")
	@NotBlank
	@Size(min = 5, max = 20, message = "Debe tener entre 5 y 20 caracteres.")
	private String curso;
	
	//@NotEmpty(message = "Debe de ingresar una cantidad de horas")
	@Min(value=60, message= "Debe ingresar un número mayor o igual a 60")
	@Max(value=90, message= "Debe ingresar un número menor o igual a 90")
	private int cantidadHoras;
	
	//@NotEmpty(message = "Seleccione la modalidad de la cursada.")
	//@NotBlank
	private Modalidad modalidad;
	
	//@NotEmpty(message = "Seleccione un Docente para esta Materia.")
	//@NotBlank
	private DocenteDTO docente;
	
	//@NotEmpty(message = "Seleccione la Carrera a la que pertenece esta Materia.")
	//@NotBlank
	private CarreraDTO carrera;
	
	private boolean estado;
}
