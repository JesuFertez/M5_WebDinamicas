package interfaces;

import java.util.List;

import model.Usuario;

public interface IUsuarioDAO {
	
	public int crearUsuario(Usuario usu);
	public List<Usuario>obtenerUsuarios();
	public Usuario obtenerUsuario(int id);
	public int actualizarUsuario(Usuario usu);
	public int borarUsuario(Usuario usu);

}
