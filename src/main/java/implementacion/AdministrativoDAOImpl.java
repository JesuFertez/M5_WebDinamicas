package implementacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexion.Conexion;
import interfaces.IAdministrativoDAO;
import model.Administrativo;
import model.TipoUsuario;
import model.Usuario;

public class AdministrativoDAOImpl extends UsuarioDAOImpl implements IAdministrativoDAO {


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


    public Administrativo obtenerAdministrativo(int id) {
        String SQL_SELECT_FROM = "SELECT a.nombre, a.area, a.experienciaPrevia "
        		+ "FROM Administrativo a "
        		+ "JOIN Usuarios u ON a.id = u.id "
        		+ "WHERE a.id = ?";
       
        Administrativo admin = null;

        try {
            Connection conn = Conexion.getConn();
            PreparedStatement stmt = conn.prepareStatement(SQL_SELECT_FROM);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String nombre = rs.getString("nombre");
                String area = rs.getString("area");
                String experienciaPrevia = rs.getString("experienciaPrevia");
                String nombreUsuario = rs.getString("nombreUsuario");
                String contraseña = rs.getString("contraseña");
                admin = new Administrativo(id,nombreUsuario,contraseña,nombre, area, experienciaPrevia);
            }
           
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return admin;
    }

    public int crearAdministrativo(Administrativo administrativo) {
        String SQL_INSERT = "INSERT INTO Administrativo (id, nombre, area, experienciaPrevia) VALUES (?, ?, ?, ?)";

        int registros = 0;
        Connection conn;
        PreparedStatement stmt;

        try {
            conn = Conexion.getConn();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, administrativo.getId());
            stmt.setString(2, administrativo.getNombre());
            stmt.setString(3, administrativo.getArea());
            stmt.setString(4, administrativo.getExperienciaPrevia());
            registros = stmt.executeUpdate();

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return registros;
    }
}
