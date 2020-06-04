package persistencias;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import clasesbasicas.Usuario;

public class PersistenciaUsuario {
	/*
	 * Método que comprueba si existe un usuario con el nick pasado
	 * por parámetros en la tabla Usuarios
	 * Signatura: public boolean usuarioRegistrado(String nickUsuario, Connection conexion)
	 * Entradas:
	 * 		- String nickUsuario
	 * 		- Connection conexion
	 * Precondiciones:
	 * 		- El nick de usuario debe ser un nick validado
	 * Salidas: 
	 * 		- boolean registrado
	 * Postcondiciones: Se devolverá un valor boolean asociado al nombre,
	 * 					true para usuario registrado y false en caso 
	 * 					contrario.
	 * 					Si existiera un problema con la conexion se lanzará una excepción SQLException.
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
	 * Método que registra un usuario
	 * Signatura: public void registrarUsuario(Usuario usuario, Connection conexion)
	 * Entradas:
	 * 		- Usuario usuario
	 * 		- Connection conexion
	 * Precondiciones:
	 * 		- El usuario debe ser un usuario no registrado
	 * Salidas: No hay
	 * Postcondiciones: Se registrará el usuario pasado por parámetros
	 * 					a la tabla Usuarios.
	 * 					Si existiera un problema con la conexion se lanzará una excepción SQLException.
	 */
	public void registrarUsuario(Usuario usuario, Connection conexion)
	{
		
		PreparedStatement ps = null;
		
		try {
			
			if(conexion != null)
			{
				ps = conexion.prepareStatement("INSERT INTO Usuarios (Nick, Contraseña) VALUES (?,?)");
				
	    		ps.setString(1, usuario.getNick());
	    		ps.setString(2, usuario.getPassword());
					
	    		ps.executeUpdate();	
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Método que inicia sesión de un usuario, devolverá un objeto Usuario
	 * Signatura: public Usuario inicioSesion(String nickUsuario, String passwordUsuario, Connection conexion)
	 * Entradas:
	 * 		- String nickUsuario
	 * 		- String passwordUsuario
	 * 		- Connection conexion
	 * Precondiciones: No hay
	 * Salidas:
	 * 		- Usuario usuario
	 * Postcondiciones: En caso de exito en el inicio de sesion se devolverá un objeto Usuario con el usuaro registrado,
	 * 					en caso contrario se devolverá null.
	 * 					Si existiera un problema con la conexion se lanzará una excepción SQLException.
	 */
	public Usuario inicioSesion(String nickUsuario, String passwordUsuario, Connection conexion)
	{
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		Usuario usuario = null;
		
		try {
			
			if(conexion != null)
			{
				ps = conexion.prepareStatement("SELECT Nick, Contraseña FROM Usuarios WHERE Nick = (?) AND Contraseña = (?)");
				
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
	 * Método que actualiza un usuario de la tabla Usuarios a partir de un objeto Usuario
	 * Signatura: public void actualizarUsuario(Usuario usuario, Connection conexion)
	 * Entradas:
	 * 		- Usuario usuario
	 * 		- Connection conexion
	 * Precondiciones:
	 * 		- El usuario debe existir en la base de datos
	 * Salidas: No hay
	 * Postcondiciones: Se actualizará el usuario en la tabla Usuarios.
	 * 					Si existiera un problema con la conexion se lanzará una excepción SQLException.
	 */
	public void actualizarUsuario(Usuario usuario, Connection conexion)
	{
		
		PreparedStatement ps = null;
		
		try {
			
			if(conexion != null)
			{
				ps = conexion.prepareStatement("UPDATE Usuarios SET Contraseña = (?) WHERE Nick = (?)");
				
				ps.setString(1, usuario.getPassword());
				ps.setString(2, usuario.getNick());
				
				ps.executeUpdate();	
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
