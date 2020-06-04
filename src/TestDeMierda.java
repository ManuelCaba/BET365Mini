import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.GregorianCalendar;

import clasesbasicas.Equipo;
import clasesbasicas.UsuarioApostador;
import persistencias.PersistenciaApuesta;
import persistencias.PersistenciaClasificaciones;
import persistencias.PersistenciaEquipo;
import persistencias.PersistenciaPartido;
import persistencias.PersistenciaUsuarioApostador;

public class TestDeMierda {

	public static void main(String[] args) {
		String sourceURL = "jdbc:sqlserver://localhost";
		String usuarioSQL = "myuserid";
		String password = "prueba";
		
		PersistenciaPartido pp = new PersistenciaPartido();
		PersistenciaEquipo pe = new PersistenciaEquipo();
		PersistenciaUsuarioApostador pup = new PersistenciaUsuarioApostador();
		PersistenciaClasificaciones pc = new PersistenciaClasificaciones();
		PersistenciaApuesta pa = new PersistenciaApuesta();
		
		try {
			Connection conexion = DriverManager.getConnection(sourceURL, usuarioSQL, password);
			
			if(conexion != null)
			{
				//pe.listarEquipos(conexion);
				//pp.listarPartidos(conexion);
				//System.out.println(pp.recuperarPartido(1, conexion));
				//pup.listarUsuarios(conexion);
				//pc.listarClasificacion(false, conexion);
				//pp.listarPartidos(false, conexion);
				//pp.listarPartidos("GTFE", conexion);
				//pa.listarApuestas(true, conexion);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
