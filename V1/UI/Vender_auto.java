package UI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.SwingConstants;

import Logica.Cliente;
import Logica.Vendedor;
import conexion.Conexion;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Iterator;
import java.util.LinkedList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Vender_auto extends JPanel {
	private JTable table;
	private JTable anadertable = new JTable();
	JLabel lblNewLabel_2 = new JLabel("error no hay autos a la venta");
	Cliente cliente = new Cliente(null, null, null, null, null);

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

	private String client, nombre_apellido = "", nombrec, apellidoc, dni;

	public String getNombrec() {
		return nombrec;
	}

	public void setNombrec(String nombrec) {
		this.nombrec = nombrec;
	}

	public String getApellidoc() {
		return apellidoc;
	}

	public void setApellidoc(String apellidoc) {
		this.apellidoc = apellidoc;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	JLabel lblNewLabel_1 = new JLabel("cliente seleccionado:");

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public String getNombre_apellido() {
		return nombre_apellido;
	}

	public void setNombre_apellido(String nombre_apellido) {
		this.nombre_apellido = nombre_apellido;
	}

	/**
	 * Create the panel.
	 */
	public Vender_auto() {

		setLayout(null);

		JLabel lblNewLabel = new JLabel("Vender Auto");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(140, 29, 264, 39);
		add(lblNewLabel);

		tablecontainer_1.setBounds(29, 190, 495, 272);
		add(tablecontainer_1);

		table = new JTable();
		tablecontainer_1.setViewportView(table);
		table.setModel(modelo);

		JButton btnNewButton = new JButton("Vender");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int f = 0;
				boolean found = false;
				if (client != null) {
					if (!client.isEmpty()) {
						if (!client.contentEquals("-1")) {
							if (seleccionarauto() != null) {
								
									if (seleccionarauto() != "-1") {
										System.err.println("verificador");
										String v = seleccionarauto();
										for (int z = 0; z < v.length(); z++) {
											char y = v.charAt(z);
											if ((y < '0' || y > '9')) {
												f++;
											}
										}
										System.err.println(f);
										if (f == 0) {
											System.err.println("is numero");
											
											for (int i = 0; i < vendedor.getCarro().size(); i++) {
												if (vendedor.getCarro().get(i).getId() == Integer
														.parseInt(seleccionarauto())) {
													vendedor.setVehiculo(vendedor.getCarro().get(i));
													found = true;
												}
											}
											if (found) {
												cliente.setId(client);
												cliente.setApellido(apellidoc);
												cliente.setDni(dni);
												cliente.setNombre(nombrec);
												vendedor.setCliente(cliente);
												registrar_venta();
											}
										}
									}
								
							}
						}
					}
				}
				if (f==0 && !found ) {
					lblNewLabel_2.setVisible(true);
				}else {
					lblNewLabel_2.setVisible(false);
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(178, 498, 190, 39);
		add(btnNewButton);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(29, 156, 502, 24);
		add(lblNewLabel_1);
		
		
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(29, 472, 495, 16);
		lblNewLabel_2.setVisible(false);
		add(lblNewLabel_2);

	}

	public void table_generator() {
		vendedor.buscar_anuncios();
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

	void title() {
		lblNewLabel_1.setText("cliente seleccionado: " + nombre_apellido);
	}

	public String seleccionarauto() {
		return table.getModel().getValueAt(table.getSelectedRow(), 0).toString();
	}

	private void registrar_venta() {
		vendedor.registrar_venta();
		System.err.println("registro terminado");
		vendedor.vender_auto(true, 0);
		System.err.println("registro terminado 2");
		table_generator();
	}
}
