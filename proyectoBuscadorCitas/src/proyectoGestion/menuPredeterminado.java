package proyectoGestion;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import proyectoModelos.Usuario;

public class menuPredeterminado {

	private static ArrayList<Usuario> usuarios = new ArrayList(generarUsuariosPrueba(20));

	public static void main(String[] args) {
	menuMarco()

	}

	/**
	 * @author Manuel
	 * 			
	 * 			Metodo que sirve como primer menu principal y donde anidaremos
	 *         los metodos principales
	 *  
	 * @see #menuEmparejamiento(Usuario) {@link #crearUsuario()}
	 */
	public static void menuMarco() {
		Usuario usuarioPrograma = null;
		String despedida = "Hasta otra!";
		// 	Usuario prueba1 = new Usuario(); Dejamos esta linea comentada por facilitar el uso del programa

		int opcionUsuario;

		do {
			almacenPantallazos(1);
			opcionUsuario = Util.pedirNumero(); // Se controlan las excepciones dentro del Util
			switch (opcionUsuario) {
			case 1:
				usuarioPrograma = crearUsuario();

				break;
			case 2:
				if (usuarioPrograma == null)
					System.out.println("Para acceder a estas opciones debe crear un usuario primero");
				else
					menuEmparejamiento(usuarioPrograma);

				break;
			case 3:
				System.out.println(despedida);

				break;

			default:
				break;
			}
		} while (opcionUsuario != 3);

	}
/**
 * @author Manuel
 * 			Este metodo consiste en otro switch donde en cada CASE hacemos la llamada al metodo pertinente,
 * 			sea de la clase USUARIO o del mismo menu.
 * 			@see #mostrarOpcionesFiltrado(int, Usuario)
 * 
 * @param usuario
 * @return Devuelve al mismo usuario en caso de que quiera hacer alguna otra cosa en {@link #menuMarco()}
 */
	public static Usuario menuEmparejamiento(Usuario usuario) {
		ArrayList<Usuario> listaFiltrado;
		Usuario usuarioRandom;

		int opcion;

		do {
			almacenPantallazos(2);
			System.out.println("Introduzca una opcion");
			opcion = Util.pedirNumero();
			switch (opcion) {
			case 1:
				almacenPantallazos(4);
				opcion = Util.pedirNumero();
				mostrarOpcionesFiltrado(opcion, usuario);

				break;

			case 2:
				listaFiltrado = usuario.filtroInteresesComunes(usuario, usuarios);
				System.out.println(usuario);
				for (Usuario resultado : listaFiltrado) {
					System.out.println(resultado);
					System.out.println(mostrarCompatiblidad(usuario, resultado));
				}
				break;

			case 3:
				listaFiltrado = usuario.filtroInteresesOpuestos(usuario, usuarios);
				System.out.println(usuario);

				for (Usuario resultado : listaFiltrado) {
					System.out.println(resultado);
					System.out.println(mostrarCompatiblidad(usuario, resultado));

				}
				break;

			case 4:
				System.out.println(usuario);
				usuarioRandom = usuario.generarUsuarioCompatibleAleatorio(usuario, usuarios);
				if (!usuarioRandom.equals(null)) {
					System.out.println(usuarioRandom);
					System.out.println(mostrarCompatiblidad(usuario, usuarioRandom));
				} else
					System.out.println("ahora mismo no contamos con nadie compatible aleatoriamente");

				break;

			default:
				break;
			}
		} while (opcion != 5);
		return usuario;
	}

