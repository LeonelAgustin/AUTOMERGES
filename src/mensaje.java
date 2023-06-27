import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;

public class mensaje extends JFrame {

	private JPanel contentPane;
	private JTextField textUsuario;
	private JTextField txtContrasea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mensaje frame = new mensaje();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public mensaje() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textUsuario = new JTextField();
		textUsuario.setBackground(Color.GREEN);
		textUsuario.setBounds(20, 166, 115, 20);
		contentPane.add(textUsuario);
		textUsuario.setColumns(10);
		
		JButton btnNewButton = new JButton("Ingresar");
		btnNewButton.setBounds(177, 227, 89, 23);
		contentPane.add(btnNewButton);
		
		txtContrasea = new JTextField();
		txtContrasea.setColumns(10);
		txtContrasea.setBackground(Color.GREEN);
		txtContrasea.setBounds(273, 166, 115, 20);
		contentPane.add(txtContrasea);
		
		JLabel lblNewLabel = new JLabel("Ingrese usuario");
		lblNewLabel.setBounds(35, 141, 75, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblIngreseContrasea = new JLabel("Ingrese contraseña");
		lblIngreseContrasea.setBounds(281, 141, 95, 14);
		contentPane.add(lblIngreseContrasea);
	}
}
