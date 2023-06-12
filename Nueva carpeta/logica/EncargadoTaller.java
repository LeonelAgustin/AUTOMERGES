package Logica;

import java.sql.Connection;
import java.sql.PreparedStatement;

import conexion.Conexion;

public class EncargadoTaller extends Persona {
	private String idEtaller;
	private int claveE ;
	
	

	public EncargadoTaller(String nombre, String apellido,
			String dni, String id, String contrasena, String tipo_cuenta) {
		super(nombre, apellido, dni, id, contrasena);
		
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
