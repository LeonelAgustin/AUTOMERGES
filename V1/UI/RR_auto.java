package UI;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

import Logica.Cliente;
import Logica.Vendedor;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class RR_auto extends JPanel {
	private JTable table;

	private Vendedor vendedor;
	
	private String client;
	
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
		buscador();
	}
	public Vendedor getVendedor() {
		return vendedor;
	}
		public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}
		String nombre[] = {"id", "patene", "Marca", "modelo", "ano", "cliente" ,"precio"};
		String autos[][] = {{" "," "," "," "," "," "},{" "," "," "," "," "," "},{" "," "," "," "," "," "},{" "," "," "," "," "," "},{" "," "," "," "," "," "},{" "," "," "," "," "," "},{" "," "," "," "," "," "},{" "," "," "," "," "," "},{" "," "," "," "," "," "},{" "," "," "," "," "," "}};
		String buttondialog[] = {"llavar a reparar","llavar a restaurar"};
	datatable modelo = new datatable(autos, nombre);
	
	/**
	 * Create the panel.
	 */
	public RR_auto() {
		
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 168, 548, 203);
		add(scrollPane);
		

		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			autos,
			nombre
		));
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("Restaurar y Reparar");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 22, 548, 64);
		add(lblNewLabel);
		
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Reparar");
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Restaurar");
		JButton btnNewButton = new JButton(buttondialog[0]);
		
		chckbxNewCheckBox.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(chckbxNewCheckBox.isSelected()) {
					chckbxNewCheckBox_1.setSelected(false);
					btnNewButton.setText(buttondialog[0]);
				}else {
					chckbxNewCheckBox_1.setSelected(true);
					btnNewButton.setText(buttondialog[1]);
				}
			}
		});
		chckbxNewCheckBox.setSelected(true);
		chckbxNewCheckBox.setBounds(70, 413, 93, 21);
		add(chckbxNewCheckBox);
		
		
		chckbxNewCheckBox_1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(chckbxNewCheckBox_1.isSelected()) {
					chckbxNewCheckBox.setSelected(false);
					btnNewButton.setText(buttondialog[1]);
				}else {
					chckbxNewCheckBox.setSelected(true);
					btnNewButton.setText(buttondialog[0]);
				}
			}
		});
		chckbxNewCheckBox_1.setBounds(389, 413, 93, 21);
		add(chckbxNewCheckBox_1);
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton.setBounds(170, 453, 214, 35);
		add(btnNewButton);

	}
	
	void buscador(){
		//System.err.println("numero recibido");
		//System.out.println(client);
		vendedor.buscador(client, 7);
		Timer myTimer = new Timer(10000, generar_tabla());
		myTimer.setRepeats(false); // asegurarse de que el Timer solo se ejecute una vez
		myTimer.start(); // iniciar el Timer
	}
	
	public ActionListener generar_tabla() {
		String aux[][]= new String[vendedor.getCarro().size()][7];
		if (vendedor.getCarro().size()!=0) {
		for (int i = 0; i < vendedor.getCarro().size(); i++) {
			aux[i][0]=String.valueOf(vendedor.getCarro().get(i).getId());
			aux[i][1]=vendedor.getCarro().get(i).getPatente();
			aux[i][2]=vendedor.getCarro().get(i).getMarca();
			aux[i][3]=vendedor.getCarro().get(i).getModelo();
			aux[i][4]=String.valueOf(vendedor.getCarro().get(i).getAno());
			aux[i][5]=String.valueOf(vendedor.getCarro().get(i).getIdcliente());
			aux[i][6]=vendedor.getCarro().get(i).getPrecio();
		//System.err.println(vendedor.getCarro().get(i));
		}
		}else{
			aux=autos;
		}
		table.removeAll();
		datatable modelo_new = new datatable(aux, nombre);
		table.setModel(modelo_new);
		revalidate();
		repaint();
		return null;
	}
	
	
}
