package Visual;

import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

import Logica.Cliente;
import Logica.Informe;
import Logica.Login;
import Logica.Mecanico;
import Logica.Vehiculo;


public class Main {

	public static void main(String[] args) {

		final String tipo_de_cuenta[] = { "cliente", "empleado" };
		final String opciones[] = { "Registrarse", "Logearse","salir" };
		
		JCheckBox chec = new JCheckBox("Prueba");
		
		
		boolean key = true;
		Login empleado = new Login(0, 0, null, null, null, null);
		Login cliente = new Login(0, 0, null, null);
		do {

			int seleccion2 = JOptionPane.showOptionDialog(chec, "Seleccione una opcion", "Selector de opciones",
					JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, 
					opciones, opciones[0]);

			if (seleccion2 == 0) {
				try {
					String dni = JOptionPane.showInputDialog("ingresa tu dni");
					String nombre = JOptionPane.showInputDialog("ingresa tu nombre");
					String apellido = JOptionPane.showInputDialog("ingresa tu apellido");
					String direccion = JOptionPane.showInputDialog("ingresa tu direccion");
					String altura = JOptionPane.showInputDialog("ingrese la altura de tu direccion");
					String telefono = JOptionPane.showInputDialog("ingresa tu telefono");
					String contrasena =JOptionPane.showInputDialog("ingrese una contrase\u00f1a con un minimo de 6 caracteres y un maximo de 45");
					boolean aprobacion= empleado.RegistrarUsuario(contrasena,dni,nombre,apellido,direccion,altura,telefono);
					if (aprobacion) {
						aprobacion=false;
						aprobacion=empleado.registro(contrasena, dni, nombre, apellido, direccion, altura, telefono);
					}
					do {
						
					} while (!aprobacion);
						aprobacion=false;
						aprobacion=empleado.registro1(contrasena, dni, nombre, apellido, direccion, altura, telefono);
					do {
						
					} while (!aprobacion);
						System.err.println(empleado.getId());
						empleado.registro2(contrasena, dni, nombre, apellido, direccion, altura, telefono);
					
					
					
					
				} catch (Exception e) {
					JOptionPane.showConfirmDialog(chec,"error intentado registrar el usuario");
				}
					
			} else {
				if(seleccion2==1) {
				
				int seleccion = JOptionPane.showOptionDialog(chec, "Seleccione una opcion", "Selector de opciones",
						JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, // null para icono por
						tipo_de_cuenta, tipo_de_cuenta[0]);
				String user = JOptionPane.showInputDialog("ingrese el dni");
				String pass = JOptionPane.showInputDialog("ingrese la contrase\u00f1a");
				System.err.println('\u00BA');


			
				if (seleccion == 1) {
					if (empleado.TraerEmleados(pass, user)) {
						empleado.menu_transport();
						System.err.println(empleado);
					} else {
						System.err.println("error");
					}
				} else {
					if (cliente.TraerUsuarios(pass, user)) {
						
						System.err.println(cliente);
					} else {
						System.err.println("error");
					}
				}
				
			}else {
				key=false;
			}
				
			}
			
			
		} while (key);
	}

}
