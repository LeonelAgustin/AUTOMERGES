package UI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;

import Logica.Vendedor;
import java.awt.Font;
import javax.swing.SwingConstants;

public class registrar_auto extends JPanel {
	private JTextField patente;
	private JTextField marca;
	private JTextField modelo;
	private JTextField ano;
	private JTextField precio;
	private JTable table;
	private Vendedor vendedor;
	private String cliente="";
	
	public Vendedor getVendedor() {
		return vendedor;
	}
		public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}
	/**
	 * Create the panel.
	 */
	public registrar_auto() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Patente");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(44, 55, 92, 13);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Marca");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(349, 55, 96, 13);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Modelo");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(44, 127, 88, 13);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("ano");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(349, 127, 96, 13);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("accion");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(44, 212, 88, 13);
		add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("precio");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(349, 212, 96, 13);
		add(lblNewLabel_5);
		
		JButton btnNewButton = new JButton("Registrar auto");
		
		btnNewButton.setBounds(140, 428, 213, 47);
		add(btnNewButton);
		
		JComboBox accion = new JComboBox();
		accion.setModel(new DefaultComboBoxModel(new String[] {"Reparar", "Restaurar", "Comprar", "Vender", "Vendido"}));
		accion.setBounds(44, 235, 88, 21);
		add(accion);
		
		patente = new JTextField();
		patente.setBounds(40, 78, 96, 19);
		add(patente);
		patente.setColumns(10);
		
		marca = new JTextField();
		marca.setBounds(349, 78, 96, 19);
		add(marca);
		marca.setColumns(10);
		
		modelo = new JTextField();
		modelo.setBounds(40, 147, 96, 19);
		add(modelo);
		modelo.setColumns(10);
		
		ano = new JTextField();
		ano.setBounds(349, 147, 96, 19);
		add(ano);
		ano.setColumns(10);
		
		precio = new JTextField();
		precio.setBounds(349, 236, 96, 19);
		add(precio);
		precio.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Registrar auto");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_6.setBounds(154, 24, 159, 31);
		add(lblNewLabel_6);

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			int accion_suma= accion.getSelectedIndex()+1;
			String accion_ev =  String.valueOf(accion_suma) ;
			
			if (cliente=="") {
				cliente="-1";
			}
			//int cliente,String marca ,String modelo,String patente,String ano,String precio,String estad o
			vendedor.registrarauto(Integer.parseInt(cliente),marca.getText() ,modelo.getText(),patente.getText(),ano.getText(),precio.getText(),accion_ev);
			}
		});
		
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
}
