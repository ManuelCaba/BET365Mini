package clasesbasicas;

import excepciones.NegativeNumberException;

/*
 * Clase ClasificacionGeneral
 * 
 * Propiedades Básicas:
 * 
 * 		- posicion --> int, Consultable y Modificable
 * 		- equipo --> Equipo, Consultable
 * 		- clasificacioLocal --> ClasificacionEspecifica, Consultable
 * 		- clasificacionVisitante --> ClasificacionEspecifica, Consultable
 * 
 * Propiedades Compartidas: No hay
 * 
 * Propiedades Derivadas:
 * 
 * 		- partidosGanados --> int, Consultable
 * 		- partidosPerdidos --> int, Consultable
 * 		- partidosEmpatados --> int, Consultable
 * 		- partidosJugados --> int, Consultable
 * 		- golesAFavor --> int, Consultable
 * 		- golesEnContra --> int, Consultable
 * 		- diferenciaGoles --> int, Consultable
 * 		- puntos --> int, Consultable
 *
 * Getters y/o Setters
 * 		
 * 		public int getPosicion();
 * 		public void setPosicion(int posicion);
 * 
 * 		public Equipo getEquipo();
 * 		public String getIDEquipo(); --> Delegated Method
 * 	
 * 		public ClasificacionEspecifica getClasificacionLocal();
 * 
 * 		public ClasificacionEspecifica getClasificacionVisitante();
 * 
 * 		public int getPartidosGanados();
 * 
 * 		public int getPartidosPerdidos();
 * 
 * 		public int getPartidosEmpatados();
 * 
 * 		public int getPartidosJugados();
 * 
 * 		public int getGolesAFavor();
 * 
 * 		public int getGolesEnContra();
 * 
 * 		public int getDiferenciaGoles();
 * 
 * 		public int getPuntos();
 * 
 * Métodos añadidos:
 * 
 * 		- public String mostrarClasificacion();
 * 
 * Restricciones:
 * 
 *		- La posición se iniciliazará a 0
 *		- Todos los partidos y goles deben ser un número entero positivo.
 *		
 */
public class ClasificacionGeneral implements Cloneable, Comparable<ClasificacionGeneral> {
	
	//Declaración de las propiedades de la clase
	private int posicion;
	private Equipo equipo;
	private ClasificacionEspecifica clasificacionLocal;
	private ClasificacionEspecifica clasificacionVisitante;
	
    //Constructores
	
	public ClasificacionGeneral()
	{
		this.posicion = 0;
		this.equipo = new Equipo();
		this.clasificacionLocal = new ClasificacionEspecifica();
		this.clasificacionVisitante = new ClasificacionEspecifica();
	}
	
	public ClasificacionGeneral(Equipo equipo)
	{
		this.posicion = 0;
		this.equipo = equipo;
		this.clasificacionLocal = new ClasificacionEspecifica(equipo);
		this.clasificacionVisitante = new ClasificacionEspecifica(equipo);
	}
	
