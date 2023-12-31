package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import implementacion.AdministrativoDAOImpl;
import implementacion.UsuarioDAOImpl;
import interfaces.IAdministrativoDAO;
import interfaces.IUsuarioDAO;
import model.Administrativo;
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
    private IAdministrativoDAO administrativoDAO = new AdministrativoDAOImpl();

    public EditarAdministrativo() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Se obtiene la sesion actual
		HttpSession session = request.getSession();
		// validacion de usuario logeado
		String nombreUsuario = (String)session.getAttribute("nombreUsuario");
		String tipoUsuario = (String)session.getAttribute("tipoUsuario");
		if (session != null && nombreUsuario != null && tipoUsuario.equals("Administrativo") ) {

            int id = Integer.valueOf(request.getParameter("idRescatado").toString());
            Administrativo administrativo = administrativoDAO.obtenerAdministrativo(id);
            System.out.println(administrativo);
         
            if(administrativo == null) {
            	Usuario usu = administrativoDAO.obtenerUsuario(id);
            	System.out.println(usu);
            	administrativo = new Administrativo();
            	administrativo.setId(id);
            	administrativo.setNombre(usu.getNombre());
            	administrativo.setContraseña(usu.getContraseña());
            	administrativo.setTipo(TipoUsuario.Administrativo);
            }
            request.setAttribute("usuario", administrativo);
            getServletContext().getRequestDispatcher("/views/editar-usuario.jsp").forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/Login");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    	String contrasena = request.getParameter("contraseña");
		String nombreUsuario = request.getParameter("nombreUsuario");
    	int id = Integer.valueOf(request.getParameter("idUsuario"));
        String nombreAdmin = request.getParameter("nombre");
        String area = request.getParameter("area");
        String experienciaPrevia = request.getParameter("experienciaPrevia");
        
        Administrativo administrativo = new Administrativo(id,nombreUsuario,contrasena, nombreAdmin, area, experienciaPrevia);
       System.out.println(administrativo);
       String mensaje;
       Boolean mostrarAlert = false;
        if (administrativoDAO.obtenerAdministrativo(administrativo.getId()) != null) {
            administrativoDAO.actualizarAdministrativo(administrativo);
            System.out.println("El administrativo se ha actualizado correctamente");
			mensaje="El administrativo se ha actualizado correctamente";
			mostrarAlert= true;
        } else {
            administrativoDAO.crearAdministrativo(administrativo);
            System.out.println("El administrativo se ha ingresado correctamente");
			mensaje="El administrativo se ha actualizado correctamente";
			mostrarAlert= true;
        }
		request.setAttribute("mostrarAlert", mostrarAlert);
		request.setAttribute("mensaje", mensaje);
		getServletContext().getRequestDispatcher("/views/listado-usuarios.jsp").forward(request, response);
    }
}

