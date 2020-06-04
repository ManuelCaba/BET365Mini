package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.GregorianCalendar;

import clasesbasicas.Apuesta;
import clasesbasicas.Equipo;
import clasesbasicas.Partido;
import clasesbasicas.Usuario;
import clasesbasicas.UsuarioApostador;
import excepciones.CuoteException;
import excepciones.EndingDateException;
import excepciones.NegativeNumberException;
import excepciones.PasswordException;
import persistencias.PersistenciaApuesta;
import persistencias.PersistenciaClasificaciones;
import persistencias.PersistenciaEquipo;
import persistencias.PersistenciaPartido;
import persistencias.PersistenciaUsuario;
import persistencias.PersistenciaUsuarioApostador;
import validaciones.ValidacionesApuesta;
import validaciones.ValidacionesEquipo;
import validaciones.ValidacionesMenu;
import validaciones.ValidacionesPartido;
import validaciones.ValidacionesUsuario;


/*
 * PG
 * Inicio
 * 	mostrarMenuRegistroYLeerYValidarOpcion*
 * 	Mientras quiera registrar
 * 		Leer Y Validar Usuario Apostador
 * 		registrarUsuario*
 * 		mostrarMenuRegistroYLeerYValidarOpcion*
 * 	Fin_Mientras
 * 	Si no elige salir
 * 		leerYValidarNickUsuario*
 * 		validarUsuario*
 * 		mostrarMenuAplicacionYLeerYValidarOpcion*
 * 		Mientras quiera realizar una opcion
 * 			Segun opcion
 * 				caso 1:
 * 					Menu Configuraciones
 * 				caso 2:
 * 					Menu Listas
 * 				caso 3:
 * 					Menu Apuestas
 * 			Fin_Segun
 * 			mostrarMenuAplicacionYLeerYValidarOpcion*
 * 		Fin_Mientras
 * 	Fin_Si
 * Fin
 * 
 * Menu Configuraciones
 * Inicio
 * 	mostrarMenuConfiguracionesYLeerYValidarOpcion*
 * 	Mientras quiera realizar una configuración
 * 		Segun opcion
 * 			caso 1:
 * 				Configuraciones Usuario
 * 			caso 2:
 * 				Configuraciones Partido
 * 			caso 3:
 * 				Registrar Equipo
 * 		Fin_Segun
 * 		mostrarMenuConfiguracionesYLeerYValidarOpcion*
 * 	Fin_Mientras
 * Fin
 * 
 * Configuraciones Usuario
 * Inicio
 * 	mostrarMenuConfiguracionesUsuarioYLeerYValidarOpcion*
 * 	Mientras quiera realizar una configuración
 * 		Segun opcion
 * 			caso 1:
 * 				Modificar Password
 * 			caso 2:
 * 				Ingresar Dinero
 * 			caso 3:
 * 				Retirar Dinero
 * 			caso 4:
 * 				Solicitar Baja
 * 		Fin_Segun
 * 		mostrarMenuConfiguracionesUsuarioYLeerYValidarOpcion*
 * 	Fin_Mientras
 * Fin
 * 
 * Configuraciones Partido
 * Inicio
 * 	mostrarMenuConfiguracionesPartidoYLeerYValidarOpcion*
 * 	Mientras quiera realizar una configuración
 * 		Segun opcion
 * 			caso 1:
 * 				Registrar Partido
 * 			caso 2:
 * 				Actualizar Cuotas
 * 			caso 3:
 * 				Finalizar Partido
 * 			caso 4:
 * 				Aplazar Partido
 * 		Fin_Segun
 * 		mostrarMenuConfiguracionesPartidoYLeerYValidarOpcion*
 * 	Fin_Mientras
 * Fin
 * 
 * ActualizarCuotas
 * Inicio
 * 	mostrarMenuActualizarCuotasYLeerYValidarOpcion*
 * 	Mientras quiera actualizar las cuotas de un partido
 * 		Leer Y Validar Partido
 * 		Segun opcion
 * 			caso 1:
 * 				Actualizar Cuota Local
 * 			caso 2:
 * 				Actualizar Cuota Empate
 * 			caso 3:
 * 				Actualizar Cuota Visitante
 * 			caso 4:
 * 				Actualizar Cuotas
 * 		Fin_Segun
 * 		mostrarMenuActualizarCuotasYLeerYValidarOpcion*
 * 	Fin_Mientras
 * Fin
 * 
 * Menu Apuestas
 * Inicio
 * 	mostrarMenuApuestasYLeerYValidarOpcion*
 * 	Mientras quiera realizar una opción apuesta
 * 		Segun opcion
 * 			caso 1:
 * 				Realizar Apuesta
 * 			caso 2:
 * 				Comprobar Apuesta
 * 		Fin_Segun
 * 		mostrarMenuApuestasYLeerYValidarOpcion*
 * 	Fin_Mientras
 * Fin
 * 
 * Menu Listas
 * Inicio
 * 	mostrarMenuListasYLeerYValidarOpcion*
 * 		Mientras se quiera listar
 * 			Segun opcion
 * 				caso 1:
 * 					Listas Usuarios
 * 				caso 2:
 * 					Lista Equipos*
 * 				caso 3:
 * 					Listas Clasificaciones
 * 				caso 4:
 * 					Listas Partidos
 * 				caso 5:
 * 					Listas Apuestas
 * 			Fin_Segun
 * 		mostrarMenuListasYLeerYValidarOpcion*
 * 		Fin_Mientras
 * Fin 
 * 
 * Listas Usuarios
 * Inicio
 * 	mostrarMenuListasUsuariosYLeerYValidarOpcion*
 * 		Mientras se quiera listar usuarios
 * 			Segun opcion
 * 				caso 1:
 * 					Lista Usuarios*
 * 				caso 2:
 * 					Lista Usuarios Alta*
 * 				caso 3:
 * 					Lista Usuarios Baja*
 * 			Fin_Segun
 * 		mostrarMenuListasUsuariosYLeerYValidarOpcion*
 * 		Fin_Mientras
 * Fin 
 * 
 * Listas Clasificaciones
 * Inicio
 * 	mostrarMenuListasClasificacionesYLeerYValidarOpcion*
 * 		Mientras se quiera listar clasificaciones
 * 			Segun opcion
 * 				caso 1:
 * 					Lista Clasificacion*
 * 				caso 2:
 * 					Lista Clasificacion Local*
 * 				caso 3:
 * 					Lista Clasificacion Visitante*
 * 			Fin_Segun
 * 		mostrarMenuListasClasificacionesYLeerYValidarOpcion*
 * 		Fin_Mientras
 * Fin 
 * 
 * Listas Partidos
 * Inicio
 * 	mostrarMenuListasPartidosYLeerYValidarOpcion*
 * 		Mientras se quiera listar partidos
 * 			Segun opcion
 * 				caso 1:
 * 					Lista Partidos*
 * 				caso 2:
 * 					Lista Partidos Finalizados*
 * 				caso 3:
 * 					Lista Partidos No Finalizados*
 * 				caso 4:
 * 					Lista Partidos Equipo*
 * 			Fin_Segun
 * 		mostrarMenuListasPartidosYLeerYValidarOpcion*
 * 		Fin_Mientras
 * Fin 
 * 
 * Listas Apuestas
 * Inicio
 * 	mostrarMenuListasApuestasYLeerYValidarOpcion*
 * 		Mientras se quiera listar apuestas
 * 			Segun opcion
 * 				caso 1:
 * 					Lista Apuestas*
 * 				caso 2:
 * 					Lista Apuestas Comprobadas*
 * 				caso 3:
 * 					Lista Apuestas No Comprobadas*
 * 				caso 4:
 * 					Listas Apuestas Usuario*
 * 			Fin_Segun
 * 		mostrarMenuListasPartidosYLeerYValidarOpcion*
 * 		Fin_Mientras
 * Fin 
 */


