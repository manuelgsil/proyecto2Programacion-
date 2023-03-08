package proyectoGestion;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import proyectoModelos.Usuario;
import proyectoModelos.Util;

public class menuPredeterminado {

	private static Scanner inputInt = new Scanner(System.in);
	private static Scanner inputString = new Scanner(System.in);
	private static ArrayList<Usuario> usuarios = new ArrayList(generarUsuariosPrueba(30));

	public static void main(String[] args) {

		Usuario prueba1 = new Usuario();

		menuEmparejamiento(prueba1);
	}

	/**
	 * @author Manuel Metodo que sirve como primer menu principal y donde anidaremos
	 *         los metodos principales
	 */
	public static void menuMarco() {
		Usuario usuarioPrograma = null;
		String despedida = "Hasta otra!";

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

	public static Usuario menuEmparejamiento(Usuario usuario) {
		ArrayList<Usuario> listaFiltrado;
		Usuario usuarioRandom;

		Usuario usuarioprueba = new Usuario();
		int opcion;

		do {
			almacenPantallazos(2);
			System.out.println("Introduzca una opcion");
			opcion = Util.pedirNumero();
			switch (opcion) {
			case 1:

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

			case 5:
				break;

			default:
				break;
			}
		} while (opcion != 5);
		return usuario;
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
			nombre = Util.pedirString(); // Con el util controlamos que los datos que nos introduzca son validos de por
											// si
			System.out.print("Ahora su apellido: ");
			apellido = Util.pedirString();
			System.out.println("Ingrese su fecha de nacimiento");
			fechaNacimiento = Util.solicitarFecha(); // con este tambien esta validado automaticamente

			System.out.print("Ciudad de residencia: ");
			ciudad = Util.pedirString(); // Quiza seria posible controlar esto pero no lo veo necesario ahora mismo
			System.out.print("Idioma: ");
			idioma = Util.pedirString(); // tambien controlado
			System.out.print("Introduzca una descripcion:\n");
			descripcion = Util.pedirString(); // AQUI HABRIA QUE CONTROLAR EL LIMITE DE CARACTERES SI QUEREMOS DARLE UN
												// TOQUE GRACIOSO
			System.out.println("indique su sexo (Hombre/Mujer)");
			sexo = delimitadorOpcionesCreacionUsuario(2); // Este es el parametro para el sexo

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

			System.out.println("\nPor ultimo, de la siguiente lista escoja los intereses que le parezcan."); // TODO
																												// controlar
																												// esta
																												// entrada
			System.out.println(Usuario.mostrartInteresesDisponibles());

			usuarioParametros = agregarInteresesUsuario(usuarioParametros);

			System.out.println(usuarioParametros);

			System.out.println("Estas de acuerdo con el perfil?\n1.Si\n2.No");
			opcion = Util.pedirNumero();
		} while (opcion != 1);

		return usuarioParametros;
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
	 *                     
	 *                     
	 * @return el dato verificado segun los parametros de cada condicion
	 */
	public static String delimitadorOpcionesCreacionUsuario(int numeroSwitch) {
		//
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

	public static List<Usuario> mostrarFiltroIdioma(List<Usuario> personasIdioma) {
		for (Usuario persona : personasIdioma) {
			System.out.println(persona.getNombre());
		}
		return personasIdioma;

	}

	/**
	 * @author DANI_ Metodo por el cual mostramos al usuario un filtro de edad,
	 *         donde se le preguta al usuario un minimo un maximo de años y luego se
	 *         guarda el resultado en un ArrayList y despues se llama a otro metodo
	 *         por el cual se muestra por pantalla.
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
	 * @author DANI_ Metodo por el cual mostramos al usuario un filtro de Ciudad,
	 *         donde se le preguta al usuario la ciudad que desea filtrar y luego se
	 *         guarda el resultado en un ArrayList y despues se llama a otro metodo
	 *         por el cual se muestra por pantalla.
	 * @param usuarios
	 */

	public static void preguntaFiltrosCiudad(List<Usuario> usuarios) {
		Scanner sc = new Scanner(System.in);
		String entradaDatos;
		System.out.println("Dime la Ciudad que quieres Filtrar");

		entradaDatos = sc.nextLine();

		List<Usuario> personasPorCiudad = Usuario.filtrarPorCiudad(usuarios, entradaDatos);
		mostrarFiltroCiudad(personasPorCiudad);

	}

	/**
	 * @author Manuel 
	 * 
	 * 		   Metodo de la clase menu que nos generara un array de usuarios
	 *         aleatorios segun la informacion provista. Como parametro de entrada
	 *         hay que indicar el numero de usuarios que se desea obtener.
	 * @param cantidad de usuarios de prueba
	 * @return Devuelve un array con dichos usuarios
	 */
	public static ArrayList<Usuario> generarUsuariosPrueba(int cantidad) {
		ArrayList<Usuario> usuarios = new ArrayList<>();

		String[] nombresH = { "Juan", "Ricardo", "Pedro", "Pepe", "Felipe", "Carlos", "Cristobal", "Pablo", "Adrian", //Nombres para hombres
				"Andres" };

		String[] nombresM = { "Cristina", "Ana", "Naturaleza", "Maria", "Luisa", "Marta", "Lucia", "Leonor", "Laura",//Nombres para mujeres
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
				nombre = nombresH[Util.numeroAleatorio.nextInt(nombresH.length)]; // condicional para elegir el nombre segun su sexo
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

	/**
	 * @author Manuel
	 * 
	 *         Metodo donde almacenanmos una variable String con el texto de cada
	 *         menu para usarlo en distintas partes del codigo
	 * 
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
	
		default:
			break;
		}
	}

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

}
