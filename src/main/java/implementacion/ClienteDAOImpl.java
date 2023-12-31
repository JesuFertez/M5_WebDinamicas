package implementacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import conexion.Conexion;
import interfaces.IClienteDAO;
import model.Cliente;
import model.TipoUsuario;
import model.Usuario;

public class ClienteDAOImpl extends UsuarioDAOImpl implements IClienteDAO {

	
	public void actualizarCliente(Cliente usuario) {
	    if (!(usuario instanceof Cliente)) {
	        throw new IllegalArgumentException("El usuario no es del tipo Cliente.");
	    }

	    Cliente cliente = (Cliente) usuario;
	    String SQL_UPDATE = "UPDATE Cliente SET nombres = ?, apellidos = ?, telefono = ?, direccion = ?, comuna = ?, edad = ?, rut = ? WHERE id = ?";

	    try (Connection conn = Conexion.getConn();
	         PreparedStatement stmt = conn.prepareStatement(SQL_UPDATE)) {

	        stmt.setString(1, cliente.getNombres());
	        stmt.setString(2, cliente.getApellidos());
	        stmt.setInt(3, cliente.getTelefono());
	        stmt.setString(4, cliente.getDireccion());
	        stmt.setString(5, cliente.getComuna());
	        stmt.setInt(6, cliente.getEdad());
	        stmt.setInt(7, cliente.getRut());
	        stmt.setInt(8, cliente.getId());

	        int registros = stmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace(System.out);
	    }

	    // Actualizar la tabla Usuario
	    Usuario usuarioCliente = new Usuario(cliente.getId(), cliente.getNombre(), cliente.getContraseña(), TipoUsuario.Cliente);
	    actualizarUsuario(usuarioCliente);
	}



	public List<Usuario> obtenerClientes() {
	    String SQL_SELECT = "SELECT u.id, u.nombre, c.nombres, c.apellidos, c.telefono, c.direccion, c.comuna, c.edad, c.rut "
	    		+ "FROM Usuarios AS u INNER JOIN Cliente AS c ON u.id = c.id WHERE tipo = 'Cliente'";
	    List<Usuario> clientes = new ArrayList<>();

	    try {
	        Connection conn = Conexion.getConn();
	        PreparedStatement stmt = conn.prepareStatement(SQL_SELECT);
	        ResultSet rs = stmt.executeQuery();

	        while (rs.next()) {
	            int id = rs.getInt("id");
	            String nombre = rs.getString("nombre");
	            String nombres= rs.getString("nombres");
	            String apellidos = rs.getString("apellidos");
	            int telefono = rs.getInt("telefono");
	            String direccion = rs.getString("direccion");
	            String comuna = rs.getString("comuna");
	            int edad = rs.getInt("edad");
	            int rut = rs.getInt("rut");
	        
	            Cliente cliente = new Cliente(id, nombre, nombres, apellidos, telefono, direccion, comuna, edad, rut);
	            clientes.add(cliente);
	        }
	        rs.close();
	        stmt.close();
	        conn.close();
	    } catch (SQLException e) {
	        e.printStackTrace(System.out);
	    }

	    return clientes;
	}


	
	public Cliente obtenerCliente(int id) {
	    String SQL_SELECT = "SELECT c.nombres, c.apellidos, c.telefono, c.direccion, c.comuna, c.edad, c.rut, u.nombre, u.contrasena " +
	                        "FROM Cliente c " +
	                        "JOIN Usuarios u ON c.id = u.id " +
	                        "WHERE c.id = ?";
	    Cliente cliente = null;

	    try (Connection conn = Conexion.getConn();
	         PreparedStatement stmt = conn.prepareStatement(SQL_SELECT)) {

	        stmt.setInt(1, id);
	        try (ResultSet rs = stmt.executeQuery()) {
	            if (rs.next()) {
	                String nombres = rs.getString("nombres");
	                String apellidos = rs.getString("apellidos");
	                int telefono = rs.getInt("telefono");
	                String direccion = rs.getString("direccion");
	                String comuna = rs.getString("comuna");
	                int edad = rs.getInt("edad");
	                int rut = rs.getInt("rut");
	                String nombre = rs.getString("nombre");
	                String contraseña = rs.getString("contrasena");
	                cliente = new Cliente(id, nombre, contraseña, nombres, apellidos, telefono, direccion, comuna, edad, rut);
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace(System.out);
	    }
	    return cliente;
	}

	public int crearCliente(Cliente cliente) {
	    String SQL_INSERT = "INSERT INTO Cliente (id, nombres, apellidos, telefono, direccion, comuna, edad, rut) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	    int registros = 0;

	    try (Connection conn = Conexion.getConn();
	         PreparedStatement stmt = conn.prepareStatement(SQL_INSERT)) {

	        stmt.setInt(1, cliente.getId());
	        stmt.setString(2, cliente.getNombres());
	        stmt.setString(3, cliente.getApellidos());
	        stmt.setInt(4, cliente.getTelefono());
	        stmt.setString(5, cliente.getDireccion());
	        stmt.setString(6, cliente.getComuna());
	        stmt.setInt(7, cliente.getEdad());
	        stmt.setInt(8, cliente.getRut());

	        registros = stmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace(System.out);
	    }

	    return registros;
	}

}
