package UI;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import Logica.Cliente;
import Logica.Vendedor;

public class seleccionar_auto extends JPanel {

	String cliente_id;
	private JTable table;
	private Vendedor vendedor;
	
	
	public Vendedor getVendedor() {
		return vendedor;
	}
		public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}
		String nombre[] = {"id", "patene", "Marca", "modelo", "ano", "cliente" ,"precio"};
		String autos[][] = {{" "," "," "," "," "," "},{" "," "," "," "," "," "},{" "," "," "," "," "," "},{" "," "," "," "," "," "},{" "," "," "," "," "," "},{" "," "," "," "," "," "},{" "," "," "," "," "," "},{" "," "," "," "," "," "},{" "," "," "," "," "," "},{" "," "," "," "," "," "}};

	datatable modelo = new datatable(autos, nombre);
	String value[] = new String[5];
	int floating = -1;
	String buscar_dato = null;
	/**
	 * Create the panel.
	 */
	public seleccionar_auto() {

		//vendedor.buscar_auto(true);
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
			
			
		
		JLabel lblNewLabel = new JLabel("Seleccionar auto");
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
		String aux[][]= new String[vendedor.getCarro().size()][7];
		for (int i = 0; i < vendedor.getCarro().size(); i++) {
			aux[i][0]=String.valueOf(vendedor.getCarro().get(i).getId());
			aux[i][1]=vendedor.getCarro().get(i).getPatente();
			aux[i][2]=vendedor.getCarro().get(i).getMarca();
			aux[i][3]=vendedor.getCarro().get(i).getModelo();
			aux[i][4]=String.valueOf(vendedor.getCarro().get(i).getAno());
			aux[i][5]=String.valueOf(vendedor.getCarro().get(i).getIdcliente());
			aux[i][6]=vendedor.getCarro().get(i).getPrecio();
		//System.err.println(vendedor.getCarro().get(i));
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

}
