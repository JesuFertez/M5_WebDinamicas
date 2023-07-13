package interfaces;

import model.Cliente;

public interface IClienteDAO {

	public void actualizarCliente(Cliente cliente);
	public int crearCliente(Cliente cliente);
	public Cliente obtenerCliente (int id);
}
