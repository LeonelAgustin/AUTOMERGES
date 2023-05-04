package Logica;

public class Vendedor extends Persona {

	private String tipo_cuenta;

	public Vendedor(String nombre, String apellido, String dni , String id, String contrasena) {
		super(nombre, apellido, dni , id, contrasena);
		this.tipo_cuenta="Vendedor";
	}
	
	public String getTipo_cuenta() {
		return tipo_cuenta;
	}
	//solo puede modificar administrador el tipo de cuenta
	public void setTipo_cuenta(String tipo_cuenta) {
		this.tipo_cuenta = tipo_cuenta;
	}

    	
   

}
