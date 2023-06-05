package logica;

import java.util.ArrayList;

public class EncargadoDeposito extends Persona{
	private int id_encarDepo;
	private int claveD;
	
	public EncargadoDeposito(String nombre, String apellido, String dni, String tipo_cuenta, String id,
			String contrasena, int id_encarDepo, int claveD) {
		super(nombre, apellido, dni, tipo_cuenta, id, contrasena);
		this.id_encarDepo = id_encarDepo;
		this.claveD = claveD;
	}

	public int getId_encarDepo() {
		return id_encarDepo;
	}

	public void setId_encarDepo(int id_encarDepo) {
		this.id_encarDepo = id_encarDepo;
	}

	public int getClaveD() {
		return claveD;
	}

	public void setClaveD(int claveD) {
		this.claveD = claveD;
	}

	@Override
	public String toString() {
		return "EncargadoDeposito [id_encarDepo=" + id_encarDepo + ", claveD=" + claveD + "]";
	}
		
}
