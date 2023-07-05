package controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Se obtiene la sesion actual
		HttpSession session = request.getSession();
		//validacion de usuario logeado
	    if (session != null && session.getAttribute("usuario") != null) {
	    	List<Capacitacion> listaCapacitaciones= new ArrayList<>();
	    	/*Capacitacion(int id, String nombre, String detalle, int rutCliente, String dia, String hora, String lugar,
	    			String duracion, int cantidadAsistentes)*/
	    	Capacitacion cap1 = new Capacitacion(1, "Prevencion de Riesgos", "Identificando y previniendo riesgos en el ambiente laboral", 123456789, "2023-07-05", "09:00", "Sala A", "2 horas", 20);

	    	Capacitacion cap2 = new Capacitacion(2, "Manipulación del Extintor", "Uso correcto, curso práctico", 987654321, "2023-07-10", "14:00", "Sala B", "3 horas", 15);

	    	Capacitacion cap3 = new Capacitacion(3, "Primeros Auxilios", "Conocimientos y habilidades para brindar asistencia inmediata", 555555555, "2023-07-15", "18:00", "Sala C", "4 horas", 30);

	    	listaCapacitaciones.add(cap1);
	    	listaCapacitaciones.add(cap2);
	    	listaCapacitaciones.add(cap3);
	    	request.setAttribute("listaCapacitaciones", listaCapacitaciones);
	    	//Redireccionando a la vista para ver las capacitaciones
	    	getServletContext().getRequestDispatcher("/views/listar-capacitaciones.jsp").forward(request, response);
	    } else {
	    	//redireccionando al login
	    	response.sendRedirect(request.getContextPath() + "/Login");
	    }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