public class ApuestasFutbol {
    public static void main(String[] args) {
    	
    	ValidacionesMenu validacionesMenu = new ValidacionesMenu();
    	ValidacionesUsuario validacionesUsuario = new ValidacionesUsuario();
    	ValidacionesEquipo validacionesEquipo = new ValidacionesEquipo();
    	ValidacionesPartido validacionesPartido = new ValidacionesPartido();
    	ValidacionesApuesta validacionesApuesta = new ValidacionesApuesta();
    	PersistenciaUsuario persistenciaUsuario = new PersistenciaUsuario();
    	PersistenciaUsuarioApostador persistenciaUsuarioApostador = new PersistenciaUsuarioApostador();
    	PersistenciaEquipo persistenciaEquipo = new PersistenciaEquipo();
    	PersistenciaPartido persistenciaPartido = new PersistenciaPartido();
    	PersistenciaApuesta persistenciaApuesta = new PersistenciaApuesta();
    	PersistenciaClasificaciones persistenciaClasificaciones = new PersistenciaClasificaciones();
    	
    	UsuarioApostador usuarioApostador = null;
    	Usuario usuario = null;
    	Equipo equipoLocal, equipoVisitante = null;
    	Apuesta apuesta = null;
    	GregorianCalendar fechaPartido = null;
    	Partido partido = null, partidoAplazado = null;
    	
    	char apuestaEquipo;
    	int opcion, IDPartido, golesLocal, golesVisitante, IDApuesta;
    	double cantidadDinero, cuotaLocal, cuotaEmpate, cuotaVisitante, importeApuesta, cantidadGanada;
    	String nickUsuario, passwordUsuario, IDEquipoLocal, IDEquipoVisitante, nombreEquipo, ciudadEquipo, paisEquipo;
    	
    	boolean esUsuario = false, esUsuarioApostador = false, partidoFinalizado = false;
    	
		String sourceURL = "jdbc:sqlserver://localhost";
		String usuarioSQL = "myuserid";
		String password = "prueba";
		
		try {
			Connection conexion = DriverManager.getConnection(sourceURL, usuarioSQL, password);
			
			if(conexion != null)
			{
				System.out.println("Se ha establecido una conexion");
				
		    	//mostrarMenuRegistroYLeerYValidarOpcion*
		    	opcion = validacionesMenu.mostrarMenuRegistroYLeerYValidarOpcion();
		    	
		    	System.out.println();
		    	
		    	while(opcion == 1) //Mientras quiera registrar
		    	{
		    		//Leer Y Validar Usuario Apostador
		    		do
		    		{
		    			System.out.println("\nEscribe salir si no desea introducir un usuario\n");
		    			nickUsuario = validacionesUsuario.leerYValidarNickUsuario();	
		    		}
		    		while(persistenciaUsuario.usuarioRegistrado(nickUsuario, conexion));
		    		
		    		if(!nickUsuario.equals("salir")) //Si no ha elegido salir
		    		{
			    		passwordUsuario = validacionesUsuario.leerYValidarPasswordUsuario();
			    		
			    		//Crear Usuario
			    		usuarioApostador = new UsuarioApostador(nickUsuario, passwordUsuario);
			    		
			    		//Registrar Usuario
			    		persistenciaUsuario.registrarUsuario(usuarioApostador, conexion);
			    		persistenciaUsuarioApostador.registrarUsuarioApostador(usuarioApostador, conexion);
			    		
			    		System.out.println("\nUsuario registrado con exito\n");
		    		}
		    		
			    	//mostrarMenuRegistroYLeerYValidarOpcion*
			    	opcion = validacionesMenu.mostrarMenuRegistroYLeerYValidarOpcion();	
		    	}
		    	
		    	if(opcion != 0)
		    	{
		    		System.out.println();
		    		
		    		if(opcion == 2) //Entrar como usuario
		    		{
		    			//Leer y Validar Nick Usuario
		    			nickUsuario = validacionesUsuario.leerYValidarNickUsuario();
		    			
		    			if(persistenciaUsuario.usuarioRegistrado(nickUsuario, conexion)) //Si es un usuario registrado
		    			{
		    				//Leer y Validar Password
		    				passwordUsuario = validacionesUsuario.leerYValidarPasswordUsuario();
		    				
		    				//Inicio Sesión
		    				usuario = persistenciaUsuario.inicioSesion(nickUsuario, passwordUsuario, conexion);
		    				
		    				System.out.println();
		    				
		    				if(usuario != null) //Si se ha realizado el inicio de sesión con éxito
		    				{
		    					if(persistenciaUsuarioApostador.usuarioApostadorRegistrado(nickUsuario, conexion)) //Si es un usuario apostador
		    					{
		    						//recuperarUsuarioApostador
		    						usuarioApostador = persistenciaUsuarioApostador.recuperarUsuarioApostador(nickUsuario, conexion);
		    								    						
		    						if(usuarioApostador.getEndingDate() == null) //Si el usuario no está dado de baja
		    						{
			    						esUsuarioApostador = true;
			    						
			    						System.out.println("Ha iniciado sesion como usuario apostador");
		    						}
		    						else
		    						{
		    							System.out.println("El usuario al que deseas acceder esta dado de baja.\nIniciara sesion commo usuario anonimo");
		    						}

		    					}
		    					else
		    					{
		    						System.out.println("Ha iniciado sesion como administrador");
		    					}
		    					
		    					esUsuario = true;
		    				}
		    				else
		    				{
		    					System.out.println("Error en el inicio de sesion. Ha iniciado sesion como usuario anonimo");
		    				}
		    			}
		    			else
		    			{
		    				System.out.println("\nError en el inicio de sesion. Ha iniciado sesion como usuario anonimo");
		    			}
		    			
		    			System.out.println();
		    		}
		    		
		    		//mostrarMenuAplicacionYLeerYValidarOpcion*
		    		opcion = validacionesMenu.mostrarMenuAplicacionYLeerYValidarOpcion();
		    		
		    		while(opcion != 0) //Mientras no quiera salir
		    		{
		    			System.out.println();
		    			
			    		switch(opcion)
			    		{
			    			case 1:
			    				
			    				//Menu Configuraciones
			    				
			    				if(esUsuario) //Si es un usuario registrado
			    				{
				    				//mostrarMenuConfiguracionesYLeerYValidarOpcion*
				    				opcion = validacionesMenu.mostrarMenuConfiguracionesYLeerYValidarOpcion();
				    				
				    				while(opcion != 0) //Mientras quiera realizar una configuración
				    				{
				    					System.out.println();
				    					
							    		switch(opcion)
							    		{
							    			case 1:
							    				//Configuraciones Usuario
							    				
							    				if(esUsuarioApostador) //Si es un usuario apostador
							    				{
								    				//mostrarMenuConfiguracionesUsuarioYLeerYValidarOpcion
								    				opcion = validacionesMenu.mostrarMenuConfiguracionesUsuarioYLeerYValidarOpcion();
								    				
								    				while (opcion != 0) //Mientras quiera realizar una configuración del usuario
								    				{
								    					System.out.println();
								    					
											    		switch(opcion)
											    		{
											    			case 1:
											    				//Modificar Password
											    				
											    				//leerYValidarPasswordUsuario*
											    				passwordUsuario = validacionesUsuario.leerYValidarPasswordUsuario();
											    				
											    				if(!usuario.getPassword().equals(passwordUsuario)) //Si la password es diferente a la actual
											    				{
											    					//Modificar password
											    					try 
											    					{
																		usuario.setPassword(passwordUsuario);
																	} 
											    					catch (PasswordException e) 
											    					{
																		e.printStackTrace();
																	}
											    					
											    					//actualizarUsuario*
											    					persistenciaUsuario.actualizarUsuario(usuario, conexion);
											    					
											    					System.out.println("\nPassword actualizada con exito\n");
											    				}
											    				else
											    				{
											    					System.out.println("\nHas introducido la password actual\n");
											    				}
											    				
											    			break;
											    			case 2:
											    				//Ingresar Dinero
											    				
											    				//Mostrar Saldo Actual
											    				System.out.println("Tu saldo actual es de "+usuarioApostador.getBalance()+"€\n");
											    				
											    				//leerYValidarCantidadDinero*
											    				cantidadDinero = validacionesUsuario.leerYValidarCantidadDinero();
											    				
											    				//Modificar cantidad de dinero
											    				usuarioApostador.changeBalance(cantidadDinero);
											    				
										    					//actualizarUsuarioApostador*
										    					persistenciaUsuarioApostador.actualizarUsuarioApostador(usuarioApostador, conexion);
										    					
										    					System.out.println("\nSe ha ingresado "+cantidadDinero+"€ a su cuenta\n");
												    		break;
											    			case 3:
											    				//Retirar Dinero
											    				
											    				//Mostrar Saldo Actual
											    				System.out.println("Tu saldo actual es de "+usuarioApostador.getBalance()+"€\n");
											    				
											    				if(usuarioApostador.getBalance() > 0)  //Si el usuario tiene saldo
											    				{
												    				//leerYValidarCantidadDinero*
												    				cantidadDinero = validacionesUsuario.leerYValidarCantidadDinero();
												    				
												    				if(cantidadDinero <= usuarioApostador.getBalance()) //Si el usuario tiene el suficiente saldo para retirar
												    				{
													    				//Modificar cantidad de dinero
													    				usuarioApostador.changeBalance(-cantidadDinero);
													    				
												    					//actualizarUsuarioApostador*
												    					persistenciaUsuarioApostador.actualizarUsuarioApostador(usuarioApostador, conexion);
												    					
												    					System.out.println("\nSe ha retirado "+cantidadDinero+"€ de su cuenta\n");
												    				}
												    				else
												    				{
												    					System.out.println("\nNo hay suficiente saldo para retirar\n");
												    				}
											    				}
											    				else
											    				{
											    					System.out.println("\nTu saldo se encuentra a 0\n");
											    				}

											    			break;
											    			case 4:
											    				//Solicitar Baja
											    				
											    				//Modificar fecha de baja
																try 
																{
																	usuarioApostador.setEndingDate(new GregorianCalendar());
																} 
																catch (EndingDateException e) 
																{
																	e.printStackTrace();
																}
																
										    					//actualizarUsuarioApostador*
										    					persistenciaUsuarioApostador.actualizarUsuarioApostador(usuarioApostador, conexion);
										    					
										    					System.out.println("Baja realizada con exito.\nAhora eres un usuario anonimo\n");
										    					
										    					esUsuarioApostador = false; //Cambiar a usuario anónimo
											    		}

											    		
											    		if(esUsuarioApostador) //Si sigue siendo un usuario apostador
											    		{
											    			//mostrarMenuConfiguracionesUsuarioYLeerYValidarOpcion
											    			System.out.println();
											    			
											    			opcion = validacionesMenu.mostrarMenuConfiguracionesUsuarioYLeerYValidarOpcion();
											    		}
											    		else
											    		{
											    			opcion = 0;
											    		}
								    				}
							    				}

							    			break;
							    			case 2:
							    				//Configuraciones Partido
							    				
							    				if(!esUsuarioApostador) //Si no es un usuario apostador
							    				{
							    					//mostrarMenuConfiguracionesPartidoYLeerYValidarOpcion
							    					opcion = validacionesMenu.mostrarMenuConfiguracionesPartidoYLeerYValidarOpcion();
							    					
							    					while(opcion != 0) //Mientras quiera realizar una configuración
							    					{
							    						if(opcion >= 2 && opcion <= 4) //Si elige opcion actualizar, finalizar o aplazar
							    						{
							    							//Leer Y Validar Partido
							    							
							    							System.out.println();
							    							
							    							//listarPartidos
							    							persistenciaPartido.listarPartidos(conexion);
							    							
							    							System.out.println();
							    							
							    							//leerYValidarIDPartido*
							    							IDPartido = validacionesPartido.leerYValidarIDPartido();
							    							
							    							if(persistenciaPartido.partidoRegistrado(IDPartido, conexion)) //Si el partido existe
							    							{
							    								//recuperarPartido*
							    								partido = persistenciaPartido.recuperarPartido(IDPartido, conexion);
							    								
							    								partidoFinalizado = partido.getFinalized();
							    								
							    								System.out.println();
							    								
							    								if(partidoFinalizado)
							    								{
							    									opcion = 0;
							    									System.out.println("\nEl partido ha finalizado\n");
							    								}
							    							}
							    							else
							    							{
							    								opcion = 0;
							    								System.out.println("\nNo existe ese partido\n");
							    							}
							    						}
							    						
							    						switch(opcion)
							    						{
							    							case 1:
							    								//Registrar Partido
							    								
							    								System.out.println();
							    								
							    								//listarEquipos*
							    								
							    								persistenciaEquipo.listarEquipos(conexion);
							    								
							    								//leerYValidarIDEquipoLocal
							    								System.out.println("\nEquipo Local");
							    								IDEquipoLocal = validacionesEquipo.leerYValidarIDEquipo();
							    								
							    								if(persistenciaEquipo.equipoRegistrado(IDEquipoLocal, conexion)) //Si es un equipo registrado
							    								{
							    									//Recuperar equipo local
							    									equipoLocal = persistenciaEquipo.recuperarEquipo(IDEquipoLocal, conexion);
							    									
								    								//leerYValidarIDEquipoVisitante
							    									System.out.println("\nEquipo Visitante");
								    								IDEquipoVisitante = validacionesEquipo.leerYValidarIDEquipo();
								    								
								    								if(persistenciaEquipo.equipoRegistrado(IDEquipoVisitante, conexion)) //Si es un equipo registrado
								    								{
								    									if(!IDEquipoLocal.equals(IDEquipoVisitante)) //Si no son el mismo equipo
								    									{
									    									//Recuperar equipo visitante
									    									equipoVisitante = persistenciaEquipo.recuperarEquipo(IDEquipoVisitante, conexion);
									    									
									    									System.out.println();
									    									
									    									//leerYValidarFechaPartido
									    									fechaPartido = validacionesPartido.leerYValidarFechaPartido();
									    									
									    									if(fechaPartido.compareTo(new GregorianCalendar()) >= 0) //Si la fecha del partido es mayor igual a la actual
									    									{
									    										//Crear Partido
									    										partido = new Partido(equipoLocal, equipoVisitante, 0, 0, 0, fechaPartido, null);
									    										
									    										//Registrar Partido
									    										persistenciaPartido.registrarPartido(partido, conexion);
									    										
									    										System.out.println("\nEl partido se ha registrado correctamente\n");
									    									}
									    									else
									    									{
									    										System.out.println("\nHas introducio una fecha anterior o igual a la actual\n");
									    									}
								    									}
								    									else
								    									{
								    										System.out.println("\nLos dos equipos no pueden ser el mismo\n");
								    									}
								    								}
								    								else
								    								{
								    									System.out.println("\nNo existe ese equipo\n");
								    								}
								    								
							    								}
							    								else
							    								{
							    									System.out.println("\nNo existe ese equipo\n");
							    								}
							    							break;
							    							case 2:
							    								
							    								if(!partidoFinalizado) //Si el partido no ha finalizado
							    								{
							    									//Actualizar Cuotas
							    									
							    									//mostrarMenuActualizarCuotasYLeerYValidarOpcion*
								    								opcion = validacionesMenu.mostrarMenuActualizarCuotasYLeerYValidarOpcion();
								    								
								    								//Mostrar Cuotas
							    									System.out.println("\nCuotaLocal: "+partido.getCuotaLocal()+" | CuotaEmpate: "+partido.getCuotaEmpate()+
							    													   " | CuotaVisitante: "+partido.getCuotaVisitante()+"\n");
							    									
							    									switch(opcion)
							    									{
							    										case 1:
							    											//Actualizar Cuota Local

										    								//Leer Y Validar Cuota Local
										    								System.out.println("\nCuota Local");
										    								cuotaLocal = validacionesPartido.leerYValidarCuota();
										    								
										    								//Cambiar Cuota Local
																			try 
																			{
																				partido.setCuotaLocal(cuotaLocal);
																			} 
																			catch (CuoteException e) 
																			{
																				e.printStackTrace();
																			}
							    										break;
							    										case 2:
							    											//Actualizar Cuota Empate

										    								//Leer Y Validar Cuota Empate
										    								System.out.println("\nCuota Empate");
										    								cuotaEmpate = validacionesPartido.leerYValidarCuota();
										    								
										    								//Cambiar Cuota Empate
																			try 
																			{
																				partido.setCuotaEmpate(cuotaEmpate);
																			} 
																			catch (CuoteException e) 
																			{
																				e.printStackTrace();
																			}
							    										break;
							    										case 3:
							    											//Actualizar Cuota Visitante

										    								//Leer Y Validar Cuota Visitante
										    								System.out.println("\nCuota Visitante");
										    								cuotaVisitante = validacionesPartido.leerYValidarCuota();
										    								
										    								//Cambiar Cuota Empate
																			try 
																			{
																				partido.setCuotaVisitante(cuotaVisitante);
																			} 
																			catch (CuoteException e) 
																			{
																				e.printStackTrace();
																			}
							    										break;
							    										case 4:
							    											//Actualizar Cuotas
							    											
										    								//Leer Y Validar Cuota Local
										    								System.out.println("\nCuota Local");
										    								cuotaLocal = validacionesPartido.leerYValidarCuota();
										    								
										    								//Leer Y Validar Cuota Empate
										    								System.out.println("\nCuota Empate");
										    								cuotaEmpate = validacionesPartido.leerYValidarCuota();
										    								
										    								//Leer Y Validar Cuota Visitante
										    								System.out.println("\nCuota Visitante");
										    								cuotaVisitante = validacionesPartido.leerYValidarCuota();
										    								
										    								if(cuotaLocal + cuotaEmpate + cuotaVisitante == 100)  //Si la suma de las cuotas es 100
										    								{
																				//Cambiar Cuotas
																				partido.changeCuotas(cuotaLocal, cuotaEmpate, cuotaVisitante);
																				
																				//Actualizar Partido
																				persistenciaPartido.actualizarPartido(partido, conexion);
										    								}
										    								else
										    								{
										    									System.out.println("\nLa suma de las cuotas debe ser 100\n");
										    								}
							    									}
							    									
							    									if(opcion >= 1 && opcion <= 3) //Si solo ha elegido modificar cuota individual
							    									{
																		//Actualizar Partido
																		persistenciaPartido.actualizarPartido(partido, conexion);
							    									}

							    									
								    								//Mostrar Cuotas
							    									System.out.println("\nCuotaLocal: "+partido.getCuotaLocal()+" | CuotaEmpate: "+partido.getCuotaEmpate()+
							    													   " | CuotaVisitante: "+partido.getCuotaVisitante()+"\n");
								    								
							    								}		

							    							break;
							    							case 3:
							    								//Finalizar Partido
							    								
							    								if(!partido.getFinalized()) //Si el partido no ha finalizado
							    								{
							    									if(partido.getDate().compareTo(new GregorianCalendar()) < 0) //Si se ha jugado el partido
							    									{
							    										//Leer Y Validar Goles Local
							    										System.out.println("\nGoles Local");
							    										golesLocal = validacionesPartido.leerYValidarGolesPartido();
							    										
							    										//Leer Y Validar Goles Visitante
							    										System.out.println("\nGoles Visitante");
							    										golesVisitante = validacionesPartido.leerYValidarGolesPartido();
							    										
							    										//Cambiar goles
							    										try 
							    										{
							    											partido.setGolesLocal(golesLocal);
																			partido.setGolesVisitante(golesVisitante);
																		}
							    										catch (NegativeNumberException e) 
							    										{
																			e.printStackTrace();
																		}
							    										
							    										//Finalizar Partido
							    										partido.setFinalized(true);
							    										
																		//Actualizar Partido
																		persistenciaPartido.actualizarPartido(partido, conexion);
																		
																		System.out.println("\nPartido finalizado con exito\n");
							    									}
							    									else
							    									{
							    										System.out.println("\nTodavia no se ha jugado el partido\n");
							    									}
							    								}
							    								else
							    								{
							    									System.out.println("\nEl partido ya ha finalizado\n");
							    								}
							    							break;
							    							case 4:
							    								//Aplazar Partido
							    								
							    								if(!partido.getFinalized()) //Si el partido no ha finalizado
							    								{
							    									if(partido.getDate().compareTo(new GregorianCalendar()) > 0) //Si no se ha jugado el partido
							    									{
							    										System.out.println();
							    										
							    										//Leer Y Validar Fecha del partido
							    										fechaPartido = validacionesPartido.leerYValidarFechaPartido();
							    										
							    										if(partido.getDate().compareTo(fechaPartido) >= 0) //Si la fecha del partido a aplazar es menor o igual a la elegida
							    										{
								    										//Finalizar Partido
								    										partido.setFinalized(true);
								    										
								    										//CrearPartido
								    										partidoAplazado = new Partido(partido.getEquipoLocal(), partido.getEquipoVisitante(), 
								    												partido.getCuotaLocal(), partido.getCuotaEmpate(), partido.getCuotaVisitante(), 
								    												fechaPartido, partido);
								    										
								    										persistenciaPartido.registrarPartido(partidoAplazado, conexion);
								    										
																			//Actualizar Partido
																			persistenciaPartido.actualizarPartido(partido, conexion);
								    										
								    										System.out.println("\nPartido sustituido con exito\n");
							    										}
							    										else
							    										{
							    											System.out.println("\nNo se puede aplazar el partido a una fecha anterior o igual\n");
							    										}
							    									}
							    									else
							    									{
							    										System.out.println("\nEl partido ya se ha jugado\n");
							    									}
							    								}
							    								else
							    								{
							    									System.out.println("\nEl partido ya ha finalizado\n");
							    								}
							    						}
							    						
							    						System.out.println();
							    						
								    					//mostrarMenuConfiguracionesPartidoYLeerYValidarOpcion
								    					opcion = validacionesMenu.mostrarMenuConfiguracionesPartidoYLeerYValidarOpcion();
							    					}
							    				}
							    			break;
							    			case 3:
							    				
							    				if(!esUsuarioApostador) //Si no es un usuario apostador
							    				{
								    				//Registrar Equipo

								    				//Leer Y Validar Equipo
								    				
							    					System.out.println();
							    					
								    				//leerYValidarID
								    				IDEquipoLocal = validacionesEquipo.leerYValidarIDEquipo();
								    				
								    				if(!persistenciaEquipo.equipoRegistrado(IDEquipoLocal, conexion)) //Si no es un equipo registrado
								    				{
								    					System.out.println();
								    					
									    				//leerYValidarName
									    				nombreEquipo = validacionesEquipo.leerYValidarNombreEquipo();
									    				
									    				System.out.println();
									    				
									    				//leerYValidarCity
									    				ciudadEquipo = validacionesEquipo.leerYValidarCiudadEquipo();
									    				
									    				System.out.println();
									    				
									    				//leerYValidarCountry
									    				paisEquipo = validacionesEquipo.leerYValidarPaisEquipo();
									    				
									    				//Crear Equipo
									    				equipoLocal = new Equipo(IDEquipoLocal, nombreEquipo, ciudadEquipo, paisEquipo);
									    				
									    				//Registrar Equipo
									    				persistenciaEquipo.registrarEquipo(equipoLocal, conexion);
									    				
									    				System.out.println("\nEquipo registrado con exito\n");
								    				}
								    				else
								    				{
								    					System.out.println("\nYa se ha registrado ese equipo\n");
							    				}
						    				}							    				
							    				
							    		}
							    		
							    		if(esUsuario) //Si sigue siendo un usuario
							    		{
								    		//mostrarMenuConfiguracionesYLeerYValidarOpcion*
							    			System.out.println();
							    			
								    		opcion = validacionesMenu.mostrarMenuConfiguracionesYLeerYValidarOpcion();
							    		}
							    		else
							    		{
							    			opcion = 0;
							    		}
						    		}
			    				}		
			    			break;
			    			case 2:
			    				//Menu Listas
			    				
			    				//mostrarMenuListasYLeerYValidarOpcion*
			    				opcion = validacionesMenu.mostrarMenuListasYLeerYValidarOpcion();
			    				
			    				while(opcion != 0) //Mientras quiera realizar alguna lista
			    				{
			    					switch(opcion)
			    					{
			    						case 1:
			    							//Listas Usuarios
			    							
			    							System.out.println();
			    							
			    							//mostrarMenuListasUsuarioYLeerYValidarOpcion*
			    							opcion = validacionesMenu.mostrarMenuListasUsuariosYLeerYValidarOpcion();
			    							
			    							while(opcion != 0) //Mientras quiera realizar listas de usuarios
			    							{
			    								switch(opcion)
			    								{
			    									case 1:
			    										//Listar Usuarios
			    										System.out.println();
			    										
			    										persistenciaUsuarioApostador.listarUsuarios(conexion);
			    										
			    										System.out.println();
			    									break;
			    									case 2:
			    										//Listar Usuarios Alta
			    										System.out.println();
			    										
			    										persistenciaUsuarioApostador.listarUsuarios(true, conexion);
			    										
			    										System.out.println();
			    									break;
			    									case 3:
			    										//Listar Usuarios Baja
			    										System.out.println();
			    										
			    										persistenciaUsuarioApostador.listarUsuarios(false, conexion);
			    										
			    										System.out.println();
			    								}		    								
			    								
				    							//mostrarMenuListasUsuarioYLeerYValidarOpcion*
				    							opcion = validacionesMenu.mostrarMenuListasUsuariosYLeerYValidarOpcion();
			    							}
			    						break;
			    						case 2:
			    							//Lista Equipos
			    							
			    							System.out.println();
			    							
			    							persistenciaEquipo.listarEquipos(conexion);
			    							
			    							System.out.println();
			    						break;
			    						case 3:
			    							//Listas Clasificaciones
			    							
			    							System.out.println();
			    							
			    							//mostrarMenuListasClasificacionesYLeerYValidarOpcion*
			    							opcion = validacionesMenu.mostrarMenuListasClasificacionesYLeerYValidarOpcion();
			    							
			    							while(opcion != 0) //Mientras quiera realizar listas de usuarios
			    							{
			    								switch(opcion)
			    								{
			    									case 1:
			    										//Listar Clasificacion
			    										System.out.println();
			    										
			    										persistenciaClasificaciones.listarClasificacion(conexion);
			    										
			    										System.out.println();
			    									break;
			    									case 2:
			    										//Listar Clasificacion Local
			    										System.out.println();
			    										
			    										persistenciaClasificaciones.listarClasificacion(true, conexion);
			    										
			    										System.out.println();
			    									break;
			    									case 3:
			    										//Listar Clasificacion Visitante
			    										System.out.println();
			    										
			    										persistenciaClasificaciones.listarClasificacion(false, conexion);
			    										
			    										System.out.println();
			    								}		    								
			    								
				    							//mostrarMenuListasClasificacionesYLeerYValidarOpcion*
				    							opcion = validacionesMenu.mostrarMenuListasClasificacionesYLeerYValidarOpcion();
			    							}
			    						break;
			    						case 4:
			    							//Listas Partidos
			    							
			    							System.out.println();
			    							
			    							//mostrarMenuListasPartidosYLeerYValidarOpcion*
			    							opcion = validacionesMenu.mostrarMenuListasPartidosYLeerYValidarOpcion();
			    							
			    							while(opcion != 0) //Mientras quiera realizar listas de partidos
			    							{
			    								switch(opcion)
			    								{
			    									case 1:
			    										//Lista Partidos
			    										System.out.println();
			    										
			    										persistenciaPartido.listarPartidos(conexion);
			    										
			    										System.out.println();
			    									break;
			    									case 2:
			    										//Lista Partidos Finalizados
			    										System.out.println();
			    										
			    										persistenciaPartido.listarPartidos(true, conexion);
			    										
			    										System.out.println();
			    									break;
			    									case 3:
			    										//Lista Partidos No Finalizados
			    										System.out.println();
			    										
			    										persistenciaPartido.listarPartidos(false, conexion);
			    										
			    										System.out.println();
			    									break;
			    									case 4:
			    										//Lista Partidos Equipo
			    										System.out.println();
			    										
			    										IDEquipoLocal = validacionesEquipo.leerYValidarIDEquipo();
			    										
			    										System.out.println();
			    										
			    										persistenciaPartido.listarPartidos(IDEquipoLocal, conexion);
			    										
			    										System.out.println();
			    								}		    								
			    								
				    							//mostrarMenuListasPartidosYLeerYValidarOpcion*
				    							opcion = validacionesMenu.mostrarMenuListasPartidosYLeerYValidarOpcion();
			    							}
			    						break;
			    						case 5:
			    							//Listas Apuestas
			    							
			    							System.out.println();
			    							
			    							//mostrarMenuApuestasYLeerYValidarOpcion*
			    							opcion = validacionesMenu.mostrarMenuApuestasYLeerYValidarOpcion();
			    							
			    							while(opcion != 0) //Mientras quiera realizar listas de partidos
			    							{
			    								switch(opcion)
			    								{
			    									case 1:
			    										//Lista Apuestas
			    										System.out.println();
			    										
			    										persistenciaApuesta.listarApuestas(conexion);
			    										
			    										System.out.println();
			    									break;
			    									case 2:
			    										//Lista Apuestas Comprobadas
			    										System.out.println();
			    										
			    										persistenciaApuesta.listarApuestas(true, conexion);
			    										
			    										System.out.println();
			    									break;
			    									case 3:
			    										//Lista Apuestas No Comprobadas
			    										System.out.println();
			    										
			    										persistenciaApuesta.listarApuestas(false, conexion);
			    										
			    										System.out.println();
			    									break;
			    									case 4:
			    										//Lista Apuestas Usuario
			    										System.out.println();
			    										
			    										nickUsuario = validacionesUsuario.leerYValidarNickUsuario();
			    										
			    										System.out.println();
			    										
			    										persistenciaApuesta.listarApuestas(nickUsuario, conexion);
			    										
			    										System.out.println();
			    								}		    								
			    								
				    							//mostrarMenuApuestasYLeerYValidarOpcion*
				    							opcion = validacionesMenu.mostrarMenuApuestasYLeerYValidarOpcion();
			    							}
			    					}
			    					
				    				//mostrarMenuListasYLeerYValidarOpcion*
				    				opcion = validacionesMenu.mostrarMenuListasYLeerYValidarOpcion();
			    				}
				    		break;
			    			case 3:
			    				
			    				if(esUsuarioApostador) //Si es un usuario apostador
			    				{
				    				//Menu Apuestas
				    				
				    				//mostrarMenuApuestasYLeerYValidarOpcion
				    				opcion = validacionesMenu.mostrarMenuApuestasYLeerYValidarOpcion();
				    				
				    				while(opcion != 0) //Mientras quiera realizar una opcion apuesta
				    				{
				    					switch(opcion)
				    					{
				    						case 1:
				    							//Realizar Apuesta
				    							
				    							//Leer y Validar Apuesta
				    							
				    							//Leer Y Validar Partido
				    							
				    							System.out.println();
				    							
				    							//Listar Partidos
				    							persistenciaPartido.listarPartidos(conexion);
				    							
				    							System.out.println();
				    							
				    							//Leer Y Validar IDPartido
				    							IDPartido = validacionesPartido.leerYValidarIDPartido();
				    							
				    							System.out.println();
				    							
				    							if(persistenciaPartido.partidoRegistrado(IDPartido, conexion)) //Si es un partido registrado
				    							{
				    								//Recuperar Partido
				    								partido = persistenciaPartido.recuperarPartido(IDPartido, conexion);
				    								
				    								if(partido.getDate().compareTo(new GregorianCalendar()) > 0) //Si el partido no ha finalizado
				    								{
				    									//Leer Y Validar Importe Apuesta
				    									importeApuesta = validacionesApuesta.leerYValidarImporteApuesta();
				    									
				    									if(importeApuesta > usuarioApostador.getBalance()) //Si el importe de la apuesta supera el saldo del usuario
				    									{
				    										//Modificar Saldo Jugador
				    										usuarioApostador.changeBalance(-importeApuesta);
				    										
				    										//Actualizar Usuario
				    										persistenciaUsuarioApostador.actualizarUsuarioApostador(usuarioApostador, conexion);
				    										
					    									System.out.println();
					    									
					    									//Leer Y Validar Apuesta Equipo
					    									apuestaEquipo = validacionesApuesta.leerYValidarApuesta();				    									
					    									
					    									//Crear Apuesta
					    									apuesta = new Apuesta(usuarioApostador, partido, importeApuesta, apuestaEquipo);
					    									
					    									//Registrar Apuesta 
					    									persistenciaApuesta.registrarApuesta(apuesta, conexion);
					    									
					    									System.out.println("\nApuesta registrada con exito\n");
				    									}
				    									else
				    									{
				    										System.out.println("\nNo tienes suficiente saldo para apostar\n");
				    									}
				    								}		
				    							}
				    							else
				    							{
				    								System.out.println("\nNo existe ese partido\n");
				    							}
				    							
				    							System.out.println("\nRealizar Apuesta\n");
				    						break;
				    						case 2:
				    							//Comprobar Apuesta
				    							
				    							//Listar Apuestas Usuario		
				    							System.out.println();
				    							
				    							persistenciaApuesta.listarApuestas(usuarioApostador.getNick(), conexion);
				    							
				    							System.out.println();
				    							
				    							//Leer Y Validar IDApuesta
				    							IDApuesta = validacionesApuesta.leerYValidarIDApuesta();
				    							
				    							if(persistenciaApuesta.apuestaRegistrada(IDApuesta, conexion)) //Si es una apuesta registrada
				    							{
				    								//Recuperar Apuesta
				    								apuesta = persistenciaApuesta.recuperarApuesta(IDApuesta, conexion);
				    								
				    								if(apuesta.getNickUsuario().equals(usuarioApostador.getNick())) //Si la apuesta pertenece al usuario
				    								{
				    									if(!apuesta.getComprobada()) //Si la apuesta ha sido comprobada
				    									{
				    										//Recuperar Partido
				    										partido = persistenciaPartido.recuperarPartido(apuesta.getIDPartido(), conexion);
				    										
				    										if(partido.getFinalized()) //Si el partido ha finalizado
				    										{
				    											cantidadGanada = 0;
				    											
				    											switch(apuesta.getApuesta())
				    											{
				    												case '1':
				    													if(partido.getGolesLocal() > partido.getGolesVisitante()) //Si ha ganado el equipo local
				    													{
				    														//Recargar saldo
				    														cantidadGanada = apuesta.getCantidadApostada() * (partido.getCuotaLocal() / 100);
				    														
				    														System.out.println("\nEnhorabuena! Ha ganado "+cantidadGanada+"€\n");
				    													}
				    													else
				    													{
				    														System.out.println("\nUna pena, la proxima vez sera\n");
				    													}
				    												break;
				    												case 'X':
				    													if(partido.getGolesLocal() == partido.getGolesVisitante()) //Si han quedado empate
				    													{
				    														//Recargar saldo
				    														cantidadGanada = apuesta.getCantidadApostada() * (partido.getCuotaEmpate() / 100);
				    														
				    														System.out.println("\nEnhorabuena! Ha ganado "+cantidadGanada+"€\n");
				    													}
				    													else
				    													{
				    														System.out.println("\nUna pena, la proxima vez sera\n");
				    													}
				    												break;
				    												case '2':
				    													if(partido.getGolesLocal() < partido.getGolesVisitante()) //Si ha ganado el equipo visitante
				    													{
				    														//Recargar saldo
				    														cantidadGanada = apuesta.getCantidadApostada() * (partido.getCuotaVisitante() / 100);
				    														
				    														System.out.println("\nEnhorabuena! Ha ganado "+cantidadGanada+"€\n");
				    													}
				    													else
				    													{
				    														System.out.println("\nUna pena, la proxima vez sera\n");
				    													}
				    											}
				    											
				    											//Modificar Saldo Usuario
				    											usuarioApostador.changeBalance(cantidadGanada);
				    											
				    											//Actualizar Usuario
				    											persistenciaUsuarioApostador.actualizarUsuarioApostador(usuarioApostador, conexion);
				    											
				    											//Modificar Apuesta
				    											apuesta.setComprobada(true);
				    											
				    											//Actualizar Apuesta
				    											persistenciaApuesta.actualizarApuesta(apuesta, conexion);
				    											
				    											System.out.println("\nApuesta comprobada con exito\n");
				    										}
				    										else
				    										{
				    											System.out.println("\nEl partido aun no ha finalizado\n");
				    										}
				    									}
				    									else
				    									{
				    										System.out.println("\nYa se ha comprobado esa apuesta\n");
				    									}
				    								}
				    								else
				    								{
				    									System.out.println("\nNo existe esa apuesta\n");
				    								}
				    							}
				    							else
				    							{
				    								System.out.println("\nNo existe esa apuesta\n");
				    							}
				    							
				    							System.out.println("Comprobar Apuesta");
				    					}
				    					
					    				//mostrarMenuApuestasYLeerYValidarOpcion
					    				opcion = validacionesMenu.mostrarMenuApuestasYLeerYValidarOpcion();
				    				}
			    				}

			    		}
			    		
			    		System.out.println();
			    		
			    		opcion = validacionesMenu.mostrarMenuAplicacionYLeerYValidarOpcion();
		    		}
		    	}
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
