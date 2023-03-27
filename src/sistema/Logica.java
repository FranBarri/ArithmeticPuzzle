package sistema;

import javax.swing.JLabel;
import javax.swing.JTable;

public class Logica {

	public boolean filaSumaResultado(JTable table,JLabel resultado,int fila) {
		Integer suma = 0;
	    int nroFil = table.getRowCount();
		for (int i = 0; i < nroFil; i++) {
            Integer valor = Integer.parseInt(table.getValueAt(fila, i).toString());
			suma+=valor;
		}
		if(suma.toString().equals(resultado.getText())) {
			return true;
		}
		return false;
	}
	
	public boolean columnaSumaResultado(JTable table,JLabel resultado,int columna) {
		Integer suma = 0;
	    int numCols = table.getColumnCount();
		for (int i = 0; i < numCols; i++) {
            Integer valor = Integer.parseInt(table.getValueAt(i, columna).toString());
			suma+=valor;
		}
		if(suma.toString().equals(resultado.getText())) {
			return true;
		}
		return false;
	}
	
	public boolean validar(JTable table) {
	    int nroFil = table.getRowCount();
	    int nroCol= table.getColumnCount();
	    for (int i = 0; i < nroFil; i++) {
	        for (int j = 0; j < nroCol; j++) {
	            Object valor = table.getValueAt(i, j);
	            if (valor == null || valor.toString().isEmpty()) {
	                return false;
	            }
	        }
	    }
	    int numElements = table.getModel().getRowCount() * table.getModel().getColumnCount();
	    return nroFil > 0 && nroCol > 0 && nroFil * nroCol == numElements;
	}

}
