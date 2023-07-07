package interfaces;

import java.util.List;

import model.Capacitacion;

public interface ICapacitacionDAO {

	public int crearCapacitacion(Capacitacion cap);
	public List<Capacitacion>obtenerCapacitaciones();
	public Capacitacion obtenerCapacitacion(int id);
	public int actualizar(Capacitacion p);
	public int borrarCapacitacion(Capacitacion p);

}
