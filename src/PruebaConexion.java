import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PruebaConexion {

	public static void main(String[] args) {
		String sourceURL = "jdbc:sqlserver://localhost";
		String usuario = "myuserid";
		String password = "prueba";
		
		try {
			Connection conexionBaseDatos = DriverManager.getConnection(sourceURL, usuario, password);
			
			if(conexionBaseDatos != null)
			{
				System.out.println("Se ha establecido una conexion");
				
				conexionBaseDatos.close();
				
				System.out.println("Y se cerro");
			}
			else
			{
				System.out.println("Vaya F");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

		

	}

}
