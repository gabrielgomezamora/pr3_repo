package Presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JComboBox;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JDateChooser;

import Dominio.GestorMesas;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ifReserva extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JComboBox cbMesa;
	private JComboBox cbComensales;
	private JComboBox cbHora;
	private JTextField txtFieldNombreCliente;
	private JButton Reservar;
	private JDateChooser dateChooser;
	private GestorMesas gestorMesas;
	private JLabel lblNumero;
	private JLabel lblHora;
	private JLabel lblComensales;
	private JLabel lblFecha;
	private JLabel lblNombre;

	/**
	 * Create the frame.
	 */
	public ifReserva(GestorMesas gestorMesas) {
		setTitle("Seleccione la Reserva");
		this.gestorMesas = gestorMesas;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 625, 311);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		{
			panel = new JPanel();
			contentPane.add(panel, BorderLayout.CENTER);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[] { 106, 298, 0, 298, 0 };
			gbl_panel.rowHeights = new int[] { 84, 84, 84, 0 };
			gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
			gbl_panel.rowWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
			panel.setLayout(gbl_panel);
			{
				lblNumero = new JLabel("Numero Mesa");
				GridBagConstraints gbc_lblNumero = new GridBagConstraints();
				gbc_lblNumero.insets = new Insets(0, 0, 5, 5);
				gbc_lblNumero.gridx = 0;
				gbc_lblNumero.gridy = 0;
				panel.add(lblNumero, gbc_lblNumero);
			}
			{
				cbMesa = new JComboBox();
				cbMesa.setToolTipText("Numero de mesa");
				cbMesa.setName("");
				cbMesa.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
				cbMesa.setMaximumRowCount(1);
				GridBagConstraints gbc_cbMesa = new GridBagConstraints();
				gbc_cbMesa.fill = GridBagConstraints.BOTH;
				gbc_cbMesa.insets = new Insets(0, 0, 5, 5);
				gbc_cbMesa.gridx = 1;
				gbc_cbMesa.gridy = 0;
				panel.add(cbMesa, gbc_cbMesa);
			}
			{
				lblHora = new JLabel("Hora:");
				GridBagConstraints gbc_lblHora = new GridBagConstraints();
				gbc_lblHora.insets = new Insets(0, 0, 5, 5);
				gbc_lblHora.anchor = GridBagConstraints.EAST;
				gbc_lblHora.gridx = 2;
				gbc_lblHora.gridy = 0;
				panel.add(lblHora, gbc_lblHora);
			}
			{
				cbHora = new JComboBox();
				cbHora.setModel(new DefaultComboBoxModel(new String[] { "13", "14", "15", "21", "22", "23" }));
				GridBagConstraints gbc_cbHora = new GridBagConstraints();
				gbc_cbHora.fill = GridBagConstraints.BOTH;
				gbc_cbHora.insets = new Insets(0, 0, 5, 0);
				gbc_cbHora.gridx = 3;
				gbc_cbHora.gridy = 0;
				panel.add(cbHora, gbc_cbHora);
			}
			{
				lblComensales = new JLabel("Comensales");
				GridBagConstraints gbc_lblComensales = new GridBagConstraints();
				gbc_lblComensales.insets = new Insets(0, 0, 5, 5);
				gbc_lblComensales.gridx = 0;
				gbc_lblComensales.gridy = 1;
				panel.add(lblComensales, gbc_lblComensales);
			}
			{
				cbComensales = new JComboBox();
				cbComensales.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5+" }));
				GridBagConstraints gbc_cbComensales = new GridBagConstraints();
				gbc_cbComensales.fill = GridBagConstraints.BOTH;
				gbc_cbComensales.insets = new Insets(0, 0, 5, 5);
				gbc_cbComensales.gridx = 1;
				gbc_cbComensales.gridy = 1;
				panel.add(cbComensales, gbc_cbComensales);
			}
			{
				lblFecha = new JLabel("Fecha:");
				GridBagConstraints gbc_lblFecha = new GridBagConstraints();
				gbc_lblFecha.insets = new Insets(0, 0, 5, 5);
				gbc_lblFecha.gridx = 2;
				gbc_lblFecha.gridy = 1;
				panel.add(lblFecha, gbc_lblFecha);
			}
			{
				dateChooser = new JDateChooser();

				dateChooser.setDateFormatString("yyyy-MM-dd");
				GridBagConstraints gbc_dateChooser = new GridBagConstraints();
				gbc_dateChooser.insets = new Insets(0, 0, 5, 0);
				gbc_dateChooser.fill = GridBagConstraints.BOTH;
				gbc_dateChooser.gridx = 3;
				gbc_dateChooser.gridy = 1;
				panel.add(dateChooser, gbc_dateChooser);
			}
			{
				lblNombre = new JLabel("Nombre");
				GridBagConstraints gbc_lblNombre = new GridBagConstraints();
				gbc_lblNombre.insets = new Insets(0, 0, 0, 5);
				gbc_lblNombre.gridx = 0;
				gbc_lblNombre.gridy = 2;
				panel.add(lblNombre, gbc_lblNombre);
			}
			{
				txtFieldNombreCliente = new JTextField();
				GridBagConstraints gbc_txtFieldNombreCliente = new GridBagConstraints();
				gbc_txtFieldNombreCliente.fill = GridBagConstraints.BOTH;
				gbc_txtFieldNombreCliente.insets = new Insets(0, 0, 0, 5);
				gbc_txtFieldNombreCliente.gridx = 1;
				gbc_txtFieldNombreCliente.gridy = 2;
				panel.add(txtFieldNombreCliente, gbc_txtFieldNombreCliente);
				txtFieldNombreCliente.setColumns(10);
			}
			{
				Reservar = new JButton("Reservar");
				Reservar.addMouseListener(new ReservarMouseListener());
				Reservar.addActionListener(new ReservarActionListener());
				GridBagConstraints gbc_Reservar = new GridBagConstraints();
				gbc_Reservar.fill = GridBagConstraints.BOTH;
				gbc_Reservar.gridx = 3;
				gbc_Reservar.gridy = 2;
				panel.add(Reservar, gbc_Reservar);
			}

		}

	}

	public void RellenarReserva(int numMesa) {
		cbMesa.setSelectedIndex(numMesa - 1);

	}

	private class ReservarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int idMesa = cbMesa.getSelectedIndex() + 1;
			int hora = Integer.parseInt((String) cbHora.getSelectedItem());
			int comensales = cbComensales.getSelectedIndex() + 1;

