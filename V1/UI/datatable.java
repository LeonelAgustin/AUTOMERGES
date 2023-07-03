package UI;

import javax.swing.table.AbstractTableModel;

public class datatable extends AbstractTableModel {

	
	
	// crear modelo de tabla personalizado

	    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private Object[][] data;
	    private String[] columnas;
	    public datatable(Object[][] data, String[] columnas) {
	        this.data = data;
	        this.columnas = columnas ;
	    }
	    @Override
	    public String getColumnName(int column) {
	        return columnas[column];
	    }
	    
	    @Override
	    public int getRowCount() {
	        return data.length;
	    }
	    @Override
	    public int getColumnCount() {
	        return data[0].length;
	    }
	    @Override
	    public Object getValueAt(int rowIndex, int columnIndex) {
	        return data[rowIndex][columnIndex];
	    }
	

	

	

}
