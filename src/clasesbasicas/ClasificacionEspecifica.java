package clasesbasicas;

import excepciones.NegativeNumberException;

/*
 * Clase ClasificacionEspecifica
 * 
 * Propiedades Básicas:
 * 
 * 		- posicion --> int, Consultable y Modificable
 * 		- equipo --> Equipo, Consultable
 * 		- partidosGanados --> int, Consultable y Modificable
 * 		- partidosPerdidos --> int, Consultable y Modificable
 * 		- partidosEmpatados --> int, Consultable y Modificable
 * 		- golesAFavor --> int, Consultable y Modificable
 * 		- golesEnContra --> int, Consultable y Modificable
 * 
 * Propiedades Compartidas: No hay
 * 
 * Propiedades Derivadas:
 * 
 * 		- partidosJugados --> int, Consultable
 * 		- diferenciaGoles --> int, Consultable
 * 		- puntos --> int, Consultable
 *
 * Getters y/o Setters
 * 		
 * 		public int getPosicion();
 * 		public void setPosicion(int posicion);
 * 
 * 		public Equipo getEquipo();
 * 		public String getIDEquipo();
 * 	
 * 		public int getPartidosGanados();
 * 		public void setPartidosGanados(int partidosGanados);
 * 
 * 		public int getPartidosPerdidos();
 * 		public void setPartidosPerdidos(int partidosPerdidos);
 * 
 * 		public int getPartidosEmpatados();
 * 		public void setPartidosEmpatados(int partidosEmpatados);
 * 
 * 		public int getGolesAFavor();
 * 		public void setGolesAFavor(int golesAFavor);
 * 
 * 		public int getGolesEnContra();
 * 		public void setGolesEnContra(int golesEnContra);
 * 
 * 		public int getPartidosJugados();
 * 
 * 		public int getDiferenciaGoles();
 * 
 * 		public int getPuntos();
 * 
 * Métodos añadidos:
 * 
 * 		- public void incrementarPartidosGanados(int partidosGanados);
 * 		- public void incrementarPartidosPerdidos(int partidosPerdidos);
 * 		- public void incrementarPartidosEmpatados(int partidosEmpatados);
 * 		- public void incrementarGolesAFavor(int golesAFavor);
 * 		- public void incrementarGolesEnContra(int golesEnContra);
 * 		- public String mostrarClasificacion();
 * 
 * Restricciones:
 * 
 *		- La posición se iniciliazará a 0
 *		- Todos los partidos y goles deben ser un número entero positivo.
 *		
 */
public class ClasificacionEspecifica implements Cloneable, Comparable<ClasificacionEspecifica> {
	//Declaración de las propiedades de la clase
	private int posicion;
	private Equipo equipo;
	private int partidosGanados;
	private int partidosPerdidos;
	private int partidosEmpatados;
	private int golesAFavor;
	private int golesEnContra;
	
	//Constructores
	
	public ClasificacionEspecifica()
	{
		this.posicion = 0;
		this.equipo = new Equipo();
		this.partidosGanados = 0;
		this.partidosPerdidos = 0;
		this.partidosEmpatados = 0;
		this.golesAFavor = 0;
		this.golesEnContra = 0;
	}
	
	public ClasificacionEspecifica(Equipo equipo)
	{
		this.posicion = 0;
		this.equipo = equipo;
		this.partidosGanados = 0;
		this.partidosPerdidos = 0;
		this.partidosEmpatados = 0;
		this.golesAFavor = 0;
		this.golesEnContra = 0;
	}
	
	public ClasificacionEspecifica(ClasificacionEspecifica clasificacion)
	{
		this.posicion = clasificacion.posicion;
		this.equipo = clasificacion.equipo;
		this.partidosGanados = clasificacion.partidosGanados;
		this.partidosPerdidos = clasificacion.partidosPerdidos;
		this.partidosEmpatados = clasificacion.partidosEmpatados;
		this.golesAFavor = clasificacion.golesAFavor;
		this.golesEnContra = clasificacion.golesEnContra;
	}
	
	//Getters y/o Setters
	
	public int getPosicion()
	{
		return this.posicion;
	}
	
  	public void setPosicion(int posicion) throws NegativeNumberException
  	{
  		if(posicion < 0)
  		{
  			throw new NegativeNumberException("Numero introducido negativo");
  		}
  		else
  		{
  			this.posicion = posicion;
  		}
  	}
  
