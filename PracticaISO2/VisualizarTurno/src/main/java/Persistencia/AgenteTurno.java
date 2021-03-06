package Persistencia;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;



import Dominio.Turno;

public class AgenteTurno {

    private java.sql.Connection Conex;
    private java.sql.Statement Sentencia_SQL;
    private java.sql.ResultSet Conj_Registros;

    private Agente agente;


    public AgenteTurno(String b, String u, String c) throws ClassNotFoundException,
            InstantiationException, IllegalAccessException, SQLException {

        agente=new Agente(b,u,c);
        
    }


    public void Obtener_Datos_Tabla(String nom_tabla) throws SQLException {
        int cont = 0;
        String Sentencia = "SELECT * FROM " + nom_tabla;
        Conj_Registros = agente.ejecutarSentencia(Sentencia);
    }



    public ArrayList<Turno> pasarTurnos() throws SQLException{
    	ArrayList<Turno> listaTurnos = new ArrayList<Turno>();
    	String Sentencia = "SELECT * FROM listaturnos";
    	Conj_Registros = agente.ejecutarSentencia(Sentencia);
    	while(Conj_Registros.next()) {
    		Turno t= new Turno();
    		t.setIdentificador(Integer.parseInt(this.Conj_Registros.getString("identificador")));
    		t.setTipoTurno(this.Conj_Registros.getString("tipoTurno"));
    		t.setTipoEmpleado(this.Conj_Registros.getString("tipoempleado"));
    		
    		listaTurnos.add(t);
    	}
    	return listaTurnos;
    }


    public void actualizarTurno(int identificador, String tipo, String turno) throws SQLException {
		String nom_tabla = "listaturnos";
		String Sentencia = "update " + nom_tabla + " set tipoTurno='" + turno + "', tipoempleado='" + tipo 
				+ "'  where identificador='" + identificador + "'";
		agente.insertarFila(Sentencia);
	}

	public void Conectar(String nombre_bbdd) throws SQLException {
		agente.Conectar(nombre_bbdd);
		
	}


	public Object obtenerCampo(String campo) throws SQLException {
		
		return this.Conj_Registros.getString(campo);
	}


	public boolean irSiguiente() throws SQLException {
	
		return this.Conj_Registros.next();
	}






}