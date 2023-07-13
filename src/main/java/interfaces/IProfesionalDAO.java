package interfaces;

import model.Profesional;
import model.Usuario;

public interface IProfesionalDAO {
    public void actualizarProfesional(Usuario usuario);
    public int crearProfesional(Profesional profesional);
    public Profesional obtenerProfesional(int id);
}