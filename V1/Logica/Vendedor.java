package Logica;

import java.sql.ResultSet;
import java.util.LinkedList;

import javax.swing.JCheckBox;

import javax.swing.JOptionPane;

import negocio.Verificar;

public class Vendedor extends Persona {
	LinkedList<Vehiculo> carro = new LinkedList<Vehiculo>();
	private String tipo_cuenta;

	public Vendedor(String nombre, String apellido, String dni, String id, String contrasena, String tipo_cuenta) {
		super(nombre, apellido, dni, id, contrasena);
		this.tipo_cuenta = tipo_cuenta;
	}

	public String getTipo_cuenta() {
		return tipo_cuenta;
	}

	// solo puede modificar administrador el tipo de cuenta
	public void setTipo_cuenta(String tipo_cuenta) {
		this.tipo_cuenta = tipo_cuenta;
	}

	public void menu_ventas() {
		JOptionPane.showMessageDialog(null, "test");
	}

	public boolean vendedor(Vehiculo vehiculo, Pieza pieza, Cliente cliente) {
		final String tipo_de_empleado[] = { "Comprar auto", "Vender auto", "Comprar pieza", "Vender pieza",
				"Reparar auto", "ver Stock", "Salir" };
		JCheckBox chec = new JCheckBox("Prueba");
		// filtra cliente de empleado
		int seleccion = JOptionPane.showOptionDialog(chec, "Seleccione una opcion", "Selector de opciones",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, // null para icono por defecto.
				tipo_de_empleado, tipo_de_empleado[0]);
		Informe informe = new Informe(cliente, vehiculo, 0, true);
		Informe informef = new Informe(cliente, pieza, 0, true);
		switch (seleccion) {
		case 0:
			JOptionPane.showMessageDialog(null, "comprar auto\n" + vehiculo);
			informe.setIsfactura(false);
			informe.setCliente(cliente);
			informe.setasunto("compra");
			informe.setVehiculo(vehiculo);
			JOptionPane.showMessageDialog(null, informe.toString());
			break;
		case 1:
			JOptionPane.showMessageDialog(null, "Vender auto\n" + vehiculo);
			informe.setIsfactura(true);
			informe.setCliente(cliente);
			informe.setasunto("venta");
			informe.setVehiculo(vehiculo);
			JOptionPane.showMessageDialog(null, informe.toString());
			break;
		case 2:
			JOptionPane.showMessageDialog(null, "Comprar pieza\n" + pieza);
			informef.setIsfactura(false);
			informef.setCliente(cliente);
			informef.setasunto("venta");
			informef.setPieza(pieza);
			JOptionPane.showMessageDialog(null, informef.toString());
			break;
		case 3:
			JOptionPane.showMessageDialog(null, "Vender pieza\n" + pieza);
			informef.setIsfactura(true);
			informef.setCliente(cliente);
			informef.setasunto("venta");
			informef.setPieza(pieza);
			JOptionPane.showMessageDialog(null, informef.toString());
			break;
		case 4:
			JOptionPane.showMessageDialog(null, "Reparar auto\n" + vehiculo);
			informe.setIsfactura(false);
			informe.setCliente(cliente);
			informe.setasunto("venta");
			informe.setVehiculo(vehiculo);
			JOptionPane.showMessageDialog(null, informe.toString());
			break;
		case 5:

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
				sql = "SELECT * FROM `vehiculo` WHERE `año` = " + dato;
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
					conexion.close();
				} catch (Exception e) {
					// id=-1;
				}

			}

		} else {

		}
	}

	public void registrar_auto(String cliente) {
		boolean z;
		String marca = JOptionPane.showInputDialog("ingresa la marca del vehiculo");
		String modelo = JOptionPane.showInputDialog("ingresa tu nombre");
		String patente = JOptionPane.showInputDialog("ingresa tu apellido");
		String ano = JOptionPane.showInputDialog("ingresa tu direccion");
		String id = "0";
		//String cliente = JOptionPane.showInputDialog("ingresa tu telefono");
		String precio = JOptionPane.showInputDialog("ingresa tu telefono");
		String estado = JOptionPane.showInputDialog("ingresa tu telefono");
		Verificar verificar = new Verificar();
		do {
			if (verificar.verificarmarca(marca)) {
				marca = JOptionPane.showInputDialog("ingrese una marca valida");
				z = false;
			} else {
				z = true;
			}
		} while (z);
		z=true;
		do {
			if (verificar.verificarmodelo(modelo)) {
				modelo = JOptionPane.showInputDialog("ingrese un modelo valida");
				z = false;
			} else {
				z = true;
			}
		} while (z);
		z=true;
		do {
			if (verificar.verificarpatente(patente)) {
				patente = JOptionPane.showInputDialog("ingrese una patente valida");
				z = false;
			} else {
				z = true;
			}
		} while (z);
		z=true;
		do {
			if (verificar.verificarano(ano)) {
				ano = JOptionPane.showInputDialog("ingrese una ano valida");
				z = false;
			} else {
				z = true;
			}
		} while (z);
		z=true;
		do {
			if (verificar.verificarprecio(precio)) {
				precio = JOptionPane.showInputDialog("ingrese un precio valida");
				z = false;
			} else {
				z = true;
			}
		} while (z);
		z=true;
		do {
			if (verificar.verificarestado(estado)) {
				estado = JOptionPane.showInputDialog("ingrese un estado valida");
				z = false;
			} else {
				z = true;
			}
		} while (z);
		
		Vehiculo vehiculo = new Vehiculo(0, patente, marca, modelo, 0, 0, null, precio);
		
		
		
	}

	public void buscar_pieza() {
		
	}

	public void vender_auto() {

	}

	public void registrar_venta() {
		// generar factura
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
		String contrasena = JOptionPane.showInputDialog("ingrese una contrase\u00f1a con un minimo de 6 caracteres y un maximo de 45");
		boolean aprobacion= login.RegistrarUsuario(contrasena,dni,nombre,apellido,direccion,altura,telefono);
		if (aprobacion) {
			login.registro(contrasena, dni, nombre, apellido, direccion, altura, telefono);
		}
	}

	public void comprar_pieza() {

	}

	public void revisar_deposito() {

	}

}
