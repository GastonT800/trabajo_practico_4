package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Component

@Entity
@Table(name = "CARRERA")
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

	
/*	
	//Constructor por defecto
	public Carrera() {
		super();
	}
	
	//Constructor parametrizado
	public Carrera(int codigo, String nombre, short cantAnios, boolean estado) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.cantAnios = cantAnios;
		this.estado = estado;
	}
	
	//Getters and Setters
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public short getCantAnios() {
		return cantAnios;
	}
	public void setCantAnios(short cantAnios) {
		this.cantAnios = cantAnios;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	//toString
	@Override
	public String toString() {
		return "Carrera [codigo=" + codigo + ", nombre=" + nombre + ", cantAnios=" + cantAnios + ", estado="
				+ estado + "]";
	}
	
	*/
}
