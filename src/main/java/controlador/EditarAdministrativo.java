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
@WebServlet("/EditarAdministrativo")
public class EditarAdministrativo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IUsuarioDAO usuarioDAO = new UsuarioDAOImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarAdministrativo() {
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
	    	String id = request.getParameter("id");
	    	
	    	Usuario usuario = usuarioDAO.obtenerUsuario(Integer.parseInt(id));
	    	request.setAttribute("usuario", usuario);
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
			String nombre = request.getParameter("nombre");
			String contrasena = request.getParameter("contraseña");
			String tipo = request.getParameter("tipo");

			// Validaciones de campos del formulario
			boolean todoOk = (ValidarDatos.esObligatorio(nombre) && ValidarDatos.esObligatorio(contrasena)
					&& ValidarDatos.esObligatorio(tipo));

			if (todoOk) {
				Usuario usuario = new Usuario(nombre, contrasena, TipoUsuario.parse(tipo));
				usuarioDAO.actualizarUsuario(usuario);
				request.setAttribute("mensaje", "Usuario modificado correctamente");

				// Redireccionar a web de exito
				getServletContext().getRequestDispatcher("/views/exito.jsp").forward(request, response);
			} else {
				getServletContext().getRequestDispatcher("/views/listado-usuarios.jsp").forward(request, response);
			}
		} catch (Exception e) {
			System.out.println("Error al modificar usuario Servlet: " + e);
		}
	}

}
