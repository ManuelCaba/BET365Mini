package persistencias;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.GregorianCalendar;

import clasesbasicas.Apuesta;
import clasesbasicas.Partido;
import clasesbasicas.UsuarioApostador;

public class PersistenciaApuesta {
	/*
	 * Método que registra una apuesta en la tabla Apuestas
	 * Signatura: public void registrarApuesta(Apuesta apuesta, Connection conexion)
	 * Entradas:
	 * 		- Apuesta apuesta
	 * 		- Connection conexion
	 * Precondiciones:
	 * 		- La apuesta debe ser una apuesta no registrada
	 * Salidas: No hay
	 * Postcondiciones: Se registrará la apuesta pasada por parámetros
	 * 					a la tabla Apuestas
	 */
	public void registrarApuesta(Apuesta apuesta, Connection conexion)
	{
		
		PreparedStatement ps = null;
		
		try {
			
			if(conexion != null)
			{
				ps = conexion.prepareStatement("INSERT INTO Apuestas (DineroApostado, IDPartido, NickUsuario, Resultado) VALUES (?, ?, ?, ?)");
				
	    		ps.setDouble(1, apuesta.getCantidadApostada());
	    		ps.setInt(2, apuesta.getIDPartido());
	    		ps.setString(3, apuesta.getNickUsuario());
	    		ps.setString(4, Character.toString(apuesta.getApuesta()));
					
	    		ps.executeUpdate();	
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Método que comprueba si existe una apuesta con el ID pasado por parámetros
	 * Signatura: public boolean apuestaRegistrada(int IDApuesta, Connection conexion)
	 * Entradas:
	 * 		- int IDApuesta
	 * 		- Connection conexion
	 * Precondiciones:
	 * 		- El ID de la apuesta debe ser un ID validado
	 * Salidas: 
	 * 		- boolean registrada
	 * Postcondiciones: Se devolverá un valor boolean asociado al nombre,
	 * 					true para apuesta registrada y false en caso 
	 * 					contrario.
	 * 					Si existiera un problema con la conexion se lanzará una excepción SQLException.
	 */
	public boolean apuestaRegistrada(int IDApuesta, Connection conexion)
	{
		boolean registrada = false;

		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			
			if(conexion != null)
			{
				ps = conexion.prepareStatement("SELECT * FROM Apuestas WHERE ID = (?)");
				
				ps.setInt(1, IDApuesta);
				
				rs = ps.executeQuery();
					
				if(rs.next())
				{
					registrada = true;
				}
					
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return registrada;
	}
	
	/*
	 * Método que recupera una de la tabla Apuestas
	 * Signatura: public Apuesta recuperarApuesta(int IDApuesta, Connection conexion)
	 * Entradas:
	 * 		- int IDApuesta
	 * 		- Connection conexion
	 * Precondiciones: No hay
	 * Salidas:
	 * 		- Equipo equipo
	 * Postcondiciones: En caso de exito en la recuperación se devolverá un objeto Apuesta con la apuesta
	 * 					cuyo ID se ha pasado por parámetros, en caso contrario se devolverá null.
	 * 					Si existiera un problema con la conexion se lanzará una excepción SQLException.
	 */
	public Apuesta recuperarApuesta(int IDApuesta, Connection conexion)
	{
		PersistenciaPartido persistenciaPartido = new PersistenciaPartido();
		PersistenciaUsuarioApostador persistenciaUsuarioApostador = new PersistenciaUsuarioApostador();
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		Apuesta apuesta = null;
		
		try {
			
			if(conexion != null)
			{
				ps = conexion.prepareStatement("SELECT DineroApostado, IDPartido, NickUsuario, Resultado, Comprobada FROM Apuestas WHERE ID = (?)");
				
				ps.setInt(1, IDApuesta);
				
				rs = ps.executeQuery();
				
				if(rs.next())
				{
					apuesta = new Apuesta(IDApuesta, persistenciaUsuarioApostador.recuperarUsuarioApostador(rs.getString(3), conexion), 
							persistenciaPartido.recuperarPartido(rs.getInt(2), conexion), rs.getDouble(1), 
							rs.getString(4).charAt(0), rs.getBoolean(5));
				}		
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return apuesta;
	}
	
	/*
	 * Método que actualiza una apuesta de la tabla Apuestas a partir de un objeto Apuesta
	 * Signatura: public void actualizarApuesta(Apuesta apuesta, Connection conexion)
	 * Entradas:
	 * 		- Apuesta apuesta
	 * 		- Connection conexion
	 * Precondiciones:
	 * 		- La apuesta debe existir en la base de datos
	 * Salidas: No hay
	 * Postcondiciones: Se actualizará la apiuesta en la tabla Apuestas.
	 * 					Si existiera un problema con la conexion se lanzará una excepción SQLException.
	 */
	public void actualizarApuesta(Apuesta apuesta, Connection conexion)
	{
		
		PreparedStatement ps = null;
		
		try {
			
			if(conexion != null)
			{
				ps = conexion.prepareStatement("UPDATE Apuestas SET Comprobada = (?) WHERE ID = (?)");
				
				ps.setBoolean(1, apuesta.getComprobada());
				
				ps.setInt(2, apuesta.getID());
				
				ps.executeUpdate();	
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Método que lista todos las apuestas de un usuario de la tabla Apuestas
	 * Signatura: public void listarApuestas(String nickUsuario, Connection conexion)
	 * Entradas:
	 * 		- String nickUsuario
	 * 		- Connection conexion
	 * Precondiciones: No hay
	 * Salidas: No hay
	 * Postcondiciones: Se mostrará una lista de todos las apuestas de un usuario de la tabla Apuestas.
	 * 					Si existiera un problema con la conexion se lanzará una excepción SQLException.
	 */
	public void listarApuestas(String nickUsuario, Connection conexion)
	{
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			
			if(conexion != null)
			{
				ps = conexion.prepareStatement("SELECT ID, DineroApostado, IDPartido, Resultado, Comprobada FROM Apuestas WHERE NickUsuario = (?)");
				
				ps.setString(1, nickUsuario);
				
				rs = ps.executeQuery();
					
				while(rs.next())
				{
					System.out.println(rs.getInt(1)+" | "+rs.getDouble(2)+" | "+rs.getInt(3)+" | "+nickUsuario+" | "+rs.getString(4)+" | "+
									   rs.getBoolean(5));
				}
					
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Método que lista todos las apuestas de la tabla Apuestas según su comprobación
	 * Signatura: public void listarApuestas(boolean comprobada, Connection conexion)
	 * Entradas:
	 * 		- boolean comprobada
	 * 		- Connection conexion
	 * Precondiciones: No hay
	 * Salidas: No hay
	 * Postcondiciones: Se mostrará una lista de todos las apuestas de la tabla Apuestas según su comprobación.
	 * 					Si existiera un problema con la conexion se lanzará una excepción SQLException.
	 */
	public void listarApuestas(boolean comprobada, Connection conexion)
	{
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			
			if(conexion != null)
			{
				ps = conexion.prepareStatement("SELECT ID, DineroApostado, IDPartido, NickUsuario, Resultado, Comprobada FROM Apuestas WHERE Comprobada = (?)");
				
				ps.setBoolean(1, comprobada);
				
				rs = ps.executeQuery();
					
				while(rs.next())
				{
					System.out.println(rs.getInt(1)+" | "+rs.getDouble(2)+" | "+rs.getInt(3)+" | "+rs.getString(4)+" | "+rs.getString(5)+" | "+
									   rs.getBoolean(6));
				}
					
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Método que lista todos las apuestas de la tabla Apuestas
	 * Signatura: public void listarApuestas(Connection conexion)
	 * Entradas:
	 * 		- Connection conexion
	 * Precondiciones: No hay
	 * Salidas: No hay
	 * Postcondiciones: Se mostrará una lista de todos las apuestas de la tabla Apuestas.
	 * 					Si existiera un problema con la conexion se lanzará una excepción SQLException.
	 */
	public void listarApuestas(Connection conexion)
	{
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			
			if(conexion != null)
			{
				ps = conexion.prepareStatement("SELECT ID, DineroApostado, IDPartido, NickUsuario, Resultado, Comprobada FROM Apuestas");
				
				rs = ps.executeQuery();
					
				while(rs.next())
				{
					System.out.println(rs.getInt(1)+" | "+rs.getDouble(2)+" | "+rs.getInt(3)+" | "+rs.getString(4)+" | "+rs.getString(5)+" | "+
									   rs.getBoolean(6));
				}
					
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
