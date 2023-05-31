package deposito;
import java.util.ArrayList;
public class vehiculo {
private String marca;
private String modelo;
private String patente; 
private int año; 
private String restauracion;
private boolean reparacion;
private String estado;

public String getRestauracion() {
	return restauracion;
}
public String getEstado() {
	return estado;
}
public void setEstado(String estado) {
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
public int getAño() {
	return año;
}
public void setAño(int año) {
	this.año = año;
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
	return " AUTOS:"+"Marca auto =" + marca + ", Modelo de auto =" + modelo + ", Patente =" + patente + ", año de fabricacion=" + año
			+ ", Fue restaurado =" + restauracion + ", Estado del auto =" + estado;
}
vehiculo(String marca,String modelo,String patente,int año,String restaurado,String estado){
this.setMarca(marca);
this.setModelo(modelo);
this.setPatente(patente);
this.setAño(año);
this.setRestauracion(restaurado);
this.setEstado(estado);

}


}
