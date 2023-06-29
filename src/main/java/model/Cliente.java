package model;

import java.time.LocalDate;

public class Cliente extends Usuario {
	private String nombres;
	private String apellidos;
	private int telefono;
	private String afp;
	private SistemaSalud sistemaSalud;
	private String direccion;
	private String comuna;
	private int edad;
	private int rut;

	public Cliente() {
	}

	public Cliente(String nombre, LocalDate fechaNacimiento, int run, String nombres, String apellidos, int telefono, String afp,
			SistemaSalud sistemaSalud, String direccion, String comuna, int edad, int rut) {
		super(nombre, fechaNacimiento,run);
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.afp = afp;
		this.sistemaSalud = sistemaSalud;
		this.direccion = direccion;
		this.comuna = comuna;
		this.edad = edad;
		this.rut = rut;
	
	}

	public int getRut() {
		return rut;
	}

	public void setRut(int rut) {
		this.rut = rut;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getAfp() {
		return afp;
	}

	public void setAfp(String afp) {
		this.afp = afp;
	}

	public SistemaSalud getSistemaSalud() {
		return sistemaSalud;
	}

	public void setSistemaSalud(SistemaSalud sistemaSalud) {
		this.sistemaSalud = sistemaSalud;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getComuna() {
		return comuna;
	}

	public void setComuna(String comuna) {
		this.comuna = comuna;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	// Metodos de la clase
	@Override
	public String toString() {
		return " Nombres: " + nombres + "\n Apellidos=" + apellidos + "\n Telefono: " + telefono + "\n Afp: "
				+ afp + "\n Sistema de Salud: " + sistemaSalud + "\n Direccion: " + direccion + "\n Comuna:" + comuna
				+ "\n Edad: " + edad + "\n rut: " + rut;
	}

	public String mostrarEdad() {
		return " Nombre Completo: " + nombres + " " + apellidos;
	}

	public void obtenerSistemaSalud() {
		System.out.println(" Sistema de Salud: " + sistemaSalud);
	}

	@Override
	public int analizarUsuario() {
		super.analizarUsuario();
		System.out.println(" Dirección: " + direccion + "\n Comuna: " + comuna);
		return super.getRun();
	}
}
