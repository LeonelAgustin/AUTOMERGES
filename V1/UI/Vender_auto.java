package UI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;

public class Vender_auto extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public Vender_auto() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Vender Auto");
		lblNewLabel.setBounds(140, 29, 264, 39);
		add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(87, 114, 370, 192);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(182, 332, 190, 39);
		add(btnNewButton);

	}
}
