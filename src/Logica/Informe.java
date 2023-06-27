package Logica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Arrays;
import java.util.LinkedList;

import conexion.Conexion;

public class Informe {
	
	Conexion con = new Conexion();	
	
	Connection conexion = con.conectar();
	
	PreparedStatement stmt;
	
	LinkedList <Informe> informes=new LinkedList <Informe>();
	
	private String cargado="";
	
	private int codinforme;
	private Cliente cliente;
	private Pieza pieza;
	private Vehiculo vehiculo;
	final public String transaccion[] = { "compra", "venta", "reparacion", "restauracion" };
	private String asunto;
	private boolean isfactura;
	private boolean isauto;

	public Informe(int codinforme, Cliente cliente, Vehiculo vehiculo, int tipo, boolean isfactura) {
		this.cliente = cliente;
		this.vehiculo = vehiculo;
		this.asunto = transaccion[tipo];
		this.isfactura = isfactura;
		this.isauto = true;
	}

	public Informe(int codinforme, Cliente cliente, Pieza pieza, int tipo, boolean isfactura) {
		this.cliente = cliente;
		this.pieza = pieza;
		this.asunto = transaccion[tipo];
		this.isfactura = isfactura;
		this.isauto = false;
	}

	public String getCargado() {
		return cargado;
	}

	public void setCargado(String cargado) {
		this.cargado = cargado;
	}

	public LinkedList<Informe> getInformes() {
		return informes;
	}

	public void setInformes(LinkedList<Informe> informes) {
		this.informes = informes;
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
				return "factura \ncliente=" + cliente.getNombre() + "  " + cliente.getApellido() + "\nauto="
						+ vehiculo.getMarca() + "  " + vehiculo.getModelo() + "\nasunto=" + asunto;
			}
			return "factura \ncliente=" + cliente.getNombre() + "  " + cliente.getApellido() + "\npieza="
					+ pieza.getNumero_de_sere() + "\nasunto=" + asunto;
		} else {
			if (isauto) {
				return "Informe \ncliente=" + cliente.getNombre() + "  " + cliente.getApellido() + "\nauto="
						+ vehiculo.getMarca() + "  " + vehiculo.getModelo() + "\nasunto=" + asunto;
			}
			return "Informe \ncliente=" + cliente.getNombre() + "  " + cliente.getApellido() + "\npieza="
					+ pieza.getNumero_de_sere() + "\nasunto=" + asunto;
		}

	}

	public String verInformes() {

String sql = "SELECT informe.idinforme, informe.asunto, informe.Hora_de_trabajo, informe.materiales,estados.estado,vehiculo.marca,vehiculo.modelo,vehiculo.año\n"
				+ "FROM informe\n"
				+ "INNER join estados\n"
				+ "on informe.estados_idestados = estados.idestados\n"
				+ "INNER JOIN vehiculo\n"
				+ "on vehiculo.Id_auto = informe.Vehiculo_Id_auto\n"
				+ "INNER JOIN accion\n"
				+ "on vehiculo.accion_idaccion = accion.idaccion\n"
				+ ";";
		String datos = " ";

		try {

			stmt = conexion.prepareStatement(sql);

			ResultSet result = stmt.executeQuery();

			while (result.next()) {
				cargado += "Infor Nº:"+String.valueOf(result.getInt(1));
				cargado += "_Asunto: "+result.getString(2);
				cargado += "_Horas trabajo: "+String.valueOf(result.getInt(3));
				cargado += "_Materiales: "+result.getString(4);
				cargado += "_Estado: "+result.getString(5);
				cargado += "_Marca: "+result.getString(6);
				cargado += "_Modelo: "+result.getString(7);
				cargado += "_año:"+String.valueOf(result.getInt(8))+"\n";
				
				conexion.close();
				return cargado;
			}

			return null;

		} catch (Exception excepcion) {
			System.out.println(excepcion.getMessage());
			return null;
		}

	}

}
