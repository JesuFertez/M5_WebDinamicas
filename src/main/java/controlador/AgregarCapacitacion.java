package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import implementacion.CapacitacionDAO;
import interfaces.ICapacitacionDAO;
import model.Capacitacion;

/**
 * Servlet implementation class AgregarCapacitacion
 */
@WebServlet("/AgregarCapacitacion")
public class AgregarCapacitacion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ICapacitacionDAO capacitacionDAO = new CapacitacionDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgregarCapacitacion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			//Obteniendo parametros del formulario
			int id = capacitacionDAO.obtenerCapacitaciones().size()+1; //en un futuro la base de datos asignará el id
			String nombre = request.getParameter("nombre");
			String detalle = request.getParameter("detalle");
	        int rutCliente = Integer.valueOf(request.getParameter("rutCliente"));
	        String dia = request.getParameter("dia");
	        String hora = request.getParameter("hora");
	        String lugar = request.getParameter("lugar");
	        String duracion = request.getParameter("duracion");
	        int cantidadAsistentes = Integer.valueOf(request.getParameter("cantidadAsistentes"));
			//Creando nueva capacitacion
			Capacitacion capacitacion = new Capacitacion(id,nombre,detalle,rutCliente,dia,hora,lugar,duracion,cantidadAsistentes);
			capacitacionDAO.agregarCapacitacion(capacitacion);
			
			// Establecer el mensaje de éxito como atributo de solicitud
			request.setAttribute("mensaje", "La Capacitacion se ha agregado correctamente.");
			
			//Redireccionar a web de exito
			getServletContext().getRequestDispatcher("/views/exito.jsp").forward(request, response);
			
			
		} catch (Exception e) {
			System.out.println("Error en AgregarCapacitacion Servlet: "+e);
		}
	}

}
