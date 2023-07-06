package controlador;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Administrativo;
import model.Cliente;
import model.Profesional;
import model.Usuario;

/**
 * Servlet implementation class ListadoUsuarios
 */
@WebServlet("/ListadoUsuarios")
public class ListadoUsuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListadoUsuarios() {
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
			    	//Creando usuarios por defecto
			    	List<Usuario> listaUsuarios= new ArrayList<>();
					Usuario usu1= new Administrativo(1,"marco","marco1234","Marco Antonio Soliz del Carmen","Recursos Humanos","5 años en gestión de personal para Ambrosoli.co");
					Usuario usu2= new Profesional(2,"maria","maria1234","María Josefa Castro Pérez","Técnico Lógistico",LocalDate.of(2020,11, 12));
					Usuario usu3= new Cliente(3,"cocacola","cocacola1234","Manuel Francisco","Castillo Montesinos",985436622,"Las Parcelas Blancas #4455","Huechuraba",45,164425667);
					
					//Agregando usuarios
			    	listaUsuarios.add(usu1);
			    	listaUsuarios.add(usu2);
			    	listaUsuarios.add(usu3);
			    	
			    	//Enviado lista por el request
			    	request.setAttribute("listaUsuarios", listaUsuarios);
			    	//Redireccionando a la vista para ver las capacitaciones
			    	getServletContext().getRequestDispatcher("/views/listado-usuarios.jsp").forward(request, response);
			    } else {
			    	//redireccionando al login
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
