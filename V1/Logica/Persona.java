package Logica;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

import com.mysql.jdbc.log.Log;

import conexion.Conexion;

public abstract class Persona {
	Conexion con = new Conexion();
	
	Connection conexion = con.conectar();
	
	PreparedStatement stmt;
	
	private String nombre , apellido , dni , tipo_cuenta , id ,contrasena ;
	//falta historial de compra ventas resparacion

	//empleado 
	public Persona(String nombre, String apellido, String dni, String tipo_cuenta, String id, String contrasena) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.tipo_cuenta = tipo_cuenta;
		this.id = id;
		this.contrasena = contrasena;
	}
	
	
	//cliente
	public Persona(String id,String dni,String nombre, String apellido, String contrasena) {
		super();
		this.id = id;
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.contrasena = contrasena;
	}


	//test
	public Persona(int parseInt, int parseInt2, String string) {
		super();
		this.id = id;
		this.dni = dni;
		this.nombre = nombre;
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getTipo_cuenta() {
		return tipo_cuenta;
	}

	public void setTipo_cuenta(String tipo_cuenta) {
		this.tipo_cuenta = tipo_cuenta;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + ", tipo_cuenta=" + tipo_cuenta
				+ ", id=" + id + ", contrasena=" + contrasena + "]";
	}
	
	
	
	
		
}
