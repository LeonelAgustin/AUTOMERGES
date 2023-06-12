package Logica;
import java.sql.Connection;

import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import conexion.Conexion;
public class Adminstrador extends Persona{

	private int claveA;

	public Adminstrador(String nombre, String apellido,
			String dni, String id, String contrasena, String tipo_cuenta) {
		super(nombre, apellido, dni, id, contrasena);
	}
	
	public void verEmpleados() {
		
	}
	public void despedirEmpleado() {
		
	}
}
