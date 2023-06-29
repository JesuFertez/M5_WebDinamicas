package model;

import java.time.LocalDate;

public class Usuario implements IAsesoria {
	private String nombre;
	private LocalDate fechaNacimiento;
	private int run;

	/**
	 * Constructor vacío de la clase Usuario.
	 */
	public Usuario() {
	}

	/**
	 * 
	 * Constructor de la clase Usuario.
	 * 
	 * @param nombre          Nombre del usuario.
	 * @param fechaNacimiento Fecha de nacimiento del usuario.
	 * @param run             Run del usuario.
	 */
	public Usuario(String nombre, LocalDate fechaNacimiento, int run) {
		super();
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.run = run;
	}

	/**
	 * 
	 * Constructor de la clase Usuario.
	 * 
	 * @param run Run del usuario.
	 */
	public Usuario(int run) {
		this.run = run;
	}

	/**
	 * 
	 * Obtiene el nombre del usuario.
	 * 
	 * @return El nombre del usuario.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * 
	 * Establece el nombre del usuario.
	 * 
	 * @param nombre El nombre del usuario.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * 
	 * Obtiene la fecha de nacimiento del usuario.
	 * 
	 * @return La fecha de nacimiento del usuario.
	 */
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	/**
	 * 
	 * Establece la fecha de nacimiento del usuario.
	 * 
	 * @param fechaNacimiento La fecha de nacimiento del usuario.
	 */
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	/**
	 * 
	 * Obtiene el Run del usuario.
	 * 
	 * @return El Run del usuario.
	 */
	public int getRun() {
		return run;
	}

	/**
	 * 
	 * Establece el Run del usuario.
	 * 
	 * @param run El Run del usuario.
	 */
	public void setRun(int run) {
		this.run = run;
	}

	/**
	 * 
	 * Devuelve una representación en cadena del usuario.
	 * 
	 * @return Representación en cadena del usuario.
	 */
	@Override
	public String toString() {
		return "Usuario: \n Nombre: " + nombre + "\n Fecha de Nacimiento: " + fechaNacimiento + "\n Run: " + run;
	}

	/**
	 * 
	 * Realiza el análisis del usuario y devuelve un valor representativo.
	 * 
	 * @return El resultado del análisis del usuario.
	 */
	@Override
	public int analizarUsuario() {
		System.out.println(" Nombre: " + nombre + "\n Run:  " + run);
		return run;
	}

	/**
	 * 
	 * Muestra la edad del usuario.
	 * 
	 * @return La edad del usuario en forma de cadena.
	 */
	public String mostrarEdad() {
		int añoNacimiento = this.fechaNacimiento.getYear();
		int edad = LocalDate.now().getYear() - añoNacimiento;
		return "“El usuario tiene " + edad + " años”";
	}
	public String mostrarUsuario() {
		return "\n Nombre: " + nombre + "\n Fecha de Nacimiento: " + fechaNacimiento + "\n Run: " + run;
	}
}
