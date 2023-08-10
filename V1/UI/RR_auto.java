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
import javax.swing.JTextField;

public class RR_auto extends JPanel {
	private JTable table;

	private boolean z = false;

	private Vendedor vendedor;

	private String client;

	JLabel Informacion = new JLabel("");
	
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

	String nombre[] = { "id", "patente", "Marca", "modelo", "ano", "cliente", "precio" };
	String autos[][] = { { " ", " ", " ", " ", " ", " " }, { " ", " ", " ", " ", " ", " " },
			{ " ", " ", " ", " ", " ", " " }, { " ", " ", " ", " ", " ", " " }, { " ", " ", " ", " ", " ", " " },
			{ " ", " ", " ", " ", " ", " " }, { " ", " ", " ", " ", " ", " " }, { " ", " ", " ", " ", " ", " " },
			{ " ", " ", " ", " ", " ", " " }, { " ", " ", " ", " ", " ", " " } };
	String buttondialog[] = { "llavar a reparar", "llavar a restaurar" };
	datatable modelo = new datatable(autos, nombre);
	private JTextField asunto_text;

	/**
	 * Create the panel.
	 */
	public RR_auto() {

		table = new JTable();

		setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 168, 548, 154);
		add(scrollPane);

		table.setModel(new DefaultTableModel(autos, nombre));
		scrollPane.setViewportView(table);

		JLabel lblNewLabel = new JLabel("Restaurar y Reparar");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 22, 548, 64);
		add(lblNewLabel);

		JCheckBox chckbxNewCheckBox = new JCheckBox("Reparar");
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Restaurar");
		JButton btnNewButton = new JButton(buttondialog[0]);
		asunto_text = new JTextField();

		chckbxNewCheckBox.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (chckbxNewCheckBox.isSelected()) {
					chckbxNewCheckBox_1.setSelected(false);
					btnNewButton.setText(buttondialog[0]);
					z = false;
				} else {
					chckbxNewCheckBox_1.setSelected(true);
					btnNewButton.setText(buttondialog[1]);
					z = true;
				}
			}
		});
		chckbxNewCheckBox.setSelected(true);
		chckbxNewCheckBox.setBounds(70, 413, 93, 21);
		add(chckbxNewCheckBox);

		chckbxNewCheckBox_1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (chckbxNewCheckBox_1.isSelected()) {
					chckbxNewCheckBox.setSelected(false);
					btnNewButton.setText(buttondialog[1]);
					z = true;
				} else {
					chckbxNewCheckBox.setSelected(true);
					btnNewButton.setText(buttondialog[0]);
					z = false;
				}
			}
		});
		chckbxNewCheckBox_1.setBounds(399, 413, 93, 21);
		add(chckbxNewCheckBox_1);

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.err.println("button");
				registrar(asunto_text.getText());
			}

		});
		btnNewButton.setBounds(170, 453, 228, 35);
		add(btnNewButton);

		asunto_text.setBounds(10, 366, 548, 21);
		add(asunto_text);
		asunto_text.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Asunto");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 343, 548, 21);
		add(lblNewLabel_1);
		
		
		Informacion.setHorizontalAlignment(SwingConstants.CENTER);
		Informacion.setBounds(10, 504, 548, 21);
		Informacion.setVisible(false);
		add(Informacion);

	}

	void buscador() {
		// System.err.println("numero recibido");
		// System.out.println(client);
		vendedor.buscador(client, 7);
		Timer myTimer = new Timer(10000, generar_tabla());
		myTimer.setRepeats(false); // asegurarse de que el Timer solo se ejecute una vez
		myTimer.start(); // iniciar el Timer
	}

	public ActionListener generar_tabla() {
		String aux[][] = new String[vendedor.getCarro().size()][7];
		if (vendedor.getCarro().size() != 0) {
			for (int i = 0; i < vendedor.getCarro().size(); i++) {
				aux[i][0] = String.valueOf(vendedor.getCarro().get(i).getId());
				aux[i][1] = vendedor.getCarro().get(i).getPatente();
				aux[i][2] = vendedor.getCarro().get(i).getMarca();
				aux[i][3] = vendedor.getCarro().get(i).getModelo();
				aux[i][4] = String.valueOf(vendedor.getCarro().get(i).getAno());
				aux[i][5] = String.valueOf(vendedor.getCarro().get(i).getIdcliente());
				aux[i][6] = vendedor.getCarro().get(i).getPrecio();
				// System.err.println(vendedor.getCarro().get(i));
			}
		} else {
			aux = autos;
		}
		table.removeAll();
		datatable modelo_new = new datatable(aux, nombre);
		table.setModel(modelo_new);
		revalidate();
		repaint();
		return null;
	}

	private void registrar(String asunt) {
		System.err.println(asunt + " registrar");
		boolean floating = false;
		String client_auto = seleccionarauto();
		if (client_auto == null) {
			client_auto = "0";
		}

		if (client_auto == "-1") {

		} else {

			for (int i = 0; i < vendedor.getCarro().size(); i++) {
				System.err.println(client_auto + " " + vendedor.getCarro().get(i).getId());
				if (client_auto.equals(String.valueOf(vendedor.getCarro().get(i).getId()))) {
					vendedor.setVehiculo(vendedor.getCarro().get(i));
					floating = true;
				}
			}
			System.err.println(floating);
			try {
				if (floating) {
					if (asunt.isEmpty()) {
						if (z) {
							vendedor.informe_cargar("reparar auto", 1);
						} else {
							vendedor.informe_cargar("restaurar auto", 2);
						}
					} else {
						if (z) {
							vendedor.informe_cargar(asunt, 1);
						} else {
							vendedor.informe_cargar(asunt, 2);
						}
					}
				}
			} catch (Exception e) {
				System.err.println(e);
			}

		}
	}

	public String seleccionarauto() {
		System.err.println(table.getModel().getValueAt(table.getSelectedRow(), 0).toString());
		return table.getModel().getValueAt(table.getSelectedRow(), 0).toString();
	}
}
