package Dominio;

public class Reserva {

	private int idMesa;
	private int hora;
	private int comensales;
	private String fecha;
	private String nombreCliente;
	private int idReserva;
	
	public Reserva() {
		this.idMesa = 0;
		this.hora = 0;
		this.fecha= "";
		this.comensales=0;
		this.nombreCliente = "";
		this.idReserva=0;
		

	}
	public Reserva(int idMesa, int hora, String nombreCliente, int comensales) {
		super();
		this.idMesa = idMesa;
		this.hora = hora;
		this.fecha= fecha;
		this.comensales=comensales;
		this.nombreCliente = nombreCliente;
		this.idReserva=idReserva;
		

	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public int getIdReserva() {
		return idReserva;
	}
	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}
	public int getComensales() {
		return comensales;
	}
	public void setComensales(int comensales) {
		this.comensales = comensales;
	}
	public int getIdMesa() {
		return idMesa;
	}
	public void setIdMesa(int idMesa) {
		this.idMesa = idMesa;
	}
	public int getHora() {
		return hora;
	}
	public void setHora(int hora) {
		this.hora = hora;
	}
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

}
