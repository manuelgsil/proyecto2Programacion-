package proyectoModelos;

import java.time.LocalDate;
import java.util.ArrayList;

public class Usuario {

	private static int numeroUsuarios;

	protected String nombre;
	protected String apellidos;
	protected LocalDate fechaNacimiento;
	protected String ciudadNacimiento;
	protected String idioma;
	protected String alias;
	protected boolean buscarPareja;
	protected boolean buscarAmistad;
	protected String contrasenia;
	protected String descripcion;
	protected String preferencias;
	protected ArrayList<String> intereses;

	public Usuario() {
		super();

		nombre = "UsuarioPrueba";
		apellidos = "ProbarApellido";
		fechaNacimiento = LocalDate.of(1993, 03, 14);
		ciudadNacimiento = "Sevilla";
		idioma = "Español";
		alias = "eldemonio";
		buscarAmistad = true;
		buscarPareja = false;
		contrasenia = "123Ma!";
		descripcion = "en una palabra: betico";
		preferencias = "indiferente";
		Usuario.numeroUsuarios++;
	}

	public Usuario(String nombre, String apellidos, LocalDate fechaNacimiento, String ciudadNacimiento, String idioma,
			String alias, boolean buscarPareja, boolean buscarAmistad, String contrasenia, String descripcion,
			String preferencias, ArrayList<String> intereses) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
		this.ciudadNacimiento = ciudadNacimiento;
		this.idioma = idioma;
		this.alias = alias;
		this.buscarPareja = buscarPareja;
		this.buscarAmistad = buscarAmistad;
		this.contrasenia = contrasenia;
		this.descripcion = descripcion;
		this.preferencias = preferencias;
		this.intereses = intereses;
	}

	public static int getNumeroUsuarios() {
		return numeroUsuarios;
	}

	public String getAlias() {
		return alias;
	}

	public boolean isBuscarPareja() {
		return buscarPareja;
	}

	public boolean isBuscarAmistad() {
		return buscarAmistad;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public String getPreferencias() {
		return preferencias;
	}

	public static void setNumeroUsuarios(int numeroUsuarios) {
		Usuario.numeroUsuarios = numeroUsuarios;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public void setBuscarPareja(boolean buscarPareja) {
		this.buscarPareja = buscarPareja;
	}

	public void setBuscarAmistad(boolean buscarAmistad) {
		this.buscarAmistad = buscarAmistad;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setPreferencias(String preferencias) {
		this.preferencias = preferencias;
	}

	public String getCiudad() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getEdad() {
		// TODO Auto-generated method stub
		return 0;
	}

}
