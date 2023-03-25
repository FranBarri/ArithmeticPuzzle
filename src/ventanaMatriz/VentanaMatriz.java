package ventanaMatriz;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.JButton;

public class VentanaMatriz {

	private JFrame frame;
	private JScrollPane scrollPane;
	private JTable table;
	private JLabel lblSumaFila1;
	private JLabel lblSumaFila2;
	private JLabel lblSumaFila3;
	private JLabel lblSumaFila4;
	private JLabel lblSumaCol1;
	private JLabel lblSumaCol2;
	private JLabel lblSumaCol3;
	private JLabel lblSumaCol4;
	private JButton btnVerificar;

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
		
		
	}

	private void inciarInterfaz() {
		JLabel lblMatriz = new JLabel("MATRIZ");
		lblMatriz.setHorizontalAlignment(SwingConstants.CENTER);
		lblMatriz.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblMatriz.setBounds(0, 0, 434, 32);
		frame.getContentPane().add(lblMatriz);
		
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
		
		//Estas son las sumas, el numero puede ser modificado manualmente con labelname.setText("nuevo valor").
		lblSumaFila1 = new JLabel("5");
		lblSumaFila1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSumaFila1.setBounds(325, 58, 9, 14);
		frame.getContentPane().add(lblSumaFila1);
		
		lblSumaFila2 = new JLabel("12");
		lblSumaFila2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSumaFila2.setBounds(325, 92, 18, 20);
		frame.getContentPane().add(lblSumaFila2);
		
		lblSumaFila3 = new JLabel("5");
		lblSumaFila3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSumaFila3.setBounds(325, 135, 9, 14);
		frame.getContentPane().add(lblSumaFila3);
		
		lblSumaFila4 = new JLabel("7");
		lblSumaFila4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSumaFila4.setBounds(325, 177, 9, 14);
		frame.getContentPane().add(lblSumaFila4);
		
		lblSumaCol1 = new JLabel("7");
		lblSumaCol1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSumaCol1.setBounds(147, 215, 9, 14);
		frame.getContentPane().add(lblSumaCol1);
		
		lblSumaCol2 = new JLabel("9");
		lblSumaCol2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSumaCol2.setBounds(190, 215, 9, 14);
		frame.getContentPane().add(lblSumaCol2);
		
		lblSumaCol3 = new JLabel("9");
		lblSumaCol3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSumaCol3.setBounds(240, 215, 9, 14);
		frame.getContentPane().add(lblSumaCol3);
		
		lblSumaCol4 = new JLabel("6");
		lblSumaCol4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSumaCol4.setBounds(287, 215, 9, 14);
		frame.getContentPane().add(lblSumaCol4);
		
		btnVerificar = new JButton("Verificar");
		btnVerificar.setBounds(310, 249, 89, 23);
		frame.getContentPane().add(btnVerificar);
		
		btnVerificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (validar(table)) {
					JOptionPane.showMessageDialog(null, "Todo ok"); //Aparece cuando estan todas las celdas
				} else {
					JOptionPane.showMessageDialog(null, "Hay celdas vacias");
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
	            Object value = table.getValueAt(i, j);
	            if (value == null || value.toString().isEmpty()) {
	                return false;
	            }
	        }
	    }
	    int numElements = table.getModel().getRowCount() * table.getModel().getColumnCount();
	    return nroFil > 0 && nroCol > 0 && nroFil * nroCol == numElements;
	}
	
}
