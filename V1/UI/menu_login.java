package UI;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class menu_login extends JPanel {
public int i=0;

	public int getI() {
	return i;
}

public void setI(int i) {
	this.i = i;
}

	/**
	 * Create the panel.
	 * @param panel_opcion 
	 * @return 
	 */
	public menu_login() {
		setLayout(null);
	
		
		JButton btnNewButton = new JButton("Registrarse");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				i=1;
			}
			
		});
		btnNewButton.setBounds(37, 169, 128, 53);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Loguearse");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				i=0;
			}
		});
		btnNewButton_1.setBounds(37, 343, 128, 53);
		add(btnNewButton_1);

		
		
	}
}
