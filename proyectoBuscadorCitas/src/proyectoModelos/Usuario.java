package proyectoModelos;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Usuario {

	private static int numeroUsuarios;

	private static final String[][] LISTA_INTERESES = { { "Deportes:", "Futbol", "Baloncesto", "Tenis", "Boxeo" },
			{ "Musica:", "Rock", "Pop", "Electronica" },
			{ "Arte y cultura:", "Pintura", "Literatura", "Filosofia", "Museos" }, { "Mascotas:", "Perros", "Gatos" },
			{ "Comida:", "Italiana", "Japonesa", "Mexicana" }, { "Bienestar y salud:", "Yoga", "Realfooder" },
			{ "Tecnologia:", "Informatica", "Hardware" }, { "Videojuegos:", "Rpg", "Estrategia", "Plataformas" },
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
	private ArrayList<String> intereses;
	private String [] informacionPersonal;
	
	public Usuario() {
		this.nombre = "prueba";
		apellido = "masprueba";
		fechaNacimiento = LocalDate.of(1993, 03, 14);
		ciudad = "Sevilla";
		edad = calcularEdad(fechaNacimiento);
		sexo = 'H';
		descripcion = "jaja jiji";
		orientacionSexual = "HETERO";
		generarInteresesAleatorios();
		ciudad="Sevilla";

	}

	public Usuario(String[] informacionPersonal, LocalDate fechaNacimiento, char sexo) {
	    this.nombre = informacionPersonal[0];
	    this.apellido = informacionPersonal[1];
	    this.ciudad = informacionPersonal[2];
	    this.idioma = informacionPersonal[3];
	    this.descripcion = informacionPersonal[4];
	    this.orientacionSexual = informacionPersonal[5];
	    this.fechaNacimiento = fechaNacimiento;
	    this.edad = calcularEdad(fechaNacimiento);
	    this.sexo = sexo;
	    this.intereses=new ArrayList<String>();
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

<<<<<<< HEAD
=======
	public int getEdad() {
		return edad;
	}
>>>>>>> branch 'ramaManuel' of https://github.com/manuelgsil/proyecto2Programacion-.git

	public String getIdioma() {
		return idioma;
	}

	public ArrayList<String> getIntereses() {
		return intereses;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String [] getInformacionPersonal() {
		return informacionPersonal;
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

	public void setInformacionPersonal(String [] informacionPersonal) {
		this.informacionPersonal = informacionPersonal;
	}

	/**
	 * @author Manuel Metodo que calcula la edad del usuario una vez que nos da la
	 *         fecha de nacimiento
	 * 
	 * @param fechaNacimiento
	 * @return la edad del usuario
	 */
	private int calcularEdad(LocalDate fechaNacimiento) {
		LocalDate fechaActual = LocalDate.now();
	
		return Period.between(fechaNacimiento, fechaActual).getYears();
	
	}

	/**
	 * @author Manuel Metodo
	 * 
	 *         que nos devuelve un INT que refiere al porcentaje de compatibilidad.
	 *         Para que se efectue el metodo correctamente, tiene una llamada a otro
	 *         metodo: {@link #banderaCompatibilidad(Usuario)} que comprueba si el
	 *         sexo y la orientacion sexual de los usuarios es compatible entre si.
	 * @param usuarioComparar
	 * @return int con la puntuacion de compatibilidad entre los usuarios
	 */
	public int calcularCompatiblidad(Usuario usuarioComparar) {

		boolean bandera;
		int compatiblidad = 0;

		bandera = banderaCompatibilidad(usuarioComparar);
		if (bandera) {
			compatiblidad = 20 + calcularCompatibilidadIntereses(usuarioComparar)
					+ calcularCompatibilidadEdad(usuarioComparar) + calcularCompatibilidadCiudad(usuarioComparar);

			compatiblidad = compatiblidad > 100 ? 100 : compatiblidad;

		}
		return compatiblidad;
	}

	/**
	 * @author Manuel
	 * 
	 *         Este metodo nos sirve como indicador para calcular la compatibilidad o
	 *         no. En el caso de que su sexo y orientacion sexual sean
	 *         incompatibles, no se ejecutara {@link #calcularCompatiblidad(Usuario)}
	 * 
	 * @param usuarioComparar el usuario del array que este siendo comparado con el usuario que llame al metodo
	 * 
	 * @return un valor booleano que nos servira como bandera para el metodo
	 *         {@link #calcularCompatiblidad(Usuario)}
	 */
	private boolean banderaCompatibilidad(Usuario usuarioComparar) {
		boolean bandera = false;
	
		final String HETERO = "HETERO"; // CONVERTIMOS LAS OPCIONES EN CONSTANTES
		final String GAY = "GAY";
		final String BI = "BI";
		switch (this.orientacionSexual) { // En el switch ponemos como key la preferencia sexual del usuario
		// desde aqui realizamos una serie de condicionales segun su orientacion
		// Sexual
		case HETERO:

			if (this.sexo != usuarioComparar.getSexo() && usuarioComparar.getOrientacionSexual().equals(HETERO) // Usuarios
																												// de
																												// distinto
																												// sexo
																												// y
																												// heterosexuales
					|| this.sexo != usuarioComparar.getSexo() && usuarioComparar.getOrientacionSexual().equals(BI)) // ESTE
																													// USUARIO
																													// ES
																													// DE
																													// distinto
																													// sexo
																													// al
																													// otro
																													// y
																													// el
																													// otro
																													// es
																													// bisexual
				bandera = true;
			break;

		case BI:

			if (this.sexo != usuarioComparar.getSexo() && usuarioComparar.getOrientacionSexual().equals(HETERO) // SEXOS
																												// DISTINTOS
																												// Y
																												// OTRO
																												// HETERO
					|| this.sexo == usuarioComparar.getSexo() && usuarioComparar.getOrientacionSexual().equals(GAY)) // SEXOS
																														// IGUALES
																														// Y
																														// EL
																														// OTRO
																														// GAY
				bandera = true;
			break;

		case GAY:
			if (this.sexo == usuarioComparar.getSexo() && usuarioComparar.getOrientacionSexual().equals(GAY) // MISMO
																												// SEXO
																												// MISMA
																												// ORIENTACION
																												// (GAY)
					|| this.sexo == usuarioComparar.getSexo() && usuarioComparar.getOrientacionSexual().equals(BI)) // MISMO
																													// SEXO
																													// Y
																													// MISMA
																													// ORIENTACION
																													// (BI)

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
	 * @param usuarioComparar
	 * @return devuelve mediante un operador ternario 20 de indice de compatiblidad
	 *         si son de la misma ciudad. 0 en cualquier otro caso
	 */
	private int calcularCompatibilidadCiudad(Usuario usuarioComparar) {

		return this.ciudad.equalsIgnoreCase(usuarioComparar.getciudad()) ? 20 : 0;

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
	 * @param usuarioComparar
	 * @return devuelve el numero de intereses comunes multiplicado por 10
	 */
	private int calcularCompatibilidadIntereses(Usuario usuarioComparar) {
		List<String> interesesComunes = new ArrayList<String>(this.intereses);
		interesesComunes.retainAll(usuarioComparar.getIntereses()); // quitamos de la lista todos los intereses que
																	// no sean comunes
		return interesesComunes.size() * 20; // el tamanio de esa lista (es decir, cada interes en comun) sera
												// multiplicado por 10 y devuelto al metodo principal
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
	 * @param usuarioComparar
	 * @return devuelve 10 si la diferencia de edad es menor o igual 5. Si la
	 *         diferencia de edad es menor de 10 se devuelve 5. En cualquier otro
	 *         caso, no suma.
	 */
	private int calcularCompatibilidadEdad(Usuario usuarioComparar) {
		int diferenciaEdad = Math.abs(this.edad - usuarioComparar.edad); // Con esto obtenemos la diferencia de edad
																			// entre los usuarios
		int compatiblidad = 0;

		if (diferenciaEdad <= 5) {
			compatiblidad = 10;
		} else if (diferenciaEdad > 5 && diferenciaEdad <= 10)
			compatiblidad = 5;
		else
			compatiblidad = 0;

		return compatiblidad;
	}

	/**
	 * Manuel 
	 * 	Metodo por el que encontramos los usuarios compatibles entre si.
	 * 
	 * @param usuario
	 * @param arrayUsuarios
	 * @return el array de usuarios compatibles
	 */
	private ArrayList<Usuario> comprobarCompatibilidad(Usuario usuario, ArrayList<Usuario> arrayUsuarios) {
		ArrayList<Usuario> usuariosCompatibles = new ArrayList<Usuario>();
		for (int i = 0; i < arrayUsuarios.size(); i++) {
			if ((!arrayUsuarios.get(i).equals(usuario)) && banderaCompatibilidad(arrayUsuarios.get(i))) {
				usuariosCompatibles.add(arrayUsuarios.get(i));
			}
		}
		return usuariosCompatibles;
	
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
					intereses.add(interes.toLowerCase());
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
	 * @author DANI_ Filtra una lista de usuarios que tienen intereses en común con
	 *         el usuario dado.
	 *
	 * @param usuario  El usuario del que se desea encontrar intereses comunes.
	 * @param usuarios La lista de usuarios en la que se buscarán intereses
	 *                 comunes.
	 * @return Una lista de usuarios que tienen intereses en común con el usuario
	 *         especificado.
	 */
	public ArrayList<Usuario> filtroInteresesComunes(Usuario usuario, ArrayList<Usuario> usuarios) {

		ArrayList<Usuario> usuariosCompatibles = new ArrayList<Usuario>();
		ArrayList<Usuario> genteConInteresesComunes = new ArrayList<Usuario>();
		ArrayList<String> interesesComunes = new ArrayList<String>(this.intereses);

		usuariosCompatibles = comprobarCompatibilidad(usuario, usuarios);

		for (int i = 0; i < usuariosCompatibles.size(); i++) {
			interesesComunes.retainAll(usuariosCompatibles.get(i).getIntereses());
			if (!interesesComunes.isEmpty())
				genteConInteresesComunes.add(usuariosCompatibles.get(i));
		}
		return genteConInteresesComunes;
	}

	/**
	 * @author DANI_ Filtra una lista de usuarios por ciudad.
	 *
	 * @param ciudades La lista de usuarios a filtrar.
	 * @param ciudad   La ciudad por la que se desea filtrar.
	 * @return Una nueva lista que contiene solo los usuarios que viven en la ciudad
	 *         especificada.
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
	 * @author DANI_ Filtra una lista de usuarios por edad.
	 *
	 * @param edad       La lista de usuarios a filtrar.
	 * @param edadMinima La edad mínima de los usuarios que se desean filtrar.
	 * @param edadMaxima La edad máxima de los usuarios que se desean filtrar.
	 * @return Una nueva lista que contiene solo los usuarios cuya edad está dentro
	 *         del rango especificado.
	 */
	public static List<Usuario> filtrarPorEdad(List<Usuario> edad, int edadMinima, int edadMaxima) {
		return edad.stream().filter(ciudades -> ciudades.getEdad() >= edadMinima && ciudades.getEdad() <= edadMaxima)
				.collect(Collectors.toList());
	}

	/**
	 * @author DANI_ Filtra una lista de usuarios por idioma.
	 *
	 * @param idioma La lista de usuarios a filtrar.
	 * @param lengua El idioma por el que se desea filtrar.
	 * @return Una nueva lista que contiene solo los usuarios que hablan el idioma
	 *         especificado.
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

	/**	Manuel.
	 * 
	 * @param usuario
	 * @param arrayUsuarios
	 * @return Array de gente con bajo indice de compatibilidad
	 */
	public ArrayList<Usuario> filtroInteresesOpuestos(Usuario usuario, ArrayList<Usuario> arrayUsuarios) {

		ArrayList<Usuario> usuariosCompatibles = new ArrayList<Usuario>();
		ArrayList<Usuario> genteConPocaCompatiblidad = new ArrayList<Usuario>();
		int indiceCompatibilidad;

		usuariosCompatibles = comprobarCompatibilidad(usuario, arrayUsuarios);

		for (int i = 0; i < usuariosCompatibles.size(); i++) {

			indiceCompatibilidad = calcularCompatiblidad(usuariosCompatibles.get(i));

			if (indiceCompatibilidad <= 30)
				genteConPocaCompatiblidad.add(usuariosCompatibles.get(i));
		}
		return genteConPocaCompatiblidad;

	}

	/**
	 * @author Manuel
	 * 	
	 * 			Este metodo es una herramienta auxiliar que hemos usado para generar intereses aleatorios en el constructor.
	 * 	
	 * @serialData	 Declaramos dentro de la herramienta 3 variables tipo int
	 * 				cantidadIntereses: el numero de intereses generados aleatoriamente.
	 * 				categoriaAletoria:corresponderia al indice, o a la categoria de los intereses
	 * 				interesAelatorio: que seria dentro de la categoria, el intereses seleccionado.
	 * 
	 */
	public void generarInteresesAleatorios() {
		ArrayList<String> intereses = new ArrayList<String>();
	

		// Seleccionar un numero aleatorio entre 1 y 3, que sera la cantidad de
		// intereses que tendra el usuario
		int cantidadIntereses = 5;
		int categoriaAleatoria;
		int interesAleatorio;

		for (int i = 0; i < cantidadIntereses; i++) {
			 categoriaAleatoria = Util.numeroAleatorio.nextInt(LISTA_INTERESES.length); // Seleccionar una categoria aleatoria de  la lista de intereses
			
			 interesAleatorio = Util.numeroAleatorio.nextInt(LISTA_INTERESES[categoriaAleatoria].length - 1) + 1; // Seleccionar un interes aleatorio de la categoria seleccionada

			String interes = LISTA_INTERESES[categoriaAleatoria][interesAleatorio];
			if (!intereses.contains(interes)) {
				intereses.add(interes);
			}
		}
		this.intereses = intereses;

	}

	/**
	 * @author DANI_ Genera aleatoriamente un usuario compatible con el usuario
	 *         introducido.
	 *
	 * @param usuario       El usuario con el que se va a comprobar la
	 *                      compatibilidad.
	 * @param arrayUsuarios La lista de todos los usuarios existentes (incluyendo al
	 *                      usuario introducido).
	 * @return Un usuario compatible aleatorio, o null si no se encontró ningún
	 *         usuario compatible.
	 */
	
	public Usuario generarUsuarioCompatibleAleatorio(Usuario usuario, ArrayList<Usuario> arrayUsuarios) {
	
		ArrayList<Usuario> usuariosCompatibles = comprobarCompatibilidad(usuario, arrayUsuarios);
		int numeroAleatorio;
		Usuario usuarioRandom;
	
		if (!usuariosCompatibles.isEmpty()) {
			numeroAleatorio = Util.generarNumerosAleatorios(0, usuariosCompatibles.size() - 1);
			usuarioRandom = usuariosCompatibles.get(numeroAleatorio);
		} else
			usuarioRandom = null;
	
		return usuarioRandom;
	}

	@Override
	public String toString() {
		final String FORMATO_TEXTO = "| %-16s | %-19s |%n";
		final String SEPARADOR_LINEA = "+---------------------------------------+\n";
		StringBuilder cadenaFuerte = new StringBuilder();

		cadenaFuerte.append(SEPARADOR_LINEA).append(String.format(FORMATO_TEXTO, "Nombre", nombre))
				.append(SEPARADOR_LINEA).append(String.format(FORMATO_TEXTO, "Apellido", apellido))
				.append(SEPARADOR_LINEA).append(String.format(FORMATO_TEXTO, "Edad", edad)).append(SEPARADOR_LINEA)
				.append(String.format(FORMATO_TEXTO, "Ciudad", ciudad)).append(SEPARADOR_LINEA)
				.append(String.format(FORMATO_TEXTO, "Idioma", idioma)).append(SEPARADOR_LINEA)
				.append(String.format(FORMATO_TEXTO, "Preferencias", orientacionSexual)).append(SEPARADOR_LINEA)
				.append(String.format(FORMATO_TEXTO, "Intereses", intereses)).append(SEPARADOR_LINEA)
				.append(String.format(FORMATO_TEXTO, "Sexo", sexo)).append(SEPARADOR_LINEA).append("\nDescripcion:\n")
				.append(SEPARADOR_LINEA).append(String.format("| %-38s |%n", descripcion)).append(SEPARADOR_LINEA);

		return cadenaFuerte.toString(); 

	}

}
