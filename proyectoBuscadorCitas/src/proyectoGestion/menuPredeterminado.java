package proyectoGestion;

import java.util.Scanner;

import proyectoModelos.Usuario;

public class menuPredeterminado {

	private static Scanner inputInt = new Scanner(System.in);
	public static Scanner inputString = new Scanner(System.in);

	public static void main(String[] args) {
		menuMarco();
	}

	/**
	 * @author Manuel Pantallazo incial del menu. Aqui almacenaremos la informacion
	 *         que queramos mostrar por pantalla y la seleccionaremos con un numero.
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
	 * @author Manuel Metodo que almacena un SWITCH. Hay que modificarlo segun las
	 *         preferencias del usuario. Por defecto trae 3 opciones.
	 * 
	 * @param opcionUsuario
	 * @return
	 * 
	 */
	private static int pantallaSwitchUsuario(int opcionUsuario) {
		// TODO Revisar si existe alguna manera de generar CASES DINAMICOS
		// Es decir, generar un numero de CASES en funcion del problema para así no
		// crear varios metodos
		// SWITCH con diferentes numeros de CASES
		try {
			switch (opcionUsuario) { // En cada case esta indicado el contenido del metodo pantallazoMenu
			case 1:
				crearUsuario();
				break;

			case 2:

				break;
			case 3:

				break;
			default:
				System.out.println("Introduzca una opcion valida");
			}
		} catch (Exception e) {
			System.out.println(" La estas liando");
		}
		return opcionUsuario;

	}

	private static void menuMarco() {
		// TODO Modificarlo segun lo que necesitemos
		int opcionUsuario;

		do {
			almacenPantallazos(1);
			opcionUsuario = inputInt.nextInt();
			opcionUsuario = pantallaSwitchUsuario(opcionUsuario);
		} while (opcionUsuario != 3);

	}

	public static void crearUsuario() {
		//TODO buscar una manera eficiente de crear un formulario para crear un objeto Usuario.
		// Usuario prueba = new Usuario(null, null, null, null, null, null, false, false, null, null, null, null);

	}
}
