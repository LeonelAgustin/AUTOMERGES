package conexion;

import javax.swing.JOptionPane;

public class Verificar {

	public boolean verificarcontrasena(String contrasena) {
		String error = "";
		System.err.println(contrasena.length());
		char errorcaracter[]= new char[contrasena.length()];
		int errorconter = 0;
		if (contrasena.length() >= 6 && contrasena.length() <= 45) {

			for (int i = 0; i < contrasena.length(); i++) {
				char q = contrasena.charAt(i);

				if ((q < 'a' || q > 'z') && (q < 'A' || q > 'Z')&& ( q<'0'||q>'9' ) && q != '\u00e1' && q != '\u00e9' && q != '\u00ed'
						&& q != '\u00f3' && q != '\u00fa' && q != '\u00c1' && q != '\u00c9' && q != '\u00cd'
						&& q != '\u00d3' && q != '\u00da' && q != '\u00f1' && q != '\u00d1'&& q !='-'&& q !='#'&& q !='+' && q !='_') {
					errorcaracter[errorconter]=q;
					errorconter++;
				}
				//error = error + "el caracter " + q + "\n";
			}
		}else {
			if (contrasena.length() <= 6 && contrasena.length() >= 0) {
				error = "la contrase\u00f1a tiene que tener m\u00e1s de 6 caracteres \ncantidad de caracteres " + contrasena.length();
			}else {
			
			if (contrasena.length() >= 45 ) {
				error = "la contrase\u00f1a tiene que tener menos de 45 caracteres \ncantidad de caracteres " + contrasena.length();
			}}
		}
		System.err.println(errorconter);
		if (errorconter>=1) {
			if (errorconter==1) {
				error = "el caracter " + errorcaracter[0] + " es invalido";
			}else {
				error = "los caracteres ";
				for (int i = 0; i < errorconter; i++) {
					error = error +"\""+" "+ errorcaracter[i] + " " +"\""+ "," ;
				}
				error = error + " son invalidos";
			}
			
		}
		
		System.err.println(error);
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

			if (!Character.isDigit(q)) {
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

			if (!Character.isAlphabetic(q) && q != '\u00e1' && q != '\u00e9' && q != '\u00ed' && q != '\u00f3'
					&& q != '\u00fa' && q != '\u00c1' && q != '\u00c9' && q != '\u00cd' && q != '\u00d3'
					&& q != '\u00da' && q != '\u00f1' && q != '\u00d1') {
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

			if (!Character.isAlphabetic(q) && q != '\u00e1' && q != '\u00e9' && q != '\u00ed' && q != '\u00f3'
					&& q != '\u00fa' && q != '\u00c1' && q != '\u00c9' && q != '\u00cd' && q != '\u00d3'
					&& q != '\u00da' && q != '\u00f1' && q != '\u00d1') {
				if (error.equals("")) {
					error = "el caracter " + q + "\n";
				} else {
					error = error + " , " + q;
				}

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

			if (!Character.isAlphabetic(q) && q != '\u00e1' && q != '\u00e9' && q != '\u00ed' && q != '\u00f3'
					&& q != '\u00fa' && q != '\u00c1' && q != '\u00c9' && q != '\u00cd' && q != '\u00d3'
					&& q != '\u00da' && q != '\u00f1' && q != '\u00d1' && q != '\u00BA') {
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

			if (!Character.isDigit(q)) {
				error = error + "el caracter " + q + " no es numerico\n";
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

			if (!Character.isDigit(q)) {
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
