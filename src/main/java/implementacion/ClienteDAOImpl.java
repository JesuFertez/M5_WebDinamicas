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
	    // Validar si el usuario es del tipo Cliente
	    if (usuario.getTipo() == TipoUsuario.Cliente) {
	        Cliente cliente = (Cliente) usuario;
	        // Actualizar los campos específicos del tipo Cliente en la base de datos
	        String SQL_UPDATE = "UPDATE Cliente SET nombres = ?, apellidos = ?, telefono = ?, direccion = ?, comuna = ?, edad = ?, rut = ? WHERE id = ?";
	        try {
	            Connection conn = Conexion.getConn();
	            PreparedStatement stmt = conn.prepareStatement(SQL_UPDATE);
	            stmt.setString(1, cliente.getNombres());
	            stmt.setString(2, cliente.getApellidos());
	            stmt.setInt(3, cliente.getTelefono());
	            stmt.setString(4, cliente.getDireccion());
	            stmt.setString(5, cliente.getComuna());
	            stmt.setInt(6, cliente.getEdad());
	            stmt.setInt(7, cliente.getRut());
	            stmt.setInt(8, cliente.getId());
	            int registros = stmt.executeUpdate();
	            stmt.close();
	            conn.close();
	        } catch (SQLException e) {
	            e.printStackTrace(System.out);
	        }
	        //Actualizar la tabla Usuario
	        Usuario usuarioCliente= new Usuario(cliente.getId(),cliente.getNombre(),cliente.getContraseña(),TipoUsuario.Cliente);
	        actualizarUsuario(usuarioCliente);
	    } else {
	        throw new IllegalArgumentException("El usuario no es del tipo Cliente.");
	    }
	}


	public List<Usuario> obtenerClientes() {
	    String SQL_SELECT = "SELECT id, nombres, apellidos, telefono, direccion, comuna, edad, rut FROM Usuarios INNER JOIN Cliente ON Usuarios.id = Cliente.id WHERE tipo = 'Cliente'";
	    List<Usuario> clientes = new ArrayList<>();

	    try {
	        Connection conn = Conexion.getConn();
	        PreparedStatement stmt = conn.prepareStatement(SQL_SELECT);
	        ResultSet rs = stmt.executeQuery();

	        while (rs.next()) {
	            int id = rs.getInt("id");
	            String nombres = rs.getString("nombres");
	            String apellidos = rs.getString("apellidos");
	            int telefono = rs.getInt("telefono");
	            String direccion = rs.getString("direccion");
	            String comuna = rs.getString("comuna");
	            int edad = rs.getInt("edad");
	            int rut = rs.getInt("rut");
	            Usuario usuario = obtenerUsuario(id);
	            String nombre = usuario.getNombre();
	            Cliente cliente = new Cliente(id, nombre, "", nombres, apellidos, telefono, direccion, comuna, edad, rut);
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


	
	public Cliente obtenerCliente (int id) {
		String SQL_SELECT_FROM ="SELECT id, nombres, apellidos, telefono, direccion, comuna, edad, rut FROM Cliente WHERE id=";
		Cliente cli=null;
		Usuario usu = obtenerUsuario(id);
		
		try {
			Connection conn = Conexion.getConn();
			Statement stmt =conn.createStatement();
			ResultSet rs= stmt.executeQuery(SQL_SELECT_FROM+id);
			System.out.println("Ejecutando query ");
			if(rs.next()) {
				cli = new Cliente(rs.getInt(id),usu.getNombre(),usu.getContraseña(), rs.getString("nombres"),
						 rs.getString("apellidos"), rs.getInt("telefono"), rs.getString("direccion"), rs.getString("comuna"),
						 rs.getInt("edad"), rs.getInt("rut"));
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			
			e.printStackTrace(System.out);
		}
		return cli;
	}
	public int crearCliente(Cliente cliente) {
		String SQL_INSERT = "INSERT INTO Cliente (id, nombres, apellidos, telefono, direccion, comuna, edad, rut)VALUES(?,?,?,?,?,?,?,?);";
		
		int registros=0;
		Connection conn;
		PreparedStatement stmt;
		
		try {
			conn= Conexion.getConn();
			stmt = conn.prepareStatement(SQL_INSERT);
			stmt.setInt(1,cliente.getId());
			stmt.setString(2,cliente.getNombres());
			stmt.setString(3,cliente.getApellidos());
			stmt.setInt(4,cliente.getTelefono());
			stmt.setString(5, cliente.getDireccion());
			stmt.setString(6, cliente.getComuna());
			stmt.setInt(7,cliente.getEdad());
			stmt.setInt(8,cliente.getRut());
			registros = stmt.executeUpdate();
			
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace(System.out);
		}
		return registros;
	}
}
