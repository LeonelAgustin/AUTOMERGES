package automerges;

public class Fabricante {
	private int id_frabicante;
	private String claveF;
	
	public Fabricante(int id_frabicante, String claveF) {
		super();
		this.id_frabicante = id_frabicante;
		this.claveF = claveF;
	}

	public int getId_frabicante() {
		return id_frabicante;
	}

	public void setId_frabicante(int id_frabicante) {
		this.id_frabicante = id_frabicante;
	}

	public String getClaveF() {
		return claveF;
	}

	public void setClaveF(String claveF) {
		this.claveF = claveF;
	}

	@Override
	public String toString() {
		return "Fabricante [id_frabicante=" + id_frabicante + ", claveF=" + claveF + "]";
	}
	
	
}
