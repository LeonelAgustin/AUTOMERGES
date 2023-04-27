package Logica;

public class Vendedor extends Persona {

	private String tipo_cuenta;

	public Vendedor(String nombre, String apellido, String dni , String id, String contrasena) {
		super(nombre, apellido, dni , id, contrasena);
		this.tipo_cuenta="Vendedor";
	}

	

}
