package model;

import java.time.LocalDate;

public class Administrativo extends Usuario {

	String area;
	String experienciaPrevia;

	public Administrativo() {
	}

	public Administrativo(int id, String nombreUsuario, String area, String experienciaPrevia) {
		super(id, nombreUsuario, TipoUsuario.Administrativo);
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
		return super.toString() + " [area=" + area + ", experienciaPrevia=" + experienciaPrevia + "]";
	}

}
