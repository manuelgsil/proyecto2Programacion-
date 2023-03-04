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
		ArrayList<Usuario> usuarios = new ArrayList<>();

		Usuario prueba1 = new Usuario("Pepe", "Flores", LocalDate.of(1999, 1, 18), "Sevilla", "Espanol", 'H',
				"Malo malote", "GAY");
		Usuario prueba2 = new Usuario("Ricardo", "Flores", LocalDate.of(1999, 1, 18), "Sevilla", "Espanol", 'H',
				"Malo malote", "BI");

		System.out.println(prueba1.calcularCompatiblidad(prueba2));

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
					�Qu� desea hacer?
					 1. - A�adir una nueva persona
					 2. - Buscar emparejamientos
					 3. - Salir del programa
					 """;
			System.out.println(bloqueTexto);

			break;
		case 2:
			bloqueTexto = """
					�Como desea buscar?
					1. - Filtrando
					2. - Personas con mismos datos en comun
					3. - Personas con aficiones opuestas
					4.- Busqueda aleatoria
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

	/**
	 * @author Manuel Metodo que sirve como primer menu principal y donde anidaremos
	 *         los metodos principales
	 */
	private static void menuMarco() {
		Usuario usuarioPrograma;

		// TODO Modificarlo segun lo que necesitemos

		int opcionUsuario;

		do {
			almacenPantallazos(1);
			opcionUsuario = inputInt.nextInt();
			switch (opcionUsuario) {
			case 1:
				usuarioPrograma = crearUsuario();

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
	public static Usuario crearUsuario() {
// En un principio el constructor por parametros esta terminado. Queda hacerle pruebas a muerte.
		almacenPantallazos(3);
		String nombre;
		String apellido;
		String ciudad;
		String idioma;
		String descripcion;
		String orientacionSexual;
		String sexo;
		LocalDate fechaNacimiento;

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
		System.out.print("Introduzca una descripcion (max 250c)");
		descripcion = Util.pedirString(); // AQUI HABRIA QUE CONTROLAR EL LIMITE DE CARACTERES SI QUEREMOS DARLE UN
											// TOQUE GRACIOSO
		System.out.println("indique su sexo (Hombre/Mujer)");
		sexo = delimitadorOpcionesCreacionUsuario(2); // Este es el parametro para el sexo

		System.out.println("Escoja sus preferencias : HETERO | GAY | BI ");
		orientacionSexual = delimitadorOpcionesCreacionUsuario(1);

		Usuario UsuarioParametros = new Usuario(nombre, apellido, fechaNacimiento, ciudad, idioma, sexo.charAt(0),
				descripcion, orientacionSexual);

		System.out.println("\nPor ultimo, de la siguiente lista escoja los intereses que le parezcan. Min 1");
		System.out.println(Usuario.mostrartInteresesDisponibles());

		UsuarioParametros = agregarInteresesUsuario(UsuarioParametros);

		System.out.println(UsuarioParametros);
		return UsuarioParametros;
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
// con este metodo auxiliar vamos a controlar las entradas de datos que necesitan de algo mas de verificacion
		// las que no puedo controlar con el Util.pedirString vaya
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
	 *         donde se le preguta al usuario un minimo un maximo de años y luego
	 *         se guarda el resultado en un ArrayList y despues se llama a otro
	 *         metodo por el cual se muestra por pantalla.
	 * @param usuarios
	 */
	public static void preguntaFiltroEdad(List<Usuario> usuarios) {

		int minimo, maximo;
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

}
