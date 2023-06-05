package logica;

public class Cliente extends Persona {

	private String tipo_cuenta;

	public Cliente(String nombre, String apellido, String dni, String id, String contrasena) {
		super(nombre, apellido, dni, id, contrasena);
		this.tipo_cuenta="cliente";
	}

	
	
}
