package graficos;

import java.awt.Color;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Datos.Mecanico;

public class mecanicoMenu extends JFrame {

	private JPanel volver;

	/**
	 * Launch the application.
	 */
	
			public void run(Mecanico mecanico) {
				try {
					mecanicoMenu frame = new mecanicoMenu(mecanico);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			
	}

	/**
	 * Create the frame.
	 */
	public mecanicoMenu(Mecanico mecanico) {
		LocalDateTime locaDate = LocalDateTime.now();
		int horas  = locaDate.getHour();
		int minutos = locaDate.getMinute();
		int segundos = locaDate.getSecond();
		System.out.println("Hora actual : " + horas  + ":"+ minutos +":"+segundos); 
		
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		 Date date = new Date(horas,minutos,segundos);
		  System.out.println("Hora actual: " + dateFormat.format(date));
		  
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Alumno\\Desktop\\tp2\\iconos\\Automerges-icono.png"));
		setTitle("AUTOMERGE s.a");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1193, 633);
		volver = new JPanel();
		volver.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(volver);
		volver.setLayout(null);
		
		
		JButton opcion1 = new JButton("Trabajar en informes ya registrados");
		opcion1.setBackground(Color.LIGHT_GRAY);
		opcion1.setIcon(new ImageIcon("C:\\Users\\Alumno\\Desktop\\tp2\\iconos\\opcion1.png"));
		opcion1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {//case 1
				mostrarInformes tabla = new mostrarInformes();
				tabla.run();
			}
		});
		opcion1.setFont(new Font("Arial", Font.BOLD, 14));
		opcion1.setBounds(23, 152, 377, 90);
		volver.add(opcion1);
		
		
		JButton opcion2 = new JButton("Trabajar en informes \r\nque lleguen durante el dia");
		opcion2.setIcon(new ImageIcon("C:\\Users\\Alumno\\Desktop\\tp2\\iconoss\\opcion3.png"));
		opcion2.setFont(new Font("Arial", Font.BOLD, 14));
		opcion2.setBounds(660, 152, 507, 90);
		volver.add(opcion2);
		
		JButton opcion3 = new JButton("Solicitar piezas para el taller");
		opcion3.setIcon(new ImageIcon("C:\\Users\\Alumno\\Desktop\\tp2\\iconos\\opcion2.png"));
		opcion3.setFont(new Font("Arial", Font.BOLD, 14));
		opcion3.setBounds(10, 426, 377, 93);
		volver.add(opcion3);
		
		JButton opcion4 = new JButton("Terminar jornada laboral");
		opcion4.setIcon(new ImageIcon("C:\\Users\\Alumno\\Desktop\\tp2\\iconos\\opcion4.png"));
		opcion4.setFont(new Font("Arial", Font.BOLD, 14));
		opcion4.setBounds(660, 426, 507, 93);
		volver.add(opcion4);
		
		JLabel lblIconM = new JLabel("");
		lblIconM.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIconM.setIcon(new ImageIcon("C:\\Users\\Alumno\\Desktop\\tp2\\iconos\\mecanico.png"));
		lblIconM.setBounds(497, 252, 79, 93);
		volver.add(lblIconM);
		
		JLabel nombreMecanico = new JLabel("Esta logueado como: "+mecanico.getNombre()+" "+mecanico.getApellido());
		nombreMecanico.setFont(new Font("Tahoma", Font.BOLD, 14));
		nombreMecanico.setBounds(396, 356, 321, 46);
		volver.add(nombreMecanico);
		
		JLabel lblBienvenida = new JLabel("Bienvenido Mecanico que trabajo desea realizar:");
		lblBienvenida.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 16));
		lblBienvenida.setBounds(357, 76, 321, 46);
		volver.add(lblBienvenida);
		
		JLabel lblHoraDeEntrada = new JLabel("Hora de entrada al taller:");
		lblHoraDeEntrada.setFont(new Font("Calibri", Font.BOLD, 16));
		lblHoraDeEntrada.setBounds(357, 32, 186, 46);
		volver.add(lblHoraDeEntrada);

		// HORA LOCAL
		
        DateTimeFormatter f = DateTimeFormatter.ofPattern("hh:MM");
		JLabel lblHora = new JLabel("Fecha "+LocalDate.now() + " Hora " + LocalDateTime.now().format(f));
		lblHora.setFont(new Font("Calibri", Font.BOLD, 16));
		lblHora.setBounds(563, 32, 298, 46);
		volver.add(lblHora);
		
		JButton atras = new JButton("");
		atras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int res = 0;
				res= Integer.parseInt(JOptionPane.showInputDialog("¿Esta seguro que quiere cerrar sesion?\n1-Cerrar sesion\n0-Seguir en sesion")) ;
								
				if (res==1) {
					ingresarM aux = new ingresarM();
					aux.run();
					dispose();
				}
			}
		});
		atras.setIcon(new ImageIcon("C:\\Users\\Alumno\\Desktop\\tp2\\iconos\\salir.png"));
		atras.setBounds(23, 11, 67, 73);
		volver.add(atras);
	}
}
