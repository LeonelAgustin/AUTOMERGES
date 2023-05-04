package Logica;

public class Ventas {

    private Persona persona;
    private Pieza pieza;
    private Auto auto;
    final public String transaccion[] ={"compra","venta","reparacion","restauracion"};
    private String tipo_transaccion;
    //
	public Ventas(Persona persona, Auto auto,int tipo) {
		super();
		this.persona = persona;
		this.auto = auto;
		this.tipo_transaccion=transaccion[tipo];
	}
	public Ventas(Persona persona, Pieza pieza,int tipo) {
		super();
		this.persona = persona;
		this.pieza = pieza;
		this.tipo_transaccion=transaccion[tipo];
	}
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
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
	public String getTipo_transaccion() {
		return tipo_transaccion;
	}
	public void setTipo_transaccion(String tipo_transaccion) {
		this.tipo_transaccion = tipo_transaccion;
	}
    	
   
}
