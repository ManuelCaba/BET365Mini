package clasesbasicas;

/*
 * Clase Equipo
 * 
 * Propiedades Básicas:
 * 
 * 		- ID --> String, Consultable
 * 		- Name --> String, Consultable
 * 		- City --> String, Consultable
 * 		- Country --> String, Consultable
 * 
 * Propiedades Compartidas: No hay
 * 
 * Propiedades Derivadas: No hay
 * 
 * Getters y/o Setters
 * 
 * 		public String getID();
 * 
 *		public String getName();
 *
 *		public String getCity();
 *	
 *		public String getCountry();
 *
 * Métodos añadidos: 
 * 	
 * 		public String mostrarEquipo();
 *
 * Restricciones:
 * 
 * 		- El ID debe ser una cadena de 4 dígitos y mayúscula
 */
public class Equipo implements Cloneable, Comparable<Equipo> {
	//Declaración de las propiedades de la clase
	private String ID;
	private String name;
	private String city;
	private String country;
	
	//Constructores
	
	public Equipo()
	{
		this.ID = "DFLT";
		this.name = "Default";
		this.city = "Default";
		this.country = "Default";
	}
	
	public Equipo(String ID, String name, String city, String country)
	{
		if(ID.length() == 4)
		{
			this.ID = ID.toUpperCase();
		}
		else
		{
			this.ID = "DFLT";
		}
		this.name = name;
		this.city = city;
		this.country = country;
	}
	
	public Equipo(Equipo equipo)
	{
		this.ID = equipo.ID;
		this.name = equipo.name;
		this.city = equipo.city;
		this.country = equipo.country;
	}
	
	//Getters y/o Setters
	
	public String getID()
	{
		return this.ID;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public String getCity()
	{
		return this.city;
	}
	
	public String getCountry()
	{
		return this.country;
	}
	
	//Métodos añadidos
	
	/*
	 * Método que muestra los datos de un equipo
	 * Signatura: public String mostrarEquipo()
	 * Entradas: No hay
	 * Precondiciones: No hay
	 * Salidas:
	 * 		- String equipo
	 * Postcondiciones: Se devolverá un String asociado al nombre con los datos del equipo
	 */
	public String mostrarEquipo() 
	{
		return this.ID+" | "+this.name+" | "+this.city+" | "+this.country;
	}
	
	//Métodos sobreescritos y compareTo
	
	//hashCode
	@Override
	public int hashCode()
	{
		return this.country.hashCode() + this.city.hashCode() + this.ID.hashCode();
	}
	
	//compareTo
	/*
	 * Criterio de comparación: Country, City e ID
	 * Devolverá Negativo, 0 o Positivo:
	 * - Negativo --> Si el Equipo que recibe la llamada es menor al pasado por parámetros
	 * - 0 --> Si ambos son iguales
	 * - Positivo --> Si el Equipo que recibe la llamada es mayor al pasado por parámetros
	 */
	public int compareTo(Equipo equipo)
	{
		int ret;
		
		ret = this.country.compareTo(equipo.country);
		
		if(ret == 0)
		{
			ret = this.city.compareTo(equipo.city);
			
			if(ret == 0)
			{
				ret = this.ID.compareTo(equipo.ID);
			}
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
		else if(obj != null && obj instanceof Equipo)
		{
			Equipo equipo = (Equipo) obj;
			
			if(this.ID == equipo.ID)
			{
				ret = true;
			}
		}
		
		return ret;
	}
	
	//clone
	@Override
	public Equipo clone()
	{
		Equipo equipo = null;
		
		try
		{
			equipo = (Equipo) super.clone();
		}
		catch(CloneNotSupportedException error)
		{
			error.printStackTrace();
		}
		
		return equipo;
	}
	
	//toString
	@Override
	public String toString()
	{
		return this.ID+","+this.name+","+this.country+","+this.city;
	}
}
