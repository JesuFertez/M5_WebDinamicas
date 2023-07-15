package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Profesional extends Usuario {

	private String nombrePro;
	private String titulo;
	private LocalDate fechaIngreso;

	public Profesional() {
	}

	public Profesional(int id, String nombreUsuario, String contraseña, String nombre, String titulo,
			LocalDate fechaIngreso) {
		super(id, nombreUsuario, contraseña, TipoUsuario.Profesional);
		this.nombrePro = nombre;
		this.titulo = titulo;
		this.fechaIngreso = fechaIngreso;
	}
	
	public String getNombrePro() {
		return nombrePro;
	}

	public void setNombrePro(String nombre) {
		this.nombrePro = nombre;
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
	public String obtenerFechaFormat() {
		String fechaIngresoFormateada = "";
		if(fechaIngreso != null) {
			DateTimeFormatter formatoSalida = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			fechaIngresoFormateada = fechaIngreso.format(formatoSalida);
		}
		return fechaIngresoFormateada;
	}
	@Override
	public String toString() {
		return super.toString()+" [nombre=" + nombrePro + ", titulo=" + titulo + ", fechaIngreso=" + fechaIngreso + "]";
	}
	

}
