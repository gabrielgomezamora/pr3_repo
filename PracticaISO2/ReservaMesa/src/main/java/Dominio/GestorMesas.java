package Dominio;
import Persistencia.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class GestorMesas {
	private ArrayList<Mesa> listaMesas = new ArrayList();
	private AgenteMesa conexion;

	private ArrayList<Reserva> listaReservas;
	
	public ArrayList<Mesa> getListaMesas() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		conexion=new AgenteMesa("mesas","hola","hola");
		listaMesas = conexion.pasarMesas();
		return listaMesas;
	}
//	public void Obtener_Datos_Tabla(String nom_tabla) throws SQLException {
//		int cont = 0;
//		String Sentencia = "SELECT * FROM " + nom_tabla;
//		Conj_Registros = Sentencia_SQL.executeQuery(Sentencia);
//	}

	public void setListaMesas(ArrayList<Mesa> listaMesas) {
		this.listaMesas = listaMesas;
	}


	public boolean ReservarMesas(int idmesa) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {



		boolean reservada=true;
		for (Mesa mesaSeleccionada : listaMesas) {
			int id= mesaSeleccionada.getIdentificador();
			String estadoMesa= mesaSeleccionada.getEstado();
			if(idmesa==id) {

				if(estadoMesa.equalsIgnoreCase("Ocupado")) {
					System.out.println("Mesa ya Ocupada");
					conexion.ReservarEstadoMesa(mesaSeleccionada.getIdentificador(),"libre",mesaSeleccionada.getCamareroMesa());
					reservada=false;
				}else {
					conexion.ReservarEstadoMesa(mesaSeleccionada.getIdentificador(),"Ocupado",mesaSeleccionada.getCamareroMesa());
					reservada=true;
				}
				
			}
			
			
		}
		
		return reservada;
		
	}

	public void guardarReserva(int idMesa,int hora,String fecha,int comensales,String nombre) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		conexion=new AgenteMesa("mesas","hola","hola");
		listaReservas= getListaReservas();
		if(controlReserva(idMesa, hora, fecha)) {
			//String nombre_bbdd="listaturnos";
			//conexion.Conectar(nombre_bbdd);

			conexion.GuardarReserva(idMesa,hora,fecha,comensales,nombre);
		}else {
			System.out.println("MESA YA RESERVADA");
		}

		
	}
	public boolean controlReserva(int idMesa, int hora, String fecha) throws SQLException {
		boolean sepuede = true;

		for (Reserva reserva : listaReservas) {
			if (reserva.getIdMesa() == idMesa && reserva.getHora() == hora && reserva.getFecha().equals(fecha)) {
				sepuede = false;
			}
		}
		return sepuede;
	}
	public ArrayList<Reserva> getListaReservas() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {

		conexion=new AgenteMesa("mesas","hola","hola");
		listaReservas = conexion.pasarReservas();
		
		return listaReservas;
	}

}
