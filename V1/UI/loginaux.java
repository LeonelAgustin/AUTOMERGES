package UI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.event.ChangeListener;

import Logica.Login;
import negocio.Verificar;

import javax.swing.event.ChangeEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class loginaux extends JPanel {
	private JPasswordField contrasena_i;
	private JTextField usuario_i;
	private boolean logueado;
	private String contrasena;
	private String usuario;
	JLabel Contrasena_p = new JLabel("Contrasena");
	JLabel Usuario_p = new JLabel("Usuario");
	
	
	public String getContrasena() {
		return contrasena;
	}


	public String getUsuario() {
		return usuario;
	}


	public boolean isLogueado() {
		return logueado;
	}

	public void setLogueado(boolean logueado) {
		this.logueado = logueado;
	}

	
	private int i=0;
	
	public int getI() {
		return i;
	}

	/**
	 * Create the panel.
	 */
	public loginaux() {
		setBackground(Color.WHITE);
		setLayout(null);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(new Color(0, 0, 0));
		separator_1.setBounds(271, 223, 165, 2);
		add(separator_1);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(0, 0, 0));
		separator.setBounds(52, 222, 165, 2);
		add(separator);


		Usuario_p.setBounds(52, 158, 119, 33);
		add(Usuario_p);
		
		
		Contrasena_p.setBounds(271, 158, 119, 33);
		add(Contrasena_p);
		contrasena_i = new JPasswordField();
		
		contrasena_i.setEchoChar('*');
		contrasena_i.setBounds(271, 192, 165, 33);
		contrasena_i.setBorder(null);
		add(contrasena_i);
		
		usuario_i = new JTextField();
		usuario_i.setBounds(52, 190, 165, 33);
		usuario_i.setBorder(null);
		add(usuario_i);
		usuario_i.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Login");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_2.setBounds(240, 31, 119, 60);
		add(lblNewLabel_2);
		JButton Usuario = new JButton("Usuario");
		JButton Empleado = new JButton("Empleado");
		
		Empleado.setForeground(Color.RED);
		
		Empleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Empleado.setForeground(Color.RED);
			
				i=0;
				
				Usuario.setForeground(Color.black);
				
				
				revalidate();
				repaint();
			}
		});
		Empleado.setBounds(52, 287, 165, 33);
		add(Empleado);
		
		
		Usuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Usuario.setForeground(Color.RED);
				
				i=1;
				
				Empleado.setForeground(Color.black);
				
				revalidate();
				repaint();
			}
		});
		Usuario.setBounds(271, 287, 165, 33);
		add(Usuario);
		
		
		
	}
	
	
	public void parametros() {
	contrasena	= String.valueOf(contrasena_i.getPassword());
	usuario=usuario_i.getText();
	}
	
	public void pintar() {
		Verificar verificar = new Verificar();
		if (verificar.verificarcontrasena(contrasena)) {
			Contrasena_p.setForeground(new Color(0, 0, 0));
		}else {
			Contrasena_p.setForeground(new Color(255, 51, 0));
		}
		if (verificar.verificardni(usuario)) {
			Usuario_p.setForeground(new Color(0, 0, 0));
		}else {
			Usuario_p.setForeground(new Color(255, 51, 0));
		}
		revalidate();
		repaint();
	}
	
}
