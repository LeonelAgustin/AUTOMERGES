package Datos;

import java.util.LinkedList;

import javax.swing.JOptionPane;

public class Verifica {
	Pieza PiezaV = new Pieza(0,"","");

	public LinkedList<Pieza> verificaLista(){
		
		return PiezaV.Mostrar();
	}
	public boolean verificarAnadirP(String nombre, String precio) {
		int flag=0;
		do {
			
	
		if (nombre.length()>=3 &&  nombre.length()<=15){
			if (Integer.parseInt(precio)>0){
					flag=1;
					PiezaV.setNombre(nombre);
					PiezaV.setPrecio(precio);
					return true;
				}else {
					precio=JOptionPane.showInputDialog("Error al ingresar el precio debe ser mayor a 0");
				}
			}else {
				nombre = JOptionPane.showInputDialog("Error al ingresar el nombre debe tener entre 3 y 15 letras \n Ingrese el nombre de la nueva pieza");
		}
		}while(flag==0);
		return false;
		
	}
}
