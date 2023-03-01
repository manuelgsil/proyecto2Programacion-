package proyectoModelos;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Usuario {

	private static int numeroUsuarios;

	protected String nombre;
	protected String apellido;
	protected LocalDate fechaNacimiento;
	protected String ciudad;
	protected String idioma;
	protected int edad;
	protected String sexo;
	protected String contrasenia;
	protected String descripcion;
	protected String preferencias;
	protected ArrayList<String> intereses = new ArrayList();

	public Usuario() {
		super();

		nombre = "UsuarioPrueba";
		apellido = "ProbarApellido";
		fechaNacimiento = LocalDate.of(1993, 03, 14);
		ciudad = "Sevilla";
		idioma = "Español";
		edad = 29;
		contrasenia = "123Ma!";
		descripcion = "en una palabra: betico";
		preferencias = "indiferente";
		this.intereses.add("rpg");
		this.intereses.add("plataformas");
		this.intereses.add("informatica");
		Usuario.numeroUsuarios++;
	}

	public Usuario(String nombre, String apellido, LocalDate fechaNacimiento, String ciudadNacimiento, String idioma,
			String contrasenia, String descripcion, String preferencias, ArrayList<String> intereses) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.ciudad = ciudadNacimiento;
		this.idioma = idioma;
		this.edad = calcularEdad(fechaNacimiento);
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

	public String getciudad() {

		return ciudad;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public String getCiudad() {
		return ciudad;
	}

	public String getIdioma() {
		return idioma;
	}

	public ArrayList<String> getIntereses() {
		return intereses;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public void setIntereses(ArrayList<String> intereses) {
		this.intereses = intereses;
	}

	public int getEdad() {
		return edad;
	}

	public int calcularEdad(LocalDate fechaNacimiento) {
		LocalDate fechaActual = LocalDate.now();

		return Period.between(fechaNacimiento, fechaActual).getYears();

	}

	public String calcularCompatiblidad(Usuario Usuario_a_comparar) {

		// TODO hay que trabajar sobre este metodo.

		String mensaje = null;
		int compatiblidad = 0;
		int diferenciaEdad = Math.abs(this.edad - Usuario_a_comparar.edad);
		int num_interesesComunes; // Al tamaño del array de cosas comunes que tengan lo voy a multiplicar por 10

		List<String> interesesComunes = new ArrayList<String>(this.intereses);
		interesesComunes.retainAll(Usuario_a_comparar.getIntereses());

		if (diferenciaEdad <= 5)
			compatiblidad = +10;
		if (this.ciudad.equals(Usuario_a_comparar.getciudad()))
			compatiblidad = +10;

		num_interesesComunes = interesesComunes.size() * 10;
		compatiblidad = +num_interesesComunes;

		if (this.preferencias.equals(Usuario_a_comparar.preferencias))
			compatiblidad = +20;

		// TODO He planteado esto como un String para ahorrame trabajo posteriormente.
		// Ya veremos si es buena idea o no.

		if (compatiblidad > 100) {
			mensaje = "PARECE QUE SOIS MUY PERO QUE MUY COMPATIBLES. MUY MAL TENDRIA QUE DARSE\nCOMPATIBILIDAD: "
					+ compatiblidad;
		} else {
			mensaje = "Tu compatiblidad con este usuario es la siguiente: " + compatiblidad;
		}

		return mensaje;

	}

	public ArrayList<Usuario> filtroBusqueda1(Usuario usuario_a_buscar, int opcionBusqueda) {
		ArrayList<Usuario> usuariosAfines = new ArrayList<Usuario>();

		switch (opcionBusqueda) {
		case 1:
			if (this.ciudad.equalsIgnoreCase(usuario_a_buscar.getciudad())) // Usuarios con la misma ciudad
				usuariosAfines.add(usuario_a_buscar);
			break;
		case 2:
			if(this.idioma.equalsIgnoreCase(usuario_a_buscar.idioma)) // Usuarios con el mismo idioma
				usuariosAfines.add(usuario_a_buscar);
			break;
		case 3:														// encontrar por rango de edad
			

			break;
		case 4:														//numero de intereses afines

			break;

		default:
			break;
		}

		return usuariosAfines;
	}

	@Override
	public String toString() {
		String output = "+------------------+---------------------+\n";
		output += String.format("| %-16s | %-19s |%n", "Nombre", nombre);
		output += "+------------------+---------------------+\n";
		output += String.format("| %-16s | %-19s |%n", "Apellido", apellido);
		output += "+------------------+---------------------+\n";
		output += String.format("| %-16s | %-19s |%n", "Edad", edad);
		output += "+------------------+---------------------+\n";
		output += String.format("| %-16s | %-19s |%n", "Ciudad", ciudad);
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
