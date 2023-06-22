package Logica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.JCheckBox;

import javax.swing.JOptionPane;

import conexion.Conexion;
import negocio.Verificar;

public class Vendedor extends Persona {
	LinkedList<Vehiculo> carro = new LinkedList<Vehiculo>();
	private String tipo_cuenta;
	Vehiculo vehiculo;
	Pieza pieza;
	Cliente cliente;

	Conexion con = new Conexion();

	Connection conexion = con.conectar();

	PreparedStatement stmt;

	// cosas que faltan que el vendedor pueda comprar piezas

	public Vendedor(String nombre, String apellido, String dni, String id, String contrasena, String tipo_cuenta,
			Vehiculo vehiculo, Pieza pieza, Cliente cliente) {
		super(nombre, apellido, dni, id, contrasena);
		this.tipo_cuenta = tipo_cuenta;
		this.vehiculo = vehiculo;
		this.pieza = pieza;
		this.vehiculo=vehiculo;
		this.pieza = pieza;
		this.cliente = cliente;
	}

	public String getTipo_cuenta() {
		return tipo_cuenta;
	}

	// solo puede modificar administrador el tipo de cuenta
	public void setTipo_cuenta(String tipo_cuenta) {
		this.tipo_cuenta = tipo_cuenta;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public Pieza getPieza() {
		return pieza;
	}

	public void setPieza(Pieza pieza) {
		this.pieza = pieza;
	}

	public LinkedList<Vehiculo> getCarro() {
		return carro;
	}

	public void setCarro(LinkedList<Vehiculo> carro) {
		this.carro = carro;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public void menu_ventas() {
		JOptionPane.showMessageDialog(null, "test");
	}

	public boolean vendedor() {
		final String tipo_de_empleado[] = { "Comprar auto", "Vender auto", "Vender pieza", "Reparar auto", "ver Stock",
				"Registrar auto", "buscar auto", "Salir" };

		JCheckBox chec = new JCheckBox("Prueba");
		// filtra cliente de empleado
		int seleccion = JOptionPane.showOptionDialog(chec, "Seleccione una opcion", "Selector de opciones",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, // null para icono por defecto.
				tipo_de_empleado, tipo_de_empleado[0]);
		//Informe informe = new Informe(cliente, vehiculo, 0, true);
		//Informe informef = new Informe(cliente, pieza, 0, true);
		try {
			//conexion.close();
		} catch (Exception e) {
			
		}
		
		switch (seleccion) {
		case 0:
			// JOptionPane.showMessageDialog(null, "comprar auto\n" + vehiculo);
			// informe.setIsfactura(false);
			// informe.setCliente(cliente);
			// informe.setasunto("compra");
			// informe.setVehiculo(vehiculo);
			// JOptionPane.showMessageDialog(null, informe.toString());
			buscar_usuario(Integer.parseInt(JOptionPane.showInputDialog("ingrese el id de usuario")));
			String d[] = { "registrar auto", "seleccionar auto" };
			int seleccion5 = JOptionPane.showOptionDialog(chec, "Seleccione una opcion", "Selector de opciones",
					JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, // null para icono por
																							// defecto.
					d, d[0]);
			boolean t = seleccion5 == 0;
			if (t) {
				registrar_auto(Integer.parseInt(this.cliente.getId()));
			} else {
				buscar_auto(true);
			}

			registrarcompra();
			
			break;
		case 1:
			// JOptionPane.showMessageDialog(null, "Vender auto\n" + vehiculo);
			// informe.setIsfactura(true);
			// informe.setCliente(cliente);
			// informe.setasunto("venta");
			// informe.setVehiculo(vehiculo);
			// JOptionPane.showMessageDialog(null, informe.toString());

			buscar_anuncios();

			String mensaje = "";

			for (int i = 0; i < this.carro.size(); i++) {

				mensaje = mensaje + this.carro.get(i).getId() + this.carro.get(i).getMarca() + this.carro.get(i).getModelo();

			}

			JOptionPane.showMessageDialog(null, mensaje);

			int zero = Integer.parseInt( JOptionPane.showInputDialog("ingrese el id"));

			for (int i = 0; i < carro.size(); i++) {
				if (carro.get(i).getId()==zero) {
					  this.vehiculo.setId(this.carro.get(i).getId());
					  this.vehiculo.setPatente(this.carro.get(i).getPatente());
					  this.vehiculo.setMarca(this.carro.get(i).getMarca());
					  this.vehiculo.setModelo(this.carro.get(i).getModelo());
					  this.vehiculo.setAno(this.carro.get(i).getAno());
					  this.vehiculo.setEstado(this.carro.get(i).getEstado());
					  this.vehiculo.setIdcliente(this.carro.get(i).getIdcliente());
				}
			}
			
			if(zero>0) {
			registrar_venta();
			}
			
			break;
		/*
		 * case 2: JOptionPane.showMessageDialog(null, "Comprar pieza\n" + pieza);
		 * informef.setIsfactura(false); informef.setCliente(cliente);
		 * informef.setasunto("venta"); informef.setPieza(pieza);
		 * JOptionPane.showMessageDialog(null, informef.toString()); break;
		 */
		case 2:
			/*
			 * JOptionPane.showMessageDialog(null, "Vender pieza\n" + pieza);
			 * informef.setIsfactura(true); informef.setCliente(cliente);
			 * informef.setasunto("venta"); informef.setPieza(pieza);
			 * JOptionPane.showMessageDialog(null, informef.toString());
			 */
			buscar_usuario(Integer.parseInt(JOptionPane.showInputDialog("ingrese el id de usuario")));
			buscar_pieza();
			int cantida = Integer.parseInt(JOptionPane.showInputDialog("ingrese la cantidad de piezas"));
			if (cantida>0) {
				vender_auto(false, cantida);
			}
			
			break;
		case 3:
			/*
			 * JOptionPane.showMessageDialog(null, "Reparar auto\n" + vehiculo);
			 * informe.setIsfactura(false); informe.setCliente(cliente);
			 * informe.setasunto("venta"); informe.setVehiculo(vehiculo);
			 * JOptionPane.showMessageDialog(null, informe.toString());
			 */
			buscar_usuario(Integer.parseInt(JOptionPane.showInputDialog("ingrese el id de usuario")));
			String r[]= { "registrar auto", "seleccionar auto" };
			int seleccion2 = JOptionPane.showOptionDialog(chec, "Seleccione una opcion", "Selector de opciones",
					JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, // null para icono por
																							// defecto.
					r, r[0]);
			boolean z = seleccion2 == 0;
			if (z) {
				registrar_auto(Integer.parseInt(this.cliente.getId()));
			} else {
				buscar_auto(true);
			}
			
			System.err.println(this.vehiculo.getId());
			

			String s[] = { "reparar", "restaurar" };
			 seleccion2 = JOptionPane.showOptionDialog(chec, "Seleccione una opcion", "Selector de opciones",
					JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, // null para icono por
																							// defecto.
					s, s[0]);
			z = seleccion2 == 0;
			if (z) {
					informe_cargar("reparar",1);
			} else {
					informe_cargar("restaurar",2);
			}
			
			break;
		case 4:
			revisar_deposito();
			break;
		case 5:
			//buscar_usuario(Integer.parseInt(JOptionPane.showInputDialog("ingrese el id de usuario")));
			String ed[] = { "registrar auto", "registrar un auto a un usuario" };
			int seleccion4 = JOptionPane.showOptionDialog(chec, "Seleccione una opcion", "Selector de opciones",
					JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, // null para icono por
																							// defecto.
					ed, ed[0]);
			boolean q = seleccion4 == 0;

			if (q) {
				registrar_auto(-1);
			} else {
			Boolean wait=buscar_usuario(Integer.parseInt(JOptionPane.showInputDialog("ingrese el id de usuario")));
			
				do {
					//System.err.println(wait);
				} while (!wait);
				
				registrar_auto(Integer.parseInt(this.cliente.getId()));
			}
			break;
		case 6:
			buscar_auto(false);
			break;
		default:
			return true;
		}
		return false;
	}

	public Informe informe(Informe informe, Informe informef, int seleccion) {

		if (seleccion == 2 || seleccion == 3) {
			return informef;
		}
		return informe;
	}

	public boolean informe_cargar(String asunto, int accion) {

		String sql = "INSERT INTO `informe`( `asunto`, `estados_idestados`, `Vehiculo_Id_auto`) VALUES (?,4,?)";
		String sql1 = "UPDATE `vehiculo` SET `accion_idaccion`=? WHERE `Id_auto`=?";

		try {
			stmt = conexion.prepareStatement(sql1);
			ResultSet resulta1 = stmt.executeQuery();
			stmt.setString(1, asunto);
			stmt.setInt(2, this.vehiculo.getId());
			stmt = conexion.prepareStatement(sql);
			stmt.setInt(1, accion);
			stmt.setInt(2, this.vehiculo.getId());
			ResultSet resulta = stmt.executeQuery();
			while (resulta1.next() && resulta.next()) {

			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public void buscar_auto(boolean isventa) {
		String sql = "*";
		final String tr[] = { "buscar por a\u00f1o", "buscar por modelo", "buscar por marca", "buscar por precio",
				"buscar por id", "buscar por patente", "Salir" };
		String dato;
		int seleccion2;
		if (!isventa) {
			seleccion2 = JOptionPane.showOptionDialog(null, "Seleccione una opcion", "Selector de opciones",
					JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, // null para icono por
																							// defecto.
					tr, tr[0]);
			this.carro.clear();
			switch (seleccion2) {
			case 0:
				dato = JOptionPane.showInputDialog("ingrese el ano del auto");
				sql = "SELECT * FROM `vehiculo` WHERE `a2\u00f1o` = " + dato;
				break;
			case 1:
				dato = JOptionPane.showInputDialog("ingrese el modelo del auto");
				sql = "SELECT * FROM `vehiculo` WHERE `modelo` LIKE \"%" + dato + "%\"";
				break;
			case 2:
				dato = JOptionPane.showInputDialog("ingrese la marca del auto");
				sql = "SELECT * FROM `vehiculo` WHERE `marca` LIKE \"%" + dato + "%\"";
				break;
			case 3:
				dato = JOptionPane.showInputDialog("ingrese el precio del auto");
				sql = "SELECT * FROM `vehiculo` WHERE `Precio` = " + dato;
				break;
			case 4:
				dato = JOptionPane.showInputDialog("ingrese el id del auto");
				sql = "SELECT * FROM `vehiculo` WHERE `Id_auto` = " + dato;
				break;
			case 5:
				dato = JOptionPane.showInputDialog("ingrese el patente del auto");
				sql = "SELECT * FROM `vehiculo` WHERE `Patente` LIKE \"%" + dato + "%\"";
				break;

			default:
				sql = "*";
				break;
			}

			if (!sql.equals("*")) {
				try {
					ResultSet resulta = stmt.executeQuery();
					// id=resulta.getInt(1);
					while (resulta.next()) {
						this.carro.add(new Vehiculo(resulta.getInt(1), resulta.getString(2), resulta.getString(3),
								resulta.getString(4), Integer.parseInt(String.format("%.0f", resulta.getFloat(5))),
								resulta.getInt(6), resulta.getInt(7), String.format("%.2f", resulta.getFloat(8))));
					}
					//conexion.close();
				} catch (Exception e) {
					// id=-1;
				}

			}

		} else {

			sql = " SELECT   `Id_auto`, `Patente`, `marca`, `modelo`, `año`, `accion_idaccion`, `cliente_idcliente`, `Precio` FROM `vehiculo` WHERE cliente_idcliente =?";

			try {

				stmt = conexion.prepareStatement(sql);
				stmt.setInt(1, Integer.parseInt(this.cliente.getId()));
				ResultSet result = stmt.executeQuery();
				while (result.next()) {
					this.vehiculo.setId(result.getInt(1));
					this.vehiculo.setPatente(result.getString(2));
					this.vehiculo.setMarca((result.getString(3)));
					this.vehiculo.setModelo(result.getString(4));
					this.vehiculo.setAno(Integer.parseInt(String.format("%.0f", result.getFloat(5))));
					this.vehiculo.setEstado(result.getInt(6));
					this.vehiculo.setIdcliente(result.getInt(7));
					//conexion.close();
					// return true;
				}

			} catch (Exception excepcion) {
				System.out.println(excepcion.getMessage());
				// return false;
			}

		}
	}

	public boolean buscar_usuario(int cliente_id) {

		String sql = "SELECT cliente.idcliente,persona.nombre,persona.apellido,persona.dni FROM `cliente` INNER JOIN persona on Persona.idPersona=cliente.Persona_idPersona WHERE cliente.idcliente = ? ";
		// String[] datos = new String[5];
		try {

			stmt = conexion.prepareStatement(sql);
			stmt.setInt(1, cliente_id);
			ResultSet result = stmt.executeQuery();
			while (result.next()) {
				this.cliente.setId(String.valueOf(result.getInt(1)));
				this.cliente.setNombre(result.getString(2));
				this.cliente.setApellido(result.getString(3));
				this.cliente.setDni(String.format("%.0f", result.getFloat(4)));
				//conexion.close();
				System.err.println(result.getInt(1));
				return true;
			}

			return false;

		} catch (Exception excepcion) {
			System.out.println(excepcion.getMessage());
			return false;
		}

	}

	public boolean buscar_anuncios() {

		String sql = " SELECT   `Id_auto`, `Patente`, `marca`, `modelo`, `año`, `accion_idaccion`, `cliente_idcliente`, `Precio` FROM `vehiculo` WHERE accion_idaccion = 4 ";
		this.carro.clear();
		try {

			stmt = conexion.prepareStatement(sql);
			stmt.setInt(1, Integer.parseInt(this.cliente.getId()));
			ResultSet result = stmt.executeQuery();
			while (result.next()) {
				this.carro.add(new Vehiculo(result.getInt(1), result.getString(2), result.getString(3),
						result.getString(4), Integer.parseInt(String.format("%.0f", result.getFloat(5))),
						result.getInt(6), result.getInt(7), String.format("%.2f", result.getFloat(8))));
			}

			/*
			 * this.vehiculo.setId(result.getInt(1));
			 * this.vehiculo.setPatente(result.getString(2));
			 * this.vehiculo.setMarca((result.getString(3)));
			 * this.vehiculo.setModelo(result.getString(4)); this.vehiculo.setAno(
			 * Integer.parseInt( String.format("%.0f", result.getFloat(5))));
			 * this.vehiculo.setEstado(result.getInt(6));
			 * this.vehiculo.setIdcliente(result.getInt(7));
			 */

			//conexion.close();

			return true;

		} catch (Exception excepcion) {
			System.out.println(excepcion.getMessage());
			return false;
		}

	}

	public void registrar_auto(int cliente) {
		boolean z;
		String marca = JOptionPane.showInputDialog("ingresa la marca del vehiculo");
		String modelo = JOptionPane.showInputDialog("ingresa el modelo");
		String patente = JOptionPane.showInputDialog("ingresa la patente");
		String ano = JOptionPane.showInputDialog("ingresa el año de fabricacion");
		String id = "0";
		// String cliente = JOptionPane.showInputDialog("ingresa tu telefono");
		String precio = JOptionPane.showInputDialog("ingresa el precio");
		String estado = JOptionPane.showInputDialog("ingresa la accion");
		Verificar verificar = new Verificar();
		do {
			if (!verificar.verificarmarca(marca)) {
				marca = JOptionPane.showInputDialog("ingrese una marca valida");
				z = false;
			} else {
				z = true;
			}
		} while (z);
		z = true;
		do {
			if (!verificar.verificarmodelo(modelo)) {
				modelo = JOptionPane.showInputDialog("ingrese un modelo valida");
				z = false;
			} else {
				z = true;
			}
		} while (z);
		z = true;
		do {
			if (!verificar.verificarpatente(patente)) {
				patente = JOptionPane.showInputDialog("ingrese una patente valida");
				z = false;
			} else {
				z = true;
			}
		} while (z);
		z = true;
		do {
			if (!verificar.verificarano(ano)) {
				ano = JOptionPane.showInputDialog("ingrese una ano valida");
				z = false;
			} else {
				z = true;
			}
		} while (z);
		z = true;
		do {
			if (!verificar.verificarprecio(precio)) {
				precio = JOptionPane.showInputDialog("ingrese un precio valida");
				z = false;
			} else {
				z = true;
			}
		} while (z);
		z = true;
		do {
			if (!verificar.verificarestado(estado)) {
				estado = JOptionPane.showInputDialog("ingrese una accion valida");
				z = false;
			} else {
				z = true;
			}
		} while (z);

		Vehiculo vehiculo = new Vehiculo(cliente, patente, marca, modelo, Integer.parseInt(ano),
				Integer.parseInt(estado), 1, precio);
		this.vehiculo = vehiculo;
		registrar_auto_connetion();

	}

	/* en caso de que la empresa compre un auto el cliente va a ser -1 */
	public void registrar_auto_connetion() {

		if (this.vehiculo.getIdcliente() <= 0) {

			String sql = "INSERT INTO `vehiculo`( `Patente`, `marca`, `modelo`, `a\u00f1o`, `accion_idaccion`, `cliente_idcliente`, `Precio`) VALUES (?,?,?,?,?,?,?)";

			try {
				stmt = conexion.prepareStatement(sql);
				stmt.setString(1, this.vehiculo.getPatente());
				stmt.setString(2, this.vehiculo.getMarca());
				stmt.setString(3, this.vehiculo.getModelo());
				stmt.setFloat(4, Float.parseFloat(String.valueOf(this.vehiculo.getAno()) + ".00"));
				stmt.setInt(5, this.vehiculo.getEstado());
				stmt.setInt(6, this.vehiculo.getIdcliente());
				stmt.setFloat(7, Float.parseFloat(this.vehiculo.getPrecio() + ".00"));
				stmt.executeUpdate();
				//conexion.close();

				// return true;
			} catch (Exception e) {
				System.err.println("test");
				System.out.println(e.getMessage());
				// return false;
			}
		} else {
			String sql = "INSERT INTO `vehiculo`( `Patente`, `marca`, `modelo`, `a\u00f1o`, `accion_idaccion`, `Precio`) VALUES (?,?,?,?,?,?)";

			try {
				stmt = conexion.prepareStatement(sql);
				stmt.setString(1, this.vehiculo.getPatente());
				stmt.setString(2, this.vehiculo.getMarca());
				stmt.setString(3, this.vehiculo.getModelo());
				stmt.setFloat(4, Float.parseFloat(String.valueOf(this.vehiculo.getAno()) + ".00"));
				stmt.setInt(5, this.vehiculo.getEstado());
				stmt.setFloat(6, Float.parseFloat(this.vehiculo.getPrecio() + ".00"));
				stmt.executeUpdate();
				// conexion.close();

				// return true;
			} catch (Exception e) {
				System.err.println("test");
				System.out.println(e.getMessage());
				// return false;
			}

		}

	}

	public void buscar_pieza() {
		LinkedList<Pieza> piezas = new LinkedList<Pieza>();
		String sql = "SELECT `Numero_de_pieza`, `nombre_Pieza`, `Pieza_precio` FROM `pieza` ";
		String sql1 = "SELECT COUNT(*) FROM `pieza`";
		String opciones[] = { "<--", "seleccionar", "-->" };
		String opciones2[] = { "comprar", "salir" };
		try {
			ResultSet resulta1 = stmt.executeQuery(sql1);
			stmt = conexion.prepareStatement(sql);
			ResultSet resulta = stmt.executeQuery();
			while (resulta1.next() && resulta.next()) {
				for (int i = 0; i < resulta1.getInt(1); i++) {
					piezas.add(new Pieza(resulta.getInt(1),
							Double.parseDouble(String.format("%.2f", resulta.getFloat(3))), resulta.getString(2)));
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		String mensaje = "";

		for (int i = 0; i < piezas.size(); i++) {
			mensaje = mensaje + piezas.get(i).getNumero_de_sere() + "" + piezas.get(i).getNombre_pieza() + ""
					+ piezas.get(i).getPrecio();
		}
		JOptionPane.showMessageDialog(null, mensaje);
		int seleccion1;
		// int pagina;
		String id1;
		/*
		 * do { seleccion1 = JOptionPane.showOptionDialog(null, "Seleccione una opcion",
		 * "Selector de opciones", JOptionPane.YES_NO_CANCEL_OPTION,
		 * JOptionPane.QUESTION_MESSAGE, null, // null para icono por opciones,
		 * opciones[0]); } while (seleccion1 != 1);
		 */
		do {
			id1 = JOptionPane.showInputDialog("ingrese el id");
		} while (id1.length() == 0);

		do {
			seleccion1 = JOptionPane.showOptionDialog(null, "Seleccione una opcion", "Selector de opciones",
					JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, // null para icono por
					opciones2, opciones2[0]);
			if (seleccion1 == 1) {
				vender_auto(false, Integer.parseInt(id1));
			}
		} while (seleccion1 != 1);
	}

	// si auto es falso se carga como pieza
	// en caso de venta auto se pone cantidad en 0
	public void vender_auto(boolean auto, int cantidad) {
		if (auto) {
			String sql = "INSERT INTO `factura`( `cliente_idcliente`, `Vehiculo_Id_auto`, `Precio`) VALUES ('?','?','?')";
			try {
				stmt = conexion.prepareStatement(sql);
				stmt.setInt(1, Integer.parseInt(this.cliente.getId()));
				stmt.setInt(2, this.vehiculo.getId());
				stmt.setFloat(3, Float.parseFloat(this.vehiculo.getPrecio() + ".00"));
				stmt.executeUpdate();
				//conexion.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		} else {
			String sql = "INSERT INTO `factura`( `cliente_idcliente`, `Pieza_Numero_de_pieza`, `Precio`, `cantidad`) VALUES (?,?,?,?)";
			try {
				stmt = conexion.prepareStatement(sql);
				stmt.setInt(1, Integer.parseInt(this.cliente.getId()));
				stmt.setInt(2, this.vehiculo.getId());
				stmt.setFloat(3, Float.parseFloat(this.vehiculo.getPrecio() + ".00"));
				stmt.setInt(4, cantidad);
				stmt.executeUpdate();
				//conexion.close();
			} catch (Exception e) {
				// TODO: handle exception
			}

		}
	}

	public void registrar_venta() {
		String sql = "UPDATE `vehiculo` SET `accion_idaccion`='?' WHERE id_auto = 5";
		try {
			stmt = conexion.prepareStatement(sql);
			stmt.setInt(1, this.vehiculo.getId());
			stmt.executeUpdate();
			//conexion.close();
		} catch (Exception e) {

		}

	}

	public void registrar_cliente() {
		// copia del registro de main
		Login login = new Login(0, 0, null, null, null, null);
		String dni = JOptionPane.showInputDialog("ingresa tu dni");
		String nombre = JOptionPane.showInputDialog("ingresa tu nombre");
		String apellido = JOptionPane.showInputDialog("ingresa tu apellido");
		String direccion = JOptionPane.showInputDialog("ingresa tu direccion");
		String altura = JOptionPane.showInputDialog("ingrese la altura de tu direccion");
		String telefono = JOptionPane.showInputDialog("ingresa tu telefono");
		String contrasena = JOptionPane
				.showInputDialog("ingrese una contrase\u00f1a con un minimo de 6 caracteres y un maximo de 45");
		boolean aprobacion = login.RegistrarUsuario(contrasena, dni, nombre, apellido, direccion, altura, telefono);
		if (aprobacion) {
			login.registro(contrasena, dni, nombre, apellido, direccion, altura, telefono);
		}
	}

	public void revisar_deposito() {
		String sql = "SELECT count(*) FROM `deposito_has_vehiculo` WHERE `estacionado`= 1";
		System.err.println();
		try {
			stmt = conexion.prepareStatement(sql);
			ResultSet resulta = stmt.executeQuery();
			
			while (resulta.next()) {
				
				
			
			if (resulta.getInt(1) == 0) {
				JOptionPane.showMessageDialog(null, "el estacionamiento del depocito esta vacio");
			} else {
				if (resulta.getInt(1) <= 0 && resulta.getInt(1) > 150) {
					JOptionPane.showMessageDialog(null, "el estacionamiento del depocito tiene " + resulta.getInt(1));
				} else {
					if (resulta.getInt(1) == 150) {
						JOptionPane.showMessageDialog(null, "el estacionamiento del depocito esta lleno");
					}
				}
			}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void registrarcompra() {
		
		String sql = "UPDATE `vehiculo` SET `accion_idaccion`=3,`cliente_idcliente`=null WHERE Id_auto = ?";
		
		try {
			stmt=conexion.prepareStatement(sql);
			stmt.setInt(1,this.vehiculo.getId());
			stmt.executeUpdate();
		} catch (Exception e) {
			
		}

	}

}
