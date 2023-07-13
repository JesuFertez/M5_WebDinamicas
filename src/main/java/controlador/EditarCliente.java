package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import implementacion.UsuarioDAOImpl;
import interfaces.IUsuarioDAO;
import model.Cliente;
import model.TipoUsuario;
import model.Usuario;
import utils.ValidarDatos;

/**
 * Servlet implementation class EditarCliente
 */
@WebServlet("/EditarCliente")
public class EditarCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IUsuarioDAO usuarioDAO = new UsuarioDAOImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarCliente() {
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
			getServletContext().getRequestDispatcher("/views/editar-usuario.jsp").forward(request, response);
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
		
		try {
			int id = Integer.valueOf(request.getParameter("id"));
			usuarioDAO cliente = ;
				// Redireccionar a de editar
				getServletContext().getRequestDispatcher("/views/editar-usuario.jsp").forward(request, response);
		} catch (Exception e) {
			System.out.println("Error en EditarCliente Servlet: " + e);
		}
	}

}
