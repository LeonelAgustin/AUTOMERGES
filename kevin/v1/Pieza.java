package automerges;

import java.util.LinkedList;

import javax.swing.*;

public class Pieza {
	private int numero_de_pieza;
	private String nombre;
	private double precio;
	private String importada;
	private LinkedList<Pieza> Piezas = new LinkedList<Pieza>();
	
	
	public Pieza(int numero_de_pieza, String nombre, double precio, String importada) {
		super();
		this.numero_de_pieza = numero_de_pieza;
		this.nombre = nombre;
		this.precio = precio;
		this.importada = importada;
	}
	
	public int getNumero_de_pieza() {
		return numero_de_pieza;
	}

	public void setNumero_de_pieza(int numero_de_pieza) {
		this.numero_de_pieza = numero_de_pieza;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getImportada() {
		return importada;
	}

	public void setImportada(String importada) {
		this.importada = importada;
	}
	public Pieza() {
		this.Piezas = new LinkedList<Pieza>();    
	}
	
	public LinkedList<Pieza> getPiezas() {
		return Piezas;
	}
	
	@Override
	public String toString() {
		return "Numero de Pieza: "+numero_de_pieza+"\nNombre: "+nombre+"\nPrecio:"+precio+"\nImportado: "+importada +"\n ";
	}
	private LinkedList<Pieza> PiezasPausadas = new LinkedList<Pieza>();
	public String IniciarProceso(){
		int sel;
		int num=+1;
		do {
		double precio=Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio"));
		String nom = JOptionPane.showInputDialog("Ingrese el nombre de la pieza");
		String imp="no";
		
		 Pieza pieza1 = new Pieza (num++,nom,precio,imp);
		 Piezas.add(pieza1);
		
		sel = Integer.parseInt(JOptionPane.showInputDialog("Ingrese \n1Si quiere agregar otra pieza \n2 Voler al menu"));
		} while (sel==1);
		return "";
	}
	public boolean PararProceso(){
		JOptionPane.showMessageDialog(null, Piezas);
		int piez=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de pieza, del cual desea parar el proceso"));
	
		if (Piezas.isEmpty()) {
			JOptionPane.showMessageDialog(null,"La lista esta vacia");
			return false;
		}else {
			 for (Pieza elemento : Piezas)
			        if(elemento.getNumero_de_pieza()==piez) {
			        	JOptionPane.showMessageDialog(null,"Paro el proceso de la pieza: "+elemento.getNumero_de_pieza() );
			        	//System.out.println("Paro el proceso de la pieza: "+elemento.getNumero_de_pieza()); 
			        	PiezasPausadas.add(Piezas.get(piez));
			    		Piezas.remove(piez);
			    		
		}
		}
		
			return true;
	}
	public boolean ReanudarProceso(){
		JOptionPane.showMessageDialog(null, PiezasPausadas);
		int pie=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de pieza, del cual desea reanudar el proceso"));
		if (PiezasPausadas.isEmpty()) {
			JOptionPane.showMessageDialog(null,"La lista esta vacia");
			return false;
		}else {
			 for (Pieza elemento : PiezasPausadas)
			        if(elemento.getNumero_de_pieza()==pie) {
			        	JOptionPane.showMessageDialog(null, "Reanudo la pieza: "+elemento.getNumero_de_pieza());
			        	//System.out.println("Reanudo la pieza: "+elemento.getNumero_de_pieza()); 
			        	Piezas.add(PiezasPausadas.get(pie));
			        	PiezasPausadas.remove(pie);
		}
		}
			return true;
	}      	
        
	public boolean BorrarProceso(){
		JOptionPane.showMessageDialog(null, Piezas);
		int piee=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de pieza para borrar el proceso"));
		//piee=piee+1;
		if (Piezas.isEmpty()) {
			JOptionPane.showMessageDialog(null,"La lista esta vacia");
			return false;
		}else if(piee==getNumero_de_pieza()){
		 for (Pieza elemento : Piezas)
			        if(elemento.getNumero_de_pieza()==piee) {
			        	JOptionPane.showMessageDialog(null, "removio el elemento: "+elemento.getNumero_de_pieza());
			        	//System.out.println("removio el elemento: "+elemento.getNumero_de_pieza()); 
			        	Piezas.remove(piee);
		}
		}
		return true;
		//JOptionPane.showMessageDialog(null, "Elimino el proceso "+getNumero_de_pieza());
	
	}
	public String Lista() {
		if (Piezas.isEmpty()) {
			JOptionPane.showMessageDialog(null,"La lista esta vacia");
		}else {
		JOptionPane.showMessageDialog(null, Piezas);
		}
		return "";
		
	}

	}
