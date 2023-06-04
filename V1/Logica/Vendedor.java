package Logica;

import javax.swing.JCheckBox; 

import javax.swing.JOptionPane;

public class Vendedor extends Persona {

	private String tipo_cuenta;

	public Vendedor(String nombre, String apellido, String dni , String id, String contrasena) {
		super(nombre, apellido, dni , id, contrasena);
		this.tipo_cuenta="Vendedor";
	}
	
	public String getTipo_cuenta() {
		return tipo_cuenta;
	}
	//solo puede modificar administrador el tipo de cuenta
	public void setTipo_cuenta(String tipo_cuenta) {
		this.tipo_cuenta = tipo_cuenta;
	}

    public boolean vendedor(Vehiculo vehiculo ,Pieza pieza,Cliente cliente) {
		final String tipo_de_empleado[]={"Comprar auto","Vender auto","Comprar pieza","Vender pieza","Reparar auto","ver Stock","Salir"};
    	JCheckBox chec=new JCheckBox("Prueba");
		//filtra cliente de empleado
		int seleccion = JOptionPane.showOptionDialog( chec,"Seleccione una opcion",
				  "Selector de opciones",JOptionPane.YES_NO_CANCEL_OPTION,
				   JOptionPane.QUESTION_MESSAGE,null,// null para icono por defecto.
				   tipo_de_empleado,tipo_de_empleado[0]);
		Informe informe = new Informe(cliente, vehiculo, 0, true);
		Informe informef = new Informe(cliente, pieza, 0, true);
		switch (seleccion) {
		case 0:
			JOptionPane.showMessageDialog(null, "comprar auto\n" + vehiculo);
			informe.setIsfactura(false);
			informe.setCliente(cliente);
			informe.setasunto("compra");
			informe.setVehiculo(vehiculo);
			JOptionPane.showMessageDialog(null, informe.toString());
			break;
		case 1:
			JOptionPane.showMessageDialog(null, "Vender auto\n"+vehiculo);
			informe.setIsfactura(true);
			informe.setCliente(cliente);
			informe.setasunto("venta");
			informe.setVehiculo(vehiculo);
			JOptionPane.showMessageDialog(null, informe.toString());
			break;
		case 2:
			JOptionPane.showMessageDialog(null, "Comprar pieza\n"+pieza);
			informef.setIsfactura(false);
			informef.setCliente(cliente);
			informef.setasunto("venta");
			informef.setPieza(pieza);
			JOptionPane.showMessageDialog(null, informef.toString());
			break;		case 3:
			JOptionPane.showMessageDialog(null, "Vender pieza\n"+pieza);
			informef.setIsfactura(true);
			informef.setCliente(cliente);
			informef.setasunto("venta");
			informef.setPieza(pieza);
			JOptionPane.showMessageDialog(null, informef.toString());
			break;		case 4:
			JOptionPane.showMessageDialog(null, "Reparar auto\n"+vehiculo);
			informe.setIsfactura(false);
			informe.setCliente(cliente);
			informe.setasunto("venta");
			informe.setVehiculo(vehiculo);
			JOptionPane.showMessageDialog(null, informe.toString());
			break;
		case 5:
			
			
			
			break;
		default:
		    return true;
		}
		return false;
	}
   
    
    public Informe informe(Informe informe,Informe informef,int seleccion) {
		
		if (seleccion==2||seleccion==3) {
			return informef;
		}
		return informe;
	}

    
    public void buscar_auto() {
		
	}
    
    public void registrar_auto() {
    	
    }
    
    public void buscar_pieza() {
    	
    }
    
    public void vender_auto() {
    	
    }
    
    public void registrar_venta() {
    	
    }
    
    public void registrar_cliente() {
    	
    }
    
    public void comprar_pieza() {
    	
    }
    
    public void revisar_deposito() {
    	
    }
}
