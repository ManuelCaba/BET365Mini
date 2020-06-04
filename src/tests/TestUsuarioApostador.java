package tests;

import java.util.GregorianCalendar;

import clasesbasicas.Usuario;
import clasesbasicas.UsuarioApostador;
import excepciones.EndingDateException;

public class TestUsuarioApostador {

	public static void main(String[] args) {
		
		System.out.println("Constructores\n");
		
		UsuarioApostador porDefecto = new UsuarioApostador();
		System.out.println("UsuarioApostador porDefecto = new UsuarioApostador();");
		UsuarioApostador conParametros = new UsuarioApostador("manucaba","asdfgh7");
		System.out.println("UsuarioApostador conParametros = new UsuarioApostador(\"manucaba\",\"asdfgh7\");");
		UsuarioApostador deCopia = new UsuarioApostador(conParametros);
		System.out.println("UsuarioApostador deCopia = new UsuarioApostador(conParametros);");
		
		
		System.out.println("\n");
		
		
		System.out.println("Getters y/o Setters y Metodos anhadidos\n");
		
		System.out.println("porDefecto.getBalance(); --> "+porDefecto.getBalance());
		System.out.println("porDefecto.changeBalance(100);");
		porDefecto.changeBalance(100);
		System.out.println("porDefecto.getBalance(); --> "+porDefecto.getBalance());
		System.out.println("porDefecto.changeBalance(-50);");
		porDefecto.changeBalance(-50);
		System.out.println("porDefecto.getBalance(); --> "+porDefecto.getBalance());
		
		System.out.println();
		
		System.out.println("deCopia.getStartingDateString(); --> "+deCopia.getStartingDateString());
		
		System.out.println();
		
		System.out.println("porDefecto.getEndingDateString(); --> "+porDefecto.getEndingDateString());
		System.out.println("porDefecto.setEndingDate(new GregorianCalendar(2021,10,15));");
		try 
		{
			porDefecto.setEndingDate(new GregorianCalendar(2021,10,15));
		} 
		catch (EndingDateException e) 
		{
			e.printStackTrace();
		}
		System.out.println("porDefecto.getEndingDateString(); --> "+porDefecto.getEndingDateString());

		System.out.println("\n");
		
		System.out.println("Metodos sobreescritos y compareTo\n");
		
		System.out.println("porDefecto.hashCode(); --> "+porDefecto.hashCode());
		System.out.println("conParametros.hashCode(); --> "+conParametros.hashCode());
		System.out.println("deCopia.hashCode(); --> "+deCopia.hashCode());
		
		System.out.println();
		
		System.out.println("conParametros.compareTo(porDefecto); --> "+conParametros.compareTo(porDefecto));
		System.out.println("conParametros.compareTo(deCopia); --> "+conParametros.compareTo(deCopia));
		
		System.out.println();
		
		System.out.println("conParametros.equals(porDefecto) --> "+conParametros.equals(porDefecto));
		System.out.println("conParametros.equals(deCopia); --> "+conParametros.equals(deCopia));
		
		System.out.println();
		
		System.out.println("porDefecto.clone().toString(); --> "+porDefecto.clone().toString());
		System.out.println("deCopia.clone().toString(); --> "+deCopia.clone().toString());
	}

}
