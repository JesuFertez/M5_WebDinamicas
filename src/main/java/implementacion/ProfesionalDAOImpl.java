package implementacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import conexion.Conexion;
import interfaces.IProfesionalDAO;
import model.Profesional;
import model.TipoUsuario;
import model.Usuario;

public class ProfesionalDAOImpl extends UsuarioDAOImpl implements IProfesionalDAO {


	public void actualizarProfesional(Usuario usuario) {
	    // Validar si el usuario es del tipo Profesional
	    if (usuario.getTipo() == TipoUsuario.Profesional) {
	        Profesional profesional = (Profesional) usuario;
	    	if(profesional.getFechaIngreso()!= null) {// Actualizar los campos específicos del tipo Profesional en la base de datos
		        String SQL_UPDATE = "UPDATE Profesional SET nombre_p = ?, titulo = ?, fechaIngreso = ? WHERE id = ?";
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
		        System.out.println("fecha de ingreso null");
	    	}
	    } else {
	        throw new IllegalArgumentException("El usuario no es del tipo Profesional.");
	    }
	}
	public List<Usuario> obtenerProfesionales() {
	    String SQL_SELECT = "SELECT u.id, u.nombre, p.nombre_p, p.titulo, p.fechaIngreso FROM Usuario "
	    		+ " AS u INNER JOIN Profesional AS p ON u.id = p.id WHERE tipo = 'Profesional'";
	    List<Usuario> profesionales = new ArrayList<>();

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	    try {
	        Connection conn = Conexion.getConn();
	        PreparedStatement stmt = conn.prepareStatement(SQL_SELECT);
	        ResultSet rs = stmt.executeQuery();

	        while (rs.next()) {
	            int id = rs.getInt("id");
	            String nombre = rs.getString("nombre");
	            String nombreP = rs.getString("nombre_p");
	            String titulo = rs.getString("titulo");
	            LocalDate fechaIngreso = rs.getDate("fechaIngreso").toLocalDate();
	    		fechaIngreso = LocalDate.parse(fechaIngreso.format(formatter),formatter);
	            
	            Profesional profesional = new Profesional(id, nombre, nombreP, titulo, fechaIngreso);
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

	public Profesional obtenerProfesional(int id) {
	    String SQL_SELECT = "SELECT p.nombre_p, p.titulo, p.fechaIngreso, u.nombre, u.contrasena " +
	                        "FROM Profesional p " +
	                        "JOIN Usuarios u ON p.id = u.id " +
	                        "WHERE p.id = ?";
	    Profesional profesional = null;

		
	    try (Connection conn = Conexion.getConn();
	         PreparedStatement stmt = conn.prepareStatement(SQL_SELECT)) {

	        stmt.setInt(1, id);
	        try (ResultSet rs = stmt.executeQuery()) {
	            if (rs.next()) {
	                String nombre = rs.getString("nombre_p");
	                String titulo = rs.getString("titulo");
	                LocalDate fechaIngreso = rs.getDate("fechaIngreso").toLocalDate();
	                String usuarioNombre = rs.getString("nombre");
	                String contraseña = rs.getString("contrasena");
	                profesional = new Profesional(id, usuarioNombre, contraseña, nombre, titulo, fechaIngreso);
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace(System.out);
	    }

	    return profesional;
	}


	    public int crearProfesional(Profesional profesional) {
	        String SQL_INSERT = "INSERT INTO Profesional (id, nombre_p, titulo, fechaIngreso) VALUES (?,?,?,?);";

	        int registros = 0;
	        Connection conn;
	        PreparedStatement stmt;

	        try {
	            conn = Conexion.getConn();
	            stmt = conn.prepareStatement(SQL_INSERT);
	            stmt.setInt(1, profesional.getId());
	            stmt.setString(2, profesional.getNombre());
	            stmt.setString(3, profesional.getTitulo());
	            stmt.setDate(4, java.sql.Date.valueOf(profesional.getFechaIngreso()));
	            registros = stmt.executeUpdate();
	            stmt.close();
	            conn.close();
	        } catch (SQLException e) {
	            e.printStackTrace(System.out);
	        }
	        return registros;
	    }

}
