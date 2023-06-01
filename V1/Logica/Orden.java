package Logica;

public class Orden {
	
	private int codOrden;
	private String solicitante;
	private String nombrePieza;
	private boolean importada;
	
	public Orden(int codOrden, String solicitante, String nombrePieza, boolean importada) {
		super();
		this.codOrden = codOrden;
		this.solicitante = solicitante;
		this.nombrePieza = nombrePieza;
		this.importada = importada;
	}
	
	public int getCodOrden() {
		return codOrden;
	}

	public void setCodOrden(int codOrden) {
		this.codOrden = codOrden;
	}

	public String getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(String solicitante) {
		this.solicitante = solicitante;
	}

	public String getNombrePieza() {
		return nombrePieza;
	}

	public void setNombrePieza(String nombrePieza) {
		this.nombrePieza = nombrePieza;
	}

	public boolean isImportada() {
		return importada;
	}

	public void setImportada(boolean importada) {
		this.importada = importada;
	}

	@Override
	public String toString() {
		return "Orden [codOrden=" + codOrden + ", solicitante=" + solicitante + ", nombrePieza=" + nombrePieza
				+ ", importada=" + importada + "]";
	}
	
	
	
	
}
