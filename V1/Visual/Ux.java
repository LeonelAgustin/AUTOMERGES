package Visual;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Window.Type;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;
import java.awt.Dimension;
import javax.swing.SwingConstants;

public class Ux extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ux frame = new Ux();
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
	public Ux() {
		setEnabled(false);
		setFont(null);
		setForeground(Color.RED);
		setType(Type.POPUP);
		setTitle("Iniciar Sesion");
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 504, 427);
		contentPane = new JPanel();
		contentPane.setBorder(new CompoundBorder());

		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Contraseña");
		lblNewLabel.setBounds(284, 148, 135, 22);
		lblNewLabel.setFont(new Font("Roboto Medium", lblNewLabel.getFont().getStyle(), lblNewLabel.getFont().getSize() + 2));
		
		textField = new JTextField();
		textField.setBounds(284, 171, 135, 22);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Usuario");
		lblNewLabel_1.setBounds(50, 148, 135, 22);
		lblNewLabel_1.setFont(new Font("Roboto Medium", lblNewLabel_1.getFont().getStyle(), lblNewLabel_1.getFont().getSize() + 2));
		
		textField_1 = new JTextField();
		textField_1.setBounds(50, 169, 135, 22);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(178, 303, 135, 42);
		btnNewButton.setForeground(new Color(0, 0, 51));
		btnNewButton.setFont(new Font("Roboto Black", btnNewButton.getFont().getStyle(), btnNewButton.getFont().getSize() + 3));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.setLayout(null);
		contentPane.add(lblNewLabel);
		contentPane.add(textField);
		contentPane.add(lblNewLabel_1);
		contentPane.add(textField_1);
		contentPane.add(btnNewButton);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Empleado");
		rdbtnNewRadioButton.setBounds(284, 240, 135, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Cliente");
		rdbtnNewRadioButton_1.setSelected(true);
		rdbtnNewRadioButton_1.setBounds(50, 240, 135, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("Error");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setBackground(new Color(240, 240, 240));
		lblNewLabel_2.setDisplayedMnemonic('1');
		lblNewLabel_2.setFont(new Font("Roboto Slab Medium", lblNewLabel_2.getFont().getStyle(), lblNewLabel_2.getFont().getSize() + 1));
		lblNewLabel_2.setForeground(new Color(255, 0, 0));
		lblNewLabel_2.setBounds(50, 202, 135, 22);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Error");
		lblNewLabel_2_1.setLabelFor(this);
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_1.setDisplayedMnemonic('1');
		lblNewLabel_2_1.setFont(new Font("Roboto Slab Medium", lblNewLabel_2_1.getFont().getStyle(), lblNewLabel_2_1.getFont().getSize() + 2));
		lblNewLabel_2_1.setForeground(Color.RED);
		lblNewLabel_2_1.setBounds(284, 204, 135, 22);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_3 = new JLabel("Iniciar sesion");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Roboto Black", lblNewLabel_3.getFont().getStyle(), lblNewLabel_3.getFont().getSize() + 15));
		lblNewLabel_3.setBounds(93, 44, 272, 67);
		contentPane.add(lblNewLabel_3);
	}
}
