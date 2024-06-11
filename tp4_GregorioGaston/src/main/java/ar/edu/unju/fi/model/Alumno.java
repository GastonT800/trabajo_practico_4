package ar.edu.unju.fi.model;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

@Component
public class Alumno {
	
	//Se definen los atributos para esta clase
	private int dni;
	private String nombre;
	private String apellido;
	private String email;
	private long telefono;
	private LocalDate fechaNacimiento;
	private String domicilio;
	private String lu;
	
	//Constructor por defecto
	public Alumno() {
		super();
	}
	
	//Constructor parametrizado
	public Alumno(int dni, String nombre, String apellido, String email, long telefono, LocalDate fechaNacimiento,
			String domicilio, String lu) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.telefono = telefono;
		this.fechaNacimiento = fechaNacimiento;
		this.domicilio = domicilio;
		this.lu = lu;
	}
	
	//Getters and Setters
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
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
	public long getTelefono() {
		return telefono;
	}
	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	public String getLu() {
		return lu;
	}
	public void setLu(String lu) {
		this.lu = lu;
	}
	
	//toString
	@Override
	public String toString() {
		return "Alumno [dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email
				+ ", telefono=" + telefono + ", fechaNacimiento=" + fechaNacimiento + ", domicilio=" + domicilio +", lu=" + lu + "]";
	}
	

}
