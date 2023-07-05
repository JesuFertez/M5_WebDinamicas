package model;

import java.time.LocalDate;

public class Administrativo extends Usuario {
	
	private String nombre;
	private String area;
	private String experienciaPrevia;

	public Administrativo() {
	}

	public Administrativo(int id, String nombreUsuario,String contraseña,String nombre, String area, String experienciaPrevia) {
		super(id, nombreUsuario,contraseña, TipoUsuario.Administrativo);
		this.nombre= nombre;
		this.area = area;
		this.experienciaPrevia = experienciaPrevia;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getExperienciaPrevia() {
		return experienciaPrevia;
	}

	public void setExperienciaPrevia(String experienciaPrevia) {
		this.experienciaPrevia = experienciaPrevia;
	}

	@Override
	public String toString() {
		return super.toString() +" [nombre=" + nombre + ", area=" + area + ", experienciaPrevia=" + experienciaPrevia + "]";
	}

	

}
