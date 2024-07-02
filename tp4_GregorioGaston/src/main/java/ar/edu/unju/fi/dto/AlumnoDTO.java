package ar.edu.unju.fi.dto;

import java.time.LocalDate;


import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Component
@Data
@NoArgsConstructor
@RequiredArgsConstructor

public class AlumnoDTO {
	
	private Integer lu;
	@NonNull
	@NotEmpty(message = "Por favor, ingrese un dni.")
	@Pattern(regexp = "^(10\\.000\\.000|[1-6]\\d{7}|7[0-0]\\d{6})$", message = "El DNI debe estar entre 10.000.000 y 70.000.000")
	private String dni;
	@NonNull
	@Size(min = 4, max = 20, message = "Debe tener entre 4 y 20 caracteres.")
	@Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$", message = "Solo puede contener letras.")
	private String nombre;
	@NonNull
	@NotEmpty(message = "Por favor, ingrese un apellido.") @Size(min = 5, max = 25, message = "El apellido debe tener entre 5 y 25 caracteres.")
	@Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$", message = "El apellido solo puede contener letras.")
	private String apellido;
	@NonNull
	@NotEmpty(message = "Por favor, ingrese un email.")
	@Email(message = "Por favor, ingrese un correo electrónico válido.")
	private String email;
	@NonNull
	@NotEmpty(message = "Por favor, ingrese teléfono.")
	@Size(min = 8, max = 10, message = "El teléfono debe tener entre 8 y 10 digitos.")
	private String telefono;
	@NotNull(message = "Por favor, ingrese una fecha.") @Past(message="La fecha debe ser anterior a la actual")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate fechaNacimiento;
	@NonNull
	@NotEmpty(message = "Por favor, ingrese un domicilio.")
	private String domicilio;
	private Boolean estado;
}
