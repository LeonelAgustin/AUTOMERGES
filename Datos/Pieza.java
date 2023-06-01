package Datos;

public class Pieza {
	
	private int numero_de_sere;
	private String nombre;
	private double precio;
	private String importada;
	private int estado;
	
	public Pieza(int numero_de_sere, String nombre, double precio, String importada, int estado) {
		super();
		this.numero_de_sere = numero_de_sere;
		this.nombre = nombre;
		this.precio = precio;
		this.importada = importada;
		this.estado = estado;
	}
	public int getNumero_de_sere() {
		return numero_de_sere;
	}
	public void setNumero_de_sere(int numero_de_sere) {
		this.numero_de_sere = numero_de_sere;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public String getImportada() {
		return importada;
	}
	public void setImportada(String importada) {
		this.importada = importada;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	@Override
	public String toString() {
		return "Pieza [numero_de_sere=" + numero_de_sere + ", nombre=" + nombre + ", precio=" + precio + ", importada="
				+ importada + ", estado=" + estado + "]";
	}
	
	

}
