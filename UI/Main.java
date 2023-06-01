package UI;
import javax.swing.JOptionPane;

import Datos.Cliente;
import Datos.Empleados;
import Datos.Informe;
import Datos.Mecanico;
import Datos.Pieza;
import Datos.Vehiculo;

public class Main {

	public static void main(String[] args) {
		Vehiculo miauto = new Vehiculo ("toyota","corolla","ABC123",2014,false,true,1);
		Cliente senior = new Cliente (12345678,"luis", "gonzalez","microcentro",88776655,0003,miauto);
		Pieza cambiar =  new Pieza(1234,"bujia",12500.500,"importada",1);
		Mecanico juan = new Mecanico (987654321,"juan","smith", "Almagro",11223344,003,"bloquear345","tarde");
		
		Informe infor = new Informe (001, "reparacion",senior,miauto,cambiar,"Sin completar",false,0,juan);
		
		boolean salir = false; 
		do {
			int a = Integer.parseInt(JOptionPane.showInputDialog("Binevenido Mecanico, que tarea desea realizar hoy:\n1-"));
			switch (a) {
			case 1:
				
				break;

			case 2:
				break;
			}
		} while (salir==false);

	}

}
