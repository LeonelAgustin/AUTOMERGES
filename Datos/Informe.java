package Datos;

import java.util.Arrays;

public class Informe {
	
	private int cod_inf;
	private String asunto;
    private Cliente cliente;
    private Vehiculo vehiculo;
    private Pieza pieza;
    final public String transaccion[] ={"compra","venta","reparacion","restauracion"};
    private String materiales;
    private boolean terminado;
    private int horasT;
    private Mecanico mecanico;
    
	public Informe(int cod_inf, String asunto, Cliente cliente, Vehiculo vehiculo, Pieza pieza, String materiales,
			boolean terminado, int horasT, Mecanico mecanico) {
		super();
		this.cod_inf = cod_inf;
		this.asunto = asunto;
		this.cliente = cliente;
		this.vehiculo = vehiculo;
		this.pieza = pieza;
		this.materiales = materiales;
		this.terminado = terminado;
		this.horasT = horasT;
		this.mecanico = mecanico;
	}
	
	public int getCod_inf() {
		return cod_inf;
	}
	public void setCod_inf(int cod_inf) {
		this.cod_inf = cod_inf;
	}
	public String getAsunto() {
		return asunto;
	}
	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Vehiculo getVehiculo() {
		return vehiculo;
	}
	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}
	public Pieza getPieza() {
		return pieza;
	}
	public void setPieza(Pieza pieza) {
		this.pieza = pieza;
	}
	public String getMateriales() {
		return materiales;
	}
	public void setMateriales(String materiales) {
		this.materiales = materiales;
	}
	public boolean isTerminado() {
		return terminado;
	}
	public void setTerminado(boolean terminado) {
		this.terminado = terminado;
	}
	public int getHorasT() {
		return horasT;
	}
	public void setHorasT(int horasT) {
		this.horasT = horasT;
	}
	public Mecanico getMecanico() {
		return mecanico;
	}
	public void setMecanico(Mecanico mecanico) {
		this.mecanico = mecanico;
	}
	public String[] getTransaccion() {
		return transaccion;
	}
    
	
   
}
