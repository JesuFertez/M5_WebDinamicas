package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import implementacion.ClienteDAOImpl;
import implementacion.UsuarioDAOImpl;
import interfaces.IClienteDAO;
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
	private IClienteDAO usuarioDAO = new ClienteDAOImpl();
       
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
			
	    	int id = Integer.valueOf(request.getParameter("idRescatado").toString());
			Cliente cliente = usuarioDAO.obtenerCliente(id);
			request.setAttribute("usuario", cliente);
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

		int id = Integer.valueOf(request.getParameter("idUsuario"));
		System.out.println(id);
		String nombres = request.getParameter("nombres");
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
		response.sendRedirect(request.getContextPath() + "/ListadoUsuarios");
	}
		
}