//			Date fecha=dateChooser.getDate();
//			java.text.SimpleDateFormat sdf =   new java.text.SimpleDateFormat("yyyy-MM-dd");
//			//String dateStr = sdf.format(fecha);
//			java.util.Date dateStr = sdf.parse(fecha);
			Calendar calendar = dateChooser.getCalendar();
			int year = calendar.get(Calendar.YEAR);
			int month = calendar.get(Calendar.MONTH);
			int day = calendar.get(Calendar.DAY_OF_MONTH);
			String fecha = (year + "-" + month + "-" + day);
			String nombre = txtFieldNombreCliente.getText();
			try {
				gestorMesas.guardarReserva(idMesa, hora, fecha, comensales, nombre);
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
		}
	}

	private class ReservarMouseListener extends MouseAdapter {
		@Override
		public void mouseEntered(MouseEvent e) {
//			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
//			LocalDate localDate = LocalDate.now();
//			String fechaActual=dtf.format(localDate); 
			Calendar cal = Calendar.getInstance();
			int yearActual = cal.get(Calendar.YEAR);
			int monthActual = cal.get(Calendar.MONTH);
			int dayActual = cal.get(Calendar.DAY_OF_MONTH);

			Calendar calendar = dateChooser.getCalendar();
			boolean finvalida=false;
			if (calendar != null) {
				int year = calendar.get(Calendar.YEAR);
				int month = calendar.get(Calendar.MONTH);
				int day = calendar.get(Calendar.DAY_OF_MONTH);
				String fecha = (year + "-" + month + "-" + day);
				
				if (yearActual >= year) {
					if (monthActual >= monthActual) {
						if (dayActual >= day) {
							Reservar.setText("Fecha Invalida");
							Reservar.setEnabled(false);
							finvalida=true;
							System.out.println("Fecha Invalida");
						}
					}

				}
			}
			boolean ninvalido=false;
			if(txtFieldNombreCliente.getText().equals("")) {
				ninvalido=true;
				Reservar.setText("Introduce Nombre");
				Reservar.setEnabled(false);
				System.out.println("Debe introducir un nombre");
			}
			if(!finvalida && !ninvalido) {
				Reservar.setText("Reservar");
				Reservar.setEnabled(true);
			}

		}
	}
}
