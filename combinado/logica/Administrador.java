package logica;

public class Administrador extends Persona{
	private int id_admin;
	private String claveA;
	
	public Administrador(String nombre, String apellido, String dni, String tipo_cuenta, String id, String contrasena,
			int id_admin, String claveA) {
		super(nombre, apellido, dni, tipo_cuenta, id, contrasena);
		this.id_admin = id_admin;
		this.claveA = claveA;
	}
	public int getId_admin() {
		return id_admin;
	}
	public void setId_admin(int id_admin) {
		this.id_admin = id_admin;
	}
	public String getClaveA() {
		return claveA;
	}
	public void setClaveA(String claveA) {
		this.claveA = claveA;
	}
	@Override
	public String toString() {
		return "Administrador [id_admin=" + id_admin + ", claveA=" + claveA + "]";
	}
	
	public Informe realizarInforme(Informe informe, Cliente cliente ){
		return null;
	}
}
