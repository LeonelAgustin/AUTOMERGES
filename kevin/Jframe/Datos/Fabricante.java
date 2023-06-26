package Datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.LinkedList;
import javax.swing.JOptionPane;

import Interfaz.VBorrarProceso;


public class Fabricante extends Persona{
	private int id_frabicante;
	private String claveF;
	
	Conexion con = new Conexion();
	
	Connection conexion = con.conectar();
	
	PreparedStatement stmt;
	private Pieza PiezasNuevas;
	
	public Fabricante(int dni, String nombre, String apellido, String direccion, int telefono, int id_frabicante,
			String claveF) {
		super(dni, nombre, apellido, direccion, telefono);
		this.id_frabicante = id_frabicante;
		this.claveF = claveF;
	}

	public int getId_frabicante() {
		return id_frabicante;
	}

	public void setId_frabicante(int id_frabicante) {
		this.id_frabicante = id_frabicante;
	}

	public String getClaveF() {
		return claveF;
	}

	public void setClaveF(String claveF) {
		this.claveF = claveF;
	}

	@Override
	public String toString() {
		return "Fabricante [id_frabicante=" + id_frabicante + ", claveF=" + claveF + "]";
	}
	public  boolean Fabricante() {
		Pieza pieza1= new Pieza("","");
		Pieza p=new Pieza("","");
		String [] opciones={"Iniciar Proceso","Parar Proceso","Reanudar Proceso","Borrar Proceso","Ver Procesos","Salir"};
		String opcion="";
		do {
		       opcion = (String)JOptionPane.showInputDialog(null, "Opciones del Fabricante","",JOptionPane.DEFAULT_OPTION,null, opciones,opciones[0]);
		switch (opcion) {
		case "Iniciar Proceso":
			RegistrarPieza();
			break;
		case "Parar Proceso":
		    if (pieza1.MostrarSinSus().isEmpty() || pieza1.MostrarSinSus() == null) {
		        JOptionPane.showMessageDialog(null, "Lista vac�a");
		    } else {
		    	JOptionPane.showMessageDialog(null, pieza1.MostrarSinSus());
		        String[] opcioncitas = new String[pieza1.MostrarSinSus().size()];
		        for (int i = 0; i < pieza1.MostrarSinSus().size(); i++) {
		            opcioncitas[i] = Integer.toString(pieza1.MostrarSinSus().get(i).getId());
		            //opcioncitas[i] = Integer.toString(pieza1.Mostrar().get(i).getId())+pieza1.Mostrar().get(i).getNombre();
		            //opcioncitas[i] = pieza1.Mostrar().get(i).getNombre()+Integer.toString(pieza1.Mostrar().get(i).getId());
		        }
		        int id = Integer.parseInt((String) JOptionPane.showInputDialog(null, "Elija el id: ", "", JOptionPane.DEFAULT_OPTION, null, opcioncitas, opcioncitas[0]));
		        System.out.println(id);
		        for (Pieza piezaNueva : pieza1.MostrarSinSus()) {
		            if (piezaNueva.getId() == id) {
		                //JOptionPane.showMessageDialog(null, pieza1.Mostrar());
		                String sql = "UPDATE `pieza` SET `Estado_proceso` = 'suspendido' WHERE `Numero_de_pieza` = ?";
		                try {
		                    PreparedStatement stmt = conexion.prepareStatement(sql);
		                    stmt.setInt(1, piezaNueva.getId());
		                    stmt.executeUpdate();		        
		               
		                } catch (Exception excepcion) {
		                    System.out.println(excepcion.getMessage());
		                }
		            }
		        }
		    }
		    
		case "Reanudar Proceso":
			   if (pieza1.MostrarConSus().isEmpty() || pieza1.MostrarConSus() == null) {
			        JOptionPane.showMessageDialog(null, "Lista vac�a");
			    } else {
			    	JOptionPane.showMessageDialog(null, pieza1.MostrarConSus());
			        String[] opcioncitas1 = new String[pieza1.MostrarConSus().size()];
			        for (int i = 0; i < pieza1.MostrarSinSus().size(); i++) {
			            opcioncitas1[i] = Integer.toString(pieza1.MostrarConSus().get(i).getId());
			        }
			        int id = Integer.parseInt((String) JOptionPane.showInputDialog(null, "Elija el id: ", "", JOptionPane.DEFAULT_OPTION, null, opcioncitas1, opcioncitas1[0]));
			        System.out.println(id);
			        for (Pieza piezaNueva : pieza1.MostrarConSus()) {
			            if (piezaNueva.getId() == id) {
			                //JOptionPane.showMessageDialog(null, pieza1.Mostrar());
			                String sql = "UPDATE `pieza` SET `Estado_proceso` = 'en proceso' WHERE `Numero_de_pieza` = ?";
			                try {
			                    PreparedStatement stmt = conexion.prepareStatement(sql);
			                    stmt.setInt(1, piezaNueva.getId());
			                    stmt.executeUpdate();			            
			               
			                } catch (Exception excepcion) {
			                    System.out.println(excepcion.getMessage());
			                }
			            }
			        }
			    }
			
			//p.ReanudarProceso();
			break;
			case "Borrar Proceso":
			    if (pieza1.Mostrar().isEmpty() || pieza1.Mostrar() == null) {
			        JOptionPane.showMessageDialog(null, "Lista vac�a");
			    } else {
			        JOptionPane.showMessageDialog(null, pieza1.Mostrar());
			        String[] opcioncitas2 = new String[pieza1.Mostrar().size()];
			        for (int i = 0; i < pieza1.Mostrar().size(); i++) {
			            opcioncitas2[i] = Integer.toString(pieza1.Mostrar().get(i).getId());
			        }
			        int id = Integer.parseInt((String) JOptionPane.showInputDialog(null, "Elija el id: ","", JOptionPane.DEFAULT_OPTION, null, opcioncitas2, opcioncitas2[0]));
			        System.out.println(id);
			        
			        String sql = "DELETE FROM `pieza` WHERE `Numero_de_pieza` = ?";
			        try {
			            PreparedStatement stmt = conexion.prepareStatement(sql);
			            stmt.setInt(1, id);
			            stmt.executeUpdate();
			        } catch (Exception excepcion) {
			            System.out.println(excepcion.getMessage());
			        }
			    }
			break;
		case "Ver Procesos":
			if(pieza1.Mostrar().isEmpty() || pieza1.Mostrar()==null ) {
				JOptionPane.showMessageDialog(null, "Lista vacia");
			}else {
				JOptionPane.showMessageDialog(null, pieza1.Mostrar());
			}
			break;
		case "Salir":
			break;
		default:
			break;
		}
	} while(!opcion.equals("Salir" ));
		return true;
	}
	
