package clasesbasicas;

import java.util.Calendar;
import java.util.GregorianCalendar;

import excepciones.CuoteException;
import excepciones.NegativeNumberException;

/*
 * Clase Partido
 * 
 * Propiedades Básicas:
 * 
 * 		- ID --> int, Consultable
 * 		- equipoLocal --> Equipo, Consultable
 * 		- equipoVisitante --> Equipo, Consultable
 * 		- golesLocal --> int, Consultable y Modificable
 * 		- golesVisitante --> int, Consultable y Modificable
 * 		- finalized --> boolean, Consultable y Modificable
 * 		- date --> GregorianCalendar, Consultable
 * 		- partidoSustituido --> Partido, Consultable
 * 
 * Propiedades Compartidas: No hay
 * 
 * Propiedades Derivadas: No hay
 * 
 * Propiedades Dependientes: (Todas dependen unas de otras)
 * 
 * 		- cuotaLocal --> double, Consultable y Modificable
 * 		- cuotaEmpate --> double, Consultable y Modificable
 * 		- cuotaVisitante --> double, Consultable y Modificable
 * 
 * Getters y/o Setters
 * 
 * 		public int getID();
 * 		
 * 		public Equipo getEquipoLocal();
 * 		public String getIDEquipoLocal();
 * 		public String getNameEquipoLocal();
 * 		public String getCityEquipoLocal();
 * 		public String getCountryEquipoLocal();
 * 
 * 		public Equipo getEquipoVisitante();
 * 		public String getIDEquipoVisitante();
 * 		public String getNameEquipoVisitante();
 * 		public String getCityEquipoVisitante();
 * 		public String getCountryEquipoVisitante();
 * 
 * 		public int getGolesLocal();
 * 		public void setGolesLocal(int golesLocal);
 * 	
 * 		public int getGolesVisitante();
 * 		public void setGolesVisitante(int golesVisitante);
 * 
 * 		public double getCuotaLocal();
 * 		public void setCuotaLocal(double cuotaLocal);
 * 
 * 		public double getCuotaEmpate();
 * 		public void setCuotaEmpate(double cuotaEmpate);
 * 	
 * 		public double getCuotaVisitante();
 * 		public void setCuotaVisitante(double cuotaVisitante);
 * 
 * 		public boolean getFinalized();
 * 		public void setFinalized(boolean finalized);
 * 
 * 		public GregorianCalendar getDate();
 * 		public int getDayDate();
 * 		public int getMonthDate();
 * 		public int getYearDate();
 * 		public String getDateString();
 * 
 * 		public Partido getPartidoAplazado();
 * 		public int getIDPartidoAplazado();
 * 
 * Métodos Añadidos:
 * 
 * 		- public void changeCuotas(double cuotaLocal, double cuotaEmpate, double cuotaVisitante);
 * 
 * Restricciones:
 
 * 		- Los goles local y visitante se inicializarán a 0 y no permitirá valores negativos
 * 		- Las cuotas local, empate y visitante deben sumar entre ellas un total de 100 y deben tener un valor entre 5 y 90
 * 		- El atributo finalized tendrá valor false si el partido no ha finalizado y true en caso contrario
 * 		- El partido sustituido se usará para un aplazamiento de partido
 *		
 */
public class Partido implements Cloneable, Comparable<Partido>{
	
	//Declaración de las propiedades de la clase
	private int ID;
	private Equipo equipoLocal;
	private Equipo equipoVisitante;
	private int golesLocal;
	private int golesVisitante;
	private double cuotaLocal;
	private double cuotaEmpate;
	private double cuotaVisitante;
	private boolean finalized;
	private GregorianCalendar date;
	private Partido partidoSustituido;
	
	//Constructores
	
	public Partido()
	{
		this.ID = 0;
		this.equipoLocal = new Equipo();
		this.equipoVisitante = new Equipo();
		this.golesLocal = 0;
		this.golesVisitante = 0;
		this.cuotaLocal = 100/3;
		this.cuotaEmpate = 100/3;
		this.cuotaVisitante = 100/3;
		this.finalized = false;
		this.date = new GregorianCalendar();
		this.partidoSustituido = null;
	}
	
