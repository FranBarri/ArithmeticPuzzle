package trabajoPractico1;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Random;

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
	private JButton btnMeRindo;
	private JLabel lblTiempo;
	private static final long serialVersionUID = 1L;
	private Date tiempoInicial;
	private Date tiempoActual;
	private boolean detenido;
	private int[][] grilla;
	Random rand = new Random();

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
		generarGrillaRandom();
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
		
		JLabel lblMatriz = new JLabel("MATRIZ");
		lblMatriz.setHorizontalAlignment(SwingConstants.CENTER);
		lblMatriz.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblMatriz.setBounds(0, 0, 434, 32);
		frame.getContentPane().add(lblMatriz);
		
		lblTiempo = new JLabel("0 segundos");
        lblTiempo.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblTiempo.setBounds(19, 236, 137, 40);
        frame.getContentPane().add(lblTiempo);
        
        tiempoInicial = new Date();
        tiempoActual = new Date();
        detenido = true;
        
		scrollPane = new JScrollPane();
		scrollPane.setBounds(127, 43, 188, 161);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setCellSelectionEnabled(true);
		table.setFont(new Font("Tahoma", Font.PLAIN, 16));
		table.setFillsViewportHeight(true);
		table.setModel(new DefaultTableModel(
			new Object[][] {
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
//		lblSumaFila1 = new JLabel("5");
		lblSumaFila1 = new JLabel("");
		lblSumaFila1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSumaFila1.setBounds(325, 58, 25, 25);
		lblSumaFila1.setText(Integer.toString(sumaFila(grilla,0)));
		frame.getContentPane().add(lblSumaFila1);
		
//		lblSumaFila2 = new JLabel("12");
		lblSumaFila2 = new JLabel("");
		lblSumaFila2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSumaFila2.setBounds(325, 92, 25, 25);
		lblSumaFila2.setText(Integer.toString(sumaFila(grilla,1)));
		frame.getContentPane().add(lblSumaFila2);
		
//		lblSumaFila3 = new JLabel("5");
		lblSumaFila3 = new JLabel("");
		lblSumaFila3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSumaFila3.setBounds(325, 135, 25, 25);
		lblSumaFila3.setText(Integer.toString(sumaFila(grilla,2)));
		frame.getContentPane().add(lblSumaFila3);
		
//		lblSumaFila4 = new JLabel("7");
		lblSumaFila4 = new JLabel("");
		lblSumaFila4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSumaFila4.setBounds(325, 177, 25, 25);
		lblSumaFila4.setText(Integer.toString(sumaFila(grilla,3)));
		frame.getContentPane().add(lblSumaFila4);
		
//		lblSumaCol1 = new JLabel("7");
		lblSumaCol1 = new JLabel("");
		lblSumaCol1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSumaCol1.setBounds(147, 215, 25, 25);
		lblSumaCol1.setText(Integer.toString(sumaColumna(grilla,0)));
		frame.getContentPane().add(lblSumaCol1);
		
//		lblSumaCol2 = new JLabel("9");
		lblSumaCol2 = new JLabel("");
		lblSumaCol2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSumaCol2.setBounds(190, 215, 25, 25);
		lblSumaCol2.setText(Integer.toString(sumaColumna(grilla,1)));
		frame.getContentPane().add(lblSumaCol2);
		
//		lblSumaCol3 = new JLabel("9");
		lblSumaCol3 = new JLabel("");
		lblSumaCol3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSumaCol3.setBounds(240, 215, 25, 25);
		lblSumaCol3.setText(Integer.toString(sumaColumna(grilla,2)));
		frame.getContentPane().add(lblSumaCol3);
		
//		lblSumaCol4 = new JLabel("6");
		lblSumaCol4 = new JLabel("");
		lblSumaCol4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSumaCol4.setBounds(287, 215, 25, 25);
		lblSumaCol4.setText(String.valueOf(sumaColumna(grilla,3)));
		frame.getContentPane().add(lblSumaCol4);
		
		btnVerificar = new JButton("Verificar");
		btnVerificar.setBounds(310, 249, 89, 23);
		frame.getContentPane().add(btnVerificar);
		
		btnMeRindo = new JButton("Me rindo!");
		btnMeRindo.setBounds(176, 249, 89, 23);
		frame.getContentPane().add(btnMeRindo);
		
		btnMeRindo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        table.setValueAt(grilla[i][j], i, j);
                    }
                }
            }
        });
		

		btnVerificar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tiempoActual = new Date();
                long tiempoTranscurrido = tiempoActual.getTime() - tiempoInicial.getTime();
                lblTiempo.setText(tiempoTranscurrido / 1000 + " segundos");
                detenido=false;
            }
        });
		
		 Thread t = new Thread(new Runnable() {
	            public void run() {
	                while (detenido) {
	                    tiempoActual = new Date();
	                    long tiempoTranscurrido = tiempoActual.getTime() - tiempoInicial.getTime();
	                    lblTiempo.setText(tiempoTranscurrido / 1000 + " segundos");
	                    try {
	                        Thread.sleep(1000);
	                    } catch (InterruptedException e) {
	                        e.printStackTrace();
	                    }
	                }
	            }
	        });
	        t.start();
	        
	    }
	public void generarGrillaRandom() {
		this.grilla = new int[4][4];
		for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                grilla[i][j] = rand.nextInt(9) + 1; // genera numeros random entre 1 y 9
            }
        }
	}
	public static int sumaFila(int[][] matriz, int fila) {
        int sum = 0;
        for (int j = 0; j < matriz[fila].length; j++) {
            sum += matriz[fila][j];
        }
        return sum;
    }
	 public static int sumaColumna(int[][] matriz, int col) {
	        int sum = 0;
	        for (int i = 0; i < matriz.length; i++) {
	            sum += matriz[i][col];
	        }
	        return sum;
	    }
		
	
	}
	

