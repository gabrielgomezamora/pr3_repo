package Dominio;

public class Turno {
int identificador;
String tipoTurno;
String tipoEmpleado;
public Turno() {
	this.identificador =0;
	this.tipoTurno = "";
	this.tipoEmpleado = "";
}
public Turno(int identificador, String tipoTurno, String tipoEmpleado) {
	this.identificador = identificador;
	this.tipoTurno = tipoTurno;
	this.tipoEmpleado = tipoEmpleado;
}
public int getIdentificador() {
	return identificador;
}
public void setIdentificador(int identificador) {
	this.identificador = identificador;
}
public String getTipoTurno() {
	return tipoTurno;
}
public void setTipoTurno(String tipoTurno) {
	this.tipoTurno = tipoTurno;
}
public String getTipoEmpleado() {
	return tipoEmpleado;
}
public void setTipoEmpleado(String tipoEmpleado) {
	this.tipoEmpleado = tipoEmpleado;
}

}
