package model;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class VisitaEnTerreno {
	private int idVisitaTerreno;
	private int rutCliente;
	private LocalDate fechaAccidente;
	private LocalTime horaAccidente;
	private String lugar;
	private String comentarios;
	private List<Revision>revisiones; 

	public VisitaEnTerreno() {
	}

	public VisitaEnTerreno(int idVisitaTerreno, int rutCliente, LocalDate fechaAccidente, LocalTime horaAccidente,
			String lugar, String comentarios) {
		super();
		this.idVisitaTerreno = idVisitaTerreno;
		this.rutCliente = rutCliente;
		this.fechaAccidente = fechaAccidente;
		this.horaAccidente = horaAccidente;
		this.lugar = lugar;
		this.comentarios = comentarios;
	}

	public int getIdVisitaTerreno() {
		return idVisitaTerreno;
	}

	public void setIdVisitaTerreno(int idVisitaTerreno) {
		this.idVisitaTerreno = idVisitaTerreno;
	}

	public int getRutCliente() {
		return rutCliente;
	}

	public void setRutCliente(int rutCliente) {

		this.rutCliente = rutCliente;
	}

	public LocalDate getFechaAccidente() {
		return fechaAccidente;
	}

	public void setFechaAccidente(LocalDate fechaAccidente) {
	
		this.fechaAccidente = fechaAccidente;
	}

	public LocalTime getHoraAccidente() {
		return horaAccidente;
	}

	public void setHoraAccidente(LocalTime horaAccidente) {
		
		this.horaAccidente = horaAccidente;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		
		this.comentarios = comentarios;
	}

	@Override
	public String toString() {
		return "VisitaEnTerreno  \n idVisitaTerreno: " + idVisitaTerreno + " \n rutCliente: " + rutCliente
				+ " \n fechaAccidente: " + fechaAccidente + " \n horaAccidente: " + horaAccidente + " \n lugar: "
				+ lugar + " \n comentarios: " + comentarios;
	}

	public List<Revision> getRevisiones() {
		return revisiones;
	}

	public void setRevisiones(List<Revision> revisiones) {
		this.revisiones = revisiones;
	}

}
