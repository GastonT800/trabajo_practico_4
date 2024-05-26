package ar.edu.unju.fi.model;

public class Docente {
	
	//Se definen los atributos para esta clase
	private short legajo;
	private String nombre;
	private String apellido;
	private String email;
	private short telefono;
	
	//Constructo por defecto
	public Docente() {
		super();
	}
	
	//Constructor parametrizado
	public Docente(short legajo, String nombre, String apellido, String email, short telefono) {
		super();
		this.legajo = legajo;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.telefono = telefono;
	}

	//Getters and Setters
	public short getLegajo() {
		return legajo;
	}

	public void setLegajo(short legajo) {
		this.legajo = legajo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public short getTelefono() {
		return telefono;
	}

	public void setTelefono(short telefono) {
		this.telefono = telefono;
	}

	//toString
	@Override
	public String toString() {
		return "Docente [legajo=" + legajo + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email
				+ ", telefono=" + telefono + "]";
	}
	

}
