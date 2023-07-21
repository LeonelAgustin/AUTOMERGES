package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class panel_auxiliar extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					panel_auxiliar frame = new panel_auxiliar();
					
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
	public panel_auxiliar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 211, 563);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton vender_auto_acc = new JButton("Vender auto");
		vender_auto_acc.setBounds(35, 94, 120, 38);
		panel.add(vender_auto_acc);
		
		JButton vender_pieza_acc = new JButton("Vender pieza");
		vender_pieza_acc.setBounds(35, 160, 120, 38);
		panel.add(vender_pieza_acc);
		
		JButton reparar_auto_acc = new JButton("Reparar auto");
		reparar_auto_acc.setBounds(35, 226, 120, 38);
		panel.add(reparar_auto_acc);
		
		JButton ver_Stock = new JButton("Ver estacionamiento");
		ver_Stock.setBounds(35, 292, 120, 38);
		panel.add(ver_Stock);
		
		JButton registrar_auto_acc = new JButton("Registrar auto");
		registrar_auto_acc.setBounds(35, 358, 120, 38);
		panel.add(registrar_auto_acc);
		
		JButton buscar_auto_acc = new JButton("Buscar auto");
		buscar_auto_acc.setBounds(35, 424, 120, 38);
		panel.add(buscar_auto_acc);
		
		JButton logout = new JButton("Logout");
		logout.setBounds(35, 490, 120, 38);
		panel.add(logout);
		
		JButton comprar_auto_acc = new JButton("Comprar auto");
		comprar_auto_acc.setBounds(35, 28, 120, 38);
		panel.add(comprar_auto_acc);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(223, 0, 557, 556);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 210, 533, 340);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"New column", "New column", "New column"
			}
		));
		scrollPane.setViewportView(table);
		
	}
}
