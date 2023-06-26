package Interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import Datos.*;

public class PantallaFabricante extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaFabricante frame = new PantallaFabricante();
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
	public PantallaFabricante() {
		Pieza pieza1 = new Pieza (0,"","");
		//Fabricante fabricante1= new Fabricante(0,"","","",0,0,"");
		Fabricante fabricante = new Fabricante(0, null, null, null, 0, 0, null);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 886, 493);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel MyLabel = new JLabel("Bienvenido Fabricante");
		MyLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		MyLabel.setBounds(10, 34, 394, 80);
		contentPane.add(MyLabel);
		
		JButton btnPararProceso = new JButton("Parar Proceso");
		btnPararProceso.setBackground(new Color(0, 255, 255));
		btnPararProceso.setFont(new Font("Tahoma", Font.ITALIC, 15));
		btnPararProceso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//fabricante.PararProceso();
				VPararProceso ventanaPararProceso = new VPararProceso();
				ventanaPararProceso.run();	
				}			
		});
		btnPararProceso.setBounds(527, 108, 160, 48);
		contentPane.add(btnPararProceso);
		
		JButton btnVerStock = new JButton("Ver Stock");
		btnVerStock.setFont(new Font("Tahoma", Font.ITALIC, 15));
		btnVerStock.setBackground(Color.CYAN);
		btnVerStock.setBounds(604, 167, 160, 48);
		contentPane.add(btnVerStock);
		btnVerStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(pieza1.Mostrar().isEmpty() || pieza1.Mostrar()==null ) {
					JOptionPane.showMessageDialog(null, "Lista vacia");
				}else {
					JOptionPane.showMessageDialog(null, pieza1.Mostrar());
				}
				}			
		});
		
		/*JButton btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSalir.setFont(new Font("Tahoma", Font.ITALIC, 15));
		btnSalir.setBackground(Color.RED);
		btnSalir.setBounds(697, 398, 160, 48);
		contentPane.add(btnSalir);*/
		
		JButton btnIniciarProceso = new JButton("Iniciar Proceso");
		btnIniciarProceso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				fabricante.RegistrarPieza();
			}
		});
		btnIniciarProceso.setFont(new Font("Tahoma", Font.ITALIC, 15));
		btnIniciarProceso.setBackground(Color.CYAN);
		btnIniciarProceso.setBounds(527, 37, 160, 48);
		contentPane.add(btnIniciarProceso);
		
		JButton btnReanudarProceso = new JButton("Reanudar Proceso");
		btnReanudarProceso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fabricante.ReanudarProceso();
			}
		});
		btnReanudarProceso.setFont(new Font("Tahoma", Font.ITALIC, 15));
		btnReanudarProceso.setBackground(Color.CYAN);
		btnReanudarProceso.setBounds(697, 37, 160, 48);
		contentPane.add(btnReanudarProceso);
		
		JButton btnBorrarProceso = new JButton("Borrar Proceso");
		btnBorrarProceso.setFont(new Font("Tahoma", Font.ITALIC, 15));
		btnBorrarProceso.setBackground(Color.CYAN);
		btnBorrarProceso.setBounds(697, 108, 160, 48);
		contentPane.add(btnBorrarProceso);
		btnBorrarProceso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VBorrarProceso ventanaBorrarProceso = new VBorrarProceso();
				ventanaBorrarProceso.run();
				//fabricante.BorrarProceso();
			}
		});
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Alumno\\Desktop\\fabrica\\Fabricaa\\src\\img\\3998333_14282 (1).jpg"));
		lblNewLabel.setBounds(10, 11, 850, 450);
		contentPane.add(lblNewLabel);
	}
}
