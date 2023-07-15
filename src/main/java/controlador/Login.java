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
import model.Usuario;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IUsuarioDAO usuarioDAO = new UsuarioDAOImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		getServletContext().getRequestDispatcher("/views/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nombreUsuario = request.getParameter("usuario");
		String password = request.getParameter("password");
		// Obtenemos la sesion y validamos si ingresa con exito
		HttpSession sesion = request.getSession(true);
		sesion.setAttribute("nombreUsuario", nombreUsuario);
		Usuario usuario = usuarioDAO.obtenerUsuarioPorNombreYContraseña(nombreUsuario, password);
		System.out.println(usuario);
		if (usuario != null) {
			sesion.setAttribute("ingreso", true);
			sesion.setAttribute("tipoUsuario", usuario.getTipo().toString());
			getServletContext().getRequestDispatcher("/views/index.jsp").forward(request, response);
			System.out.println("** Inicio de sesión exitoso, usuario "+ nombreUsuario);
		} else {
			getServletContext().getRequestDispatcher("/views/login.jsp").forward(request, response);
		}
	}

}
