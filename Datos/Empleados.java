package Datos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

import Interfaz.Conexion;


// esto es una clase de testeo de nuevas interacciones o funciones
public class Empleados {

	Conexion con = new Conexion();
	
	Connection conexion = con.conectar();
	
	PreparedStatement stmt;
	
	private int id ,dni;
	private String nombre ,apellido,tipo;

	public Empleados(int id, int dni, String nombre, String apellido, String clave, String tipo) {
		super();
		this.id = id;
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipo = tipo;
	}

	public Empleados(int id, int dni, String nombre, String apellido) {
		super();
		this.id = id;
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public boolean TraerEmleados(String clave ,String usuario) {
		String sql = "SELECT empleado.idempleado,persona.nombre,persona.apellido,persona.dni,empleado_tipo.Nombre clase FROM `empleado` INNER JOIN empleado_tipo on empleado_tipo.idempleado_tipo = empleado.empleado_tipo_idempleado_tipo INNER JOIN persona on Persona.idPersona=empleado.Persona_idPersona WHERE persona.dni = " + usuario + " && empleado.clave LIKE \""+clave +"\";";
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

	

	public boolean TraerUsuarios(String clave ,String usuario) {
		String sql = "SELECT cliente.idcliente,persona.nombre,persona.apellido,persona.dni FROM `cliente` INNER JOIN persona on Persona.idPersona=cliente.Persona_idPersona WHERE persona.dni = " + usuario + " && cliente.clave LIKE \""+clave +"\";";
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
	
	@Override
	public String toString() {
		return "Empleados [id=" + id + ", dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", tipo=" + tipo + "]";
	}

	
}
