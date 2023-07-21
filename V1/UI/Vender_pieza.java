package UI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;


public class Vender_pieza extends JPanel {
	public Vender_pieza() {
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(61, 98, 409, 221);
		add(scrollPane);
		
		JLabel lblNewLabel = new JLabel("Vender Pieza");
		lblNewLabel.setBounds(61, 28, 409, 39);
		add(lblNewLabel);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(61, 329, 415, 21);
		add(btnNewButton);
	}

}
