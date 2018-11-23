package Presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;

import Dominio.GestorTurno;
import Persistencia.Agente;

import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class InterfazPrincipal {
	private JFrame frame;
	private JButton btnReservaMesa;
	private JButton btnVisualizarTurnos;
	

	/**
	 * Create the application.
	 * @throws SQLException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public InterfazPrincipal() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	private void initialize() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		frame.getContentPane().setLayout(gridBagLayout);
		{
			btnReservaMesa = new JButton("Reserva Mesa");
			btnReservaMesa.addActionListener(new BtnNewButtonActionListener());
			GridBagConstraints gbc_btnReservaMesa = new GridBagConstraints();
			gbc_btnReservaMesa.fill = GridBagConstraints.HORIZONTAL;
			gbc_btnReservaMesa.gridheight = 2;
			gbc_btnReservaMesa.gridwidth = 3;
			gbc_btnReservaMesa.insets = new Insets(0, 0, 5, 5);
			gbc_btnReservaMesa.gridx = 2;
			gbc_btnReservaMesa.gridy = 4;
			frame.getContentPane().add(btnReservaMesa, gbc_btnReservaMesa);
		}
		{
			btnVisualizarTurnos = new JButton("Visualizar Turnos");
			btnVisualizarTurnos.addActionListener(new BtnVisualizarTurnosActionListener());
			GridBagConstraints gbc_btnVisualizarTurnos = new GridBagConstraints();
			gbc_btnVisualizarTurnos.fill = GridBagConstraints.VERTICAL;
			gbc_btnVisualizarTurnos.insets = new Insets(0, 0, 5, 0);
			gbc_btnVisualizarTurnos.gridheight = 2;
			gbc_btnVisualizarTurnos.gridx = 6;
			gbc_btnVisualizarTurnos.gridy = 4;
			frame.getContentPane().add(btnVisualizarTurnos, gbc_btnVisualizarTurnos);
		}
		frame.setVisible(true);
	}

	private class BtnNewButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			InterfazReservaMesa v = null;
			try {
				v = new InterfazReservaMesa();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			v.frmReservaDeMesas.setVisible(true);
		}
	}

	private class BtnVisualizarTurnosActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			VisualizarTurno turno=new VisualizarTurno();
			turno.frmTurnos.setVisible(true);

			GestorTurno gestTurno=null;
			try {
				gestTurno = new GestorTurno(turno.getTablaTurnos());
			} catch (ClassNotFoundException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			} catch (InstantiationException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			} catch (IllegalAccessException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
			try {
				gestTurno.visualizarTurno();
				turno.setGestorTurno(gestTurno);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
