package UI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import negocio.Verificar;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import Logica.Login;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class registro extends JPanel {
	private JTextField dni_p;
	private JTextField contrasena_d;
	private JTextField telefono_d;
	private JTextField contrasena2_d;
	private JTextField nombre_d;
	private JTextField apellido_d;
	private JTextField direccion_d;
	private JTextField altura_d;
	private JLabel contrasena_l;
	private JLabel telefono_l;
	private JLabel contrasena2_l;
	private JLabel nombre_l;
	private JLabel apellido_l;
	private JLabel direccion_l;
	private JLabel altura_l;
	private JButton btnNewButton;

	String dni=null;
	String contrasena=null;
	String telefono=null;
	String contrasena2=null;
	String nombre=null;
	String apellido = null;
	String direccion = null;
	String altura=null;
	
	Login empleado = new Login(0, 0, null, null, null, null);
	
	/**
	 * Create the panel.
	 */
	public registro() {
		setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registro");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(50, 28, 383, 36);
		add(lblNewLabel);
		
		dni_p = new JTextField();
		dni_p.setBackground(Color.WHITE);
		dni_p.setForeground(Color.BLACK);
		dni_p.setBounds(50, 129, 96, 19);
		add(dni_p);
		dni_p.setColumns(10);
		
		contrasena_d = new JTextField();
		contrasena_d.setBounds(337, 129, 96, 19);
		add(contrasena_d);
		contrasena_d.setColumns(10);
		
		telefono_d = new JTextField();
		telefono_d.setBounds(50, 214, 96, 19);
		add(telefono_d);
		telefono_d.setColumns(10);
		
		contrasena2_d = new JTextField();
		contrasena2_d.setBounds(337, 214, 96, 19);
		add(contrasena2_d);
		contrasena2_d.setColumns(10);
		
		nombre_d = new JTextField();
		nombre_d.setBounds(50, 318, 96, 19);
		add(nombre_d);
		nombre_d.setColumns(10);
		
		apellido_d = new JTextField();
		apellido_d.setBounds(337, 318, 96, 19);
		add(apellido_d);
		apellido_d.setColumns(10);
		
		direccion_d = new JTextField();
		direccion_d.setBounds(50, 415, 96, 19);
		add(direccion_d);
		direccion_d.setColumns(10);
		
		altura_d = new JTextField();
		altura_d.setBounds(337, 415, 96, 19);
		add(altura_d);
		altura_d.setColumns(10);
		
		JLabel dni_l = new JLabel("Dni");
		dni_l.setBounds(50, 108, 45, 13);
		add(dni_l);
		
		
		contrasena_l = new JLabel("contrasena");
		contrasena_l.setBounds(337, 106, 78, 13);
		add(contrasena_l);
		
		
		telefono_l = new JLabel("telefono");
		telefono_l.setBounds(50, 191, 59, 13);
		add(telefono_l);
		
		
		contrasena2_l = new JLabel("confirmar contrasena");
		contrasena2_l.setBounds(337, 191, 129, 13);
		add(contrasena2_l);
		
		
		nombre_l = new JLabel("nombre");
		nombre_l.setBounds(50, 295, 59, 13);
		add(nombre_l);
		
		
		apellido_l = new JLabel("apellido");
		apellido_l.setBounds(337, 295, 45, 13);
		add(apellido_l);
		
		
		
		direccion_l = new JLabel("direccion");
		direccion_l.setBounds(50, 392, 59, 13);
		add(direccion_l);
		 
		
		
		altura_l = new JLabel("altura");
		altura_l.setBounds(337, 392, 45, 13);
		add(altura_l);
		
		
		
		btnNewButton = new JButton("registrarse");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				altura= altura_d.getText().toString();
				direccion = direccion_d.getText().toString();
				dni=dni_p.getText().toString();
				contrasena=contrasena_d.getText().toString();
				telefono=telefono_d.getText().toString();
				contrasena2=contrasena2_d.getText().toString();
				nombre=nombre_d.getText().toString();
				apellido = apellido_d.getText().toString();
				int errores=0;
				
				
				System.err.println(dni);
				Verificar verificar = new Verificar();
		if (!verificar.verificarcontrasena(contrasena)) {
			errores++;
			contrasena_l.setForeground(new Color(255, 51, 0));
			
		}else {
			contrasena_l.setForeground(new Color(0, 0, 0));

		}
		
		if(!contrasena.equals(contrasena2)||!verificar.verificarcontrasena(contrasena)) {
			contrasena2_l.setForeground(new Color(255, 51, 0));
			errores++;
		}else {
			contrasena2_l.setForeground(new Color(0, 0, 0));

		}
		

		if (!verificar.verificardni(dni)) {	
			dni_l.setForeground(new Color(255, 51, 0));
			errores++;
		}else {
			dni_l.setForeground(new Color(0, 0, 0));

		}

		if (!verificar.verificarnombre(nombre)) {
			nombre_l.setForeground(new Color(255, 51, 0));
			errores++;
		}else {
			nombre_l.setForeground(new Color(0, 0, 0));

		}

		if (!verificar.verificarapellido(apellido)) {
			apellido_l.setForeground(new Color(255, 51, 0));
			errores++;
		}else {
			apellido_l.setForeground(new Color(0, 0, 0));

		}

		if (!verificar.verificardireccion(direccion)) {
			direccion_l.setForeground(new Color(255, 51, 0));
			errores++;
		}else {
			direccion_l.setForeground(new Color(0, 0, 0));

		}

		if (!verificar.verificaraltura(altura)) {
			altura_l.setForeground(new Color(255, 51, 0));
			errores++;
		}else {
			altura_l.setForeground(new Color(0, 0, 0));

		}

		if (!verificar.verificartelefono(telefono)) {
			telefono_l.setForeground(new Color(255, 51, 0));
			errores++;
		}else {
			telefono_l.setForeground(new Color(0, 0, 0));

		}
		
		if (errores==0) {
			boolean aprobacion=true;
			if (aprobacion) {
				aprobacion=false;
				aprobacion=empleado.registro(contrasena, dni, nombre, apellido, direccion, altura, telefono);
			}
			do {
				//System.err.println("cargando... 20%");
			} while (!aprobacion);
				aprobacion=false;
				aprobacion=empleado.registro1(contrasena, dni, nombre, apellido, direccion, altura, telefono);
			do {
				//System.err.println("cargando... 50%");
			} while (!aprobacion);
				System.err.println(empleado.getId());
				empleado.registro2(contrasena, dni, nombre, apellido, direccion, altura, telefono);
				altura_d.setText("");
				direccion_d.setText("");
				dni_p.setText("");
				contrasena_d.setText("");
				telefono_d.setText("");
				contrasena2_d.setText("");
				nombre_d.setText("");
				apellido_d.setText("");
				JOptionPane.showMessageDialog(null,"registro realizado correctamente");
		}
		
		
		System.err.println("contrasena " + (!verificar.verificarcontrasena(contrasena)) + " confirmar contrasena "+ (!contrasena.equals(contrasena2) )+ " dni "+ ((!verificar.verificardni(dni)))  + " nombre "+(!verificar.verificarnombre(nombre)) + " apellido "+(!verificar.verificarapellido(apellido)) + " direccion " + (!verificar.verificardireccion(direccion)) +" altura " + (!verificar.verificaraltura(altura)) + " telefono " + (!verificar.verificartelefono(telefono))  );
		
		lblNewLabel.revalidate();
		lblNewLabel.repaint();
		}
		});
		btnNewButton.setBounds(179, 470, 129, 50);
		add(btnNewButton);

		
	}
}
