package controlador;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
		
		// Se obtiene la sesion actual
		HttpSession session = request.getSession();
		// validacion de usuario logeado
		String nombreUsuario = (String)session.getAttribute("nombreUsuario");
		String tipoUsuario = (String)session.getAttribute("tipoUsuario");
		if (session != null && nombreUsuario != null && tipoUsuario.equals("Administrativo") ) {

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
		int id = Integer.valueOf(request.getParameter("idUsuario"));
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate fechaIngreso = null;
		try {
			fechaIngreso = LocalDate.parse(request.getParameter("fechaIngreso"), formatter);
		} catch (Exception e) {
			System.out.println("Servlet EditarProfesional - error en LocalDate.parse");
			System.out.println("fechaIngreso no valida "+ fechaIngreso);
			System.out.println(e);
		}
		if(fechaIngreso == null) {
			getServletContext().getRequestDispatcher("/views/listado-usuarios.jsp").forward(request, response);
		}
		
		Profesional pro = new Profesional(id,nombreUsuario,contrasena,nombre,titulo,fechaIngreso);
		System.out.println(pro);
		String mensaje;
		Boolean mostrarAlert = false;
		if(usuarioDAO.obtenerProfesional(pro.getId()) != null) {
			usuarioDAO.actualizarProfesional(pro);
			System.out.println("El profesional se ha actualizado correctamente");
			mensaje="El profesional se ha actualizado correctamente";
			mostrarAlert= true;
		}else {
			usuarioDAO.crearProfesional(pro);
			System.out.println("El profesional se ha ingresado correctamente");
			mensaje="El profesional se ha actualizado correctamente";
			mostrarAlert= true;
		}
		request.setAttribute("mostrarAlert", mostrarAlert);
		request.setAttribute("mensaje", mensaje);
		getServletContext().getRequestDispatcher("/views/listado-usuarios.jsp").forward(request, response);
	}

}
