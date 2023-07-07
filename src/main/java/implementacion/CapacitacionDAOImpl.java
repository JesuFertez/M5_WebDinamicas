package implementacion;

import conexion.Conexion;
import interfaces.ICapacitacionDAO;
import model.Capacitacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CapacitacionDAOImpl implements ICapacitacionDAO {

	@Override
	public int crearCapacitacion(Capacitacion cap) {
		String SQL_INSERT = "INSERT INTO Capacitaciones(nombre, detalle,rut_cliente, dia, hora, lugar, duracion, cantidad_asistentes)VALUES(?,?,?,?,?,?,?,?)";

		int registros = 0;
		Connection conn;
		PreparedStatement stmt;

		try {
			conn = Conexion.getConn();
			stmt = conn.prepareStatement(SQL_INSERT); // Altera o modifica la base de datos
			stmt.setString(1, cap.getNombre());
			stmt.setString(2, cap.getDetalle());
			stmt.setInt(3, cap.getRutCliente());
			stmt.setString(4, cap.getDia());
			stmt.setString(5, cap.getHora());
			stmt.setString(6, cap.getLugar());
			stmt.setString(7, cap.getDuracion());
			stmt.setInt(8, cap.getCantidadAsistentes());
			registros = stmt.executeUpdate(); // INSERT-UPDATE-DELETE

			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(System.out);
		}
		return registros;
	}

	@Override
	public List<Capacitacion> obtenerCapacitaciones() {
		String SQL_SELECT = "SELECT id, nombre, detalle,rut_cliente, dia, hora, lugar, duracion, cantidad_asistentes FROM Capacitaciones";

		Capacitacion cap;
		List<Capacitacion> capacitaciones = new ArrayList<>();
		Connection conn;
		PreparedStatement stmt;
		ResultSet rs;
		try {
			conn = Conexion.getConn();
			stmt = conn.prepareStatement(SQL_SELECT);
			rs = stmt.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				String detalle = rs.getString("detalle");
				int rutCliente = rs.getInt("rut_cliente");
				String dia = rs.getString("dia");
				String hora = rs.getString("hora");
				String lugar = rs.getString("lugar");
				String duracion = rs.getString("duracion");
				int cantidadAsistentes = rs.getInt("cantidad_asistentes");

				cap = new Capacitacion(id, nombre, detalle, rutCliente, dia, hora, lugar, duracion, cantidadAsistentes);
				capacitaciones.add(cap);
			}
			
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace(System.out);

		}
		return capacitaciones;
	}

	@Override
	public Capacitacion obtenerCapacitacion(int id) {
		String SQL_SELECT_FROM = "SELECT id, nombre, detalle,rut_cliente, dia, hora, lugar, duracion, cantidad_asistentes FROM Capacitaciones WHERE id =";

		Capacitacion cap = null;

		try {
			Connection cn = Conexion.getConn();
			Statement stm = cn.createStatement();
			ResultSet rs = stm.executeQuery(SQL_SELECT_FROM + id);

			if (rs.next()) {
				cap = new Capacitacion(rs.getInt("id"), rs.getString("nombre"), rs.getString("detalle"),
						rs.getInt("rut_cliente"), rs.getString("dia"), rs.getString("hora"), rs.getString("lugar"),
						rs.getString("duracion"), rs.getInt("cantidad_asistentes"));
			}
			rs.close();
			stm.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return cap;
	}

	@Override
	public int actualizar(Capacitacion cap) {
		String SQL_UPDATE = "UPDATE Capacitacion SET nombre = ?, detalle = ?, rut_cliente = ?,"
				+ " dia = ?, hora = ?, lugar = ?, duracion = ?, cantidad_asistentes = ? WHERE id = ?";
		Connection conn;
		PreparedStatement stmt;
		int registros = 0;

		try {
			conn = Conexion.getConn();
			stmt = conn.prepareStatement(SQL_UPDATE);
			stmt.setString(1, cap.getNombre());
			stmt.setString(2, cap.getDetalle());
			stmt.setInt(3, cap.getRutCliente());
			stmt.setString(4, cap.getDia());
			stmt.setString(5, cap.getHora());
			stmt.setString(6, cap.getLugar());
			stmt.setString(7, cap.getDuracion());
			stmt.setInt(8, cap.getCantidadAsistentes());
			stmt.setInt(9, cap.getId());
			registros = stmt.executeUpdate(); // INSERT-UPDATE-DELETE

			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace(System.out);
		}

		return registros;

	}

	@Override
	public int borrarCapacitacion(Capacitacion cap) {
		String SQL_DELETE = "DELETE FROM Capacitacion WHERE id = ?";

		int registros = 0;

		try {
			Connection conn = Conexion.getConn();
			PreparedStatement stmt = conn.prepareStatement(SQL_DELETE);
			stmt.setInt(1, cap.getId());
			registros = stmt.executeUpdate(); // INSERT-UPDATE-DELETE

			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return registros;
	}

}