	public void RegistrarPieza() {
		Verifica verifica = new Verifica();
		String nombre = JOptionPane.showInputDialog("Ingrese el nombre de la pieza");
		String precio = JOptionPane.showInputDialog("Ingrese el precio de la pieza");
		String id="0";
	
		if (verifica.verificarAnadirP(nombre,precio)) {
			Pieza PiezasNuevas = new Pieza(1,nombre,precio);
			this.PiezasNuevas=PiezasNuevas;
			System.err.println(this.PiezasNuevas.toString());
			RegistrarPiezaCon();			
		}
		
		
	}
	public void RegistrarPiezaCon() {
		System.err.println("recived");
		//String sql ="INSERT INTO `pieza`(`Numero_de_pieza`, `nombre_Pieza`, `Pieza_precio`) VALUES (?,?,?)";
		String sql ="INSERT INTO `pieza`(`nombre_Pieza`, `Pieza_precio`) VALUES (?,?)";
		
		try {
			stmt = conexion.prepareStatement(sql);
			stmt.setString(1,this.PiezasNuevas.getNombre());
			stmt.setFloat(2,Float.parseFloat(this.PiezasNuevas.getPrecio()));
			stmt.executeUpdate();
			//return true;
			
		}catch(Exception excepcion){
			System.out.println(excepcion.getMessage());
			//return false;
		}
		
	}
	public void PararProceso() {
		Pieza pieza1= new Pieza("","");
		if (pieza1.MostrarSinSus().isEmpty() || pieza1.MostrarSinSus() == null) {
	        JOptionPane.showMessageDialog(null, "Lista vac�a");
	    } else {
	    	JOptionPane.showMessageDialog(null, pieza1.MostrarSinSus());
	        String[] opcioncitas = new String[pieza1.MostrarSinSus().size()];
	        for (int i = 0; i < pieza1.MostrarSinSus().size(); i++) {
	            opcioncitas[i] = Integer.toString(pieza1.MostrarSinSus().get(i).getId());
	        }
	            //opcioncitas[i] = Integer.toString(pieza1.Mostrar().get(i).getId())+pieza1.Mostrar().get(i).getNombre();
	            //opcioncitas[i] = pieza1.Mostrar().get(i).getNombre()+Integer.toString(pieza1.Mostrar().get(i).getId());
	        int id = Integer.parseInt((String) JOptionPane.showInputDialog(null, "Elija el id: ", "", JOptionPane.DEFAULT_OPTION, null, opcioncitas, opcioncitas[0]));
	        System.out.println(id);
	        for (Pieza piezaNueva : pieza1.MostrarSinSus()) {
	            if (piezaNueva.getId() == id) {
	                //JOptionPane.showMessageDialog(null, pieza1.Mostrar());
	                String sql = "UPDATE `pieza` SET `Estado_proceso` = 'suspendido' WHERE `Numero_de_pieza` = ?";
	                try {
	                    PreparedStatement stmt = conexion.prepareStatement(sql);
	                    stmt.setInt(1, piezaNueva.getId());
	                    stmt.executeUpdate();
	               
	                } catch (Exception excepcion) {
	                    System.out.println(excepcion.getMessage());
	                }
	            }
	        }
	    }
	}
	public void ppp(int idSeleccionado) {
		 String sql = "UPDATE `pieza` SET `Estado_proceso` = 'suspendido' WHERE `Numero_de_pieza` = ?";
         try {
             PreparedStatement stmt = conexion.prepareStatement(sql);
             stmt.setInt(1, idSeleccionado);
             stmt.executeUpdate();
        
         } catch (Exception excepcion) {
             System.out.println(excepcion.getMessage());
         }
	}
	public void PBorrar(int idSeleccionado) {
		//int id=0;
		String sql = "DELETE FROM `pieza` WHERE `Numero_de_pieza` = ?";
        try {
            PreparedStatement stmt = conexion.prepareStatement(sql);
            stmt.setInt(1, idSeleccionado);
            stmt.executeUpdate();
        } catch (Exception excepcion) {
            System.out.println(excepcion.getMessage());
        }
        VBorrarProceso ventanaBorrarProceso = new VBorrarProceso();
		ventanaBorrarProceso.repaint();
	}
	/*public void PararProceso() {
		Pieza pieza1= new Pieza("","");
		if(pieza1.Mostrar().isEmpty() || pieza1.Mostrar()==null ) {
			JOptionPane.showMessageDialog(null, "Lista vacia");
		}else{
		String[] opcioncitas= new String[pieza1.Mostrar().size()];
		for (int i = 0; i < pieza1.Mostrar().size(); i++) {
			opcioncitas[i] = Integer.toString(pieza1.Mostrar().get(i).getId()) ; 
		}
		int id =  Integer.parseInt((String)JOptionPane.showInputDialog(null, "Ingrese el id: ", "", JOptionPane.DEFAULT_OPTION,null,opcioncitas,opcioncitas[0]));
		System.out.println(id);
		for (Pieza PiezasNuevas: pieza1.Mostrar()) {
			if(PiezasNuevas.getId()==id) {
				JOptionPane.showMessageDialog(null, PiezasNuevas);
			}
		}
		
	}
		//int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id: "));
		/*if (PiezasNuevas) {
			JOptionPane.showMessageDialog(null, "Se elimino con exito la pieza con id" + id);
		}else {
			JOptionPane.showMessageDialog(null, "No se encontro el id, o no se pudo borrar");
		}*/
	
	
	public void PararProcesoCon() {
		String sql = "UPDATE `pieza` SET `Estado_proceso`= 3 , WHERE 'pieza'.'Numero_de_pieza' = ?";
		try {
			stmt = conexion.prepareStatement(sql);
			stmt.setInt(1, this.PiezasNuevas.getId());
			stmt.executeUpdate();	
			
		}catch(Exception excepcion){
			System.out.println(excepcion.getMessage());
		}
	}
	public void BorrarProceso() {
		Pieza pieza1= new Pieza("","");
		 if (pieza1.Mostrar().isEmpty() || pieza1.Mostrar() == null) {
		        JOptionPane.showMessageDialog(null, "Lista vac�a");
		    } else {
		        JOptionPane.showMessageDialog(null, pieza1.Mostrar());
		        String[] opcioncitas2 = new String[pieza1.Mostrar().size()];
		        for (int i = 0; i < pieza1.Mostrar().size(); i++) {
		            opcioncitas2[i] = Integer.toString(pieza1.Mostrar().get(i).getId());
		        }
		        int id = Integer.parseInt((String) JOptionPane.showInputDialog(null, "Elija el id: ","", JOptionPane.DEFAULT_OPTION, null, opcioncitas2, opcioncitas2[0]));
		        System.out.println(id);
		        
		        String sql = "DELETE FROM `pieza` WHERE `Numero_de_pieza` = ?";
		        try {
		            PreparedStatement stmt = conexion.prepareStatement(sql);
		            stmt.setInt(1, id);
		            stmt.executeUpdate();
		        } catch (Exception excepcion) {
		            System.out.println(excepcion.getMessage());
		        }
		    }
	}
	public void ReanudarProceso() {
		Pieza pieza1= new Pieza("","");
		if (pieza1.Mostrar().isEmpty() || pieza1.Mostrar() == null) {
	        JOptionPane.showMessageDialog(null, "Lista vac�a");
	    } else {
	        JOptionPane.showMessageDialog(null, pieza1.Mostrar());
	        String[] opcioncitas2 = new String[pieza1.Mostrar().size()];
	        for (int i = 0; i < pieza1.Mostrar().size(); i++) {
	            opcioncitas2[i] = Integer.toString(pieza1.Mostrar().get(i).getId());
	        }
	        int id = Integer.parseInt((String) JOptionPane.showInputDialog(null, "Elija el id: ","", JOptionPane.DEFAULT_OPTION, null, opcioncitas2, opcioncitas2[0]));
	        System.out.println(id);
	        
	        String sql = "DELETE FROM `pieza` WHERE `Numero_de_pieza` = ?";
	        try {
	            PreparedStatement stmt = conexion.prepareStatement(sql);
	            stmt.setInt(1, id);
	            stmt.executeUpdate();
	        } catch (Exception excepcion) {
	            System.out.println(excepcion.getMessage());
	        }
	    }
	}

}

