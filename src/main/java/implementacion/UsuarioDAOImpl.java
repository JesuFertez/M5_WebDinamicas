package implementacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import conexion.Conexion;
import interfaces.IUsuarioDAO;
import model.Administrativo;
import model.Cliente;
import model.Profesional;
import model.TipoUsuario;
import model.Usuario;

public class UsuarioDAOImpl implements IUsuarioDAO {

	@Override
	public int crearUsuario(Usuario usu) {
		String SQL_INSERT = "INSERT INTO Usuarios(nombre, contrasena,tipo)VALUES(?,?,?)";
		int registros=0;
		Connection conn;
		PreparedStatement stmt;
		
		try {
			conn= Conexion.getConn();
			stmt = conn.prepareStatement(SQL_INSERT);
			stmt.setString(1,usu.getNombre());
			stmt.setString(2,usu.getContraseña());
			stmt.setString(3,usu.getTipo().toString());
			registros = stmt.executeUpdate();
			
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace(System.out);
		}
		return registros;
	}

	@Override
	public List<Usuario> obtenerUsuarios() {
		String SQL_SELECT = "SELECT id, nombre, tipo FROM Usuarios";
		List <Usuario> usuarios = new ArrayList<>();
		
		try {
			Connection conn = Conexion.getConn();
			PreparedStatement stmt = conn.prepareStatement(SQL_SELECT);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				String tipo = rs.getString("tipo");
				
				usuarios.add(new Usuario(id, nombre, TipoUsuario.parse(tipo)));
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			
			e.printStackTrace(System.out);
		}
		
		return usuarios;
	}

