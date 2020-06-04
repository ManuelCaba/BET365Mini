package persistencias;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import clasesbasicas.Usuario;

public class PersistenciaUsuario {
	/*
	 * M�todo que comprueba si existe un usuario con el nick pasado
	 * por par�metros en la tabla Usuarios
	 * Signatura: public boolean usuarioRegistrado(String nickUsuario, Connection conexion)
	 * Entradas:
	 * 		- String nickUsuario
	 * 		- Connection conexion
	 * Precondiciones:
	 * 		- El nick de usuario debe ser un nick validado
	 * Salidas: 
	 * 		- boolean registrado
	 * Postcondiciones: Se devolver� un valor boolean asociado al nombre,
	 * 					true para usuario registrado y false en caso 
	 * 					contrario.
	 * 					Si existiera un problema con la conexion se lanzar� una excepci�n SQLException.
	 */
	public boolean usuarioRegistrado(String nickUsuario, Connection conexion)
	{
		boolean registrado = false;

		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			
			if(conexion != null)
			{
				ps = conexion.prepareStatement("SELECT * FROM Usuarios WHERE Nick = (?)");
				
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
	 * M�todo que registra un usuario
	 * Signatura: public void registrarUsuario(Usuario usuario, Connection conexion)
	 * Entradas:
	 * 		- Usuario usuario
	 * 		- Connection conexion
	 * Precondiciones:
	 * 		- El usuario debe ser un usuario no registrado
	 * Salidas: No hay
	 * Postcondiciones: Se registrar� el usuario pasado por par�metros
	 * 					a la tabla Usuarios.
	 * 					Si existiera un problema con la conexion se lanzar� una excepci�n SQLException.
	 */
	public void registrarUsuario(Usuario usuario, Connection conexion)
	{
		
		PreparedStatement ps = null;
		
		try {
			
			if(conexion != null)
			{
				ps = conexion.prepareStatement("INSERT INTO Usuarios (Nick, Contrase�a) VALUES (?,?)");
				
	    		ps.setString(1, usuario.getNick());
	    		ps.setString(2, usuario.getPassword());
					
	    		ps.executeUpdate();	
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * M�todo que inicia sesi�n de un usuario, devolver� un objeto Usuario
	 * Signatura: public Usuario inicioSesion(String nickUsuario, String passwordUsuario, Connection conexion)
	 * Entradas:
	 * 		- String nickUsuario
	 * 		- String passwordUsuario
	 * 		- Connection conexion
	 * Precondiciones: No hay
	 * Salidas:
	 * 		- Usuario usuario
	 * Postcondiciones: En caso de exito en el inicio de sesion se devolver� un objeto Usuario con el usuaro registrado,
	 * 					en caso contrario se devolver� null.
	 * 					Si existiera un problema con la conexion se lanzar� una excepci�n SQLException.
	 */
	public Usuario inicioSesion(String nickUsuario, String passwordUsuario, Connection conexion)
	{
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		Usuario usuario = null;
		
		try {
			
			if(conexion != null)
			{
				ps = conexion.prepareStatement("SELECT Nick, Contrase�a FROM Usuarios WHERE Nick = (?) AND Contrase�a = (?)");
				
				ps.setString(1, nickUsuario);
				ps.setString(2, passwordUsuario);
				
				rs = ps.executeQuery();
					
				if(rs.next())
				{
					usuario = new Usuario(nickUsuario, passwordUsuario);
				}	
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return usuario;
	}
	
	/*
	 * M�todo que actualiza un usuario de la tabla Usuarios a partir de un objeto Usuario
	 * Signatura: public void actualizarUsuario(Usuario usuario, Connection conexion)
	 * Entradas:
	 * 		- Usuario usuario
	 * 		- Connection conexion
	 * Precondiciones:
	 * 		- El usuario debe existir en la base de datos
	 * Salidas: No hay
	 * Postcondiciones: Se actualizar� el usuario en la tabla Usuarios.
	 * 					Si existiera un problema con la conexion se lanzar� una excepci�n SQLException.
	 */
	public void actualizarUsuario(Usuario usuario, Connection conexion)
	{
		
		PreparedStatement ps = null;
		
		try {
			
			if(conexion != null)
			{
				ps = conexion.prepareStatement("UPDATE Usuarios SET Contrase�a = (?) WHERE Nick = (?)");
				
				ps.setString(1, usuario.getPassword());
				ps.setString(2, usuario.getNick());
				
				ps.executeUpdate();	
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
