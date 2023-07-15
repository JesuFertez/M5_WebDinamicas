package controlador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import implementacion.CapacitacionDAOImpl;
import interfaces.ICapacitacionDAO;
import model.Capacitacion;
import utils.ValidarDatos;

/**
 * Servlet implementation class AgregarCapacitacion
 */
@WebServlet("/AgregarCapacitacion")
public class AgregarCapacitacion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ICapacitacionDAO capacitacionDAO = new CapacitacionDAOImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AgregarCapacitacion() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// Se obtiene la sesion actual
		HttpSession session = request.getSession();
		// validacion de usuario logeado
		String nombreUsuario = (String) session.getAttribute("nombreUsuario");
		String tipoUsuario = (String) session.getAttribute("tipoUsuario");
		if (session != null && nombreUsuario != null && tipoUsuario.equals("Administrativo")) {

			getServletContext().getRequestDispatcher("/views/crearCapacitacion.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			// Obteniendo parametros del formulario
			String nombre = request.getParameter("nombre");
			String detalle = request.getParameter("detalle");
			int rutCliente = Integer.parseInt(request.getParameter("rutCliente"));
			String dia = request.getParameter("dia").toLowerCase();
			String hora = request.getParameter("hora");
			String lugar = request.getParameter("lugar");
			String duracion = request.getParameter("duracion");
			int cantidadAsistentes = Integer.valueOf(request.getParameter("cantidadAsistentes"));

			// Validaciones a los campos del formulario
			boolean todoOk = (ValidarDatos.esObligatorio(nombre));
			if (todoOk) {
				// Creando nueva capacitacion
				Capacitacion capacitacion = new Capacitacion(nombre, detalle, rutCliente, dia, hora, lugar, duracion,
						cantidadAsistentes);
				capacitacionDAO.crearCapacitacion(capacitacion);

				// Establecer el mensaje de éxito como atributo de solicitud
				request.setAttribute("mensaje", "La Capacitacion se ha agregado correctamente.");

				// Redireccionar a web de exito
				getServletContext().getRequestDispatcher("/views/exito.jsp").forward(request, response);
			} else {
				System.out.println("No se creó la capacitacion en la BDD");
				getServletContext().getRequestDispatcher("/views/index.jsp").forward(request, response);

			}

		} catch (Exception e) {
			System.out.println("Error en AgregarCapacitacion Servlet: " + e);
		}
	}

}
