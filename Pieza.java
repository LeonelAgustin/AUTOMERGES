package automerges;

import java.util.LinkedList;

import javax.swing.JOptionPane;

public class Pieza {
	private int numero_de_pieza;
	private double precio;
	private boolean importada;
	private LinkedList<Pieza> Clasificados = new LinkedList<Pieza>();
	
	public Pieza(int numero_de_pieza, double precio, boolean importada) {
		super();
		this.numero_de_pieza = numero_de_pieza;
		this.precio = precio;
		this.importada = importada;
	}

	public int getNumero_de_pieza() {
		return numero_de_pieza;
	}

	public void setNumero_de_pieza(int numero_de_pieza) {
		this.numero_de_pieza = numero_de_pieza;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public boolean isImportada() {
		return importada;
	}

	public void setImportada(boolean importada) {
		this.importada = importada;
	}

	@Override
	public String toString() {
		return "Pieza [numero_de_pieza=" + numero_de_pieza + ", precio=" + precio + ", importada=" + importada + "]";
	}
	
	public boolean IniciarProceso(){
		int agregap=Integer.parseInt(JOptionPane.showInputDialog("ingrese "));
		{
			
			return true;
		}else {
			return false;
		}
	}
	public boolean PararProceso(Pieza pieza1){
		if(1==1)
		{
			return true;
		}else {
			return false;
		}
	}
	public boolean BorrarProceso(Pieza pieza1){
		if(1==1)
		{
			return true;
		}else {
			return false;
		}
	}
	}
	
	
}
