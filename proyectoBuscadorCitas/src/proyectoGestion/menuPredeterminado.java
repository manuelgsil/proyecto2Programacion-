package proyectoGestion;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import proyectoModelos.Usuario;

public class menuPredeterminado {

	private static Scanner inputInt = new Scanner(System.in);
	private static Scanner inputString = new Scanner(System.in);

	public static void main(String[] args) {
		List<Usuario> filtro = new ArrayList<>();
		Usuario usuarioPrueba = new Usuario();
		filtro.add(usuarioPrueba);

	System.out.println(usuarioPrueba);
	
	
	String nombre, apellido, ciudad, idioma, descripcion, preferencias, contrasenia;
	LocalDate fechaNacimiento;
	ArrayList<String> interesesUsuario = new ArrayList<>();


	System.out.print("Nombre: ");
	nombre = inputString.next();
	System.out.print("Apellido: ");
	apellido = inputString.next();
	System.out.println("Ingrese su fecha de nacimiento");
	fechaNacimiento = Util.solicitarFecha();
	System.out.print("Ciudad: ");
	ciudad = inputString.next();
	System.out.print("Idioma: ");
	idioma = inputString.next();
	System.out.print("Descripcion: ");
	descripcion = inputString.next();

	System.out.println("Escoja sus preferencias : HETERO | HOmO | BI ");
	preferencias = inputString.next();
	// TODO REALIZAR BUCLE
	if (!(preferencias.equalsIgnoreCase("hetero") || preferencias.equalsIgnoreCase("Homo")
			|| preferencias.equalsIgnoreCase("bi")))
		System.out.println("Revise su eleccion");

	interesesUsuario = mostrarInteresesDisponibles(); // Revisar esto posteriormente. Me da que podria plantearse
														// mejor
	System.out.println("Por ultimo introduzca una contrasenia: ");
	contrasenia = inputString.next();

	Usuario usuarioNuevo = new Usuario(nombre, apellido, fechaNacimiento, ciudad, idioma, contrasenia, descripcion,
			preferencias, interesesUsuario);

	System.out.println(usuarioNuevo.calcularCompatiblidad(usuarioPrueba));
		
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
					¿Qué desea hacer?
					 1. - Añadir una nueva persona
					 2. - Buscar emparejamientos
					 3. - Salir del programa
					 """;
			System.out.println(bloqueTexto);

			break;
		case 2:
			bloqueTexto = """
					¿Como desea buscar?
					1. - Filtrando
					2. - Personas con más datos en común
					3. - Personas con aficiones opuestas
					4.- Búsqueda aleatoria
										""";
			System.out.println(bloqueTexto);
			break;

		default:
			break;
		}
	}

	/**
	 * @author Manuel Metodo que sirve como primer menu principal y donde anidaremos
	 *         los metodos principales
	 */
	private static void menuMarco() {

		// TODO Modificarlo segun lo que necesitemos

		int opcionUsuario;

		do {
			almacenPantallazos(1);
			opcionUsuario = inputInt.nextInt();
			switch (opcionUsuario) {
			case 1:
				crearUsuario();

				break;
			case 2:

				break;
			case 3:

				break;

			default:
				break;
			}
		} while (opcionUsuario != 3);

	}

	/**
	 * @author Manuel Metodo para crear una instancia de Usuario por parametros.
	 *         Tiene anidados varios metodos tantos de esta clase como de la clase
	 *         Util.
	 */
	public static void crearUsuario() {
		/*
		 * TODO Desarrollar este metodo para que mediante una serie de preguntas
		 * .
		 * almacenemos la informacion neceseria para pasarselo al constructor de clase
		 */

		/*
			
		 */
		Usuario usuarioPrueba = new Usuario();
		System.out.println(usuarioPrueba);
		String nombre, apellido, ciudad, idioma, descripcion, preferencias, contrasenia;
		LocalDate fechaNacimiento;
		ArrayList<String> interesesUsuario = new ArrayList<>();

		System.out.print("Nombre: ");
		nombre = inputString.next();
		System.out.print("Apellido: ");
		apellido = inputString.next();
		System.out.println("Ingrese su fecha de nacimiento");
		fechaNacimiento = Util.solicitarFecha();
		System.out.print("Ciudad: ");
		ciudad = inputString.next();
		System.out.print("Idioma: ");
		idioma = inputString.next();
		System.out.print("Descripcion: ");
		descripcion = inputString.next();

		System.out.println("Escoja sus preferencias : HETERO | HOmO | BI ");
		preferencias = inputString.next();
		// TODO REALIZAR BUCLE
		if (!(preferencias.equalsIgnoreCase("hetero") || preferencias.equalsIgnoreCase("Homo")
				|| preferencias.equalsIgnoreCase("bi")))
			System.out.println("Revise su eleccion");

		interesesUsuario = mostrarInteresesDisponibles(); // Revisar esto posteriormente. Me da que podria plantearse
															// mejor
		System.out.println("Por ultimo introduzca una contrasenia: ");
		contrasenia = inputString.next();

		Usuario usuarioNuevo = new Usuario(nombre, apellido, fechaNacimiento, ciudad, idioma, contrasenia, descripcion,
				preferencias, interesesUsuario);

		System.out.println(usuarioNuevo);
	}

	private static ArrayList<String> mostrarInteresesDisponibles() {
		// TODO La lista de intereses es provisional. Habra que retocarla de cara al
		// final

		String interesUnico = null; // String que usaremos para almacenar la opcion del usuario
		ArrayList<String> interesesUsuario = new ArrayList<>(); // Lista dinamica con la que podremos darle elasticidad
																// a las opciones
		// y al perfil por si quisiera modificar algo
		String bloqueTexto;
		boolean bandera = true;

		// Declaramos una lista dinamica para poder añadir o quitar posteriormente

		String[][] listaIntereses = { { "Deportes:", "Futbol", "Baloncesto", "Tenis", "Boxeo" },
				{ "Música:", "Rock", "Pop", "Electrónica" }, { "Arte y cultura:", "Pintura" },
				{ "Mascotas:", "Perros", "Gatos" }, { "Comida:", "Italiana", "Japonesa", "Mexicana" },
				{ "Bienestar y salud:", "Yoga", "Realfooder" }, { "Tecnología:", "Informatica", "Hardware" },
				{ "Videojuegos:", "Rpg", "Estrategia", "Plataformas" },
				{ "Cine y TV:", "Cine clasico", "Series TV", "Ciencia ficcion" },

		};

		// Imprimir filas de datos
		for (int i = 0; i < listaIntereses.length; i++) {
			System.out.printf("%-3d", i + 1);
			for (int j = 0; j < listaIntereses[i].length; j++) {
				System.out.printf("%-20s", listaIntereses[i][j]);
			}
			System.out.println();
		}

		bloqueTexto = """

				Debe seleccionar un minimo de 3 intereses.
				Escriba sus prefrencias despues de la lista.
				Cuando finalice o desee acabar, teclee fin.

				""";
		System.out.print(bloqueTexto);

		while (bandera) {

			interesUnico = inputString.next();

			if (interesUnico.equalsIgnoreCase("fin"))
				bandera = false;

			else
				interesesUsuario = agregarInteresesUsuario(listaIntereses, interesUnico, interesesUsuario);

		}
		return interesesUsuario;

	}

	/**
	 * @author Manuel
	 * 
	 *         Metodo por el cual agregamos el interes escogido por el usuario,
	 *         proveniente de un array bidimensional que contiene los permitidos, a
	 *         un ArrayList. Se ha controlado que no se puedan introducir las
	 *         categorias generales colocando el indice fuera de la variable j
	 *         (siempre empieza en 1)
	 * 
	 * 
	 * @param interesesPermitidos arrayBidimensinoal que contiene los intereses que
	 *                            se pueden escoger
	 * @param interesEscogido     String que contiene la seleccion del usuario
	 * @param interesesUsuario    arraylist que va generandose hasta que el usuario
	 *                            decide acabar
	 * @return Devuelve el arrayList con los intereses introducidos
	 */
	private static ArrayList<String> agregarInteresesUsuario(String[][] interesesPermitidos, String interesEscogido,
			ArrayList<String> interesesUsuario) {

		// TODO poner algun tipo de mensaje para comentarle al usuario si se ha añadido
		// o no algo a su lista

		for (int i = 0; i < interesesPermitidos.length; i++) {
			for (int j = 1; j < interesesPermitidos[i].length; j++) { // Controlamos que no se pueda introducir el
																		// INDICE

				if (interesesPermitidos[i][j].equalsIgnoreCase(interesEscogido)
						&& !interesesUsuario.contains(interesEscogido)) // Ignore case para que no haya problemas
					interesesUsuario.add(interesEscogido);
			}
		}

		return interesesUsuario;
	}
}
