package validaciones;

import java.util.Scanner;

public class ValidacionesEquipo {
	/*
	 * M�todo que lee y valida el ID de un equipo
	 * Signatura: public String leerYValidarIDEquipo();
	 * Entradas: No hay
	 * Precondiciones: No hay
	 * Salidas:
	 * 		- String IDEquipo
	 * Postcondiciones: Devolver� asociado al nombre el ID del equipo validado
	 */
	public String leerYValidarIDEquipo()
	{
		Scanner teclado = new Scanner(System.in);
		
		String IDEquipo = null;
		
		do
		{
			System.out.print("Introduce el ID del equipo: ");
			IDEquipo = teclado.nextLine().toUpperCase();
		}
		while(IDEquipo.length() != 4);
		
		return IDEquipo;
	}
	
	/*
	 * M�todo que lee y valida el nombre de un equipo
	 * Signatura: public String leerYValidarNombreEquipo();
	 * Entradas: No hay
	 * Precondiciones: No hay
	 * Salidas:
	 * 		- String nombreEquipo
	 * Postcondiciones: Devolver� asociado al nombre el nombre del equipo validado
	 */
	public String leerYValidarNombreEquipo()
	{
		Scanner teclado = new Scanner(System.in);
		
		String nombreEquipo = null;
		
		do
		{
			System.out.print("Introduce el nombre del equipo: ");
			nombreEquipo = teclado.nextLine();
		}
		while(nombreEquipo.length() > 30);
		
		return nombreEquipo;
	}
	
	/*
	 * M�todo que lee y valida la ciudad de un equipo
	 * Signatura: public String leerYValidarCiudadEquipo();
	 * Entradas: No hay
	 * Precondiciones: No hay
	 * Salidas:
	 * 		- String ciudadEquipo
	 * Postcondiciones: Devolver� asociado al nombre la ciudad del equipo validado
	 */
	public String leerYValidarCiudadEquipo()
	{
		Scanner teclado = new Scanner(System.in);
		
		String ciudadEquipo = null;
		
		do
		{
			System.out.print("Introduce la ciudad del equipo: ");
			ciudadEquipo = teclado.nextLine();
		}
		while(ciudadEquipo.length() > 25);
		
		return ciudadEquipo;
	}
	
	/*
	 * M�todo que lee y valida el pais de un equipo
	 * Signatura: public String leerYValidarPaisEquipo();
	 * Entradas: No hay
	 * Precondiciones: No hay
	 * Salidas:
	 * 		- String paisEquipo
	 * Postcondiciones: Devolver� asociado al nombre el pais del equipo validado
	 */
	public String leerYValidarPaisEquipo()
	{
		Scanner teclado = new Scanner(System.in);
		
		String paisEquipo = null;
		
		do
		{
			System.out.print("Introduce el pais del equipo: ");
			paisEquipo = teclado.nextLine();
		}
		while(paisEquipo.length() > 20);
		
		return paisEquipo;
	}
}
