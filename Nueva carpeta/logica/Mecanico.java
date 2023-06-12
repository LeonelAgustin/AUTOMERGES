package Logica;

import java.sql.Connection;

import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import conexion.Conexion;

public class Mecanico extends Persona{
	
	public Mecanico(String nombre, String apellido,
			String dni, String id, String contrasena, String tipo_cuenta) {
		super(nombre, apellido, dni, id, contrasena);
		
	}

	
	public Vehiculo restaurarVehiculo () {
		return null;
	}
	
	public void loginMecanico() {
		String usuario = JOptionPane.showInputDialog("Ingrese su usuario como mecanico");
		int contra = Integer.parseInt(JOptionPane.showInputDialog("ingrese su contrasenia de mecanico"));
		JOptionPane.showMessageDialog(null, "Bienvenido mecanico:"+usuario);
		
	}
	
	public void completarInforme() {
		 /*completar y devuelve el informe*/
		Informe informe = null;
		double precio1 = 0;
		double total;
		int res,res2, estado=0;
		int horas = 0;
		String material = "";
		
		switch (informe.getasunto()) {
		
		case "restauracion":
			
			for (int i = 0; i < 2; i++) {
				
			int a = Integer.parseInt(JOptionPane.showInputDialog("Asunto:Restauracion\nIndique que materiales uso para restaurar el vehiculo:"+informe.getVehiculo().getModelo()+"\n1-Aleaciones de hierro\n2-Aleaciones de aluminio\n3-Aluminio de magnesio\n4-Plasticos\n5-Cristales\nOtro"));
			switch (a) {
			case 1:
				material = JOptionPane.showInputDialog("Aleacion de hierro");
				break;
			case 2:
				material = JOptionPane.showInputDialog("Aleacion de aluminio");
				
				break;
			case 3:
				material = JOptionPane.showInputDialog("Aleacion de magnesio");
				
				break;
			case 4:
				material = JOptionPane.showInputDialog("Plasticos");
				
				break;
			case 5:
				material = JOptionPane.showInputDialog("cristales");
				
				break;
			default:
				material = JOptionPane.showInputDialog("Describa el material para el informe");
				
				break;
			}
			
			res = Integer.parseInt(JOptionPane.showInputDialog("¿El trabajo esta terminado o debe usar mas materiales?\n1-Trabajo terminado\n0-Usar mas materiales"));
			if (res==1) {
				estado = 1;
				i++;
			} 
			} 
			
			
		case "reparacion":
			
			int a = Integer.parseInt(JOptionPane.showInputDialog("Asunto:Reparacion\nIndique si necesita una pieza particular para reparar  el vehiculo:"+informe.getVehiculo().getModelo()+"\n1-Necesito una pieza de fabrica\n2-Tengo lo necesario para hacer el trabajo"));
			if (a==1) {
				this.generarOrden();
			} if (a==2) {
				
					JOptionPane.showMessageDialog(null, "Indique los datos de la pieza para completar el informe");
					
					informe.getPieza().setNumero_de_sere(Integer.parseInt(JOptionPane.showInputDialog("Indique el numero de serie de la pieza")));
					informe.getPieza().setNombre(JOptionPane.showInputDialog("Indique el nombre de la pieza"));
					informe.getPieza().setPrecio(Double.parseDouble(JOptionPane.showInputDialog("Indique el precio de la pieza")));

				
				horas = Integer.parseInt(JOptionPane.showInputDialog("Indique cuantas horas le llevo hacer la reparacion"));
				precio1 = informe.getPieza().getPrecio();
			}
			
			total = (precio1/2)*horas;
			JOptionPane.showMessageDialog(null, "Informe completado \nCodigo de informe:"+informe.getCodinforme()+"\nAsunto:"+informe.getasunto()+"\nAuto:"+informe.getVehiculo().getModelo()+"\nPieza Nº:"+informe.getPieza().getNumero_de_sere()+"\nMateriales:"+material+"\nCliente:"+informe.getCliente().getNombre()+"\nPrecio a cobrar:"+total+"\nMecanico:"+this.getNombre()+" "+this.getApellido()+"Horas de trabajo:"+horas);
			break;
		}
		
		
	}
	
	public Orden generarOrden () {
		String aux = "";
		int a=0;
		Orden nueva = new Orden (0,"","",false);
		do {
		JOptionPane.showMessageDialog(null, "Complete los datos requeridos para generar una Orden de solicitud de Pieza");
				
		nueva = new Orden (00+(int)(Math.random()*10+1),this.getNombre(),JOptionPane.showInputDialog("Ingrese el nombre de pieza que necesita"),true);
		a = Integer.parseInt(JOptionPane.showInputDialog("la pieza solicitada debe ser importada\n1-Si\n2-No"));
		
		if (a==1) {
			nueva.setImportada(true);
		} else {
			nueva.setImportada(false);
		}
		
		JOptionPane.showMessageDialog(null, "Orden Nº "+nueva.getCodOrden()+" generada, porfavor revise los datos para enviarla a deposito\nNombre la pieza:"+nueva.getNombrePieza()+"\nImportada:"+aux+"Solicitante:"+nueva.getSolicitante());
		
		aux = JOptionPane.showInputDialog("Orden Nº "+nueva.getCodOrden()+" generada, porfavor revise los datos para enviarla a deposito\nNombre la pieza:"+nueva.getNombrePieza()+"\nImportada:"+aux+"Solicitante:"+nueva.getSolicitante()+"\n¿Desea enviar la orden?");
			
		} while (aux.equalsIgnoreCase("no"));
		
		
		if (nueva.generarOrden()) {
			JOptionPane.showMessageDialog(null, "La orden fue generada y enviada exitosamente a deposito");
		} else {
			JOptionPane.showMessageDialog(null, "La orden fue generada pero no se puedo enviar al deposito, reintente nuevamente");
		}
		
		return nueva;
	}

}
