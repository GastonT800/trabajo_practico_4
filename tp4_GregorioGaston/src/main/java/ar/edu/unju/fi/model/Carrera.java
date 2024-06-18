package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Carrera {
	
	//Se definen los atributos para esta clase
	private int codigo;
	private String nombre;
	private short cantAnios;
	private boolean estado;
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