	public Partido(Equipo equipoLocal, Equipo equipoVisitante, double cuotaLocal, double cuotaEmpate, double cuotaVisitante, GregorianCalendar date, Partido partidoSustituido)
	{
		this.ID = 0;
		this.equipoLocal = equipoLocal;
		this.equipoVisitante = equipoVisitante;
		this.golesLocal = 0;
		this.golesVisitante = 0;
		if((cuotaLocal + cuotaEmpate + cuotaVisitante != 100) ||
		   (cuotaLocal < 5 || cuotaLocal > 90) ||
		   (cuotaEmpate < 5 || cuotaEmpate > 90) ||
		   (cuotaVisitante < 5 || cuotaVisitante > 90))
		{
			this.cuotaLocal = 50;
			this.cuotaEmpate = 20;
			this.cuotaVisitante = 30;
		}
		else
		{
			this.cuotaLocal = cuotaLocal;
			this.cuotaEmpate = cuotaEmpate;
			this.cuotaVisitante = cuotaVisitante;
		}
		this.finalized = false;
		this.date = date;
		this.partidoSustituido = partidoSustituido;
	}
	
	public Partido(Partido partido)
	{
		this.ID = partido.ID;
		this.equipoLocal = partido.equipoLocal;
		this.equipoVisitante = partido.equipoVisitante;
		this.golesLocal = partido.golesLocal;
		this.golesVisitante = partido.golesVisitante;
		this.finalized = partido.finalized;
		this.date = partido.date;
		this.partidoSustituido = partido.partidoSustituido;
	}
	
	
	public Partido(int IDPartido, Equipo equipoLocal, Equipo equipoVisitante, int golesLocal, int golesVisitante, double cuotaLocal,
			double cuotaEmpate, double cuotaVisitante, boolean finalized, GregorianCalendar date, Partido partidoSustituido) 
	{
		this.ID = IDPartido;
		this.equipoLocal = equipoLocal;
		this.equipoVisitante = equipoVisitante;
		this.golesLocal = golesLocal;
		this.golesVisitante = golesVisitante;
		this.cuotaLocal = cuotaLocal;
		this.cuotaEmpate = cuotaEmpate;
		this.cuotaVisitante = cuotaVisitante;
		this.finalized = finalized;
		this.date = date;
		this.partidoSustituido = partidoSustituido;
	}
	//Getters y/o Setters

	public int getID()
	{
		return this.ID;
	}
  		
  	public Equipo getEquipoLocal()
  	{
  		return this.equipoLocal;
  	}
  	
  	public String getIDEquipoLocal()
  	{
  		return this.equipoLocal.getID();
  	}
  	
  	public String getNameEquipoLocal()
  	{
  		return this.equipoLocal.getName();
  	}
  	
  	public String getCityEquipoLocal()
  	{
  		return this.equipoLocal.getCity();
  	}
  	
  	public String getCountryEquipoLocal()
  	{
  		return this.equipoLocal.getCountry();
  	}
  	
  	public Equipo getEquipoVisitante()
  	{
  		return this.equipoVisitante;
  	}
  	
  	public String getIDEquipoVisitante()
  	{
  		return this.equipoVisitante.getID();
  	}
  	
  	public String getNameEquipoVisitante()
  	{
  		return this.equipoVisitante.getName();
  	}
  	
  	public String getCityEquipoVisitante()
  	{
  		return this.equipoVisitante.getCity();
  	}
  	
  	public String getCountryEquipoVisitante()
  	{
  		return this.equipoVisitante.getCountry();
  	}
  
  	public int getGolesLocal()
  	{
  		return this.golesLocal;
  	}
  	
