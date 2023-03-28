package controladores;

import javax.swing.UIManager;

public class Principal {
	
	public static void main(String args[]) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			VentanaMenuControlador.mostrar();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}