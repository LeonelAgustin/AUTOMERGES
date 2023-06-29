package UI;

import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logica.Login;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class LoginUX extends JFrame {

	private JPanel contentPane;
	private JTextField Usuario;
	private JTextField Contrasena;
	private int temp;

	public int getTemp() {
		return temp;
	}

	public void setTemp(int temp) {
		this.temp = temp;
	}

	
	public LoginUX(int temp) throws HeadlessException {
		super();
		this.temp = temp;
	}

	/**
	 * Launch the application.
	 */

		
			public void run() {
				try {
					LoginUX frame = new LoginUX();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		
	

	/**
	 * Create the frame.
	 */
	public LoginUX() {
		
		 
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setBounds(221, 29, 76, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("usuario");
		lblNewLabel_1.setBounds(87, 88, 50, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("contrasena");
		lblNewLabel_2.setBounds(356, 88, 76, 16);
		contentPane.add(lblNewLabel_2);
		
		Usuario = new JTextField();
		Usuario.setBounds(56, 127, 112, 28);
		contentPane.add(Usuario);
		Usuario.setColumns(10);
		
		Contrasena = new JTextField();
		Contrasena.setBounds(338, 127, 112, 28);
		contentPane.add(Contrasena);
		Contrasena.setColumns(10);
		JRadioButton empleadob = new JRadioButton("Empleado");
		JRadioButton usuariob = new JRadioButton("Usuario");
		
		Login empleado = new Login(0, 0, null, null, null, null);
		Login cliente = new Login(0, 0, null, null);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
								
				String pass = Contrasena.getText();
				 String user =Usuario.getText();
				 
				System.err.println("usuario ="+ user + " contrasena ="+pass + " secc "+ getTemp()  );
				 
				if (empleadob.isEnabled()) {
					
					if (empleado.TraerEmleados(pass,user)) {
						
						cerrar();
						//this.notify();
						
						empleado.menu_transport();
						//System.err.println(empleado.getNombre());
					} else {
						System.err.println("error");
					}
				} else {
					
					if (cliente.TraerUsuarios(pass, user)) {
						
						//System.err.println(cliente);
					} else {
						System.err.println("error");
					}
				}
				
			}

		});
		btnNewButton.setBounds(211, 309, 86, 28);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("error ingresando el usuario");
		lblNewLabel_3.setBounds(33, 167, 159, 16);
		lblNewLabel_3.setVisible(false);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("error ingresando la contrasena");
		lblNewLabel_4.setBounds(303, 167, 183, 16);
		lblNewLabel_4.setVisible(false);
		contentPane.add(lblNewLabel_4);
	

		usuariob.setSelected(true);
		usuariob.setBounds(59, 235, 109, 18);
		usuariob.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 if(usuariob.isEnabled()) {
        	empleadob.setSelected(false);
        }
			}
		});
		contentPane.add(usuariob);
		
		
	
		empleadob.setBounds(338, 235, 109, 18);	
		empleadob.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 if(empleadob.isEnabled()) {
        	usuariob.setSelected(false);
        }
			}
		});
		contentPane.add(empleadob);
        
       
        
       
		
	}
	
	public void cerrar() {
   	 this.dispose();
   	 //this.notify();
    }
		
	
	public boolean empleado() {
		return this.getTemp() == 1;
	}
}
