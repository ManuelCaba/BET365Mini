package clasesbasicas;

/*
 * Clase Apuesta
 * 
 * Propiedades Básicas:
 * 
 * 		- ID --> int, Consultable
 * 		- usuario --> UsuarioApostador, Consultable
 * 		- partido --> Partido, Consultable
 * 		- cantidadApostada --> double, Consultable
 * 		- apuesta --> char, Consultable
 * 		- comprobada --> boolean, Consultable y Modificable
 * 
 * Propiedades Compartidas: No hay
 * 
 * Propiedades Derivadas: No hay
 * 
 * Getters y/o Setters
 * 
 * 		public int getID();
 * 
 * 		public UsuarioApostador getUsuario();
 * 		public String getNickUsuario();
 * 
 * 		public Partido getPartido();
 * 		public int getIDPartido();
 * 		public String getIDEquipoLocal();
 * 		public String getIDEquipoVisisitante();
 * 		
 * 		public double getCantidadApostada();
 * 
 * 		public char getApuesta();
 * 		
 * 		public boolean getComprobada();
 * 		public void setComprobada(boolean comprobada);
 * 
 * Restricciones:
 * 
 * 		- El ID se generará automaticamente desde 1
 * 		- La cantidad apostada debe ser un número positivo mayor que o igual a 1
 * 		- La apuesta debe tener valor '1' para local, '2' para visitante o 'X' para empate 
 */
public class Apuesta implements Cloneable, Comparable<Apuesta> {
	
	//Declaración de las propiedades de la clase
	private int ID;
	private UsuarioApostador usuarioApostador;
	private Partido partido;
	private double cantidadApostada;
	private char apuesta;
	private boolean comprobada;
	
	//Constructores
	
	public Apuesta()
	{
		this.ID = 0;
		this.usuarioApostador = new UsuarioApostador();
		this.partido = new Partido();
		this.cantidadApostada = 1;
		this.apuesta = 'X';
		this.comprobada = false;
	}
	
	public Apuesta(UsuarioApostador usuarioApostador, Partido partido, double cantidadApostada, char apuesta)
	{
		this.ID = 0;
		this.usuarioApostador = usuarioApostador;
		this.partido = partido;
		
		if(cantidadApostada < 1)
		{
			this.cantidadApostada = 1;
		}
		else
		{
			this.cantidadApostada = cantidadApostada;
		}
		
		if(apuesta != '1' && apuesta != '2' && apuesta != 'X')
		{
			this.apuesta = 'X';
		}
		else
		{
			this.apuesta = apuesta;
		}
		
		this.comprobada = false;
	}
	
	public Apuesta(Apuesta apuesta)
	{
		this.ID = apuesta.ID;
		this.usuarioApostador = apuesta.usuarioApostador;
		this.partido = apuesta.partido;
		this.cantidadApostada = apuesta.cantidadApostada;
		this.apuesta = apuesta.apuesta;
		this.comprobada = apuesta.comprobada;
	}
	
	public Apuesta(int ID, UsuarioApostador usuarioApostador, Partido partido, double cantidadApostada, char apuesta, boolean comprobada)
	{
		this.ID = ID;
		this.usuarioApostador = usuarioApostador;
		this.partido = partido;
		this.cantidadApostada = cantidadApostada;
		this.apuesta = apuesta;
		this.comprobada = comprobada;
	}
	
	//Getters y/o Setters
	
	public int getID()
	{
		return this.ID;
	}
	
	public UsuarioApostador getUsuario()
	{
		return this.usuarioApostador;
	}
	
	public String getNickUsuario()
	{
		return this.usuarioApostador.getNick();
	}
	
	public Partido getPartido()
	{
		return this.partido;
	}
	
	public int getIDPartido()
	{
		return this.partido.getID();
	}
	
	public String getIDEquipoLocal()
	{
		return this.partido.getIDEquipoLocal();
	}
	
	public String getIDEquipoVisisitante()
	{
		return this.partido.getIDEquipoVisitante();
	}
	  		
	public double getCantidadApostada()
	{
		return this.cantidadApostada;
	}
	  
	public char getApuesta()
	{
		return this.apuesta;
	}
	  		
	public boolean getComprobada()
	{
		return this.comprobada;
	}
	
	public void setComprobada(boolean comprobada)
	{
		this.comprobada = comprobada;
	}
	
	//Métodos sobreescritos y compareTo
	
	//hashCode
	@Override
	public int hashCode()
	{
		return this.partido.hashCode() + this.usuarioApostador.hashCode() + this.ID * 3;
	}
	
	//compareTo
	/*
	 * Criterio de comparación: Partido, Usuario e ID
	 * Devolverá un valor entero negativo, 0 o positivo:
	 * Negativo --> Si la Apuesta que recibe la llamada es menor a la pasada por parámetros
	 * 0 --> Si ambos son iguales
	 * Positivo --> Si la Apuesta que recibe la llamada es mayor a la pasada por parámetros
	 */
	public int compareTo(Apuesta apuesta)
	{
		int ret;
		
		ret = this.partido.compareTo(apuesta.partido);
		
		if(ret == 0)
		{
			ret = this.usuarioApostador.compareTo(apuesta.usuarioApostador);
			
			if(ret == 0)
			{
				ret = this.ID - apuesta.ID;
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
		else if(obj != null && obj instanceof Apuesta)
		{
			Apuesta apuesta = (Apuesta) obj;
			
			if(this.ID == apuesta.ID && 
			   this.partido == apuesta.partido &&
			   this.usuarioApostador == apuesta.usuarioApostador)
			{
				ret = true;
			}
		}
		
		return ret;
	}
	
	//clone
	@Override
	public Apuesta clone()
	{
		Apuesta apuesta = null;
		
		try
		{
			apuesta = (Apuesta) super.clone();
		}
		catch(CloneNotSupportedException error)
		{
			error.printStackTrace();
		}
		
		return apuesta;
	}
	
	//toString
	@Override
	public String toString()
	{
		return this.ID+","+this.getNickUsuario()+","+this.getIDPartido()+","+this.cantidadApostada+","+this.apuesta+","+this.comprobada;
	}
}

