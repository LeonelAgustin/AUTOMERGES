package Logica;


public abstract class Persona {

	private String nombre , apellido , dni , tipo_cuenta , id ,contrasena ;
	//falta historial de compra ventas resparacion

	public Persona(String nombre, String apellido, String dni, String tipo_cuenta, String id, String contrasena) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.tipo_cuenta = tipo_cuenta;
		this.id = id;
		this.contrasena = contrasena;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getTipo_cuenta() {
		return tipo_cuenta;
	}

	public void setTipo_cuenta(String tipo_cuenta) {
		this.tipo_cuenta = tipo_cuenta;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + ", tipo_cuenta=" + tipo_cuenta
				+ ", id=" + id + ", contrasena=" + contrasena + "]";
	}
		
}
