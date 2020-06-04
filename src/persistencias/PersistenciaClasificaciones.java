package persistencias;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersistenciaClasificaciones {
	/*
	 * Método que lista la clasificación general de todos los equipos
	 * Signatura: public void listarClasificacion(Connection conexion)
	 * Entradas:
	 * 		- Connection conexion
	 * Precondiciones: No hay
	 * Salidas: No hay
	 * Postcondiciones: Se mostrará una lista de la clasificacion.
	 * 					Si existiera un problema con la conexion se lanzará una excepción SQLException.
	 */
	public void listarClasificacion(Connection conexion)
	{
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			
			if(conexion != null)
			{
				ps = conexion.prepareStatement("SELECT ROW_NUMBER() OVER(ORDER BY Puntos DESC, DiferenciaGoles DESC, GolesFavor DESC, "
						+ "PartidosGanadosVisitante DESC, GolesFavorVisitante),IDEquipo, NombreEquipo, PartidosJugados, PartidosGanados, "
						+ "PartidosEmpatados, PartidosPerdidos, GolesFavor, GolesContra, DiferenciaGoles, Puntos FROM Clasificacion");
				
				rs = ps.executeQuery();
				
				System.out.println("Posicion | IDEquipo | NombreEquipo | PartidosJugados | PartidosGanados | PartidosEmpatados | PartidosPerdidos"
						+ " | GolesFavor | GolesContra | DiferenciaGoles | Puntos\n");
				
				while(rs.next())
				{
					System.out.println(rs.getInt(1)+" | "+rs.getString(2)+" | "+rs.getString(3)+" | "+rs.getInt(4)+" | "+rs.getString(5)+" | "+
					+rs.getInt(6)+" | "+rs.getInt(7)+" | "+rs.getInt(8)+" | "+rs.getString(9)+" | "+rs.getInt(10)+" | "+rs.getString(11)); 
				}
					
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Método que lista la clasificación local o visitante de todos los equipos
	 * Signatura: public void listarClasificacion(boolean local, Connection conexion)
	 * Entradas:
	 * 		- boolean local
	 * 		- Connection conexion
	 * Precondiciones: No hay
	 * Salidas: No hay
	 * Postcondiciones: Se mostrará una lista de la clasificacion, true para local y false para visitante.
	 * 					Si existiera un problema con la conexion se lanzará una excepción SQLException.
	 */
	public void listarClasificacion(boolean local, Connection conexion)
	{
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			
			if(conexion != null)
			{
				ps = conexion.prepareStatement("SELECT * FROM ClasificacionesEspecificas WHERE [Local/Visitante] = (?) ORDER BY Posicion");
				
				ps.setBoolean(1, local);
				
				rs = ps.executeQuery();
				
				System.out.println("Posicion | IDEquipo | NombreEquipo | PartidosJugados | PartidosGanados | PartidosEmpatados | PartidosPerdidos"
						+ " | GolesFavor | GolesContra | DiferenciaGoles | Puntos\n");
				
				while(rs.next())
				{
					System.out.println(rs.getInt(1)+" | "+rs.getString(2)+" | "+rs.getString(3)+" | "+rs.getInt(4)+" | "+rs.getString(5)+" | "+
					+rs.getInt(6)+" | "+rs.getInt(7)+" | "+rs.getInt(8)+" | "+rs.getString(9)+" | "+rs.getInt(10)+" | "+rs.getString(11)); 
				}
					
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
