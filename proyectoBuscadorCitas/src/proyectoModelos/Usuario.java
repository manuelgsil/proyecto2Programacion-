package proyectoModelos;

import java.time.LocalDate;
import java.util.ArrayList;

public class Usuario {

	private static int numeroUsuarios;

	protected String nombre;
	protected String apellido;
	protected LocalDate fechaNacimiento;
	protected String ciudadNacimiento;
	protected String idioma;

	protected String contrasenia;
	protected String descripcion;
	protected String preferencias;
	protected ArrayList<String> intereses;

	public Usuario() {
		super();

		nombre = "UsuarioPrueba";
		apellido = "ProbarApellido";
		fechaNacimiento = LocalDate.of(1993, 03, 14);
		ciudadNacimiento = "Sevilla";
		idioma = "Español";

		contrasenia = "123Ma!";
		descripcion = "en una palabra: betico";
		preferencias = "indiferente";
		Usuario.numeroUsuarios++;
	}

	public Usuario(String nombre, String apellido, LocalDate fechaNacimiento, String ciudadNacimiento, String idioma,
			String contrasenia, String descripcion, String preferencias, ArrayList<String> intereses) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.ciudadNacimiento = ciudadNacimiento;
		this.idioma = idioma;

		this.contrasenia = contrasenia;
		this.descripcion = descripcion;
		this.preferencias = preferencias;
		this.intereses = intereses;
	}

	public static int getNumeroUsuarios() {
		return numeroUsuarios;
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

	@Override
	public String toString() {
		String output = "+------------------+---------------------+\n";
		output += String.format("| %-16s | %-19s |%n", "Nombre", nombre);
		output += "+------------------+---------------------+\n";
		output += String.format("| %-16s | %-19s |%n", "Apellido", apellido);
		output += "+------------------+---------------------+\n";
		output += String.format("| %-3s : %-16s |%n", "Fecha de Nacimiento", fechaNacimiento);
		output += "+------------------+---------------------+\n";
		output += String.format("| %-1s : %-15s |%n", "Ciudad de Nacimiento", ciudadNacimiento);
		output += "+------------------+---------------------+\n";
		output += String.format("| %-16s | %-19s |%n", "Idioma", idioma);
		output += "+------------------+---------------------+\n";
		output += String.format("| %-16s | %-19s |%n", "Preferencias", preferencias);
		output += "+------------------+---------------------+\n";
		output += String.format("| %-16s | %-19s |%n", "Intereses", intereses);
		output += "+------------------+---------------------+\n";
		  output += "\nDescripción:\n";
	        output += "+----------------------------------------+\n";
	        output += String.format("| %-38s |%n", descripcion);
	        output += "+----------------------------------------+\n";

		return output;

	}

}
