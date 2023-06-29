package model;

/**
 * 
 * Interfaz que define los métodos comunes para las asesorías que implementa la Clase {@link Usuario}.
 */
public interface IAsesoria {
	/**
	 * 
	 * Analiza y devuelve el identificador del usuario asociado a la asesoría.
	 * 
	 * @return El identificador del usuario (RUN).
	 */
	public int analizarUsuario();
	public String mostrarUsuario();
	public int getRun();
}
