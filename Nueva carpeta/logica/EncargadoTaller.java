package logica;

import javax.swing.JOptionPane;

public class EncargadoTaller extends Persona {
	private int id_Etaller;
	private String claveT;

	public EncargadoTaller(String nombre, String apellido, String dni, String tipo_cuenta, String id, String contrasena,
			int id_Etaller, String claveT) {
		super(nombre, apellido, dni, tipo_cuenta, id, contrasena);
		this.id_Etaller = id_Etaller;
		this.claveT = claveT;
	}

	public int getId_Etaller() {
		return id_Etaller;
	}

	public void setId_Etaller(int id_Etaller) {
		this.id_Etaller = id_Etaller;
	}

	public String getClaveT() {
		return claveT;
	}

	public void setClaveT(String claveT) {
		this.claveT = claveT;
	}

	@Override
	public String toString() {
		return "EncargadoTaller [id_Etaller=" + id_Etaller + ", claveT=" + claveT + "]";
	}

	public Informe1 completarInforme(Informe1 informe1) {

		switch (informe1.getasunto()) {
		case "restauracion":

			String info = "Revisando informe como Encargado del taller\nCodigo:"+informe1.getCod_informe()+"\nAsunto:restauracion\nVehiculo:"
					+ informe1.getAuto().getModelo() + "\nDueño:" + informe1.getCliente().getNombre() + "\nTerminado:"
					+ informe1.isTerminado() + "\nHoras de trabajo:0" + "\nMateriales:Sin especificar" + "Mecanico:Sin asignar\n";

			String nombre = JOptionPane
					.showInputDialog(info + "Ingrese el mecanico a quien quiere asignarle el trabajo");

			informe1.getEmpleado().setNombre(nombre);

			JOptionPane.showMessageDialog(null, "asignado trabajo de restauracion al mecanico:" + nombre);

			break;

		case "reparacion":

			String info1 = "Revisando informe como Encargado del taller\nCodigo:"+informe1.getCod_informe()+"\nAsunto:reparacion\nVehiculo:"
					+ informe1.getAuto().getModelo() + "\nDueño:" + informe1.getCliente().getNombre() + "\nTerminado:"
					+ informe1.isTerminado() + "\nHoras de trabajo:0" +"\nPieza:Sin especificar"+ "\n" + "Mecanico:Sin asignar\n";

			int identificador1 = Integer.parseInt(JOptionPane.showInputDialog(info1 + "Ingrese el id del mecanico a quien quiere asignarle el trabajo")); 
					

			informe1.getEmpleado().setId_mecanico(identificador1);

			JOptionPane.showMessageDialog(null, "asignado trabajo de reparacion al mecanico :" + identificador1 );

			break;
		}
		//devuelve el informe completado
		return informe1;
	}
}
