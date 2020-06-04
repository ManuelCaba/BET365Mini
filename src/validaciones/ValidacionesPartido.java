package validaciones;

import java.util.GregorianCalendar;
import java.util.Scanner;

public class ValidacionesPartido {
	/*
	 * Método que lee y valida una fecha de un partido
	 * Signatura: public GregorianCalendar leerYValidarFechaPartido();
	 * Entradas: No hay
	 * Precondiciones: No hay
	 * Salidas:
	 * 		- GregorianCalendar fechaPartido
	 * Postcondiciones: Devolverá asociado al nombre la fecha del partido validada
	 */
	public GregorianCalendar leerYValidarFechaPartido()
	{
		Scanner teclado = new Scanner(System.in);
		
		int dia;
		int mes;
		int anho;
		
		GregorianCalendar fechaPartido = null;

        boolean valido = false;

        do
        {
            do
            {
                System.out.print("Introduce el dia: ");
                dia = teclado.nextInt();

                System.out.println();

                System.out.print("Introduce el mes: ");
                mes = teclado.nextInt();

                System.out.println();

                do
                {
                    System.out.print("Introduce el anho: ");
                    anho = teclado.nextInt();
                }
                while(anho < 1582);

                if(mes >= 1 && mes <= 12)
                {
                    switch(mes)
                    {
                        case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                        if(dia >= 1 && dia <= 31)
                        {
                            valido = true;
                        }
                        break;
                        case 4: case 6: case 9: case 11:
                        if(dia >= 1 && dia <= 30)
                        {
                            valido = true;
                        }
                        break;
                        case 2:
                            if((anho%4 == 0) && (anho%100 != 0) || (anho%400 == 0))
                            {
                                if( dia >= 1 && dia <= 29 )
                                {
                                    valido = true;
                                }
                            }
                            else if( dia >= 1 && dia <= 28 )
                            {
                                valido = true;
                            }
                            break;
                    }
                }
            }
            while(valido == false);
            
            fechaPartido = new GregorianCalendar(anho, mes - 1, dia);
            
        }while(fechaPartido.compareTo(new GregorianCalendar()) <= 0);

        return fechaPartido;
	}
	
	/*
	 * Método que lee y valida un ID de un partido
	 * Signatura: public int leerYValidarIDPartido();
	 * Entradas: No hay
	 * Precondiciones: No hay
	 * Salidas:
	 * 		- int IDPartido
	 * Postcondiciones: Devolverá asociado al nombre el ID del partido validado
	 */
	public int leerYValidarIDPartido()
	{
		Scanner teclado = new Scanner(System.in);
		
		int IDPartido;
		
		do
		{
			System.out.print("Introduce el ID del partido: ");
			IDPartido = teclado.nextInt();
		}
		while(IDPartido <= 0);
		
		return IDPartido;
	}
	
	/*
	 * Método que lee y valida una cuota de un partido
	 * Signatura: public double leerYValidarCuota();
	 * Entradas: No hay
	 * Precondiciones: No hay
	 * Salidas:
	 * 		- double cuota
	 * Postcondiciones: Devolverá asociado al nombre la cuota del partido validada
	 */
	public double leerYValidarCuota()
	{
		Scanner teclado = new Scanner(System.in);
		
		double cuota;
		
		do
		{
			System.out.print("Introduce la cuota: ");
			cuota = teclado.nextDouble();
		}
		while(cuota < 5 || cuota > 90);
		
		return cuota;
	}
	
	/*
	 * Método que lee y valida los goles de un partido
	 * Signatura: public int leerYValidarGolesPartido();
	 * Entradas: No hay
	 * Precondiciones: No hay
	 * Salidas:
	 * 		- int golesPartido
	 * Postcondiciones: Devolverá asociado al nombre los goles del partido validado
	 */
	public int leerYValidarGolesPartido()
	{
		Scanner teclado = new Scanner(System.in);
		
		int golesPartido;
		
		do
		{
			System.out.print("Introduce los goles: ");
			golesPartido = teclado.nextInt();
		}
		while(golesPartido < 0);
		
		return golesPartido;
	}
}
