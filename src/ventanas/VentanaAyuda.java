package ventanas;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import audio.Audio;
import controladores.VentanaMenuControlador;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class VentanaAyuda extends JFrame{
	private File imagen;
	private Image icono;
	private JTextArea textAreaTexto;
	private JLabel lblImagen;
	
	public void iniciar() {
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
		
		JLabel lblComoJugar = new JLabel("\u00BFC\u00F3mo Jugar?");
		lblComoJugar.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblComoJugar.setHorizontalAlignment(SwingConstants.CENTER);
		lblComoJugar.setForeground(new Color(255, 255, 255));
		lblComoJugar.setBounds(0, 0, 534, 78);
		getContentPane().add(lblComoJugar);
		
		lblImagen = new JLabel("");
		lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
		lblImagen.setIcon(new ImageIcon("imagenes\\ejemplo.png"));
		lblImagen.setBounds(0, 170, 532, 300);
		getContentPane().add(lblImagen);

		textAreaTexto = new JTextArea();
		textAreaTexto.setForeground(new Color(255, 255, 255));
		textAreaTexto.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textAreaTexto.setBackground(new Color(163, 200, 211));
		textAreaTexto.setText("Ten\u00E9s que adivinar qu\u00E9 n\u00FAmero poner en cada\r\ncelda de la grilla, de modo tal que la suma de\r\nlos n\u00FAmeros de cada fila sea igual al valor que\r\naparece al costado derecho de la misma, y\r\nque la suma de los n\u00FAmeros de cada columna\r\nsea igual al valor que est\u00E1 debajo de la grilla.\r\nEjemplo:");
		textAreaTexto.setEditable(false);
		textAreaTexto.setBounds(58, 71, 466, 258);
		getContentPane().add(textAreaTexto);
		
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnVolver.setBounds(10, 404, 125, 29);
		getContentPane().add(btnVolver);
		
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Audio.sonidoClick();
				VentanaMenuControlador.mostrar();
				dispose();
			}
		});
	}
}
