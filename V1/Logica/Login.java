package Logica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import conexion.Conexion;
import conexion.Verificar;

public class Login {
	/*
	String dat= "dat";
	char gi=dat.charAt(0);
	*/
	//final char tipo[] = {'c','e'};
	final char empleado[]= {'v','a','r','i','d'};
	//final String tipo_de_usuario[]={"cliente","ventas","administrador","restauracion","reparacion","deposito"};
	private boolean resul; 

	Conexion con = new Conexion();

	Connection conexion = con.conectar();

	PreparedStatement stmt;

	private int id, dni;
	private String nombre, apellido,tipo;
	
	public Login(boolean resul) {
		this.resul = resul;
	}

	public boolean isResul() {
		return resul;
	}

	public void setResul(boolean resul) {
		this.resul = resul;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
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

	public boolean TraerEmleados(String clave, String usuario) {
		String sql = "SELECT empleado.idempleado,persona.nombre,persona.apellido,persona.dni,empleado_tipo.Nombre clase FROM `empleado` INNER JOIN empleado_tipo on empleado_tipo.idempleado_tipo = empleado.empleado_tipo_idempleado_tipo INNER JOIN persona on Persona.idPersona=empleado.Persona_idPersona WHERE persona.dni = "
				+ usuario + " && empleado.clave LIKE \"" + clave + "\";";
		String[] datos = new String[5];
		try {

			stmt = conexion.prepareStatement(sql);
			ResultSet result = stmt.executeQuery();
			while (result.next()) {
				datos[0] = String.valueOf(result.getInt(1));
				datos[1] = result.getString(2);
				datos[2] = result.getString(3);
				datos[3] = String.format("%.0f", result.getFloat(4));
				datos[4] = result.getString(5);

				this.setId(Integer.parseInt(datos[0]));
				this.setNombre(datos[1]);
				this.setApellido(datos[2]);
				this.setDni(Integer.parseInt(datos[3]));
				this.setTipo(datos[4]);
				return true;
			}

			return false;

		} catch (Exception excepcion) {
			System.out.println(excepcion.getMessage());
			return false;
		}

	}

	public boolean TraerUsuarios(String clave, String usuario) {
		String sql = "SELECT cliente.idcliente,persona.nombre,persona.apellido,persona.dni FROM `cliente` INNER JOIN persona on Persona.idPersona=cliente.Persona_idPersona WHERE persona.dni = "
				+ usuario + " && cliente.clave LIKE \"" + clave + "\";";
		String[] datos = new String[5];
		try {

			stmt = conexion.prepareStatement(sql);
			ResultSet result = stmt.executeQuery();
			while (result.next()) {
				datos[0] = String.valueOf(result.getInt(1));
				datos[1] = result.getString(2);
				datos[2] = result.getString(3);
				datos[3] = String.format("%.0f", result.getFloat(4));

				this.setId(Integer.parseInt(datos[0]));
				this.setNombre(datos[1]);
				this.setApellido(datos[2]);
				this.setDni(Integer.parseInt(datos[3]));
				return true;
			}

			return false;

		} catch (Exception excepcion) {
			System.out.println(excepcion.getMessage());
			return false;
		}

	}
	

	public boolean RegistrarUsuario(String contrasena, String dni, String nombre, String apellido, String direccion,
			String altura, String telefono) {
		Verificar verificar = new Verificar();
		if (!verificar.verificarcontrasena(contrasena)) {
			do {
				contrasena = JOptionPane.showInputDialog(verificar);
			} while (!verificar.verificarcontrasena(contrasena));
		}

		if (!verificar.verificardni(dni)) {
			do {
				dni = JOptionPane.showInputDialog(verificar);
			} while (!verificar.verificardni(dni));
		}

		if (!verificar.verificarnombre(nombre)) {
			do {
				nombre = JOptionPane.showInputDialog(verificar);
			} while (!verificar.verificarnombre(nombre));
		}

		if (!verificar.verificarapellido(apellido)) {
			do {
				apellido = JOptionPane.showInputDialog(verificar);
			} while (!verificar.verificarapellido(apellido));
		}

		if (!verificar.verificardireccion(direccion)) {
			do {
				direccion = JOptionPane.showInputDialog(verificar);
			} while (!verificar.verificardireccion(direccion));
		}

		if (!verificar.verificaraltura(altura)) {
			do {
				altura = JOptionPane.showInputDialog(verificar);
			} while (!verificar.verificaraltura(altura));
		}

		if (!verificar.verificartelefono(telefono)) {
			do {
				telefono = JOptionPane.showInputDialog(verificar);
			} while (!verificar.verificartelefono(telefono));
		}

		return true;
	}


	
	
	
	
	
	
	
	
	
	
	
/*

	public String d(String value) {
	if (value.charAt(0)==tipo[0]) {
		return tipo_de_usuario[0];
	}
	if (value.charAt(0)==tipo[1]) {
		
		if (value.charAt(1)==empleado[0]) {
			return tipo_de_usuario[1];
		}	
		if (value.charAt(1)==empleado[1]) {
			return tipo_de_usuario[2];
		}	
		if (value.charAt(1)==empleado[2]) {
			return tipo_de_usuario[3];
		}	
		if (value.charAt(1)==empleado[3]) {
			return tipo_de_usuario[4];
		}	
		if (value.charAt(1)==empleado[4]) {
			return tipo_de_usuario[5];
		}	
		
		if (value.charAt(1)==' ') {
			return "error";
		}
		
	}
	
	
	
	return "0"; 
	}
	*/
	
}


