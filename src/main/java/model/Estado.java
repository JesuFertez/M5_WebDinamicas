package model;

public enum Estado {
	
	UNO("Sin problemas"), DOS("Con observaciones"), TRES("No aprueba");

private final String anotacion;

	Estado(String anotacion) {
		this.anotacion = anotacion;
	}
	public String getAnotacion() {
		return this.anotacion;
	}
}
