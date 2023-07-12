package model;

public enum TipoUsuario {
	Cliente,
	Administrativo,
	Profesional;
	
public static TipoUsuario parse(String text) {
		
		if(Cliente.name().equalsIgnoreCase(text)) {
			return Cliente;
		}else if(Administrativo.name().equalsIgnoreCase(text)) {
			return Administrativo;
		}else {
			return Profesional;
		}
	}
}

