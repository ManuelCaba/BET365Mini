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
import validaciones.ValidacionesMenu;

public class TestGeneral {

	public static void main(String[] args) {
		String sourceURL = "jdbc:sqlserver://localhost";
		String usuarioSQL = "myuserid";
		String password = "prueba";
		
		PersistenciaPartido pp = new PersistenciaPartido();
		PersistenciaEquipo pe = new PersistenciaEquipo();
		PersistenciaUsuarioApostador pup = new PersistenciaUsuarioApostador();
		PersistenciaClasificaciones pc = new PersistenciaClasificaciones();
		PersistenciaApuesta pa = new PersistenciaApuesta();
		
		ValidacionesMenu vm = new ValidacionesMenu();
		
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
				//vm.mostrarMenuRegistroYLeerYValidarOpcion();
				//vm.mostrarMenuAplicacionYLeerYValidarOpcion();
				//vm.mostrarMenuConfiguracionesYLeerYValidarOpcion();
				//vm.mostrarMenuConfiguracionesUsuarioYLeerYValidarOpcion();
				//vm.mostrarMenuConfiguracionesPartidoYLeerYValidarOpcion();
				//vm.mostrarMenuActualizarCuotasYLeerYValidarOpcion();
				//vm.mostrarMenuApuestasYLeerYValidarOpcion();
				//vm.mostrarMenuListasYLeerYValidarOpcion();
				//vm.mostrarMenuListasUsuariosYLeerYValidarOpcion();
				//vm.mostrarMenuListasClasificacionesYLeerYValidarOpcion();
				//vm.mostrarMenuListasPartidosYLeerYValidarOpcion();
				vm.mostrarMenuListasApuestasYLeerYValidarOpcion();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
