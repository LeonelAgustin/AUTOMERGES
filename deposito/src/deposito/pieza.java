package deposito;

public class pieza {
	private int numero_de_sere;
	private String nombre;
	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	private double precio;
	private String importada;
	private int estado;
	
	public int getEstado() {
		return estado;
	}


	public void setEstado(int estado) {
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
		return "pieza [numero_de_sere=" + numero_de_sere + ", nombre=" + nombre + ", precio=" + precio + ", importada="
				+ importada + ", estado=" + estado + "]";
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


	public pieza(String nombre,int num,double precio,String importada,int estado){
		this.setNombre(nombre);
		this.setNumero_de_sere(num);
		this.setPrecio(precio);
		this.setImportada(importada);
		this.setEstado(estado);
	}


	
}
