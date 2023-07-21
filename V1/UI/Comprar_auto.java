package UI;

import javax.swing.JPanel;

import Logica.Vendedor;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JEditorPane;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class comprar_auto extends JPanel {

	private Vendedor vendedor;
	private JTable table;

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	/**
	 * Create the panel.
	 */
	public comprar_auto(Vendedor vendedor) {
		vendedor.buscar_auto(true);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Comprar auto");
		lblNewLabel.setBounds(10, 10, 513, 48);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(59, 99, 418, 240);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null},
			},
			new String[] {
				"New column"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Seleccionar Cliente");
		btnNewButton.setBounds(182, 371, 159, 48);
		add(btnNewButton);

	}
}
