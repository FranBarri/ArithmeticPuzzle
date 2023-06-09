package ventanas;

import javax.imageio.ImageIO;
import javax.swing.*;
import audio.Audio;
import controladores.VentanaAyudaControlador;
import controladores.VentanaMatrizControlador;
import sistema.Dificultad;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

@SuppressWarnings("serial")
public class VentanaMenu extends JFrame {

	private JLabel lblTitulo;
	private JLabel lblTitulo2;	
	private JButton btnFacil;
	private JButton btnMedio;
	private JButton btnDificil;
	private JButton btnAyuda;
	private JLabel lblNombres;
	private JLabel lblImagen;
	private File imagen;
	private Image icono;
	
	public VentanaMenu() {
		Audio.sonidoInicio();
		getContentPane().setBackground(new Color(163, 200, 211));
		setBounds(100, 100, 550, 490);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		//Cargar icono y titulo de ventana
		try {
			imagen = new File("imagenes\\icono.png");
			icono = ImageIO.read(imagen);
			setIconImage(icono);
		} catch (Exception e) {
			System.out.println("Error cargando imagen: " + e.getMessage());
		}
		setTitle("Puzzles Aritmeticos");
		setLocationRelativeTo(null); //Centra la ventana en pantalla
		setResizable(false);

		lblTitulo = new JLabel("Puzzles");
		lblTitulo.setForeground(new Color(255, 255, 255));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblTitulo.setBounds(0, 11, 532, 29);
		getContentPane().add(lblTitulo);

		lblTitulo2 = new JLabel("Aritm\u00E9ticos");
		lblTitulo2.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo2.setForeground(Color.WHITE);
		lblTitulo2.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblTitulo2.setBounds(0, 44, 532, 29);
		getContentPane().add(lblTitulo2);

		lblImagen = new JLabel("");
		lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
		lblImagen.setIcon(new ImageIcon("imagenes\\sudoku3.png"));
		lblImagen.setBounds(0, 84, 532, 130);
		getContentPane().add(lblImagen);

		btnFacil = new JButton("F\u00E1cil");
		btnFacil.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnFacil.setBounds(202, 259, 125, 29);
		getContentPane().add(btnFacil);

		btnMedio = new JButton("Medio");
		btnMedio.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnMedio.setBounds(202, 299, 125, 29);
		getContentPane().add(btnMedio);

		btnDificil = new JButton("Dif\u00EDcil");
		btnDificil.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnDificil.setBounds(202, 339, 125, 29);
		getContentPane().add(btnDificil);

		btnAyuda = new JButton("");
		btnAyuda.setIcon(new ImageIcon("imagenes\\pregunta1.png"));
		btnAyuda.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAyuda.setBounds(10, 398, 40, 40);
		getContentPane().add(btnAyuda);

		lblNombres = new JLabel("Barrientos - Psara - Gimenez");
		lblNombres.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombres.setBounds(346, 416, 178, 22);
		getContentPane().add(lblNombres);
		
		JLabel lblSelec = new JLabel("Seleccione una dificultad");
		lblSelec.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelec.setForeground(Color.WHITE);
		lblSelec.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSelec.setBounds(0, 219, 532, 29);
		getContentPane().add(lblSelec);

		btnFacil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Audio.sonidoClick();
				VentanaMatrizControlador.setDificultad(Dificultad.FACIL);
				dispose();
			}
		});
		
		btnMedio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Audio.sonidoClick();
				VentanaMatrizControlador.setDificultad(Dificultad.MEDIO);
				dispose();
			}
		});	
		
		btnDificil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Audio.sonidoClick();
				VentanaMatrizControlador.setDificultad(Dificultad.DIFICIL);
				dispose();
			}
		});	
		
		btnAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Audio.sonidoClick();
				VentanaAyudaControlador.mostrar();
				dispose();
			}
		});
	}
}
