package servlet;
import model.Capacitacion;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CrearCapacitacion
 */
@WebServlet("/CrearCapacitacion")
public class CrearCapacitacion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrearCapacitacion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		getServletContext().getRequestDispatcher("/views/crearCapacitacion.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//Obteniendo parametros del formulario
		int id = Integer.valueOf(request.getParameter("idCapacitacion"));
		int rutCliente = Integer.valueOf(request.getParameter("rutCliente"));
		String dia = request.getParameter("dia");
		String hora = request.getParameter("hora");
		String lugar = request.getParameter("lugar");
		String duracion = request.getParameter("duracion");
		int cantidadAsistentes = Integer.valueOf(request.getParameter("cantidadAsistentes"));
		
		//Creando nueva capacitacion
		Capacitacion capacitacion = new Capacitacion(id,rutCliente,dia,hora,lugar,duracion,cantidadAsistentes);
		
		// Establecer el mensaje de éxito como atributo de solicitud
		request.setAttribute("mensaje", "La Capacitacion se ha agregado correctamente.");
		
		//Redireccionar a web de exito
		getServletContext().getRequestDispatcher("/views/exito.jsp").forward(request, response);
	}

}
