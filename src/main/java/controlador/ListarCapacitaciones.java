package controlador;

import java.io.IOException;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import conexion.Conexion;
import implementacion.CapacitacionDAOImpl;
import model.Capacitacion;

/**
 * Servlet implementation class ListarCapacitaciones
 */
@WebServlet("/ListarCapacitaciones")
public class ListarCapacitaciones extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListarCapacitaciones() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Se obtiene la sesion actual
		
		HttpSession session = request.getSession();
		// validacion de usuario logeado
		if (session != null && session.getAttribute("usuario") != null) {

			CapacitacionDAOImpl capacitacionDAO = new CapacitacionDAOImpl(); // Obtenemos la lista desde el DAO
			List<Capacitacion> listaCapacitaciones = capacitacionDAO.obtenerCapacitaciones();
			System.out.println("-Lista desplegada en listar-capacitaciones.jsp");

			session.setAttribute("listaCapacitaciones", listaCapacitaciones);

			// Redireccionando a la vista para ver las capacitaciones
			getServletContext().getRequestDispatcher("/views/listar-capacitaciones.jsp").forward(request, response);
		} else {
			// redireccionando al login
			response.sendRedirect(request.getContextPath() + "/Login");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
