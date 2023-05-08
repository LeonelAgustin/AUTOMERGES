package logica;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import javax.swing.*;

public class Deposito {
	public int opcion = 0;
	private int cod_deposto;
	private ArrayList<Pieza> piezas;
	private ArrayList<Vehiculo> automoviles;
	private boolean stock_P;
	private boolean stock_v;

	public Deposito(int opcion, int cod_deposto, ArrayList<Pieza> piezas, ArrayList<Vehiculo> automoviles,
			boolean stock_P, boolean stock_v) {
		super();
		this.opcion = opcion;
		this.cod_deposto = cod_deposto;
		this.piezas = piezas;
		this.automoviles = automoviles;
		this.stock_P = stock_P;
		this.stock_v = stock_v;
	}

	public int getCod_deposto() {
		return cod_deposto;
	}

	public void setCod_deposto(int cod_deposto) {
		this.cod_deposto = cod_deposto;
	}

	public ArrayList<Pieza> getPiezas() {
		return piezas;
	}

	public void setPiezas(ArrayList<Pieza> piezas) {
		this.piezas = piezas;
	}

	public ArrayList<Vehiculo> getAutomoviles() {
		return automoviles;
	}

	public void setAutomoviles(ArrayList<Vehiculo> automoviles) {
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
		JOptionPane.showMessageDialog(null, "ingrese datos de vehiculos para el informe");
		int opcio;
		do {
			String marc = JOptionPane.showInputDialog("introduzca marca del vehiculo ");
			String mod = JOptionPane.showInputDialog("introduzca modelo del vehiculo ");
			String pat = JOptionPane.showInputDialog("introduzca patente del vehiculo ");
			int anio = Integer.parseInt(JOptionPane.showInputDialog("introduzca el anio"));
			String res = JOptionPane.showInputDialog("introduzca si el vehiculo fue restaurado");
			int esta = Integer.parseInt(JOptionPane
					.showInputDialog("introduzca el estado del producto:\n 1 si esta todo correcto 0 si hay algo raro"));
			if (esta == 0) {

				int caso = Integer.parseInt(JOptionPane.showInputDialog(
						"ingrese uno de las anomailias que aparecen en pantalla ,\n 1 error con la pieza anda rara\n 2 error la pieza esta calificada como muerta \n3 reparaciones basicas a la pieza para probar"));

				switch (caso) {
				case 1:
					JOptionPane.showMessageDialog(null,
							"La pieza/vehiculo andaba mal y a pesar de intentar las reparaciones basicas \n se la diste al final al mecanico para que la revisara");
					Vehiculo auto1 = new Vehiculo(marc, mod, pat, anio, res, esta);

					automoviles.add(auto1);
					break;
				case 2:
					JOptionPane.showMessageDialog(null,
							"La pieza/ vehiculo al intentar las reparaciones basicas no mostraba se�ales de vida asi que la diste por muerta y la vendiste al mejor postor no agregar al informe");
					break;
				case 3:
					JOptionPane.showMessageDialog(null,
							"La pieza/vehiculo se realizo las reparaciones basicas y anduvo");
					Vehiculo auto3 = new Vehiculo(marc, mod, pat, anio, res, esta);

					automoviles.add(auto3);
					break;
				default:
					break;
				}
			} else {
				Vehiculo auto = new Vehiculo(marc, mod, pat, anio, res, esta);

				automoviles.add(auto);
			}

			opcio = Integer.parseInt(JOptionPane.showInputDialog("quiere agregar otro vehiculo? 1-Si\n0-No"));
		} while (opcio == 1);

		JOptionPane.showMessageDialog(null, "datos cargados correctamente");
		return "";
	}

	public String datosPieza() {
		JOptionPane.showMessageDialog(null, "ingrese datos de las piezas para el informe");
		int opcio;
		do {
			int n_s = Integer.parseInt(JOptionPane.showInputDialog("introduzca el numero de serie"));
			double pre = (int) Integer.parseInt(JOptionPane.showInputDialog("ingrese el valor de la pieza"));
			String impo = JOptionPane.showInputDialog("introduzca si fue importado ");
			int esta = Integer.parseInt(JOptionPane
					.showInputDialog("introduzca el estado del producto 1 si esta todo correcto 0 si hay algo raro"));
			if (esta == 0) {

				int caso = Integer.parseInt(JOptionPane.showInputDialog(
						"ingrese uno de las anomailias que aparecen en pantalla ,\n 1 error con la pieza anda rara\n 2 error la pieza esta calificada como muerta \n3 reparaciones basicas a la pieza para probar"));

				switch (caso) {
				case 1:
					JOptionPane.showMessageDialog(null,
							"La pieza/vehiculo andaba mal y a pesar de intentar las reparaciones basicas \n se la diste al final al mecanico para que la revisara");
					Pieza piezaas1 = new Pieza(n_s, pre, impo, esta);

					piezas.add(piezaas1);
					break;
				case 2:
					JOptionPane.showMessageDialog(null,
							"La pieza/ vehiculo al intentar las reparaciones basicas no mostraba se�ales de vida asi que la diste por muerta y la vendiste al mejor postor no agregar al informe");
					break;
				case 3:
					JOptionPane.showMessageDialog(null,
							"La pieza/vehiculo se realizo las reparaciones basicas y anduvo");
					Pieza piezaas3 = new Pieza(n_s, pre, impo, esta);

					piezas.add(piezaas3);
					break;
				default:
					break;
				}
			} else {
				Pieza piezaas = new Pieza(n_s, pre, impo, esta);

				piezas.add(piezaas);
			}

			opcio = Integer.parseInt(JOptionPane.showInputDialog("quiere agregar otro 1 si o 0 no"));
		} while (opcio == 1);
		JOptionPane.showMessageDialog(null, "datos cargados correctamente");
		return "datos ingresados correctamente";
	}

	public String informe() {
		JOptionPane.showMessageDialog(null, "informacion de cada vehiculo");
		for (Vehiculo vehiculo : automoviles) {
			JOptionPane.showMessageDialog(null, vehiculo.toString());
		}
		JOptionPane.showMessageDialog(null, "informacion de cada pieza");
		for (Pieza piezaas : piezas) {
			JOptionPane.showMessageDialog(null, piezaas.toString());

		}
		return "-";
	}

	public Deposito() {
		this.automoviles = new ArrayList<Vehiculo>();
		this.piezas = new ArrayList<Pieza>();
		this.stock_P = true;
		this.stock_v = true;
	}
}
