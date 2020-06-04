package tests;

import clasesbasicas.ClasificacionGeneral;
import clasesbasicas.Equipo;
import excepciones.NegativeNumberException;

public class TestClasificacionGeneral {
	
	public static void main(String[] args) {
		
		System.out.println("Constructores\n");
		
		ClasificacionGeneral porDefecto = new ClasificacionGeneral();
		System.out.println("ClasificacionGeneral porDefecto = new ClasificacionGeneral();");
		ClasificacionGeneral conParametros = new ClasificacionGeneral(new Equipo("RMAD","Real Madrid","Madrid","España"));
		System.out.println("ClasificacionGeneral conParametros = new ClasificacionGeneral(new Equipo(\"RMAD\",\"Real Madrid\",\"Madrid\",\"España\"));");
		ClasificacionGeneral deCopia = new ClasificacionGeneral(conParametros);
		System.out.println("ClasificacionGeneral deCopia = new ClasificacionGeneral(conParametros);");
		
		
		System.out.println("\n");
		
		
		System.out.println("Getters y/o Setters\n");
		
		System.out.println("porDefecto.getPosicion --> "+porDefecto.getPosicion());
		/*
		System.out.println("porDefecto.setPosicion(-5); --> ERROR");
		try 
		{
			porDefecto.setPosicion(-5);
		} 
		catch (NegativeNumberException e) 
		{
			e.printStackTrace();
		}
		*/
		System.out.println("porDefecto.setPosicion(10);");
		try 
		{
			porDefecto.setPosicion(10);
		} 
		catch (NegativeNumberException e) 
		{
			e.printStackTrace();
		}
		System.out.println("porDefecto.getPosicion --> "+porDefecto.getPosicion());
		
		System.out.println();
		
		System.out.println("conParametros.getEquipo(); --> "+conParametros.getEquipo());
		System.out.println("conParametros.getIDEquipo(); --> "+conParametros.getIDEquipo());
		
		System.out.println();
		
		System.out.println("deCopia.getPartidosGanados(); --> "+deCopia.getPartidosGanados());
		
		System.out.println();
		
		System.out.println("porDefecto.getPartidosPerdidos(); --> "+porDefecto.getPartidosPerdidos());
		
		System.out.println();
		
		System.out.println("conParametros.getPartidosEmpatados(); --> "+conParametros.getPartidosEmpatados());
		
		System.out.println();
		
		System.out.println("deCopia.getGolesAFavor(); --> "+deCopia.getGolesAFavor());
		
		System.out.println();
		
		System.out.println("porDefecto.getGolesEnContra(); --> "+porDefecto.getGolesEnContra());
		
		System.out.println();
		
		System.out.println("conParametros.getPartidosJugados(); --> "+conParametros.getPartidosJugados());
		
		System.out.println();
		
		System.out.println("deCopia.getDiferenciaGoles(); --> "+deCopia.getDiferenciaGoles());
		
		System.out.println();
		
		System.out.println("porDefecto.getPuntos(); --> "+porDefecto.getPuntos());
		
		
		System.out.println("\n");
		
		
		System.out.println("Metodos anhadidos\n");
		
		System.out.println("porDefecto.mostrarClasificacion(); --> "+porDefecto.mostrarClasificacion());
		System.out.println("conParametros.mostrarClasificacion(); --> "+conParametros.mostrarClasificacion());
		
		
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
