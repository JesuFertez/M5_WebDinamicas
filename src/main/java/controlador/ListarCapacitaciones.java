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
			Capacitacion cap1= new Capacitacion(1,"Prevención de Riesgos","Esta capacitación proporciona una visión general "
					+ "de los conceptos básicos de la prevención de riesgos laborales, incluyendo identificación de riesgos, "
					+ "medidas preventivas y normativa aplicable.");
			Capacitacion cap2= new Capacitacion(2,"Taller de uso correcto del Extintor ","En esta capacitación se enseña a manipular "
					+ "correctamente los extintores según su tipo para cada ocasión de emergencia.");
			Capacitacion cap3= new Capacitacion(3,"Primeros auxilios en el trabajo","En esta capacitación se enseñan los "
					+ "principios básicos de primeros auxilios aplicados a situaciones de emergencia en el entorno laboral, "
					+ "incluyendo reanimación cardiopulmonar (RCP), control de hemorragias y atención inicial a lesiones comunes.");
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
