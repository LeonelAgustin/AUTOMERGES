package UI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;

import Logica.Vendedor;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.html.HTML;

import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class Vender_pieza extends JPanel {
	private JTable table;
	private Vendedor vendedor;
	private String client;
	protected String cantidad;

	public String getCantidad() {
		return cantidad;
	}

	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}

	String nombre[] = { "nombre", "stock", "precio" };
	String piezas[][] = { { " ", " ", " " }, { " ", " ", " " }, { " ", " ", " " }, { " ", " ", " " }, { " ", " ", " " },
			{ " ", " ", " " }, { " ", " ", " " }, { " ", " ", " " }, { " ", " ", " " }, { " ", " ", " " }, };
	private JTextField textField;

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public Vender_pieza() {
		setLayout(null);
		textField = new JTextField();
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(60, 192, 445, 189);
		add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(piezas, nombre));
		scrollPane.setViewportView(table);

		JLabel lblNewLabel = new JLabel("Vender Pieza");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(42, 28, 463, 39);
		add(lblNewLabel);

		JButton btnNewButton = new JButton("Vender pieza");
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("unlikely-arg-type")
			public void actionPerformed(ActionEvent e) {
				setCantidad(textField.getText());
				if (!getCantidad().isEmpty()) {
					int numero = Integer.parseInt(getCantidad());
					if (numero > 0) {
						if (client != null) {
							if (!client.isEmpty()) {
								if (!table.getModel().getValueAt(table.getSelectedRow(), 0).toString().equals("-1")) {
								for (int i = 0; i < vendedor.getPiezas().size(); i++) {
									String val=	seleccionarauto();
									if (vendedor.getPiezas().get(i).equals(val)) {
										vendedor.setPieza(vendedor.getPiezas().get(i));
									}
								}
								if (Integer.parseInt(seleccionarstock())>=Integer.parseInt(cantidad)) {
									vender_parte(numero);
								}
								
								
								}
							}
						}
					} else {
						System.err.println("tiene que se mayor a 0");
					}

				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(60, 480, 445, 39);
		add(btnNewButton);

		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setText("0");
		textField.setBounds(60, 423, 445, 25);
		add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Cantidad");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(60, 391, 445, 30);
		add(lblNewLabel_1);
	}

	public void generar_tabla() {
		vendedor.getPiezas().clear();
		boolean r = vendedor.buscar_pieza();
		System.err.println(r);
		String aux[][] = new String[vendedor.getPiezas().size()][3];
		if (vendedor.getPiezas().size() != 0) {
			for (int i = 0; i < vendedor.getPiezas().size(); i++) {
				aux[i][0] = vendedor.getPiezas().get(i).getNombre_pieza();
				aux[i][2] = String.valueOf(vendedor.getPiezas().get(i).getPrecio());
				aux[i][1] = String.valueOf(vendedor.getPiezas().get(i).getNumero_de_sere());
				// System.err.println(vendedor.getCarro().get(i));
			}
			for (int i = 0; i < aux.length; i++) {
				String aux2 = vendedor.res(Integer.parseInt(aux[i][1]));
				
				if (aux2.isBlank()) {
					aux[i][1] = "no encontrado";
				} else {
					aux[i][1] = aux2; 
				}
			}
			
			for (int i = 0; i < aux.length; i++) {
				if (!aux[i][1].equals("no encontrado")) {
					
				}
			}
			
		} else {
			aux = piezas;
		}

		table.removeAll();
		datatable modelo_new = new datatable(aux, nombre);
		table.setModel(modelo_new);
		revalidate();
		repaint();
	}

	public void vender_parte(int end_of_za_warudo) {
		for (int i = 0; i < vendedor.getClientes().size(); i++) {
			if (vendedor.getClientes().get(i).getId().equals(client)) {
				vendedor.setCliente(vendedor.getClientes().get(i));
			}
		}
		vendedor.vender_auto(false, end_of_za_warudo);
		if (!seleccionarstock().equals("no encontrado")) {
			int send= Integer.parseInt(cantidad)-Integer.parseInt(seleccionarstock());
			vendedor.registrar_ventap(send);
		}
		generar_tabla();
	}
	
	public String seleccionarauto() {
		//System.err.println(table.getModel().getValueAt(table.getSelectedRow(), 0).toString());
		String t;
		try {
			 t =table.getModel().getValueAt(table.getSelectedRow(), 0).toString();
		} catch (Exception e) {
			 t = "-1";
		}
		
		
		return t;
	}
	public String seleccionarstock() {
		//System.err.println(table.getModel().getValueAt(table.getSelectedRow(), 0).toString());
		String t;
		try {
			 t =table.getModel().getValueAt(table.getSelectedRow(), 1).toString();
		} catch (Exception e) {
			 t = "-1";
		}
		return t;
	}
}
