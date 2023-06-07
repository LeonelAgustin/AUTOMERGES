package Logica;

public class Vehiculo {
	private String marca;
	private String modelo;
	private String patente; 
	private int ano; 
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
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
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
		return "vehiculo [marca=" + marca + ", modelo=" + modelo + ", patente=" + patente + ", ano=" + ano
				+ ", restauracion=" + restauracion + ", reparacion=" + reparacion + ", estado=" + estado + "]";
	}
	/*
	Vehiculo(String marca,String modelo,String patente,int año,String restaurado,int estado){
	this.setMarca(marca);
	this.setModelo(modelo);
	this.setPatente(patente);
	this.setAño(año);
	this.setRestauracion(restaurado);
	this.setEstado(estado);

	}
	*/
	public Vehiculo(String marca, String modelo, String patente, int ano, String restauracion, boolean reparacion,int estado) {
		this.marca = marca;
		this.modelo = modelo;
		this.patente = patente;
		this.ano = ano;
		this.restauracion = restauracion;
		this.reparacion = reparacion;
		this.estado = estado;
	}
	
	
	
	//ventas module //unir con juan 
	private int id;
	private String precio;
	private Cliente cliente;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPrecio() {
		return precio;
	}
	public void setPrecio(String precio) {
		this.precio = precio;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Vehiculo(int id,String patente,String marca, String modelo, int ano, int estado,Cliente cliente, String precio) {
		this.marca = marca;
		this.modelo = modelo;
		this.patente = patente;
		this.ano = ano;
		this.id = id;
		this.cliente = cliente;
		this.precio = precio;
		this.estado = estado;
	}
	
	
	
	
}
