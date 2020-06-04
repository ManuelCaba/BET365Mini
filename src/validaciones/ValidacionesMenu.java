package validaciones;

import java.util.Scanner;

public class ValidacionesMenu {
	/*
	 * Método que muestra el menu de registro y lee y valida la opcion
	 * Signatura: public int mostrarMenuRegistroYLeerYValidarOpcion()
	 * Entradas: No hay
	 * Precondiciones: No hay
	 * Salidas:
	 * 		- int opcion
	 * Postcondiciones: Devolverá la opcion validada según el menu:
	 * 					 - 0 [Salir]
	 * 					 - 1 [Registrar]
	 * 					 - 2 [Entrar como usuario]
	 * 					 - 3 [Entrar como anonimo]
	 */
	public int mostrarMenuRegistroYLeerYValidarOpcion()
	{
		Scanner teclado = new Scanner(System.in);
		
		int opcion;
		
		do
		{
			System.out.println("Salir [0]");
			System.out.println("Registrar [1]");
			System.out.println("Entrar como usuario [2]");
			System.out.println("Entrar como anonimo [3]");
			System.out.print("Elige una opcion: ");
			
			opcion = teclado.nextInt();
		}
		while(opcion < 0 || opcion > 3);
		
		return opcion;
	}
	
	/*
	 * Método que muestra el menu de aplicacion y lee y valida la opcion
	 * Signatura: public int mostrarMenuAplicacionYLeerYValidarOpcion()
	 * Entradas: No hay
	 * Precondiciones: No hay
	 * Salidas:
	 * 		- int opcion
	 * Postcondiciones: Devolverá la opcion validada según el menu:
	 * 					 - 0 [Salir]
	 * 					 - 1 [Menu Configuraciones]
	 * 					 - 2 [Menu Listas]
	 * 					 - 3 [Menu Apuestas]
	 */
	public int mostrarMenuAplicacionYLeerYValidarOpcion()
	{
		Scanner teclado = new Scanner(System.in);
		
		int opcion;
		
		do
		{
			System.out.println("Salir [0]");
			System.out.println("Menu Configuraciones [1]");
			System.out.println("Menu Listas [2]");
			System.out.println("Menu Apuestas [3]");
			System.out.print("Elige una opcion: ");
			
			opcion = teclado.nextInt();
		}
		while(opcion < 0 || opcion > 3);
		
		return opcion;
	}
	
	/*
	 * Método que muestra el menu de configuraciones y lee y valida la opcion
	 * Signatura: public int mostrarMenuConfiguracionesYLeerYValidarOpcion()
	 * Entradas: No hay
	 * Precondiciones: No hay
	 * Salidas:
	 * 		- int opcion
	 * Postcondiciones: Devolverá la opcion validada según el menu:
	 * 					 - 0 [Salir]
	 * 					 - 1 [Configuraciones Usuario]
	 * 					 - 2 [Configuraciones Partido]
	 * 					 - 3 [Registrar Equipo]
	 */
	public int mostrarMenuConfiguracionesYLeerYValidarOpcion()
	{
		Scanner teclado = new Scanner(System.in);
		
		int opcion;
		
		do
		{
			System.out.println("Salir [0]");
			System.out.println("Configuraciones Usuario [1]");
			System.out.println("Configuraciones Partido [2]");
			System.out.println("Registrar Equipo [3]");
			System.out.print("Elige una opcion: ");
			
			opcion = teclado.nextInt();
		}
		while(opcion < 0 || opcion > 3);
		
		return opcion;
	}
	
	/*
	 * Método que muestra el menu de configuraciones de usuario y lee y valida la opcion
	 * Signatura: public int mostrarMenuConfiguracionesUsuarioYLeerYValidarOpcion()
	 * Entradas: No hay
	 * Precondiciones: No hay
	 * Salidas:
	 * 		- int opcion
	 * Postcondiciones: Devolverá la opcion validada según el menu:
	 * 					 - 0 [Salir]
	 * 					 - 1 [Modificar Password]
	 * 					 - 2 [Ingresar Dinero]
	 * 					 - 3 [Retirar Dinero]
	 * 					 - 4 [Solicitar Baja]
	 */
	public int mostrarMenuConfiguracionesUsuarioYLeerYValidarOpcion()
	{
		Scanner teclado = new Scanner(System.in);
		
		int opcion;
		
		do
		{
			System.out.println("Salir [0]");
			System.out.println("Modificar Password [1]");
			System.out.println("Ingresar Dinero [2]");
			System.out.println("Retirar Dinero [3]");
			System.out.println("Solicitar Baja [4]");
			System.out.print("Elige una opcion: ");
			
			opcion = teclado.nextInt();
		}
		while(opcion < 0 || opcion > 4);
		
		return opcion;
	}
	
