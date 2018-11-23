package Persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import Dominio.Mesa;
import Dominio.Reserva;

public class AgenteMesa {

	private java.sql.Connection Conex;
	private java.sql.Statement Sentencia_SQL;
	private java.sql.ResultSet Conj_Registros;

	private Agente agente;
	private ArrayList<Reserva> listaReservas;

	public AgenteMesa() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		String controlador = "com.mysql.cj.jdbc.Driver";
		Class.forName(controlador).newInstance();

		agente.Conectar("mesas");
	}

	public AgenteMesa(String b, String u, String c)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		agente = new Agente(b, u, c);
	}

	public void Conectar(String nombre_bbdd) throws SQLException {
		agente.Conectar(nombre_bbdd);

	}

	public void ReservarEstadoMesa(int identificador, String estado, String camarero) throws SQLException {
		String nom_tabla = "listamesas";
		String Sentencia = "update " + nom_tabla + " set camarero='" + camarero + "', estado='" + estado
				+ "'  where identificador='" + identificador + "'";
		System.out.println(Sentencia);
		agente.insertarFila(Sentencia);
	}

	public ArrayList<Mesa> pasarMesas() throws SQLException {
		ArrayList<Mesa> listaMesas = new ArrayList<Mesa>();
		String Sentencia = "SELECT * FROM listamesas";
		Conj_Registros = agente.ejecutarSentencia(Sentencia);
		// Sentencia_SQL.executeQuery(Sentencia);
		while (Conj_Registros.next()) {
			Mesa m = new Mesa();
			m.setIdentificador(Integer.parseInt(this.Conj_Registros.getString("identificador")));
			m.setEstado(this.Conj_Registros.getString("estado"));
			m.setCamareroMesa(this.Conj_Registros.getString("camarero"));

			listaMesas.add(m);
		}
		return listaMesas;
	}

	public ArrayList<Reserva> pasarReservas() throws SQLException {
		listaReservas = new ArrayList<Reserva>();
		String Sentencia = "SELECT * FROM listareservas";
		Conj_Registros = agente.ejecutarSentencia(Sentencia);
		// Sentencia_SQL.executeQuery(Sentencia);
		while (Conj_Registros.next()) {
			Reserva r = new Reserva();
			r.setIdMesa(Integer.parseInt(this.Conj_Registros.getString("idmesa")));
			r.setHora(Integer.parseInt(this.Conj_Registros.getString("hora")));
			r.setFecha(this.Conj_Registros.getString("fecha"));
			r.setComensales(Integer.parseInt(this.Conj_Registros.getString("comensales")));
			r.setNombreCliente(this.Conj_Registros.getString("nombre"));
			r.setIdReserva(Integer.parseInt(this.Conj_Registros.getString("idreserva")));

			listaReservas.add(r);
		}
		return listaReservas;
	}



	public void GuardarReserva(int idMesa, int hora, String fecha, int comensales, String nombre) throws SQLException {

			String nom_tabla = "listareservas";
			boolean revisado = true;
			boolean cambiado=true;
			int idReserva = (int) (Math.random() * 500);
			while (cambiado) {
				cambiado=false;
				for (Reserva reserva : listaReservas) {
					if(reserva.getIdReserva()==idReserva) {
						idReserva = (int) (Math.random() * 500);
						cambiado=true;
					}
				}
			String Sentencia = "INSERT INTO " + nom_tabla
					+ " (`idmesa`, `hora`, `fecha`, `comensales`, `nombre`, `idReserva`)" + "VALUES" + "('" + idMesa
					+ "','" + hora + "','" + fecha + "','" + comensales + "','" + nombre + "','" + idReserva + "');";
			System.out.println(Sentencia);
			agente.insertarFila(Sentencia);
		}
	}

	public boolean irSiguiente() throws SQLException {
		return this.Conj_Registros.next();
	}

	public String obtenerCampo(String campo) throws SQLException {
		return this.Conj_Registros.getString(campo);
	}
}
