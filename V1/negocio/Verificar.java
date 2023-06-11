package negocio;

import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class Verificar {

	public boolean verificarcontrasena(String contrasena) {
		String error = "";
		// System.err.println(contrasena.length());
		char errorcaracter[] = new char[contrasena.length()];
		int errorconter = 0;
		if (contrasena.length() >= 6 && contrasena.length() <= 45) {

			for (int i = 0; i < contrasena.length(); i++) {
				char q = contrasena.charAt(i);

				if ((q < 'a' || q > 'z') && (q < 'A' || q > 'Z') && (q < '0' || q > '9') && q != '\u00e1'
						&& q != '\u00e9' && q != '\u00ed' && q != '\u00f3' && q != '\u00fa' && q != '\u00c1'
						&& q != '\u00c9' && q != '\u00cd' && q != '\u00d3' && q != '\u00da' && q != '\u00f1'
						&& q != '\u00d1' && q != '-' && q != '#' && q != '+' && q != '_') {
					errorcaracter[errorconter] = q;
					errorconter++;
				}
				// error = error + "el caracter " + q + "\n";
			}
		} else {
			if (contrasena.length() <= 6 && contrasena.length() >= 0) {
				error = "la contrase\u00f1a tiene que tener m\u00e1s de 6 caracteres \ncantidad de caracteres "
						+ contrasena.length();
			} else {

				if (contrasena.length() >= 45) {
					error = "la contrase\u00f1a tiene que tener menos de 45 caracteres \ncantidad de caracteres "
							+ contrasena.length();
				}
			}
		}
		System.err.println(errorconter);
		if (errorconter >= 1) {
			if (errorconter == 1) {
				error = "el caracter " + errorcaracter[0] + " es invalido";
			} else {
				error = "los caracteres ";
				for (int i = 0; i < errorconter; i++) {
					error = error + "\"" + " " + errorcaracter[i] + " " + "\"" + ",";
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
		char errorcaracter[] = new char[dni.length()];
		int errorconter = 0;

		if (dni.length() >= 6 && dni.length() <= 10) {

			for (int i = 0; i < dni.length(); i++) {
				char q = dni.charAt(i);

				if (q < '0' || q > '9') {
					errorcaracter[errorconter] = q;
					errorconter++;
					// error = error + "el caracter " + q + "\n";
				}
			}

		} else {

			if (dni.length() <= 6 && dni.length() >= 0) {
				error = "el dni tiene que tener un minimo de 6 numeros " + dni.length();
			} else {

				if (dni.length() >= 10) {
					error = "el dni tiene que tener un maximo de 10 numeros" + dni.length();
				}

			}

		}

		if (errorconter >= 1) {
			if (errorconter == 1) {
				error = "el caracter " + errorcaracter[0] + " es invalido";
			} else {
				error = "los caracteres ";
				for (int i = 0; i < errorconter; i++) {
					error = error + "\"" + " " + errorcaracter[i] + " " + "\"" + ",";
				}
				error = error + " son invalidos";
			}

		}

		if (error.equals("")) {
			return true;
		} else {
			JOptionPane.showMessageDialog(null, error);
			return false;
		}

	}

	public boolean verificarnombre(String nombre) {
		String error = "";
		char errorcaracter[] = new char[nombre.length()];
		int errorconter = 0;

		if (nombre.length() >= 2 && nombre.length() <= 45) {

			for (int i = 0; i < nombre.length(); i++) {
				char q = nombre.charAt(i);
				if ((q < 'a' || q > 'z') && (q < 'A' || q > 'Z') && q != '\u00e1' && q != '\u00e9' && q != '\u00ed'
						&& q != '\u00f3' && q != '\u00fa' && q != '\u00c1' && q != '\u00c9' && q != '\u00cd'
						&& q != '\u00d3' && q != '\u00da' && q != '\u00f1' && q != '\u00d1' && Character.isDigit(q)) {
					errorcaracter[errorconter] = q;
					errorconter++;
					// error = error + "el caracter " + q + "\n";
				}
			}

		} else {

			if (nombre.length() <= 2 && nombre.length() >= 0) {
				error = "el nombre tiene que tener un minimo de 2 numeros " + nombre.length();
			} else {

				if (nombre.length() >= 45) {
					error = "el nombre tiene que tener un maximo de 45 numeros" + nombre.length();
				}

			}

		}

		// System.err.println(errorconter);

		if (errorconter >= 1) {
			if (errorconter == 1) {
				error = "el caracter " + errorcaracter[0] + " es invalido";
			} else {
				error = "los caracteres ";
				for (int i = 0; i < errorconter; i++) {
					error = error + "\"" + " " + errorcaracter[i] + " " + "\"" + ",";
				}
				error = error + " son invalidos";
			}

		}

		if (error.equals("")) {
			return true;
		} else {
			JOptionPane.showMessageDialog(null, error);
			return false;
		}

	}

	public boolean verificarapellido(String apellido) {
		String error = "";
		char errorcaracter[] = new char[apellido.length()];
		int errorconter = 0;

		if (apellido.length() >= 2 && apellido.length() <= 45) {

			for (int i = 0; i < apellido.length(); i++) {
				char q = apellido.charAt(i);

				if ((q < 'a' || q > 'z') && (q < 'A' || q > 'Z') && q != '\u00e1' && q != '\u00e9' && q != '\u00ed'
						&& q != '\u00f3' && q != '\u00fa' && q != '\u00c1' && q != '\u00c9' && q != '\u00cd'
						&& q != '\u00d3' && q != '\u00da' && q != '\u00f1' && q != '\u00d1' && Character.isDigit(q)) {
					errorcaracter[errorconter] = q;
					errorconter++;

				}

			}

		} else {

			if (apellido.length() <= 6 && apellido.length() >= 0) {
				error = "el apellido tiene que tener un minimo de 6 numeros " + apellido.length();
			} else {

				if (apellido.length() >= 45) {
					error = "el apellido tiene que tener un maximo de 45 numeros" + apellido.length();
				}

			}

		}

		if (errorconter >= 1) {
			if (errorconter == 1) {
				error = "el caracter " + errorcaracter[0] + " es invalido";
			} else {
				error = "los caracteres ";
				for (int i = 0; i < errorconter; i++) {
					error = error + "\"" + " " + errorcaracter[i] + " " + "\"" + ",";
				}
				error = error + " son invalidos";
			}

		}

		if (error.equals("")) {
			return true;
		} else {
			JOptionPane.showMessageDialog(null, error);
			return false;
		}

	}

	public boolean verificardireccion(String direccion) {
		String error = "";
		char errorcaracter[] = new char[direccion.length()];
		int errorconter = 0;

		if (direccion.length() >= 2 && direccion.length() <= 45) {

			for (int i = 0; i < direccion.length(); i++) {
				char q = direccion.charAt(i);

				if ((q < 'a' || q > 'z') && (q < 'A' || q > 'Z') && q != '\u00e1' && q != '\u00e9' && q != '\u00ed'
						&& q != '\u00f3' && q != '\u00fa' && q != '\u00c1' && q != '\u00c9' && q != '\u00cd'
						&& q != '\u00d3' && q != '\u00da' && q != '\u00f1' && q != '\u00d1' && q != ' ') {
					errorcaracter[errorconter] = q;
					errorconter++;
					// error = error + "el caracter " + q + "\n";
				}
			}

		} else {

			if (direccion.length() <= 6 && direccion.length() >= 0) {
				error = "la direccion tiene que tener un minimo de 6 numeros " + direccion.length();
			} else {

				if (direccion.length() >= 45) {
					error = "la direccion tiene que tener un maximo de 45 numeros" + direccion.length();
				}

			}

		}

		if (errorconter >= 1) {
			if (errorconter == 1) {
				error = "el caracter " + errorcaracter[0] + " es invalido";
			} else {
				error = "los caracteres ";
				for (int i = 0; i < errorconter; i++) {
					error = error + "\"" + " " + errorcaracter[i] + " " + "\"" + ",";
				}
				error = error + " son invalidos";
			}

		}

		if (error.equals("")) {
			return true;
		} else {
			JOptionPane.showMessageDialog(null, error);
			return false;
		}

	}

	public boolean verificaraltura(String altura) {
		String error = "";
		char errorcaracter[] = new char[altura.length()];
		int errorconter = 0;

		if (altura.length() >= 2 && altura.length() <= 10) {

			for (int i = 0; i < altura.length(); i++) {
				char q = altura.charAt(i);

				if (q < '0' || q > '9') {
					errorcaracter[errorconter] = q;
					errorconter++;
					// error = error + "el caracter " + q + " no es numerico\n";
				}
			}

		} else {

			if (altura.length() <= 2 && altura.length() >= 0) {
				error = "la altura tiene que tener un minimo de 6 numeros " + altura.length();
			} else {

				if (altura.length() >= 10) {
					error = "la altura tiene que tener un maximo de 10 numeros" + altura.length();
				}

			}

		}

		if (errorconter >= 1) {
			if (errorconter == 1) {
				error = "el caracter " + errorcaracter[0] + " es invalido";
			} else {
				error = "los caracteres ";
				for (int i = 0; i < errorconter; i++) {
					error = error + "\"" + " " + errorcaracter[i] + " " + "\"" + ",";
				}
				error = error + " son invalidos";
			}

		}

		if (error.equals("")) {
			return true;
		} else {
			JOptionPane.showMessageDialog(null, error);
			return false;
		}

	}

	public boolean verificartelefono(String telefono) {
		String error = "";
		char errorcaracter[] = new char[telefono.length()];
		int errorconter = 0;

		if (telefono.length() >= 8 && telefono.length() <= 20) {

			for (int i = 0; i < telefono.length(); i++) {
				char q = telefono.charAt(i);

				if (q < '0' || q > '9') {
					errorcaracter[errorconter] = q;
					errorconter++;
					// error = error + "el caracter " + q + "\n";
				}
			}

		} else {

			if (telefono.length() <= 8 && telefono.length() >= 0) {
				error = "el telefono tiene que tener un minimo de 8 numeros " + telefono.length();
			} else {

				if (telefono.length() >= 20) {
					error = "el telefono tiene que tener un maximo de 20 numeros" + telefono.length();
				}

			}

		}

		if (errorconter >= 1) {
			if (errorconter == 1) {
				error = "el caracter " + errorcaracter[0] + " es invalido";
			} else {
				error = "los caracteres ";
				for (int i = 0; i < errorconter; i++) {
					error = error + "\"" + " " + errorcaracter[i] + " " + "\"" + ",";
				}
				error = error + " son invalidos";
			}

		}

		if (error.equals("")) {
			return true;
		} else {
			JOptionPane.showMessageDialog(null, error);
			return false;
		}

	}

	public boolean verificarid(String id) {
		String error = "";
		char errorcaracter[] = new char[id.length()];
		int errorconter = 0;

		if (id.length() >= 8 && id.length() <= 20) {

			for (int i = 0; i < id.length(); i++) {
				char q = id.charAt(i);

				if (q < '0' || q > '9') {
					errorcaracter[errorconter] = q;
					errorconter++;
					// error = error + "el caracter " + q + "\n";
				}
			}

		} else {

			if (id.length() <= 8 && id.length() >= 0) {
				error = "el id tiene que tener un minimo de 8 numeros " + id.length();
			} else {

				if (id.length() >= 20) {
					error = "el id tiene que tener un maximo de 20 numeros" + id.length();
				}

			}

		}

		if (errorconter >= 1) {
			if (errorconter == 1) {
				error = "el caracter " + errorcaracter[0] + " es invalido";
			} else {
				error = "los caracteres ";
				for (int i = 0; i < errorconter; i++) {
					error = error + "\"" + " " + errorcaracter[i] + " " + "\"" + ",";
				}
				error = error + " son invalidos";
			}

		}

		if (error.equals("")) {
			return true;
		} else {
			JOptionPane.showMessageDialog(null, error);
			return false;
		}

	}

	public boolean verificarpatente(String patente) {
		String error = "";
		// System.err.println(contrasena.length());

		if (patente.length() <= 6 && patente.length() >= 7) {
			if (patente.length() == 6) {
				for (int i = 0; i < patente.length(); i++) {
					if (i <= 0 && i > 3) {
						if (patente.charAt(i)<'A'||patente.charAt(i)>'Z') {
							
						}else {
							error="la patente no es valida";
						}
					} else {
						if (patente.charAt(i)<'0'||patente.charAt(i)>'9') {
							
						}else {
							error="la patente no es valida";
						}
					}
				}
			} else {
				for (int i = 0; i < patente.length(); i++) {
					if (i <= 0 && i > 4) {
						if (patente.charAt(i)<'A'||patente.charAt(i)>'Z') {
							
						}else {
							error="la patente no es valida";
						}
					} else {
						if (patente.charAt(i)<'0'||patente.charAt(i)>'9') {
							
						}else {
							error="la patente no es valida";
						}
					}
				}
			}

		} 

		// System.err.println(error);
		if (error.equals("")) {
			return true;
		} else {
			JOptionPane.showMessageDialog(null, error);
			return false;
		}

	}

	public boolean verificarmarca(String marca) {
		String error = "";
		char errorcaracter[] = new char[marca.length()];
		int errorconter = 0;
		// System.err.println(contrasena.length());
		if (marca.length() >= 4 && marca.length() <= 45) {

			for (int i = 0; i < marca.length(); i++) {
				char q = marca.charAt(i);

				if (q < '0' || q > '9') {
					errorcaracter[errorconter] = q;
					errorconter++;
					// error = error + "el caracter " + q + " no es numerico\n";
				}
			}

		} else {

			if (marca.length() <= 4 && marca.length() >= 0) {
				error = "la marca tiene que tener un minimo de 4 caracteres " + marca.length();
			} else {

				if (marca.length() >= 45) {
					error = "la marca tiene que tener un maximo de 45 caracteres" + marca.length();
				}

			}

		}
		// System.err.println(error);
		if (error.equals("")) {
			return true;
		} else {
			JOptionPane.showMessageDialog(null, error);
			return false;
		}

	}

	public boolean verificarano(String ano) {
		String error = "";
		// System.err.println(contrasena.length());

		Pattern pat = Pattern.compile("([0-9]{4,4})");
		Matcher mat = pat.matcher(ano);

		if (mat.matches()) {

		} else {
			error = ano + " no es una a\u00f1o valida";
		}

		// System.err.println(error);
		if (error.equals("")) {
			return true;
		} else {
			JOptionPane.showMessageDialog(null, error);
			return false;
		}

	}

	public boolean verificarestado(String estado) {
		String error = "";
		// System.err.println(contrasena.length());
		boolean stop = estado.length() == 1;
		Pattern pat = Pattern.compile("([0-5]{1,1})");
		Matcher mat = pat.matcher(estado);

		if (mat.matches() && stop) {

		} else {
			error = estado + " no es una estado valida";
		}

		// System.err.println(error);
		if (error.equals("")) {
			return true;
		} else {
			JOptionPane.showMessageDialog(null, error);
			return false;
		}

	}

	public boolean verificarprecio(String precio) {
		String error = "";
		// System.err.println(contrasena.length());
		
		
		Pattern pat = Pattern.compile("([0-9]{1,28})([.]{1})([0-9]{2})");
		Matcher mat = pat.matcher(precio);

		if (mat.matches()) {

		} else {
			error = precio + " no es una precio valido el formato es 400.00";
		}

		// System.err.println(error);
		if (error.equals("")) {
			return true;
		} else {
			JOptionPane.showMessageDialog(null, error);
			return false;
		}

	}

	public boolean verificarmodelo(String modelo) {
		String error = "";
		char errorcaracter[] = new char[modelo.length()];
		int errorconter = 0;
		// System.err.println(contrasena.length());
		if (modelo.length() >= 4 && modelo.length() <= 45) {

			for (int i = 0; i < modelo.length(); i++) {
				char q = modelo.charAt(i);

				if ((q < 'a' || q > 'z') && (q < 'A' || q > 'Z') && q != '\u00e1' && q != '\u00e9' && q != '\u00ed'
						&& q != '\u00f3' && q != '\u00fa' && q != '\u00c1' && q != '\u00c9' && q != '\u00cd'
						&& q != '\u00d3' && q != '\u00da' && q != '\u00f1' && q != '\u00d1') {
					errorcaracter[errorconter] = q;
					errorconter++;
					// error = error + "el caracter " + q + " no es numerico\n";
				}
			}

		} else {

			if (modelo.length() <= 4 && modelo.length() >= 0) {
				error = "la modelo tiene que tener un minimo de 4 caracteres " + modelo.length();
			} else {

				if (modelo.length() >= 45) {
					error = "la modelo tiene que tener un maximo de 45 caracteres" + modelo.length();
				}

			}

		}
		// System.err.println(error);
		if (error.equals("")) {
			return true;
		} else {
			JOptionPane.showMessageDialog(null, error);
			return false;
		}

	}

}