	@Override
	public Usuario obtenerUsuario(int id) {
		String SQL_SELECT_FROM =" SELECT id nombre, tipo from Usuario WHERE id=";
		Usuario usu=null;
		
		try {
			Connection conn = Conexion.getConn();
			Statement stmt =conn.createStatement();
			ResultSet rs= stmt.executeQuery(SQL_SELECT_FROM+id);
			
			if(rs.next()) {
				usu = new Usuario(rs.getInt(id), rs.getString("nombre"), TipoUsuario.parse(rs.getString("tipo")));
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			
			e.printStackTrace(System.out);
		}
		return usu;
	}

	@Override
	public int actualizarUsuario(Usuario usu) {
		String SQL_UPDATE =" UPDATE Usuario SET nombre = ?, SET contraseña = ?, SET tipo = ? WHERE id = ?";
		int registros=0;
		try {
			Connection conn = Conexion.getConn();
			PreparedStatement stmt = conn.prepareStatement(SQL_UPDATE);
			stmt.setString(1,usu.getNombre());
			stmt.setString(2,usu.getContraseña());
			stmt.setString(3,usu.getTipo().toString());
			stmt.setInt(4,usu.getId());
			
			registros= stmt.executeUpdate();
			
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(System.out);
		}
		
		return registros;
	}

	@Override
	public int borarUsuario(Usuario usu) {
		String SQL_DELETE="DELETE FROM Usuarios WHERE id =?";
		int registros =0;
		
		try {
			Connection conn = Conexion.getConn();
			PreparedStatement stmt= conn.prepareStatement(SQL_DELETE);
			stmt.setInt(1,usu.getId());
			registros= stmt.executeUpdate();
			
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			
			e.printStackTrace(System.out);
		}
		
		return registros;
	}
	
	//Metodos para los tipos de usuarios
	public void actualizarCliente(Usuario usuario) {
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

	public void actualizarProfesional(Usuario usuario) {
	    // Validar si el usuario es del tipo Profesional
	    if (usuario.getTipo() == TipoUsuario.Profesional) {
	        Profesional profesional = (Profesional) usuario;
	        // Actualizar los campos específicos del tipo Profesional en la base de datos
	        String SQL_UPDATE = "UPDATE Profesional SET nombre = ?, titulo = ?, fechaIngreso = ? WHERE id = ?";
	        try {
	            Connection conn = Conexion.getConn();
	            PreparedStatement stmt = conn.prepareStatement(SQL_UPDATE);
	            stmt.setString(1, profesional.getNombre());
	            stmt.setString(2, profesional.getTitulo());
	            stmt.setDate(3, java.sql.Date.valueOf(profesional.getFechaIngreso()));
	            stmt.setInt(4, profesional.getId());
	            int registros = stmt.executeUpdate();
	            stmt.close();
	            conn.close();
	        } catch (SQLException e) {
	            e.printStackTrace(System.out);
	        }
	        //Actualizar la tabla Usuario
	        Usuario usuarioPro= new Usuario(profesional.getId(),profesional.getNombre(),profesional.getContraseña(),TipoUsuario.Profesional);
	        actualizarUsuario(usuarioPro);
	    } else {
	        throw new IllegalArgumentException("El usuario no es del tipo Profesional.");
	    }
	}

	public void actualizarAdministrativo(Usuario usuario) {
	    // Validar si el usuario es del tipo Administrativo
	    if (usuario.getTipo() == TipoUsuario.Administrativo) {
	        Administrativo administrativo = (Administrativo) usuario;
	        // Actualizar los campos específicos del tipo Administrativo en la base de datos
	        String SQL_UPDATE = "UPDATE Administrativo SET nombre = ?, area = ?, experienciaPrevia = ? WHERE id = ?";
	        try {
	            Connection conn = Conexion.getConn();
	            PreparedStatement stmt = conn.prepareStatement(SQL_UPDATE);
	            stmt.setString(1, administrativo.getNombre());
	            stmt.setString(2, administrativo.getArea());
	            stmt.setString(3, administrativo.getExperienciaPrevia());
	            stmt.setInt(4, administrativo.getId());
	            int registros = stmt.executeUpdate();
	            stmt.close();
	            conn.close();
	        } catch (SQLException e) {
	            e.printStackTrace(System.out);
	        }
	        //Actualizar la tabla Usuario
	        Usuario usuarioAdmin= new Usuario(administrativo.getId(),administrativo.getNombre(),administrativo.getContraseña(),TipoUsuario.Cliente);
	        actualizarUsuario(usuarioAdmin);
	    } else {
	        throw new IllegalArgumentException("El usuario no es del tipo Administrativo.");
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

	public List<Usuario> obtenerProfesionales() {
	    String SQL_SELECT = "SELECT id, nombre, titulo, fechaIngreso FROM Usuario INNER JOIN Profesional ON Usuarios.id = Profesional.id WHERE tipo = 'Profesional'";
	    List<Usuario> profesionales = new ArrayList<>();

	    try {
	        Connection conn = Conexion.getConn();
	        PreparedStatement stmt = conn.prepareStatement(SQL_SELECT);
	        ResultSet rs = stmt.executeQuery();

	        while (rs.next()) {
	            int id = rs.getInt("id");
	            String nombre = rs.getString("nombre");
	            String titulo = rs.getString("titulo");
	            LocalDate fechaIngreso = rs.getDate("fechaIngreso").toLocalDate();
	            Usuario usuario = obtenerUsuario(id);
	            String nombreUsuario = usuario.getNombre();
	            Profesional profesional = new Profesional(id, nombreUsuario , "", nombre, titulo, fechaIngreso);
	            profesionales.add(profesional);
	        }
	        rs.close();
	        stmt.close();
	        conn.close();
	    } catch (SQLException e) {
	        e.printStackTrace(System.out);
	    }

	    return profesionales;
	}

	public List<Usuario> obtenerAdministrativos() {
	    String SQL_SELECT = "SELECT id, nombre , area, experienciaPrevia FROM Usuario INNER JOIN Administrativo ON Usuarios.id = Administrativo.id WHERE tipo = 'Administrativo'";
	    List<Usuario> administrativos = new ArrayList<>();

	    try {
	        Connection conn = Conexion.getConn();
	        PreparedStatement stmt = conn.prepareStatement(SQL_SELECT);
	        ResultSet rs = stmt.executeQuery();

	        while (rs.next()) {
	            int id = rs.getInt("id");
	            String nombre = rs.getString("nombre");
	            String area = rs.getString("area");
	            String experienciaPrevia = rs.getString("experienciaPrevia");
	            Usuario usuario = obtenerUsuario(id);
	            String nombreUsuario = usuario.getNombre();
	            
	            Administrativo administrativo = new Administrativo(id, nombreUsuario ,"", nombre, area, experienciaPrevia);
	            administrativos.add(administrativo);
	        }
	        rs.close();
	        stmt.close();
	        conn.close();
	    } catch (SQLException e) {
	        e.printStackTrace(System.out);
	    }

	    return administrativos;
	}

	public Cliente obtenerCliente (int id) {
		String SQL_SELECT_FROM ="SELECT id, nombres, apellidos, telefono, direccion, comuna, edad, rut FROM Cliente WHERE id=";
		Cliente cli=null;
		Usuario usu = obtenerUsuario(id);
		try {
			Connection conn = Conexion.getConn();
			Statement stmt =conn.createStatement();
			ResultSet rs= stmt.executeQuery(SQL_SELECT_FROM+id);
			
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
}
