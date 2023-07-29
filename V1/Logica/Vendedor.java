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
	LinkedList<Pieza> piezas = new LinkedList<Pieza>();
	LinkedList<Cliente> clientes = new LinkedList<Cliente>();
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
		this.vehiculo = vehiculo;
		this.pieza = pieza;
		this.cliente = cliente;
	}
	
	

	public LinkedList<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(LinkedList<Cliente> clientes) {
		this.clientes = clientes;
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

	public LinkedList<Pieza> getPiezas() {
		return piezas;
	}

	public void setPiezas(LinkedList<Pieza> piezas) {
		this.piezas = piezas;
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
		// Vehiculo l = new Vehiculo(0,"","","",0,0,0,"");
		// Cliente k = new Cliente("","","","","");
		// Pieza qb = new Pieza(0,0,null);
		JCheckBox chec = new JCheckBox("Prueba");
		// filtra cliente de empleado
		int seleccion = JOptionPane.showOptionDialog(chec, "Seleccione una opcion", "Selector de opciones",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, // null para icono por defecto.
				tipo_de_empleado, tipo_de_empleado[0]);
		// Informe informe = new Informe(cliente, vehiculo, 0, true);
		// Informe informef = new Informe(cliente, pieza, 0, true);

		switch (seleccion) {
		case 0:
			// JOptionPane.showMessageDialog(null, "comprar auto\n" + vehiculo);
			// informe.setIsfactura(false);
			// informe.setCliente(cliente);
			// informe.setasunto("compra");
			// informe.setVehiculo(vehiculo);
			// JOptionPane.showMessageDialog(null, informe.toString());
			buscar_usuario(Integer.parseInt(JOptionPane.showInputDialog("ingrese el id de usuario")));
			String id = "-1";
			if (!this.cliente.getNombre().equals("")) {

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

					// System.out.println(this.carro.get(0));
					String mensaje = "";
					for (int i = 0; i < this.carro.size(); i++) {
						mensaje = mensaje + this.carro.get(i).getId() + " " + this.carro.get(i).getMarca() + " "
								+ this.carro.get(i).getModelo() + "\n";
					}

					boolean keyp = true;
					if (!this.carro.isEmpty()) {
						do {
							JOptionPane.showMessageDialog(null, mensaje);
							id = JOptionPane.showInputDialog("ingrese el id del auto");
							System.err.println(id);

							for (int i = 0; i < this.carro.size(); i++) {
								try {
									boolean y = this.carro.get(i).getId() == Integer.parseInt(id);
									System.err.println(y);
									if (y) {
										this.vehiculo = this.carro.get(i);
										keyp = false;
									}
								} catch (Exception e) {

								}
							}
						} while (keyp);
					} else {
						JOptionPane.showMessageDialog(null, "no hay autos registrados");
					}
				}
				if (this.vehiculo.getPatente() != "") {
					registrarcompra();
				} else {
					System.err.println("auto es nulo");
				}
			} else {
				JOptionPane.showMessageDialog(null, "cliente no existe");
			}
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

				mensaje = mensaje + this.carro.get(i).getId() + "  " + this.carro.get(i).getMarca() + "  "
						+ this.carro.get(i).getModelo();

			}
			if (!mensaje.equals("")) {
				JOptionPane.showMessageDialog(null, mensaje);
				int zero;
				do {
					zero = Integer.parseInt(JOptionPane.showInputDialog("ingrese el id"));
				} while (zero < 0);

				for (int i = 0; i < this.carro.size(); i++) {
					if (this.carro.get(i).getId() == zero) {
						this.vehiculo.setId(this.carro.get(i).getId());
						this.vehiculo.setPatente(this.carro.get(i).getPatente());
						this.vehiculo.setMarca(this.carro.get(i).getMarca());
						this.vehiculo.setModelo(this.carro.get(i).getModelo());
						this.vehiculo.setAno(this.carro.get(i).getAno());
						this.vehiculo.setEstado(this.carro.get(i).getEstado());
						this.vehiculo.setIdcliente(this.carro.get(i).getIdcliente());
					}
				}
				System.err.println(this.vehiculo);

				registrar_venta();
				System.err.println("registro terminado");
				vender_auto(true, 0);
				System.err.println("registro terminado 2");
			} else {
				JOptionPane.showMessageDialog(null, "no hay autos a la venta");
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
			// JOptionPane.showMessageDialog(null,"esta funcion no funciona");

			buscar_usuario(Integer.parseInt(JOptionPane.showInputDialog("ingrese el id de usuario")));
			if (buscar_pieza()) {
				System.err.println("buscarpieza" + true);
				partes();
				
			} else {
				System.err.println(false);
			}

			if (this.piezas.isEmpty()) {

			} else {
				int cantida = Integer.parseInt(JOptionPane.showInputDialog("ingrese la cantidad de piezas"));
				if (cantida > 0) {
					if (this.pieza.getNombre_pieza() != null && !this.pieza.getNombre_pieza().equals("")) {
						vender_auto(false, cantida);
					}
				}
			}

			break;
		case 3:
			/*
			 * JOptionPane.showMessageDialog(null, "Reparar auto\n" + vehiculo);
			 * informe.setIsfactura(false); informe.setCliente(cliente);
			 * informe.setasunto("venta"); informe.setVehiculo(vehiculo);
			 * JOptionPane.showMessageDialog(null, informe.toString());
			 */

			int rts = Integer.parseInt(JOptionPane.showInputDialog("ingrese el id de usuario"));
			buscar_usuario(rts);
			String r[] = { "registrar auto", "seleccionar auto" };
			int seleccion2 = JOptionPane.showOptionDialog(chec, "Seleccione una opcion", "Selector de opciones",
					JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, // null para icono por // defecto.
					r, r[0]);
			boolean z = seleccion2 == 0;
			if (z) {
				registrar_auto(Integer.parseInt(this.cliente.getId()));
			} else {
				buscar_auto(true);

				String mensajel = "";
				for (int i = 0; i < this.carro.size(); i++) {
					mensajel = mensajel + this.carro.get(i).getId() + " " + this.carro.get(i).getMarca() + " "
							+ this.carro.get(i).getModelo() + "\n";
				}

				boolean keyp = true;
				if (!this.carro.isEmpty()) {
					do {
						JOptionPane.showMessageDialog(null, mensajel);
						id = JOptionPane.showInputDialog("ingrese el id del auto");
						System.err.println(id);

						for (int i = 0; i < this.carro.size(); i++) {
							try {
								boolean y = this.carro.get(i).getId() == Integer.parseInt(id);
								System.err.println(y);
								if (y) {
									this.vehiculo = this.carro.get(i);
									keyp = false;
								}
							} catch (Exception e) {

							}
						}
					} while (keyp);
					System.err.println(this.vehiculo);

					String s[] = { "reparar", "restaurar" };

					if (this.cliente.getNombre() != null && !this.cliente.getNombre().equals("")) {

						seleccion2 = JOptionPane.showOptionDialog(chec, "Seleccione una opcion", "Selector de opciones",
								JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, // null para icono
																										// por
																										// defecto.
								s, s[0]);
						z = seleccion2 == 0;
						if (!this.vehiculo.getPatente().equals("")) {
							if (z) {
								informe_cargar("reparar auto", 1);
							} else {
								informe_cargar("restaurar auto", 2);
							}
						}
					} else {
						JOptionPane.showMessageDialog(null, "el usuario no existe");
					}
				} else {
					JOptionPane.showMessageDialog(null, "no hay autos registrados");
				}
			}

			break;
		case 4:
			revisar_deposito();
			break;
		case 5:
			// buscar_usuario(Integer.parseInt(JOptionPane.showInputDialog("ingrese el id de
			// usuario")));
			String ed[] = { "registrar auto", "registrar un auto a un usuario" };
			int seleccion4 = JOptionPane.showOptionDialog(chec, "Seleccione una opcion", "Selector de opciones",
					JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, // null para icono por
																							// defecto.
					ed, ed[0]);
			boolean q = seleccion4 == 0;

			if (q) {
				registrar_auto(-1);

			} else {
				buscar_usuario(Integer.parseInt(JOptionPane.showInputDialog("ingrese el id de usuario")));
				;
				if (this.cliente.getId() != null) {
					registrar_auto(Integer.parseInt(this.cliente.getId()));
				}

			}
			break;
		case 6:
			buscar_auto(false);
			String flatering = null;
			for (int i = 0; i < this.carro.size(); i++) {
				flatering = flatering + this.carro.get(i).getId() + " " + this.carro.get(i).getMarca() + " "
						+ this.carro.get(i).getModelo() + " " + this.carro.get(i).getPatente() + "/n";
			}
			JOptionPane.showMessageDialog(null, flatering);
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
		System.err.println("enter");
		String sql = "INSERT INTO `informe`( `asunto`, `estados_idestados`, `Vehiculo_Id_auto`) VALUES (?,4,?)";
		String sql1 = "UPDATE `vehiculo` SET `accion_idaccion`= ? WHERE `Id_auto`=?";

		try {
			stmt = conexion.prepareStatement(sql);
			stmt.setString(1, asunto);
			stmt.setInt(2, this.vehiculo.getId());
			stmt.executeUpdate();
			System.err.println(stmt.toString());
		} catch (Exception e) {
			System.err.println("1");
			System.err.println(e.getMessage());
		}

		try {
			stmt = conexion.prepareStatement(sql1);
			stmt.setInt(1, accion);
			stmt.setInt(2, this.vehiculo.getId());
			System.err.println(stmt.toString());
			stmt.executeUpdate();
			return true;
		} catch (Exception e) {
			System.err.println("2");
			System.err.println(e.getMessage());
		}
		return false;
	}

	
	public boolean buscador(String dato,int seleccion2) {
		String sql = "*";
		
		
			this.carro.clear();
			try {
				
			switch (seleccion2) {
			case 0:
				//dato = JOptionPane.showInputDialog("ingrese el a\u00f1o del auto");
				sql = "SELECT * FROM `vehiculo` WHERE `a\u00f1o` = ?"  ;
				stmt = conexion.prepareStatement(sql);
				stmt.setLong(1, Integer.parseInt(dato));
				break;
			case 1:
				//dato = JOptionPane.showInputDialog("ingrese el modelo del auto");
				sql = "SELECT * FROM `vehiculo` WHERE `modelo` LIKE ?";
				stmt = conexion.prepareStatement(sql);
				stmt.setString(1,"%"+dato+"%");
				
				break;
			case 2:
				//dato = JOptionPane.showInputDialog("ingrese la marca del auto");
				sql = "SELECT * FROM `vehiculo` WHERE `marca` LIKE ?";
				stmt = conexion.prepareStatement(sql);
				stmt.setString(1,"%"+dato+"%");
				break;
			case 3:
				//dato = JOptionPane.showInputDialog("ingrese el precio del auto");
				sql = "SELECT * FROM `vehiculo` WHERE `Precio` = ?" ;
				stmt = conexion.prepareStatement(sql);
				stmt.setLong(1, Integer.parseInt(dato));
				break;
			case 4:
				//dato = JOptionPane.showInputDialog("ingrese el id del auto");
				sql = "SELECT * FROM `vehiculo` WHERE `Id_auto` = ?";
				stmt = conexion.prepareStatement(sql);
				stmt.setLong(1, Integer.parseInt(dato));
				break;
			case 5:
				//dato = JOptionPane.showInputDialog("ingrese el patente del auto");
				sql = "SELECT * FROM `vehiculo` WHERE `Patente` LIKE ?";
				stmt = conexion.prepareStatement(sql);
				stmt.setString(1,"%"+dato+"%");
				break;
			case 6:
				//dato = JOptionPane.showInputDialog("ingrese el patente del auto");
				sql = "SELECT * FROM `vehiculo` WHERE `accion_idaccion` = ?";
				stmt = conexion.prepareStatement(sql);
				stmt.setString(1,dato);
				break;
			case 7:
				//dato = JOptionPane.showInputDialog("ingrese el patente del auto");
				sql = "SELECT * FROM `vehiculo` WHERE `cliente_idcliente`= ? and accion_idaccion != 2 and accion_idaccion != 1;";
				stmt = conexion.prepareStatement(sql);
				stmt.setString(1,dato);
				break;
			case 8:
				//dato = JOptionPane.showInputDialog("ingrese el patente del auto");
				sql = "SELECT * FROM `vehiculo` WHERE `cliente_idcliente`= ?";
				stmt = conexion.prepareStatement(sql);
				stmt.setString(1,dato);
				break;
			default:
				sql = "SELECT * FROM `vehiculo` WHERE 1";
				break;
			}
				System.err.println(stmt.toString());
				ResultSet resulta = stmt.executeQuery();
				// id=resulta.getInt(1);
				while (resulta.next()) {
					Vehiculo ki = new Vehiculo(resulta.getInt(1), resulta.getString(2), resulta.getString(3),
							resulta.getString(4), Integer.parseInt(String.format("%.0f", resulta.getFloat(5))),
							resulta.getInt(6), resulta.getInt(7), String.format("%.2f", resulta.getFloat(8)));
					//System.err.println(ki);
					this.carro.add(ki);
				}
				
				return true;
				// conexion.close();
			} catch (Exception e) {
				System.err.println(e.getMessage());
				System.err.println("yes");
				// id=-1;
				return false;
			}
		}
	
	public String res(int one_piece) {
		String sql = "SELECT `Pieza_Numero_de_pieza` FROM `pieza_has_deposito` WHERE `stock` = ?";
		try {
			stmt = conexion.prepareStatement(sql);
			stmt.setInt(1, one_piece);
			ResultSet resulta = stmt.executeQuery();
			while (resulta.next()) {
				return resulta.getString(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "";
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
				dato = JOptionPane.showInputDialog("ingrese el a\u00f1o del auto");
				sql = "SELECT * FROM `vehiculo` WHERE `a\u00f1o` = " + dato;
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
				sql = "SELECT * FROM `vehiculo` WHERE 1";
				break;
			}

			try {
				stmt = conexion.prepareStatement(sql);
				ResultSet resulta = stmt.executeQuery();
				// id=resulta.getInt(1);
				while (resulta.next()) {
					Vehiculo ki = new Vehiculo(resulta.getInt(1), resulta.getString(2), resulta.getString(3),
							resulta.getString(4), Integer.parseInt(String.format("%.0f", resulta.getFloat(5))),
							resulta.getInt(6), resulta.getInt(7), String.format("%.2f", resulta.getFloat(8)));
					this.carro.add(ki);
				}

				// conexion.close();
			} catch (Exception e) {
				System.err.println(e.getMessage());
				// id=-1;
			}

		} else {

			sql = " SELECT   `Id_auto`, `Patente`, `marca`, `modelo`, `a\u00f1o`, `accion_idaccion`, `cliente_idcliente`, `Precio` FROM `vehiculo` WHERE cliente_idcliente = ?";

			try {

				stmt = conexion.prepareStatement(sql);
				stmt.setInt(1, Integer.parseInt(this.cliente.getId()));
				ResultSet result = stmt.executeQuery();

				while (result.next()) {

					Vehiculo ki = new Vehiculo(result.getInt(1), result.getString(2), result.getString(3),
							result.getString(4), Integer.parseInt(String.format("%.0f", result.getFloat(5))),
							result.getInt(6), result.getInt(7), String.format("%.2f", result.getFloat(8)));
					this.carro.add(ki);
					System.err.println(this.carro.size());
				}
				while (result.next()) {
					if (this.carro.size() >= 1) {
						this.vehiculo.setId(result.getInt(1));
						this.vehiculo.setPatente(result.getString(2));
						this.vehiculo.setMarca((result.getString(3)));
						this.vehiculo.setModelo(result.getString(4));
						this.vehiculo.setAno(Integer.parseInt(String.format("%.0f", result.getFloat(5))));
						this.vehiculo.setEstado(result.getInt(6));
						this.vehiculo.setIdcliente(result.getInt(7));
					}
				}
				// conexion.close();
				// return true;

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
				this.cliente.setId(String.valueOf(result.getLong("idcliente")));
				this.cliente.setNombre(result.getString("nombre"));
				this.cliente.setApellido(result.getString("apellido"));
				this.cliente.setDni(String.format("%.0f", result.getFloat("dni")));
				// conexion.close();
				//System.err.println(result.getString(2));
				
			}
			System.err.println();
			return true;
		

		} catch (Exception excepcion) {
			System.out.println(excepcion.getMessage());
			return false;
		}

	}

	public boolean buscar_usuarios() {

		String sql = "SELECT cliente.idcliente,persona.nombre,persona.apellido,persona.dni FROM `cliente` INNER JOIN persona on Persona.idPersona=cliente.Persona_idPersona WHERE 1";
		String[] datos = new String[5];
		try {
			clientes.clear();
			stmt = conexion.prepareStatement(sql);
			ResultSet result = stmt.executeQuery();
			while (result.next()) {
				//this.cliente.setId();
				//this.cliente.setNombre();
				//this.cliente.setApellido();
				//this.cliente.setDni();
				// conexion.close();
				//
				datos[0]=String.valueOf(result.getLong("idcliente"));
				//
				datos[1]=result.getString("nombre");
				//
				datos[2]=result.getString("apellido");
				//
				datos[3]=String.format("%.0f", result.getFloat("dni"));
				//System.err.println("dato" +datos[3]);
				Cliente tr = new Cliente(datos[0],datos[3],datos[1],datos[2], null);
				System.err.println(tr);
				this.clientes.add(tr);
				//System.err.println(result.getString(2));
				
			}

			return true;

		} catch (Exception excepcion) {
			System.out.println(excepcion.getMessage());
			System.err.println("es aqui");
			return false;
		}

	}
	
	
	public boolean buscar_anuncios() {

		String sql = " SELECT   `Id_auto`, `Patente`, `marca`, `modelo`, `a\u00f1o`, `accion_idaccion`, `cliente_idcliente`, `Precio` FROM `vehiculo` WHERE accion_idaccion = 4 ";
		this.carro.clear();
		try {

			stmt = conexion.prepareStatement(sql);
			// stmt.setInt(1, Integer.parseInt(this.cliente.getId()));
			ResultSet result = stmt.executeQuery();
			while (result.next()) {
				Vehiculo ki = new Vehiculo(result.getInt(1), result.getString(2), result.getString(3),
						result.getString(4), Integer.parseInt(String.format("%.0f", result.getFloat(5))),
						result.getInt(6), result.getInt(7), String.format("%.2f", result.getFloat(8)));
				this.carro.add(ki);
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

			// conexion.close();

			return true;

		} catch (Exception excepcion) {
			System.out.println(excepcion.getMessage());
			return false;
		}

	}

	
	public void registrarauto(int cliente,String marca ,String modelo,String patente,String ano,String precio,String estado) {
		boolean z;
	
		Verificar verificar = new Verificar();
		System.err.println("finished");
		/*
		do {
			if (!verificar.verificarmarca(marca)) {
				//marca = JOptionPane.showInputDialog("ingrese una marca valida");
				z = false;
			} else {
				z = true;
			}
		} while (!z);
		// z = true;
		do {
			if (!verificar.verificarmodelo(modelo)) {
				//modelo = JOptionPane.showInputDialog("ingrese un modelo valida");
				z = false;
			} else {
				z = true;
			}
		} while (!z);
		// z = true;
		do {
			patente.toUpperCase();
			if (!verificar.verificarpatente(patente)) {
				//patente = JOptionPane.showInputDialog("ingrese una patente valida");
				z = false;
			} else {
				z = true;
			}
		} while (!z);
		// z = true;
		do {
			if (!verificar.verificarano(ano)) {
				//ano = JOptionPane.showInputDialog("ingrese una ano valida");
				z = false;
			} else {
				z = true;
			}
		} while (!z);
		// z = true;
		do {
			if (!verificar.verificarprecio(precio)) {
			//	precio = JOptionPane.showInputDialog("ingrese un precio valida");
				z = false;
			} else {
				z = true;
			}
		} while (!z);
		// z = true;
		do {
			if (!verificar.verificarestado(estado)) {
				//estado = JOptionPane.showInputDialog("ingrese una accion valida");
				z = false;
			} else {
				z = true;
			}
			System.err.println("finished");
		} while (!z);
		 */
		Vehiculo vehiculo = new Vehiculo(1, patente, marca, modelo, Integer.parseInt(ano), Integer.parseInt(estado),
				cliente, precio);
		this.vehiculo = vehiculo;
		System.err.println(this.vehiculo.toString());
		registrarautoconnetion();

	}

	/* en caso de que la empresa compre un auto el cliente va a ser -1 */
	public void registrarautoconnetion() {
		System.err.println("recived");
		if (this.vehiculo.getIdcliente() >= 0) {
			System.err.println("cliente");
			String sql = "INSERT INTO `vehiculo`( `Patente`, `marca`, `modelo`, `a\u00f1o`, `accion_idaccion`, `cliente_idcliente`, `Precio`) VALUES (?,?,?,?,?,?,?)";

			try {
				stmt = conexion.prepareStatement(sql);
				stmt.setString(1, this.vehiculo.getPatente());
				stmt.setString(2, this.vehiculo.getMarca());
				stmt.setString(3, this.vehiculo.getModelo());
				stmt.setFloat(4, Float.parseFloat(String.valueOf(this.vehiculo.getAno()) + ".00"));
				stmt.setInt(5, this.vehiculo.getEstado());
				stmt.setInt(6, this.vehiculo.getIdcliente());
				stmt.setFloat(7, Float.parseFloat(this.vehiculo.getPrecio()));
				System.err.println(stmt.toString());
				stmt.executeUpdate();
				// conexion.close();

				// return true;
			} catch (Exception e) {
				System.err.println("test");
				System.out.println(e.getMessage());
				// return false;
			}
		} else {
			String sql = "INSERT INTO `vehiculo`( `Patente`, `marca`, `modelo`, `a\u00f1o`, `accion_idaccion`, `Precio`) VALUES (?,?,?,?,?,?)";
			System.err.println("registro");
			try {
				stmt = conexion.prepareStatement(sql);
				stmt.setString(1, this.vehiculo.getPatente());
				stmt.setString(2, this.vehiculo.getMarca());
				stmt.setString(3, this.vehiculo.getModelo());
				stmt.setFloat(4, Float.parseFloat(String.valueOf(this.vehiculo.getAno()) + ".00"));
				stmt.setInt(5, this.vehiculo.getEstado());
				stmt.setFloat(6, Float.parseFloat(this.vehiculo.getPrecio()));
				System.err.println(stmt.toString());
				stmt.executeUpdate();
				// conexion.close();

				// return true;
			} catch (Exception e) {
				System.err.println("test");
				System.out.println(e.getMessage());
				// return false;
			}

		}
		JOptionPane.showMessageDialog(null, "auto registrado");
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
		System.err.println("finished");
		do {
			if (!verificar.verificarmarca(marca)) {
				marca = JOptionPane.showInputDialog("ingrese una marca valida");
				z = false;
			} else {
				z = true;
			}
		} while (!z);
		// z = true;
		do {
			if (!verificar.verificarmodelo(modelo)) {
				modelo = JOptionPane.showInputDialog("ingrese un modelo valida");
				z = false;
			} else {
				z = true;
			}
		} while (!z);
		// z = true;
		do {
			patente.toUpperCase();
			if (!verificar.verificarpatente(patente)) {
				patente = JOptionPane.showInputDialog("ingrese una patente valida");
				z = false;
			} else {
				z = true;
			}
		} while (!z);
		// z = true;
		do {
			if (!verificar.verificarano(ano)) {
				ano = JOptionPane.showInputDialog("ingrese una ano valida");
				z = false;
			} else {
				z = true;
			}
		} while (!z);
		// z = true;
		do {
			if (!verificar.verificarprecio(precio)) {
				precio = JOptionPane.showInputDialog("ingrese un precio valida");
				z = false;
			} else {
				z = true;
			}
		} while (!z);
		// z = true;
		do {
			if (!verificar.verificarestado(estado)) {
				estado = JOptionPane.showInputDialog("ingrese una accion valida");
				z = false;
			} else {
				z = true;
			}
			System.err.println("finished");
		} while (!z);

		Vehiculo vehiculo = new Vehiculo(1, patente, marca, modelo, Integer.parseInt(ano), Integer.parseInt(estado),
				cliente, precio);
		this.vehiculo = vehiculo;
		System.err.println(this.vehiculo.toString());
		registrar_auto_connetion();

	}

	/* en caso de que la empresa compre un auto el cliente va a ser -1 */
	public void registrar_auto_connetion() {
		System.err.println("recived");
		if (this.vehiculo.getIdcliente() >= 0) {
			System.err.println("cliente");
			String sql = "INSERT INTO `vehiculo`( `Patente`, `marca`, `modelo`, `a\u00f1o`, `accion_idaccion`, `cliente_idcliente`, `Precio`) VALUES (?,?,?,?,?,?,?)";

			try {
				stmt = conexion.prepareStatement(sql);
				stmt.setString(1, this.vehiculo.getPatente());
				stmt.setString(2, this.vehiculo.getMarca());
				stmt.setString(3, this.vehiculo.getModelo());
				stmt.setFloat(4, Float.parseFloat(String.valueOf(this.vehiculo.getAno()) + ".00"));
				stmt.setInt(5, this.vehiculo.getEstado());
				stmt.setInt(6, this.vehiculo.getIdcliente());
				stmt.setFloat(7, Float.parseFloat(this.vehiculo.getPrecio()));
				System.err.println(stmt.toString());
				stmt.executeUpdate();
				// conexion.close();

				// return true;
			} catch (Exception e) {
				System.err.println("test");
				System.out.println(e.getMessage());
				// return false;
			}
		} else {
			String sql = "INSERT INTO `vehiculo`( `Patente`, `marca`, `modelo`, `a\u00f1o`, `accion_idaccion`, `Precio`) VALUES (?,?,?,?,?,?)";
			System.err.println("registro");
			try {
				stmt = conexion.prepareStatement(sql);
				stmt.setString(1, this.vehiculo.getPatente());
				stmt.setString(2, this.vehiculo.getMarca());
				stmt.setString(3, this.vehiculo.getModelo());
				stmt.setFloat(4, Float.parseFloat(String.valueOf(this.vehiculo.getAno()) + ".00"));
				stmt.setInt(5, this.vehiculo.getEstado());
				stmt.setFloat(6, Float.parseFloat(this.vehiculo.getPrecio()));
				System.err.println(stmt.toString());
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

	public boolean buscar_pieza() {
		// LinkedList<Pieza> piezas = new LinkedList<Pieza>();
		String sql1 = "SELECT `Numero_de_pieza`, `nombre_Pieza`, `Pieza_precio` FROM `pieza` WHERE 1";
		// String sql1 = "SELECT COUNT(*) FROM `pieza`";
		String opciones[] = { "<--", "seleccionar", "-->" };
		String opciones2[] = { "comprar", "salir" };
		try {
			// ResultSet resulta1 = stmt.executeQuery(sql1);
			stmt = conexion.prepareStatement(sql1);
			ResultSet resulta = stmt.executeQuery();
			while (resulta.next()) {
				//System.err.println(resulta.getString(2));
				this.pieza.setNumero_de_sere((int) resulta.getLong(1));
				this.pieza.setNombre_pieza(resulta.getString(2));
				//String aux =String.format("%.2f", resulta.getFloat(3));
				//System.err.println(aux);
				this.pieza.setPrecio(resulta.getDouble(3));
				//System.err.println(resulta.getInt(2));
				this.piezas.add(this.pieza);
			}
			
			
			return true;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return false;
		}

	}

	public void partes() {
		String opciones2[] = { "comprar", "salir" };
		String mensaje = "";
		System.out.println(this.piezas.isEmpty());
		if (!this.piezas.isEmpty()) {

			for (int i = 0; i < piezas.size(); i++) {
				mensaje = mensaje + this.piezas.get(i).getNumero_de_sere() + "" + this.piezas.get(i).getNombre_pieza()
						+ "" + this.piezas.get(i).getPrecio();
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

			for (int j = 0; j < this.piezas.size(); j++) {

			}

			do {
				seleccion1 = JOptionPane.showOptionDialog(null, "Seleccione una opcion", "Selector de opciones",
						JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, // null para icono por
						opciones2, opciones2[0]);
				if (seleccion1 == 1) {
					//vender_auto(false, Integer.parseInt(id1));
				}
			} while (seleccion1 != 1);

		} else {
			JOptionPane.showMessageDialog(null, "no hay piezas");
		}
	}

	// si auto es falso se carga como pieza
	// en caso de venta auto se pone cantidad en 0
	public void vender_auto(boolean auto, int cantidad) {
		int id = Integer.parseInt(this.cliente.getId());
		System.out.println("cantidad :"+ cantidad);
		System.out.println(this.cliente.getId());
		String auto_precio = "";
		for (int i = 0; i < this.vehiculo.getPrecio().length(); i++) {
			if (i==0) {
				auto_precio = "";
			}
			if (this.vehiculo.getPrecio().charAt(i)!=',') {
				auto_precio += this.vehiculo.getPrecio().charAt(i);
			}else {
				auto_precio += '.';
			}
		}
		
		
		
		if (auto) {
			String sql = "INSERT INTO `factura`( `cliente_idcliente`, `Vehiculo_Id_auto`, `Precio`) VALUES (?,?,?)";
			System.err.println(this.vehiculo.getPrecio());
			try {
				stmt = conexion.prepareStatement(sql);
				stmt.setLong(1, id);
				stmt.setLong(2, this.vehiculo.getId());
				stmt.setDouble(3, Float.parseFloat(auto_precio));
				stmt.executeUpdate();
				System.err.println(stmt.toString());
				// conexion.close();
			} catch (Exception e) {
				System.err.println(e.getMessage());
				// TODO: handle exception
			}
		} else {
			String sql = "INSERT INTO `factura`( `cliente_idcliente`, `Pieza_Numero_de_pieza`, `Precio`, `cantidad`) VALUES (?,?,?,?)";
			try {
				stmt = conexion.prepareStatement(sql);
				stmt.setLong(1, Integer.parseInt(this.cliente.getId()));
				stmt.setLong(2, this.pieza.getNumero_de_sere());
				stmt.setDouble(3, this.pieza.getPrecio());
				stmt.setLong(4, cantidad);
				System.err.println(stmt.toString());
				stmt.executeUpdate();
				// conexion.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}
	}

	public void registrar_venta() {
		String sql = "UPDATE `vehiculo` SET `accion_idaccion`= 5 , `cliente_idcliente`= ?  WHERE id_auto = ?";
		try {
			stmt = conexion.prepareStatement(sql);
			stmt.setInt(1, Integer.parseInt(this.cliente.getId()));
			stmt.setInt(2, this.vehiculo.getId());
			stmt.executeUpdate();
			// conexion.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}
	
	
	public void registrar_ventap() {
		String sql = "UPDATE `vehiculo` SET `accion_idaccion`= 5 , `cliente_idcliente`= ?  WHERE id_auto = ?";
		try {
			stmt = conexion.prepareStatement(sql);
			stmt.setInt(1, Integer.parseInt(this.cliente.getId()));
			stmt.setInt(2, this.vehiculo.getId());
			stmt.executeUpdate();
			// conexion.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
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
				System.err.println(resulta.getInt(1));
				if (resulta.getInt(1) == 0) {
					JOptionPane.showMessageDialog(null, "el estacionamiento del depocito esta vacio");
				} else {
					if (resulta.getInt(1) >= 0 || resulta.getInt(1) > 150) {
						JOptionPane.showMessageDialog(null,
								"el estacionamiento del depocito tiene " + resulta.getInt(1));
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

	
	public String verestacionamiento() {
		String sql = "SELECT count(*) FROM `deposito_has_vehiculo` WHERE `estacionado`= 1";
		System.err.println();
		String mensaja="";
		try {
			stmt = conexion.prepareStatement(sql);
			ResultSet resulta = stmt.executeQuery();
			while (resulta.next()) {
				System.err.println(resulta.getInt(1));
				if (resulta.getInt(1) == 0) {
					mensaja=  "el estacionamiento del depocito esta vacio";
				} else {
					if (resulta.getInt(1) >= 0 || resulta.getInt(1) > 150) {
						mensaja="el estacionamiento del depocito tiene " + resulta.getInt(1);
					} else {
						if (resulta.getInt(1) == 150) {
							mensaja="el estacionamiento del depocito esta lleno";
						}
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return mensaja;
	}
	
	
	public void registrarcompra() {
		String sql2 = "SELECT `Id_auto` FROM `vehiculo` WHERE Patente LIKE ?;";
		String sql = "UPDATE `vehiculo` SET `accion_idaccion`= 3 ,`cliente_idcliente`= null WHERE Id_auto = ?";

		try {
			stmt = conexion.prepareStatement(sql2);
			stmt.setString(1, this.vehiculo.getPatente());
			ResultSet resulta = stmt.executeQuery();
			while (resulta.next()) {
				this.vehiculo.setId(resulta.getInt(1));
				System.out.println(this.vehiculo.getId());
				stmt = conexion.prepareStatement(sql);
				stmt.setInt(1, this.vehiculo.getId());
				stmt.executeUpdate();
			}

		} catch (Exception e) {

		}

	}



}
