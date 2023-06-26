package Interfaz;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLayeredPane;
import javax.swing.JScrollBar;
import java.awt.Choice;
import Datos.*;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class VPararProceso extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
			public void run() {
				try {
					VPararProceso frame = new VPararProceso();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	/**
	 * Create the frame.
	 */
	public VPararProceso() {
			Pieza pieza1=new Pieza(0,"","");
			Fabricante fabricante = new Fabricante(0, null, null, null, 0, 0, null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 701, 545);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Choice choice = new Choice();
		choice.setBounds(63, 107, 234, 20);
		int id=0;
		contentPane.add(choice);

		// Agregar los elementos del array opcioncitas al objeto Choice
		String[] opcioncitas = new String[pieza1.MostrarSinSus().size()];
		for (int i = 0; i < pieza1.MostrarSinSus().size(); i++) {
		    opcioncitas[i] = Integer.toString(pieza1.MostrarSinSus().get(i).getId());
		    choice.add(opcioncitas[i]);
		}
		// int id = Integer.parseInt((String) JOptionPane.showInputDialog(null, "Elija el id: ", "", JOptionPane.DEFAULT_OPTION, null, opcioncitas, opcioncitas[0]));
		contentPane.add(choice);
		// Obtener el valor seleccionado del objeto Choice
		String valorSeleccionado = choice.getSelectedItem();

		// Convertir el valor seleccionado a un entero
		final int idSeleccionado = Integer.parseInt(valorSeleccionado);
		//id=idSeleccionado;
		
		
		
		/*JList list = new JList();
		list.setBounds(394, 25, 234, 433);
		
		contentPane.add(list);*/
		DefaultListModel<String> model = new DefaultListModel<>();
		JList<String> list = new JList<>(model);
		list.setBounds(356, 64, 286, 405);

		if (pieza1.Mostrar().isEmpty() || pieza1.MostrarSinSus() == null) {
		    JOptionPane.showMessageDialog(null, "Lista vacia");
		} else {
		    for (Pieza elemento : pieza1.MostrarSinSus()) {
		        model.addElement(elemento.toString());
		    }
		}

		contentPane.add(list);
		
		JButton btnNewButton = new JButton("Parar Proceso ");
		btnNewButton.setBackground(Color.CYAN);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBounds(107, 357, 124, 43);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Elija la pieza");
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblNewLabel.setBounds(127, 71, 90, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblListaDePiezas = new JLabel("Lista de Piezas ");
		lblListaDePiezas.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblListaDePiezas.setBounds(455, 23, 100, 30);
		contentPane.add(lblListaDePiezas);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fabricante.ppp(idSeleccionado);
				//fabricante.RegistrarPieza();
			}
		});
	}
}