	public static ArrayList<Usuario> mostrarOpcionesFiltrado(int opcion, Usuario usuarioBase) {
	ArrayList<Usuario> resultadoFiltro = new ArrayList<>();
	final String advertencia = "No hay nadie en nuestra aplicacion que responda a ese filtro";

	switch (opcion) {

	case 1:

		resultadoFiltro = preguntaFiltrosCiudad(usuarios);
		System.out.println(usuarioBase);
		if (resultadoFiltro.isEmpty())
			System.out.println(advertencia);
		for (Usuario usuarioFiltrado : resultadoFiltro) {
			System.out.println(usuarioFiltrado);
			System.out.println(mostrarCompatiblidad(usuarioBase, usuarioFiltrado));

		}
		break;
	case 2:
		resultadoFiltro = preguntaFiltroEdad(usuarios);
		System.out.println(usuarioBase);
		if (resultadoFiltro.isEmpty())
			System.out.println(advertencia);
		for (Usuario usuarioFiltrado : resultadoFiltro) {
			System.out.println(usuarioFiltrado);
			System.out.println(mostrarCompatiblidad(usuarioBase, usuarioFiltrado));
		}

		break;
	case 3:
		resultadoFiltro = preguntaFiltroIdioma(usuarios);
		if (resultadoFiltro.isEmpty())
			System.out.println(advertencia);
		for (Usuario usuarioFiltrado : resultadoFiltro) {
			System.out.println(usuarioFiltrado);
			System.out.println(mostrarCompatiblidad(usuarioBase, usuarioFiltrado));
		}
		break;

	}

	return resultadoFiltro;

}

	/**
	 * @author Manuel
	 * 
	 *         Metodo donde almacenanmos una variable String con el texto de cada
	 *         menu para usarlo en distintas partes del codigo
	 *  @param hay que indicar que bloquedeTexto se quiere mostrar mediante la variable
	 *  		numeroPantallazo
	 * 
	 */
	private static void almacenPantallazos(int numeroPantallazo) {
		String bloqueTexto;
		switch (numeroPantallazo) {
		case 1:
			bloqueTexto = """
					Que desea hacer?
					1. - Aniadir una nueva persona
					2. - Buscar emparejamientos
					3. - Salir del programa
					""";
			System.out.println(bloqueTexto);

			break;
		case 2:
			bloqueTexto = """
					Como desea buscar?

					1. - Filtrando
					2. - Personas con mismos datos en comun
					3. - Personas con aficiones opuestas
					4. - Busqueda aleatoria
					5. - Volver atras
										""";
			System.out.println(bloqueTexto);
			break;
		case 3:
			bloqueTexto = """
					A continuacion podra introducir los datos de su ficha como usuario

					Si no esta contento con el resultado puede volver a introducir los datos
											""";
			System.out.println(bloqueTexto);
			break;
		case 4:
			bloqueTexto = """
					Como desea Filtrar?
					1.Filtrar por ciudad.
					2.Filtrar por edad.
					3.Filtrar por Idioma.

					""";

			System.out.println(bloqueTexto);
			break;
		default:
			break;
		}
	}

	/**
	 * @author DANI_ Metodo por el cual mostramos al usuario un filtro de edad,
	 *         donde se le preguta al usuario un minimo un maximo de aÃ±os y luego
	 *         se guarda el resultado en un ArrayList y despues se llama a otro
	 *         metodo por el cual se muestra por pantalla.
	 * @param usuarios
	 */
	public static void preguntaFiltroEdad(List<Usuario> usuarios) {

		int minimo;
		int maximo;
		Scanner sc = new Scanner(System.in);
		System.out.println("Dime la Edad Minima que quieres filtrar");
		minimo = sc.nextInt();
		System.out.println("Dime la Edad Maxima que quieres filtrar");
		maximo = sc.nextInt();

		List<Usuario> personasPorEdad = Usuario.filtrarPorEdad(usuarios, minimo, maximo);
		mostrarFiltroEdad(personasPorEdad);

	}

	/**
	 * @author DANI_ Metodo por el cual se muestra al usuario por pantalla el
	 *         resultado de filtrar una ciudad.
	 * @param personasPorCiudad
	 * @return
	 */
	public static List<Usuario> mostrarFiltroCiudad(List<Usuario> personasPorCiudad) {
		for (Usuario u : personasPorCiudad) {
			System.out.println(u.getNombre());
		}
		return personasPorCiudad;

	}

	/**
	 * @author DANI_ Metodo por el cual se muestra al usuario por pantalla el
	 *         resultado de filtrar por edad.
	 * @param personasPorCiudad
	 * @return
	 */
	public static List<Usuario> mostrarFiltroEdad(List<Usuario> personasEnRangoDeEdad) {
		for (Usuario persona : personasEnRangoDeEdad) {
			System.out.println(persona.getNombre());
		}
		return personasEnRangoDeEdad;

	}

