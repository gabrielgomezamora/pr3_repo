package Dominio;

import java.awt.BorderLayout;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Persistencia.Agente;
import Persistencia.AgenteMesa;
import Persistencia.AgenteTurno;
import Presentacion.VisualizarTurno;

public class GestorTurno {
	private JTable ifTurnos;
	private AgenteTurno agenteTurno;
	private ArrayList<Turno> listaTurnos;




	public GestorTurno(JTable ifTurnos) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		this.agenteTurno = new AgenteTurno("turnos", "hola", "hola");
		this.ifTurnos = ifTurnos;
	}


	public void visualizarTurno()
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {

		//AgenteTurno agenteTurno = ;
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

	public void modificarTurno() throws SQLException {
		listaTurnos = agenteTurno.pasarTurnos();
		ArrayList<Turno> listaTurnosTemp = new ArrayList<Turno>();
		for (int i = 0; i < listaTurnos.size(); i++) {
			
			Turno nuevo = new Turno();
			for (int j = 0; j < 3; j++) {
				String valor=ifTurnos.getValueAt(i, j).toString();

				if (j == 0) {
					nuevo.setIdentificador(Integer.parseInt(valor));
					
				} else if (j == 1) {
					nuevo.setTipoTurno(valor);
				} else if (j == 2) {
					nuevo.setTipoEmpleado(valor);
				}
			}

			listaTurnosTemp.add(nuevo);
			}
		listaTurnos=listaTurnosTemp;
		for (Turno turno : listaTurnos) {
			agenteTurno.actualizarTurno(turno.getIdentificador(), turno.getTipoEmpleado(), turno.getTipoTurno());
		}

	}

}
