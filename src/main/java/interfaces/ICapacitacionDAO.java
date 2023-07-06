package interfaces;

import java.util.List;

import model.Capacitacion;

public interface ICapacitacionDAO {

	List<Capacitacion> obtenerCapacitaciones();
	void agregarCapacitacion(Capacitacion capacitacion);
}
