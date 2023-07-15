package controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import implementacion.AdministrativoDAOImpl;
import implementacion.ClienteDAOImpl;
import implementacion.ProfesionalDAOImpl;
import model.Usuario;

/**
 * Servlet implementation class ListarPorTipoUsuario
 */
@WebServlet("/ListarPorTipoUsuario")
public class ListarPorTipoUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdministrativoDAOImpl iAdmin = new AdministrativoDAOImpl();
	private ClienteDAOImpl iCliente = new ClienteDAOImpl();
	private ProfesionalDAOImpl iProf = new ProfesionalDAOImpl();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListarPorTipoUsuario() {
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
		HttpSession session = request.getSession();
		String accion = request.getParameter("accion");

		// validacion de usuario logeado
		String nombreUsuario = (String)session.getAttribute("nombreUsuario");
		String tipoUsuario = (String)session.getAttribute("tipoUsuario");
		Boolean mostrarCampos = tipoUsuario.equals("Cliente") || tipoUsuario.equals("Administrativo");
		
		
		if (session != null  && nombreUsuario != null && mostrarCampos) {
			
			if (accion != null) {
				switch (accion) {

				case "listarCliente":
					System.out.println("Listare clientes");
					List<Usuario>listaClientes= iCliente.obtenerClientes();
					session.setAttribute("listaClientes", listaClientes);
					System.out.println(listaClientes);
					getServletContext().getRequestDispatcher("/views/listado-clientes.jsp").forward(request, response);
					break;

				case "listarProfesional":
					System.out.println("Listare profesionales");
					List<Usuario>listaProf= iProf.obtenerProfesionales();
					session.setAttribute("listaProf", listaProf);
					System.out.println(listaProf);
					getServletContext().getRequestDispatcher("/views/listado-profesionales.jsp").forward(request, response);
					break;

				case "listarAdministrativo":
					System.out.println("Listare administrativos");
					List<Usuario>listaAdmin= iAdmin.obtenerAdministrativos();
					session.setAttribute("listaAdmin", listaAdmin);
					getServletContext().getRequestDispatcher("/views/listado-administrativos.jsp").forward(request, response);
					break;
				}
			}

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
	}/*
	UsuarioDAOImpl usuarioDAO = new UsuarioDAOImpl();
			    	List<Usuario> listaUsuarios= usuarioDAO.obtenerUsuarios();
					System.out.println("-Lista desplegada en listado-usuarios.jsp");

			    	session.setAttribute("listaUsuarios", listaUsuarios);
			    	
	*/

}