	public ClasificacionGeneral(ClasificacionGeneral clasificacion)
	{
		this.posicion = clasificacion.posicion;
		this.equipo = clasificacion.equipo;
		this.clasificacionLocal = clasificacion.clasificacionLocal;
		this.clasificacionVisitante = clasificacion.clasificacionVisitante;
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
  	
  	public ClasificacionEspecifica getClasificacionLocal()
  	{
  		return this.clasificacionLocal;
  	}
  
  	public ClasificacionEspecifica getClasificacionVisitante()
  	{
  		return this.clasificacionVisitante;
  	}
  
 	public int getPartidosGanados()
 	{
 		return this.clasificacionLocal.getPartidosGanados() + this.clasificacionVisitante.getPartidosGanados();
 	}
 
  	public int getPartidosPerdidos()
  	{
  		return this.clasificacionLocal.getPartidosPerdidos() + this.clasificacionVisitante.getPartidosPerdidos();
  	}
  
  	public int getPartidosEmpatados()
  	{
  		return this.clasificacionLocal.getPartidosEmpatados() + this.clasificacionVisitante.getPartidosEmpatados();
  	}
 
  	public int getPartidosJugados()
  	{
  		return this.clasificacionLocal.getPartidosJugados() + this.clasificacionVisitante.getPartidosJugados();
  	}
  
  	public int getGolesAFavor()
  	{
  	  	
  	  	return this.clasificacionLocal.getGolesAFavor() + this.clasificacionVisitante.getGolesAFavor();
  	}
  
  	public int getGolesEnContra()
  	{
  		return this.clasificacionLocal.getGolesEnContra() + this.clasificacionVisitante.getGolesEnContra();
  	}
  
  	public int getDiferenciaGoles()
  	{
  		return this.getGolesAFavor() - this.getGolesEnContra();
  	}
  
  	public int getPuntos()
  	{
  		return (this.getPartidosGanados() * 3) + this.getPartidosEmpatados();
  	}
  	
  	//Métodos añadidos
  	
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
		return this.posicion+" | "+this.getIDEquipo()+" | "+this.getPartidosJugados()+" | "+this.getGolesAFavor()+":"+this.getGolesEnContra()+" | "+this.getDiferenciaGoles()+" | "+this.getPuntos();
	}
	
 	//Métodos sobreescritos y compareTo
 	
 	//hashCode
 	@Override
 	public int hashCode()
 	{
 		return this.getPuntos() + this.getDiferenciaGoles() + this.getGolesAFavor() + this.clasificacionVisitante.getPartidosGanados() + this.clasificacionVisitante.getGolesAFavor() + this.equipo.hashCode();
 	}
 	
	//compareTo
	/*
	 * Criterio de comparación: Puntos, DiferenciaGoles , GolesAFavor, PartidosGanadosVisitante, GolesAFavorVisitante y Equipo
	 * Devolverá un valor entero negativo, 0 o positivo:
	 * Negativo --> Si la ClasificacionGeneral que recibe la llamada es menor a la pasada por parámetros
	 * 0 --> Si ambos son iguales
	 * Positivo --> Si la ClasifacionGeneral que recibe la llamada es mayor a la pasada por parámetros
	 */
	public int compareTo(ClasificacionGeneral clasificacion)
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
					ret = this.clasificacionVisitante.getPartidosGanados()- clasificacion.clasificacionVisitante.getPartidosGanados();
					
					if(ret == 0)
					{
						ret = this.clasificacionVisitante.getGolesAFavor() - clasificacion.clasificacionVisitante.getGolesAFavor();
						
						if(ret == 0)
						{
							ret = this.equipo.compareTo(clasificacion.equipo);
						}
					}
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
		else if(obj != null && obj instanceof ClasificacionGeneral)
		{
			ClasificacionGeneral clasificacion = (ClasificacionGeneral) obj;
			
			if(this.equipo.equals(clasificacion.equipo))
			{
				ret = true;
			}
		}
		
