package Persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

//
//import Dominio.Mesa;
//import Dominio.Turno;

public class Agente {

	private java.sql.Connection Conex;
	private java.sql.Statement Sentencia_SQL;
	private java.sql.ResultSet Conj_Registros;
	private String bbdd;
	private String usuario;
	private String clave;

	public Agente() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		String controlador = "com.mysql.cj.jdbc.Driver";
		Class.forName(controlador).newInstance();

		Conectar("mesas");
	}

	public Agente(String b, String u, String c)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		String controlador = "com.mysql.cj.jdbc.Driver";

		Class.forName(controlador).newInstance();
		bbdd = b;
		usuario = u;
		clave = c;
		Conectar(bbdd);
	}

	public void Conectar(String nombre_bbdd) throws SQLException {
		String URL_BD = "jdbc:mysql://localhost/" + nombre_bbdd + "?serverTimezone=CET";
		try {
			Conex = java.sql.DriverManager.getConnection(URL_BD, usuario, clave);
			Sentencia_SQL = Conex.createStatement();
			System.out.println("Conexion realizada con éxito");
		} catch (Exception e) {
			System.err.println("Exception: " + e.getMessage());
		}

	}

	public void Obtener_Datos_Tabla(String nom_tabla) throws SQLException {
		int cont = 0;
		String Sentencia = "SELECT * FROM " + nom_tabla;
		Conj_Registros = Sentencia_SQL.executeQuery(Sentencia);
	}

	public void ReservarEstadoMesa(int identificador, String estado, String camarero) throws SQLException {
		String nom_tabla = "listamesas";
		String Sentencia = "update " + nom_tabla + " set camarero='" + camarero + "', estado='" + estado
				+ "'  where identificador='" + identificador + "'";
		System.out.println(Sentencia);
		this.Sentencia_SQL.executeUpdate(Sentencia);
	}
	public void insertarFila(String Sentencia) throws SQLException {
		this.Sentencia_SQL.executeUpdate(Sentencia);
	}
//    public ArrayList<Mesa> pasarMesas() throws SQLException{
//    	ArrayList<Mesa> listaMesas = new ArrayList<Mesa>();
//    	String Sentencia = "SELECT * FROM listamesas";
//    	Conj_Registros = Sentencia_SQL.executeQuery(Sentencia);
//    	while(Conj_Registros.next()) {
//    		Mesa m= new Mesa();
//    		m.setIdentificador(Integer.parseInt(this.Conj_Registros.getString("identificador")));
//    		m.setEstado(this.Conj_Registros.getString("estado"));
//    		m.setCamareroMesa(this.Conj_Registros.getString("camarero"));
//    		
//    		listaMesas.add(m);
//    	}
//    	return listaMesas;
//    }
//    public ArrayList<Turno> pasarTurnos() throws SQLException{
//    	ArrayList<Turno> listaTurnos = new ArrayList<Turno>();
//    	String Sentencia = "SELECT * FROM listamesas";
//    	Conj_Registros = Sentencia_SQL.executeQuery(Sentencia);
//    	while(Conj_Registros.next()) {
//    		Turno t= new Turno();
//    		t.setIdentificador(Integer.parseInt(this.Conj_Registros.getString("identificador")));
//    		t.setTipoTurno(this.Conj_Registros.getString("tipoTurno"));
//    		t.setTipoEmpleado(this.Conj_Registros.getString("tipoempleado"));
//    		
//    		listaTurnos.add(t);
//    	}
//    	return listaTurnos;
//    }
	public boolean irSiguiente() throws SQLException {
		return this.Conj_Registros.next();
	}

	public String obtenerCampo(String campo) throws SQLException {
		return this.Conj_Registros.getString(campo);
	}

	public ResultSet ejecutarSentencia(String sentencia) throws SQLException {
		return Sentencia_SQL.executeQuery(sentencia);
	}



}
