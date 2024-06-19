package ar.edu.unju.fi.dto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor 
@AllArgsConstructor
@Component
public class CarreraDTO {
	
	private int codigo;
	private String nombre;
	private short cantAnios;
	private boolean estado;

}
