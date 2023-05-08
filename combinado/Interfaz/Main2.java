package Interfaz;
import logica.*;

public class Main2 {
	//String nombre, String apellido, String dni, String tipo_cuenta, String id, String contrasena, int id_mecanico, String turno
	public static void main(String[] args) {
		Mecanico juan = new Mecanico("Juan","rodriguez","21234567","empleado","1213","contrasenia",9876,"maniana");
		
		juan.completarInforme();
	}

}
