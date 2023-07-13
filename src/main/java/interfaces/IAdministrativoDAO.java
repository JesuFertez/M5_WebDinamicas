package interfaces;

import model.Administrativo;
import model.Usuario;

public interface IAdministrativoDAO {
    public void actualizarAdministrativo(Usuario usuario);
    public int crearAdministrativo(Administrativo administrativo);
    public Administrativo obtenerAdministrativo(int id);
}
