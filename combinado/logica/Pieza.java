package logica;

public class Pieza {
	private int numero_de_sere;

	private double precio;
	private String importada;
	private String estado;
	
	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


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


	public Pieza(int numero_de_sere, double precio, String importada, String estado) {
		super();
		this.numero_de_sere = numero_de_sere;
		this.precio = precio;
		this.importada = importada;
		this.estado = estado;
	}


	


}
