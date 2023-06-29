package model;

import java.time.LocalDate;

public class Profesional extends Usuario {

	private String titulo;
	private LocalDate fechaIngreso;

	public Profesional(String nombre, LocalDate fechaNacimiento, int run, String titulo, LocalDate fechaIngreso) {
		super(nombre, fechaNacimiento, run);
		this.titulo = titulo;
		this.fechaIngreso = fechaIngreso;
	}

	public Profesional() {
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
		return super.toString() + "\n t�tulo: " + titulo + "\n fecha de ingreso:" + fechaIngreso;
	}

	public void validarTitulo(String titulo) {
		if (titulo.length() >= 10 && titulo.length() <= 50) {
			this.titulo = titulo;
		} else {
			System.out.println("El t�tulo debe tener entre 10 y 50 caracteres...");
		}
	}

	public int analizarUsuario() {
		super.analizarUsuario();
		System.out.println("T�tulo: " + titulo);
		System.out.println("Fecha de ingreso: " + fechaIngreso);

		return super.getRun();
	}
}
