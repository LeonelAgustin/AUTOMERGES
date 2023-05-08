package deposito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import javax.swing.*;

public class deposito {
	public int opcion = 0;
private int cod_deposto;
private ArrayList<pieza> piezas;  
private ArrayList<vehiculo> automoviles;
private boolean stock_P;
private boolean stock_v;


public int getCod_deposto() {
	return cod_deposto;
}
public void setCod_deposto(int cod_deposto) {
	this.cod_deposto = cod_deposto;
}
public ArrayList<pieza> getPiezas() {
	return piezas;
}
public void setPiezas(ArrayList<pieza> piezas) {
	this.piezas = piezas;
}
public ArrayList<vehiculo> getAutomoviles() {
	return automoviles;
}
public void setAutomoviles(ArrayList<vehiculo> automoviles) {
	this.automoviles = automoviles;
}
public boolean isStock_P() {
	return stock_P;
}
public void setStock_P(boolean stock_P) {
	this.stock_P = stock_P;
}
public boolean isStock_v() {
	return stock_v;
}
public void setStock_v(boolean stock_v) {
	this.stock_v = stock_v;
}

public String datosVehiculo() {
	JOptionPane.showMessageDialog(null, "Bienvenido encargado de deposito");
	JOptionPane.showMessageDialog(null, "ingrese datos de vehiculos para el informe");
	int opcio; 
    do {
        String marc = JOptionPane.showInputDialog("introduzca marca del vehiculo ");
       
        String mod = JOptionPane.showInputDialog("introduzca modelo del vehiculo ");
        String pat = JOptionPane.showInputDialog("introduzca patente del vehiculo ");
        int año = Integer.parseInt(JOptionPane.showInputDialog("introduzca el año"));
        String res = JOptionPane.showInputDialog("introduzca si el vehiculo fue restaurado");
        String esta = JOptionPane.showInputDialog("El producto esta en orden o alguna anomalia mal o bien");
        if (esta.equalsIgnoreCase("mal")) {
        	
        	int caso = Integer.parseInt(JOptionPane.showInputDialog("ingrese uno de las anomailias que aparecen en pantalla ,\n 1 error con la pieza anda rara\n 2 error la pieza esta calificada como muerta \n3 reparaciones basicas a la pieza para probar"));
        	
        	switch (caso) {
			case 1:
				JOptionPane.showMessageDialog(null, "La pieza/vehiculo andaba mal y a pesar de intentar las reparaciones basicas \n se la diste al final al mecanico para que la revisara");
				 vehiculo auto1 = new vehiculo(marc, mod, pat, año, res, esta);

			        automoviles.add(auto1);
				break;
			case 2:
				JOptionPane.showMessageDialog(null, "La pieza/ vehiculo al intentar las reparaciones basicas no mostraba señales de vida asi que la diste por muerta y la vendiste al mejor postor no agregar al informe");
			break;
			case 3:
				JOptionPane.showMessageDialog(null, "La pieza/vehiculo se realizo las reparaciones basicas y anduvo");
				 vehiculo auto3 = new vehiculo(marc, mod, pat, año, res, esta);

			        automoviles.add(auto3);
				break;
			default:
				break;
			}
		} else {
			 vehiculo auto = new vehiculo(marc, mod, pat, año, res, esta);

		        automoviles.add(auto);
		}

       
        opcio = Integer.parseInt(JOptionPane.showInputDialog("quiere agregar otro 1 si o 0 no"));
    } while (opcio == 1);

    JOptionPane.showMessageDialog(null, "datos cargados correctamente");
	return "";
}
public String datosPieza() {
	JOptionPane.showMessageDialog(null, "ingrese datos de las piezas para el informe");
	int opcio; 
    do {
    	String nom = JOptionPane.showInputDialog("ingrese nombre de la pieza");
    	int n_s = Integer.parseInt(JOptionPane.showInputDialog("introduzca el numero de serie"));
        double pre = (int) Integer.parseInt(JOptionPane.showInputDialog("ingrese el valor de la pieza"));
        String impo = JOptionPane.showInputDialog("introduzca si fue importado ");
        String esta = JOptionPane.showInputDialog("El producto esta en orden o alguna anomalia mal o bien");
 if (esta.equalsIgnoreCase("mal")) {
        	
        	int caso = Integer.parseInt(JOptionPane.showInputDialog("ingrese uno de las anomailias que aparecen en pantalla ,\n 1 error con la pieza anda rara\n 2 error la pieza esta calificada como muerta \n3 reparaciones basicas a la pieza para probar"));
        	
        	switch (caso) {
			case 1:
				JOptionPane.showMessageDialog(null, "La pieza/vehiculo andaba mal y a pesar de intentar las reparaciones basicas \n se la diste al final al mecanico para que la revisara");
				esta = "se mando al mecanico";
				pieza piezaas1 = new pieza(nom,n_s,pre,impo,esta);

		        piezas.add(piezaas1);
				break;
			case 2:
				JOptionPane.showMessageDialog(null, "La pieza/ vehiculo al intentar las reparaciones basicas no mostraba señales de vida asi que la diste por muerta y la vendiste al mejor postor no agregar al informe");
			break;
			case 3:
				JOptionPane.showMessageDialog(null, "La pieza/vehiculo se realizo las reparaciones basicas y anduvo");
				esta= "se realizo las reparaciones basicas y ando";
				 pieza piezaas3 = new pieza(nom,n_s,pre,impo,esta);

			        piezas.add(piezaas3);
				break;
			default:
				break;
			}
		} else {
			 pieza piezaas = new pieza(nom,n_s,pre,impo,esta);

		        piezas.add(piezaas);
		}

   
        opcio = Integer.parseInt(JOptionPane.showInputDialog("quiere agregar otro 1 si o 0 no"));
    } while (opcio == 1);
    JOptionPane.showMessageDialog(null, "datos cargados correctamente");
	return "datos ingresados correctamente";
}


public deposito() {
    this.automoviles = new ArrayList<vehiculo>();
    this.piezas = new ArrayList<pieza>();
    this.stock_P = true;
    this.stock_v = true;
}
}