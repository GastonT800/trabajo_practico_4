package ar.edu.unju.fi.model;


import org.springframework.stereotype.Component;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Component 
@Entity
@Table(name = "DOCENTES")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Docente {
	
	@Id
	@Column(name = "doc_legajo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int legajo;
	
	@NonNull
	@Column(name = "doc_nombre",nullable = false)
	private String nombre;
	
	@NonNull
	@Column(name = "doc_apellido",nullable = false)
	private String apellido;
	
	@NonNull
	@Column(name = "doc_email",nullable = false)
	private String email;
	
	@NonNull
	@Column(name = "doc_telefono",nullable = false)
	private String telefono;

	@Column(name = "doc_estado",nullable = false)
	private boolean estado;

}
