package interfaces;

import model.Cliente;
import model.Usuario;

public interface IClienteDAO {

	public void actualizarCliente(Cliente cliente);
	public int crearCliente(Cliente cliente);
	public Cliente obtenerCliente (int id);
	public Usuario obtenerUsuario(int id);
}
