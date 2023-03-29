package test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.junit.jupiter.api.BeforeEach;

import controladores.VentanaMatrizControlador;

public class Testeo {
	private JTable tablaFull;
	private JTable tablaIncorrecta;
	private JTable tablaVacia;
	private JLabel[] labelsFilas;
	private JLabel[] labelsColumnas;
	
	@BeforeEach
	public void setUp() throws Exception {
		tablaFull = new JTable();
		tablaFull.setFont(new Font("Tahoma", Font.PLAIN, 24));
		tablaFull.setFillsViewportHeight(true);
		tablaFull.setModel(new DefaultTableModel(
			new Integer[][] {
				{2, 1, 1, 1},
				{1, 2, 3, 1},
				{2, 4, 3, 3},
				{2, 2, 2, 1},
			},
			new String[] {
				"New column", "New column", "New column", "New column"
			}
		));
		
		tablaVacia = new JTable();
		tablaVacia.setFont(new Font("Tahoma", Font.PLAIN, 24));
		tablaVacia.setFillsViewportHeight(true);
		tablaVacia.setModel(new DefaultTableModel(
			new Integer[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column"
			}
		));
		
		tablaIncorrecta = new JTable();
		tablaIncorrecta.setFont(new Font("Tahoma", Font.PLAIN, 24));
		tablaIncorrecta.setFillsViewportHeight(true);
		tablaIncorrecta.setModel(new DefaultTableModel(
			new Integer[][] {
				{2, 3, 4, 2},
				{1, 5, 3, 1},
				{2, 4, 3, 3},
				{2, 2, 2, 1},
			},
			new String[] {
				"New column", "New column", "New column", "New column"
			}
		));
		
		labelsFilas = new JLabel[4];
		labelsColumnas = new JLabel[4];
		labelsFilas[0] = new JLabel("5");
		labelsFilas[0].setFont(new Font("Tahoma", Font.PLAIN, 22));
		labelsFilas[0].setBounds(410, 100, 40, 50);
		
		labelsFilas[1] = new JLabel("7");
		labelsFilas[1].setFont(new Font("Tahoma", Font.PLAIN, 22));
		labelsFilas[1].setBounds(410, 160, 40, 50);
		
		labelsFilas[2] = new JLabel("12");
		labelsFilas[2].setFont(new Font("Tahoma", Font.PLAIN, 22));
		labelsFilas[2].setBounds(410, 220, 40, 50);
		
		labelsFilas[3] = new JLabel("7");
		labelsFilas[3].setFont(new Font("Tahoma", Font.PLAIN, 22));
		labelsFilas[3].setBounds(410, 280, 40, 50);
		
		labelsColumnas[0] = new JLabel("7");
		labelsColumnas[0].setFont(new Font("Tahoma", Font.PLAIN, 22));
		labelsColumnas[0].setBounds(175, 335, 40, 50);
		
		labelsColumnas[1] = new JLabel("9");
		labelsColumnas[1].setFont(new Font("Tahoma", Font.PLAIN, 22));
		labelsColumnas[1].setBounds(235, 335, 40, 50);
		
		labelsColumnas[2] = new JLabel("9");
		labelsColumnas[2].setFont(new Font("Tahoma", Font.PLAIN, 22));
		labelsColumnas[2].setBounds(295, 335, 40, 50);
		
		labelsColumnas[3] = new JLabel("6");
		labelsColumnas[3].setFont(new Font("Tahoma", Font.PLAIN, 22));
		labelsColumnas[3].setBounds(355, 335, 40, 50);
	}
	
	//Verificar hayVacias
	@org.junit.jupiter.api.Test
	public void noHayVaciasDevuelveTrue() {
		assertTrue(VentanaMatrizControlador.noHayVacias(tablaFull));
	}
	@org.junit.jupiter.api.Test
	public void noHayVaciasDevuelveFalse() {
		assertFalse(VentanaMatrizControlador.noHayVacias(tablaVacia));
	}
	
	//Verificar suma
	@org.junit.jupiter.api.Test
	public void sumaDevuelveTrue() {
		boolean verif = true;
		for (int i = 0; i < tablaFull.getRowCount(); i++) {
			verif = VentanaMatrizControlador.filaSumaResultado(tablaFull, labelsFilas, i) && 
					VentanaMatrizControlador.columnaSumaResultado(tablaFull, labelsColumnas, i);
		}
		assertTrue(verif);
	}
	@org.junit.jupiter.api.Test
	public void sumaDevuelveFalse() {
		boolean verif = true;
		for (int i = 0; i < tablaIncorrecta.getRowCount(); i++) {
			verif = verif && VentanaMatrizControlador.filaSumaResultado(tablaIncorrecta, labelsFilas, i) && 
					VentanaMatrizControlador.columnaSumaResultado(tablaIncorrecta, labelsColumnas, i);
		}
		assertFalse(verif);
	}
}