	/**
	 * @author DANI_ Metodo por el cual se muestra al usuario por pantalla el
	 *         resultado de filtrar por idioma.
	 * @param personasPorCiudad
	 * @return
	 */

	public static ArrayList<Usuario> mostrarFiltroIdioma(List<Usuario> personasIdioma) {
		for (Usuario persona : personasIdioma) {
			System.out.println(persona.getNombre());
		}
		return (ArrayList<Usuario>) personasIdioma;

	}

	/**
	 * @author DANI_ Metodo por el cual se muestra al usuario por pantalla el
	 *         resultado de filtrar por idioma.
	 * @param personasPorCiudad
	 * @return
	 */
	public static ArrayList<Usuario> preguntaFiltroIdioma(ArrayList<Usuario> usuarios) {
		ArrayList<Usuario> personasPorIdioma;
		String idioma = "";
		System.out.println("Dime el idioma que quieres filtar");
		idioma = Util.pedirString();
		return personasPorIdioma = Usuario.filtrarPorIdioma(usuarios, idioma);

	}

	/**
	 * @author DANI_ Metodo por el cual mostramos al usuario un filtro de edad,
	 *         donde se le preguta al usuario un minimo un maximo de años y luego se
	 *         guarda el resultado en un ArrayList y despues se llama a otro metodo
	 *         por el cual se muestra por pantalla.
	 * @param usuarios
	 * @return
	 */
	public static ArrayList<Usuario> preguntaFiltroEdad(ArrayList<Usuario> usuarios) {

		int minimo;
		int maximo;
		Scanner sc = new Scanner(System.in);
		System.out.println("Dime la Edad Minima que quieres filtrar");
		minimo = sc.nextInt();
		System.out.println("Dime la Edad Maxima que quieres filtrar");
		maximo = sc.nextInt();

		ArrayList<Usuario> personasPorEdad = Usuario.filtrarPorEdad(usuarios, minimo, maximo);

		return (ArrayList<Usuario>) mostrarFiltroEdad(personasPorEdad);

	}

	/**
	 * @author DANI_ Metodo por el cual mostramos al usuario un filtro de Ciudad,
	 *         donde se le preguta al usuario la ciudad que desea filtrar y luego se
	 *         guarda el resultado en un ArrayList y despues se llama a otro metodo
	 *         por el cual se muestra por pantalla.
	 * @param usuarios
	 * @return
	 */

	public static ArrayList<Usuario> preguntaFiltrosCiudad(ArrayList<Usuario> usuarios) {
		ArrayList<Usuario> personasPorCiudad;
		String entradaDatos;
		System.out.println("Dime la Ciudad que quieres Filtrar");
		entradaDatos = Util.pedirString();
		personasPorCiudad = Usuario.filtrarPorCiudad(usuarios, entradaDatos);
		return personasPorCiudad;
	}

	/**
	 * @author Manuel Metodo
	 * 
	 *         metodo creado para encapsular el numero de condicionales en la
	 *         funcion {@link #crearUsuario()} mediante un switch. Segun la opcion
	 *         que marquemos nos verificara un dato segun distintas condiciones.
	 * 
	 * 
	 * @param numeroSwitch tenemos que indicar que case queremos aplicar SIENDO EL 1
	 *                     PARA LA ORIENTACION SEXUAL Y EL 2 PARA SU SEXO
	 * @return el dato verificado segun los parametros de cada condicion
	 */
	public static String delimitadorOpcionesCreacionUsuario(int numeroSwitch) {
		// con este metodo auxiliar vamos a controlar las entradas de datos que
		// necesitan de algo mas de verificacion
		// las que no se pueden controlar con el Util.pedirString vaya
		String datoVerificado = "";
		boolean bandera = true;

		switch (numeroSwitch) {

		case 1:

			while (bandera) {
				datoVerificado = Util.pedirString();
				if (!(datoVerificado.equalsIgnoreCase("hetero") || datoVerificado.equalsIgnoreCase("Homo")
						|| datoVerificado.equalsIgnoreCase("bi")))
					System.out.println("Revise su eleccion");
				else
					bandera = false;
			}

			break;

		case 2:

			while (bandera) {
				datoVerificado = Util.pedirString();
				if (!(datoVerificado.equalsIgnoreCase("Hombre") || datoVerificado.equalsIgnoreCase("Mujer")))

					System.out.println("Revise su eleccion");
				else
					bandera = false;
			}
			break;

		}

		return datoVerificado.toUpperCase();

	}

