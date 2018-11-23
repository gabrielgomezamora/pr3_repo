package Dominio;

import java.sql.SQLException;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Persistencia.Agente;
import Persistencia.AgenteMesa;
import Persistencia.AgenteTurno;
import Presentacion.VisualizarTurno;

public class GestorTurno {
	private JTable ifTurnos;

	public GestorTurno(JTable ifTurnos) {

		this.ifTurnos = ifTurnos;
	}

	public void consultarTurno() {

	}

	public void visualizarTurno()
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {

		AgenteTurno agenteTurno = new AgenteTurno("turnos", "hola", "hola");
		agenteTurno.Conectar("turnos");
		Object datos[] = new Object[3];
		DefaultTableModel m = (DefaultTableModel) ifTurnos.getModel();
		agenteTurno.Obtener_Datos_Tabla("listaturnos");
		m.addColumn("Identificador");
		m.addColumn("Tipo Turno");
		m.addColumn("Tipo empleado");
		while (agenteTurno.irSiguiente()) {
			datos[0] = agenteTurno.obtenerCampo("identificador");
			datos[1] = agenteTurno.obtenerCampo("tipoTurno");
			datos[2] = agenteTurno.obtenerCampo("tipoempleado");
			m.addRow(datos);
		}

		// this.tablaTurnos.setModel(m);
		ifTurnos.setModel(m);
		// ifTurnos.setTablaTurnos(tablaTurnos);
	}

	public void asginarTurno() {

	}

}
