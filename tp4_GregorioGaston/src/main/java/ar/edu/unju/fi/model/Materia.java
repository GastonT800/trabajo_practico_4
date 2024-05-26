package ar.edu.unju.fi.model;

public class Materia {
	
	//Se definen los atributos para esta clase
	private int codigo;
	private String nombre;
	private String curso;
	private short cantidad;
	private short cantidadHoras;
	private Modalidad modalidad;
	private Docente docente;
	private String carrera;
		
	//Se define enum Modalidad
	public enum Modalidad {
		VIRTUAL, PRESENCIAL
	}

	//Constructor por defecto
	public Materia() {
		super();
	}
	
	//Constructor parametrizado
	public Materia(int codigo, String nombre, String curso, short cantidad, short cantidadHoras, Modalidad modalidad,
			Docente docente, String carrera) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.curso = curso;
		this.cantidad = cantidad;
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
	public short getCantidad() {
		return cantidad;
	}
	public void setCantidad(short cantidad) {
		this.cantidad = cantidad;
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
	public String getCarrera() {
		return carrera;
	}
	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}
		
	//toString
	@Override
	public String toString() {
		return "Carrera [codigo=" + codigo + ", nombre=" + nombre + ", curso=" + curso + ", cantidad=" + cantidad
				+ ", cantidadHoras=" + cantidadHoras + ", modalidad=" + modalidad + ", docente=" + docente
				+ ", carrera=" + carrera + "]";
	}
		
}
