package proyectoModelos;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Random;
import java.util.Scanner;

public class Util {
	private static Scanner inputInt = new Scanner(System.in);

	public static Scanner inputString = new Scanner(System.in);
	public static Random numeroAleatorio= new Random();

	/**
	 * Genera numeros aleatorios tipo INT entre los limites indicados (INCLUIDOS
	 * ESTOS)
	 * 
	 * @param num1 Principio de rango de numeros
	 * @param num2 Final de rango
	 * @return numero aleatorio entre ese rango
	 */
		public static int generarNumerosAleatorios(int num1, int num2) {
		    Random numeroAleatorio = new Random();
		    return numeroAleatorio.nextInt(num1, num2) + 1;
		}
		
		
		public static int generarNumeroAleatorio() {
		    Random numeroAleatorio = new Random();
		    return numeroAleatorio.nextInt();
		}

	

	/**
	 * @author Manuel Este metodo devuelve un String con la informacion del tiempo
	 *         transcurrido entre dos fechas (segundos,minutos,horas y dias).
	 * 
	 * @param fecha1
	 * @param fecha2
	 * @return Devuelve un string con la informacion recabada
	 */
	public static String calcularDiferencia(LocalDateTime fecha1, LocalDateTime fecha2) {
		// Calcular la diferencia de tiempo entre las dos fechas
		Duration duracion = Duration.between(fecha1, fecha2);

		// Construir la cadena de resultado
		StringBuilder resultado = new StringBuilder();
		resultado.append("La diferencia de tiempo entre ").append(fecha1).append(" y ").append(fecha2).append(" es:\n")
				.append(duracion.getSeconds()).append(" segundos\n").append(duracion.toMinutes()).append(" minutos\n")
				.append(duracion.toHours()).append(" horas\n").append(duracion.toDays()).append(" d�as");

		// Devolver la cadena de resultado
		return resultado.toString();
	}

	/**
	 * @author Manuel Este metodo vuelve a darnos la informacion del tiempo
	 *         transcurrido entre dos fechas. La informacion que devuelve es un tipo
	 *         de dato INT y cuenta los dias de diferencia.
	 * 
	 * @param fecha1
	 * @param fecha2
	 * @return Un dato tipo int que sera la diferencia en dias entre dos fechas.
	 */
	public static int calcularDiasDeDiferencia(LocalDateTime fecha1, LocalDateTime fecha2) {
		LocalDate localDate1 = fecha1.toLocalDate();
		LocalDate localDate2 = fecha2.toLocalDate();
		return Period.between(localDate1, localDate2).getDays();
	}

	/**
	 * @author Manuel Metodo que nos sirve para pedirle al usuario que inserte una
	 *         fecha (LocalDate). Incluye la clase #DateTimeFormatter para que el
	 *         string que sirve como input sea formateado a LocalDate.
	 * 
	 *         Este metodo tambien incluye un blqoue try / catch para las
	 *         excepciones
	 * 
	 * @return devuelve la fecha en LocalDate
	 */
	public static LocalDate solicitarFecha() {
		System.out.println("Ingrese la fecha en formato yyyy-MM-dd: ");
		Scanner sc = new Scanner(System.in);
		String fecha = sc.nextLine();

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		try {
			LocalDate date = LocalDate.parse(fecha, formatter);
			return date;
		} catch (Exception e) {
			System.out.println("La fecha ingresada no es v�lida. Intente nuevamente.");
			return solicitarFecha();
		}

	}

	/**
	 * @author Manuel
	 * @return devuelve un string solo de textos (no admite numeros en el string ni
	 *         tampoco admitira si este solo tuviera eespacios en blanco)
	 */
	public static String pedirString() {
		String texto = "";
		boolean bandera = true;
		while (bandera) {
			try {
				texto = inputString.nextLine();
				if (texto.matches("^\\s*$") || !texto.matches("^[a-zA-Z\\s]+$")) {
					System.out.println("Compruebe que haya introducido informacion o que no contenga numeros");
				} else {
					bandera = false;
				}
			} catch (Exception e) {
				System.out.println("Se ha producido la siguiente excepcion en el codigo: " + e.getMessage());
			}

		}
		return texto;
	}
	public static int pedirNumero() {
		
	      
	        int numero = 0;
	        boolean entradaValida = false;
	        
	        while (!entradaValida) {
	           
	            try {
	                numero = inputInt.nextInt();
	                entradaValida = true;
	            } catch (Exception e) {
	                System.out.println("Entrada inv�lida. Intente nuevamente.");
	                inputInt.nextLine(); // limpiar el buffer de entrada
	            }
	        }
	        
	        return numero;		
	
		
	}

}
