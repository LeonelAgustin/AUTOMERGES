package logica;

import javax.swing.JOptionPane;

public class Mecanico extends Persona{
	private int id_mecanico;
	private String turno;
	
	public Mecanico(String nombre, String apellido, String dni, String tipo_cuenta, String id, String contrasena,
			int id_mecanico, String turno) {
		super(nombre, apellido, dni, tipo_cuenta, id, contrasena);
		this.id_mecanico = id_mecanico;
		this.turno = turno;
	}

	public int getId_mecanico() {
		return id_mecanico;
	}



	public void setId_mecanico(int id_mecanico) {
		this.id_mecanico = id_mecanico;
	}



	public String getTurno() {
		return turno;
	}



	public void setTurno(String turno) {
		this.turno = turno;
	}



	public void loginMecanico() {
		
	}
	
	public Informe completarInforme(Informe informe) {
		 /*completar y devuelve el informe*/
		int res;
		int res2;
		String nombre = JOptionPane.showInputDialog("Revisando informe como el mecanico:"+informe.getEmpleado().getId_mecanico()+"\nComplete su nombre en el informe");
		informe.getEmpleado().setNombre(nombre);
		String apellido = JOptionPane.showInputDialog("Revisando informe como el mecanico:"+informe.getEmpleado().getId_mecanico()+"\nComplete su apellido en el informe");
		informe.getEmpleado().setNombre(apellido);
		
		switch (informe.getasunto()) {
		
		case "restauracion":
			do {
				
			int a = Integer.parseInt(JOptionPane.showInputDialog("Asunto:Restauracion\nIndique que materiales uso para restaurar el vehiculo:"+informe.getAuto().getModelo()+"\n1-Aleaciones de hierro\n2-Aleaciones de aluminio\n3-Aluminio de magnesio\n4-Plasticos\n5-Cristales\nOtro"));
			switch (a) {
			case 1:
				informe.setMateriales("Aleacion de hierro");
				break;
			case 2:
				informe.setMateriales("Aleacion de aluminio");
				break;
			case 3:
				informe.setMateriales("Aleacion de magnesio");
				break;
			case 4:
				informe.setMateriales("Plasticos");
				break;
			case 5:
				informe.setMateriales("cristales");
				break;
			default:
				String material = JOptionPane.showInputDialog("Describa el material para el informe");
				informe.setMateriales(material);
				break;
			}
			
			res = Integer.parseInt(JOptionPane.showInputDialog("¿El trabajo esta terminado o debe usar mas materiales?\n1-Trabajo terminado\n0-Usar mas materiales"));
			
			} while (res == 0);
			informe.setTerminado(true);
		case "reparacion":
			int a = Integer.parseInt(JOptionPane.showInputDialog("Asunto:Reparacion\nIndique si necesita una pieza particular para repara el vehiculo el vehiculo:"+informe.getAuto().getModelo()+"\n1-Necesito una pieza del deposito\n2-Tengo la pieza necesaria"));
			if (a==1) {
				this.generarOrden();
			} if (a==2) {
				do {
					informe.getPieza().getEstado();
					informe.getPieza().getImportada();
					informe.getPieza().getImportada();
					informe.getPieza().getNumero_de_sere();
					informe.getPieza().setPrecio(Double.parseDouble(JOptionPane.showInputDialog("Indique el precio de la pieza que utilizo")));
					
					res2 = Integer.parseInt(JOptionPane.showInputDialog("Indique si utilizo otra pieza  extra para el trabajo\n1-Utilice otra pieza\n2-Ya informe todas las piezas que utilice"));
				} while (res2==1);
				int horas = Integer.parseInt(JOptionPane.showInputDialog("Indique cuantas horas le llevo hacer la reparacion"));
				
			}
			this.generarOrden();
			break;
		}
		
		return informe;
	}
	
	public Orden generarOrden () {
		
		return null;
	}
		
	}

