package implementacion;

import java.util.ArrayList;
import java.util.List;

import interfaces.ICapacitacionDAO;
import model.Capacitacion;

public class CapacitacionDAO implements ICapacitacionDAO {
	private static List<Capacitacion> listaCapacitaciones = new ArrayList<>();
	private static boolean capacitacionesCargadas = false;
	
	public CapacitacionDAO() {

        // Agregar 3 capacitaciones solo si aún no se han cargado
		if(!capacitacionesCargadas) {
			Capacitacion cap1 = new Capacitacion(1, "Prevencion de Riesgos",
					"Identificando y previniendo riesgos en el ambiente laboral", 123456789, "Martes", "09:00",
					"Sala A", "2 horas", 20);

			Capacitacion cap2 = new Capacitacion(2, "Manipulación del Extintor", "Uso correcto, curso práctico", 987654321,
					"Jueves", "14:00", "Sala B", "3 horas", 15);

			Capacitacion cap3 = new Capacitacion(3, "Primeros Auxilios",
					"Conocimientos y habilidades para brindar asistencia inmediata", 555555555, "Lunes", "18:00",
					"Sala C", "4 horas", 30);
			
			listaCapacitaciones.add(cap1);
			listaCapacitaciones.add(cap2);
			listaCapacitaciones.add(cap3);
			
			capacitacionesCargadas = true;
			System.out.println("-- 3 Capacitaciones cargadas por defecto en la lista.");
		}
	}

	public List<Capacitacion> obtenerCapacitaciones() {
		return listaCapacitaciones;
	}

	public void agregarCapacitacion(Capacitacion capacitacion) {
		listaCapacitaciones.add(capacitacion);
		System.out.println("** Capacitacion agregada con éxito: ");
		System.out.println("___Datos " + capacitacion.toString());
	}

}
