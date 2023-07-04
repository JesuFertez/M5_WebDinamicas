package model;

import java.time.LocalDate;

public class Profesional extends Usuario {

	private String titulo;
	private LocalDate fechaIngreso;

	public Profesional() {
	}

	public Profesional(int id, String nombreUsuario, String titulo, LocalDate fechaIngreso) {
		super(id, nombreUsuario, TipoUsuario.Profesional);
		this.titulo = titulo;
		this.fechaIngreso = fechaIngreso;
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
		return super.toString() + " [titulo=" + titulo + ", fechaIngreso=" + fechaIngreso + "]";
	}

}