	/*
	 * Método que muestra el menu de configuraciones de partido y lee y valida la opcion
	 * Signatura: public int mostrarMenuConfiguracionesPartidoYLeerYValidarOpcion()
	 * Entradas: No hay
	 * Precondiciones: No hay
	 * Salidas:
	 * 		- int opcion
	 * Postcondiciones: Devolverá la opcion validada según el menu:
	 * 					 - 0 [Salir]
	 * 					 - 1 [Registrar Partido]
	 * 					 - 2 [Actualizar Cuotas]
	 * 					 - 3 [Finalizar Partido]
	 * 					 - 4 [Aplazar Partido]					
	 */
	public int mostrarMenuConfiguracionesPartidoYLeerYValidarOpcion()
	{
		Scanner teclado = new Scanner(System.in);
		
		int opcion;
		
		do
		{
			System.out.println("Salir [0]");
			System.out.println("Registrar Partido [1]");
			System.out.println("Actualizar Cuotas [2]");
			System.out.println("Finalizar Partido [3]");
			System.out.println("Aplazar Partido [4]");
			System.out.print("Elige una opcion: ");
			
			opcion = teclado.nextInt();
		}
		while(opcion < 0 || opcion > 4);
		
		return opcion;
	}
	
	/*
	 * Método que muestra el menu de actualizar cuotas y lee valida la opcion
	 * Signatura: public int mostrarMenuActualizarCuotasYLeerYValidarOpcion()
	 * Entradas: No hay
	 * Precondiciones: No hay
	 * Salidas:
	 * 		- int opcion
	 * Postcondiciones: Devolverá la opcion validada según el menu:
	 * 					 - 0 [Salir]
	 * 					 - 1 [Actualizar Cuota Local]
	 * 					 - 2 [Actualizar Cuota Empate]
	 * 					 - 3 [Actualizar Cuota Visitante]
	 * 					 - 4 [Actualizar Cuotas]
	 */
	public int mostrarMenuActualizarCuotasYLeerYValidarOpcion()
	{
		Scanner teclado = new Scanner(System.in);
		
		int opcion;
		
		do
		{
			System.out.println("Salir [0]");
			System.out.println("Actualizar Cuota Local [1]");
			System.out.println("Actualizar Cuota Empate [2]");
			System.out.println("Actualizar Cuota Visitante [3]");
			System.out.println("Actualizar Cuotas [4]");
			System.out.print("Elige una opcion: ");
			
			opcion = teclado.nextInt();
		}
		while(opcion < 0 || opcion > 4);
		
		return opcion;
	}
	
	/*
	 * Método que muestra el menu de apuestas y lee valida la opcion
	 * Signatura: public int mostrarMenuApuestasYLeerYValidarOpcion()
	 * Entradas: No hay
	 * Precondiciones: No hay
	 * Salidas:
	 * 		- int opcion
	 * Postcondiciones: Devolverá la opcion validada según el menu:
	 * 					 - 0 [Salir]
	 * 					 - 1 [Realizar apuesta]
	 * 					 - 2 [Comprobar apuesta]
	 */
	public int mostrarMenuApuestasYLeerYValidarOpcion()
	{
		Scanner teclado = new Scanner(System.in);
		
		int opcion;
		
		do
		{
			System.out.println("Salir [0]");
			System.out.println("Realizar Apuesta [1]");
			System.out.println("Comprobar Apuesta [2]");
			System.out.print("Elige una opcion: ");
			
			opcion = teclado.nextInt();
		}
		while(opcion < 0 || opcion > 2);
		
		return opcion;
	}
	
	/*
	 * Método que muestra el menu de listas y lee y valida la opcion
	 * Signatura: public int mostrarMenuListasYLeerYValidarOpcion()
	 * Entradas: No hay
	 * Precondiciones: No hay
	 * Salidas:
	 * 		- int opcion
	 * Postcondiciones: Devolverá la opcion validada según el menu:
	 * 					 - 0 [Salir]
	 * 					 - 1 [Listas Usuarios]
	 * 					 - 2 [Lista Equipos]
	 * 					 - 3 [Listas Clasificaciones]
	 * 					 - 4 [Listas Partidos]
	 * 					 - 5 [Listas Apuestas]
	 */
	public int mostrarMenuListasYLeerYValidarOpcion()
	{
		Scanner teclado = new Scanner(System.in);
		
		int opcion;
		
		do
		{
			System.out.println("Salir [0]");
			System.out.println("Listas Usuarios [1]");
			System.out.println("Lista Equipos [2]");
			System.out.println("Listas Clasificaciones [3]");
			System.out.println("Listas Partidos [4]");
			System.out.println("Listas Apuestas [5]");
			System.out.print("Elige una opcion: ");
			
			opcion = teclado.nextInt();
		}
		while(opcion < 0 || opcion > 5);
		
		return opcion;
	}
	
