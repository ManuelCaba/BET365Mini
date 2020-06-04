package validaciones;

import java.util.Scanner;

public class ValidacionesApuesta {
	/*
	 * Método que lee y valida un importe de una apuesta
	 * Signatura: public double leerYValidarImporteApuesta();
	 * Entradas: No hay
	 * Precondiciones: No hay
	 * Salidas:
	 * 		- double importeApuesta
	 * Postcondiciones: Devolverá asociado al nombre el importe de la apuesta validado
	 */
	public double leerYValidarImporteApuesta()
	{
		Scanner teclado = new Scanner(System.in);
		
		double importeApuesta;
		
		do
		{
			System.out.print("Introduce el importe a apostar: ");
			importeApuesta = teclado.nextDouble();
		}
		while(importeApuesta < 1);
		
		return importeApuesta;
	}
	
	/*
	 * Método que lee y valida una apuesta
	 * Signatura: public char leerYValidarApuesta();
	 * Entradas: No hay
	 * Precondiciones: No hay
	 * Salidas:
	 * 		- char apuesta
	 * Postcondiciones: Devolverá asociado al nombre la apuesta validada
	 */
	public char leerYValidarApuesta()
	{
		Scanner teclado = new Scanner(System.in);
		
		char apuesta;
		
		do
		{
			System.out.print("Introduce la apuesta (1 X 2): ");
			apuesta = teclado.next().charAt(0);
		}
		while((apuesta != '1' && apuesta != '2' && apuesta != 'X'));
		
		return apuesta;
	}
	
	/*
	 * Método que lee y valida un ID de una apuesta
	 * Signatura: public int leerYValidarIDApuesta();
	 * Entradas: No hay
	 * Precondiciones: No hay
	 * Salidas:
	 * 		- int IDApuesta
	 * Postcondiciones: Devolverá asociado al nombre el ID de la apuesta validada
	 */
	public int leerYValidarIDApuesta()
	{
		Scanner teclado = new Scanner(System.in);
		
		int IDApuesta;
		
		do
		{
			System.out.print("Introduce el ID de la apuesta: ");
			IDApuesta = teclado.nextInt();
		}
		while(IDApuesta <= 0);
		
		return IDApuesta;
	}
}
