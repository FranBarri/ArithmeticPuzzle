package controladores;

import javax.swing.JLabel;
import javax.swing.JTable;

import sistema.Dificultad;
import ventanas.VentanaMatriz;

public class VentanaMatrizControlador {
	
	public static VentanaMatriz ventanaMatriz = new VentanaMatriz();
	
	//Eventos
	public static void cerrar() {
		ventanaMatriz.setVisible(false);
	}
	
	public static void mostrar() {
		ventanaMatriz.setVisible(true);
	}
		
	//Anadir timer para ver cuanto tarda en resolver matriz
	
	/*
	 * Valida que la tabla no tenga celdas nulas (celdas no editadas)
	 * y celdas vacias luego de editarlas y borrar su valor.
	 */
	public static boolean noHayVacias(JTable table) {
	    int nroFil = table.getRowCount();
	    int nroCol= table.getColumnCount();
	    boolean ret = true;
	    for (int i = 0; i < nroFil; i++) {
	        for (int j = 0; j < nroCol; j++) {
	            Object valor = table.getValueAt(i, j);
	            if (valor == null) {
	            	ret = false;
	            } else {
	            	ret = ret && !valor.toString().isEmpty();
	            }
	        }
	    }
	    return ret;
	}
	
	public static boolean filaSumaResultado(JTable table,JLabel[] resultado,int fila) {
		Integer suma = 0;
	    int nroFil = table.getRowCount();
		for (int i = 0; i < nroFil; i++) {
            Integer valor = Integer.parseInt(table.getValueAt(fila, i).toString());
			suma+=valor;
		}
		for (JLabel lbl : resultado) {
			if (lbl == null || lbl.toString().isEmpty()) {
				return false;
			}
			if(suma.toString().equals(lbl.getText())) {
				return true;
			}			
		}
		return false;
	}
	
	public static boolean columnaSumaResultado(JTable table,JLabel[] resultado,int columna) {
		Integer suma = 0;
	    int numCols = table.getColumnCount();
		for (int i = 0; i < numCols; i++) {
            Integer valor = Integer.parseInt(table.getValueAt(i, columna).toString());
			suma+=valor;
		}
		for (JLabel lbl : resultado) {
			if (lbl == null || lbl.toString().isEmpty()) {
				return false;
			}
			if(suma.toString().equals(lbl.getText())) {
				return true;
			}
		}
		return false;
	}
	
	public static Integer lblText(JLabel label) {
		Integer valor = Integer.parseInt(label.getText().toString());
		return valor;
	}
	
	public static void setDificultad(Dificultad dificultad) {
		switch(dificultad) {
		case FACIL:
			ventanaMatriz.iniciarFacil();
			break;
		case MEDIO:
			ventanaMatriz.iniciarMedio();
			break;
		case DIFICIL:
			ventanaMatriz.iniciarDificil();
			break;
		}
		ventanaMatriz.setVisible(true);

	}
}
