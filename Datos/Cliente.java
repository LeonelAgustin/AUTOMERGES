package Datos;

public class Cliente extends Persona {

	private int idCliente;
	private Vehiculo automovil;
	
	public Cliente(int dni, String nombre, String apellido, String direccion, int telefono, int idCliente,
			Vehiculo automovil) {
		super(dni, nombre, apellido, direccion, telefono);
		this.idCliente = idCliente;
		this.automovil = automovil;
	}
	
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public Vehiculo getAutomovil() {
		return automovil;
	}
	public void setAutomovil(Vehiculo automovil) {
		this.automovil = automovil;
	}
	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", automovil=" + automovil + "]";
	}	
	
}
