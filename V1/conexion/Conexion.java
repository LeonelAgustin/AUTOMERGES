package conexion;

import java.sql.Connection;
import java.sql.DriverManager;


import javax.swing.JOptionPane;


public class Conexion {
	//true = defecto  false = davinci
private boolean demo_setting=true;
Connection con ;
	
	public Connection conectar() {
		
		
			
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
				//configuracion defecto
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/automerges","root","");
				//JOptionPane.showMessageDialog(null, "se conecto");
		} catch (Exception e) {
	
			try {
				//configuracion davinci
				con = DriverManager.getConnection("jdbc:mysql://localhost:3463/automerges","root","");
			} catch (Exception e2) {
				
			}
			
			//JOptionPane.showMessageDialog(null, "error al conectarse" + e.getMessage());
		}
		return con;
	
		

		
	
	
	}


}
