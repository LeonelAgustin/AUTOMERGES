package Datos;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import Interfaz.Conexion;

public class Mecanico extends Persona{
	
	private int id_mecanico;
	private String claveM;
	private String turno;
	

	public Mecanico(int dni, String nombre, String apellido, String direccion, int telefono, int id_mecanico, String claveM, String turno) {
		super(dni, nombre, apellido, direccion, telefono);
		this.id_mecanico = id_mecanico;
		this.claveM = claveM;
		this.turno = turno;
	}

	public int getId_mecanico() {
		return id_mecanico;
	}

	public void setId_mecanico(int id_mecanico) {
		this.id_mecanico = id_mecanico;
	}

	public String getClaveM() {
		return claveM;
	}

	public void setClaveM(String claveM) {
		this.claveM = claveM;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	@Override
	public String toString() {
		return "Mecanico [id_mecanico=" + id_mecanico + ", claveM=" + claveM + ", turno=" + turno + "]";
	}
	public Vehiculo restaurarVehiculo () {
		return null;
	}
	
	
	public Informe completarInforme (Informe informe) {
		
		return null;
	}
	
	public Orden generarOrden () {
		String aux = "";
		JOptionPane.showMessageDialog(null, "Complete los datos requeridos para generar una Orden de solicitud de Pieza");
				
		Orden nueva = new Orden (00+(int)(Math.random()*10+1),this.getNombre(),JOptionPane.showInputDialog("Ingrese el nombre de pieza que necesita del deposito"),true);
		int a = Integer.parseInt(JOptionPane.showInputDialog("la pieza solicitada debe ser importada\n1-Si\n2-No"));
		
		if (a==1) {
			nueva.setImportada(true);
			aux = "Si"; 
		}else {
			nueva.setImportada(false);
			aux = "No";
		}
		
		JOptionPane.showMessageDialog(null, "Orden Nº "+nueva.getCodOrden()+" generada, porfavor revise los datos para enviarla a deposito\nNombre la pieza:"+nueva.getNombrePieza()+"\nImportada:"+aux+"Solicitante:"+nueva.getSolicitante());
		
		return nueva;
	}

}
