package implementacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import conexion.Conexion;
import interfaces.IUsuarioDAO;
import model.TipoUsuario;
import model.Usuario;

public class UsuarioDaoImpl implements IUsuarioDAO {

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
		String SQL_SELECT_FROM =" SELECT id,nombre,tipo from Usuarios WHERE id=";
		Usuario usu=null;
		
		try {
			Connection conn = Conexion.getConn();
			Statement stmt =conn.createStatement();
			ResultSet rs= stmt.executeQuery(SQL_SELECT_FROM+id);
			if(rs.next()) {
				usu = new Usuario();
				usu.setId(rs.getInt(1));
				usu.setNombre(rs.getString(2));
				usu.setTipo(TipoUsuario.parse(rs.getString(3)));
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
	public int borrarUsuario(Usuario usu) {
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

}