	/**
	 * @author Manuel Metodo para crear una instancia de Usuario por parametros.
	 * 
	 *         Tiene anidados varios metodos tantos de esta clase como de la clase
	 *         Util.
	 */
	public static Usuario crearUsuario() {

		almacenPantallazos(3);
		Usuario usuarioParametros;
		int opcion;
		String nombre;
		String apellido;
		String ciudad;
		String idioma;
		String descripcion;
		String orientacionSexual;
		String sexo;
		LocalDate fechaNacimiento;

		do {
			System.out.print("Introduzca su nombre: ");
			nombre = Util.pedirString(); 
										
			System.out.print("Ahora su apellido: ");
			apellido = Util.pedirString();
			System.out.println("Ingrese su fecha de nacimiento");
			fechaNacimiento = Util.solicitarFecha();

			System.out.print("Ciudad de residencia: ");
			ciudad = Util.pedirString();
			System.out.print("Idioma: ");
			idioma = Util.pedirString(); 
			System.out.print("Introduzca una descripcion:\n");
			descripcion = Util.pedirString();
			System.out.println("indique su sexo (Hombre/Mujer)");
			sexo = delimitadorOpcionesCreacionUsuario(2); 

			System.out.println("Escoja sus preferencias : HETERO | GAY | BI ");
			orientacionSexual = delimitadorOpcionesCreacionUsuario(1);

			String[] infoPersonal = { nombre, apellido, ciudad, idioma, descripcion, orientacionSexual }; // Creamos un
																											// array
																											// para
																											// que el
																											// constructor
																											// no tenga
																											// 12039897
																											// mil
																											// parametros
																											// de
																											// entrada

			usuarioParametros = new Usuario(infoPersonal, fechaNacimiento, sexo.charAt(0));

			System.out.println("\nPor ultimo, de la siguiente lista escoja los intereses que le parezcan.");
			System.out.println("Teclee su interes. Cuando desee terminar la insercion, teclee fin.");

			System.out.println(Usuario.mostrartInteresesDisponibles());

			usuarioParametros = agregarInteresesUsuario(usuarioParametros);

			System.out.println(usuarioParametros);

			System.out.println("Estas de acuerdo con el perfil?\n1.Si\n2.No");
			opcion = Util.pedirNumero();
		} while (opcion != 1);

		return usuarioParametros;
	}

	/**
	 * @author DANI_ Metodo por el cual mostramos al usuario un filtro de Ciudad,
	 *         donde se le preguta al usuario la ciudad que desea filtrar y luego se
	 *         guarda el resultado en un ArrayList y despues se llama a otro metodo
	 *         por el cual se muestra por pantalla.
	 * @param usuarios
	 * @return
	 */

	public static String mostrarCompatiblidad(Usuario usuarioBase, Usuario usuarioComparado) {
		String mensaje;
		mensaje = "Tu indice de compatibilidad con " + usuarioComparado.getNombre() + " es del: "
				+ usuarioComparado.calcularCompatiblidad(usuarioBase) + "%";
		return mensaje;

	}

	/**
	 * @author Manuel Este metodo encapsula la manera de aniadir intereses al
	 *         usuario en cuestion
	 * @param usuarioParametros Se debe introducir el usuario que hayamos creado
	 *                          para ir agregando intereses al arraylist
	 * @return devuelve un arraylist con todos los intereses seleccionado por el
	 *         usuario
	 */
	static Usuario agregarInteresesUsuario(Usuario usuarioParametros) {
		boolean bandera = true;
		String interes;
		while (bandera) {

			interes = Util.pedirString();
			if (interes.equalsIgnoreCase("fin"))
				bandera = false;

			usuarioParametros.agregarListaIntereses(interes);
		}
		return usuarioParametros;

	}

