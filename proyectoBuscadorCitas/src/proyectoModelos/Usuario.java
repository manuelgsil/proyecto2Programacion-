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
			{ "Bienestar y salud:", "Yoga", "Realfooder" }, { "Tecnologia:", "Informatica", "Hardware" },
			{ "Videojuegos:", "Rpg", "Estrategia", "Plataformas" },
			{ "Cine y TV:", "Cine clasico", "Series TV", "Ciencia ficcion" } };

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

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public void setOrientacionSexual(String orientacionSexual) {
		this.orientacionSexual = orientacionSexual;
	}

	public String getciudad() {

		return ciudad;
	}

	public char getSexo() {
		return sexo;
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

	public int getEdad() {
		return edad;
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

	/**
	 * @author Manuel Metodo que calcula la edad del usuario una vez que nos da la
	 *         fecha de nacimiento
	 * 
	 * @param fechaNacimiento
	 * @return la edad del usuario
	 */
	public int calcularEdad(LocalDate fechaNacimiento) {
		LocalDate fechaActual = LocalDate.now();

		return Period.between(fechaNacimiento, fechaActual).getYears();

	}

	// esto no tiene mucho sentido, tenog que darle una vuelta
	public String determinarPreferenciaSexual(String orientacionSexual) {
		if (orientacionSexual.equalsIgnoreCase("Hetero") || orientacionSexual.equalsIgnoreCase("Gay")
				|| orientacionSexual.equalsIgnoreCase("Bi"))
			;

		return orientacionSexual;
	}

	public String calcularCompatiblidad(Usuario usuario_a_comparar) {

		// Tengo que revisar si el string es la mejor opcion o posteriormente quiero
		// trabajar sobre el menu.
		// La compatibilidad se calculara si son de la misma orientacion sexual
		String mensaje = "";
		boolean bandera;
		int compatiblidad;

		bandera = banderaCompatibilidad(usuario_a_comparar);
		if (bandera) {
			compatiblidad = calcularCompatibilidadIntereses(usuario_a_comparar)
					+ calcularCompatibilidadEdad(usuario_a_comparar) + calcularCompatibilidadCiudad(usuario_a_comparar);

			if (compatiblidad > 100)
				compatiblidad = 100;

			mensaje = "Tu indice de compatibilidad con " + usuario_a_comparar.getNombre() + " es del : " + compatiblidad
					+ "%";
		}
		return mensaje;
	}

	/**
	 * @author Manuel
	 * 
	 *         Este metodo nos sirve como bandera para calcular la compatibilidad o
	 *         no. En el caso de que su sexo y orientacion sexual sean
	 *         incompatibles, no se ejecutara
	 *         {@link #calcularCompatiblidad(Usuario)} ESTE METODO TIENE UNA
	 * 
	 *         COMPLEJIDAD ELEVADA. DEBERIA DIVIDIRLO PARA QUE SEA MAS LEGIBLE.
	 * 
	 * @param usuario_a_comparar
	 * 
	 * @return
	 */
	private boolean banderaCompatibilidad(Usuario usuario_a_comparar) {
		boolean bandera = false;

		final String HETERO = "HETERO"; // CONVERTIMOS LAS OPCIONES EN CONSTANTES
		final String GAY = "GAY";
		final String BI = "BI";
		switch (this.orientacionSexual) { // En el switch ponemos como key la preferencia sexual del usuario
											// desde aqui realizamos una serie de condicionales segun su orientacion Sexual
		case HETERO:

			if (this.sexo != usuario_a_comparar.getSexo() && usuario_a_comparar.getOrientacionSexual().equals(HETERO)
					|| this.sexo != usuario_a_comparar.getSexo()
							&& usuario_a_comparar.getOrientacionSexual().equals(BI))
				bandera = true;
			break;

		case BI:

			if (this.sexo != usuario_a_comparar.getSexo() && usuario_a_comparar.getOrientacionSexual().equals(HETERO)
					|| this.sexo == usuario_a_comparar.getSexo()
							&& usuario_a_comparar.getOrientacionSexual().equals(GAY))
				bandera = true;
			break;

		case GAY:
			if (this.sexo == usuario_a_comparar.getSexo() && usuario_a_comparar.getOrientacionSexual().equals(GAY)
					|| this.sexo == usuario_a_comparar.getSexo()
							&& usuario_a_comparar.getOrientacionSexual().equals(BI))

				bandera = true;

			break;
		}

		return bandera;

	}

	/**
	 * @author Manuel Seccion que suma 20 puntos al indice de compatiblidad si son
	 *         de la misma ciudad
	 * @see #calcularCompatibilidadEdad(Usuario). Se emplea esta funcion para
	 *      reducir la complejidad de estructuras condicionales y hacer el codigo
	 *      mas legible / mantenible.
	 * @param usuario_a_comparar
	 * @return devuelve mediante un operador ternario 20 de indice de compatiblidad
	 *         si son de la misma ciudad. 0 en cualquier otro caso
	 */
	private int calcularCompatibilidadCiudad(Usuario usuario_a_comparar) {

		return this.ciudad.equals(usuario_a_comparar.getciudad()) ? 20 : 0;

	}

	/**
	 * @author Manuel
	 * 
	 *         Metodo que se encarga de calcular la compatibilidad en funcion de los
	 *         intereses en comun.
	 * @see #calcularCompatibilidadEdad(Usuario). Se emplea esta funcion para
	 *      reducir la complejidad de estructuras condicionales y hacer el codigo
	 *      mas legible / mantenible.
	 * 
	 * @param Usuario_a_comparar
	 * @return devuelve el numero de intereses comunes multiplicado por 10
	 */
	private int calcularCompatibilidadIntereses(Usuario Usuario_a_comparar) {
		List<String> interesesComunes = new ArrayList<String>(this.intereses);
		interesesComunes.retainAll(Usuario_a_comparar.getIntereses());
		return interesesComunes.size() * 10;
	}

	/**
	 * @author Manuel
	 * 
	 *         Metodo que se encarga de calcular la compatibilidad en funcion de la
	 *         diferencia de edad.
	 * @see #calcularCompatibilidadEdad(Usuario). Se emplea esta funcion para
	 *      reducir la complejidad de estructuras condicionales y hacer el codigo
	 *      mas legible / mantenible. Se ha empleado un operador ternario para
	 *      expresar las condiciones en vez de un bloque if / else
	 * @param Usuario_a_comparar
	 * @return devuelve 10 si la diferencia de edad es menor o igual 5. Si la
	 *         diferencia de edad es menor de 10 se devuelve 5. En cualquier otro
	 *         caso, no suma.
	 */
	private int calcularCompatibilidadEdad(Usuario Usuario_a_comparar) {
		int diferenciaEdad = Math.abs(this.edad - Usuario_a_comparar.edad);
		return (diferenciaEdad <= 5) ? 10 : ((diferenciaEdad > 5 && diferenciaEdad <= 10) ? 5 : 0);
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
	 * @author DANI_ Metodo por el cual cogemos y guardamos dentro de un ArrayList
	 *         de String el metodo {@linkFiltroInteresComunes}, y mostramos a
	 *         través de un String tanto los intereses que tienen´ en comun como
	 *         el "Perfil" de dicha/s personas, que tienen en comun esos intereses.
	 * @param usuario
	 * @param usuarios
	 * @return
	 */
	public String mostrarPersonasConInteresesEnComun(Usuario usuario, List<Usuario> usuarios) {
		String devolver = "";
		List<String> interesesComunes = FiltroInteresesComunes(usuario, usuarios);

		for (Usuario u : usuarios) {
			if (!u.equals(usuario) && u.getIntereses().containsAll(interesesComunes)) { // Creo que esto es Contains a
																						// secas, No all.
				devolver = "Intereses en comun: " + interesesComunes + "\n" + u.toString();
			}
		}
		return devolver;
	}

	/**
	 * @author DANI_ Metodo por el cual le damos como entrada un Objeto de la clase
	 *         Usuario y un ArrayList y buscamos a traves de un bucle for-each las
	 *         personas que tienen intereses comunes y lo delvolvemos en otro
	 *         ArrayList con los usuarios que tienen en comun dichos intereses.
	 * @param usuario_a_comparar
	 * @param usuarios
	 * @return
	 */
	public List<String> FiltroInteresesComunes(Usuario usuario_a_comparar, List<Usuario> usuarios) {

		List<String> interesesComunes = new ArrayList<String>(usuario_a_comparar.getIntereses());

		for (Usuario usuario : usuarios) {
			interesesComunes.retainAll(usuario.getIntereses());
		}

		return interesesComunes;
	}

	/**
	 * @author DANI_ Metodo por el cual filtramos la ciudad que queramos de cada
	 *         usuario guardandolos en un ArrayList con dichos Usuarios que vivan en
	 *         dicha ciudad.
	 * @param ciudades
	 * @param ciudad
	 * @return
	 */
	public static List<Usuario> filtrarPorCiudad(List<Usuario> ciudades, String ciudad) {
		List<Usuario> filtradas = new ArrayList<>();
		for (Usuario c : ciudades) {
			if (c.getciudad().equalsIgnoreCase(ciudad)) {
				filtradas.add(c);
			}
		}
		return filtradas;
	}

	/**
	 * @author DANI_ Metodo por el cual filtramos la edad de un ArrayList de
	 *         Usuarios entre dos intervalos (Edad minima y Edad maxima que queramos
	 *         filtrar.
	 * @param edad
	 * @param edadMinima
	 * @param edadMaxima
	 * @return
	 */
	public static List<Usuario> filtrarPorEdad(List<Usuario> edad, int edadMinima, int edadMaxima) {
		return edad.stream().filter(ciudades -> ciudades.getEdad() >= edadMinima && ciudades.getEdad() <= edadMaxima)
				.collect(Collectors.toList());
	}

	/**
	 * @author DANI_ Metodo el cual filtra el idioma que queramos. Mediante un bucle
	 *         for-each vamos recorriendo y lo vamos comparando con los idiomas de
	 *         los usuarios, finalmente no aniaade al ArrayList los usuarios que
	 *         tengan en comun dicho idioma.
	 * @param idioma de tipo ArrayList
	 * @param lengua String con el idioma que queremos filtrar.
	 * @return
	 */
	public static List<Usuario> filtrarPorIdioma(List<Usuario> idioma, String lengua) {

		List<Usuario> filtrado = new ArrayList<>();

		for (Usuario c : idioma) {
			if (c.getIdioma().equalsIgnoreCase(lengua)) {
				filtrado.add(c);

			}
		}

		return filtrado;

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

}