  	public Equipo getEquipo()
  	{
  		return this.equipo;
  	}
  	
  	public String getIDEquipo()
  	{
  		return this.equipo.getID();
  	}
  	
  	public int getPartidosGanados()
  	{
  		return this.partidosGanados;
  	}
  	
  	public void setPartidosGanados(int partidosGanados) throws NegativeNumberException
  	{
  		if(partidosGanados < 0)
  		{
  			throw new NegativeNumberException("Numero introducido negativo");
  		}
  		else
  		{
  			this.partidosGanados = partidosGanados;
  		}
  	}
 
 	public int getPartidosPerdidos()
 	{
 		return this.partidosPerdidos;
 	}
 	
 	public void setPartidosPerdidos(int partidosPerdidos) throws NegativeNumberException
 	{
  		if(partidosPerdidos < 0)
  		{
  			throw new NegativeNumberException("Numero introducido negativo");
  		}
  		else
  		{
  			this.partidosPerdidos = partidosPerdidos;
  		}
 	}
  
  	public int getPartidosEmpatados()
  	{
  		return this.partidosEmpatados;
  	}
  	
  	public void setPartidosEmpatados(int partidosEmpatados) throws NegativeNumberException
  	{
  		if(partidosEmpatados < 0)
  		{
  			throw new NegativeNumberException("Numero introducido negativo");
  		}
  		else
  		{
  			this.partidosEmpatados = partidosEmpatados;
  		}
  	}
  
  	public int getGolesAFavor()
  	{
  		return this.golesAFavor;
  	}
  	
 	public void setGolesAFavor(int golesAFavor) throws NegativeNumberException
 	{
  		if(golesAFavor < 0)
  		{
  			throw new NegativeNumberException("Numero introducido negativo");
  		}
  		else
  			
  		{
  			this.golesAFavor = golesAFavor;
  		}
 	}
  
  	public int getGolesEnContra()
  	{
  		return this.golesEnContra;
  	}
 		
  	public void setGolesEnContra(int golesEnContra) throws NegativeNumberException
  	{
  		if(golesEnContra < 0)
 		{
 			throw new NegativeNumberException("Numero introducido negativo");
 		}
 		else
 		{
 			this.golesEnContra = golesEnContra;
 		} 
  	}
  
  	public int getPartidosJugados()
  	{
  		return this.partidosGanados+this.partidosEmpatados+this.partidosPerdidos;
  	}
  
  	public int getDiferenciaGoles()
  	{
  		return this.golesAFavor - this.golesEnContra;
  	}
  
  	public int getPuntos()
  	{
  		return (this.partidosGanados * 3) + this.partidosEmpatados;
  	}
 	
 	//Métodos añadidos
 	
 	/*
 	 * Método que incrementa los partidosGanados
 	 * Signatura: public void incrementarPartidosGanados(int partidosGanados)
 	 * Entradas:
 	 * 		- int partidosGanados
 	 * Precondiciones:
 	 * 		- partidosGanados deber ser un número entero positivo
 	 * Salidas: No hay
 	 * Postcondiciones: Se incrementará la variable partidosGanados de la clasificiación
 	 * 					que recibe la llamada
 	 */
 	public void incrementarPartidosGanados(int partidosGanados)
 	{
 		this.partidosGanados += partidosGanados;
 	}
 	
 	/*
 	 * Método que incrementa los partidosPerdidos
 	 * Signatura: public void incrementarPartidosPerdidos(int partidosPerdidos)
 	 * Entradas:
 	 * 		- int partidosPerdidos
 	 * Precondiciones:
 	 * 		- partidosPerdidos deber ser un número entero positivo
 	 * Salidas: No hay
 	 * Postcondiciones: Se incrementará la variable partidosPerdidos de la clasificiación
 	 * 					que recibe la llamada
 	 */
 	public void incrementarPartidosPerdidos(int partidosPerdidos)
	{
 		this.partidosPerdidos += partidosPerdidos;
	}
 	
 	/*
 	 * Método que incrementa los partidosEmpatados
 	 * Signatura: public void incrementarPartidosEmpatados(int partidosEmpatados)
 	 * Entradas:
 	 * 		- int partidosEmpatados
 	 * Precondiciones:
 	 * 		- partidosEmpatados deber ser un número entero positivo
 	 * Salidas: No hay
 	 * Postcondiciones: Se incrementará la variable partidosEmpatados de la clasificiación
 	 * 					que recibe la llamada
 	 */
 	public void incrementarPartidosPartidosEmpatados(int partidosEmpatados)
	{
 		this.partidosEmpatados += partidosEmpatados;
	}
 	
