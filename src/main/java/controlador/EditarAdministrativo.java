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
        HttpSession session = request.getSession();

        if (session != null && session.getAttribute("usuario") != null) {
            int id = Integer.valueOf(request.getParameter("idRescatado").toString());
            Administrativo administrativo = administrativoDAO.obtenerAdministrativo(id);
            request.setAttribute("administrativo", administrativo);
            getServletContext().getRequestDispatcher("/views/editar-administrativo.jsp").forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/Login");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.valueOf(request.getParameter("idAdministrativo"));
        String nombre = request.getParameter("nombreAdministrativo");
        String area = request.getParameter("area");
        String experienciaPrevia = request.getParameter("experienciaPrevia");

        Administrativo administrativo = new Administrativo(id, "", "", nombre, area, experienciaPrevia);
        if (administrativoDAO.obtenerAdministrativo(administrativo.getId()) != null) {
            administrativoDAO.actualizarAdministrativo(administrativo);
            System.out.println("El administrativo se ha actualizado correctamente");
        } else {
            administrativoDAO.crearAdministrativo(administrativo);
            System.out.println("El administrativo se ha ingresado correctamente");
        }
    }
}

