package Presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class InterfazReservaMesa {

	public JFrame frmReservaDeMesas;
	private JPanel PnlReserva;

	/**
	 * Create the application.
	 * @throws SQLException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public InterfazReservaMesa() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	private void initialize() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		frmReservaDeMesas = new JFrame();

		frmReservaDeMesas.setVisible(true);
		frmReservaDeMesas.setTitle("Reserva");
		frmReservaDeMesas.setBounds(100, 100, 375, 318);
		frmReservaDeMesas.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		{
			PnlReserva = new PanelMesas();
			frmReservaDeMesas.getContentPane().add(PnlReserva, BorderLayout.CENTER);
			PnlReserva.setLayout(new GridLayout(3, 3, 0, 0));
		}
	}

	

	
}
