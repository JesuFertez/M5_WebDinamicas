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

import implementacion.UsuarioDAOImpl;
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
			    	
			    	UsuarioDAOImpl usuarioDAO = new UsuarioDAOImpl();
			    	List<Usuario> listaUsuarios= usuarioDAO.obtenerUsuarios();
					System.out.println("-Lista desplegada en listado-usuarios.jsp");

			    	session.setAttribute("listaUsuarios", listaUsuarios);
			    	
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
