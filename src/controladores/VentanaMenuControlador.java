package controladores;
import ventanas.VentanaMenu;
import sistema.Dificultad;

public class VentanaMenuControlador {
	
	public static VentanaMenu ventanaMenu = new VentanaMenu();
	
	//Eventos
	public static void cerrar() {
		ventanaMenu.setVisible(false);
	}
	
	public static void mostrar() {
		ventanaMenu.setVisible(true);
	}
	
	public void setDificultadMatriz(Dificultad dificultad) {
		cerrar();
		VentanaMatrizControlador.setDificultad(dificultad);
		
	}
	
}
