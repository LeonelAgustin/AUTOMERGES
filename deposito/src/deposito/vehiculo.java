package deposito;
import java.util.ArrayList;
public class vehiculo {
private String marca;
private String modelo;
private String patente; 
private int a�o; 
private String restauracion;
private boolean reparacion;
private int estado;

public int getEstado() {
	return estado;
}
public void setEstado(int estado) {
	this.estado = estado;
}
public String getMarca() {
	return marca;
}
public void setMarca(String marca) {
	this.marca = marca;
}
public String getModelo() {
	return modelo;
}
public void setModelo(String modelo) {
	this.modelo = modelo;
}
public String getPatente() {
	return patente;
}
public void setPatente(String patente) {
	this.patente = patente;
}
public int getA�o() {
	return a�o;
}
public void setA�o(int a�o) {
	this.a�o = a�o;
}

public void setRestauracion(String restauracion) {
	this.restauracion = restauracion;
}
public boolean isReparacion() {
	return reparacion;
}
public void setReparacion(boolean reparacion) {
	this.reparacion = reparacion;
}
@Override
public String toString() {
	return "vehiculo [marca=" + marca + ", modelo=" + modelo + ", patente=" + patente + ", a�o=" + a�o
			+ ", restauracion=" + restauracion + ", reparacion=" + reparacion + ", estado=" + estado + "]";
}
vehiculo(String marca,String modelo,String patente,int a�o,String restaurado,int estado){
this.setMarca(marca);
this.setModelo(modelo);
this.setPatente(patente);
this.setA�o(a�o);
this.setRestauracion(restaurado);
this.setEstado(estado);

}


}
