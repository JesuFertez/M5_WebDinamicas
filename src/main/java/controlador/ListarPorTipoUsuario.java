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
	
	public ListarPorTipoUsuario() {
		super();
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String accion = request.getParameter("accion"); // Se rescata parámetro desde el navbar segun listado seleccionado

		// validacion de usuario logeado
		String nombreUsuario = (String)session.getAttribute("nombreUsuario");
		String tipoUsuario = (String)session.getAttribute("tipoUsuario");
		Boolean mostrarCampos = tipoUsuario.equals("Cliente") || tipoUsuario.equals("Administrativo");
		
		
		if (session != null  && nombreUsuario != null && mostrarCampos) {
			// Trae la consulta desde la base de datos y envía la respuesta al JSP correspondiente al tipo de usuario.	
			if (accion != null) {
				switch (accion) {

				case "listarCliente":
					List<Usuario>listaClientes= iCliente.obtenerClientes();
					session.setAttribute("listaClientes", listaClientes);
					getServletContext().getRequestDispatcher("/views/listado-clientes.jsp").forward(request, response);
					break;

				case "listarProfesional":
					List<Usuario>listaProf= iProf.obtenerProfesionales();
					session.setAttribute("listaProf", listaProf);
					getServletContext().getRequestDispatcher("/views/listado-profesionales.jsp").forward(request, response);
					break;

				case "listarAdministrativo":
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
