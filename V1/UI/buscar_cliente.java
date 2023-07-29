package UI;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import Logica.Vehiculo;
import Logica.Vendedor;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.table.DefaultTableModel;

public class buscar_cliente extends JPanel {
	String cliente_id;
	private JTable table;
	private Vendedor vendedor;
	
	
	public Vendedor getVendedor() {
		return vendedor;
	}
		public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}
	String nombre[] = {"id", "Nombre", "Apellido", "Dni"};
	String autos[][] = {{" "," "," "," "},{" "," "," "," "},{" "," "," "," "},{" "," "," "," "},{" "," "," "," "},{" "," "," "," "},{" "," "," "," "}};
	datatable modelo = new datatable(autos, nombre);
	String value[] = new String[5];
	int floating = -1;
	String buscar_dato = null;
	/**
	 * Create the panel.
	 */
	public buscar_cliente() {
		addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
			}
		});
		
		
		
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 98, 548, 394);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(modelo);
		table.setCellSelectionEnabled(true);
		scrollPane.setViewportView(table);
			
			
		
		JLabel lblNewLabel = new JLabel("Buscador de usuarios");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 30, 548, 49);
		add(lblNewLabel);
		
		
	}
	
	

	public void obtener_seleccion() {
		vendedor.buscar_usuarios();
		Timer myTimer = new Timer(10000, generar_tabla());
		myTimer.setRepeats(false); // asegurarse de que el Timer solo se ejecute una vez
		myTimer.start(); // iniciar el Timer
	}
	public ActionListener generar_tabla() {
		String aux[][] = new String[vendedor.getClientes().size()][4];
		for (int i = 0; i < vendedor.getClientes().size(); i++) {
			aux[i][0]=vendedor.getClientes().get(i).getId();
			aux[i][1]=vendedor.getClientes().get(i).getNombre();
			aux[i][2]=vendedor.getClientes().get(i).getApellido();
			aux[i][3]=vendedor.getClientes().get(i).getDni();
			System.err.println(aux);
		}
		table.removeAll();
		datatable modelo_new = new datatable(aux, nombre);
		table.setModel(modelo_new);
		revalidate();
		repaint();
		return null;
	}
	
	public String seleccionarcliente() {
		return  table.getModel().getValueAt(table.getSelectedRow(),0).toString();
	}

	public String seleccionarcliente_nombre() {
		return  table.getModel().getValueAt(table.getSelectedRow(),1).toString()  + " " + table.getModel().getValueAt(table.getSelectedRow(),2).toString();
	}
	
	public String seleccionarnombre() {
		return  table.getModel().getValueAt(table.getSelectedRow(),0).toString();
	}
	
	public String seleccionarapellido() {
		return  table.getModel().getValueAt(table.getSelectedRow(),0).toString();
	}
	
	public String seleccionardni() {
		return  table.getModel().getValueAt(table.getSelectedRow(),0).toString();
	}
}
