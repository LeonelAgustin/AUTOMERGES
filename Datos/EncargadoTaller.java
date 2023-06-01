package Datos;

import java.sql.Connection;
import java.sql.PreparedStatement;

import Interfaz.Conexion;

public class EncargadoTaller extends Persona {
	private String idEtaller;
	private int claveE ;
	
	

	public EncargadoTaller(int dni, String nombre,
			String apellido, String direccion, int telefono, String idEtaller, int claveE) {
		super( dni, nombre, apellido, direccion, telefono);
		this.idEtaller = idEtaller;
		this.claveE = claveE;
	}

	public String getIdEtaller() {
		return idEtaller;
	}

	public void setIdEtaller(String idEtaller) {
		this.idEtaller = idEtaller;
	}

	public int getClaveE() {
		return claveE;
	}

	public void setClaveE(int claveE) {
		this.claveE = claveE;
	}

	@Override
	public String toString() {
		return "EncargadoTaller [idEtaller=" + idEtaller + ", claveE=" + claveE + "]";
	}
	
	public Informe completarIforme (Informe informe1) {
		
		return null;
	}
	
}
