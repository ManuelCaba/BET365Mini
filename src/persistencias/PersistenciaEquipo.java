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

public class PersistenciaEquipo {
	/*
	 * M�todo que comprueba si existe un equipo apostador con el ID pasado por par�metros
	 * Signatura: public boolean equipoRegistrado(String IDEquipo, Connection conexion)
	 * Entradas:
	 * 		- String IDEquipo
	 * 		- Connection conexion
	 * Precondiciones:
	 * 		- El ID del equipo debe ser un ID validado
	 * Salidas: 
	 * 		- boolean registrado
	 * Postcondiciones: Se devolver� un valor boolean asociado al nombre,
	 * 					true para equipo registrado y false en caso 
	 * 					contrario.
	 * 					Si existiera un problema con la conexion se lanzar� una excepci�n SQLException.
	 */
	public boolean equipoRegistrado(String IDEquipo, Connection conexion)
	{
		boolean registrado = false;

		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			
			if(conexion != null)
			{
				ps = conexion.prepareStatement("SELECT * FROM Equipos WHERE ID = (?)");
				
				ps.setString(1, IDEquipo);
				
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
	 * M�todo que lista todos los equipos de la tabla Equipos
	 * Signatura: public void listarEquipos(Connection conexion)
	 * Entradas:
	 * 		- Connection conexion
	 * Precondiciones: No hay
	 * Salidas: No hay
	 * Postcondiciones: Se mostrar� una lista de todos los equipos de la tabla Equipos.
	 * 					Si existiera un problema con la conexion se lanzar� una excepci�n SQLException.
	 */
	public void listarEquipos(Connection conexion)
	{
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			
			if(conexion != null)
			{
				ps = conexion.prepareStatement("SELECT ID, Nombre, Ciudad, Pais FROM Equipos");
				
				rs = ps.executeQuery();
					
				while(rs.next())
				{
					System.out.println(rs.getString(1)+" | "+rs.getString(2)+" | "+rs.getString(3)+" | "+rs.getString(4));
				}
					
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * M�todo que recupera un equipo de la tabla Equipos
	 * Signatura: public Equipo recuperarEquipo(String IDEquipo, Connection conexion)
	 * Entradas:
	 * 		- String IDEquipo
	 * 		- Connection conexion
	 * Precondiciones: No hay
	 * Salidas:
	 * 		- Equipo equipo
	 * Postcondiciones: En caso de exito en la recuperaci�n se devolver� un objeto Equipo con el equipo
	 * 					cuyo ID se ha pasado por par�metros, en caso contrario se devolver� null.
	 * 					Si existiera un problema con la conexion se lanzar� una excepci�n SQLException.
	 */
	public Equipo recuperarEquipo(String IDEquipo, Connection conexion)
	{
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		Equipo equipo = null;
		String nombreEquipo, ciudadEquipo, paisEquipo;
		
		try {
			
			if(conexion != null)
			{
				ps = conexion.prepareStatement("SELECT ID, Nombre, Ciudad, Pais FROM Equipos WHERE ID = (?)");
				
				ps.setString(1, IDEquipo);
				
				rs = ps.executeQuery();
				
				if(rs.next())
				{
					nombreEquipo = rs.getString(2);
					ciudadEquipo = rs.getString(3);
					paisEquipo = rs.getString(4);
					
					equipo = new Equipo(IDEquipo, nombreEquipo, ciudadEquipo, paisEquipo);
				}		
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return equipo;
	}
	
	/*
	 * M�todo que registra un equipo en la tabla Equipos
	 * Signatura: public void resgistrarEquipo(Equipo equipo, Connection conexion)
	 * Entradas:
	 * 		- Equipo equipo
	 * 		- Connection conexion
	 * Precondiciones:
	 * 		- El equipo debe ser un equipo no registrado
	 * Salidas: No hay
	 * Postcondiciones: Se registrar� el equipo pasado por par�metros
	 * 					a la tabla Equipos
	 */
	public void registrarEquipo(Equipo equipo, Connection conexion)
	{
		
		PreparedStatement ps = null;
		
		try {
			
			if(conexion != null)
			{
				ps = conexion.prepareStatement("INSERT INTO Equipos (ID, Nombre, Ciudad, Pais) VALUES (?, ?, ?, ?)");
				
	    		ps.setString(1, equipo.getID());
	    		ps.setString(2, equipo.getName());
	    		ps.setString(3, equipo.getCity());
	    		ps.setString(4, equipo.getCountry());
					
	    		ps.executeUpdate();	
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
