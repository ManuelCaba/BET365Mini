package tests;

import java.util.GregorianCalendar;

import clasesbasicas.Apuesta;
import clasesbasicas.Equipo;
import clasesbasicas.Partido;
import clasesbasicas.Usuario;
import clasesbasicas.UsuarioApostador;

public class TestApuesta {

	public static void main(String[] args) {
		
		System.out.println("Constructores\n");
		
		Apuesta porDefecto = new Apuesta();
		System.out.println("Apuesta porDefecto = new Apuesta();");
		Apuesta conParametros = new Apuesta(new UsuarioApostador("manucaba","asdfgh7"),new Partido(new Equipo("RMAD","Real Madrid","Madrid","Spain"),new Equipo("BARC","Barcelona","Barcelona","Spain"), 40, 20, 40, new GregorianCalendar(), null),-5,'Z');
		System.out.println("Apuesta conParametros = new Apuesta(new Usuario(\"manucaba\",\"asdfgh7\"),new Partido(new Equipo(\"RMAD\",\"Real Madrid\",\"Madrid\",\"Spain\"),new Equipo(\"BARC\",\"Barcelona\",\"Barcelona\",\"Spain\"), 40, 20, 40, new GregorianCalendar(), null),-5,'Z');");
		Apuesta deCopia = new Apuesta(conParametros);
		System.out.println("Apuesta deCopia = new Apuesta(conParametros);");
		
		 
		System.out.println("\n");
		
		
		System.out.println("Getters y/o Setters\n");
		
		//Para testearlo correctamente modificaré el ID manualmente del fichero IDActualizado.txt
		System.out.println("porDefecto.getID(); --> "+porDefecto.getID());
		System.out.println("conParametros.getID(); --> "+conParametros.getID());
		
		System.out.println();
		
		System.out.println("porDefecto.getUsuario(); --> "+porDefecto.getUsuario());
		System.out.println("porDefecto.getNombreUsuario(); --> "+porDefecto.getNickUsuario());
		
		System.out.println();
		
		System.out.println("conParametros.getPartido(); --> "+conParametros.getPartido());
		System.out.println("conParametros.getIDPartido(); --> "+conParametros.getIDPartido());
		System.out.println("conParametros.getIDEquipoLocal(); --> "+conParametros.getIDEquipoLocal());
		System.out.println("conParametros.getIDEquipoVisisitante(); --> "+conParametros.getIDEquipoVisisitante());
		
		System.out.println();
		
		System.out.println("conParametros.getCantidadApostada(); --> "+conParametros.getCantidadApostada());
		
		System.out.println();
		
		System.out.println("conParametros.getApuesta(); --> "+conParametros.getApuesta());
		
		System.out.println();
		
		System.out.println("porDefecto.getComprobada(); --> "+porDefecto.getComprobada());
		porDefecto.setComprobada(true);
		System.out.println("porDefecto.setComprobada(true);");
		System.out.println("porDefecto.getComprobada(); --> "+porDefecto.getComprobada());
		
	
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