		return ret;
	}
	
	//clone
	@Override
	public ClasificacionGeneral clone()
	{
		ClasificacionGeneral clasificacion = null;
		
		try
		{
			clasificacion = (ClasificacionGeneral) super.clone();
			clasificacion.equipo = clasificacion.equipo.clone();
			clasificacion.clasificacionLocal = clasificacion.clasificacionLocal.clone();
			clasificacion.clasificacionVisitante = clasificacion.clasificacionVisitante.clone();
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
		return this.getIDEquipo()+","+this.posicion+","+this.getPartidosGanados()+","+this.getPartidosPerdidos()+","+this.getPartidosEmpatados()+","+this.getGolesAFavor()+","+this.getGolesEnContra()+","+this.getPartidosJugados()+","+this.getPuntos()+","+this.getDiferenciaGoles();
	}

	
	//Delegated Methods
	
  	public String getIDEquipo()
  	{
  		return this.equipo.getID();
  	}
	
 	public int getPartidosGanadosLocal()
 	{
 		return this.clasificacionLocal.getPartidosGanados();
 	}
 
  	public int getPartidosPerdidosLocal()
  	{
  		return this.clasificacionLocal.getPartidosPerdidos();
  	}
  
  	public int getPartidosEmpatadosLocal()
  	{
  		return this.clasificacionLocal.getPartidosEmpatados();
  	}
 
  	public int getPartidosJugadosLocal()
  	{
  		return this.clasificacionLocal.getPartidosJugados();
  	}
  
  	public int getGolesAFavorLocal()
  	{
  	  	
  	  	return this.clasificacionLocal.getGolesAFavor();
  	}
  
  	public int getGolesEnContraLocal()
  	{
  		return this.clasificacionLocal.getGolesEnContra();
  	}
  
  	public int getDiferenciaGolesLocal()
  	{
  		return this.clasificacionLocal.getGolesEnContra();
  	}
  
  	public int getPuntosLocal()
  	{
  		return this.clasificacionLocal.getPuntos();
  	}

	public void incrementarPartidosGanadosLocal(int partidosGanados) 
	{
		clasificacionLocal.incrementarPartidosGanados(partidosGanados);
	}

	public void incrementarPartidosPerdidosLocal(int partidosPerdidos) 
	{
		clasificacionLocal.incrementarPartidosPerdidos(partidosPerdidos);
	}

	public void incrementarPartidosPartidosEmpatadosLocal(int partidosEmpatados) 
	{
		clasificacionLocal.incrementarPartidosPartidosEmpatados(partidosEmpatados);
	}

	public void incrementarGolesAFavorLocal(int golesAFavor) 
	{
		clasificacionLocal.incrementarGolesAFavor(golesAFavor);
	}

	public void incrementarGolesEnContraLocal(int golesEnContra) 
	{
		clasificacionLocal.incrementarGolesEnContra(golesEnContra);
	}
	
	public String mostrarClasificacionLocal() 
	{
		return this.clasificacionLocal.mostrarClasificacion();
	}
	
 	public int getPartidosGanadosVisitante()
 	{
 		return this.clasificacionVisitante.getPartidosGanados();
 	}
 
  	public int getPartidosPerdidosVisitante()
  	{
  		return this.clasificacionVisitante.getPartidosPerdidos();
  	}
  
  	public int getPartidosEmpatadosVisitante()
  	{
  		return this.clasificacionVisitante.getPartidosEmpatados();
  	}
 
  	public int getPartidosJugadosVisitante()
  	{
  		return this.clasificacionVisitante.getPartidosJugados();
  	}
  
  	public int getGolesAFavorVisitante()
  	{
  	  	
  	  	return this.clasificacionVisitante.getGolesAFavor();
  	}
  
  	public int getGolesEnContraVisitante()
  	{
  		return this.clasificacionVisitante.getGolesEnContra();
  	}
  
  	public int getDiferenciaGolesVisitante()
  	{
  		return this.clasificacionVisitante.getDiferenciaGoles();
  	}
  
  	public int getPuntosVisitante()
  	{
  		return this.clasificacionVisitante.getPuntos();
  	}

	public void incrementarPartidosGanadosVisitante(int partidosGanados) 
	{
		clasificacionVisitante.incrementarPartidosGanados(partidosGanados);
	}

	public void incrementarPartidosPerdidosVisitante(int partidosPerdidos) 
	{
		clasificacionVisitante.incrementarPartidosPerdidos(partidosPerdidos);
	}

	public void incrementarPartidosPartidosEmpatadosVisitante(int partidosEmpatados) 
	{
		clasificacionVisitante.incrementarPartidosPartidosEmpatados(partidosEmpatados);
	}

	public void incrementarGolesAFavorVisitante(int golesAFavor) 
	{
		clasificacionVisitante.incrementarGolesAFavor(golesAFavor);
	}

	public void incrementarGolesEnContraVisitante(int golesEnContra) 
	{
		clasificacionVisitante.incrementarGolesEnContra(golesEnContra);
	}
	
	public String mostrarClasificacionVisitante() 
	{
		return this.clasificacionVisitante.mostrarClasificacion();
	}
  	
  	

}
