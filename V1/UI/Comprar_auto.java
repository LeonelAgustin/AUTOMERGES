package UI;

import javax.swing.JPanel;

import Logica.Cliente;
import Logica.Vendedor;
import conexion.Conexion;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JEditorPane;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Iterator;
import java.util.LinkedList;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class comprar_auto extends JPanel {

	private JTable table;
	private JTable anadertable = new JTable();
	JLabel lblNewLabel_2 = new JLabel("error no hay autos a la venta");
	Cliente cliente = new Cliente(null, null, null, null, null);


	private String client;

	
	
	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}
	
	JScrollPane tablecontainer_1 = new JScrollPane();

	Conexion con = new Conexion();

	Connection conexion = con.conectar();

	PreparedStatement stmt;

	String nombre[] = { "id", "patene", "Marca", "modelo", "ano", "cliente", "precio" };
	String autos[][] = { { " ", " ", " ", " ", " ", " " }, { " ", " ", " ", " ", " ", " " },
			{ " ", " ", " ", " ", " ", " " }, { " ", " ", " ", " ", " ", " " }, { " ", " ", " ", " ", " ", " " },
			{ " ", " ", " ", " ", " ", " " }, { " ", " ", " ", " ", " ", " " }, { " ", " ", " ", " ", " ", " " },
			{ " ", " ", " ", " ", " ", " " }, { " ", " ", " ", " ", " ", " " } };

	datatable modelo = new datatable(autos, nombre);

	String noauto[][] = { { "no hay datos", " ", " ", " ", " ", " " } };

	datatable nomodelo = new datatable(noauto, nombre);

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
		addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				vendedor.buscar_auto(true);
			}
		});
		
		
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Comprar auto");
		lblNewLabel.setBounds(10, 10, 513, 48);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNewLabel);
		
	
		tablecontainer_1.setViewportBorder(null);
		tablecontainer_1.setBounds(25, 184, 498, 188);
		add(tablecontainer_1);
		
		table = new JTable();
		table.setForeground(SystemColor.desktop);
		table.setModel(new DefaultTableModel(
				new Object[][] {
					{" ", " ", " ", " ", " ", " "},
					{" ", " ", " ", " ", " ", " "},
					{" ", " ", " ", " ", " ", " "},
					{" ", " ", " ", " ", " ", " "},
					{" ", " ", " ", " ", " ", " "},
					{" ", " ", " ", " ", " ", " "},
					{" ", " ", " ", " ", " ", " "},
					{" ", " ", " ", " ", " ", " "},
					{" ", " ", " ", " ", " ", " "},
					{" ", " ", " ", " ", " ", " "},
				},
				new String[] {
					"id", "patene", "Marca", "modelo", "ano", "cliente"
				}
			));
		tablecontainer_1.setViewportView(table);
		
		JButton btnNewButton = new JButton("comprar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!seleccionarauto().equals("-1")) {
					for (int i = 0; i < vendedor.getCarro().size(); i++) {
						if (seleccionarauto().equals(String.valueOf(vendedor.getCarro().get(i).getId()))) {
							vendedor.setVehiculo(vendedor.getCarro().get(i));
							vendedor.registrarcompra();
							table_generator();
						}
					}
				}
			}
		});
		btnNewButton.setBounds(158, 430, 217, 32);
		add(btnNewButton);

	}
	
	public void table_generator() {
		vendedor.buscar_usuarios();
		vendedor.buscador(client, 8);
		// {"id", "patene", "Marca", "modelo", "ano", "cliente" ,"precio"};
		String aux[][] = new String[vendedor.getCarro().size()][7];
		System.err.println(vendedor.getCarro().size());

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

			LinkedList<Cliente> nombres = vendedor.getClientes();
			for (int i = 0; i < aux.length; i++) {
				if (aux[i][5].equals("0")) {
					aux[i][5] = "automerges";
				} else {
					for (int j = 0; j < nombres.size(); j++) {

						if (aux[i][5].equals(nombres.get(j).getId())) {
							aux[i][5] = nombres.get(j).getNombre() + " " + nombres.get(j).getApellido();
							System.err.println(nombres.get(j));
						}

					}
				}
				System.err.println(nombres.get(i).getId());
			}

			table.removeAll();
			tablecontainer_1.remove(anadertable);
			datatable modelo_new = new datatable(aux, nombre);
			table.setModel(modelo_new);
			tablecontainer_1.add(table);
			tablecontainer_1.setViewportView(table);
		} else {
			System.err.println("anothercreate");
			tablecontainer_1.remove(table);
			anadertable = new JTable();
			tablecontainer_1.add(anadertable);
			tablecontainer_1.setViewportView(anadertable);
			anadertable.setRowSelectionAllowed(false);
			anadertable.setToolTipText("");
			anadertable.setModel(nomodelo);

		}
		tablecontainer_1.revalidate();
		tablecontainer_1.repaint();
		revalidate();
		repaint();
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
}
