package ar.edu.unju.fi.dto;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
//import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor 
@AllArgsConstructor
@Component
public class CarreraDTO {
	
	private int codigo;
	
	
	@NotEmpty(message="Debe de ingresar un nombre valido para este campo")
	@Size(min=15, max=40, message="El nombre debe de comprender entre 15 a 40 caracteres")
	private String nombre;

	//@NotEmpty(message = "Debe de ingresar un número")
	@Min(value=3, message= "Debe ingresar un número mayor o igual a 3")
	@Max(value=7, message= "Debe ingresar un número menor o igual a 7")
	private int cantAnios;
	
	@NotNull(message="Debe de seleccionar uno de los estados para la carrera")
	private boolean estado;
	/**
	 * Este atributo me permite saber el estado del carrera en la Base de Datos
	 */
	private boolean activo;

}
