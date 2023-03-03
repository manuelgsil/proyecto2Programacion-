package proyectoModelos;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Usuario {

	private static int numeroUsuarios;

	private static final String[][] LISTA_INTERESES = { { "Deportes:", "Futbol", "Baloncesto", "Tenis", "Boxeo" },
			{ "M�sica:", "Rock", "Pop", "Electr�nica" }, { "Arte y cultura:", "Pintura" },
			{ "Mascotas:", "Perros", "Gatos" }, { "Comida:", "Italiana", "Japonesa", "Mexicana" },
			{ "Bienestar y salud:", "Yoga", "Realfooder" }, { "Tecnolog�a:", "Informatica", "Hardware" },
			{ "Videojuegos:", "Rpg", "Estrategia", "Plataformas" },
			{ "Cine y TV:", "Cine clasico", "Series TV", "Ciencia ficcion" } };

	public final String HETERO = "Heterosexual";
	public final String GAY = "Gay";
	public final String BI = "Bisexual";

	private String nombre;
	private String apellido;
	private LocalDate fechaNacimiento;
	private String ciudad;
	private String idioma;
	private int edad;
	private char sexo;
	private String descripcion;
	private String orientacionSexual;
	private ArrayList<String> intereses = new ArrayList();

	public Usuario(String nombre, String apellido, LocalDate fechaNacimiento, String ciudad, String idioma, char sexo,
			String descripcion, String orientacionSexual) {

		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.ciudad = ciudad;
		this.idioma = idioma;
		this.edad = calcularEdad(fechaNacimiento);
		this.descripcion = descripcion;
		this.orientacionSexual = determinarPreferenciaSexual(orientacionSexual);
		this.sexo = sexo;
	}

	public static int getNumeroUsuarios() {
		return numeroUsuarios;
	}

	/**
	 * @author Manuel Con esta funcion devolvemos un String que muestra los
	 *         intereses definidos como constante
	 * 
	 */
	public static String mostrartInteresesDisponibles() {

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < LISTA_INTERESES.length; i++) {
			sb.append(String.format("%-3d", i + 1));
			for (int j = 0; j < LISTA_INTERESES[i].length; j++) {
				sb.append(String.format("%-20s", LISTA_INTERESES[i][j]));
			}
			sb.append("\n");
		}
		return sb.toString();
	}

	/**
	 * @author Manuel Metodo de clase por el cual se introduce el interes
	 *         seleccionado por el usuario. Esta controlado para que no se repitan
	 *         los intereses en la misma lista y para que no se pueda elegir el
	 *         indice de cada categoria
	 * 
	 * @param interes Seleccionado por el usuario
	 */
	public void agregarListaIntereses(String interes) {

		for (int i = 0; i < LISTA_INTERESES.length; i++) {
			for (int j = 1; j < LISTA_INTERESES[i].length; j++) { // con j=1 salimos del rango de los indices

				if (LISTA_INTERESES[i][j].equalsIgnoreCase(interes) && !intereses.contains(interes)) // esta doble
					// clausula nos
					// permite
					// controlar los
					// repetidos y
					// las mayus
					intereses.add(interes);
			}
		}
	}

	public String getDescripcion() {
		return descripcion;
	}

	public String getOrientacionSexual() {
		return orientacionSexual;
	}

	public static void setNumeroUsuarios(int numeroUsuarios) {
		Usuario.numeroUsuarios = numeroUsuarios;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setOrientacionSexual(String orientacionSexual) {
		this.orientacionSexual = orientacionSexual;
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
	// esto no tiene mucho sentido, tenog que darle una vuelta
	public String determinarPreferenciaSexual(String orientacionSexual) {
		if (orientacionSexual.equalsIgnoreCase("Hetero") || orientacionSexual.equalsIgnoreCase("Gay")
				|| orientacionSexual.equalsIgnoreCase("Bi"));

		return orientacionSexual;
	}

	public String calcularCompatiblidad(Usuario Usuario_a_comparar) {

		// TODO hay que trabajar sobre este metodo.

		String mensaje = null;
		int compatiblidad = 0;
		int diferenciaEdad = Math.abs(this.edad - Usuario_a_comparar.edad);
		int num_interesesComunes; // Al tamanioo del array de cosas comunes que tengan lo voy a multiplicar por 10

		List<String> interesesComunes = new ArrayList<String>(this.intereses);
		interesesComunes.retainAll(Usuario_a_comparar.getIntereses());

		if (diferenciaEdad <= 5)
			compatiblidad = +10;
		if (this.ciudad.equals(Usuario_a_comparar.getciudad()))
			compatiblidad = +10;

		num_interesesComunes = interesesComunes.size() * 10;
		compatiblidad = +num_interesesComunes;

		if (this.orientacionSexual.equals(Usuario_a_comparar.orientacionSexual))
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
	/**
	 * @author DANI_
	 * Metodo por el cual le damos como entrada un Objeto de la clase Usuario y un ArrayList
	 * y buscamos a traves de un bucle for-each las personas que tienen intereses comunes y lo delvolvemos
	 * en otro ArrayList con los usuarios que tienen en comun dichos intereses.
	 * @param usuario_a_comparar
	 * @param usuarios
	 * @return
	 */
	public  List<String> FiltroInteresesComunes(Usuario usuario_a_comparar,List<Usuario> usuarios) {

		List<String> interesesComunes = new ArrayList<String>(usuario_a_comparar.getIntereses());

		for (Usuario usuario : usuarios) {
			interesesComunes.retainAll(usuario.getIntereses());
		}

		return interesesComunes;
	}
	public void filtroInteresesOpuestos(Usuario usuario_a_comparar) {

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
		output += String.format("| %-16s | %-19s |%n", "Preferencias", orientacionSexual);
		output += "+------------------+---------------------+\n";
		output += String.format("| %-16s | %-19s |%n", "Intereses", intereses);
		output += "+------------------+---------------------+\n";
		output += "\nDescripci�n:\n";
		output += "+----------------------------------------+\n";
		output += String.format("| %-38s |%n", descripcion);
		output += "+----------------------------------------+\n";

		return output;

	}
	/**
	 * @author DANI_
	 *Metodo por el cual cogemos y guardamos dentro de un ArrayList de String el metodo 
	 *{@linkFiltroInteresComunes}, y mostramos a través de un String tanto los intereses que tienen´
	 *en comun como el "Perfil" de  dicha/s personas, que tienen en comun esos intereses.
	 * @param usuario
	 * @param usuarios
	 * @return 
	 */
	public String mostrarPersonasConInteresesEnComun(Usuario usuario, List<Usuario> usuarios) {
		String devolver="";
		List<String> interesesComunes = FiltroInteresesComunes(usuario, usuarios);
		
		for (Usuario u : usuarios) {
			if (!u.equals(usuario) && u.getIntereses().containsAll(interesesComunes)) {
			devolver= "Intereses en común: " + interesesComunes+ "\n"+ u.toString();
			}
		}
		return devolver;
	}
	/**
	 * @author DANI_
	 * Metodo por el cual filtramos la ciudad que queramos de cada usuario guardandolos en un
	 * ArrayList con dichos Usuarios que vivan en dicha ciudad.
	 * @param ciudades
	 * @param ciudad
	 * @return
	 */
	public static List<Usuario> filtrarPorCiudad( List<Usuario> ciudades,String ciudad) {
		List<Usuario> filtradas = new ArrayList<>();
		for (Usuario c : ciudades) {
			if (c.getciudad().equalsIgnoreCase(ciudad)) {
				filtradas.add(c);
			}
		}
		return filtradas;
	}
	/**
	 * @author DANI_
	 *Metodo por el cual filtramos la edad de un ArrayList de Usuarios entre dos intervalos (Edad
	 *minima y Edad maxima que queramos filtrar.
	 * @param edad
	 * @param edadMinima
	 * @param edadMaxima
	 * @return
	 */
	public static List<Usuario> filtrarPorEdad(List<Usuario> edad, int edadMinima, int edadMaxima) {
		return edad.stream()
				.filter(ciudades -> ciudades.getEdad() >= edadMinima && ciudades.getEdad() <= edadMaxima)
				.collect(Collectors.toList());
	}
	/**
	 * @author DANI_
	 * Metodo el cual filtra el idioma que queramos. Mediante un bucle for-each vamos recorriendo y 
	 * lo vamos comparando con los idiomas de los usuarios, finalmente no añade al ArrayList los usuarios
	 * que tengan en comun dicho idioma.
	 * @param idioma de tipo ArrayList
	 * @param lengua String con el idioma que queremos filtrar.
	 * @return
	 */
	public static List<Usuario> filtrarPorIdioma(List<Usuario> idioma,String lengua){

		List<Usuario> filtrado=new ArrayList<>();

		for (Usuario c: idioma) {
			if (c.getIdioma().equalsIgnoreCase(lengua)){
				filtrado.add(c);

			}
		}

		return filtrado;

	}


}
