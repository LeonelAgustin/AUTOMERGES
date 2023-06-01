package Datos;

public class Vehiculo {
	private String marca;
	private String modelo;
	private String patente; 
	private int anio; 
	private boolean restauracion;
	private boolean reparacion;
	private int estado;

	
	public Vehiculo(String marca, String modelo, String patente, int anio, boolean restauracion, boolean reparacion,
			int estado) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.patente = patente;
		this.anio = anio;
		this.restauracion = restauracion;
		this.reparacion = reparacion;
		this.estado = estado;
	}
	
	public boolean isRestauracion() {
		return restauracion;
	}

	public void setRestauracion(boolean restauracion) {
		this.restauracion = restauracion;
	}

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
	public int getAno() {
		return anio;
	}
	public void setAno(int ano) {
		this.anio = ano;
	}

	
	
	public boolean isReparacion() {
		return reparacion;
	}
	public void setReparacion(boolean reparacion) {
		this.reparacion = reparacion;
	}
	@Override
	public String toString() {
		return "vehiculo [marca=" + marca + ", modelo=" + modelo + ", patente=" + patente + ", anio=" + anio
				+ ", restauracion=" + restauracion + ", reparacion=" + reparacion + ", estado=" + estado + "]";
	}
	
	
	
	
}
