package implementacion;

import java.util.ArrayList;
import java.util.List;

import interfaces.ICapacitacionDAO;
import model.Capacitacion;

public class CapacitacionDAO implements ICapacitacionDAO {
	private static List<Capacitacion> listaCapacitaciones = new ArrayList<>();
	
	public List<Capacitacion> obtenerCapacitaciones() {
		return listaCapacitaciones;
	}

	
	public void agregarCapacitacion(Capacitacion capacitacion) {
		listaCapacitaciones.add(capacitacion);
	}


}
