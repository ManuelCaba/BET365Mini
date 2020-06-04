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
	 * Método que comprueba si existe un equipo apostador con el ID pasado por parámetros
	 * Signatura: public boolean equipoRegistrado(String IDEquipo, Connection conexion)
	 * Entradas:
	 * 		- String IDEquipo
	 * 		- Connection conexion
	 * Precondiciones:
	 * 		- El ID del equipo debe ser un ID validado
	 * Salidas: 
	 * 		- boolean registrado
	 * Postcondiciones: Se devolverá un valor boolean asociado al nombre,
	 * 					true para equipo registrado y false en caso 
	 * 					contrario.
	 * 					Si existiera un problema con la conexion se lanzará una excepción SQLException.
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
	 * Método que lista todos los equipos de la tabla Equipos
	 * Signatura: public void listarEquipos(Connection conexion)
	 * Entradas:
	 * 		- Connection conexion
	 * Precondiciones: No hay
	 * Salidas: No hay
	 * Postcondiciones: Se mostrará una lista de todos los equipos de la tabla Equipos.
	 * 					Si existiera un problema con la conexion se lanzará una excepción SQLException.
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
	 * Método que recupera un equipo de la tabla Equipos
	 * Signatura: public Equipo recuperarEquipo(String IDEquipo, Connection conexion)
	 * Entradas:
	 * 		- String IDEquipo
	 * 		- Connection conexion
	 * Precondiciones: No hay
	 * Salidas:
	 * 		- Equipo equipo
	 * Postcondiciones: En caso de exito en la recuperación se devolverá un objeto Equipo con el equipo
	 * 					cuyo ID se ha pasado por parámetros, en caso contrario se devolverá null.
	 * 					Si existiera un problema con la conexion se lanzará una excepción SQLException.
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
	 * Método que registra un equipo en la tabla Equipos
	 * Signatura: public void resgistrarEquipo(Equipo equipo, Connection conexion)
	 * Entradas:
	 * 		- Equipo equipo
	 * 		- Connection conexion
	 * Precondiciones:
	 * 		- El equipo debe ser un equipo no registrado
	 * Salidas: No hay
	 * Postcondiciones: Se registrará el equipo pasado por parámetros
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
