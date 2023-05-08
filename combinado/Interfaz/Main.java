package Interfaz;

import javax.swing.*;
import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		/*
		 * login cliente cx + number chacter c + x empleado E + zone + numeber zonas
		 * ventas = v administrador = a restauracion = r reparacion = i
		 * 
		 */

		String usuario;
		char aux[] = { ' ', ' ' };
		final String tipo_de_cuenta[] = { "cliente", "empleado" };
		final String tipo_de_empleado[] = { "ventas", "administrador", "restauracion", "reparacion", "deposito" };

		JCheckBox chec = new JCheckBox("Prueba");
		// filtra cliente de empleado
		int seleccion = JOptionPane.showOptionDialog(null, "Seleccione una opcion", "Selector de opciones",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, // null para icono por defecto.
				tipo_de_cuenta, tipo_de_cuenta[0]);

		if (seleccion != -1) {
			if (seleccion == 0) {
				aux[1] = 'x';

			} else {
				// filtra el tipo de empleado
				int seleccion2 = JOptionPane.showOptionDialog(null, "Seleccione una opcion", "Selector de opciones",
						JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, // null para icono por
																								// defecto.
						tipo_de_empleado, tipo_de_empleado[0]);
				if (seleccion2 != -1) {
					aux[1] = tipo_de_empleado[seleccion2].charAt(0);
				}
			}
			// ingrese el id de usuario y la contraseña

			aux[0] = tipo_de_cuenta[seleccion].charAt(0);

			usuario = aux[0] + "" + aux[1] + "";
			System.err.println(usuario);

			Login back = new Login(false);
			// String test_frase="ev54";
			JOptionPane.showMessageDialog(null, back.d(usuario));
		}
	}

}
