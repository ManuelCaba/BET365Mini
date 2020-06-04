package tests;

import clasesbasicas.Equipo;

public class TestEquipo {

	public static void main(String[] args) {
		
		System.out.println("Constructores\n");
		
		System.out.println("Equipo porDefecto = new Equipo();");
		Equipo porDefecto = new Equipo();
		System.out.println("Equipo conParametros = new Equipo(\"RMAD\",\"Real Madrid\",\"Madrid\",\"Spain\");");
		Equipo conParametros = new Equipo("RMAD","Real Madrid","Madrid","Spain");
		System.out.println("Equipo conParametrosError = new Equipo(\"RMADR\",\"Real Madrid\",\"Madrid\",\"Spain\");");
		Equipo conParametrosError = new Equipo("RMADR","Real Madrid","Madrid","Spain");
		System.out.println("Equipo deCopia = new Equipo(conParametros);");
		Equipo deCopia = new Equipo(conParametros);
		
		
		System.out.println("\n");
		
		
		System.out.println("Getters y/o Setters\n");
		
		System.out.println("conParametrosError.getID(); --> "+conParametrosError.getID());
		
		System.out.println();
		
		System.out.println("porDefecto.getName(); --> "+porDefecto.getName());
		
		System.out.println();
		
		System.out.println("conParametros.getCity(); --> "+conParametros.getCity());
		
		System.out.println();
		
		System.out.println("deCopia.getCountry(); --> "+deCopia.getCountry());
		
		
		System.out.println("\n");
		
		
		System.out.println("Metodos anhadidos\n");
		
		System.out.println("porDefecto.mostrarEquipo(); --> "+porDefecto.mostrarEquipo());
		System.out.println("conParametros.mostrarEquipo(); --> "+conParametros.mostrarEquipo());
		
		
		System.out.println("\n");
		
		
		System.out.println("Metodos Sobreescritos y compareTo\n");
		
		System.out.println("porDefecto.hashCode(); --> "+porDefecto.hashCode());
		System.out.println("conParametros.compareTo(conParametrosError); --> "+conParametros.compareTo(conParametrosError));
		System.out.println("conParametros.equals(conParametrosError); --> "+conParametros.equals(conParametrosError));
		System.out.println("deCopia.clone().toString(); --> "+deCopia.clone().toString());

	}

}