 	/*
 	 * Método que incrementa los golesAFavor
 	 * Signatura: public void incrementarGolesAFavor(int golesAFavor)
 	 * Entradas:
 	 * 		- int golesAFavor
 	 * Precondiciones:
 	 * 		- golesAFavor deber ser un número entero positivo
 	 * Salidas: No hay
 	 * Postcondiciones: Se incrementará la variable golesAFavor de la clasificiación
 	 * 					que recibe la llamada
 	 */
 	public void incrementarGolesAFavor(int golesAFavor)
	{
 		this.golesAFavor += golesAFavor;
	}
 	
 	/*
 	 * Método que incrementa los golesEnContra
 	 * Signatura: public void incrementarGolesEnContra(int golesEnContra)
 	 * Entradas:
 	 * 		- int golesEnContra
 	 * Precondiciones:
 	 * 		- golesEnContra deber ser un número entero positivo
 	 * Salidas: No hay
 	 * Postcondiciones: Se incrementará la variable golesEnContra de la clasificiación
 	 * 					que recibe la llamada
 	 */
 	public void incrementarGolesEnContra(int golesEnContra)
	{
 		this.golesEnContra += golesEnContra;
	}

	/*
	 * Método que muestra los datos de la clasificación
	 * Signatura: public String mostrarClasifiacion()
	 * Entradas: No hay
	 * Precondiciones: No hay
	 * Salidas:
	 * 		- String clasificacion
	 * Postcondiciones: Se devolverá un String asociado al nombre con los datos de
	 * 					la clasificación
	 */
	public String mostrarClasificacion() 
	{
		return this.posicion+" | "+this.getIDEquipo()+" | "+this.getPartidosJugados()+" | "+this.golesAFavor+":"+this.golesEnContra+" | "+this.getDiferenciaGoles()+" | "+this.getPuntos();
	}

 	//Métodos sobreescritos y compareTo
 	
 	//hashCode
 	@Override
 	public int hashCode()
 	{
 		return this.getPuntos() + this.getDiferenciaGoles() + this.golesAFavor + this.getIDEquipo().hashCode();
 	}

	//compareTo
	/*
	 * Criterio de comparación: Puntos, DiferenciaGoles , GolesAFavor y Equipo
	 * Devolverá un valor entero negativo, 0 o positivo:
	 * Negativo --> Si la ClasificacionEspecifica que recibe la llamada es menor a la pasada por parámetros
	 * 0 --> Si ambos son iguales
	 * Positivo --> Si la ClasifacionEspecifica que recibe la llamada es mayor a la pasada por parámetros
	 */
	public int compareTo(ClasificacionEspecifica clasificacion)
	{
		int ret;
		
		ret = this.getPuntos() - clasificacion.getPuntos();
		
		if(ret == 0)
		{
			ret = this.getDiferenciaGoles() - clasificacion.getDiferenciaGoles();
			
			if(ret == 0)
			{
				ret = this.getGolesAFavor() - clasificacion.getGolesAFavor();
						
				if(ret == 0)
				{
					ret = this.equipo.compareTo(clasificacion.equipo);
				}
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
		else if(obj != null && obj instanceof ClasificacionEspecifica)
		{
			ClasificacionEspecifica clasificacion = (ClasificacionEspecifica) obj;
			
			if(this.equipo.equals(clasificacion.equipo))
			{
				ret = true;
			}
		}
		
		return ret;
	}
	
	//clone
	@Override
	public ClasificacionEspecifica clone()
	{
		ClasificacionEspecifica clasificacion = null;
		
		try
		{
			clasificacion = (ClasificacionEspecifica) super.clone();
			clasificacion.equipo = clasificacion.equipo.clone();
		}
		catch(CloneNotSupportedException error)
		{
			error.printStackTrace();
		}
		
		return clasificacion;
	}

	//toString
	@Override
	public String toString()
	{
		return this.getIDEquipo()+","+this.posicion+","+this.partidosGanados+","+this.partidosPerdidos+","+this.partidosEmpatados+","+this.golesAFavor+","+this.golesEnContra+","+this.getPartidosJugados()+","+this.getPuntos()+","+this.getDiferenciaGoles();
	}
}
