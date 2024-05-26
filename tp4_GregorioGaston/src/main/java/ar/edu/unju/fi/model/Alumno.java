package ar.edu.unju.fi.model;

import java.time.LocalDate;

public class Alumno {
	
	//Se definen los atributos para esta clase
	private short dni;
	private String nombre;
	private String apellido;
	private String email;
	private short telefono;
	private LocalDate fechaNacimiento;
	private short lu;
	
	//Constructor por defecto
	public Alumno() {
		super();
	}
	
	//Constructor parametrizado
	public Alumno(short dni, String nombre, String apellido, String email, short telefono, LocalDate fechaNacimiento,
			short lu) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.telefono = telefono;
		this.fechaNacimiento = fechaNacimiento;
		this.lu = lu;
	}
	
	//Getters and Setters
	public short getDni() {
		return dni;
	}
	public void setDni(short dni) {
		this.dni = dni;
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
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public short getLu() {
		return lu;
	}
	public void setLu(short lu) {
		this.lu = lu;
	}
	
	//toString
	@Override
	public String toString() {
		return "Alumno [dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email
				+ ", telefono=" + telefono + ", fechaNacimiento=" + fechaNacimiento + ", lu=" + lu + "]";
	}
	

}
