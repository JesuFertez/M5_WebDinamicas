package model;

public class Usuario {
	
	private int id;
	private String nombreUsuario;
	private String contraseña;
	private TipoUsuario tipo;
	
	public Usuario() {}
	
	public Usuario(int id) {
		super();
		this.id = id;
	}


	public Usuario(int id, String nombreUsuario, TipoUsuario tipo) {
		super();
		this.id = id;
		this.nombreUsuario = nombreUsuario;
		this.tipo = tipo;
	}

	public Usuario(String nombreUsuario, String contraseña, TipoUsuario tipo) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.contraseña= contraseña;
		this.tipo = tipo;
	}
	
	public Usuario(int id, String nombreUsuario, String contraseña, TipoUsuario tipo) {
		super();
		this.id = id;
		this.nombreUsuario = nombreUsuario;
		this.contraseña= contraseña;
		this.tipo = tipo;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombreUsuario;
	}
	public void setNombre(String nombre) {
		this.nombreUsuario = nombre;
	}
	
	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public TipoUsuario getTipo() {
		return tipo;
	}
	public void setTipo(TipoUsuario tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombreUsuario=" + nombreUsuario + ", tipo=" + tipo + "]";
	}
	
}
