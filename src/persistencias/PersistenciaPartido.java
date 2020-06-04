package persistencias;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.GregorianCalendar;

import clasesbasicas.Equipo;
import clasesbasicas.Partido;
import clasesbasicas.UsuarioApostador;

public class PersistenciaPartido {
	/*
	 * M�todo que registra un partido en la tabla Partidos
	 * Signatura: public void registrarPartido(Partido partido, Connection conexion)
	 * Entradas:
	 * 		- Partido partido
	 * 		- Connection conexion
	 * Precondiciones:
	 * 		- El partido debe ser un partido no registrado
	 * Salidas: No hay
	 * Postcondiciones: Se registrar� el partido pasado por par�metros
	 * 					a la tabla Partidos
	 */
	public void registrarPartido(Partido partido, Connection conexion)
	{
		
		PreparedStatement ps = null;
		
		try {
			
			if(conexion != null)
			{
				ps = conexion.prepareStatement("INSERT INTO Partidos (ELocal, EVisitante, CuotaLocal, CuotaEmpate, CuotaVisitante, "
						+ "Fecha, IDPartidoSustituido) VALUES (?, ?, ?, ?, ?, ?, ?)");
				
	    		ps.setString(1, partido.getIDEquipoLocal());
	    		ps.setString(2, partido.getIDEquipoVisitante());
	    		ps.setDouble(3, partido.getCuotaLocal());
	    		ps.setDouble(4, partido.getCuotaEmpate());
	    		ps.setDouble(5, partido.getCuotaVisitante());
	    		ps.setDate(6, new Date(partido.getDate().getTime().getTime()));
	    		
	    		if(partido.getPartidoAplazado() != null)
	    		{
	    			ps.setInt(7, partido.getIDPartidoAplazado());
	    		}
	    		else
	    		{
	    			ps.setNull(7, java.sql.Types.INTEGER);
	    		}
					
	    		ps.executeUpdate();	
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * M�todo que comprueba si existe un partido con el ID pasado por par�metros
	 * Signatura: public boolean partidoRegistrado(int IDPartido, Connection conexion)
	 * Entradas:
	 * 		- int IDPartido
	 * 		- Connection conexion
	 * Precondiciones:
	 * 		- El ID del partido debe ser un ID validado
	 * Salidas: 
	 * 		- boolean registrado
	 * Postcondiciones: Se devolver� un valor boolean asociado al nombre,
	 * 					true para partido registrado y false en caso 
	 * 					contrario.
	 * 					Si existiera un problema con la conexion se lanzar� una excepci�n SQLException.
	 */
	public boolean partidoRegistrado(int IDPartido, Connection conexion)
	{
		boolean registrado = false;

		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			
			if(conexion != null)
			{
				ps = conexion.prepareStatement("SELECT * FROM Partidos WHERE ID = (?)");
				
				ps.setInt(1, IDPartido);
				
				rs = ps.executeQuery();
					
				if(rs.next())
				{
					registrado = true;
				}
					
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return registrado;
	}
	
	/*
	 * M�todo que lista todos los partidos de la tabla Partidos
	 * Signatura: public void listarPartidos(Connection conexion)
	 * Entradas:
	 * 		- Connection conexion
	 * Precondiciones: No hay
	 * Salidas: No hay
	 * Postcondiciones: Se mostrar� una lista de todos los partidos de la tabla Partidos.
	 * 					Si existiera un problema con la conexion se lanzar� una excepci�n SQLException.
	 */
	public void listarPartidos(Connection conexion)
	{
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String partido;
		int partidoAplazado;
		
		try {
			
			if(conexion != null)
			{
				ps = conexion.prepareStatement("SELECT ID, ELocal, EVisitante, GolesLocal, GolesVisitante, CuotaLocal, "
											   + "CuotaEmpate, CuotaVisitante, Finalizado, Fecha, IDPartidoSustituido FROM Partidos");
				
				rs = ps.executeQuery();
					
				while(rs.next())
				{
					partido = rs.getInt(1)+" | "+rs.getString(2)+" | "+rs.getString(3)+" | "+
							  rs.getInt(4)+" | "+rs.getInt(5)+" | "+rs.getDouble(6)+" | "+rs.getDouble(7)+" | "+
							  rs.getDouble(8)+" | "+rs.getBoolean(9)+" | ";
					
					if(rs.getDate(10) != null)
					{
						partido += rs.getDate(10);
					}
					else
					{
						partido += "null";
					}
					
					partido += " | ";
					
					partidoAplazado = rs.getInt(11);
					
					if(rs.wasNull())
					{
						partido += "null";
					}
					else
					{
						partido += partidoAplazado;
					}
					
					System.out.println(partido);

				}
					
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * M�todo que lista todos los partidos de la tabla Partidos seg�n su finalizaci�n
	 * Signatura: public void listarPartidos(boolean finalizado, Connection conexion)
	 * Entradas:
	 * 		- boolean finalizado
	 * 		- Connection conexion
	 * Precondiciones: No hay
	 * Salidas: No hay
	 * Postcondiciones: Se mostrar� una lista de todos los partidos de la tabla Partidos seg�n su finalizaci�n.
	 * 					Si existiera un problema con la conexion se lanzar� una excepci�n SQLException.
	 */
	public void listarPartidos(boolean finalizado, Connection conexion)
	{
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String partido;
		int partidoAplazado;
		
		try {
			
			if(conexion != null)
			{
				ps = conexion.prepareStatement("SELECT ID, ELocal, EVisitante, GolesLocal, GolesVisitante, CuotaLocal, "
											   + "CuotaEmpate, CuotaVisitante, Finalizado, Fecha, IDPartidoSustituido FROM Partidos WHERE Finalizado = (?)");
				
				ps.setBoolean(1, finalizado);
				
				rs = ps.executeQuery();
					
				while(rs.next())
				{
					partido = rs.getInt(1)+" | "+rs.getString(2)+" | "+rs.getString(3)+" | "+
							  rs.getInt(4)+" | "+rs.getInt(5)+" | "+rs.getDouble(6)+" | "+rs.getDouble(7)+" | "+
							  rs.getDouble(8)+" | "+rs.getBoolean(9)+" | ";
					
					if(rs.getDate(10) != null)
					{
						partido += rs.getDate(10);
					}
					else
					{
						partido += "null";
					}
					
					partido += " | ";
					
					partidoAplazado = rs.getInt(11);
					
					if(rs.wasNull())
					{
						partido += "null";
					}
					else
					{
						partido += partidoAplazado;
					}
					
					System.out.println(partido);

				}
					
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * M�todo que lista todos los partidos de la tabla Partidos seg�n un equipo
	 * Signatura: public void listarPartidos(String IDEquipo, Connection conexion)
	 * Entradas:
	 * 		- String IDEquipo
	 * 		- Connection conexion
	 * Precondiciones: No hay
	 * Salidas: No hay
	 * Postcondiciones: Se mostrar� una lista de todos los partidos de la tabla Partidos seg�n un equipo.
	 * 					Si existiera un problema con la conexion se lanzar� una excepci�n SQLException.
	 */
	public void listarPartidos(String IDEquipo, Connection conexion)
	{
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String partido;
		int partidoAplazado;
		
		try {
			
			if(conexion != null)
			{
				ps = conexion.prepareStatement("SELECT ID, ELocal, EVisitante, GolesLocal, GolesVisitante, CuotaLocal, "
											   + "CuotaEmpate, CuotaVisitante, Finalizado, Fecha, IDPartidoSustituido FROM Partidos WHERE Elocal = (?) "
											   + "OR EVisitante = (?)");
				
				ps.setString(1, IDEquipo);
				ps.setString(2, IDEquipo);
				
				rs = ps.executeQuery();
					
				while(rs.next())
				{
					partido = rs.getInt(1)+" | "+rs.getString(2)+" | "+rs.getString(3)+" | "+
							  rs.getInt(4)+" | "+rs.getInt(5)+" | "+rs.getDouble(6)+" | "+rs.getDouble(7)+" | "+
							  rs.getDouble(8)+" | "+rs.getBoolean(9)+" | ";
					
					if(rs.getDate(10) != null)
					{
						partido += rs.getDate(10);
					}
					else
					{
						partido += "null";
					}
					
					partido += " | ";
					
					partidoAplazado = rs.getInt(11);
					
					if(rs.wasNull())
					{
						partido += "null";
					}
					else
					{
						partido += partidoAplazado;
					}
					
					System.out.println(partido);

				}
					
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	/*
	 * M�todo que recupera un partido de la tabla Partidos
	 * Signatura: public Partido recuperarPartido(int IDPartido, Connection conexion)
	 * Entradas:
	 * 		- int IDPartido
	 * 		- Connection conexion
	 * Precondiciones: No hay
	 * Salidas:
	 * 		- Equipo equipo
	 * Postcondiciones: En caso de exito en la recuperaci�n se devolver� un objeto Partido con el partido
	 * 					cuyo ID se ha pasado por par�metros, en caso contrario se devolver� null.
	 * 					Si existiera un problema con la conexion se lanzar� una excepci�n SQLException.
	 */
	public Partido recuperarPartido(int IDPartido, Connection conexion)
	{
		PersistenciaEquipo persistenciaEquipo = new PersistenciaEquipo();
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		Partido partido = null;
		Partido partidoSustituido = null;
		GregorianCalendar date = new GregorianCalendar();;
		int IDPartidoSustituido;
		
		try {
			
			if(conexion != null)
			{
				ps = conexion.prepareStatement("SELECT ELocal, EVisitante, GolesLocal, GolesVisitante, CuotaLocal, "
						+ "CuotaEmpate, CuotaVisitante, Finalizado, Fecha, IDPartidoSustituido FROM Partidos WHERE ID = (?)");
				
				ps.setInt(1, IDPartido);
				
				rs = ps.executeQuery();
				
				if(rs.next())
				{
					IDPartidoSustituido = rs.getInt(10);
					
					if(IDPartidoSustituido != 0)
					{
						partidoSustituido = recuperarPartido(IDPartidoSustituido, conexion);
					}
					
					date.setTime(rs.getDate(9));
					
					partido = new Partido(IDPartido, persistenciaEquipo.recuperarEquipo(rs.getString(1), conexion), 
							persistenciaEquipo.recuperarEquipo(rs.getString(2), conexion), rs.getInt(3), rs.getInt(4), rs.getDouble(5), rs.getDouble(6),
							rs.getDouble(7), rs.getBoolean(8), date, partidoSustituido);
				}		
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return partido;
	}
	
	/*
	 * M�todo que actualiza un partido de la tabla Partidos a partir de un objeto Partido
	 * Signatura: public void actualizarPartido(Partido partido, Connection conexion)
	 * Entradas:
	 * 		- Partido partido
	 * 		- Connection conexion
	 * Precondiciones:
	 * 		- El partido debe existir en la base de datos
	 * Salidas: No hay
	 * Postcondiciones: Se actualizar� el partido en la tabla Partidos.
	 * 					Si existiera un problema con la conexion se lanzar� una excepci�n SQLException.
	 */
	public void actualizarPartido(Partido partido, Connection conexion)
	{
		
		PreparedStatement ps = null;
		
		try {
			
			if(conexion != null)
			{
				ps = conexion.prepareStatement("UPDATE Partidos SET GolesLocal = (?), GolesVisitante = (?), CuotaLocal = (?), CuotaEmpate = (?)"
						+ ", CuotaVisitante = (?), Finalizado = (?) WHERE ID = (?)");
				
				ps.setInt(1, partido.getGolesLocal());
				ps.setInt(2, partido.getGolesVisitante());
				ps.setDouble(3, partido.getCuotaLocal());
				ps.setDouble(4, partido.getCuotaEmpate());
				ps.setDouble(5, partido.getCuotaVisitante());
				ps.setBoolean(6, partido.getFinalized());
				
				ps.setInt(7, partido.getID());
				
				ps.executeUpdate();	
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
