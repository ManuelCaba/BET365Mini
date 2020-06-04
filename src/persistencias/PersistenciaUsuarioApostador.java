package persistencias;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.GregorianCalendar;

import clasesbasicas.Usuario;
import clasesbasicas.UsuarioApostador;

public class PersistenciaUsuarioApostador {
	/*
	 * Método que registra un usuario apostador
	 * Signatura: public void registrarUsuarioApostador(UsuarioApostador usuarioApostador, Connection conexion)
	 * Entradas:
	 * 		- UsuarioApostador usuarioApostador
	 * 		- Connection conexion
	 * Precondiciones:
	 * 		- El usuario apostador debe ser un usuario no registrado
	 * Salidas: No hay
	 * Postcondiciones: Se registrará el usuario apostador pasado por parámetros
	 * 					a la tabla UsuariosApostadores
	 */
	public void registrarUsuarioApostador(UsuarioApostador usuarioApostador, Connection conexion)
	{
		
		PreparedStatement ps = null;
		
		try {
			
			if(conexion != null)
			{
				ps = conexion.prepareStatement("INSERT INTO UsuariosApostadores (Nick) VALUES (?)");
				
	    		ps.setString(1, usuarioApostador.getNick());
					
	    		ps.executeUpdate();	
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Método que comprueba si existe un usuario apostador con el nick pasado
	 * por parámetros
	 * Signatura: public boolean usuarioApostadorRegistrado(String nickUsuario)
	 * Entradas:
	 * 		- String nickUsuarioApostador
	 * 		- Connection conexion
	 * Precondiciones:
	 * 		- El nick de usuario apostador debe ser un nick validado
	 * Salidas: 
	 * 		- boolean registrado
	 * Postcondiciones: Se devolverá un valor boolean asociado al nombre,
	 * 					true para usuario registrado y false en caso 
	 * 					contrario.
	 * 					Si existiera un problema con la conexion se lanzará una excepción SQLException.
	 */
	public boolean usuarioApostadorRegistrado(String nickUsuario, Connection conexion)
	{
		boolean registrado = false;

		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			
			if(conexion != null)
			{
				ps = conexion.prepareStatement("SELECT * FROM UsuariosApostadores WHERE Nick = (?)");
				
				ps.setString(1, nickUsuario);
				
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
	 * Método que recupera un usuario apostador de la tabla UsuariosApostadores
	 * Signatura: public UsuarioApostador recuperarUsuarioApostador(String nickUsuario, Connection conexion)
	 * Entradas:
	 * 		- String nickUsuario
	 * 		- Connection conexion
	 * Precondiciones: No hay
	 * Salidas:
	 * 		- UsuarioApostador usuarioApostador
	 * Postcondiciones: En caso de exito en la recuperación se devolverá un objeto UsuarioApostador con el usuario
	 * 					cuyo nick se ha pasado por parámetros, en caso contrario se devolverá null.
	 * 					Si existiera un problema con la conexion se lanzará una excepción SQLException.
	 */
	public UsuarioApostador recuperarUsuarioApostador(String nickUsuario, Connection conexion)
	{
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		UsuarioApostador usuarioApostador = null;
		String password;
		double balance = 0;
		GregorianCalendar startingDate = new GregorianCalendar();
		GregorianCalendar endingDate = new GregorianCalendar();
		Date endingDateAux = null;
		
		try {
			
			if(conexion != null)
			{
				ps = conexion.prepareStatement("SELECT * FROM Usuarios WHERE Nick = (?)");
				
				ps.setString(1, nickUsuario);
				
				rs = ps.executeQuery();
				
				if(rs.next())
				{
					password = rs.getString(2);
					
					ps = conexion.prepareStatement("SELECT Nick, Saldo, FechaAlta, FechaBaja FROM UsuariosApostadores WHERE Nick = (?)");
					
					ps.setString(1, nickUsuario);
					
					rs = ps.executeQuery();
					
					if(rs.next())
					{
						balance = rs.getDouble(2);
						
						startingDate.setTime(rs.getDate(3));
						
						endingDateAux = rs.getDate(4);
						
						if(endingDateAux != null)
						{
							endingDate.setTime(rs.getDate(4));
						}
						else
						{
							endingDate = null;
						}
						
						usuarioApostador = new UsuarioApostador(nickUsuario, password, balance, startingDate, endingDate);
					}
				}		
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return usuarioApostador;
	}
	
	/*
	 * Método que actualiza un usuario apostador de la tabla UsuariosApostadores a partir de un objeto UsuarioApostador
	 * Signatura: public void actualizarUsuarioApostador(UsuarioApostador usuarioApostador, Connection conexion)
	 * Entradas:
	 * 		- UsuarioApostador usuarioApostador
	 * 		- Connection conexion
	 * Precondiciones:
	 * 		- El usuario apostador debe existir en la base de datos
	 * Salidas: No hay
	 * Postcondiciones: Se actualizará el usuario en la tabla UsuariosApostadores.
	 * 					Si existiera un problema con la conexion se lanzará una excepción SQLException.
	 */
	public void actualizarUsuarioApostador(UsuarioApostador usuarioApostador, Connection conexion)
	{
		
		PreparedStatement ps = null;
		GregorianCalendar endingDate = usuarioApostador.getEndingDate();
		
		try {
			
			if(conexion != null)
			{
				ps = conexion.prepareStatement("UPDATE UsuariosApostadores SET Saldo = (?), FechaBaja = (?) WHERE Nick = (?)");
				
				ps.setDouble(1, usuarioApostador.getBalance());
				
				if(endingDate != null)
				{
					ps.setDate(2, new Date(usuarioApostador.getEndingDate().getTime().getTime()));
				}
				else
				{
					ps.setDate(2, null);
				}
				
				ps.setString(3, usuarioApostador.getNick());
				
				ps.executeUpdate();	
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Método que lista todos los usuarios de la tabla UsuariosApostadores
	 * Signatura: public void listarUsuarios(Connection conexion)
	 * Entradas:
	 * 		- Connection conexion
	 * Precondiciones: No hay
	 * Salidas: No hay
	 * Postcondiciones: Se mostrará una lista de todos los usuarios de la tabla UsuariosApostadores.
	 * 					Si existiera un problema con la conexion se lanzará una excepción SQLException.
	 */
	public void listarUsuarios(Connection conexion)
	{
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String usuarioApostador;
		
		try {
			
			if(conexion != null)
			{
				ps = conexion.prepareStatement("SELECT Nick, Saldo, FechaAlta, FechaBaja FROM UsuariosApostadores");
				
				rs = ps.executeQuery();
					
				while(rs.next())
				{
					usuarioApostador = rs.getString(1)+" | "+rs.getDouble(2)+" | "+rs.getDate(3)+" | ";
					
					if(rs.getDate(4) != null)
					{
						usuarioApostador += rs.getDate(4);
					}
					else
					{
						usuarioApostador += "null";
					}
					
					System.out.println(usuarioApostador);

				}
					
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Método que lista todos los usuarios de la tabla UsuariosApostadores según el estado de alta.
	 * Signatura: public void listarUsuarios(Boolean alta, Connection conexion)
	 * Entradas:
	 * 		- Connection conexion
	 * Precondiciones: No hay
	 * Salidas: No hay
	 * Postcondiciones: Se mostrará una lista de todos los usuarios de la tabla UsuariosApostadores según su estado de alta.
	 * 					Si existiera un problema con la conexion se lanzará una excepción SQLException.
	 */
	public void listarUsuarios(Boolean alta, Connection conexion)
	{
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String usuarioApostador;
		
		try {
			
			if(conexion != null)
			{
				if(alta)
				{
					ps = conexion.prepareStatement("SELECT Nick, Saldo, FechaAlta, FechaBaja FROM UsuariosApostadores WHERE FechaBaja IS NULL");
				}
				else
				{
					ps = conexion.prepareStatement("SELECT Nick, Saldo, FechaAlta, FechaBaja FROM UsuariosApostadores WHERE FechaBaja IS NOT NULL");
				}	
				rs = ps.executeQuery();
					
				while(rs.next())
				{
					usuarioApostador = rs.getString(1)+" | "+rs.getDouble(2)+" | "+rs.getDate(3)+" | ";
					
					if(rs.getDate(4) != null)
					{
						usuarioApostador += rs.getDate(4);
					}
					else
					{
						usuarioApostador += "null";
					}
					
					System.out.println(usuarioApostador);

				}
					
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
