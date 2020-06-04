package tests;

import clasesbasicas.Usuario;
import excepciones.PasswordException;

public class TestUsuario {

	public static void main(String[] args) {
		
		System.out.println("Constructores\n");
		
		Usuario porDefecto = new Usuario();
		System.out.println("Usuario porDefecto = new Usuario();");
		Usuario conParametros = new Usuario("manucaba","asdfgh7");
		System.out.println("Usuario conParametros = new Usuario(\"manucaba\",\"asdfgh7\");");
		Usuario deCopia = new Usuario(conParametros);
		System.out.println("Usuario deCopia = new Usuario(conParametros);");
		
		
		System.out.println("\n");
		
		
		System.out.println("Getters y/o Setters\n");
		
		System.out.println("conParametros.getNick(); --> "+conParametros.getNick());
		
		System.out.println();
		
		System.out.println("porDefecto.getPassword(); --> "+porDefecto.getPassword());
		/*
		System.out.println("porDefecto.setPassword(\"qwert6\"); --> ERROR");
		try 
		{
			porDefecto.setPassword("qwert6");
		} 
		catch (PasswordException e)
		{
			e.printStackTrace();
		}
		System.out.println("porDefecto.getPassword(); --> "+porDefecto.getPassword());
		*/
		System.out.println("porDefecto.setPassword(\"qwerty6\");");
		try 
		{
			porDefecto.setPassword("qwerty6");
		} 
		catch (PasswordException e) 
		{
			e.printStackTrace();
		}
		System.out.println("porDefecto.getPassword(); --> "+porDefecto.getPassword());
		

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
