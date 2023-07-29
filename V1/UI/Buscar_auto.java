package UI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import Logica.Cliente;
import Logica.Vendedor;
import conexion.Conexion;
import negocio.Verificar;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Enumeration;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultCellEditor;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JSeparator;
import javax.swing.UIManager;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.TableModelEvent;
import javax.swing.plaf.basic.BasicTableUI;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

public class Buscar_auto extends JPanel {
	private JTable table;
	private JTable anadertable;

	JScrollPane tablecontainer = new JScrollPane();

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

	String value[] = new String[6];
	int floating = -1;
	String buscar_dato = null;

	/**
	 * Create the panel.
	 * 
	 * @param vendedor
	 */
	public Buscar_auto() {
		setLayout(null);
		
		t();
		JTextPane textPane = new JTextPane();
		JLabel lblNewLabel = new JLabel("Resultados");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(236, 246, 85, 21);
		add(lblNewLabel);

		JButton btnNewButton = new JButton("ano");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				floating = 0;
				buscar_dato = textPane.getText();
				buscar();
			}
		});
		btnNewButton.setBounds(22, 117, 85, 21);
		add(btnNewButton);

		JButton btnNewButton_1 = new JButton("modelo");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				floating = 1;
				buscar_dato = textPane.getText();
				buscar();
			}
		});
		btnNewButton_1.setBounds(129, 117, 85, 21);
		add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("marca");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				floating = 2;
				buscar_dato = textPane.getText();
				buscar();
			}

		});
		btnNewButton_2.setBounds(236, 117, 85, 21);
		add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("Precio");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				floating = 3;
				buscar_dato = textPane.getText();
				buscar();
			}
		});
		btnNewButton_3.setBounds(343, 117, 85, 21);
		add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("Patente");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				floating = 5;
				buscar_dato = textPane.getText();
				buscar();
			}
		});
		btnNewButton_4.setBounds(450, 117, 85, 21);
		add(btnNewButton_4);

		textPane.setBounds(33, 60, 486, 30);
		add(textPane);

		JLabel lblNewLabel_2 = new JLabel("Buscar auto");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_2.setBounds(0, 10, 552, 40);
		add(lblNewLabel_2);

		tablecontainer.setBounds(22, 277, 513, 275);
		add(tablecontainer);

		table = new JTable();
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
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});

		tablecontainer.setViewportView(table);
		table.setRowSelectionAllowed(false);
		table.setToolTipText("");

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(82, 173, 98, 75);
		add(scrollPane_1);

		JList list = new JList();
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setLayoutOrientation(JList.VERTICAL_WRAP);
		list.setValueIsAdjusting(true);
		scrollPane_1.setColumnHeaderView(list);
		list.setModel(new AbstractListModel() {
			String[] values = value;

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});

		JButton btnNewButton_5 = new JButton("buscar por accion");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				floating = 6;
				buscar_dato = String.valueOf(list.getSelectedIndex());
				buscar();
			}
		});
		btnNewButton_5.setBounds(190, 199, 125, 21);
		add(btnNewButton_5);

		JTextPane txtpnBuscarPorAccion = new JTextPane();
		txtpnBuscarPorAccion.setText("buscar por accion");
		txtpnBuscarPorAccion.setEditable(false);
		txtpnBuscarPorAccion.setBounds(22, 191, 60, 40);
		add(txtpnBuscarPorAccion);

	}

	public void t() {
		StringBuilder sb = new StringBuilder();
		try {

			String sql = "SELECT accion.accion FROM `accion`;";
			stmt = conexion.prepareStatement(sql);
			ResultSet result = stmt.executeQuery();
			while (result.next()) {
				String valued = result.getString("accion");
				sb.append(valued).append(",");
			}
			System.err.println(sb);
		} catch (Exception e) {
			// TODO: handle exception
		}
		int j = 0;
		for (int i = 0; i < sb.length(); i++) {
			if (value[j] == null) {
				value[j] = "";
			}
			if (sb.charAt(i) != ',') {
				value[j] = value[j] + sb.charAt(i);
			} else {
				j++;
			}
		}
	}

	public void buscar() {
		vendedor.buscar_usuarios();
		Verificar validar = new Verificar();
		int errors = 0;
		
		if (buscar_dato.isBlank()) {
			errors++;
		}
		
		switch (floating) {
		case 0:
		case 4:
		case 3:
			for (int i = 0; i < buscar_dato.length(); i++) {
				if (!Character.isDigit(buscar_dato.charAt(i))) {
				errors++;
			}
			}
			
			break;
			
		case 1:
		case 2:
		case 5:
			for (int i = 0; i < buscar_dato.length(); i++) {
				char q = buscar_dato.charAt(i);
				if ((q < 'a' || q > 'z') && (q < 'A' || q > 'Z') && q != '\u00e1' && q != '\u00e9' && q != '\u00ed'
						&& q != '\u00f3' && q != '\u00fa' && q != '\u00c1' && q != '\u00c9' && q != '\u00cd'
						&& q != '\u00d3' && q != '\u00da' && q != '\u00f1' && q != '\u00d1' && Character.isDigit(q)) {
					errors++;
				}
			}
			
			break;
		case 6 :
			errors=0;
			break;
		default:
			errors++;
			break;
		}
		System.err.println(errors);

		if (errors == 0) {
			if (vendedor.buscador(buscar_dato, floating)) {
				table_generator();
			}
				
		}else {
			//nostrar error intentando filtrar
		}
		
	}

	public void table_generator() {

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
					aux[i][5]="automerges";
				}else {
					for (int j = 0; j < nombres.size(); j++) {
						
							
							if (aux[i][5].equals(nombres.get(j).getId())) {
								aux[i][5]=nombres.get(j).getNombre() +" "+ nombres.get(j).getApellido(); 
								System.err.println(nombres.get(j));
							}

						
					}
				}
				System.err.println(nombres.get(i).getId());
			}
			
			table.removeAll();
			tablecontainer.remove(anadertable);
			datatable modelo_new = new datatable(aux, nombre);
			table.setModel(modelo_new);
			tablecontainer.add(table);
			tablecontainer.setViewportView(table);
		} else {
			tablecontainer.remove(table);
			anadertable = new JTable();
			tablecontainer.add(anadertable);
			tablecontainer.setViewportView(anadertable);
			anadertable.setRowSelectionAllowed(false);
			anadertable.setToolTipText("");
			anadertable.setModel(nomodelo);

		}
		tablecontainer.revalidate();
		tablecontainer.repaint();
		revalidate();
		repaint();
	}

}
