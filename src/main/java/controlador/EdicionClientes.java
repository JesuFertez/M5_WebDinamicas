package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import implementacion.ClienteDAOImpl;
import implementacion.UsuarioDAOImpl;
import interfaces.IClienteDAO;
import interfaces.IUsuarioDAO;
import model.Cliente;

/**
 * Servlet implementation class EdicionClientes
 */
@WebServlet("/EdicionClientes")
public class EdicionClientes extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IClienteDAO usuarioDAO = new ClienteDAOImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EdicionClientes() {
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

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
}
