package UI;

import javax.swing.JPanel;

import Logica.Vendedor;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.Timer;

public class verstock extends JPanel {

	private String value = "";
	private Vendedor vendedor;
	JLabel lblNewLabel = new JLabel();
	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}
	
	
	
	/**
	 * Create the panel.
	 */
	public verstock() {
		setLayout(null);
	
		
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 220, 553, 69);
		lblNewLabel.setText(value);
		System.err.println(value);
		add(lblNewLabel);

	}
	
	public void precarga() {
	value = vendedor.verestacionamiento();
	Timer myTimer = new Timer(5000, combio());
	myTimer.setRepeats(false); // asegurarse de que el Timer solo se ejecute una vez
	myTimer.start(); // iniciar el Timer
	}
	
	public ActionListener combio() {
		lblNewLabel.setText(value);
		validate();
		repaint();
		return null;
	}
	
	
}
