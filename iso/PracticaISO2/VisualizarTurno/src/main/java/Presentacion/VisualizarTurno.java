package Presentacion;

import java.awt.EventQueue;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;

public class VisualizarTurno {

	public JFrame frmTurnos;
	private JTable tablaTurnos;



	/**
	 * Create the application.
	 */
	public VisualizarTurno() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTurnos = new JFrame();
		frmTurnos.setVisible(true);
		frmTurnos.setBounds(100, 100, 450, 300);
		frmTurnos.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		{
			setTablaTurnos(new JTable());
			frmTurnos.getContentPane().add(getTablaTurnos(), BorderLayout.CENTER);
		}
	}

	public void setTablaTurnos(JTable tablaTurnos) {
		this.tablaTurnos = tablaTurnos;
	}

	public JTable getTablaTurnos() {
		return tablaTurnos;
	}






}
