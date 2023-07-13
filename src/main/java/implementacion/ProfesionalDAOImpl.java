package implementacion;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
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

	    public Profesional obtenerProfesional(int id) {
	        String SQL_SELECT_FROM = "SELECT id, nombre, titulo, fechaIngreso FROM Profesional WHERE id = ?";
	        Profesional prof = null;
	        Usuario usu = obtenerUsuario(id);

	        try {
	            Connection conn = Conexion.getConn();
	            PreparedStatement stmt = conn.prepareStatement(SQL_SELECT_FROM);
	            stmt.setInt(1, id);
	            ResultSet rs = stmt.executeQuery();
	            System.out.println("Ejecutando query ");
	            if (rs.next()) {
	                String nombre = rs.getString("nombre");
	                String titulo = rs.getString("titulo");
		            LocalDate fechaIngreso = rs.getDate("fechaIngreso").toLocalDate();
	                prof = new Profesional(id, usu.getNombre(), usu.getContraseña(), nombre, titulo, fechaIngreso);
	            }
	            rs.close();
	            stmt.close();
	            conn.close();
	        } catch (SQLException e) {
	            e.printStackTrace(System.out);
	        }
	        return prof;
	    }

	    public int crearProfesional(Profesional profesional) {
	        String SQL_INSERT = "INSERT INTO Profesional (id, nombre, titulo, fechaIngreso) VALUES (?,?,?,?);";

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