 	public void setGolesLocal(int golesLocal) throws NegativeNumberException
 	{
 		if(golesLocal < 0)
 		{
 			throw new NegativeNumberException("Numero introducido negativo");
 		}
 		else
 		{
 			this.golesLocal = golesLocal;
 		}
 	}
 	
  	public int getGolesVisitante()
  	{
  		return this.golesVisitante;
  	}
  	
  	public void setGolesVisitante(int golesVisitante) throws NegativeNumberException
  	{
 		if(golesLocal < 0)
 		{
 			throw new NegativeNumberException("Numero introducido negativo");
 		}
 		else
 		{
 			this.golesVisitante = golesVisitante;
 		}
  	}
  	
  	public double getCuotaLocal()
  	{
  		return this.cuotaLocal;
  	}
  	
  	public void setCuotaLocal(double cuotaLocal) throws CuoteException
  	{  		
  		double cuotaVisitanteAnterior;
  		
  		if(cuotaLocal < 5 || cuotaLocal > 90)
  		{
  			throw new CuoteException("cuotaLocal fuera de rango");
  		}
  		else
  		{
  			this.cuotaLocal = cuotaLocal;
  			
  			cuotaVisitanteAnterior = this.cuotaVisitante;
  			
  			this.cuotaVisitante = (100 - cuotaLocal) * this.cuotaVisitante / (this.cuotaEmpate + this.cuotaVisitante);
  			
  			this.cuotaEmpate = this.cuotaEmpate * this.cuotaVisitante / cuotaVisitanteAnterior;
  		}
   	}
  
  	public double getCuotaEmpate()
  	{
  		return this.cuotaEmpate;
  	}
  	
  	public void setCuotaEmpate(double cuotaEmpate) throws CuoteException
  	{
  		double cuotaVisitanteAnterior;
  		
  		if(cuotaEmpate < 5 || cuotaEmpate > 90)
  		{
  			throw new CuoteException("cuotaEmpate fuera de rango");
  		}
  		else
  		{
  			this.cuotaEmpate = cuotaEmpate;
  			
  			cuotaVisitanteAnterior = this.cuotaVisitante;
  			
  			this.cuotaVisitante = (100 - cuotaEmpate) * this.cuotaVisitante / (this.cuotaLocal + this.cuotaVisitante);
  			
  			this.cuotaLocal = this.cuotaLocal * this.cuotaVisitante / cuotaVisitanteAnterior;
  		}	
  			
  	}
  	
  	public void setCuotaVisitante(double cuotaVisitante) throws CuoteException
  	{
  		double cuotaEmpateAnterior;
  		
  		if(cuotaVisitante < 5 || cuotaVisitante > 90)
  		{
  			throw new CuoteException("cuotaVisitante fuera de rango");
  		}
  		else
  		{
  			this.cuotaVisitante = cuotaVisitante;
  			
  			cuotaEmpateAnterior = cuotaEmpate;
  			
  			this.cuotaEmpate = (100 - cuotaVisitante) * this.cuotaEmpate / (this.cuotaLocal + this.cuotaEmpate);
  			
  			this.cuotaLocal = this.cuotaLocal * this.cuotaEmpate / cuotaEmpateAnterior;
  		}	
  			
  	}
  	
  	public double getCuotaVisitante()
  	{
  		return this.cuotaVisitante;
  	}
  	
  	public boolean getFinalized()
  	{
  		return this.finalized;
  	}
  	
 	public void setFinalized(boolean finalized)
 	{
 		this.finalized = finalized;
 	}
 
  	public GregorianCalendar getDate()
  	{
  		return this.date;
  	}
  	
  	public int getDayDate()
  	{
  		return this.date.get(Calendar.DATE);
  	}
  	
  	public int getMonthDate()
  	{
  		return this.date.get(Calendar.MONTH) + 1;
  	}
  	
  	public int getYearDate()
  	{
  		return this.date.get(Calendar.YEAR);
  	}
  	
  	public String getDateString()
  	{
  		return this.getDayDate()+"/"+this.getMonthDate()+"/"+this.getYearDate();
  	}
  
