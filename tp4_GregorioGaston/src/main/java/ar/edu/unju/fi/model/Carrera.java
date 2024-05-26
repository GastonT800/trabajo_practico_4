package ar.edu.unju.fi.model;

public class Carrera {
	
	//Se definen los atributos para esta clase
	private String codigo;
	private String nombre;
	private short cant;
	private short anios;
	private boolean estado;
	
	//Constructor por defecto
	public Carrera() {
		super();
	}
	
	//Constructor parametrizado
	public Carrera(String codigo, String nombre, short cant, short anios, boolean estado) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.cant = cant;
		this.anios = anios;
		this.estado = estado;
	}
	
	//Getters and Setters
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public short getCant() {
		return cant;
	}
	public void setCant(short cant) {
		this.cant = cant;
	}
	public short getAnios() {
		return anios;
	}
	public void setAnios(short anios) {
		this.anios = anios;
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
		return "Carrera [codigo=" + codigo + ", nombre=" + nombre + ", cant=" + cant + ", anios=" + anios + ", estado="
				+ estado + "]";
	}
	
	
}