	/**
	 * @author Manuel
	 * 
	 * 			Este metodo tiene una serie de arrays que refieren a los atributos de la clase Usuario
	 * 			Mediante un bucle for se iran asignando aleatoriamente. Hay 2 array list de nombres
	 * 			para cada sexo, por aquello de aportar algo de coherencia. El  parametro de entrada
	 * 			representa la cantidad de usuarios que queremos que nos devuelvan.
	 * @param cantidad de usuarios de prueba
	 * @return Un array con dichos usuarios
	 */
	public static ArrayList<Usuario> generarUsuariosPrueba(int cantidad) {
		ArrayList<Usuario> usuarios = new ArrayList<>();

		String[] nombresH = { "Juan", "Ricardo", "Pedro", "Pepe", "Felipe", "Carlos", "Cristobal", "Pablo", "Adrian", // Nombres
																														// para
																														// hombres
				"Andres" };

		String[] nombresM = { "Cristina", "Ana", "Naturaleza", "Maria", "Luisa", "Marta", "Lucia", "Leonor", "Laura", // Nombres
																														// para
																														// mujeres
				"Clara" };

		String[] apellidos = { "Garcia", "Martinez", "Fernandez", "Lopez", "Perez", "Gonzalez", "Sanchez", "Romero",
				"Saez", "Jimenez" };
		String[] ciudades = { "Madrid", "Barcelona", "Valencia", "Sevilla", "Bilbao", "Zaragoza", "Malaga", "Murcia",
				"Palma de Mallorca", "Las Palmas" };
		String[] idiomas = { "Espaniol", "Ingles", "Frances", "Aleman" };
		String[] descripciones = { "Me gusta viajar y conocer nuevos lugares",
				"Soy una persona muy activa y deportista", "Me encanta leer y pasar tiempo en casa",
				"Soy muy extrovertido y me gusta hacer nuevos amigos", "Me considero una persona tranquila y relajada",
				"Me apasiona la m�sica y toco varios instrumentos",
				"Soy un amante de los animales y tengo varias mascotas", "Me gusta cocinar y probar nuevos platos",
				"Soy una persona muy creativa y me gusta dibujar y pintar", "Me encanta el cine y las series" };
		String[] orientaciones = { "HETERO", "GAY", "BI" };

		Usuario usuario;
		String apellido;
		String ciudad;
		String idioma;
		String descripcion;
		String orientacion;
		LocalDate fechaNacimiento;

		for (int i = 0; i < cantidad; i++) { // el bucle genera usuarios segun el parametro de cantidad indicado

			char sexo = Util.numeroAleatorio.nextBoolean() ? 'H' : 'M';
			String nombre;
			if (sexo == 'H') {
				nombre = nombresH[Util.numeroAleatorio.nextInt(nombresH.length)]; // condicional para elegir el nombre
																					// segun su sexo
			} else {
				nombre = nombresM[Util.numeroAleatorio.nextInt(nombresH.length)];
			}

			apellido = apellidos[Util.numeroAleatorio.nextInt(apellidos.length)];
			ciudad = ciudades[Util.numeroAleatorio.nextInt(ciudades.length)];
			idioma = idiomas[Util.numeroAleatorio.nextInt(idiomas.length)];
			descripcion = descripciones[Util.numeroAleatorio.nextInt(descripciones.length)];
			orientacion = orientaciones[Util.numeroAleatorio.nextInt(orientaciones.length)];
			fechaNacimiento = LocalDate.of(Util.numeroAleatorio.nextInt(50) + 1950,
					Util.numeroAleatorio.nextInt(12) + 1, Util.numeroAleatorio.nextInt(28) + 1);

			String[] informacionPersonal = new String[] { nombre, apellido, ciudad, idioma, descripcion, orientacion };

			usuario = new Usuario(informacionPersonal, fechaNacimiento, sexo);
			usuario.generarInteresesAleatorios();
			usuarios.add(usuario);

		}
		return usuarios;
	}

}
