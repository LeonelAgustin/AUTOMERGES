package Logica;

public class Pieza {
	private int numero_de_sere;
	public int getEstado() {
		return estado;
	}


	public void setEstado(int estado) {
		this.estado = estado;
	}


	private double precio;
	private String importada;
	private int estado;
	
	public int getNumero_de_sere() {
		return numero_de_sere;
	}


	public void setNumero_de_sere(int numero_de_sere) {
		this.numero_de_sere = numero_de_sere;
	}


	public double getPrecio() {
		return precio;
	}


	@Override
	public String toString() {
		return "pieza [numero_de_sere=" + numero_de_sere + ", precio=" + precio + ", importada=" + importada
				+ ", estado=" + estado + "]";
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


	public Pieza(int num,double precio,String importada,int estado){
		this.setNumero_de_sere(num);
		this.setPrecio(precio);
		this.setImportada(importada);
		this.setEstado(estado);
	}


	//cambiar en pieza final
	
	private String nombre_pieza;
	public String getNombre_pieza() {
		return nombre_pieza;
	}


	public void setNombre_pieza(String nombre_pieza) {
		this.nombre_pieza = nombre_pieza;
	}


	public Pieza(int numero_de_sere, double precio, String nombre_pieza) {
		this.numero_de_sere = numero_de_sere;
		this.precio = precio;
		this.nombre_pieza = nombre_pieza;
	}
	
	
	
}
