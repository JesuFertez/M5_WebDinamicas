package model;

import java.time.LocalDate;

public class Administrativo extends Usuario {

	String area;
	String experienciaPrevia;

	public Administrativo(String nombre, LocalDate fechaNacimiento, int run, String area, String experienciaPrevia) {
		super(nombre, fechaNacimiento, run);
		this.area = area;
		this.experienciaPrevia = experienciaPrevia;
	}

	public Administrativo() {
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
		return super.toString() + "\n �rea: " + area + "\n experiencia Previa: " + experienciaPrevia;
	}

	@Override
	public int analizarUsuario() {
		super.analizarUsuario();
		System.out.println("�rea: " + area);
		System.out.println("Experiencia previa: " + experienciaPrevia);

		return super.getRun();
	}
}
