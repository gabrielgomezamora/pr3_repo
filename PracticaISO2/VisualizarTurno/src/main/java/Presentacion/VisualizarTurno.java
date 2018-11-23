package Presentacion;

import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Dominio.GestorTurno;
import Dominio.Mesa;
import Dominio.Turno;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VisualizarTurno {

	public JFrame frmTurnos;
	private JTable tablaTurnos;
	private JButton btnNewButton;
	private JPanel panel;
	private JButton btnModificar;
	private ArrayList<Turno> listaTurnos;
	private GestorTurno gestorTurno;


	public ArrayList<Turno> getListaTurnos() {
		return listaTurnos;
	}

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
		{
			panel = new JPanel();
			frmTurnos.getContentPane().add(panel, BorderLayout.SOUTH);
			{
				btnModificar = new JButton("Modificar");
				btnModificar.addActionListener(new BtnModificarActionListener());
				panel.add(btnModificar);
			}
		}
	
	}

	public void setGestorTurno(GestorTurno gestorTurno) {
		this.gestorTurno = gestorTurno;
	}

	public void setTablaTurnos(JTable tablaTurnos) {
		this.tablaTurnos = tablaTurnos;
		tablaTurnos.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
	}

	public JTable getTablaTurnos() {
		return tablaTurnos;
	}






	private class BtnModificarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				gestorTurno.modificarTurno();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
