package Presentacion;

import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.border.TitledBorder;

import Dominio.GestorMesas;
import Dominio.Mesa;

public class PanelMesas extends JPanel {
	private JButton[] botones = new JButton[9];
	GestorMesas gestorMesas=new GestorMesas();
	/**
	 * Create the panel.
	 * @throws SQLException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public PanelMesas() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		setBorder(new TitledBorder(null, "Seleccione una mesa para reservar", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new GridLayout(3, 3, 0, 0));
		
		for (int i = 0; i < 9; i++) {
			botones[i] = new JButton(String.valueOf(i + 1));
			
			this.add(botones[i]); // añadir cada componente al contenedor (JPanel)
			botones[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					int boton=Integer.parseInt(arg0.getActionCommand());
					System.out.println(boton);
					
					try {
						
						boolean reservada = gestorMesas.ReservarMesas(boton);
						
						
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InstantiationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			
						//rellenarTabla();
					
					
					ifReserva ifreserva=new ifReserva(gestorMesas);
					ifreserva.RellenarReserva(Integer.parseInt(arg0.getActionCommand()));
					ifreserva.setVisible(true);
					System.out.println("Pulsó el botón " + arg0.getActionCommand());
					
				}
			});
		}//rellenarTabla();

	}
//	public void rellenarTabla() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
//		ArrayList<Mesa> listaTabla = new ArrayList();
//		listaTabla=gestorMesas.getListaMesas();
//		
//		for (Mesa mesa : listaTabla) {
//			if(mesa.getEstado().equalsIgnoreCase("ocupado")) {
//				botones[mesa.getIdentificador()-1].setBackground(Color.RED);
//			}else {
//				botones[mesa.getIdentificador()-1].setBackground(Color.GREEN);
//			} 
//			
//		}
//	}

}