	/*
	 * Método que muestra el menu de listas usuarios y lee y valida la opcion
	 * Signatura: public int mostrarMenuListasUsuariosYLeerYValidarOpcion()
	 * Entradas: No hay
	 * Precondiciones: No hay
	 * Salidas:
	 * 		- int opcion
	 * Postcondiciones: Devolverá la opcion validada según el menu:
	 * 					 - 0 [Salir]
	 * 					 - 1 [Lista Usuarios]
	 * 					 - 2 [Lista Usuarios Alta]
	 * 					 - 3 [Lista Usuarios Baja]
	 */
	public int mostrarMenuListasUsuariosYLeerYValidarOpcion()
	{
		Scanner teclado = new Scanner(System.in);
		
		int opcion;
		
		do
		{
			System.out.println("Salir [0]");
			System.out.println("Lista Usuarios [1]");
			System.out.println("Lista Usuarios Alta [2]");
			System.out.println("Lista Usuarios Baja [3]");
			System.out.print("Elige una opcion: ");
			
			opcion = teclado.nextInt();
		}
		while(opcion < 0 || opcion > 3);
		
		return opcion;
	}
	
	/*
	 * Método que muestra el menu de listas clasificaciones y lee y valida la opcion
	 * Signatura: public int mostrarMenuListasClasificacionesYLeerYValidarOpcion()
	 * Entradas: No hay
	 * Precondiciones: No hay
	 * Salidas:
	 * 		- int opcion
	 * Postcondiciones: Devolverá la opcion validada según el menu:
	 * 					 - 0 [Salir]
	 * 					 - 1 [Lista Clasificacion]
	 * 					 - 2 [Lista Clasificacion Local]
	 * 					 - 3 [Lista Clasificacion Visitante]
	 */
	public int mostrarMenuListasClasificacionesYLeerYValidarOpcion()
	{
		Scanner teclado = new Scanner(System.in);
		
		int opcion;
		
		do
		{
			System.out.println("Salir [0]");
			System.out.println("Lista Clasificacion [1]");
			System.out.println("Lista Clasificacion Local [2]");
			System.out.println("Lista Clasificacion Visitante [3]");
			System.out.print("Elige una opcion: ");
			
			opcion = teclado.nextInt();
		}
		while(opcion < 0 || opcion > 3);
		
		return opcion;
	}
	
	/*
	 * Método que muestra el menu de listas partidos y lee y valida la opcion
	 * Signatura: public int mostrarMenuListasPartidosYLeerYValidarOpcion()
	 * Entradas: No hay
	 * Precondiciones: No hay
	 * Salidas:
	 * 		- int opcion
	 * Postcondiciones: Devolverá la opcion validada según el menu:
	 * 					 - 0 [Salir]
	 * 					 - 1 [Lista Partidos]
	 * 					 - 2 [Lista Partidos Finalizados]
	 * 					 - 3 [Lista Partidos No Finalizados]
	 * 					 - 4 [Lista Partidos Equipo]
	 */
	public int mostrarMenuListasPartidosYLeerYValidarOpcion()
	{
		Scanner teclado = new Scanner(System.in);
		
		int opcion;
		
		do
		{
			System.out.println("Salir [0]");
			System.out.println("Lista Partidos [1]");
			System.out.println("Lista Partidos Finalizados [2]");
			System.out.println("Lista Partidos No Finalizados [3]");
			System.out.println("Lista Partidos Equipo [4]");
			System.out.print("Elige una opcion: ");
			
			opcion = teclado.nextInt();
		}
		while(opcion < 0 || opcion > 4);
		
		return opcion;
	}
	
	/*
	 * Método que muestra el menu de listas apuestas y lee y valida la opcion
	 * Signatura: public int mostrarMenuListasApuestasYLeerYValidarOpcion()
	 * Entradas: No hay
	 * Precondiciones: No hay
	 * Salidas:
	 * 		- int opcion
	 * Postcondiciones: Devolverá la opcion validada según el menu:
	 * 					 - 0 [Salir]
	 * 					 - 1 [Lista Apuestas]
	 * 					 - 2 [Lista Apuestas Comprobadas]
	 * 					 - 3 [Lista Apuestas No Comprobadas]
	 * 					 - 4 [Lista Apuestas Usuario]
	 */
	public int mostrarMenuListasApuestasYLeerYValidarOpcion()
	{
		Scanner teclado = new Scanner(System.in);
		
		int opcion;
		
		do
		{
			System.out.println("Salir [0]");
			System.out.println("Lista Apuestas [1]");
			System.out.println("Lista Apuestas Comprobadas [2]");
			System.out.println("Lista Apuestas No Comprobadas [3]");
			System.out.println("Lista Apuestas Usuario [4]");
			System.out.print("Elige una opcion: ");
			
			opcion = teclado.nextInt();
		}
		while(opcion < 0 || opcion > 4);
		
		return opcion;
	}

}
