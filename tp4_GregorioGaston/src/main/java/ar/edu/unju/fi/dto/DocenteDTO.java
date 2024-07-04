package ar.edu.unju.fi.dto;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DocenteDTO {
	
	private int legajo;
	
	@NotEmpty(message = "Ingrese un Nombre.")
	@NotBlank
	@Size(min = 3, max = 25, message = "Debe tener entre 3 y 20 caracteres.")
	@Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$", message = "Solo puede contener letras.")
	private String nombre;
	
	@NotEmpty(message = "Ingrese un Apellido.")
	@Size(min = 4, max = 25, message = "Debe tener entre 4 y 20 caracteres.")
	@Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$", message = "Solo puede contener letras.")
	private String apellido;
	
	@NotEmpty(message = "Ingrese un email.")
	@Email(message = "Ingrese un correo electrónico válido.")
	private String email;
	
	@NotEmpty(message = "Ingrese un número de teléfono.")
	@Size(min = 8, max = 10, message = "El teléfono debe tener entre 8 y 10 digitos.")
	@Pattern(regexp = "^[0-9]+$", message = "Solo puede contener números.")
	private String telefono;
	private boolean estado;
	

}
