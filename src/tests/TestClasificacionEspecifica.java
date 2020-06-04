package tests;

import clasesbasicas.ClasificacionEspecifica;
import clasesbasicas.Equipo;
import excepciones.NegativeNumberException;

public class TestClasificacionEspecifica {

	public static void main(String[] args) {
		
		System.out.println("Constructores\n");
		
		ClasificacionEspecifica porDefecto = new ClasificacionEspecifica();
		System.out.println("ClasificacionEspecifica porDefecto = new ClasificacionEspecifica();");
		ClasificacionEspecifica conParametros = new ClasificacionEspecifica(new Equipo("RMAD","Real Madrid","Madrid","España"));
		System.out.println("ClasificacionEspecifica conParametros = new ClasificacionEspecifica(new Equipo(\"RMAD\",\"Real Madrid\",\"Madrid\",\"España\"));");
		ClasificacionEspecifica deCopia = new ClasificacionEspecifica(conParametros);
		System.out.println("ClasificacionEspecifica deCopia = new ClasificacionEspecifica(conParametros);");
		
		
		System.out.println("\n");
		
		
		System.out.println("Getters y/o Setters\n");
		
		System.out.println("porDefecto.getPosicion --> "+porDefecto.getPosicion());
		
		System.out.println("porDefecto.setPosicion(-5); --> ERROR");
		try 
		{
			porDefecto.setPosicion(-5);
		} 
		catch (NegativeNumberException e) 
		{
			e.printStackTrace();
		}
		System.out.println("porDefecto.getPosicion --> "+porDefecto.getPosicion());
		
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
		
		System.out.println("porDefecto.getPartidosGanados(); --> "+porDefecto.getPartidosGanados());
		System.out.println("porDefecto.setPartidosGanados(4);");
		try 
		{
			porDefecto.setPartidosGanados(4);
		} 
		catch (NegativeNumberException e) 
		{
			e.printStackTrace();
		}
		System.out.println("porDefecto.getPartidosGanados(); --> "+porDefecto.getPartidosGanados());
		
		System.out.println();
		
		System.out.println("porDefecto.getPartidosPerdidos(); --> "+porDefecto.getPartidosPerdidos());
		System.out.println("porDefecto.setPartidosPerdidos(4);");
		try 
		{
			porDefecto.setPartidosPerdidos(4);
		} 
		catch (NegativeNumberException e) 
		{
			e.printStackTrace();
		}
		System.out.println("porDefecto.getPartidosPerdidos(); --> "+porDefecto.getPartidosPerdidos());
		
		System.out.println();
		
		System.out.println("porDefecto.getPartidosEmpatados(); --> "+porDefecto.getPartidosEmpatados());
		System.out.println("porDefecto.setPartidosEmpatados(4);");
		try 
		{
			porDefecto.setPartidosEmpatados(4);
		} 
		catch (NegativeNumberException e) 
		{
			e.printStackTrace();
		}
		System.out.println("porDefecto.getPartidosEmpatados(); --> "+porDefecto.getPartidosEmpatados());
		
		System.out.println();
		
		System.out.println("porDefecto.getGolesAFavor(); --> "+porDefecto.getGolesAFavor());
		System.out.println("porDefecto.setGolesAFavor(10);");
		try 
		{
			porDefecto.setGolesAFavor(10);
		} 
		catch (NegativeNumberException e) 
		{
			e.printStackTrace();
		}
		System.out.println("porDefecto.getGolesAFavor(); --> "+porDefecto.getGolesAFavor());
		
		System.out.println();
		
		System.out.println("porDefecto.getGolesEnContra(); --> "+porDefecto.getGolesEnContra());
		System.out.println("porDefecto.setGolesEnContra(4);");
		try 
		{
			porDefecto.setGolesEnContra(4);
		} 
		catch (NegativeNumberException e) 
		{
			e.printStackTrace();
		}
		System.out.println("porDefecto.getGolesEnContra(); --> "+porDefecto.getGolesEnContra());
		
		System.out.println();
		
		System.out.println("porDefecto.getPartidosJugados(); --> "+porDefecto.getPartidosJugados());
		
		System.out.println();
		
		System.out.println("porDefecto.getDiferenciaGoles(); --> "+porDefecto.getDiferenciaGoles());
		
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
