package Logica;

public class Ventas {

    private Cliente cliente;
    private Pieza pieza;
    private Auto auto;
    final public String transaccion[] ={"compra","venta","reparacion","restauracion"};
    private String asunto;
    //private double precio;
    //
	public Ventas(Cliente cliente, Auto auto,int tipo) {
		this.cliente = cliente;
		this.auto = auto;
		this.asunto=transaccion[tipo];
	}
	
	public Ventas(Cliente cliente, Pieza pieza,int tipo) {
		this.cliente = cliente;
		this.pieza = pieza;
		this.asunto=transaccion[tipo];
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Auto getAuto() {
		return auto;
	}
	public void setAuto(Auto auto) {
		this.auto = auto;
	}
	public Pieza getPieza() {
		return pieza;
	}
	public void setPieza(Pieza pieza) {
		this.pieza = pieza;
	}
	public String getasunto() {
		return asunto;
	}
	public void setasunto(String asunto) {
		this.asunto = asunto;
	}
    	
   
}
