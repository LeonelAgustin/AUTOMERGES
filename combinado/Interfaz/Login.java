package Interfaz;

public class Login {
	
	final char tipo[] = { 'c', 'e' };
	final char empleado[] = { 'v', 'a', 'r', 'i', 'd' };
	final String tipo_de_usuario[] = { "cliente", "ventas", "administrador", "restauracion", "reparacion", "deposito" };
	private boolean resul;

	public Login(boolean resul) {
		this.resul = resul;
	}

	public boolean isResul() {
		return resul;
	}

	public void setResul(boolean resul) {
		this.resul = resul;
	}

	public String d(String value) {
		if (value.charAt(0) == tipo[0]) {
			return tipo_de_usuario[0];
		}
		if (value.charAt(0) == tipo[1]) {

			if (value.charAt(1) == empleado[0]) {
				return tipo_de_usuario[1];
			}
			if (value.charAt(1) == empleado[1]) {
				return tipo_de_usuario[2];
			}
			if (value.charAt(1) == empleado[2]) {
				return tipo_de_usuario[3];
			}
			if (value.charAt(1) == empleado[3]) {
				return tipo_de_usuario[4];
			}
			if (value.charAt(1) == empleado[4]) {
				return tipo_de_usuario[5];
			}

			if (value.charAt(1) == ' ') {
				return "error";
			}

		}

		return "0";
	}

}
