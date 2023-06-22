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

		//String usuario;
		//char aux[] = { ' ', ' ' };
		Vehiculo vehiculo = new Vehiculo(0,"","","",0,0,0,"");
		Cliente cliente1 = new Cliente("","","","","");
		Mecanico pedro = new Mecanico ("","","","","","");
		Informe informe1 = new Informe (0,cliente1,vehiculo,2,true);
		pedro.completarInforme(informe1);
		final String tipo_de_cuenta[] = { "cliente", "empleado" };
		final String opciones[] = { "Registrarse", "Logearse","salir" };
		/*
		 * final String
		 * tipo_de_empleado[]={"ventas","administrador","restauracion","reparacion",
		 * "deposito"};
		 * 
		 * JCheckBox chec=new JCheckBox("Prueba"); //filtra cliente de empleado int
		 * seleccion = JOptionPane.showOptionDialog( chec,"Seleccione una opcion",
		 * "Selector de opciones",JOptionPane.YES_NO_CANCEL_OPTION,
		 * JOptionPane.QUESTION_MESSAGE,null,// null para icono por defecto.
		 * tipo_de_cuenta,tipo_de_cuenta[0]); if (seleccion!=-1) { if (seleccion==0) {
		 * aux[1]='x'; }else { //filtra el tipo de empleado int seleccion2 =
		 * JOptionPane.showOptionDialog( null,"Seleccione una opcion",
		 * "Selector de opciones",JOptionPane.YES_NO_CANCEL_OPTION,
		 * JOptionPane.QUESTION_MESSAGE,null,// null para icono por defecto.
		 * tipo_de_empleado,tipo_de_empleado[0]); if (seleccion2!=-1) { aux[1] =
		 * tipo_de_empleado[seleccion2].charAt(0); } }
		 */
		// ingrese el id de usuario y la contraseña

		/*
		 * aux[0] = tipo_de_cuenta[seleccion].charAt(0);
		 * 
		 * usuario = aux[0] +""+ aux[1]+""; System.err.println(usuario);
		 * 
		 * Login back = new Login(false); if (back.d(usuario)!="0") {
		 * back.setResul(true); } //String test_frase="ev54";
		 * //JOptionPane.showMessageDialog(null, back.d(usuario)); if
		 * (back.d(usuario)=="ev" || back.isResul()) {
		 * 
		 * 
		 * 
		 * Vendedor vendedor = new Vendedor("Elsa","Prime", "5993982836", "302", "abc");
		 * Cliente cliente = new Cliente("Elsa","Segundo", "5993982836", "302", "abc");
		 * Vehiculo vehiculo = new Vehiculo("fiat","207", "AGT178", 12, "null", false,
		 * 0); Pieza pieza = new Pieza(30, 4.00, "no", 0); String Contrasena =
		 * JOptionPane.showInputDialog(null, "Ingrese la contraseña"); if
		 * (Contrasena.equals(vendedor.getContrasena()) ) { do {
		 * vendedor.vendedor(vehiculo, pieza, cliente); } while
		 * (JOptionPane.showInputDialog("0 para salir").equals("1")); }else {
		 * 
		 * }
		 * 
		 * }
		 * 
		 * 
		 * 
		 * }
		 */

		JCheckBox chec = new JCheckBox("Prueba");
		// filtra cliente de empleado
		boolean key = true;
		Login empleado = new Login(0, 0, null, null, null, null);
		Login cliente = new Login(0, 0, null, null);
		do {

			int seleccion2 = JOptionPane.showOptionDialog(chec, "Seleccione una opcion", "Selector de opciones",
					JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, // null para icono por
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
						//System.err.println("cargando... 20%");
					} while (!aprobacion);
						aprobacion=false;
						aprobacion=empleado.registro1(contrasena, dni, nombre, apellido, direccion, altura, telefono);
					do {
						//System.err.println("cargando... 50%");
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
