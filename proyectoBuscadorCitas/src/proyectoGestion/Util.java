package proyectoGestion;


import java.util.Random;
import java.util.Scanner;

public class Util {
	private static Scanner inputInt = new Scanner(System.in);

	public static Scanner inputString = new Scanner(System.in);
	private Random numeroAleatorio = new Random();
	
	/**
	 * Genera numeros aleatorios tipo INT entre los limites indicados (INCLUIDOS ESTOS)
	 * @param num1 Principio de rango de numeros
	 * @param num2 Final de rango
	 * @return numero aleatorio entre ese rango
	 */
	public int generarNumerosAleatorios(int num1, int num2){
		
		return numeroAleatorio.nextInt(num1,num2)+1;
		
	}



}
