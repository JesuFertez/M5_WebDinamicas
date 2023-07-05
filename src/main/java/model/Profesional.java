package model;

import java.time.LocalDate;

public class Profesional extends Usuario {

	private String nombre;
	private String titulo;
	private LocalDate fechaIngreso;

	public Profesional() {
	}

	public Profesional(int id, String nombreUsuario, String contraseña, String nombre, String titulo,
			LocalDate fechaIngreso) {
		super(id, nombreUsuario, contraseña, TipoUsuario.Profesional);
		this.nombre = nombre;
		this.titulo = titulo;
		this.fechaIngreso = fechaIngreso;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	@Override
	public String toString() {
		return super.toString()+" [nombre=" + nombre + ", titulo=" + titulo + ", fechaIngreso=" + fechaIngreso + "]";
	}
	

}
