package Logica;

import java.util.Arrays;

public class Informe {

	private int codinforme;
    private Cliente cliente;
    private Pieza pieza;
    private Vehiculo vehiculo;
    final public String transaccion[] ={"compra","venta","reparacion","restauracion"};
    private String asunto;
    private boolean isfactura;
    private boolean isauto;
    //private double precio;
    
	public Informe(int codinforme,Cliente cliente, Vehiculo vehiculo,int tipo,boolean isfactura) {
		this.cliente = cliente;
		this.vehiculo = vehiculo;
		this.asunto=transaccion[tipo];
		this.isfactura =isfactura;
		this.isauto=true;
	}
	
	public Informe(int codinforme,Cliente cliente, Pieza pieza,int tipo,boolean isfactura) {
		this.cliente = cliente;
		this.pieza = pieza;
		this.asunto=transaccion[tipo];
		this.isfactura = isfactura;
		this.isauto=false;
	}
	
	
	public int getCodinforme() {
		return codinforme;
	}

	public void setCodinforme(int codinforme) {
		this.codinforme = codinforme;
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
				return "factura \ncliente=" + cliente.getNombre() +"  "+ cliente.getApellido() + "\nauto=" + vehiculo.getMarca() + "  "+ vehiculo.getModelo() + "\nasunto=" + asunto ;
			}
			return "factura \ncliente=" + cliente.getNombre() +"  "+ cliente.getApellido() + "\npieza=" + pieza.getNumero_de_sere() + "\nasunto=" + asunto ;
		}else {
			if (isauto) {
				return "Informe \ncliente=" + cliente.getNombre() +"  "+ cliente.getApellido() + "\nauto=" +  vehiculo.getMarca() + "  "+ vehiculo.getModelo() + "\nasunto=" + asunto ;
			}
			return "Informe \ncliente=" + cliente.getNombre() +"  "+ cliente.getApellido() + "\npieza=" + pieza.getNumero_de_sere() + "\nasunto=" + asunto ;
		}
		
	}

	
	
   
}
