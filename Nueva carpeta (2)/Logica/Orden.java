package Logica;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import conexion.Conexion;

public class Orden {
	
	private int codOrden;
	private String solicitante;
	private String nombrePieza;
	private boolean importada;
	
	Conexion con =  new Conexion();;
	
	Connection conexion = con.conectar();
	
	PreparedStatement stmt;
	
	public Orden(int codOrden, String solicitante, String nombrePieza, boolean importada) {
		super();
		this.codOrden = codOrden;
		this.solicitante = solicitante;
		this.nombrePieza = nombrePieza;
		this.importada = importada;
	}
	
	public int getCodOrden() {
		return codOrden;
	}

	public void setCodOrden(int codOrden) {
		this.codOrden = codOrden;
	}

	public String getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(String solicitante) {
		this.solicitante = solicitante;
	}

	public String getNombrePieza() {
		return nombrePieza;
	}

	public void setNombrePieza(String nombrePieza) {
		this.nombrePieza = nombrePieza;
	}

	public boolean isImportada() {
		return importada;
	}

	public void setImportada(boolean importada) {
		this.importada = importada;
	}

	@Override
	public String toString() {
		return "Orden [codOrden=" + codOrden + ", solicitante=" + solicitante + ", nombrePieza=" + nombrePieza
				+ ", importada=" + importada + "]";
	}
	
	public boolean generarOrden() {
		int cant=0,idtaller=0;
		String sql ="INSERT INTO `orden`(`idorden`, `nombrePieza`, `cantidad`, `taller_idtaller`, `Importada`) VALUES (?,?,?,?,?) ";
		
		try {
			stmt = conexion.prepareStatement(sql);
			stmt.setInt(1, this.getCodOrden());
			stmt.setString(2, this.getNombrePieza());
			stmt.setInt(3, cant);
			stmt.setInt(4,idtaller);
			stmt.setBoolean(5,this.isImportada());
			stmt.executeUpdate();
			return true;
			
		} catch (Exception e) {
			System.out.println("Hubo un error"+e.getMessage());
			return false;
		}
	}
	
	public LinkedList<Orden> mostrarOrden() {
		
		return null;
	}
	
	
}
