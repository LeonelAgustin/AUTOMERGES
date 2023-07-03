package UI;

import javax.swing.JPanel;

import Logica.Vendedor;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JEditorPane;
import java.awt.Font;

public class comprar_auto extends JPanel {

private Vendedor vendedor;
	
	
	public Vendedor getVendedor() {
		return vendedor;
	}
		public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}
	
	/**
	 * Create the panel.
	 */
	public comprar_auto() {
		vendedor.buscar_auto(true);
		setLayout(null);
		

		
		JLabel lblNewLabel = new JLabel("Comprar auto");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 10, 513, 48);
		add(lblNewLabel);

		
	}
}
