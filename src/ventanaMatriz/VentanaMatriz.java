package ventanaMatriz;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.imageio.ImageIO;

public class VentanaMatriz {

	private JFrame frame;
	private JScrollPane scrollPane;
	private JTable table;
	private JLabel[] labelsFilas;
	private JLabel[] labelsColumnas;
	private JButton btnVerificar;
	private JButton btnSuma;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaMatriz window = new VentanaMatriz();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaMatriz() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 337);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		inciarInterfaz(); //Su proposito es organizar mejor el codigo
		
	}

	private void inciarInterfaz() {
		JLabel lblMatriz = new JLabel("MATRIZ");
		lblMatriz.setHorizontalAlignment(SwingConstants.CENTER);
		lblMatriz.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblMatriz.setBounds(0, 0, 434, 32);
		frame.getContentPane().add(lblMatriz);
		
		//Cargar icono de ventana
		try {
		File imagen = new File("C:\\Users\\ftbar\\eclipse-workspace\\trabajo-practico-1-programacion-3\\imagenes\\icono.png");
		Image icono = ImageIO.read(imagen);
		frame.setIconImage(icono);
		} catch (Exception e) {
			System.out.println("Error cargando imagen: " + e.getMessage());
		}
		
		frame.setTitle("Sudoku Raro!");
		frame.setLocationRelativeTo(null); //Centra la ventana en pantalla
		frame.setResizable(false);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(127, 43, 185, 161);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 16));
		table.setFillsViewportHeight(true);
		table.setModel(new DefaultTableModel(
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
		// Cosas aniadidas manualmente para mejorar lo visual de la Table
		table.getTableHeader().setVisible(false);
		table.setRowHeight(40);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		for (int i = 0; i < table.getColumnCount(); i++) {
		    table.getColumnModel().getColumn(i).setPreferredWidth(40);
		    table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
		}
		
		scrollPane.setColumnHeaderView(table);
		
		labelsFilas = new JLabel[4];
		labelsColumnas = new JLabel[4];
		//Estas son las sumas, el numero puede ser modificado manualmente con labelname.setText("nuevo valor").
		labelsFilas[0] = new JLabel("5");
		labelsFilas[0].setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelsFilas[0].setBounds(325, 58, 9, 14);
		frame.getContentPane().add(labelsFilas[0]);
		
		labelsFilas[1] = new JLabel("12");
		labelsFilas[1].setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelsFilas[1].setBounds(325, 92, 18, 20);
		frame.getContentPane().add(labelsFilas[1]);
		
		labelsFilas[2] = new JLabel("5");
		labelsFilas[2].setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelsFilas[2].setBounds(325, 135, 9, 14);
		frame.getContentPane().add(labelsFilas[2]);
		
		labelsFilas[3] = new JLabel("7");
		labelsFilas[3].setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelsFilas[3].setBounds(325, 177, 9, 14);
		frame.getContentPane().add(labelsFilas[3]);
		
		labelsColumnas[0] = new JLabel("7");
		labelsColumnas[0].setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelsColumnas[0].setBounds(147, 215, 9, 14);
		frame.getContentPane().add(labelsColumnas[0]);
		
		labelsColumnas[1] = new JLabel("9");
		labelsColumnas[1].setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelsColumnas[1].setBounds(190, 215, 9, 14);
		frame.getContentPane().add(labelsColumnas[1]);
		
		labelsColumnas[2] = new JLabel("9");
		labelsColumnas[2].setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelsColumnas[2].setBounds(240, 215, 9, 14);
		frame.getContentPane().add(labelsColumnas[2]);
		
		labelsColumnas[3] = new JLabel("6");
		labelsColumnas[3].setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelsColumnas[3].setBounds(287, 215, 9, 14);
		frame.getContentPane().add(labelsColumnas[3]);
		
		
		
		btnVerificar = new JButton("Verificar");
		btnVerificar.setBounds(310, 249, 89, 23);
		frame.getContentPane().add(btnVerificar);
		
		btnSuma = new JButton("Suma");
		btnSuma.setBounds(207, 249, 89, 23);
		frame.getContentPane().add(btnSuma);
		
		btnVerificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (validar(table)) {
					JOptionPane.showMessageDialog(null, "Todo ok"); //Aparece cuando estan todas las celdas
				} else {
					JOptionPane.showMessageDialog(null, "Hay celdas vacias");
				}
			}
		});
		
		btnSuma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean verif = true;
				for (int i = 0; i < table.getRowCount(); i++) {
					verif = filaSumaResultado(table, labelsFilas, i) && 
							columnaSumaResultado(table, labelsColumnas, i);
				}
				if (verif) {
					JOptionPane.showMessageDialog(null, "Correcto");
				} else {
					JOptionPane.showMessageDialog(null, "Incorrecto");
				}
			}
		});

		
	}
	/*
	 * Valida que la tabla no tenga celdas nulas (celdas no editadas)
	 * y celdas vacias luego de editarlas y borrar su valor.
	 */
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
	
	public boolean filaSumaResultado(JTable table,JLabel[] resultado,int fila) {
		Integer suma = 0;
	    int nroFil = table.getRowCount();
		for (int i = 0; i < nroFil; i++) {
            Object elem = table.getValueAt(fila, i);
            if (elem == null || elem.toString().isEmpty()) {
                return false;
            }
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
	
	public boolean columnaSumaResultado(JTable table,JLabel[] resultado,int columna) {
		Integer suma = 0;
	    int numCols = table.getColumnCount();
		for (int i = 0; i < numCols; i++) {
            Object elem = table.getValueAt(i, columna);
            if (elem == null || elem.toString().isEmpty()) {
                return false;
            }
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
	
	public Integer lblText(JLabel label) {
		Integer valor = Integer.parseInt(label.getText().toString());
		return valor;
	}
}
