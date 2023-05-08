package logica;



public class Vehiculo {
	private Cliente duenio;
	private String marca;
	private String modelo;
	private String patente;
	private int anio;
	private String restauracion;
	private boolean reparacion;
	private int estado;
	
	
	
	public Vehiculo(Cliente duenio, String marca, String modelo, String patente, int anio, String restauracion,
			boolean reparacion, int estado) {
		super();
		this.duenio = duenio;
		this.marca = marca;
		this.modelo = modelo;
		this.patente = patente;
		this.anio = anio;
		this.restauracion = restauracion;
		this.reparacion = reparacion;
		this.estado = estado;
	}

	Vehiculo(String marca, String modelo, String patente, int anio, String restaurado, int estado) {
		this.setMarca(marca);
		this.setModelo(modelo);
		this.setPatente(patente);
		this.setAnio(anio);
		this.setRestauracion(restaurado);
		this.setEstado(estado);

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

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
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
		return "vehiculo [marca=" + marca + ", modelo=" + modelo + ", patente=" + patente + ", a�o=" + anio
				+ ", restauracion=" + restauracion + ", reparacion=" + reparacion + ", estado=" + estado + "]";
	}

	

}
