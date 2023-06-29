package model;

public class Revision {
	int idRevision;
	int idVisitaTerreno;
	String nombreRevision;
	String detalle;
	Estado estado;

	public Revision() {
		super();
	}

	public Revision(int idRevision, int idVisitaTerreno, String nombreRevision, String detalle, Estado estado) {
		super();
		this.idRevision = idRevision;
		this.idVisitaTerreno = idVisitaTerreno;
		this.nombreRevision = nombreRevision;
		this.detalle = detalle;
		this.estado = estado;
	}

	public int getIdRevision() {
		return idRevision;
	}

	public void setIdRevision(int idRevision) {
		this.idRevision = idRevision;
	}

	public int getIdVisitaTerreno() {
		return idVisitaTerreno;
	}

	public void setIdVisitaTerreno(int idVisitaTerreno) {
		this.idVisitaTerreno = idVisitaTerreno;
	}

	public String getNombreRevision() {
		return nombreRevision;
	}

	public void setNombreRevision(String nombreRevision) {
		this.nombreRevision = nombreRevision;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Revision  \n idRevision: " + idRevision + " \n idVisitaTerreno: " + idVisitaTerreno
				+ " \n nombreRevision: " + nombreRevision + " \n detalle: " + detalle + " \n estado: " + estado;
	}

}