  	public Partido getPartidoAplazado()
  	{
  		return this.partidoSustituido;
  	}
  	
  	public int getIDPartidoAplazado()
  	{	
  		return this.partidoSustituido.ID;
  	}
  	
  	//Métodos Añadidos
  	
  	/*
  	 * Método que modifica por igual las tres cuotas del partido
  	 * Signatura: public boolean changeCuotas(double cuotaLocal, double cuotaEmpate, double cuotaVisitante)
  	 * Entradas:
  	 * 		- double cuotaLocal
  	 * 		- double cuotaEmpate
  	 * 		- double cuotaVisitante
  	 * Precondiciones:
  	 * 		- Las cuotas deben tener un valor positivo entre 5 y 90
  	 * Salidas:
  	 * 		- bolean modificado
  	 * Postcondiciones: En caso de que las cuotas sumen entre ellas un total de 100 serán modificadas y 
  	 * 					se devolverá true asociado al nombre, en caso de error se devolverá false
  	 */
  	public boolean changeCuotas(double cuotaLocal, double cuotaEmpate, double cuotaVisitante)
  	{
  		boolean modificado = false;
  		
  		if(cuotaLocal + cuotaEmpate + cuotaVisitante == 100)
  		{
  			this.cuotaLocal = cuotaLocal;
  			this.cuotaEmpate = cuotaEmpate;
  			this.cuotaVisitante = cuotaVisitante;
  			
  			modificado = true;
  		}
  		
  		return modificado;
  	}
  	
  	//Métodos sobreescritos y compareTo
  	
  	//hashCode
  	@Override
  	public int hashCode()
  	{
  		return this.date.hashCode() + this.ID * 3;
  	}
  	
  	//compareTo
  	/*
  	 * Criterio de comparación: Date e ID
  	 * Devolverá un número entero negativo, 0 o positivo:
  	 * - Negativo --> Si el Partido que recibe la llamada es menor al pasado por parámetros
  	 * - 0 --> Si ambos son iguales
  	 * - Positivo --> Si el Partido que recibe la llamada es mayor al pasado por parámetros
  	 */
  	public int compareTo(Partido partido)
  	{
  		int ret;
  		
  		ret = this.date.compareTo(partido.date);
  		
  		if(ret == 0)
  		{
  			ret = this.ID - partido.ID;
  		}
  		
  		return ret;
  	}
  	
  	//equals
  	@Override
  	public boolean equals(Object obj)
  	{
  		boolean ret = false;
  		
  		if(this == obj)
  		{
  			ret = true;
  		}
  		else if(obj != null && obj instanceof Partido)
  		{
  			Partido partido = (Partido) obj;
  			
  			if(this.ID == partido.ID && this.date == partido.date)
  			{
  				ret = true;
  			}
  		}
  		
  		return ret;
  	}
  	
  	//clone
  	@Override
  	public Partido clone()
  	{
  		Partido partido = null;
  		
  		try
  		{
  			partido = (Partido) super.clone();
  			partido.equipoLocal = this.equipoLocal.clone();
  			partido.equipoVisitante = this.equipoVisitante.clone();
  			partido.date = (GregorianCalendar) this.date.clone();
  			if(this.partidoSustituido != null)
  			{
  				partido.partidoSustituido = this.partidoSustituido.clone();
  			}
  		}
  		catch(CloneNotSupportedException error)
  		{
  			error.printStackTrace();
  		}
  		
  		return partido;
  	}
  	
  	//toString
  	@Override
  	public String toString()
  	{
  		String toString;
  		
  		toString =  this.ID+","+this.equipoLocal.toString()+","+this.equipoVisitante.toString()+","+this.golesLocal+","+this.golesVisitante+","+this.finalized+","+this.getDateString()+",";
  		
  		if(this.partidoSustituido == null)
  		{
  			toString += "NULL";
  		}
  		else
  		{
  			toString += this.partidoSustituido.toString();
  		}
  		
  		return toString;
  	}
}
