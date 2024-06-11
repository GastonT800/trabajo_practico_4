package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

@Component
public class Materia {
	
	//Se definen los atributos para esta clase
	private int codigo;
	private String nombre;
	private String curso;
	private short cantidadHoras;
	private Modalidad modalidad;
	private Docente docente;
	private Carrera carrera;
		
	//Se define enum Modalidad
	public enum Modalidad {
		VIRTUAL, PRESENCIAL, MIXTA
	}

	//Constructor por defecto
	public Materia() {
		super();
	}
	
	//Constructor parametrizado
	public Materia(int codigo, String nombre, String curso, short cantidadHoras, Modalidad modalidad,
			Docente docente, Carrera carrera) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.curso = curso;
		this.cantidadHoras = cantidadHoras;
		this.modalidad = modalidad;
		this.docente = docente;
		this.carrera = carrera;
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
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public short getCantidadHoras() {
		return cantidadHoras;
	}
	public void setCantidadHoras(short cantidadHoras) {
		this.cantidadHoras = cantidadHoras;
	}
	public Modalidad getModalidad() {
		return modalidad;
	}
	public void setModalidad(Modalidad modalidad) {
		this.modalidad = modalidad;
	}
	public Docente getDocente() {
		return docente;
	}
	public void setDocente(Docente docente) {
		this.docente = docente;
	}
	public Carrera getCarrera() {
		return carrera;
	}
	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}
		
	//toString
	@Override
	public String toString() {
		return "Carrera [codigo=" + codigo + ", nombre=" + nombre + ", curso=" + curso + ", cantidadHoras=" + cantidadHoras + ", modalidad=" + modalidad + ", docente=" + docente
				+ ", carrera=" + carrera + "]";
	}
		
}
