package Dominio;

public class Mesa {

	private int identificador;
	private String estado;
	private String camareroMesa;

	public int getIdentificador() {
		return identificador;
	}
	

	public Mesa() {
		this.identificador = 0;
		this.estado = "";
		this.camareroMesa = "";
	}


	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCamareroMesa() {
		return camareroMesa;
	}

	public void setCamareroMesa(String camareroMesa) {
		this.camareroMesa = camareroMesa;
	}
}
