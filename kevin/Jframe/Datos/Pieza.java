package Datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.LinkedList;
//import com.mysql.jdbc.Connection;

import javax.swing.JOptionPane;



public class Pieza {
	//private int numero_de_pieza;
	private String nombre;
	private String precio;
	//private String importada;
	
	private LinkedList<Pieza> Piezas = new LinkedList<Pieza>();
	
    Conexion con = new Conexion();
	
	Connection conexion = con.conectar();
	
	PreparedStatement stmt;
	
	public Pieza(String nombre, String precio) {
		super();
		//this.numero_de_pieza = numero_de_pieza;
		this.nombre = nombre;
		this.precio = precio;			
    }
	
	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Pieza(int id,String nombre,String precio) {
		this.id = id;
		this.nombre= nombre;
		this.precio= precio;
		
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/*public Pieza() {
		this.Piezas = new LinkedList<Pieza>();    
	}*/
	
	public String getPrecio() {
		return precio;
	}
	public void setPrecio(String precio) {
		this.precio = precio;
	}
	public LinkedList<Pieza> getPiezas() {
		return Piezas;
	}

	@Override
	public String toString() {
		return "\n Pieza #: "+id+" Nombre: "+nombre+" Precio:"+precio;
	}
	private LinkedList<Pieza> PiezasPausadas = new LinkedList<Pieza>();
	
	/*public boolean guardarPieza() {
		
		String sql ="INSERT INTO `pieza`(`Numero_de_pieza`, `nombre_Pieza`, `Pieza_precio`,`Estado_proceso`='en proceso') VALUES (?,?,?,?)";
		
		try {
			stmt = conexion.prepareStatement(sql);
			//stmt.setString(1,String.valueOf(this.getNumero_de_pieza()));
			stmt.setString(2,this.getNombre());
			//stmt.setFloat(3,(float) this.getPrecio());
			stmt.executeUpdate();
			return true;
			
		}catch(Exception excepcion){
			System.out.println(excepcion.getMessage());
			return false;
		}
	}*/
	public LinkedList<Pieza> Mostrar() {
		LinkedList<Pieza> PiezasNuevas = new LinkedList<Pieza>();
			String sql ="SELECT * FROM `pieza`";
			
			String[] datos= new String[3]; 
			int id;
			try {
				stmt = conexion.prepareStatement(sql);
				ResultSet result = stmt.executeQuery();
				
				while(result.next()) {
					datos[0]= result.getString(1);
					datos[1]= result.getString(2);
					datos[2]= result.getString(3);
					PiezasNuevas.add(new Pieza(Integer.parseInt(datos[0]),datos[1],datos[2]));
				}
				return PiezasNuevas;
				
			} catch (Exception e) {
				System.out.println("Hubo un error"+e.getMessage());
				return null;
			}
		}
	public LinkedList<Pieza> MostrarSinSus() {
		LinkedList<Pieza> PiezasNuevas1 = new LinkedList<Pieza>();
			String sql ="SELECT * FROM `pieza` WHERE `Estado_proceso` != 'suspendido'||`Estado_proceso` IS NULL;";
			
			String[] datos= new String[3]; 
			int id;
			try {
				stmt = conexion.prepareStatement(sql);
				ResultSet result = stmt.executeQuery();
				
				while(result.next()) {
					datos[0]= result.getString(1);
					datos[1]= result.getString(2);
					datos[2]= result.getString(3);
					PiezasNuevas1.add(new Pieza(Integer.parseInt(datos[0]),datos[1],datos[2]));
					//PiezasNuevas.add(new Pieza(datos[0],datos[1]));
					//Piezas.add(new Pieza(Integer.parseInt(datos[0]),datos[1],Float.parseFloat(datos[2])));
				}
				return PiezasNuevas1;
				
			} catch (Exception e) {
				System.out.println("Hubo un error"+e.getMessage());
				return null;
			}
		}
	public LinkedList<Pieza> MostrarConSus() {
		LinkedList<Pieza> PiezasConSus = new LinkedList<Pieza>();
			String sql ="SELECT * FROM `pieza` WHERE `Estado_proceso` = 'suspendido'";
			
			String[] datos= new String[3]; 
			int id;
			try {
				stmt = conexion.prepareStatement(sql);
				ResultSet result = stmt.executeQuery();
				
				while(result.next()) {
					datos[0]= result.getString(1);
					datos[1]= result.getString(2);
					datos[2]= result.getString(3);
					PiezasConSus.add(new Pieza(Integer.parseInt(datos[0]),datos[1],datos[2]));
					//PiezasNuevas.add(new Pieza(datos[0],datos[1]));
					//Piezas.add(new Pieza(Integer.parseInt(datos[0]),datos[1],Float.parseFloat(datos[2])));
				}
				return PiezasConSus;
				
			} catch (Exception e) {
				System.out.println("Hubo un error"+e.getMessage());
				return null;
			}
		}
	public String IniciarProceso(){
		int sel;
		int num=+1;
		do {
		Float precio=Float.parseFloat(JOptionPane.showInputDialog("Ingrese el precio"));
		String nom = JOptionPane.showInputDialog("Ingrese el nombre de la pieza");
		
		// Pieza pieza1 = new Pieza (num++,nom,precio);
		// Piezas.add(pieza1);
		
		sel = Integer.parseInt(JOptionPane.showInputDialog("Ingrese \n1Si quiere agregar otra pieza \n2 Voler al menu"));
		} while (sel==1);
		return "";
	}
	/*public boolean PararProceso() {
	    if (Piezas.isEmpty()) {
	        JOptionPane.showMessageDialog(null, "La lista esta vacia");
	        return false;
	    } else {
	    	JOptionPane.showMessageDialog(null, Piezas);
	        int piez = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de pieza del cual desea parar el proceso"));
	        Pieza piezaEncontrada = null;
	        
	        for (Pieza elemento : Piezas) {
	            if (elemento.getNumero_de_pieza() == piez) {
	                piezaEncontrada = elemento;
	                break;
	            }
	        }
	        
	        if (piezaEncontrada != null) {
	            JOptionPane.showMessageDialog(null, "Paro el proceso de la pieza: " + piezaEncontrada.getNumero_de_pieza());
	            PiezasPausadas.add(piezaEncontrada);
	            Piezas.remove(piezaEncontrada);
	        } else {
	            JOptionPane.showMessageDialog(null, "No se encontr� la pieza con el n�mero especificado");
	        }
	    }
	    
	    return true;
	}*/
	public boolean ReanudarProceso() {
	    /*JOptionPane.showMessageDialog(null, PiezasPausadas);
	    int pie = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el n�mero de pieza que desea reanudar"));
	    
	    if (PiezasPausadas.isEmpty()) {
	        JOptionPane.showMessageDialog(null, "La lista est� vac�a");
	        return false;
	    } else {
	        boolean piezaEncontrada = false;
	        
	        for (Pieza elemento : PiezasPausadas) {
	            if (elemento.getNumero_de_pieza() == pie) {
	                piezaEncontrada = true;
	                JOptionPane.showMessageDialog(null, "Reanudando la pieza: " + elemento.getNumero_de_pieza()); 
	                Piezas.add(elemento);
	                PiezasPausadas.remove(elemento);
	                break;
	            }
	        }
	        
	        if (!piezaEncontrada) {
	        	JOptionPane.showMessageDialog(null, "No se encontr� la pieza con el n�mero especificado");
	            return false;
	        }
	    }
	    */
	    return true;
	}
        
	public boolean BorrarProceso(){
		/*int piee =0;
		boolean encontrado=false;
		if (Piezas.isEmpty()) {
			JOptionPane.showMessageDialog(null,"La lista esta vacia");
			return false;
		}else {
			JOptionPane.showMessageDialog(null, Piezas);
			piee=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de pieza para borrar el proceso"));
			 for (Pieza elemento : Piezas)
			 {        if(elemento.getNumero_de_pieza()==piee) {	
			        	encontrado=true;	        	
		}	 
			 }
			 if (encontrado) {
				 System.out.println("removio el elemento: "+piee); 
				 Piezas.remove(piee-1);			
				 return true;
			}else {
				System.out.println("no se encontro la pieza");
				return false;
			}
		}*/
		return true;
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