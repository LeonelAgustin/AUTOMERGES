package deposito;

import javax.swing.JOptionPane;

public class main3 {

	public static void main(String[] args) {
	deposito dep = new deposito();
	
		dep.datosVehiculo();
		dep.datosPieza();
		
		
		JOptionPane.showMessageDialog(null, "INFORME:");
		JOptionPane.showMessageDialog(null, "DATOS DE TODOS LOS VEHICULOS");
		String informacióna="";
		for (vehiculo automoviles : dep.getAutomoviles()) {
			informacióna= informacióna+automoviles+"\n" ;
		}

			JOptionPane.showMessageDialog(null, informacióna);
			JOptionPane.showMessageDialog(null, "DATOS DE TODAS LAS PIEZAS");	
	String informaciónb="";
	for (pieza piezas : dep.getPiezas()) {
		informaciónb= informaciónb+piezas+"\n" ;
	}

		JOptionPane.showMessageDialog(null, informaciónb);
	}
	
}
