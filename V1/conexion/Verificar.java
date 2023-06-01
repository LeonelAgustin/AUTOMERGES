package conexion;

import javax.swing.JOptionPane;

public class Verificar {

	public boolean verificarcontrasena(String contrasena) {
		String error = "";
		for (int i = 0; i < contrasena.length(); i++) {
			char q = contrasena.charAt(i);

			if (Character.isAlphabetic(q) && Character.isDigit(q) && q == '\u00e1' && q == '\u00e9' && q == '\u00ed'
					&& q == '\u00f3' && q == '\u00fa' && q == '\u00c1' && q == '\u00c9' && q == '\u00cd'
					&& q == '\u00d3' && q == '\u00da' && q == '\u00f1' && q == '\u00d1') {
				error = error + "el caracter " + q + "\n";
			}
		}
		if (error.equals("")) {
			return true;
		} else {
			JOptionPane.showMessageDialog(null, error);
			return false;
		}

	}

	public boolean verificardni(String dni) {
		String error = "";
		for (int i = 0; i < dni.length(); i++) {
			char q = dni.charAt(i);

			if (Character.isDigit(q)) {
				error = error + "el caracter " + q + "\n";
			}
		}
		if (error.equals("")) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verificarnombre(String nombre) {
		String error = "";
		for (int i = 0; i < nombre.length(); i++) {
			char q = nombre.charAt(i);

			if (Character.isAlphabetic(q) && q == '\u00e1' && q == '\u00e9' && q == '\u00ed' && q == '\u00f3'
					&& q == '\u00fa' && q == '\u00c1' && q == '\u00c9' && q == '\u00cd' && q == '\u00d3'
					&& q == '\u00da' && q == '\u00f1' && q == '\u00d1') {
				error = error + "el caracter " + q + "\n";
			}
		}
		if (error.equals("")) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verificarapellido(String apellido) {
		String error = "";
		for (int i = 0; i < apellido.length(); i++) {
			char q = apellido.charAt(i);

			if (Character.isAlphabetic(q) && q == '\u00e1' && q == '\u00e9' && q == '\u00ed' && q == '\u00f3'
					&& q == '\u00fa' && q == '\u00c1' && q == '\u00c9' && q == '\u00cd' && q == '\u00d3'
					&& q == '\u00da' && q == '\u00f1' && q == '\u00d1') {
				error = error + "el caracter " + q + "\n";
			}
		}
		if (error.equals("")) {
			return true;
		} else {
			return false;
		}

	}
	
	public boolean verificardireccion(String direccion) {
		String error = "";
		for (int i = 0; i < direccion.length(); i++) {
			char q = direccion.charAt(i);

			if (Character.isAlphabetic(q) && q == '\u00e1' && q == '\u00e9' && q == '\u00ed' && q == '\u00f3'
					&& q == '\u00fa' && q == '\u00c1' && q == '\u00c9' && q == '\u00cd' && q == '\u00d3'
					&& q == '\u00da' && q == '\u00f1' && q == '\u00d1'&& q =='\u00BA') {
				error = error + "el caracter " + q + "\n";
			}
		}
		if (error.equals("")) {
			return true;
		} else {
			return false;
		}

	}
	
	
	public boolean verificaraltura(String altura) {
		String error = "";
		for (int i = 0; i < altura.length(); i++) {
			char q = altura.charAt(i);

			if (Character.isDigit(q)) {
				error = error + "el caracter " + q + "\n";
			}
		}
		if (error.equals("")) {
			return true;
		} else {
			return false;
		}

	}
	

	public boolean verificartelefono(String telefono) {
		String error = "";
		for (int i = 0; i < telefono.length(); i++) {
			char q = telefono.charAt(i);

			if (Character.isDigit(q)) {
				error = error + "el caracter " + q + "\n";
			}
		}
		if (error.equals("")) {
			return true;
		} else {
			return false;
		}

	}
	
	
}
