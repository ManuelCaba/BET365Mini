package validaciones;

import java.util.Scanner;

public class ValidacionesUsuario {
	/*
	 * Método que lee y valida el nick de un usuario
	 * Signatura: public String leerYValidarNickUsuario();
	 * Entradas: No hay
	 * Precondiciones: No hay
	 * Salidas:
	 * 		- String nickUsuario
	 * Postcondiciones: Devolverá asociado al nombre el nick del usuario validado
	 */
	public String leerYValidarNickUsuario()
	{
		Scanner teclado = new Scanner(System.in);
		
		String nickUsuario = null;
		
		do
		{
			System.out.print("Introduce el nick de usuario: ");
			nickUsuario = teclado.nextLine();
		}
		while(nickUsuario.length() < 3 || nickUsuario.length() > 20);
		
		return nickUsuario;
	}
	
	/*
	 * Método que lee y valida la password de un usuario
	 * Signatura: public String leerYValidarPasswordUsuario();
	 * Entradas: No hay
	 * Precondiciones: No hay
	 * Salidas:
	 * 		- String passwordUsuario
	 * Postcondiciones: Devolverá asociado al nombre la password del usuario validado
	 */
	public String leerYValidarPasswordUsuario()
	{
		Scanner teclado = new Scanner(System.in);
		
		String passwordUsuario;
		
		do
		{
			System.out.print("Introduce la password de usuario [Debe ser minimo de 7 digitos y contener al menos un numero]: ");
			passwordUsuario = teclado.nextLine();
		}
		while(passwordUsuario.length() < 7 || passwordUsuario.length() > 32 || (!passwordUsuario.matches(".*[0-9].*") || (!passwordUsuario.matches(".*[a-z].*") && !passwordUsuario.matches(".*[A-Z].*"))));
		
		return passwordUsuario;
	}
	
	/*
	 * Método que lee y valida una cantidiad de dinero
	 * Signatura: public double leerYValidarCantidadDinero();
	 * Entradas: No hay
	 * Precondiciones: No hay
	 * Salidas:
	 * 		- double cantidadDinero
	 * Postcondiciones: Devolverá asociado al nombre la cantidad de dinero validada
	 */
	public double leerYValidarCantidadDinero()
	{
		Scanner teclado = new Scanner(System.in);
		
		double cantidadDinero;
		
		do
		{
			System.out.print("Introduce la cantidad de dinero: ");
			cantidadDinero = teclado.nextDouble();
		}
		while(cantidadDinero <= 0);
		
		return cantidadDinero;
	}
}
