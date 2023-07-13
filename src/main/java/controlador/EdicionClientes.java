package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import implementacion.UsuarioDAOImpl;
import interfaces.IUsuarioDAO;
import model.Cliente;

/**
 * Servlet implementation class EdicionClientes
 */
@WebServlet("/EdicionClientes")
public class EdicionClientes extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IUsuarioDAO usuarioDAO = new UsuarioDAOImpl();

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

			int id = Integer.valueOf(request.getParameter("idCliente"));
			System.out.println(id);
			String nombres = request.getParameter("nombresCliente");
			System.out.println(nombres);
			String apellidos = request.getParameter("apellidos");
			System.out.println(apellidos);
			int telefono = Integer.valueOf(request.getParameter("telefono"));

			String direccion = request.getParameter("direccion");
			String comuna = request.getParameter("comuna");
			int edad = Integer.valueOf(request.getParameter("edad"));
			int rut = Integer.valueOf(request.getParameter("rut"));

			Cliente cliente = new Cliente(id,nombres,apellidos,telefono,direccion,comuna,edad,rut);
			if(usuarioDAO.obtenerCliente(cliente.getId()) != null) {
				usuarioDAO.actualizarCliente(cliente);
				System.out.println("El cliente se ha actualizado correctamente");
			}else {
				usuarioDAO.crearCliente(cliente);
				System.out.println("El cliente se ha ingresado correctamente");
			}
	}
}
