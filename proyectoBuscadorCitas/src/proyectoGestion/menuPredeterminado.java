package proyectoGestion;

import java.util.Scanner;


public class menuPredeterminado {

	private static Scanner inputInt = new Scanner(System.in);
	public static Scanner inputString = new Scanner(System.in);

	public static void main(String[] args) {

	

	}

	/**
	 * @author Manuel Pantallazo incial del menu. Aqui almacenaremos la informacion
	 *         que queramos mostrar por pantalla
	 * 
	 * 
	 */
	private static void pantallazoMenu() {
		// TODO implementar SYSOS
	}

	/**
	 * @author Manuel Metodo que almacena un SWITCH. Hay que modificarlo segun las
	 *         preferencias del usuario. Por defecto trae 3 opciones.
	 * 
	 * @param opcionUsuario
	 * @return
	 * 
	 */
	private static int pantallaSwitch(int opcionUsuario) {
		// TODO Revisar si existe alguna manera de generar CASES DINAMICOS
		// Es decir, generar un numero de CASES en funcion del problema para así no
		// crear varios metodos
		// SWITCH con diferentes numeros de CASES
		try {
			switch (opcionUsuario) { // En cada case esta indicado el contenido del metodo pantallazoMenu
			case 1:

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
			pantallazoMenu();
			opcionUsuario = inputInt.nextInt();
			opcionUsuario = pantallaSwitch(opcionUsuario);
		} while (opcionUsuario != 3);

	}
}
