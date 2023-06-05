package logica;

public class Informe1 {
	
	private int cod_informe;
    private Cliente cliente;
    private Pieza pieza;
    private String materiales;
    private Vehiculo auto;
    final public String transaccion[] ={"compra","venta","reparacion","restauracion"};
    private String asunto;
    private double precio;
    private boolean terminado;
    private int horasT;
    private Mecanico empleado;
    
	public Informe1(Cliente cliente, Vehiculo auto,int tipo) {
		this.cliente = cliente;
		this.auto = auto;
		this.asunto=transaccion[tipo];
	}
	
	public Informe1(Cliente cliente, Pieza pieza,int tipo) {
		this.cliente = cliente;
		this.pieza = pieza;
		this.asunto=transaccion[tipo];
	}
	
	
	
	public String getMateriales() {
		return materiales;
	}

	public void setMateriales(String materiales) {
		this.materiales = materiales;
	}

	public int getHorasT() {
		return horasT;
	}

	public void setHorasT(int horasT) {
		this.horasT = horasT;
	}

	public Mecanico getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Mecanico empleado) {
		this.empleado = empleado;
	}

	public int getCod_informe() {
		return cod_informe;
	}

	public void setCod_informe(int cod_informe) {
		this.cod_informe = cod_informe;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public boolean isTerminado() {
		return terminado;
	}

	public void setTerminado(boolean terminado) {
		this.terminado = terminado;
	}

	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Vehiculo getAuto() {
		return auto;
	}
	public void setAuto(Vehiculo auto) {
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
