package tests;

import java.util.GregorianCalendar;

import clasesbasicas.Equipo;
import clasesbasicas.Partido;
import excepciones.CuoteException;
import excepciones.NegativeNumberException;

public class TestPartido {

	public static void main(String[] args) {
		double total;
		double proporcionLocal;
		double proporcionEmpate;
		double proporcionVisitante;
		
		System.out.println("Constructores\n");
		
		System.out.println("Partido porDefecto = new Partido();");
		Partido porDefecto = new Partido();
		System.out.println("Partido conParametros = new Partido(new Equipo(\"RMAD\",\"Real Madrid\",\"Madrid\",\"Spain\"), new Equipo(\"BARC\",\"Barcelona\",\"Barcelona\",\"Spain\"), 40, 20, 40, new GregorianCalendar(), porDefecto);");
		Partido conParametros = new Partido(new Equipo("RMAD","Real Madrid","Madrid","Spain"), new Equipo("BARC","Barcelona","Barcelona","Spain"), 40, 20, 40, new GregorianCalendar(), porDefecto);
		System.out.println("Partido conParametros1 = new Partido(new Equipo(),new Equipo(),40,20,40,new GregorianCalendar(),null);");
		Partido conParametros1 = new Partido(new Equipo(),new Equipo(),40,20,40,new GregorianCalendar(),null);
		System.out.println("Partido deCopia = new Partido(conParametros);");
		Partido deCopia = new Partido(conParametros);
		
		
		System.out.println("\n");
		
		
		System.out.println("Getters y/o Setters\n");
		
		//Para testearlo correctamente modificaré el ID manualmente del fichero IDActualizado.txt
		System.out.println("porDefecto.getID(); --> "+porDefecto.getID());
		System.out.println("conParametros.getID(); --> "+conParametros.getID());
		
		System.out.println();
		
		System.out.println("deCopia.getEquipoLocal().toString(); --> "+deCopia.getEquipoLocal().toString());
		
		System.out.println();
		
		System.out.println("porDefecto.getGolesLocal(); --> "+porDefecto.getGolesLocal());
		System.out.println("porDefecto.setGolesLocal(4);");
		
		try 
		{
			porDefecto.setGolesLocal(4);
		} 
		catch (NegativeNumberException error) 
		{
			error.printStackTrace();
		}
		
		/*
		try 
		{
			porDefecto.setGolesLocal(-1);
		} 
		catch (NumberNegativeException error) 
		{
			error.printStackTrace();
		}
		*///Excepcion
		System.out.println("porDefecto.getGolesLocal(); --> "+porDefecto.getGolesLocal());
		
		System.out.println();
		
		System.out.println("conParametros1.getCuotaLocal(); --> "+conParametros1.getCuotaLocal());
		System.out.println("conParametros1.getCuotaEmpate(); --> "+conParametros1.getCuotaEmpate());
		System.out.println("conParametros1.getCuotaVisitante(); --> "+conParametros1.getCuotaVisitante());
		total = conParametros1.getCuotaLocal() + conParametros1.getCuotaEmpate() + conParametros1.getCuotaVisitante();
		System.out.println("conParametros1.getCuotaLocal() + conParametros1.getCuotaEmpate() + conParametros1.getCuotaVisitante(); --> "+total);
		proporcionLocal = conParametros1.getCuotaEmpate() / conParametros1.getCuotaVisitante();
		System.out.println("conParametros1.getCuotaEmpate() / conParametros1.getCuotaVisitante(); --> "+proporcionLocal);
		
		System.out.println();
		
		System.out.println("conParametros1.setCuotaLocal(35);");
		
		try 
		{
			conParametros1.setCuotaLocal(35);
		} 
		catch (CuoteException e) 
		{
			e.printStackTrace();
		}
		
		System.out.println();
		
		System.out.println("conParametros1.getCuotaLocal(); --> "+conParametros1.getCuotaLocal());
		System.out.println("conParametros1.getCuotaEmpate(); --> "+conParametros1.getCuotaEmpate());
		System.out.println("conParametros1.getCuotaVisitante(); --> "+conParametros1.getCuotaVisitante());
		total = conParametros1.getCuotaLocal() + conParametros1.getCuotaEmpate() + conParametros1.getCuotaVisitante();
		System.out.println("conParametros1.getCuotaLocal() + conParametros1.getCuotaEmpate() + conParametros1.getCuotaVisitante(); --> "+total);
		proporcionLocal = conParametros1.getCuotaEmpate() / conParametros1.getCuotaVisitante();
		System.out.println("conParametros1.getCuotaEmpate() / conParametros1.getCuotaVisitante(); --> "+proporcionLocal);
		proporcionEmpate = conParametros1.getCuotaLocal() / conParametros1.getCuotaVisitante();
		System.out.println("conParametros1.getCuotaLocal() / conParametros1.getCuotaVisitante(); --> "+proporcionEmpate);
		
		System.out.println();
		
		System.out.println("conParametros1.setCuotaEmpate(35);");
		
		try 
		{
			conParametros1.setCuotaEmpate(35);
		} 
		catch (CuoteException e) 
		{
			e.printStackTrace();
		}
		
		System.out.println();
		
		System.out.println("conParametros1.getCuotaLocal(); --> "+conParametros1.getCuotaLocal());
		System.out.println("conParametros1.getCuotaEmpate(); --> "+conParametros1.getCuotaEmpate());
		System.out.println("conParametros1.getCuotaVisitante(); --> "+conParametros1.getCuotaVisitante());
		total = conParametros1.getCuotaLocal() + conParametros1.getCuotaEmpate() + conParametros1.getCuotaVisitante();
		System.out.println("conParametros1.getCuotaLocal() + conParametros1.getCuotaEmpate() + conParametros1.getCuotaVisitante(); --> "+total);
		proporcionEmpate = conParametros1.getCuotaLocal() / conParametros1.getCuotaVisitante();
		System.out.println("conParametros1.getCuotaLocal() / conParametros1.getCuotaVisitante(); --> "+proporcionEmpate);
		proporcionVisitante = conParametros1.getCuotaLocal() / conParametros1.getCuotaEmpate();
		System.out.println("conParametros1.getCuotaLocal() / conParametros1.getCuotaEmpate(); --> "+proporcionVisitante);
		
		System.out.println();
		
		System.out.println("conParametros1.setCuotaVisitante(35);");
		
		try 
		{
			conParametros1.setCuotaVisitante(35);
		} 
		catch (CuoteException e) 
		{
			e.printStackTrace();
		}
		
		System.out.println();
		
		System.out.println("conParametros1.getCuotaLocal(); --> "+conParametros1.getCuotaLocal());
		System.out.println("conParametros1.getCuotaEmpate(); --> "+conParametros1.getCuotaEmpate());
		System.out.println("conParametros1.getCuotaVisitante(); --> "+conParametros1.getCuotaVisitante());
		total = conParametros1.getCuotaLocal() + conParametros1.getCuotaEmpate() + conParametros1.getCuotaVisitante();
		System.out.println("conParametros1.getCuotaLocal() + conParametros1.getCuotaEmpate() + conParametros1.getCuotaVisitante(); --> "+total);
		proporcionVisitante = conParametros1.getCuotaLocal() / conParametros1.getCuotaEmpate();
		System.out.println("conParametros1.getCuotaLocal() / conParametros1.getCuotaEmpate(); --> "+proporcionVisitante);
		
		System.out.println();
		
		System.out.println("porDefecto.getFinalized(); --> "+porDefecto.getFinalized());
		System.out.println("porDefecto.setFinalized(true);");
		porDefecto.setFinalized(true);
		System.out.println("porDefecto.getFinalized(); --> "+porDefecto.getFinalized());
		
		
		System.out.println("\n");
		
		System.out.println("Metodos anhadidos\n");
		
		System.out.println("porDefecto.changeCuotas(20, 20, 60); --> "+porDefecto.changeCuotas(20, 20, 60));
		System.out.println("porDefecto.getCuotaLocal(); --> "+porDefecto.getCuotaLocal());
		System.out.println("porDefecto.getCuotaEmpate(); --> "+porDefecto.getCuotaEmpate());
		System.out.println("porDefecto.getCuotaVisitante(); --> "+porDefecto.getCuotaVisitante());
		System.out.println("porDefecto.changeCuotas(10, 30, 10); --> "+porDefecto.changeCuotas(10, 30, 10));
		System.out.println("porDefecto.getCuotaLocal(); --> "+porDefecto.getCuotaLocal());
		System.out.println("porDefecto.getCuotaEmpate(); --> "+porDefecto.getCuotaEmpate());
		System.out.println("porDefecto.getCuotaVisitante(); --> "+porDefecto.getCuotaVisitante());
		
		
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
