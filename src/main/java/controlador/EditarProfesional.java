package controlador;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import implementacion.ProfesionalDAOImpl;
import interfaces.IProfesionalDAO;
import model.Profesional;
import model.TipoUsuario;
import model.Usuario;

/**
 * Servlet implementation class EditarCliente
 */
@WebServlet("/EditarProfesional")
public class EditarProfesional extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IProfesionalDAO usuarioDAO = new ProfesionalDAOImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarProfesional() {
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
			Profesional pro = usuarioDAO.obtenerProfesional(id);
	    	if(pro == null) {
	    		Usuario usu = usuarioDAO.obtenerUsuario(id);
	    		pro = new Profesional();
	    		pro.setId(id);
	    		pro.setNombre(usu.getNombre());
	    		pro.setTipo(TipoUsuario.Profesional);
	    	}
			request.setAttribute("usuario", pro);
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
		String contrasena = request.getParameter("contraseña");
		String nombreUsuario = request.getParameter("nombreUsuario");
		String nombre = request.getParameter("nombre");
		String titulo = request.getParameter("titulo");
		LocalDate fechaIngreso = LocalDate.parse(request.getParameter("fechaIngreso"));
		int id = Integer.valueOf(request.getParameter("idUsuario"));
		
		Profesional pro = new Profesional(id,nombreUsuario,contrasena,nombre,titulo,fechaIngreso);
		String mensaje;
		Boolean mostrarAlert = false;
		if(usuarioDAO.obtenerProfesional(pro.getId()) != null) {
			usuarioDAO.actualizarProfesional(pro);
			mensaje="El profesional se ha actualizado correctamente";
			mostrarAlert= true;
			System.out.println("El cliente se ha actualizado correctamente");
		}else {
			usuarioDAO.crearProfesional(pro);
			mensaje="El profesional se ha actualizado correctamente";
			mostrarAlert= true;
			System.out.println("El cliente se ha ingresado correctamente");
		}
		request.setAttribute("mostrarAlert", mostrarAlert);
		request.setAttribute("mensaje", mensaje);
		response.sendRedirect(request.getContextPath() + "/ListadoUsuarios");
	}

}
