package logica;

public class Orden {
	private int cod_orden;
	private Mecanico responsable;
	private String nombrePieza;
	
	public Orden(int cod_orden, Mecanico responsable, String nombrePieza) {
		super();
		this.cod_orden = cod_orden;
		this.responsable = responsable;
		this.nombrePieza = nombrePieza;
	}

	public int getCod_orden() {
		return cod_orden;
	}

	public void setCod_orden(int cod_orden) {
		this.cod_orden = cod_orden;
	}

	public Mecanico getResponsable() {
		return responsable;
	}

	public void setResponsable(Mecanico responsable) {
		this.responsable = responsable;
	}

	public String getNombrePieza() {
		return nombrePieza;
	}

	public void setNombrePieza(String nombrePieza) {
		this.nombrePieza = nombrePieza;
	}

	@Override
	public String toString() {
		return "Orden [cod_orden=" + cod_orden + ", responsable=" + responsable + ", nombrePieza=" + nombrePieza + "]";
	}
	
	
}
