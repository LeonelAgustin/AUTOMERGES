package Logica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import conexion.Conexion;
import negocio.Verificar;

public class Login {
	/*
	String dat= "dat";
	char gi=dat.charAt(0);
	*/
	//final char tipo[] = {'c','e'};
	//final char empleado[]= {'v','a','r','i','d'};
	//final String tipo_de_usuario[]={"cliente","ventas","administrador","restauracion","reparacion","deposito"};
	private boolean resul; 

	Conexion con = new Conexion();

	Connection conexion = con.conectar();

	PreparedStatement stmt;

	private int id, dni;
	private String nombre, apellido,tipo;
	private String clave;
	

	public Login(int id, int dni, String nombre, String apellido, String clave, String tipo) {
		super();
		this.id = id;
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipo = tipo;
		this.clave=clave;
	}

	public Login(int id, int dni, String nombre, String apellido) {
		super();
		this.id = id;
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.clave = null;
	}

	/*
	
	public Login(boolean resul) {
		this.resul = resul;
	}
	 */
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

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}
	
	public boolean TraerEmleados(String clave, String usuario) {
		String sql = "SELECT empleado.idempleado,persona.nombre,persona.apellido,persona.dni,empleado_tipo.Nombre clase FROM `empleado` INNER JOIN empleado_tipo on empleado_tipo.idempleado_tipo = empleado.empleado_tipo_idempleado_tipo INNER JOIN persona on Persona.idPersona=empleado.Persona_idPersona WHERE persona.dni = ? && empleado.clave LIKE ?";
		String[] datos = new String[5];
		try {

			stmt = conexion.prepareStatement(sql);
			stmt.setString(2, clave);
			stmt.setInt(1,Integer.parseInt(usuario));
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
				//conexion.close();
				this.clave=clave;
				return true;
			}

			return false;

		} catch (Exception excepcion) {
			System.out.println(excepcion.getMessage());
			return false;
		}

	}

	public boolean  TraerUsuarios(String clave, String usuario) {
		String sql = "SELECT cliente.idcliente,persona.nombre,persona.apellido,persona.dni FROM `cliente` INNER JOIN persona on Persona.idPersona=cliente.Persona_idPersona WHERE persona.dni = ? && cliente.clave LIKE ?";
		String[] datos = new String[5];
		try {
			
			stmt = conexion.prepareStatement(sql);
			stmt.setString(2, clave);
			stmt.setInt(1,Integer.parseInt(usuario));
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
				//conexion.close();
				this.clave=clave;
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
				contrasena = JOptionPane.showInputDialog("ingrese la contrase\u00f1a nuevamente");
			} while (!verificar.verificarcontrasena(contrasena));
		}

		if (!verificar.verificardni(dni)) {
			do {
				dni = JOptionPane.showInputDialog("ingresa nuevamente tu dni");
			} while (!verificar.verificardni(dni));
		}

		if (!verificar.verificarnombre(nombre)) {
			do {
				nombre = JOptionPane.showInputDialog("ingresa nuevamente tu nombre");
			} while (!verificar.verificarnombre(nombre));
		}

		if (!verificar.verificarapellido(apellido)) {
			do {
				apellido = JOptionPane.showInputDialog("ingresa nuevamente tu apellido");
			} while (!verificar.verificarapellido(apellido));
		}

		if (!verificar.verificardireccion(direccion)) {
			do {
				direccion = JOptionPane.showInputDialog("ingresa nuevamente tu direccion");
			} while (!verificar.verificardireccion(direccion));
		}

		if (!verificar.verificaraltura(altura)) {
			do {
				altura = JOptionPane.showInputDialog("ingrese nuevamente la altura de tu direccion");
			} while (!verificar.verificaraltura(altura));
		}

		if (!verificar.verificartelefono(telefono)) {
			do {
				telefono = JOptionPane.showInputDialog("ingresa nuevamente tu telefono");
			} while (!verificar.verificartelefono(telefono));
		}
		
		return true;
	}


	
	
	public boolean registro(String contrasena, String dni, String nombre, String apellido, String direccion,
			String altura, String telefono) {
		dni=dni+".00";
		 telefono=telefono+".00";
		String sql ="INSERT INTO `persona`( `dni`, `nombre`, `apellido`, `direccion`, `altura`, `telefono`) VALUES (?,?,?,?,?,?)";
		
		try {
			stmt = conexion.prepareStatement(sql);
			stmt.setFloat(1, Float.parseFloat(dni));
			stmt.setString(2,nombre);
			stmt.setString(3, apellido);
			stmt.setString(4, direccion);
			stmt.setInt(5, Integer.parseInt(altura));
			stmt.setFloat(6,Float.parseFloat(telefono));
			stmt.executeUpdate();
			//conexion.close();
			
			return true;
		} catch (Exception e) {
			System.err.println("test");
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean registro1(String contrasena, String dni, String nombre, String apellido, String direccion,
			String altura, String telefono) {
		//float dnif=Float.parseFloat( dni+".00");
		//float telefonof=Float.parseFloat(telefono+".00");
		String sql = "SELECT idPersona FROM `persona` ORDER BY idPersona DESC LIMIT 1;";
		try {
			stmt = conexion.prepareStatement(sql);
			ResultSet resulta = stmt.executeQuery();
			
			while (resulta.next()) {
					this.id=resulta.getInt(1);
			}

			System.err.println(this.id);
			//conexion.close();
			return true;
		} catch (Exception e) {
			//id=-1;
			System.out.println(e.getMessage());
			return false;
		}
	}
		
	public boolean registro2(String contrasena, String dni, String nombre, String apellido, String direccion,
			String altura, String telefono) {
		//String[] datos = new String[5];
		
	String	sql =  "INSERT INTO `cliente`(`Persona_idPersona`, `clave`) VALUES (?,?)";
		
		try {

			stmt = conexion.prepareStatement(sql);
			stmt.setInt(1, this.id);
			stmt.setString(2,contrasena);

			stmt.executeUpdate();
			//conexion.close();
			return true;

		} catch (Exception excepcion) {
			System.out.println(excepcion.getMessage());
			return false;
		}

	}
	
	
	
	public void menu_transport() {
		boolean userkey = true;
		switch (this.tipo) {
		case "Ventas":
			do {
				Vehiculo vehiculo = new Vehiculo(0,"","","",0,0,0,"");
				Cliente cliente = new Cliente("","","","","");
				Pieza pieza = new Pieza(0,0,null);
				Vendedor vendedor = new Vendedor(this.nombre,this.apellido, String.valueOf(this.dni) , String.valueOf(this.id) ,this.clave,this.tipo,vehiculo,pieza,cliente);
				userkey=vendedor.vendedor();
			} while (!userkey);
			break;
		case "Mecanico":
			
			break;
		case "Encargado del deposito":
			
			break;
		case "fabricante":
			
			break;
		case "Administrador":
			
			break;
		case "Encargado de taller":
			
			break;
		default:
			
			break;
		}
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


