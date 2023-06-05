package logica;

import java.util.Arrays;

public class Informe {

    private Cliente cliente;
    private Pieza pieza;
    private Vehiculo vehiculo;
    final public String transaccion[] ={"compra","venta","reparacion","restauracion"};
    private String asunto;
    private boolean isfactura;
    private boolean isauto;
    //private double precio;
    //
	public Informe(Cliente cliente, Vehiculo vehiculo,int tipo,boolean isfactura) {
		this.cliente = cliente;
		this.vehiculo = vehiculo;
		this.asunto=transaccion[tipo];
		this.isfactura =isfactura;
		this.isauto=true;
	}
	
	public Informe(Cliente cliente, Pieza pieza,int tipo,boolean isfactura) {
		this.cliente = cliente;
		this.pieza = pieza;
		this.asunto=transaccion[tipo];
		this.isfactura = isfactura;
		this.isauto=false;
	}
	
	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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

	public boolean isIsfactura() {
		return isfactura;
	}

	public void setIsfactura(boolean isfactura) {
		this.isfactura = isfactura;
	}
	
	

	@Override
	public String toString() {
		if (isfactura) {
			if (isauto) {
				return "factura \n cliente=" + cliente + "\n  auto=" + vehiculo + "\n asunto=" + asunto ;
			}
			return "factura \n cliente=" + cliente + "\n pieza=" + pieza + "asunto=" + asunto ;
		}else {
			if (isauto) {
				return "Informe \n cliente=" + cliente + "\n  auto=" + vehiculo + "\n asunto=" + asunto ;
			}
			return "Informe \n cliente=" + cliente + "\n pieza=" + pieza + "asunto=" + asunto ;
		}
		
	}

	
	
   
}
