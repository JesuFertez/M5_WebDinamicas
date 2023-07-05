package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CrearUsuario
 */
@WebServlet("/CrearUsuario")
public class CrearUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrearUsuario() {
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
					getServletContext().getRequestDispatcher("/views/crear-usuario.jsp").forward(request, response);
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
		if(request.getParameter("contraseña") != null) {
			// Establecer el mensaje de éxito como atributo de solicitud
			request.setAttribute("mensaje", "Usuario creado correctamente");
			
			//Redireccionar a web de exito
			getServletContext().getRequestDispatcher("/views/exito.jsp").forward(request, response);
		}else {
			getServletContext().getRequestDispatcher("/views/listado-usuarios.jsp").forward(request, response);
		}
	}

}
