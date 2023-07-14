package model;


public class Administrativo extends Usuario {
	
	private String nombreAdmin;
	private String area;
	private String experienciaPrevia;

	public Administrativo() {
		super();
	}
	
	public Administrativo(int id, String nombreUsuario, String contraseña, TipoUsuario tipo) {
		super(id,nombreUsuario,contraseña,tipo);
	}

	public Administrativo(int id, String nombreUsuario,String contraseña,String nombreAdmin, String area, String experienciaPrevia) {
		super(id, nombreUsuario,contraseña, TipoUsuario.Administrativo);
		this.nombreAdmin= nombreAdmin;
		this.area = area;
		this.experienciaPrevia = experienciaPrevia;
	}
	
	
	
	public String getNombreAdmin() {
		return nombreAdmin;
	}

	public void setNombreAdmin(String nombre) {
		this.nombreAdmin = nombre;
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
		return super.toString() +" [nombre=" + nombreAdmin + ", area=" + area + ", experienciaPrevia=" + experienciaPrevia + "]";
	}

}
