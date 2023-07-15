package interfaces;

import java.util.List;

import model.Cliente;
import model.Usuario;

public interface IUsuarioDAO {
	
	public int crearUsuario(Usuario usu);
	public List<Usuario>obtenerUsuarios();
	public Usuario obtenerUsuario(int id);
	public int actualizarUsuario(Usuario usu);
	public int borrarUsuario(Usuario usu);
	public Usuario obtenerUsuarioPorNombreYContraseña(String nombreUsuario, String contraseña);
}
